package com.example.calorie_test_task.tables;

import jakarta.persistence.*;

@Table(name = "food_portion")
@Entity
public class FoodPortion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    @OneToMany
    private User user;
}
