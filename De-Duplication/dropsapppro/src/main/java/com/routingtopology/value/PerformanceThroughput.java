package com.routingtopology.value;

/**
 * This is energy performance
 *
 */
public class PerformanceThroughput {

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

	public double getThroughput() {
		return throughput;
	}

	public void setThroughput(double throughput) {
		this.throughput = throughput;
	}

	private double throughput;

}
