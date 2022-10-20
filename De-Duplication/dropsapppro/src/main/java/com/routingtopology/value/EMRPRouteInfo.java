package com.routingtopology.value;

import java.util.List;


public class EMRPRouteInfo {
	
	
	private TrustRoutes regularRoute;
	
	
	private double bestRouteEnergyConsumed;

	private double bestRoutePowerConsumed;
	
	private double bestRoundTripTime;

	/**
	 * @param bestRoutePowerConsumed
	 */
	public void setBestRoutePowerConsumed(double bestRoutePowerConsumed) {
		this.bestRoutePowerConsumed = bestRoutePowerConsumed;
	}

	/**
	 * @return Power Consumed of best route
	 */
	public double getBestRoutePowerConsumed() {
		return bestRoutePowerConsumed;
	}

	/**
	 * @param bestRouteEnergyConsumed
	 */
	public void setBestRouteEnergyConsumed(double bestRouteEnergyConsumed) {
		this.bestRouteEnergyConsumed = bestRouteEnergyConsumed;
	}

	/**
	 * @return Energy consumed of the best route
	 */
	public double getBestRouteEnergyConsumed() {
		return bestRouteEnergyConsumed;
	}

	private List<TrustRoutes> trustRoutes;

	/**
	 * @param trustRoutes
	 */
	public void setTrustRoutes(List<TrustRoutes> trustRoutes) {
		this.trustRoutes = trustRoutes;
	}

	/**
	 * @return List of trusted routes from src to destination
	 */
	public List<TrustRoutes> getTrustRoutes() {
		return trustRoutes;
	}

	/**
	 * @param bestRoute
	 */
	public void setBestRoute(TrustRoutes bestRoute) {
		this.bestRoute = bestRoute;
	}

	/**
	 * @return TrustRoutes object
	 */
	public TrustRoutes getBestRoute() {
		return bestRoute;
	}

	/**
	 * @param bestRouteTrustLevel
	 */
	public void setBestRouteTrustLevel(double bestRouteTrustLevel) {
		this.bestRouteTrustLevel = bestRouteTrustLevel;
	}

	/**
	 * @return trust level of the best route
	 */
	public double getBestRouteTrustLevel() {
		return bestRouteTrustLevel;
	}

	/**
	 * @param regularRoute
	 */
	public void setRegularRoute(TrustRoutes regularRoute) {
		this.regularRoute = regularRoute;
	}

	/**
	 * @return TrustRoutes
	 */
	public TrustRoutes getRegularRoute() {
		return regularRoute;
	}

	/**
	 * @param regularRouteTrustLevel
	 */
	public void setRegularRouteTrustLevel(double regularRouteTrustLevel) {
		this.regularRouteTrustLevel = regularRouteTrustLevel;
	}

	/**
	 * @return regular route trust level
	 */
	public double getRegularRouteTrustLevel() {
		return regularRouteTrustLevel;
	}

	/**
	 * @param regularRouteTimeTaken
	 */
	public void setRegularRouteTimeTaken(double regularRouteTimeTaken) {
		this.regularRouteTimeTaken = regularRouteTimeTaken;
	}

	/**
	 * @return regular route time taken
	 */
	public double getRegularRouteTimeTaken() {
		return regularRouteTimeTaken;
	}

	/**
	 * @param powerConsumedRegularRoute
	 */
	public void setPowerConsumedRegularRoute(double powerConsumedRegularRoute) {
		this.powerConsumedRegularRoute = powerConsumedRegularRoute;
	}

	/**
	 * @return Power Consumed of regular route
	 */
	public double getPowerConsumedRegularRoute() {
		return powerConsumedRegularRoute;
	}

	/**
	 * @param energyConsumedRegularRoute
	 */
	public void setEnergyConsumedRegularRoute(double energyConsumedRegularRoute) {
		this.energyConsumedRegularRoute = energyConsumedRegularRoute;
	}

	/**
	 * @return Energy consumed of regular
	 */
	public double getEnergyConsumedRegularRoute() {
		return energyConsumedRegularRoute;
	}

	/**
	 * @param bestRoundTripTime
	 */
	public void setBestRoundTripTime(double bestRoundTripTime) {
		this.bestRoundTripTime = bestRoundTripTime;
	}

	/**
	 * @return round trip time
	 */
	public double getBestRoundTripTime() {
		return bestRoundTripTime;
	}

	private TrustRoutes bestRoute;

	private double bestRouteTrustLevel;
	
	private double regularRouteTrustLevel;
	
	private double regularRouteTimeTaken;
	
	private double powerConsumedRegularRoute;
	
	private double energyConsumedRegularRoute;



}
