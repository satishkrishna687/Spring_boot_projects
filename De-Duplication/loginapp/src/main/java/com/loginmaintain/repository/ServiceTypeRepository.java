package com.loginmaintain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginmaintain.storagemodels.ServiceTypeModel;

public interface ServiceTypeRepository extends JpaRepository<ServiceTypeModel, Long> {

}
