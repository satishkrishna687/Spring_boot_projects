package com.dropsapppro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dropsapppro.storageobjects.AlgorithmicComparisonModel;




@Repository
public interface AlgorithmComparisonRepository extends JpaRepository<AlgorithmicComparisonModel, Long> {

}