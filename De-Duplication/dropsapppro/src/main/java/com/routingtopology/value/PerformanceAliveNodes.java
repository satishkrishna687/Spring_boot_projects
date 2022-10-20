package com.routingtopology.value;

public class PerformanceAliveNodes {

	private int iterationNo;

	/**
	 * @param iterationNo
	 */
	public void setIterationNo(int iterationNo) {
		this.iterationNo = iterationNo;
	}

	/**
	 * @return Iteration NUmber
	 */
	public int getIterationNo() {
		return iterationNo;
	}

	private int noOfAliveNodes;

	/**
	 * @param noOfAliveNodes
	 */
	public void setNoOfAliveNodes(int noOfAliveNodes) {
		this.noOfAliveNodes = noOfAliveNodes;
	}

	/**
	 * @return Number of Alive Nodes in the Network
	 */
	public int getNoOfAliveNodes() {
		return noOfAliveNodes;
	}

}
