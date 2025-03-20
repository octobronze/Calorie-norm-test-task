package com.example.calorie_test_task.repos;

import com.example.calorie_test_task.tables.Eating;
import com.example.calorie_test_task.tables.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EatingRepository extends JpaRepository<Eating, Integer> {
    List<Eating> findAllByDateAndUserAndOrderByTimeAsc(User user, LocalDate date);
    List<Eating> findAllByUser(User user, Sort sort);
}
