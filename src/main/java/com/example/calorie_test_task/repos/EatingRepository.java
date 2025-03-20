package com.example.calorie_test_task.repos;

import com.example.calorie_test_task.tables.Eating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EatingRepository extends JpaRepository<Eating, Integer> {
}
