package com.model;

import java.io.Serializable;

public class NetworkCost implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double networkCost;
	public double getNetworkCost() {
		return networkCost;
	}
	public void setNetworkCost(double networkCost) {
		this.networkCost = networkCost;
	}

	
}
