package com.loginmaintain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginmaintain.storagemodels.ActivityModel;


@Repository
public interface ActivityRepository extends JpaRepository<ActivityModel, Long> {

}
