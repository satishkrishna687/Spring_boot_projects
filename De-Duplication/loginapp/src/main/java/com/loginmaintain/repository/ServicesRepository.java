package com.loginmaintain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginmaintain.storagemodels.ServicesModel;

@Repository
public interface ServicesRepository extends JpaRepository<ServicesModel, Long> {
	
	Page<ServicesModel> findByUserMaintainenceUserMaintainIdAppName(String appName,Pageable page);

}
