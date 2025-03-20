package com.example.calorie_test_task.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class EatingRequestDto {
    @NotNull(message = "date cannot be null")
    private LocalDate date;
    @NotNull(message = "time cannot be null")
    private LocalTime time;
    @NotEmpty(message = "dishIds cannot be empty")
    private List<Integer> dishIds;

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public List<Integer> getDishIds() {
        return dishIds;
    }
}
