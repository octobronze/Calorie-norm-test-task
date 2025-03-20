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

    @Column(name = "calorie_amount")
    private Double calorieAmount;

    @Column(name = "prtoeins_percent")
    private Double proteins_percent;

    @Column(name = "fats_percent")
    private Double fats_percent;

    @Column(name = "carbohydrates_percent")
    private Double carbohydratesPercent;
}
