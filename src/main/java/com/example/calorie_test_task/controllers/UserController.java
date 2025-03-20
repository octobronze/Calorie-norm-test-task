package com.example.calorie_test_task.controllers;

import com.example.calorie_test_task.dtos.UserRequestDto;
import com.example.calorie_test_task.dtos.UserResponseDto;
import com.example.calorie_test_task.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequestDto dto) {
        userService.createUser(dto);

        return ResponseEntity.ok("ok");
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
