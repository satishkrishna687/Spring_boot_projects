package com.routingtopology.test;

/**
 * This is the class used for
 * topology updation
 **/
public class SquareTopologyUpdate {
	
	private int nodeId;
	
	/**
	 * @return node id of the node
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

	/**
	 * @return Power available of the node
	 */
	public double getPowerAvailable() {
		return powerAvailable;
	}

	/**
	 * @param powerAvailable
	 */
	public void setPowerAvailable(double powerAvailable) {
		this.powerAvailable = powerAvailable;
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
	 * @return true if zone leader
	 */
	public boolean isZoneLeaderFlag() {
		return zoneLeaderFlag;
	}

	/**
	 * @param zoneLeaderFlag
	 */
	public void setZoneLeaderFlag(boolean zoneLeaderFlag) {
		this.zoneLeaderFlag = zoneLeaderFlag;
	}

	private int trustLevel; 
	
	private double energy;

	private double powerAvailable;
	
	private int networkCost;
	
	private int buffer;
			
	private boolean zoneLeaderFlag;
	
	private int XCordinate;
	
	/**
	 * @return X Cordinate of the node
	 */
	public int getXCordinate() {
		return XCordinate;
	}

	/**
	 * @param xCordinate
	 */
	public void setXCordinate(int xCordinate) {
		XCordinate = xCordinate;
	}

	/**
	 * @return Y Cordinate of node
	 */
	public int getYCordinate() {
		return YCordinate;
	}

	/**
	 * @param yCordinate
	 */
	public void setYCordinate(int yCordinate) {
		YCordinate = yCordinate;
	}

	private int YCordinate;
	
	private double xCenter;
	
	/**
	 * @return center x cordinate
	 */
	public double getxCenter() {
		return xCenter;
	}

	/**
	 * @param xCenter
	 */
	public void setxCenter(double xCenter) {
		this.xCenter = xCenter;
	}

	/**
	 * @return center Y Cordinate
	 */
	public double getyCenter() {
		return yCenter;
	}

	/**
	 * @param yCenter
	 */
	public void setyCenter(double yCenter) {
		this.yCenter = yCenter;
	}

	private double yCenter;
	
}
