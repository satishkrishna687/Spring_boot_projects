package com.dropsapppro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dropsapppro.storageobjects.FileStorage;
import com.dropsapppro.storageobjects.FileStorageLite;

@Repository
public interface FileStorageLiteRepository extends JpaRepository<FileStorageLite, Long> {

	// Page<FileStorage> findByUserInfoRouteSessionUsername(String userName,
	// Pageable pageable);

	// long countByUserInfoRouteSessionUsername(String userName);

	Page<FileStorageLite> findByUserinforoutesession_username(Pageable pageable, String userName);

	long countByUserinforoutesession_username(String userName);

}
