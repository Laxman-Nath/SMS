package com.sms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.models.Teacher;
import com.sms.services.TeacherService;

@RestController
@RequestMapping("/api/")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("teachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }
    
    @GetMapping("teachers/{id}")
    public Teacher findById(@PathVariable Integer id) throws Exception {
        return teacherService.getTeacherById(id);
    }
}
