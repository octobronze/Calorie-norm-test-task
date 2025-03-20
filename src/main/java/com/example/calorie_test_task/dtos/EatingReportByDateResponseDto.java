package com.example.calorie_test_task.dtos;

import java.time.LocalDate;

public class EatingReportByDateResponseDto extends EatingReportResponseDto {
    private LocalDate date;

    public EatingReportByDateResponseDto() {

    }

    public EatingReportByDateResponseDto(EatingReportResponseDto eatingReportResponseDto) {
        setEatingList(eatingReportResponseDto.getEatingList());
        setCalorieSum(eatingReportResponseDto.getCalorieSum());
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
