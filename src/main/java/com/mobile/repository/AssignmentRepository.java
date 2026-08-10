package com.mobile.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.entity.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

	List<Assignment> findByExecutiveIdOrderByAssignedDateDesc(Long id);

	boolean existsByExecutiveIdAndAssignedDate(Long id, LocalDate now);

	

	
	
}