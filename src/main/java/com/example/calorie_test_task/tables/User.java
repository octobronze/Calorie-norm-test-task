package com.example.calorie_test_task.tables;

import com.example.calorie_test_task.enums.UserGoalEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.math.BigDecimal;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "weight", nullable = false, precision = 8, scale = 2)
    private BigDecimal weight;

    @Column(name = "height", nullable = false, precision = 8, scale = 2)
    private BigDecimal height;

    @Column(name = "user_goal_id", nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    private UserGoalEnum userGoal;

    @Formula("88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * (age::numeric))")
    private BigDecimal calorieDayNorm;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public void setUserGoal(UserGoalEnum userGoal) {
        this.userGoal = userGoal;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public void setCalorieDayNorm(BigDecimal calorieDayNorm) {
        this.calorieDayNorm = calorieDayNorm;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getCalorieDayNorm() {
        return calorieDayNorm;
    }

    public UserGoalEnum getUserGoal() {
        return userGoal;
    }
}
