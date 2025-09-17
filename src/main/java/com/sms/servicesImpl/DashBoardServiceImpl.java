package com.sms.servicesImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.models.ClassDetails;
import com.sms.models.Subject;
import com.sms.repository.ClassDetailsRepository;
import com.sms.repository.ClassRepository;
import com.sms.repository.StudentRepository;
import com.sms.repository.TeacherRepository;
import com.sms.services.DashBoardService;

@Service
public class DashBoardServiceImpl implements DashBoardService {
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassDetailsRepository classDetailsRepository;

    @Override
    public Map<String, Object> getClassesData() {
        List<ClassDetails> classDetails = classDetailsRepository.findAll();
        Map<String, Object> result = new HashMap<>();
        for (ClassDetails c : classDetails) {
            Map<String, Object> classMap = new HashMap<>();
            classMap.put("class", c.getClassName());
            List<Map<String, String>> subjectsMap = classDetails.stream()
                    .map(s -> Map.of("subject", s.getSubject().getName(), "teacher", s.getTeacher().getName()))
                    .toList();
            classMap.put("subjects", subjectsMap);
            classMap.put("total_students", c.getClassName().getStudents().size());
            result.put(c.getClassName().getClassId().toString(), classMap);
        }
        return result;
    }

    @Override
    public Map<String, String> getStats() {
        Map<String, String> result = new HashMap<>();
 List<ClassDetails> classDetails = classDetailsRepository.findAll();
        result.put("total_teachers", String.valueOf(teacherRepository.count()));
        result.put("total_students", String.valueOf(studentRepository.count()));
        result.put("average_class_size", String.valueOf(studentRepository.count() / classRepository.count()));
        Map<Subject, Long> popularSubjects = classDetails.stream().
                collect(Collectors.groupingBy(s -> s.getSubject(), Collectors.counting()));
        Subject mostpopularSubject = Collections.max(
                popularSubjects.entrySet(),
                Map.Entry.comparingByValue()).getKey();
        result.put("popular_subject", mostpopularSubject.getName());
        return result;

    }

}
