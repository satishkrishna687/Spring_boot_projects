package com.dropsapppro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dropsapppro.storageobjects.CompareSizeAlgo;

@Repository
public interface CompareFileSizeRepository extends JpaRepository<CompareSizeAlgo,Long> {

	
	List<CompareSizeAlgo> findByOrderByOriginalFileBytesAsc();
}
