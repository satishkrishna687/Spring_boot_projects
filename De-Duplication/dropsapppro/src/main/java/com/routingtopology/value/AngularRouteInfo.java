package com.routingtopology.value;

import java.util.List;
import java.util.Map;


public class AngularRouteInfo {
	
	
	private int noOfHops;
	

	private List<ErrorMsgObj> errorList;
	
	
	
	private List<RouteValue> routes;
	
	
	private List<Double> individualPc;
	
	
	private List<Integer> route;

	/**
	 * @param route
	 */
	public void setRoute(List<Integer> route) {
		this.route = route;
	}

	/**
	 * @return List of Nodes
	 */
	public List<Integer> getRoute() {
		return route;
	}
	
	private double energy;
	
	
	/**
	 * @return energy of the node
	 */
	public double getEnergy() {
		return energy;
	}

	/**
	 * @param energy
	 */
	public void setEnergy(double energy) {
		this.energy = energy;
	}

	/**
	 * @return Power Consumed of route
	 */
	public double getPowerConsumed() {
		return powerConsumed;
	}

	/**
	 * @param powerConsumed
	 */
	public void setPowerConsumed(double powerConsumed) {
		this.powerConsumed = powerConsumed;
	}

	/**
	 * @return Time Taken by the route
	 */
	public double getTimeTaken() {
		return timeTaken;
	}

	/**
	 * @param timeTaken
	 */
	public void setTimeTaken(double timeTaken) {
		this.timeTaken = timeTaken;
	}

	/**
	 * @param individualPc
	 */
	public void setIndividualPc(List<Double> individualPc) {
		this.individualPc = individualPc;
	}

	/**
	 * @return Power Consumed intermediatory
	 */
	public List<Double> getIndividualPc() {
		return individualPc;
	}

	/**
	 * @param routes
	 */
	public void setRoutes(List<RouteValue> routes) {
		this.routes = routes;
	}

	/**
	 * @return List of routes
	 */
	public List<RouteValue> getRoutes() {
		return routes;
	}

	/**
	 * @param errorList
	 */
	public void setErrorList(List<ErrorMsgObj> errorList) {
		this.errorList = errorList;
	}

	/**
	 * @return List of Error Objects
	 */
	public List<ErrorMsgObj> getErrorList() {
		return errorList;
	}

	/**
	 * @param nodesNotCloserToObs
	 */
	public void setNodesNotCloserToObs(List<Integer> nodesNotCloserToObs) {
		this.nodesNotCloserToObs = nodesNotCloserToObs;
	}

	/**
	 * @return Nodes not closer to obs site
	 */
	public List<Integer> getNodesNotCloserToObs() {
		return nodesNotCloserToObs;
	}

	/**
	 * @param mapNodeId_SS_ANGLE
	 */
	public void setMapNodeId_SS_ANGLE(Map<Double, Integer> mapNodeId_SS_ANGLE) {
		this.mapNodeId_SS_ANGLE = mapNodeId_SS_ANGLE;
	}

	/**
	 * @return Map of Signal Strength and Angle
	 */
	public Map<Double, Integer> getMapNodeId_SS_ANGLE() {
		return mapNodeId_SS_ANGLE;
	}

	private double powerConsumed;
	
	private double timeTaken;
	
	
	private List<Integer> nodesNotCloserToObs;
	
	
	private Map<Double, Integer> mapNodeId_SS_ANGLE;
	
	private Double angleAndSignalMax;
	
	/**
	 * @return best angle and signal
	 */
	public Double getAngleAndSignalMax() {
		return angleAndSignalMax;
	}

	/**
	 * @param angleAndSignalMax
	 */
	public void setAngleAndSignalMax(Double angleAndSignalMax) {
		this.angleAndSignalMax = angleAndSignalMax;
	}

	/**
	 * @return angular best node
	 */
	public int getAngularBestNodeId() {
		return angularBestNodeId;
	}

	/**
	 * @param angularBestNodeId
	 */
	public void setAngularBestNodeId(int angularBestNodeId) {
		this.angularBestNodeId = angularBestNodeId;
	}

	/**
	 * @return number of hops
	 */
	public int getNoOfHops() {
		return noOfHops;
	}

	/**
	 * @param noOfHops
	 */
	public void setNoOfHops(int noOfHops) {
		this.noOfHops = noOfHops;
	}

	private int angularBestNodeId;

}
