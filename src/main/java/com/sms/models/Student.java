package com.sms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "student_table")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
    private String name;
    private String contactDetails;
    private String rollNumber;
    @ManyToOne
    @JoinColumn(name = "class_number")
    private Class classNumber;
    @ManyToOne
    @JoinColumn(name = "section")
    private Section section;
}
