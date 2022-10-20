package com.routingtopology.value;


public class PerformancePacketLoss {
	
	private int iterationNo;
	
	/**
	 * @param iterationNo
	 */
	public void setIterationNo(int iterationNo) {
		this.iterationNo = iterationNo;
	}

	/**
	 * @return Iteration Number 
	 */
	public int getIterationNo() {
		return iterationNo;
	}
	
	private int noOfPacketsLost;
	
	/**
	 * @param noOfPacketsLost
	 */
	public void setNoOfPacketsLost(int noOfPacketsLost) {
		this.noOfPacketsLost = noOfPacketsLost;
	}

	/**
	 * @return Number of Packets Lost
	 */
	public int getNoOfPacketsLost() {
		return noOfPacketsLost;
	}

	

}
