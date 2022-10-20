package com.routingtopology.value;

import java.util.List;
import java.util.Map;

public class ClosenessCentralityRouteInfo extends OptimizedRouteInfo {

	private double bestDistance;

	public double getBestDistance() {
		return bestDistance;
	}

	public void setBestDistance(double bestDistance) {
		this.bestDistance = bestDistance;
	}

	public String getDataPacket() {
		return dataPacket;
	}

	public void setDataPacket(String dataPacket) {
		this.dataPacket = dataPacket;
	}

	public Map<Double, Integer> getMapDistanceRouteBetweenCentrality() {
		return mapDistanceRouteBetweenCentrality;
	}

	public void setMapDistanceRouteBetweenCentrality(Map<Double, Integer> mapDistanceRouteBetweenCentrality) {
		this.mapDistanceRouteBetweenCentrality = mapDistanceRouteBetweenCentrality;
	}

	public List<Double> getDistanceClosenessCentrality() {
		return distanceClosenessCentrality;
	}

	public void setDistanceClosenessCentrality(List<Double> distanceClosenessCentrality) {
		this.distanceClosenessCentrality = distanceClosenessCentrality;
	}

	private String dataPacket;

	private Map<Double, Integer> mapDistanceRouteBetweenCentrality;

	private List<Double> distanceClosenessCentrality;
}
