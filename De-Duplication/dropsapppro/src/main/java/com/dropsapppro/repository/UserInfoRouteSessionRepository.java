package com.dropsapppro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dropsapppro.storageobjects.UserInfoRouteSession;

@Repository
public interface UserInfoRouteSessionRepository extends JpaRepository<UserInfoRouteSession, Long> {

	Page<UserInfoRouteSession> findByUsername(String userName, Pageable pageable);

	Long countByUsername(String userName);
}
