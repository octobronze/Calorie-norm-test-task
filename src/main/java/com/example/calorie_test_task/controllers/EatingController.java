package com.example.calorie_test_task.controllers;

import com.example.calorie_test_task.dtos.EatingRequestDto;
import com.example.calorie_test_task.services.EatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eating")
public class EatingController {
    private final EatingService eatingService;

    public EatingController(EatingService eatingService) {
        this.eatingService = eatingService;
    }
    @PostMapping
    public ResponseEntity<String> createEating(@RequestHeader(name = "userId") Integer userId,
                                               @RequestBody EatingRequestDto dto) {
        eatingService.createEating(userId, dto);

        return ResponseEntity.ok("ok");
    }
}
