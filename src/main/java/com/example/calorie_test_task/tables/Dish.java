package com.example.calorie_test_task.tables;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Table(name = "dish")
@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "calories", nullable = false, precision = 8, scale = 2)
    private BigDecimal calories;

    @Column(name = "proteins_grams", precision = 8, scale = 2)
    private BigDecimal proteinsGrams;

    @Column(name = "fats_grams", precision = 8, scale = 2)
    private BigDecimal fatsGrams;

    @Column(name = "carbohydrates_grams", precision = 8, scale = 2)
    private BigDecimal carbohydratesGrams;

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(BigDecimal calories) {
        this.calories = calories;
    }

    public void setProteinsGrams(BigDecimal proteinsGrams) {
        this.proteinsGrams = proteinsGrams;
    }

    public void setFatsGrams(BigDecimal fatsGrams) {
        this.fatsGrams = fatsGrams;
    }

    public void setCarbohydratesGrams(BigDecimal carbohydratesGrams) {
        this.carbohydratesGrams = carbohydratesGrams;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getProteinsGrams() {
        return proteinsGrams;
    }

    public BigDecimal getFatsGrams() {
        return fatsGrams;
    }

    public BigDecimal getCarbohydratesGrams() {
        return carbohydratesGrams;
    }
}
