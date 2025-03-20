package com.example.calorie_test_task.dtos;

public class EatingSuccessReportResponseDto {
    private Double calorieSum;
    private Double goalCalorieSum;
    private Integer goalIndex;
    private Boolean isSuccess;

    public void setCalorieSum(Double calorieSum) {
        this.calorieSum = calorieSum;
    }

    public void setGoalCalorieSum(Double goalCalorieSum) {
        this.goalCalorieSum = goalCalorieSum;
    }

    public void setGoalIndex(Integer goalIndex) {
        this.goalIndex = goalIndex;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }
}
