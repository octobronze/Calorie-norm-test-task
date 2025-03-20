package com.example.calorie_test_task.enums;

import com.example.calorie_test_task.exceptions.BadRequestException;

public enum UserGoalEnum {
    WEIGHT_LOSS, MAINTENANCE, MASS_GAIN;

    public static UserGoalEnum getByIndex(int index) {
        if (index < 0 || index >= UserGoalEnum.values().length) {
            throw new BadRequestException("Goal index is incorrect");
        }

        return UserGoalEnum.values()[index];
    }
}
