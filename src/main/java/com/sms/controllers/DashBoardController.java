package com.sms.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.sms.services.DashBoardService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/")
public class DashBoardController {
    @Autowired
    private DashBoardService dashBoardService;

    @GetMapping("dashboard")
    public Map<String, Object> getAllClassesData() {
        return dashBoardService.getClassesData();
    }

    @GetMapping("stats")
    public Map<String, String> getStats() {
        return dashBoardService.getStats();
    }

}
