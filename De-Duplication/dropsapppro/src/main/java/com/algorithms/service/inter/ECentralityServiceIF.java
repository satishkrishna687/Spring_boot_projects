package com.algorithms.service.inter;

import com.routingtopology.value.ClosenessCentralityCriteria;
import com.routingtopology.value.ECentralityCriteria;
import com.routingtopology.value.ECentralityRouteInfo;


public interface ECentralityServiceIF {

	/**
	 * @param findRoute
	 * @param topologyType
	 * @return AODVRouteInfo
	 */
	
	ECentralityRouteInfo findECentralityRoutes(ECentralityCriteria aodvCriteria, String topologyType);

	

	
}
