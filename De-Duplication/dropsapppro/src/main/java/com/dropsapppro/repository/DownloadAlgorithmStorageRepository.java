package com.dropsapppro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dropsapppro.model.DownloadAlgorithmicStorage;

@Repository
public interface DownloadAlgorithmStorageRepository extends JpaRepository<DownloadAlgorithmicStorage, Integer> {

	
	long countByAlgorithmicname(String optimized);

	List<DownloadAlgorithmicStorage> findByAlgorithmicnameOrderByOrginalFileBytesAsc(String optimized);

}
