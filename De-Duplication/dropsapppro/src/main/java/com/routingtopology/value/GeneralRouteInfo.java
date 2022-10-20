package com.routingtopology.value;

import java.util.List;


public class GeneralRouteInfo {
	
	private double bestRoutePowerConsumed;
	
	private double bestRouteTimeTaken;
	
	private double bestRouteEc;
	
	
	
	private List<RouteInfo> nonEliminatedRoutes;

	private List<RouteInfo> routesEliminate;

	private List<ErrorMsgObj> errorList;

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
	 * @param routeInfoList
	 */
	public void setRouteInfoList(List<RouteInfo> routeInfoList) {
		this.routeInfoList = routeInfoList;
	}

	/**
	 * @return List of Route information
	 */
	public List<RouteInfo> getRouteInfoList() {
		return routeInfoList;
	}

	/**
	 * @param goodnessRatio
	 */
	public void setGoodnessRatio(List<Double> goodnessRatio) {
		this.goodnessRatio = goodnessRatio;
	}

	/**
	 * @return Goodness ratio
	 */
	public List<Double> getGoodnessRatio() {
		return goodnessRatio;
	}

	/**
	 * @param routesEliminate
	 */
	public void setRoutesEliminate(List<RouteInfo> routesEliminate) {
		this.routesEliminate = routesEliminate;
	}

	/**
	 * @return RouteInfo which gets eliminated
	 */
	public List<RouteInfo> getRoutesEliminate() {
		return routesEliminate;
	}

	/**
	 * @param isRouteEliminated
	 */
	public void setRouteEliminated(boolean isRouteEliminated) {
		this.isRouteEliminated = isRouteEliminated;
	}

	/**
	 * @return true if route is eliminated
	 */
	public boolean isRouteEliminated() {
		return isRouteEliminated;
	}

	/**
	 * @param nonEliminatedRoutes
	 */
	public void setNonEliminatedRoutes(List<RouteInfo> nonEliminatedRoutes) {
		this.nonEliminatedRoutes = nonEliminatedRoutes;
	}

	/**
	 * @return non eliminated routes
	 */
	public List<RouteInfo> getNonEliminatedRoutes() {
		return nonEliminatedRoutes;
	}

	/**
	 * @param bestRoute
	 */
	public void setBestRoute(RouteInfo bestRoute) {
		this.bestRoute = bestRoute;
	}

	/**
	 * @return best route information
	 */
	public RouteInfo getBestRoute() {
		return bestRoute;
	}

	/**
	 * @param bestRouteGoodnessRatio
	 */
	public void setBestRouteGoodnessRatio(double bestRouteGoodnessRatio) {
		this.bestRouteGoodnessRatio = bestRouteGoodnessRatio;
	}

	/**
	 * @return Goodness ratio of best route
	 */
	public double getBestRouteGoodnessRatio() {
		return bestRouteGoodnessRatio;
	}


	/**
	 * @param bestRouteEc
	 */
	public void setBestRouteEc(double bestRouteEc) {
		this.bestRouteEc = bestRouteEc;
	}

	/**
	 * @return Best route energy consumed
	 */
	public double getBestRouteEc() {
		return bestRouteEc;
	}

	/**
	 * @param bestRouteTimeTaken
	 */
	public void setBestRouteTimeTaken(double bestRouteTimeTaken) {
		this.bestRouteTimeTaken = bestRouteTimeTaken;
	}

	/**
	 * @return Best Route Time taken
	 */
	public double getBestRouteTimeTaken() {
		return bestRouteTimeTaken;
	}

	/**
	 * @param bestRoutePowerConsumed
	 */
	public void setBestRoutePowerConsumed(double bestRoutePowerConsumed) {
		this.bestRoutePowerConsumed = bestRoutePowerConsumed;
	}

	/**
	 * @return best route power consumed
	 */
	public double getBestRoutePowerConsumed() {
		return bestRoutePowerConsumed;
	}

	/**
	 * @param bestRouteNoOfHops
	 */
	public void setBestRouteNoOfHops(int bestRouteNoOfHops) {
		this.bestRouteNoOfHops = bestRouteNoOfHops;
	}

	/**
	 * @return number of hops
	 */
	public int getBestRouteNoOfHops() {
		return bestRouteNoOfHops;
	}

	private List<RouteInfo> routeInfoList;
	private List<Double> goodnessRatio;
	private boolean isRouteEliminated;
	
	private RouteInfo bestRoute;
	
	
	private double bestRouteGoodnessRatio;
	
	
	private int bestRouteNoOfHops;

		

}
