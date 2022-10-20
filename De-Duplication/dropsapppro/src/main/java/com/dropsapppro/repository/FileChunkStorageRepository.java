package com.dropsapppro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dropsapppro.storageobjects.FileChunckStorage;

@Repository
public interface FileChunkStorageRepository extends JpaRepository<FileChunckStorage,Long> {
	
	Page<FileChunckStorage>  findByUserName(String userName,Pageable pageable);

	long countByUserName(String userName);

}
