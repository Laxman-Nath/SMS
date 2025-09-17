package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.models.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
    
}
