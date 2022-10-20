package com.dropsapppro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dropsapppro.storageobjects.FileChunckStorage;
import com.dropsapppro.storageobjects.FileReplicaStorage;

@Repository
public interface FileReplicaStorageRepository extends JpaRepository<FileReplicaStorage, Long> {

	Page<FileReplicaStorage> findByUserName(String userName, Pageable pageable);

	long countByUserName(String userName);

}
