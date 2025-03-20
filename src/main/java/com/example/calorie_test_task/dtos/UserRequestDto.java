package com.example.calorie_test_task.dtos;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UserRequestDto {
    @NotBlank(message = "User name cannot be empty")
    private String name;
    @NotBlank(message = "User email cannot be empty")
    private String email;
    @Min(value = 0, message = "Age cannot be less than 0")
    @Max(value = 200, message = "Age cannot be that big")
    private Integer age;
    @Min(value = 0, message = "Weight cannot be less than 0")
    @Max(value = 999, message = "Weight cannot be that big")
    private Double weight;
    @Min(value = 0, message = "Height cannot be less than 0")
    @DecimalMax(value = "300.1", message = "Height cannot be that big")
    private Double height;
    private Integer goalIndex;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getGoalIndex() {
        return goalIndex;
    }
}
