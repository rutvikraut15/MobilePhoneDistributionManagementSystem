package com.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.entity.WaitingList;

public interface WaitingListRepository extends JpaRepository<WaitingList, Long> {

}