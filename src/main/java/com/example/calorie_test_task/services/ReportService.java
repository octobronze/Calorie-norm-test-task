package com.example.calorie_test_task.services;

import com.example.calorie_test_task.dtos.EatingReportByDateResponseDto;
import com.example.calorie_test_task.dtos.EatingReportResponseDto;
import com.example.calorie_test_task.dtos.EatingSuccessReportResponseDto;
import com.example.calorie_test_task.exceptions.BadRequestException;
import com.example.calorie_test_task.other.Utils;
import com.example.calorie_test_task.repos.EatingRepository;
import com.example.calorie_test_task.repos.UserRepository;
import com.example.calorie_test_task.tables.Eating;
import com.example.calorie_test_task.tables.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.calorie_test_task.consts.ExceptionConsts.USER_NOT_FOUND_EXCEPTION;

@Service
public class ReportService {
    private final EatingRepository eatingRepository;
    private final UserRepository userRepository;

    public ReportService(EatingRepository eatingRepository, UserRepository userRepository) {
        this.eatingRepository = eatingRepository;
        this.userRepository = userRepository;
    }

    public EatingReportResponseDto getEatingReportByDate(String email, LocalDate date) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new BadRequestException(USER_NOT_FOUND_EXCEPTION));
        List<Eating> eatingList = eatingRepository.findAllByDateAndUserAndOrderByTimeAsc(user, date);

        return getEatingReportByEatingList(eatingList);
    }

    public Page<EatingReportByDateResponseDto> getEatingReport(String email, Integer pageIndex, Integer pageSize) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new BadRequestException(USER_NOT_FOUND_EXCEPTION));
        List<Eating> eatingList = eatingRepository.findAllByUser(user,
                Sort.by("date").descending().and(Sort.by("time").ascending()));

        Map<LocalDate, List<Eating>> dateToEatingListMap = new HashMap<>();

        eatingList.forEach(eating -> {
            if (!dateToEatingListMap.containsKey(eating.getDate())) {
                dateToEatingListMap.put(eating.getDate(), new ArrayList<>());
            }
            dateToEatingListMap.get(eating.getDate()).add(eating);
        });

        List<EatingReportByDateResponseDto> responseDtoList = new ArrayList<>();

        dateToEatingListMap.entrySet().forEach((entry) -> {
            LocalDate date = entry.getKey();
            List<Eating> eatingListInner = entry.getValue();

            EatingReportByDateResponseDto responseDto = new EatingReportByDateResponseDto(getEatingReportByEatingList(eatingList));

            responseDto.setDate(date);

            responseDtoList.add(responseDto);
        });

        return Utils.getPageImpl(responseDtoList, pageIndex, pageSize);
    }

    public EatingSuccessReportResponseDto getEatingSuccessReportByDate(String email, LocalDate date) {

        EatingSuccessReportResponseDto responseDto = new EatingSuccessReportResponseDto();

        User user = userRepository.findByEmail(email).orElseThrow(() -> new BadRequestException(USER_NOT_FOUND_EXCEPTION));
        List<Eating> eatingList = eatingRepository.findAllByDateAndUserAndOrderByTimeAsc(user, date);

        EatingReportResponseDto eatingReportResponseDto = getEatingReportByEatingList(eatingList);

        responseDto.setCalorieSum(eatingReportResponseDto.getCalorieSum());
        responseDto.setGoalCalorieSum(user.getCalorieDayNorm());
        responseDto.setGoalIndex(user.getUserGoal().ordinal());

        switch (user.getUserGoal()) {
            case MASS_GAIN -> responseDto.setSuccess(eatingReportResponseDto.getCalorieSum() > user.getCalorieDayNorm());
            case MAINTENANCE -> responseDto.setSuccess(eatingReportResponseDto.getCalorieSum() == user.getCalorieDayNorm());
            case WEIGHT_LOSS -> responseDto.setSuccess(eatingReportResponseDto.getCalorieSum() < user.getCalorieDayNorm());
        }

        return responseDto;
    }

    private EatingReportResponseDto getEatingReportByEatingList(List<Eating> eatingList) {
        EatingReportResponseDto responseDto = new EatingReportResponseDto();

        List<EatingReportResponseDto.EatingResponseDto> eatingDtoList = new ArrayList<>();

        for(var eating : eatingList) {
            EatingReportResponseDto.EatingResponseDto eatingDto = new EatingReportResponseDto.EatingResponseDto();

            List<EatingReportResponseDto.EatingResponseDto.DishResponseDto> dishDtoList = new ArrayList<>();

            for (var dish : eating.getDishes()) {
                EatingReportResponseDto.EatingResponseDto.DishResponseDto dishDto = new EatingReportResponseDto.EatingResponseDto.DishResponseDto();

                dishDto.setId(dish.getId());
                dishDto.setName(dish.getName());
                dishDto.setCalories(dish.getCalories());

                dishDtoList.add(dishDto);
            }

            eatingDto.setId(eating.getId());
            eatingDto.setTime(eating.getTime());
            eatingDto.setDishList(dishDtoList);
            eatingDto.calculateAndSetCalorieSum();
        }

        responseDto.setEatingList(eatingDtoList);
        responseDto.calculateAndSetCalorieSum();

        return responseDto;
    }
}
