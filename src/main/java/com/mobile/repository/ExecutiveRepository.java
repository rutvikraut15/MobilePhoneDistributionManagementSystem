package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.entity.Executive;

public interface ExecutiveRepository extends JpaRepository<Executive, Long> {

    List<Executive> findByPresentStatus(String presentStatus);
    
    

}