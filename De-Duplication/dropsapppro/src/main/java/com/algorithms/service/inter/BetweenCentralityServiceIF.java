package com.algorithms.service.inter;

import com.routingtopology.value.BetweenCentralityCriteria;
import com.routingtopology.value.BetweenCentralityRouteInfo;


public interface BetweenCentralityServiceIF {

	/**
	 * @param findRoute
	 * @param topologyType
	 * @return EEDRRouteInfo
	 */
	
	BetweenCentralityRouteInfo findBetweenCentralityRoutes(BetweenCentralityCriteria dsdvCriteria, String topologyType);

	

	
}
