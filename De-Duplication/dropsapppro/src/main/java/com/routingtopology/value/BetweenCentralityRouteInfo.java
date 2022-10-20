package com.routingtopology.value;

import java.util.List;
import java.util.Map;


public class BetweenCentralityRouteInfo extends ClosenessCentralityRouteInfo {

	private double bestTimeTaken;

	public double getBestTimeTaken() {
		return bestTimeTaken;
	}

	public void setBestTimeTaken(double bestTimeTaken) {
		this.bestTimeTaken = bestTimeTaken;
	}

	public double getBestBetweenCentrality() {
		return bestBetweenCentrality;
	}

	public void setBestBetweenCentrality(double bestBetweenCentrality) {
		this.bestBetweenCentrality = bestBetweenCentrality;
	}

	public List<Double> getBestBetweenCentralityList() {
		return bestBetweenCentralityList;
	}

	public void setBestBetweenCentralityList(List<Double> bestBetweenCentralityList) {
		this.bestBetweenCentralityList = bestBetweenCentralityList;
	}

	public Map<Double, Integer> getMapBetweenessCentrality() {
		return mapBetweenessCentrality;
	}

	public void setMapBetweenessCentrality(Map<Double, Integer> mapBetweenessCentrality) {
		this.mapBetweenessCentrality = mapBetweenessCentrality;
	}

	private double bestBetweenCentrality = 0;

	private List<Double> bestBetweenCentralityList;

	private Map<Double, Integer> mapBetweenessCentrality;

}
