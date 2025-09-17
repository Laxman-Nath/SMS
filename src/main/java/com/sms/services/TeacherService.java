package com.sms.services;

import java.util.List;

import com.sms.models.Teacher;

public interface TeacherService {
     List<Teacher> getAllTeachers();
    
     Teacher getTeacherById(Integer teacherId) throws Exception;
     
}
