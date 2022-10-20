package com.routingtopology.value;

/**
 * This is energy performance
 *
 */
public class PerformanceLifeTimeRatio {
	
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
	
	

	public double getLifeTimeRatio() {
		return lifeTimeRatio;
	}

	public void setLifeTimeRatio(double lifeTimeRatio) {
		this.lifeTimeRatio = lifeTimeRatio;
	}



	private double lifeTimeRatio;
	
	

}
