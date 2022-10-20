package com.model;

import java.util.List;

/**
 * This is the topology criteria
 * 
 */
public class FaultNodeTopologyModel {

	
	private int noOfNodes;

	/**
	 * @return number of nodes
	 */
	public int getNoOfNodes() {
		return noOfNodes;
	}

	/**
	 * @param noOfNodes
	 */
	public void setNoOfNodes(int noOfNodes) {
		this.noOfNodes = noOfNodes;
	}

	/**
	 * @return energy value of a node
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
	 * @return power of a node
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
	 * @return buffer of a node
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
	 * @return cost of network packet
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


	/**
	 * @param distanceBetweenNodes
	 */
	public void setDistanceBetweenNodes(int distanceBetweenNodes) {
		this.distanceBetweenNodes = distanceBetweenNodes;
	}

	/**
	 * @return distance between nodes
	 */
	public int getDistanceBetweenNodes() {
		return distanceBetweenNodes;
	}
	
	
	
	/**
	 * @param maxXCor
	 */
	public void setMaxXCor(int maxXCor) {
		this.maxXCor = maxXCor;
	}

	/**
	 * @return max x cordinate
	 */
	public int getMaxXCor() {
		return maxXCor;
	}
	
	private int minYCor;
	
	/**
	 * @param minXCor
	 */
	public void setMinXCor(int minXCor) {
		this.minXCor = minXCor;
	}

	/**
	 * @return minimum x cordinate
	 */
	public int getMinXCor() {
		return minXCor;
	}

	/**
	 * @param minYCor
	 */
	public void setMinYCor(int minYCor) {
		this.minYCor = minYCor;
	}

	/**
	 * @return minimum y cordinate
	 */
	public int getMinYCor() {
		return minYCor;
	}

	/**
	 * @param maxYCor
	 */
	public void setMaxYCor(int maxYCor) {
		this.maxYCor = maxYCor;
	}

	/**
	 * @return maximum y cordinate
	 */
	public int getMaxYCor() {
		return maxYCor;
	}

	private int minXCor;
	
	
	private int maxYCor;

	private int maxXCor;

	private int distanceBetweenNodes;
		
	private double energy;

	private double power;

	private int buffer;

	private int networkCost;

}
