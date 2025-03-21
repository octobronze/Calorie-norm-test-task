package com.example.calorie_test_task.dtos;

import java.math.BigDecimal;

public class EatingGoalReportResponseDto {
    private BigDecimal calorieSum;
    private BigDecimal goalCalorieSum;
    private Integer goalIndex;
    private Boolean isSuccess;

    public void setCalorieSum(BigDecimal calorieSum) {
        this.calorieSum = calorieSum;
    }

    public void setGoalCalorieSum(BigDecimal goalCalorieSum) {
        this.goalCalorieSum = goalCalorieSum;
    }

    public void setGoalIndex(Integer goalIndex) {
        this.goalIndex = goalIndex;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }
}
