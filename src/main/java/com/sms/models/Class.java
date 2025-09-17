package com.sms.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "class_table")
@Data
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer classId;
    private String className;
    @OneToMany(mappedBy = "className")
    private List<ClassDetails> classDetails=new ArrayList<>();
    @OneToMany(mappedBy = "classNumber")
    private List<Student> students = new ArrayList<>();
}
