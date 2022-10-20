package com.model;

import java.io.Serializable;
import java.util.List;

public class EEDRTempComputationObj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<Integer> route;
	
	private double CQI;

	public List<Integer> getRoute() {
		return route;
	}

	public void setRoute(List<Integer> route) {
		this.route = route;
	}

	public double getCQI() {
		return CQI;
	}

	public void setCQI(double cQI) {
		CQI = cQI;
	}

}
