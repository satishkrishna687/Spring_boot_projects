package com.dropsapppro.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dropsapppro.storageobjects.FileEncStorage;
import com.dropsapppro.storageobjects.FileEncStorageLite;

@Repository
public interface FileEncStorageLiteRepository extends JpaRepository<FileEncStorageLite, Long> {
	
	
	Page<FileEncStorageLite> findByFilenameContaining(String filename, Pageable pageable);
	
	

}
