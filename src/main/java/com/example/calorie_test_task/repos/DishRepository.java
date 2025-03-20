package com.example.calorie_test_task.repos;

import com.example.calorie_test_task.tables.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Integer> {
}
