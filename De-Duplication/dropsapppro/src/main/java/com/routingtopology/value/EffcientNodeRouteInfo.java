package com.routingtopology.value;

import java.util.List;


public class EffcientNodeRouteInfo {
	
	
	private int noOfDeadNodes;

	private double energyConsumed;

	private double totalDistance;

	private int noOfPacketsLost;

	private List<DeadNodesInfo> deadNodes;

	private List<ErrorMsgObj> errorList;

	private RouteInfo routeInfo;
	
	private boolean status;
	
	private String exceptionInfo;
	
	private String exceptionDetails;
	

	/**
	 * @param errorList
	 */
	public void setErrorList(List<ErrorMsgObj> errorList) {
		this.errorList = errorList;
	}

	/**
	 * @return List of error msg obj
	 */
	public List<ErrorMsgObj> getErrorList() {
		return errorList;
	}

	/**
	 * @param deadNodes
	 */
	public void setDeadNodes(List<DeadNodesInfo> deadNodes) {
		this.deadNodes = deadNodes;
	}

	/**
	 * @return List of Nodes Which are Dead
	 */
	public List<DeadNodesInfo> getDeadNodes() {
		return deadNodes;
	}

	/**
	 * @param noOfPacketsLost
	 */
	public void setNoOfPacketsLost(int noOfPacketsLost) {
		this.noOfPacketsLost = noOfPacketsLost;
	}

	/**
	 * @return Number of Packets Lost
	 */
	public int getNoOfPacketsLost() {
		return noOfPacketsLost;
	}

	/**
	 * @param noOfHopsConsumed
	 */
	public void setNoOfHopsConsumed(int noOfHopsConsumed) {
		this.noOfHopsConsumed = noOfHopsConsumed;
	}

	/**
	 * @return Number of Hops
	 */
	public int getNoOfHopsConsumed() {
		return noOfHopsConsumed;
	}

	/**
	 * @param timeTaken
	 */
	public void setTimeTaken(double timeTaken) {
		this.timeTaken = timeTaken;
	}

	/**
	 * @return Time Taken for Discovering Routes
	 */
	public double getTimeTaken() {
		return timeTaken;
	}

	/**
	 * @param powerConsumed
	 */
	public void setPowerConsumed(double powerConsumed) {
		this.powerConsumed = powerConsumed;
	}

	/**
	 * @return Power Consumption across the route
	 */
	public double getPowerConsumed() {
		return powerConsumed;
	}

	/**
	 * @param noOfAliveNodes
	 */
	public void setNoOfAliveNodes(int noOfAliveNodes) {
		this.noOfAliveNodes = noOfAliveNodes;
	}

	/**
	 * @return Number of Nodes which are Alive
	 */
	public int getNoOfAliveNodes() {
		return noOfAliveNodes;
	}

	/**
	 * @param totalDistance
	 */
	public void setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
	}

	/**
	 * @return Total Distance Travelled
	 */
	public double getTotalDistance() {
		return totalDistance;
	}

	/**
	 * @param energyConsumed
	 */
	public void setEnergyConsumed(double energyConsumed) {
		this.energyConsumed = energyConsumed;
	}

	/**
	 * @return Energy Consumed on the Route
	 */
	public double getEnergyConsumed() {
		return energyConsumed;
	}

	/**
	 * @param routeInfo
	 */
	public void setRouteInfo(RouteInfo routeInfo) {
		this.routeInfo = routeInfo;
	}

	/**
	 * @return This object is the RouteInfo for the route element
	 */
	public RouteInfo getRouteInfo() {
		return routeInfo;
	}

	/**
	 * @param noOfDeadNodes
	 */
	public void setNoOfDeadNodes(int noOfDeadNodes) {
		this.noOfDeadNodes = noOfDeadNodes;
	}

	/**
	 * @return Number of Dead Nodes after the Iteration Routing
	 */
	public int getNoOfDeadNodes() {
		return noOfDeadNodes;
	}

	/**
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return true if everything is fine otherwise false
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param exceptionInfo
	 */
	public void setExceptionInfo(String exceptionInfo) {
		this.exceptionInfo = exceptionInfo;
	}

	/**
	 * @return Information about the exception that has occured
	 * 
	 */
	public String getExceptionInfo() {
		return exceptionInfo;
	}

	/**
	 * @param exceptionDetails
	 */
	public void setExceptionDetails(String exceptionDetails) {
		this.exceptionDetails = exceptionDetails;
	}

	/**
	 * @return Details of the Exception being created
	 */
	public String getExceptionDetails() {
		return exceptionDetails;
	}

	private int noOfHopsConsumed;

	private double timeTaken;

	private double powerConsumed;

	private int noOfAliveNodes;

}
