package com.dropsapppro.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.delegate.impl.RoutingCustomDelegateImpl;
import com.delegate.impl.RoutingDelegateImpl;
import com.dropsapppro.uiobjects.PaginationConfigVO;
import com.model.AJAXResponse;
import com.routingtopology.constants.TopologyConstantsIF;


public class BaseController {

	@Autowired
	protected RoutingDelegateImpl routingDelegate;

	@Autowired
	protected RoutingCustomDelegateImpl routingCustomDelegate;
	
	protected String getTopologyType() {
		return routingDelegate.retrivePropertyValueForPropertyName(TopologyConstantsIF.TOPOLOGY_TYPE);
	}
	
	protected Pageable createPageRequest(int start, int end) {
		return new PageRequest(start, end);
	}


}

