package com.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This is the class which is used 
 * to maintain the output of any
 * multichannel algorithms
 * 
 *
 */


public class RoutingVO {
	
	
	private Map<Long,String>   mapRoutesAndTime;
	
	private List<Long> timeDelaysForDiffrentRoutes; 
		
	private Map<Long,List<Integer>>   mapRoutesAndTimeDelay;
	
	private Map<Long,List<RouteValue>>   mapRoutesAndTimeDelayRouteVal;
	
	
	
	List<List<RouteValue>> multipleRoutesRouteVal;
	
	
	/**
	 * @return List<List<RouteValue>>
	 */
	public List<List<RouteValue>> getMultipleRoutesRouteVal() {
		return multipleRoutesRouteVal;
	}


	/**
	 * @param multipleRoutesRouteVal
	 */
	public void setMultipleRoutesRouteVal(
			List<List<RouteValue>> multipleRoutesRouteVal) {
		this.multipleRoutesRouteVal = multipleRoutesRouteVal;
	}


	
	
	private Map<Long,String> mapTimeAndRouteString;

	
	

	

	

	/**
	 * @param mapTimeAndRouteString
	 */
	public void setMapTimeAndRouteString(Map<Long,String> mapTimeAndRouteString) {
		this.mapTimeAndRouteString = mapTimeAndRouteString;
	}


	/**
	 * @return Map of time delay and route
	 */
	public Map<Long,String> getMapTimeAndRouteString() {
		return mapTimeAndRouteString;
	}


	/**
	 * @param timeDelaysForDiffrentRoutes
	 */
	public void setTimeDelaysForDiffrentRoutes(
			List<Long> timeDelaysForDiffrentRoutes) {
		this.timeDelaysForDiffrentRoutes = timeDelaysForDiffrentRoutes;
	}


	/**
	 * @return List of route trip time
	 */
	public List<Long> getTimeDelaysForDiffrentRoutes() {
		return timeDelaysForDiffrentRoutes;
	}


	/**
	 * @param mapRoutesAndTimeDelay
	 */
	public void setMapRoutesAndTimeDelay(Map<Long,List<Integer>> mapRoutesAndTimeDelay) {
		this.mapRoutesAndTimeDelay = mapRoutesAndTimeDelay;
	}


	/**
	 * @return Map of RTT and Route
	 */
	public Map<Long,List<Integer>> getMapRoutesAndTimeDelay() {
		return mapRoutesAndTimeDelay;
	}


	/**
	 * @param mapRoutesAndTime
	 */
	public void setMapRoutesAndTime(Map<Long,String> mapRoutesAndTime) {
		this.mapRoutesAndTime = mapRoutesAndTime;
	}


	/**
	 * @return map of time and route
	 */
	public Map<Long,String> getMapRoutesAndTime() {
		return mapRoutesAndTime;
	}


	/**
	 * @param mapRoutesAndTimeDelayRouteVal
	 */
	public void setMapRoutesAndTimeDelayRouteVal(
			Map<Long,List<RouteValue>> mapRoutesAndTimeDelayRouteVal) {
		this.mapRoutesAndTimeDelayRouteVal = mapRoutesAndTimeDelayRouteVal;
	}


	/**
	 * @return Mapof nodes  of RTT and List 
	 */
	public Map<Long,List<RouteValue>> getMapRoutesAndTimeDelayRouteVal() {
		return mapRoutesAndTimeDelayRouteVal;
	}


	
	
	
	
	
	
}
