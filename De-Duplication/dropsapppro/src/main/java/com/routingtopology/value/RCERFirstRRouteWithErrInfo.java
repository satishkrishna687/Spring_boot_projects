package com.routingtopology.value;

import java.util.List;

/**
 * This is the Class Which is used for the computation of the RCER Algorithm
 * 
 */
public class RCERFirstRRouteWithErrInfo {
	
	
	private double relayNodeValue;
	
	

	private Integer clusterHead1;

	/**
	 * @return Cluster Head1 of the Node
	 */
	public Integer getClusterHead1() {
		return clusterHead1;
	}

	/**
	 * @param clusterHead1
	 */
	public void setClusterHead1(Integer clusterHead1) {
		this.clusterHead1 = clusterHead1;
	}

	/**
	 * @return Cluster Head 2 of the Node
	 */
	public Integer getClusterHead2() {
		return clusterHead2;
	}

	/**
	 * @param clusterHead2
	 */
	public void setClusterHead2(Integer clusterHead2) {
		this.clusterHead2 = clusterHead2;
	}

	/**
	 * @return Relay Node in the Route
	 */
	public Integer getRelayNode() {
		return relayNode;
	}

	/**
	 * @param relayNode
	 */
	public void setRelayNode(Integer relayNode) {
		this.relayNode = relayNode;
	}

	/**
	 * @return Back Up Node
	 */
	public Integer getBackUpNode() {
		return backUpNode;
	}

	/**
	 * @param backUpNode
	 */
	public void setBackUpNode(Integer backUpNode) {
		this.backUpNode = backUpNode;
	}

	private Integer clusterHead2;

	private Integer relayNode;

	private Integer backUpNode;

	private String errCode;

	/**
	 * @param errCode
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	/**
	 * @return Error Code
	 */
	public String getErrCode() {
		return errCode;
	}

	private String errMsg;

	/**
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	/**
	 * @return Error Message
	 */
	public String getErrMsg() {
		return errMsg;
	}

	private List<RCERRouteValue> routeInfo;

	/**
	 * @param routeInfo
	 */
	public void setRouteInfo(List<RCERRouteValue> routeInfo) {
		this.routeInfo = routeInfo;
	}

	/**
	 * @return List Information containing information about the route
	 */
	public List<RCERRouteValue> getRouteInfo() {
		return routeInfo;
	}

	/**
	 * @param relayNodeValue
	 */
	public void setRelayNodeValue(double relayNodeValue) {
		this.relayNodeValue = relayNodeValue;
	}

	/**
	 * @return Value of the Relay Node Function
	 */
	public double getRelayNodeValue() {
		return relayNodeValue;
	}

}
