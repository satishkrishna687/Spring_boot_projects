package com.dropsapppro.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.constants.EEDRServerMessages;
import com.delegate.impl.RoutingDelegateImpl;
import com.model.AJAXResponse;
import com.model.FaultNodeTopologyModel;
import com.model.FaultNodeTopologyView;
import com.model.Message;
import com.routingtopology.constants.TopologyConstantsIF;
import com.routingtopology.value.NodeParameters;
import com.routingtopology.value.TopologyCriteriaValue;

@RestController
public class DropsControlMechanismController {

	@Autowired
	private RoutingDelegateImpl routingDelegateImpl;

	@Autowired
	private MessageSource errorMessages;


}
