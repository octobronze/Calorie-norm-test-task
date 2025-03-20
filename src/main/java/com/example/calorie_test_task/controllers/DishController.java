package com.example.calorie_test_task.controllers;

import com.example.calorie_test_task.dtos.DishRequestDto;
import com.example.calorie_test_task.services.DishService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/dish")
public class DishController {
    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping
    public ResponseEntity<String> createDish(@RequestBody DishRequestDto dto) {
        dishService.createDish(dto);

        return ResponseEntity.ok("ok");
    }
}
