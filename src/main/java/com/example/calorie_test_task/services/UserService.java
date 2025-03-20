package com.example.calorie_test_task.services;

import com.example.calorie_test_task.dtos.UserRequestDto;
import com.example.calorie_test_task.exceptions.BadRequestException;
import com.example.calorie_test_task.repos.UserRepository;
import com.example.calorie_test_task.tables.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserRequestDto dto) {
        userRepository.findByEmail(dto.getEmail()).orElseThrow(() -> new BadRequestException("User with this email already exists"));

    }
}
