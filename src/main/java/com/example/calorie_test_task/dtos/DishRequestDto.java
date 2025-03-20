package com.example.calorie_test_task.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class DishRequestDto {
    @NotBlank
    private String name;
    @Min(value = 0, message = "calories cannot be less than 0")
    private BigDecimal calories;
    @Min(value = 0, message = "proteinsGrams cannot be less than 0")
    private BigDecimal proteinsGrams;
    @Min(value = 0, message = "fatsGrams cannot be less than 0")
    private BigDecimal fatsGrams;
    @Min(value = 0, message = "carbohydratesGrams cannot be less than 0")
    private BigDecimal carbohydratesGrams;

    public String getName() {
        return name;
    }

    public BigDecimal getCalories() {
        return calories;
    }

    public BigDecimal getCarbohydratesGrams() {
        return carbohydratesGrams;
    }

    public BigDecimal getFatsGrams() {
        return fatsGrams;
    }

    public BigDecimal getProteinsGrams() {
        return proteinsGrams;
    }
}
