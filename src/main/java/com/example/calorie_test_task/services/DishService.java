package com.example.calorie_test_task.services;

import com.example.calorie_test_task.dtos.DishRequestDto;
import com.example.calorie_test_task.repos.DishRepository;
import com.example.calorie_test_task.tables.Dish;
import org.springframework.stereotype.Service;

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
}
