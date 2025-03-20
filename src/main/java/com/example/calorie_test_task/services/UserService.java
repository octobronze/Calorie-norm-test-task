package com.example.calorie_test_task.services;

import com.example.calorie_test_task.dtos.UserRequestDto;
import com.example.calorie_test_task.dtos.UserResponseDto;
import com.example.calorie_test_task.enums.UserGoalEnum;
import com.example.calorie_test_task.exceptions.BadRequestException;
import com.example.calorie_test_task.repos.UserRepository;
import com.example.calorie_test_task.tables.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserRequestDto dto) {
        userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new BadRequestException("User with this email already exists"));

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());
        user.setHeight(dto.getHeight());
        user.setWeight(dto.getWeight());
        user.setUserGoal(UserGoalEnum.getByIndex(dto.getGoalIndex()));

        userRepository.save(user);
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(user -> {
            UserResponseDto userResponseDto = new UserResponseDto();

            userResponseDto.setId(user.getId());
            userResponseDto.setName(user.getName());
            userResponseDto.setAge(user.getAge());
            userResponseDto.setEmail(user.getEmail());
            userResponseDto.setUserGoalIndex(user.getUserGoal().ordinal());
            userResponseDto.setCalorieDayNorm(user.getCalorieDayNorm());
            userResponseDto.setHeight(user.getHeight());
            userResponseDto.setWeight(user.getWeight());

            return userResponseDto;
        }).toList();
    }
}
