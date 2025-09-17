package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<com.sms.models.Student,Integer>{
    
}
