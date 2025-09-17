package com.sms.mapper;

import com.sms.dtos.StudentDto;
import com.sms.models.Student;

public class StudentMapper {
    public static StudentDto toDto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setStudentId(student.getStudentId());
        dto.setName(student.getName());
        dto.setContactDetails(student.getContactDetails());
        dto.setRollNumber(student.getRollNumber());
        dto.setClassId(student.getClassNumber().getClassId());
        dto.setSectionId(student.getSection()!=null?student.getSection().getSectionId():null);
        return dto;

    }
}
