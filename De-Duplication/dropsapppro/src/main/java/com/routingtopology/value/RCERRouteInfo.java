package com.routingtopology.value;

import java.util.List;

/**
 * 
 *
 */
public class RCERRouteInfo {
	
	private List<Integer> nodeIdsInRoute;

	/**
	 * @param nodeIdsInRoute
	 */
	public void setNodeIdsInRoute(List<Integer> nodeIdsInRoute) {
		this.nodeIdsInRoute = nodeIdsInRoute;
	}

	/**
	 * @return List of Nodes in the Route
	 */
	public List<Integer> getNodeIdsInRoute() {
		return nodeIdsInRoute;
	}
	
	/**
	 * @param totalPowerConsumed
	 */
	public void setTotalPowerConsumed(double totalPowerConsumed) {
		this.totalPowerConsumed = totalPowerConsumed;
	}

	/**
	 * @return Total Power Consumed
	 */
	public double getTotalPowerConsumed() {
		return totalPowerConsumed;
	}

	/**
	 * @param totalEnergyConsumed
	 */
	public void setTotalEnergyConsumed(double totalEnergyConsumed) {
		this.totalEnergyConsumed = totalEnergyConsumed;
	}

	/**
	 * @return Total Energy Consumed
	 */
	public double getTotalEnergyConsumed() {
		return totalEnergyConsumed;
	}

	/**
	 * @param noOfHops
	 */
	public void setNoOfHops(double noOfHops) {
		this.noOfHops = noOfHops;
	}

	/**
	 * @return Number of Hops
	 */
	public double getNoOfHops() {
		return noOfHops;
	}

	/**
	 * @param routeDiscoveryTime
	 */
	public void setRouteDiscoveryTime(double routeDiscoveryTime) {
		this.routeDiscoveryTime = routeDiscoveryTime;
	}

	/**
	 * @return Route Discovery Time
	 */
	public double getRouteDiscoveryTime() {
		return routeDiscoveryTime;
	}

	private double totalPowerConsumed;
	
	private double totalEnergyConsumed;
	
	private double noOfHops;
	
	private double routeDiscoveryTime;
	
	

}
