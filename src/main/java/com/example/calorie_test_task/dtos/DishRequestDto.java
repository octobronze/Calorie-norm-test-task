package com.example.calorie_test_task.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class DishRequestDto {
    @NotBlank
    private String name;
    @Min(value = 0, message = "calories cannot be less than 0")
    private Double calories;
    @Min(value = 0, message = "proteinsGrams cannot be less than 0")
    private Double proteinsGrams;
    @Min(value = 0, message = "fatsGrams cannot be less than 0")
    private Double fatsGrams;
    @Min(value = 0, message = "carbohydratesGrams cannot be less than 0")
    private Double carbohydratesGrams;

    public String getName() {
        return name;
    }

    public Double getCalories() {
        return calories;
    }

    public Double getCarbohydratesGrams() {
        return carbohydratesGrams;
    }

    public Double getFatsGrams() {
        return fatsGrams;
    }

    public Double getProteinsGrams() {
        return proteinsGrams;
    }
}
