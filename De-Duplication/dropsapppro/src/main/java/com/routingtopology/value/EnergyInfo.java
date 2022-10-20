package com.routingtopology.value;

public class EnergyInfo {

	private int nodeId;

	private double energy;

	/**
	 * @param nodeId
	 */
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	/**
	 * @return node id
	 */
	public int getNodeId() {
		return nodeId;
	}

	/**
	 * @param energy
	 */
	public void setEnergy(double energy) {
		this.energy = energy;
	}

	/**
	 * @return energy of node
	 */
	public double getEnergy() {
		return energy;
	}

}
