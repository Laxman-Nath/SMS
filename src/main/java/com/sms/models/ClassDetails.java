package com.sms.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

// This model is for tracking which teacher is teaching which subject in
// which class.Although this tracking can be done through  many to many
// relationship between teacher -> subject & teacher -> class. But this model makes
// mapping more clear and concise.
@Entity
@Table(name="class_details")
@Data
public class ClassDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name="class_id")
    private Class className;

}
