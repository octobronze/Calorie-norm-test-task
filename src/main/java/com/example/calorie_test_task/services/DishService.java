package com.example.calorie_test_task.services;

import com.example.calorie_test_task.dtos.DishRequestDto;
import com.example.calorie_test_task.dtos.DishResponseDto;
import com.example.calorie_test_task.repos.DishRepository;
import com.example.calorie_test_task.tables.Dish;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public void createDish(DishRequestDto dto) {
        Dish dish = new Dish();

        dish.setName(dto.getName());
        dish.setCalories(dto.getCalories());
        dish.setFatsGrams(dto.getFatsGrams());
        dish.setProteinsGrams(dto.getProteinsGrams());
        dish.setCarbohydratesGrams(dto.getCarbohydratesGrams());

        dishRepository.save(dish);
    }

    public List<DishResponseDto> getAllDishes() {
        return dishRepository.findAll().stream().map(dish -> {
            DishResponseDto dishResponseDto = new DishResponseDto();

            dishResponseDto.setId(dish.getId());
            dishResponseDto.setName(dish.getName());
            dishResponseDto.setCalories(dish.getCalories());
            dishResponseDto.setProteinsGrams(dish.getProteinsGrams());
            dishResponseDto.setCarbohydratesGrams(dish.getCarbohydratesGrams());
            dishResponseDto.setFatsGrams(dish.getFatsGrams());

            return dishResponseDto;
        }).toList();
    }
}
