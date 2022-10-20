package com.algorithms.service.inter;

import com.routingtopology.value.OptimizedCriteria;
import com.routingtopology.value.OptimizedRouteInfo;


public interface OptimizedServiceIF {

	/**
	 * @param findRoute
	 * @param topologyType
	 * @return EEDRRouteInfo
	 */
	OptimizedRouteInfo findOptimizedRoutes(OptimizedCriteria eedrCriteria, String topologyType);
}
