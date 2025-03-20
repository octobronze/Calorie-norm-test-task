package com.example.calorie_test_task.dtos;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class UserRequestDto {
    @NotBlank(message = "name cannot be empty")
    private String name;
    @NotBlank(message = "email cannot be empty")
    private String email;
    @Min(value = 0, message = "age cannot be less than 0")
    @Max(value = 200, message = "age cannot be that big")
    private Integer age;
    @Min(value = 0, message = "weight cannot be less than 0")
    @Max(value = 999, message = "weight cannot be that big")
    private BigDecimal weight;
    @Min(value = 0, message = "height cannot be less than 0")
    @DecimalMax(value = "300.1", message = "height cannot be that big")
    private BigDecimal height;
    private Integer goalIndex;

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public Integer getGoalIndex() {
        return goalIndex;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }
}
