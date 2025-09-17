package com.sms.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.models.Student;
import com.sms.models.Teacher;
import com.sms.repository.TeacherRepository;
import com.sms.services.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Integer teacherId) throws Exception {
        Teacher teacher = this.teacherRepository.findById(teacherId)
                .orElseThrow(() -> new Exception("Invalid id of teacher"));
        return teacher;
    }

}
