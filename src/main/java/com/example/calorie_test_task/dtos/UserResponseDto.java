package com.example.calorie_test_task.dtos;

import java.math.BigDecimal;

public class UserResponseDto {
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private BigDecimal weight;
    private BigDecimal height;
    private Integer userGoalIndex;
    private BigDecimal calorieDayNorm;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCalorieDayNorm(BigDecimal calorieDayNorm) {
        this.calorieDayNorm = calorieDayNorm;
    }

    public void setUserGoalIndex(Integer userGoalIndex) {
        this.userGoalIndex = userGoalIndex;
    }
}
