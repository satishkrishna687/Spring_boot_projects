package com.dropsapppro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dropsapppro.repository.UserInfoRouteSessionRepository;
import com.dropsapppro.storageobjects.UserInfoRouteSession;
import com.model.CompareOptimizedInfo;
import com.model.EEDRModel;
import com.model.StatusInfo;

@Service
public class FileStorageChunkReplicationService {
	
	
	@Autowired
	private UserInfoRouteSessionRepository userInfoRouteSessionRepository;
	

	public StatusInfo saveAndReplicateData(CompareOptimizedInfo compareOptimizedInfo,EEDRModel inputCriteria,UserInfoRouteSession userInfoRouteSession) {

		StatusInfo statusInfo = new StatusInfo();

		try {
			
			
			
			
			
			

		} catch (Exception e) {
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());
		}

		return statusInfo;
	}

}
