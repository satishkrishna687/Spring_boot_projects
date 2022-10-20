package com.routingtopology.test;

import java.util.List;

/**
 * This is the class used for the generating 
 * the Square Model
 **/
public class SquareCriteriaModel {
	
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
	 * @return Energy of a node
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
	 * @return power of the node
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
	 * @return Buffer of the node
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
	 * @return network cost of the node
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
	 * @return trust level of the node
	 */
	public int getTrustLevel() {
		return trustLevel;
	}

	/**
	 * @param trustLevel
	 */
	public void setTrustLevel(int trustLevel) {
		this.trustLevel = trustLevel;
	}

	/**
	 * @param horizontalEndPoints
	 */
	public void setHorizontalEndPoints(List<Integer> horizontalEndPoints) {
		this.horizontalEndPoints = horizontalEndPoints;
	}

	/**
	 * @return number of horizontal end points
	 */
	public List<Integer> getHorizontalEndPoints() {
		return horizontalEndPoints;
	}

	/**
	 * @param verticalEndPoints
	 */
	public void setVerticalEndPoints(List<Integer> verticalEndPoints) {
		this.verticalEndPoints = verticalEndPoints;
	}

	/**
	 * @return number of vertical end points
	 */
	public List<Integer> getVerticalEndPoints() {
		return verticalEndPoints;
	}

	/**
	 * @param noOfNodesInEachZone
	 */
	public void setNoOfNodesInEachZone(List<Integer> noOfNodesInEachZone) {
		this.noOfNodesInEachZone = noOfNodesInEachZone;
	}

	/**
	 * @return number of nodes in each zone
	 */
	public List<Integer> getNoOfNodesInEachZone() {
		return noOfNodesInEachZone;
	}





	/**
	 * @param noOfZones
	 */
	public void setNoOfZones(int noOfZones) {
		this.noOfZones = noOfZones;
	}

	/**
	 * @return no of nodes
	 */
	public int getNoOfZones() {
		return noOfZones;
	}





	private double energy;
	
	private double power;
	
	private int buffer;
	
	private int networkCost;
	
	private int trustLevel;
	
	private List<Integer> horizontalEndPoints;
	
	private List<Integer> verticalEndPoints;
	
	private List<Integer> noOfNodesInEachZone;

	private int noOfZones;
	
	
	
	

}
