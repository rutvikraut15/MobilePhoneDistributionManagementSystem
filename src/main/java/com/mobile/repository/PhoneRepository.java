package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    List<Phone> findByStatus(String status);

}