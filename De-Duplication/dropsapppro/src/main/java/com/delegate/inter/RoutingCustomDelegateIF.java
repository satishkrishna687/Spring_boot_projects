package com.delegate.inter;

import com.dropsapppro.storageobjects.UserInfoRouteSession;
import com.model.CompareOptimizedInfo;
import com.model.EEDRModel;

public interface RoutingCustomDelegateIF {
	
	public CompareOptimizedInfo findRoutesAndMeasureParameters(EEDRModel eedrModel, String topologyType,
			UserInfoRouteSession userInfoRouteSession);

}
