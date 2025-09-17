package com.sms.dtos;

import lombok.Data;

@Data
public class StudentDto {
    private Integer studentId;
    private String name;
    private String contactDetails;
    private String rollNumber;
    private Integer classId;   
    private Integer sectionId; 
}
