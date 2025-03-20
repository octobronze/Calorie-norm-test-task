package com.example.calorie_test_task.services;

import com.example.calorie_test_task.dtos.EatingRequestDto;
import com.example.calorie_test_task.exceptions.BadRequestException;
import com.example.calorie_test_task.repos.DishRepository;
import com.example.calorie_test_task.repos.EatingRepository;
import com.example.calorie_test_task.repos.UserRepository;
import com.example.calorie_test_task.tables.Dish;
import com.example.calorie_test_task.tables.Eating;
import com.example.calorie_test_task.tables.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class EatingService {
    private final EatingRepository eatingRepository;
    private final UserRepository userRepository;
    private final DishRepository dishRepository;

    public EatingService(EatingRepository eatingRepository, UserRepository userRepository, DishRepository dishRepository) {
        this.eatingRepository = eatingRepository;
        this.userRepository = userRepository;
        this.dishRepository = dishRepository;
    }

    public void createEating(Integer userId, EatingRequestDto dto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new BadRequestException("User doesn't exist"));

        Eating eating = new Eating();

        eating.setDate(dto.getDate());
        eating.setTime(dto.getTime());
        eating.setUser(user);

        List<Dish> dishes = dishRepository.findAllById(dto.getDishIds());

        if (dishes.size() != dto.getDishIds().size()) {
            throw new BadRequestException("Some of dishes not exist");
        }

        eating.setDishes(new HashSet<>(dishes));

        eatingRepository.save(eating);
    }
}
