package com.routingtopology.value;

/**
 * This is the routing table 
 * format
 * */
public class NormalRoutingTable {

	private int nodeId;
	
	/**
	 * @return node id of routing table
	 */
	public int getNodeId() {
		return nodeId;
	}

	/**
	 * @param nodeId
	 */
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	/**
	 * @return distance between the nodes
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	private double distance;
	
}
