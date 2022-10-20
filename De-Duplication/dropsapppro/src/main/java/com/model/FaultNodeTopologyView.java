package com.model;

public class FaultNodeTopologyView {
	
	

	private int nodeId;

	/**
	 * @param nodeId
	 */
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	/**
	 * @return id  of the node
	 */
	public int getNodeId() {
		return nodeId;
	}
	
	/**
	 * @param xCordinate
	 */
	public void setxCordinate(int xCordinate) {
		this.xCordinate = xCordinate;
	}

	/**
	 * @return x cordinate of the node
	 */
	public int getxCordinate() {
		return xCordinate;
	}

	/**
	 * @param yCordinate
	 */
	public void setyCordinate(int yCordinate) {
		this.yCordinate = yCordinate;
	}

	/**
	 * @return y cordinate
	 */
	public int getyCordinate() {
		return yCordinate;
	}

	private int xCordinate;
		
	private int yCordinate;
	
	
	private int trustLevel;
	
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
	
	private double energy;

	/**
	 * @return Energy of the node
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
	
	private double powerConsumed;
	
	/**
	 * @return Power Consumed
	 */
	public double getPowerConsumed() {
		return powerConsumed;
	}

	/**
	 * @param powerConsumed
	 */
	public void setPowerConsumed(double powerConsumed) {
		this.powerConsumed = powerConsumed;
	}
	
	public double getNetworkCost() {
		return networkCost;
	}

	public void setNetworkCost(double networkCost) {
		this.networkCost = networkCost;
	}

	public double getBuffer() {
		return buffer;
	}

	public void setBuffer(double buffer) {
		this.buffer = buffer;
	}

	private double networkCost;
	
	private double buffer;
	
	

}
