package com.routingtopology.value;

public class PerformancePower {

	private int iterationNo;

	/**
	 * @return iteration no
	 */
	public int getIterationNo() {
		return iterationNo;
	}

	/**
	 * @param iterationNo
	 */
	public void setIterationNo(int iterationNo) {
		this.iterationNo = iterationNo;
	}

	/**
	 * @return power consumed
	 */
	public double getPowerConsumed() {
		return powerConsumed;
	}

	/**
	 * @param powerConsumed
	 */
	public void setPowerConsumed(double powerConsumed) {
		this.powerConsumed = powerConsumed;
	}

	private double powerConsumed;

}
