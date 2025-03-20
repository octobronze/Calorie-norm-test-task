package com.example.calorie_test_task.dtos;

public class UserResponseDto {
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private Double weight;
    private Double height;
    private Integer userGoalIndex;
    private Double calorieDayNorm;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCalorieDayNorm(Double calorieDayNorm) {
        this.calorieDayNorm = calorieDayNorm;
    }

    public void setUserGoalIndex(Integer userGoalIndex) {
        this.userGoalIndex = userGoalIndex;
    }
}
