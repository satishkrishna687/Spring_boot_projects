package com.routingtopology.value;

import java.util.List;
import java.util.Map;


public class ECentralityRouteInfo extends OptimizedRouteInfo {

	public String getDataPacket() {
		return dataPacket;
	}

	public void setDataPacket(String dataPacket) {
		this.dataPacket = dataPacket;
	}

	public Map<Double, Integer> getMapEcentrality() {
		return mapEcentrality;
	}

	public void setMapEcentrality(Map<Double, Integer> mapEcentrality) {
		this.mapEcentrality = mapEcentrality;
	}

	public double getDistanceEcentrality() {
		return distanceEcentrality;
	}

	public void setDistanceEcentrality(double distanceEcentrality) {
		this.distanceEcentrality = distanceEcentrality;
	}



	public List<Double> getBestECentralityDistanceList() {
		return bestECentralityDistanceList;
	}

	public void setBestECentralityDistanceList(List<Double> bestECentralityDistanceList) {
		this.bestECentralityDistanceList = bestECentralityDistanceList;
	}



	private String dataPacket;

	private Map<Double, Integer> mapEcentrality;
	private double distanceEcentrality;
	private List<Double> bestECentralityDistanceList;

}
