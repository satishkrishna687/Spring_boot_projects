package com.algorithms.service.inter;

import com.routingtopology.value.ClosenessCentralityCriteria;
import com.routingtopology.value.ClosenessCentralityRouteInfo;


public interface ClosenessCentralityServiceIF {

	/**
	 * @param findRoute
	 * @param topologyType
	 * @return AODVRouteInfo
	 */
	
	ClosenessCentralityRouteInfo findClosenessCentralityRoutes(ClosenessCentralityCriteria aodvCriteria, String topologyType);

	

	
}
