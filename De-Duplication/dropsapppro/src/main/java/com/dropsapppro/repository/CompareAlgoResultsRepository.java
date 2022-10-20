package com.dropsapppro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dropsapppro.storageobjects.CompareAlgoResults;

@Repository
public interface CompareAlgoResultsRepository extends JpaRepository<CompareAlgoResults, Long> {

}
