package com.loginmaintain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginmaintain.storagemodels.SkillSetModel;


public interface SkillSetRepository extends JpaRepository<SkillSetModel, Long> {

}
