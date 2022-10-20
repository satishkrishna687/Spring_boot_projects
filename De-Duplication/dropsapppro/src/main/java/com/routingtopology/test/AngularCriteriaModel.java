package com.routingtopology.test;

import java.util.List;

/**
 * This is the Angular Model Class
 *
 */
public class AngularCriteriaModel {
	
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
	 * @return Angular End point list
	 */
	public List<Integer> getAngularEndPoints() {
		return angularEndPoints;
	}

	/**
	 * @param angularEndPoints
	 */
	public void setAngularEndPoints(List<Integer> angularEndPoints) {
		this.angularEndPoints = angularEndPoints;
	}

	/**
	 * @return angular end points of a node
	 */
	public List<Integer> getNoOfNodesInEachAngularRegion() {
		return noOfNodesInEachAngularRegion;
	}

	/**
	 * @param noOfNodesInEachAngularRegion
	 */
	public void setNoOfNodesInEachAngularRegion(
			List<Integer> noOfNodesInEachAngularRegion) {
		this.noOfNodesInEachAngularRegion = noOfNodesInEachAngularRegion;
	}

	/**
	 * @return initial Signal Strength of the node
	 */
	public double getIntialSignalStrength() {
		return intialSignalStrength;
	}

	/**
	 * @param intialSignalStrength
	 */
	public void setIntialSignalStrength(double intialSignalStrength) {
		this.intialSignalStrength = intialSignalStrength;
	}

	private double energy;
	
	private double power;
	
	private int buffer;
	
	private int networkCost;
	
	private int trustLevel;
	
	private List<Integer> angularEndPoints;
	
	private List<Integer> noOfNodesInEachAngularRegion;
	
	private double intialSignalStrength;
}
