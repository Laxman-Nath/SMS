package com.sms.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.dtos.StudentDto;
import com.sms.mapper.StudentMapper;
import com.sms.models.Section;
import com.sms.models.Student;
import com.sms.repository.ClassRepository;
import com.sms.repository.SectionRepository;
import com.sms.repository.StudentRepository;
import com.sms.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student -> StudentMapper.toDto(student)).toList();
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = new Student();
        com.sms.models.Class cls = classRepository.findById(studentDto.getClassId())
                .orElseThrow(() -> new RuntimeException("Class not found"));

        if (studentDto.getSectionId() != null) {

            Section sec = sectionRepository.findById(studentDto.getSectionId())
                    .orElseThrow(() -> new RuntimeException("Section not found"));
            student.setSection(sec);
        }

        student.setName(studentDto.getName());
        student.setContactDetails(studentDto.getContactDetails());
        student.setRollNumber(studentDto.getRollNumber());
        student.setClassNumber(cls);
        this.studentRepository.save(student);
        return StudentMapper.toDto(student);
    }

    public StudentDto updateStudent(StudentDto dto) {
        Student existing = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (dto.getName() != null)
            existing.setName(dto.getName());
        if (dto.getContactDetails() != null)
            existing.setContactDetails(dto.getContactDetails());
        if (dto.getRollNumber() != null)
            existing.setRollNumber(dto.getRollNumber());
        if (dto.getClassId() != null) {
            com.sms.models.Class cls = classRepository.findById(dto.getClassId())
                    .orElseThrow(() -> new RuntimeException("Class not found"));
            existing.setClassNumber(cls);
        }
        if (dto.getSectionId() != null) {
            Section sec = sectionRepository.findById(dto.getSectionId())
                    .orElseThrow(() -> new RuntimeException("Section not found"));
            existing.setSection(sec);
        }

        studentRepository.save(existing);
        return StudentMapper.toDto(existing);
    }

    @Override
    public String deleteStudent(Integer studentId) {
        Optional<Student> studentToUpdate = this.studentRepository.findById(studentId);
        if (!studentToUpdate.isPresent()) {
            throw new RuntimeException("Invalid id of student");
        }
        this.studentRepository.deleteById(studentId);
        return "Student is deleted Sucessfully";
    }

    @Override
    public StudentDto getStudentById(Integer studentId) {
        Student student = this.studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Invalid id of student"));
        return StudentMapper.toDto(student);
    }

    @Override
    public StudentDto updateStudentPartially(String contactDetails, Integer studentId) {
        Student studentToUpdate = this.studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Invalid id of student"));

        studentToUpdate.setContactDetails(contactDetails);
        this.studentRepository.save(studentToUpdate);
        return StudentMapper.toDto(studentToUpdate);
    }

}
