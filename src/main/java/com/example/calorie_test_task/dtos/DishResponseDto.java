package com.example.calorie_test_task.dtos;

import java.math.BigDecimal;

public class DishResponseDto {
    private Integer id;
    private String name;
    private BigDecimal calories;
    private BigDecimal proteinsGrams;
    private BigDecimal fatsGrams;
    private BigDecimal carbohydratesGrams;


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(BigDecimal calories) {
        this.calories = calories;
    }

    public void setCarbohydratesGrams(BigDecimal carbohydratesGrams) {
        this.carbohydratesGrams = carbohydratesGrams;
    }

    public void setFatsGrams(BigDecimal fatsGrams) {
        this.fatsGrams = fatsGrams;
    }

    public void setProteinsGrams(BigDecimal proteinsGrams) {
        this.proteinsGrams = proteinsGrams;
    }

    public BigDecimal getCalories() {
        return calories;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
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
