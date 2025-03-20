package com.example.calorie_test_task.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class DayReportResponseDto {
    public class EatingResponseDto {
        public class DishResponseDto {
            private Integer id;
            private String name;
            private Double calories;

            public void setId(Integer id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setCalories(Double calories) {
                this.calories = calories;
            }
        }

        private LocalDate date;
        private LocalTime time;
        private List<DishResponseDto> dishList;
        private Double calorieSum;

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public void setTime(LocalTime time) {
            this.time = time;
        }

        public void setDishList(List<DishResponseDto> dishList) {
            this.dishList = dishList;
        }

        public void calculateAndSetCalorieSum() {
            Double calorieSum = 0.0;

            for (var dish : dishList) {
                calorieSum += dish.calories;
            }

            this.calorieSum = calorieSum;
        }
    }

    private Double calorieSum;
    private List<EatingResponseDto> eatingList;

    public void setCalorieSum(Double calorieSum) {
        this.calorieSum = calorieSum;
    }

    public void setEatingList(List<EatingResponseDto> eatingList) {
        this.eatingList = eatingList;
    }

    public void calculateAndSetCalorieSum() {
        Double calorieSum = 0.0;

        for (var eating : eatingList) {
            calorieSum += eating.calorieSum;
        }

        this.calorieSum = calorieSum;
    }
}
