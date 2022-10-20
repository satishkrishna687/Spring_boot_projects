package com.model;

public class RouteValue {

	private int nodeId;

	/**
	 * @param nodeId
	 */
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	/**
	 * @return id of the node
	 */
	public int getNodeId() {
		return nodeId;
	}

	/**
	 * @param roundTripTime
	 */
	public void setRoundTripTime(int roundTripTime) {
		this.roundTripTime = roundTripTime;
	}

	/**
	 * @return round trip time
	 */
	public int getRoundTripTime() {
		return roundTripTime;
	}

	private int roundTripTime;

}
