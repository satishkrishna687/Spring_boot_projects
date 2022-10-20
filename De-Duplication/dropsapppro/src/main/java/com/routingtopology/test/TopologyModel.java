package com.routingtopology.test;

/**
 * This is the topology criteria
 *
 */
public class TopologyModel {
	
	
	private int noOfXpos;
	
	private int noOfYpos;
	
	
	//This is distance between the nodes
	private int distanceBetweenNodes;

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
	 * @return minimum x area
	 */
	public int getMinXArea() {
		return minXArea;
	}

	/**
	 * @param minXArea
	 */
	public void setMinXArea(int minXArea) {
		this.minXArea = minXArea;
	}

	/**
	 * @return maximum x area
	 */
	public int getMaxXArea() {
		return maxXArea;
	}

	/**
	 * @param maxXArea
	 */
	public void setMaxXArea(int maxXArea) {
		this.maxXArea = maxXArea;
	}

	/**
	 * @return minimum value of y area
	 */
	public int getMinYArea() {
		return minYArea;
	}

	/**
	 * @param minYArea
	 */
	public void setMinYArea(int minYArea) {
		this.minYArea = minYArea;
	}

	/**
	 * @return maximum value of x area
	 */
	public int getMaxYArea() {
		return maxYArea;
	}

	/**
	 * @param maxYArea
	 */
	public void setMaxYArea(int maxYArea) {
		this.maxYArea = maxYArea;
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
	 * @param noOfXpos
	 */
	public void setNoOfXpos(int noOfXpos) {
		this.noOfXpos = noOfXpos;
	}

	/**
	 * @return number of x positions
	 */
	public int getNoOfXpos() {
		return noOfXpos;
	}

	/**
	 * @param noOfYpos
	 */
	public void setNoOfYpos(int noOfYpos) {
		this.noOfYpos = noOfYpos;
	}

	/**
	 * @return number of y positions
	 */
	public int getNoOfYpos() {
		return noOfYpos;
	}

	private int minXArea;
	
	private int maxXArea;
	
	private int minYArea;
	
	private int maxYArea;
	
	private double energy;
	
	private double power;
	
	private int buffer;
	
	private int networkCost;
	
}
