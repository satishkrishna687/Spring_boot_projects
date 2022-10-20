package com.routingtopology.value;

public class PerformanceTrust {

	private int iterationNo;

	/**
	 * @return iteration number
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
	 * @return trust level
	 */
	public double getTrustLevel() {
		return trustLevel;
	}

	/**
	 * @param trustLevel
	 */
	public void setTrustLevel(double trustLevel) {
		this.trustLevel = trustLevel;
	}

	private double trustLevel;

}
