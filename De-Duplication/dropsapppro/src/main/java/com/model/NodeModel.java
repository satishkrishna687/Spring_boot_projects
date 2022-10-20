package com.model;

public class NodeModel {

	/**
	 * @return id of the node
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
	 * @return xcordinate
	 */
	public int getxCordinate() {
		return xCordinate;
	}

	/**
	 * @param xCordinate
	 */
	public void setxCordinate(int xCordinate) {
		this.xCordinate = xCordinate;
	}

	/**
	 * @return y cordinate of node
	 */
	public int getyCordinate() {
		return yCordinate;
	}

	/**
	 * @param yCordinate
	 */
	public void setyCordinate(int yCordinate) {
		this.yCordinate = yCordinate;
	}

	/**
	 * @return buffer of the node
	 */
	public int getBuffer() {
		return buffer;
	}

	/**
	 * @param buffer
	 */
	public void setBuffer(int buffer) {
		this.buffer = buffer;
	}

	/**
	 * @return cost of the network
	 */
	public int getNetworkCost() {
		return networkCost;
	}

	/**
	 * @param networkCost
	 */
	public void setNetworkCost(int networkCost) {
		this.networkCost = networkCost;
	}

	/**
	 * @return energy of the node
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
	 * @return power value
	 */
	public double getPower() {
		return power;
	}

	/**
	 * @param power
	 */
	public void setPower(double power) {
		this.power = power;
	}

	/**
	 * @param trustLevel
	 */
	public void setTrustLevel(int trustLevel) {
		this.trustLevel = trustLevel;
	}

	/**
	 * @return trust level of the node
	 */
	public int getTrustLevel() {
		return trustLevel;
	}

	private int nodeId;

	private int xCordinate;

	private int yCordinate;

	private int buffer;

	private int networkCost;

	private double energy;

	private double power;

	private int trustLevel;

	private int noOfXpos;

	/**
	 * @return number of x positions
	 */
	public int getNoOfXpos() {
		return noOfXpos;
	}

	/**
	 * @param noOfXpos
	 */
	public void setNoOfXpos(int noOfXpos) {
		this.noOfXpos = noOfXpos;
	}

	/**
	 * @return number of y positions
	 */
	public int getNoOfYpos() {
		return noOfYpos;
	}

	/**
	 * @param noOfYpos
	 */
	public void setNoOfYpos(int noOfYpos) {
		this.noOfYpos = noOfYpos;
	}

	private int noOfYpos;

}
