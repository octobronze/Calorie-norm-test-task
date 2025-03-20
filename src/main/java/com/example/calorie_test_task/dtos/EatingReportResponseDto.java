package com.example.calorie_test_task.dtos;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

public class EatingReportResponseDto {
    private BigDecimal calorieSum;
    private List<EatingResponseDto> eatingList;


    public void setEatingList(List<EatingResponseDto> eatingList) {
        this.eatingList = eatingList;
    }

    protected void setCalorieSum(BigDecimal calorieSum) {
        this.calorieSum = calorieSum;
    }

    public void calculateAndSetCalorieSum() {
        BigDecimal calorieSum = BigDecimal.ZERO;

        for (var eating : eatingList) {
            calorieSum.add(eating.calorieSum);
        }

        this.calorieSum = calorieSum;
    }

    public BigDecimal getCalorieSum() {
        return calorieSum;
    }

    public List<EatingResponseDto> getEatingList() {
        return eatingList;
    }

    public static class EatingResponseDto {
        private Integer id;
        private LocalTime time;
        private List<DishResponseDto> dishList;
        private BigDecimal calorieSum;

        public void setId(Integer id) {
            this.id = id;
        }

        public void setTime(LocalTime time) {
            this.time = time;
        }

        public void setDishList(List<DishResponseDto> dishList) {
            this.dishList = dishList;
        }

        public void calculateAndSetCalorieSum() {
            BigDecimal calorieSum = BigDecimal.ZERO;

            for (var dish : dishList) {
                calorieSum.add(dish.calories);
            }

            this.calorieSum = calorieSum;
        }

        public static class DishResponseDto {
            private Integer id;
            private String name;
            private BigDecimal calories;

            public void setId(Integer id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setCalories(BigDecimal calories) {
                this.calories = calories;
            }
        }
    }
}
