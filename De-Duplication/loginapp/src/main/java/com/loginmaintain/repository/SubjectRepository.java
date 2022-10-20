package com.loginmaintain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginmaintain.storagemodels.ActivityModel;
import com.loginmaintain.storagemodels.SubjectsModel;


@Repository
public interface SubjectRepository extends JpaRepository<SubjectsModel, Long> {

}
