package com.routingtopology.value;

/**
 * This is energy performance
 *
 */
public class PerformanceRoutingOverhead {
	
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
	
	public double getRoutingOverhead() {
		return routingOverhead;
	}

	public void setRoutingOverhead(double routingOverhead) {
		this.routingOverhead = routingOverhead;
	}

	private double routingOverhead;
	
	

}
