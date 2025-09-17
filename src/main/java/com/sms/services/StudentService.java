package com.sms.services;

import java.util.List;

import com.sms.dtos.StudentDto;
import com.sms.models.Student;

public interface StudentService {
     List<StudentDto> getAllStudents();
     StudentDto createStudent(StudentDto student);
     StudentDto updateStudent(StudentDto student);
     String deleteStudent(Integer studentId) ;
     StudentDto getStudentById(Integer studentId) ;
     StudentDto updateStudentPartially(String contactDetails,Integer studentId);
}
