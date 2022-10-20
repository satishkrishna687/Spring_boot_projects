package com.loginmaintain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginmaintain.storagemodels.LicenseAppName;

@Repository
public interface LicenseAppNameRepository extends JpaRepository<LicenseAppName, String> {

}
