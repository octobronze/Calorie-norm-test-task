package com.example.calorie_test_task.tables;

import jakarta.persistence.*;

@Table(name = "dish")
@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "calories")
    private Double calories;

    @Column(name = "proteins_grams")
    private Double proteinsGrams;

    @Column(name = "fats_grams")
    private Double fatsGrams;

    @Column(name = "carbohydrates_grams")
    private Double carbohydratesGrams;

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public void setProteinsGrams(Double proteinsGrams) {
        this.proteinsGrams = proteinsGrams;
    }

    public void setFatsGrams(Double fatsGrams) {
        this.fatsGrams = fatsGrams;
    }

    public void setCarbohydratesGrams(Double carbohydratesGrams) {
        this.carbohydratesGrams = carbohydratesGrams;
    }
}
