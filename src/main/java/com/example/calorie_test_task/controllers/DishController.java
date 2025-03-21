package com.example.calorie_test_task.controllers;

import com.example.calorie_test_task.dtos.DishRequestDto;
import com.example.calorie_test_task.dtos.DishResponseDto;
import com.example.calorie_test_task.services.DishService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishController {
    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping
    public ResponseEntity<String> createDish(@Valid @RequestBody DishRequestDto dto) {
        dishService.createDish(dto);

        return ResponseEntity.ok("ok");
    }

    @GetMapping
    public ResponseEntity<List<DishResponseDto>> getAllDishes() {
        return ResponseEntity.ok(dishService.getAllDishes());
    }
}
