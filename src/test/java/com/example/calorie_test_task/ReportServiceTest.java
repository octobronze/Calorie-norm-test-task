package com.example.calorie_test_task;

import com.example.calorie_test_task.dtos.EatingGoalReportResponseDto;
import com.example.calorie_test_task.dtos.EatingReportByDateResponseDto;
import com.example.calorie_test_task.dtos.EatingReportResponseDto;
import com.example.calorie_test_task.enums.UserGoalEnum;
import com.example.calorie_test_task.repos.EatingRepository;
import com.example.calorie_test_task.repos.UserRepository;
import com.example.calorie_test_task.services.ReportService;
import com.example.calorie_test_task.tables.Dish;
import com.example.calorie_test_task.tables.Eating;
import com.example.calorie_test_task.tables.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Stream;

class ReportServiceTest {
	private final EatingRepository eatingRepository = Mockito.mock(EatingRepository.class);


	private final UserRepository userRepository = Mockito.mock(UserRepository.class);

	private final ReportService reportService = new ReportService(eatingRepository, userRepository);

	@Test
	public void test_getEatingReportByDate_shouldCalculateExpectedCalorieSum() {
		User user = createUser(null, null, null, null);
		LocalDate date = LocalDate.of(2021, 10, 10);
		List<Eating> eatingList = createEatingListByDate(user, date, List.of(
				List.of(BigDecimal.valueOf(1000.3244), BigDecimal.valueOf(1000.3245)),
				List.of(BigDecimal.valueOf(12345.9753), BigDecimal.valueOf(3239.23)),
				List.of(BigDecimal.valueOf(12345.91343), BigDecimal.valueOf(22.1))
		));

		BigDecimal expectedSum = calculateExpectedSum_getEatingReportByDate(eatingList);

		Mockito.when(userRepository.findByEmail("")).thenReturn(Optional.of(user));
		Mockito.when(eatingRepository.findAllByUserAndDateOrderByTimeAsc(user, date)).thenReturn(eatingList);

		EatingReportResponseDto responseDto = reportService.getEatingReportByDate("", date);

		Assertions.assertEquals(expectedSum, responseDto.getCalorieSum());
	}

	@Test
	public void test_getEatingReport_shouldCreateTwoElementsAndCalculateExpectedCalorieSum() {
		User user = createUser(null, null, null, null);
		LocalDate date1 = LocalDate.of(2021, 10, 10);
		LocalDate date2 = LocalDate.of(2022, 11, 20);
		List<Eating> eatingList1 = createEatingListByDate(user, date1, List.of(
				List.of(BigDecimal.valueOf(1000.3244), BigDecimal.valueOf(1000.3245)),
				List.of(BigDecimal.valueOf(12345.9753), BigDecimal.valueOf(3239.23)),
				List.of(BigDecimal.valueOf(12345.91343), BigDecimal.valueOf(22.1))
		));
		List<Eating> eatingList2 = createEatingListByDate(user, date2, List.of(
				List.of(BigDecimal.valueOf(1000.3245)),
				List.of(BigDecimal.valueOf(12345.9753), BigDecimal.valueOf(3239.23))
		));
		List<Eating> joinEatingList = new ArrayList<>() {
			{
				addAll(eatingList1);
				addAll(eatingList2);
			}
		};

		BigDecimal expectedSum1 = calculateExpectedSum_getEatingReportByDate(eatingList1);
		BigDecimal expectedSum2 = calculateExpectedSum_getEatingReportByDate(eatingList2);

		Mockito.when(userRepository.findByEmail("")).thenReturn(Optional.of(user));
		Mockito.when(eatingRepository.findAllByUser(user,
				Sort.by("date").descending().and(Sort.by("time").ascending()))).thenReturn(joinEatingList);

		Page<EatingReportByDateResponseDto> responseDto = reportService.getEatingReport("", 0, 2);
		Assertions.assertEquals(2, responseDto.getTotalElements());
		Assertions.assertEquals(expectedSum1, responseDto.get().toList().get(0).getCalorieSum());
		Assertions.assertEquals(expectedSum2, responseDto.get().toList().get(1).getCalorieSum());
	}


	@ParameterizedTest
	@MethodSource("provideUsersWithEveryGoal_for_getEatingSuccessReportByDate")
	public void test_getEatingGoalReportByDate_shouldReturnSuccessForEveryGoal(User user, LocalDate date, List<Eating> eatingList) {
		Mockito.when(userRepository.findByEmail("")).thenReturn(Optional.of(user));
		Mockito.when(eatingRepository.findAllByUserAndDateOrderByTimeAsc(user, date)).thenReturn(eatingList);

		EatingGoalReportResponseDto responseDto = reportService.getEatingGoalReportByDate("", date);
		Assertions.assertTrue(responseDto.getSuccess());
	}

	private static Stream<Arguments> provideUsersWithEveryGoal_for_getEatingSuccessReportByDate() {
		LocalDate date = LocalDate.of(2021, 10, 20);

		User userWeightLoss = createUser(30, BigDecimal.valueOf(100.32), BigDecimal.valueOf(200.45), UserGoalEnum.WEIGHT_LOSS);
		userWeightLoss.setCalorieDayNorm(calculateCalorieDayNorm(userWeightLoss));
		List<Eating> eatingListWeightLoss = createEatingListByDate(userWeightLoss, date, List.of(
				List.of(userWeightLoss.getCalorieDayNorm().subtract(BigDecimal.valueOf(1)))
		));

		User userMaintenance = createUser(50, BigDecimal.valueOf(70), BigDecimal.valueOf(180), UserGoalEnum.MAINTENANCE);
		userMaintenance.setCalorieDayNorm(calculateCalorieDayNorm(userMaintenance));
		List<Eating> eatingListMaintenance = createEatingListByDate(userWeightLoss, date, List.of(
				List.of(userMaintenance.getCalorieDayNorm())
		));

		User userMassGain = createUser(20, BigDecimal.valueOf(40), BigDecimal.valueOf(200), UserGoalEnum.MASS_GAIN);
		userMassGain.setCalorieDayNorm(calculateCalorieDayNorm(userMassGain));
		List<Eating> eatingListMassGain = createEatingListByDate(userWeightLoss, date, List.of(
				List.of(userWeightLoss.getCalorieDayNorm().add(BigDecimal.valueOf(1)))
		));

		return Stream.of(
				Arguments.of(userWeightLoss, date, eatingListWeightLoss),
				Arguments.of(userMaintenance, date, eatingListMaintenance),
				Arguments.of(userMassGain, date, eatingListMassGain)
		);
	}

	private static BigDecimal calculateCalorieDayNorm(User user) {
		return BigDecimal.valueOf(88.36)
				.add(BigDecimal.valueOf(13.4).multiply(user.getWeight()))
				.add(BigDecimal.valueOf(4.8).multiply(user.getHeight()))
				.subtract(BigDecimal.valueOf(5.7).multiply(BigDecimal.valueOf(user.getAge())));
	}

	private static List<Eating> createEatingListByDate(User user, LocalDate date, List<List<BigDecimal>> dishCalorieListForEatingList) {
		List<Eating> response = new ArrayList<>();

		for (List<BigDecimal> dishCalorieListForEating : dishCalorieListForEatingList) {
			List<Dish> dishList = new ArrayList<>();
			for(BigDecimal dishCalorie : dishCalorieListForEating) {
				Dish dish = createDish(dishCalorie);

				dishList.add(dish);
			}

			Eating eating = createEating(user, date, LocalTime.of(0, 0), new HashSet<>(dishList));

			response.add(eating);
		}

		return response;
	}

 	private static BigDecimal calculateExpectedSum_getEatingReportByDate(List<Eating> eatingList) {
		BigDecimal response = BigDecimal.ZERO;

		for (Eating eating : eatingList) {
			for (Dish dish : eating.getDishes()) {
				response = response.add(dish.getCalories());
			}
		}

		return response;
	}

	private static User createUser(Integer age, BigDecimal weight, BigDecimal height, UserGoalEnum userGoal) {
		User user = new User();

		user.setAge(age);
		user.setWeight(weight);
		user.setHeight(height);
		user.setUserGoal(userGoal);

		return user;
	}

	private static Eating createEating(User user, LocalDate date, LocalTime time, Set<Dish> dishes) {
		Eating eating = new Eating();

		eating.setUser(user);
		eating.setDate(date);
		eating.setTime(time);
		eating.setDishes(dishes);

		return eating;
	}

	private static Dish createDish(BigDecimal calories) {
		Dish dish = new Dish();

		dish.setCalories(calories);

		return dish;
	}
}
