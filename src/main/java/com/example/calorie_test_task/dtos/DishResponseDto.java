package com.example.calorie_test_task.dtos;

public class DishResponseDto {
    private Integer id;
    private String name;
    private Double calories;
    private Double proteinsGrams;
    private Double fatsGrams;
    private Double carbohydratesGrams;


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public void setCarbohydratesGrams(Double carbohydratesGrams) {
        this.carbohydratesGrams = carbohydratesGrams;
    }

    public void setFatsGrams(Double fatsGrams) {
        this.fatsGrams = fatsGrams;
    }

    public void setProteinsGrams(Double proteinsGrams) {
        this.proteinsGrams = proteinsGrams;
    }
}
