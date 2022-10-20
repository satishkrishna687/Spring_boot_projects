package com.controller.inter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dropsapppro.uiobjects.PaginationConfigVO;
import com.model.AJAXResponse;
import com.model.FaultGradeCriteria;
import com.model.FaultNodeTopologyModel;
import com.model.IPAdressVO;
import com.model.IPAdressVOFrontEnd;
import com.model.NodeIdObj;
import com.model.TypeObj;
import com.model.EEDRModel;
import com.routingtopology.value.EffcientNodeCriteria;
import com.routingtopology.value.EffcientNodeRouteInfo;
import com.routingtopology.value.SGRPRoutingCriteria;

/**
 * This is the controller for the PEEBR interface
 * 
 */
public interface RoutingControllerIF {

	/**
	 * @param request
	 * @return AJAXResponse having energy values
	 */
	public @ResponseBody AJAXResponse retriveComparisonEnergyValues(HttpServletRequest request);

	/**
	 * @param request
	 * @return AJAXResponse having Number of Hops
	 */
	public @ResponseBody AJAXResponse retriveComparisonNoOfHopsValues(HttpServletRequest request);

	/**
	 * @param request
	 * @return AJAXResponse having time values
	 */
	public @ResponseBody AJAXResponse retriveComparisonTimeValues(HttpServletRequest request);

	/**
	 * @param request
	 * @param peerbrTopologyModel
	 * @return Topology sucess or failure
	 */
	public @ResponseBody AJAXResponse generateTopology(HttpServletRequest request,
			@RequestBody FaultNodeTopologyModel peerbrTopologyModel);

	/**
	 * @param request
	 * @return This is the topology
	 */
	public @ResponseBody AJAXResponse viewTopology(HttpServletRequest request);

	/**
	 * @param request
	 * @param nodeId
	 * @return AJAXResponse sucess or failure
	 */
	public @ResponseBody AJAXResponse ViewRoutingTable(HttpServletRequest request, @RequestParam Integer nodeId);

	/**
	 * @param request
	 * @return ModelAndView show sucessful message or failure message
	 */
	public ModelAndView insertRoutingTables(HttpServletRequest request);

	/**
	 * @param request
	 * @return AJAXResponse show node ids in the combo
	 */
	public @ResponseBody AJAXResponse retriveNodeIds(HttpServletRequest request);

	/**
	 * @param request
	 * @param nodeId
	 * @return AJAXResponse sucess or failure
	 */
	public @ResponseBody AJAXResponse viewPower(HttpServletRequest request, @RequestParam Integer nodeId);

	/**
	 * @param request
	 * @param nodeId
	 * @return AJAXResponse sucess or failure
	 */
	public @ResponseBody AJAXResponse viewEnergyTablesForEEDR(HttpServletRequest request, @RequestParam Integer nodeId);

	/**
	 * @param request
	 * @return true if sucessful routing table
	 */
	public @ResponseBody AJAXResponse retriveEnergyAlgo1(HttpServletRequest request);

	/**
	 * @param request
	 * @return true if sucessful routing table
	 */
	public @ResponseBody AJAXResponse retriveEnergyAlgo2(HttpServletRequest request);

	/**
	 * @param request
	 * @return true if sucessful routing table
	 */
	public @ResponseBody AJAXResponse retrivePowerAlgo1(HttpServletRequest request);

	/**
	 * @param request
	 * @return true if sucessful routing table
	 */
	public @ResponseBody AJAXResponse retrivePowerAlgo2(HttpServletRequest request);

	/**
	 * @param request
	 * @return true if sucessful routing table
	 */
	public @ResponseBody AJAXResponse retriveTimeAlgo1(HttpServletRequest request);

	/**
	 * @param request
	 * @return true if sucessful routing table
	 */
	public @ResponseBody AJAXResponse retriveTimeAlgo2(HttpServletRequest request);

	/**
	 * @param request
	 * @return AJAXResponse
	 */
	public AJAXResponse retriveComparisonPowerValues(HttpServletRequest request);

	/**
	 * @param request
	 * @return Number of Hops for Algorithm1
	 */
	public @ResponseBody AJAXResponse retriveNoOfHopsAlgo1(HttpServletRequest request);

	/**
	 * @param request
	 * @return Number of Hops for Algorithm2
	 */
	public @ResponseBody AJAXResponse retriveNoOfHopsAlgo2(HttpServletRequest request);

	
	/**
	 * @param request
	 * @return AJAXResponse having Number of Dead Nodes
	 */
	public @ResponseBody AJAXResponse retriveComparisonNoOfDeadNodes(HttpServletRequest request);

	/**
	 * @param request
	 * @return AJAXResponse having Number of Alive Nodes
	 */
	public @ResponseBody AJAXResponse retriveComparisonNoOfAliveNodes(HttpServletRequest request);

	AJAXResponse retriveNoOfDeadNodesAlgo1(HttpServletRequest request);

	AJAXResponse retriveNoOfDeadNodesAlgo2(HttpServletRequest request);

	AJAXResponse retriveNoOfAliveNodesAlgo1(HttpServletRequest request);

	AJAXResponse retriveNoOfAliveNodesAlgo2(HttpServletRequest request);

	/**
	 * @param request
	 * @param nodeId
	 * @return AJAXResponse sucess or failure
	 */
	public @ResponseBody AJAXResponse viewEnergyTablesForDSDV(HttpServletRequest request, @RequestParam Integer nodeId);

	ModelAndView performSettings(HttpServletRequest request, String topologyType);

	AJAXResponse retriveComparisonResidualEnergy(HttpServletRequest request);

	AJAXResponse retriveComparisonLifeTimeRatio(HttpServletRequest request);

	AJAXResponse retriveCompareRoutingOverhead(HttpServletRequest request);

	AJAXResponse retriveCompareThroughput(HttpServletRequest request);

	AJAXResponse viewIPAddressList(HttpServletRequest request);

	AJAXResponse storeIpAddress(HttpServletRequest request, IPAdressVOFrontEnd ipAdressVO);

	AJAXResponse removeIpAddress(HttpServletRequest request, NodeIdObj ipAdressVO);

	AJAXResponse removePerformance(HttpServletRequest request, TypeObj typeObj);

	ModelAndView cleanUpData(HttpServletRequest request, String type);

	AJAXResponse viewEnergyTablesForECentric(HttpServletRequest request, Integer nodeId);

	AJAXResponse retriveChunksForCustomer(HttpServletRequest request, PaginationConfigVO paginationConfigVO);

	AJAXResponse retriveReplicaChunksForCustomer(HttpServletRequest request, PaginationConfigVO paginationConfigVO);

	
	AJAXResponse retriveAllChunks(HttpServletRequest request, PaginationConfigVO paginationConfigVO);
	
	AJAXResponse retriveAllReplicas(HttpServletRequest request, PaginationConfigVO paginationConfigVO);

	AJAXResponse retriveUserRouteForCustomer(HttpServletRequest request, PaginationConfigVO paginationConfigVO);

	AJAXResponse retriveRouteHistoryForAll(HttpServletRequest request, PaginationConfigVO paginationConfigVO);

	AJAXResponse retriveSecurityCompare(HttpServletRequest request, PaginationConfigVO paginationConfigVO);

	AJAXResponse retriveSecurityCompareAll(HttpServletRequest request);

	AJAXResponse retriveCustomerSpecificFiles(HttpServletRequest request, PaginationConfigVO paginationConfigVO);

	AJAXResponse retriveEncAllFiles(HttpServletRequest request, PaginationConfigVO paginationConfigVO);

	AJAXResponse retriveAllSpecificFiles(HttpServletRequest request, PaginationConfigVO paginationConfigVO);

	
	AJAXResponse compareFileCompareData(HttpServletRequest request, PaginationConfigVO paginationConfigVO);

	AJAXResponse fileSizeDataGraph(HttpServletRequest request);

	
	AJAXResponse retriveDownloadComputation(HttpServletRequest request, PaginationConfigVO paginationConfigVO);

	AJAXResponse retriveDownloadComputationForOptimized(HttpServletRequest request);

	AJAXResponse retriveDownloadComputationForClosenessCentrality(HttpServletRequest request);

	AJAXResponse retriveDownloadComputationForBetweenCentrality(HttpServletRequest request);

	AJAXResponse retriveDownloadComputationForECentrality(HttpServletRequest request);
	

}
