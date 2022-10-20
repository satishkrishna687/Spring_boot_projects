package com.model;

import java.io.Serializable;

public class PerformanceResidualEnergy implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int iterationNo;
	
	private double residualEnergy;

	public int getIterationNo() {
		return iterationNo;
	}

	public void setIterationNo(int iterationNo) {
		this.iterationNo = iterationNo;
	}

	public double getResidualEnergy() {
		return residualEnergy;
	}

	public void setResidualEnergy(double residualEnergy) {
		this.residualEnergy = residualEnergy;
	}

}
