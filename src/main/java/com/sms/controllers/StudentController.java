package com.sms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import com.sms.dtos.StudentDto;
import com.sms.models.Student;
import com.sms.services.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("students")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PreAuthorize("hasRole('teacher')")
    @PostMapping("students")
    public StudentDto addStudent(@RequestBody StudentDto student) {
        return studentService.createStudent(student);
    }

    @PreAuthorize("hasRole('teacher')")
    @PutMapping("students")
    public StudentDto udpateStudent(@RequestBody StudentDto student) throws Exception {
        return studentService.updateStudent(student);
    }

    @PreAuthorize("hasRole('teacher')")
    @DeleteMapping("students/{id}")
    public String deleteStudent(@PathVariable Integer id) throws Exception {
        return studentService.deleteStudent(id);
    }

    @GetMapping("students/{id}")
    public StudentDto findById(@PathVariable Integer id) throws Exception {
        return studentService.getStudentById(id);
    }

    @PreAuthorize("hasRole('teacher')")
    @PatchMapping("students/{id}")
    public StudentDto udpateStudentPartially(@RequestBody String contactDetails, @PathVariable Integer id)
            throws Exception {
        return studentService.updateStudentPartially(contactDetails, id);
    }

}
