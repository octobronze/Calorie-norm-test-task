package com.example.calorie_test_task.tables;

import jakarta.persistence.*;

@Table(name = "dish_to_food_portion")
public class DishToFoodPortion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dish_id")
    private Dish dish;

    @Column(name = "food_portion_id")
    private FoodPortion foodPortion;
}
