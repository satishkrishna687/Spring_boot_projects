package com.dropsapppro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dropsapppro.storageobjects.FileEncStorage;
import com.dropsapppro.storageobjects.FileEncStorageDownload;

@Repository
public interface FileEncStorageDownloadRepository extends JpaRepository<FileEncStorageDownload, Long> {

	Optional<FileEncStorageDownload> findByFilestorageid(Long fileIdLong);

}
