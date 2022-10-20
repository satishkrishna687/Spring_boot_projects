package com.routingtopology.value;

public class DeadNodesInfo {

	private int nodeId;

	/**
	 * @return Node ID which is Dead
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
	 * @return Battery Power of the Dead Node
	 */
	public double getBatteryPower() {
		return batteryPower;
	}

	/**
	 * @param batteryPower
	 */
	public void setBatteryPower(double batteryPower) {
		this.batteryPower = batteryPower;
	}

	private double batteryPower;

}
