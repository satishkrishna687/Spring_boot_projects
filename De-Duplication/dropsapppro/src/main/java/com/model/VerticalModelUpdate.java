package com.model;

public class VerticalModelUpdate {

	private int verticalBelong;

	private double energy;

	private double power;

	private int buffer;

	private int networkCost;

	/**
	 * @param energy
	 */
	public void setEnergy(double energy) {
		this.energy = energy;
	}

	/**
	 * @return Energy of the node
	 */
	public double getEnergy() {
		return energy;
	}

	/**
	 * @param power
	 */
	public void setPower(double power) {
		this.power = power;
	}

	/**
	 * @return power of the node
	 */
	public double getPower() {
		return power;
	}

	/**
	 * @param buffer
	 */
	public void setBuffer(int buffer) {
		this.buffer = buffer;
	}

	/**
	 * @return buffer of the node
	 */
	public int getBuffer() {
		return buffer;
	}

	/**
	 * @param networkCost
	 */
	public void setNetworkCost(int networkCost) {
		this.networkCost = networkCost;
	}

	/**
	 * @return network cost
	 */
	public int getNetworkCost() {
		return networkCost;
	}

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
	 * @param x_cor
	 */
	public void setX_cor(int x_cor) {
		this.x_cor = x_cor;
	}

	/**
	 * @return x coordinate of the node
	 */
	public int getX_cor() {
		return x_cor;
	}

	/**
	 * @param y_cor
	 */
	public void setY_cor(int y_cor) {
		this.y_cor = y_cor;
	}

	/**
	 * @return y coordinate
	 */
	public int getY_cor() {
		return y_cor;
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

	/**
	 * @param verticalBelong
	 */
	public void setVerticalBelong(int verticalBelong) {
		this.verticalBelong = verticalBelong;
	}

	/**
	 * @return vertical belong
	 */
	public int getVerticalBelong() {
		return verticalBelong;
	}

	private int nodeId;

	private int x_cor;

	private int y_cor;

	private int trustLevel;
}
