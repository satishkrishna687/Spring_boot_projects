package com.routingtopology.value;

import java.util.List;

/**
 * This is the class which is used to hold the trusted routes
 **/
public class TrustRoutes {
	
	
	private CorpInfo corpInfo;
	

	private List<RouteValue> routes;
	
	private double powerConsumed;
	
	private double energyConsumed;

	/**
	 * @param routes
	 */
	public void setRoutes(List<RouteValue> routes) {
		this.routes = routes;
	}

	/**
	 * @return List of nodes in the route
	 */
	public List<RouteValue> getRoutes() {
		return routes;
	}

	/**
	 * @param routeDiscoveryTime
	 */
	public void setRouteDiscoveryTime(double routeDiscoveryTime) {
		
		routeDiscoveryTime=(double)(routeDiscoveryTime/Math.pow(10, 3));
		this.routeDiscoveryTime = routeDiscoveryTime;
	}

	/**
	 * @return route discovery time
	 */
	public double getRouteDiscoveryTime() {
		return routeDiscoveryTime;
	}

	/**
	 * @param trustLevelofRoute
	 */
	public void setTrustLevelofRoute(double trustLevelofRoute) {
		this.trustLevelofRoute = trustLevelofRoute;
	}

	/**
	 * @return trust level of the route
	 */
	public double getTrustLevelofRoute() {
		return trustLevelofRoute;
	}

	/**
	 * @param powerConsumed
	 */
	public void setPowerConsumed(double powerConsumed) {
		this.powerConsumed = powerConsumed;
	}

	/**
	 * @return power consumed on the route
	 */
	public double getPowerConsumed() {
		return powerConsumed;
	}

	/**
	 * @param energyConsumed
	 */
	public void setEnergyConsumed(double energyConsumed) {
		this.energyConsumed = energyConsumed;
	}

	/**
	 * @return energy consumed
	 */
	public double getEnergyConsumed() {
		return energyConsumed;
	}

	
	/**
	 * @param corpInfo
	 */
	public void setCorpInfo(CorpInfo corpInfo) {
		this.corpInfo = corpInfo;
	}

	/**
	 * @return Corporative Node Information
	 */
	public CorpInfo getCorpInfo() {
		return corpInfo;
	}


	private double routeDiscoveryTime;

	private double trustLevelofRoute;
	
	
	

}
