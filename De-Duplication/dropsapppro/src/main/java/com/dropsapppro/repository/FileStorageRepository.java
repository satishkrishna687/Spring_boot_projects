package com.dropsapppro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dropsapppro.storageobjects.FileStorage;

@Repository
public interface FileStorageRepository extends JpaRepository<FileStorage, Long> {

	
	
//	Page<FileStorage> findByUserInfoRouteSessionUsername(String userName, Pageable pageable);

	//long countByUserInfoRouteSessionUsername(String userName);

}
