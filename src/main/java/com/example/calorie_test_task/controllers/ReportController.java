package com.example.calorie_test_task.controllers;

import com.example.calorie_test_task.dtos.EatingReportByDateResponseDto;
import com.example.calorie_test_task.dtos.EatingReportResponseDto;
import com.example.calorie_test_task.dtos.EatingSuccessReportResponseDto;
import com.example.calorie_test_task.services.ReportService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/report")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/eating/{date}")
    public ResponseEntity<EatingReportResponseDto> getEatingReportByDate(@RequestHeader(name = "email") String email,
                                                                         @PathVariable(name = "date") LocalDate date) {
        return ResponseEntity.ok(reportService.getEatingReportByDate(email, date));
    }

    @GetMapping("/eating/success/{date}")
    public ResponseEntity<EatingSuccessReportResponseDto> getEatingSuccessReportByDate(@RequestHeader(name = "email") String email,
                                                                                       @PathVariable(name = "date") LocalDate date) {
        return ResponseEntity.ok(reportService.getEatingSuccessReportByDate(email, date));
    }

    @GetMapping("/eating")
    public ResponseEntity<Page<EatingReportByDateResponseDto>> getEatingReportByDate(@RequestHeader(name = "email") String email,
                                                                                     @RequestParam(name = "pageIndex") Integer pageIndex,
                                                                                     @RequestParam(name = "pageSize") Integer pageSize) {
        return ResponseEntity.ok(reportService.getEatingReport(email, pageIndex, pageSize));
    }
}
