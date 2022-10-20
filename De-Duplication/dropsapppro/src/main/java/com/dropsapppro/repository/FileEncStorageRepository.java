package com.dropsapppro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dropsapppro.storageobjects.FileEncStorage;

@Repository
public interface FileEncStorageRepository extends JpaRepository<FileEncStorage, Long> {

	Optional<FileEncStorage> findByFilestorageid(Long fileIdLong);

}
