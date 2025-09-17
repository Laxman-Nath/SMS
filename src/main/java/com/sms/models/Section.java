package com.sms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "section_table")
@Data
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sectionId;
    private String name;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class classNumber;
}
