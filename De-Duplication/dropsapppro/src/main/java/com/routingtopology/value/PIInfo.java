package com.routingtopology.value;

public class PIInfo {

	private int nodeId;

	/**
	 * @return NodeID
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
	 * @return energy of node
	 */
	public double getEnergy() {
		return energy;
	}

	/**
	 * @param energy
	 */
	public void setEnergy(double energy) {
		this.energy = energy;
	}

	/**
	 * @return pi value of node
	 */
	public double getPi() {
		return pi;
	}

	/**
	 * @param pi
	 */
	public void setPi(double pi) {
		this.pi = pi;
	}

	/**
	 * @return zone id
	 */
	public int getZoneId() {
		return zoneId;
	}

	/**
	 * @param zoneId
	 */
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	/**
	 * @return trust
	 */
	public int getTrust() {
		return trust;
	}

	/**
	 * @param trust
	 */
	public void setTrust(int trust) {
		this.trust = trust;
	}

	private double energy;

	private double pi;

	private int trust;

	private int zoneId;

}
