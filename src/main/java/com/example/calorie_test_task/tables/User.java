package com.example.calorie_test_task.tables;

import com.example.calorie_test_task.enums.UserGoalEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "height")
    private Double height;

    @Column(name = "user_goal_id")
    @Enumerated(value = EnumType.ORDINAL)
    private UserGoalEnum userGoal;
}
