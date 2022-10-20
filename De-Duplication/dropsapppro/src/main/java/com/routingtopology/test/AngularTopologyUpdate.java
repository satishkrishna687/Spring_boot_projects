package com.routingtopology.test;

/**
 * This is the class used for
 * topology updation
 **/
public class AngularTopologyUpdate {
	
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

	/**
	 * @return signal strength of the node
	 */
	public double getSignalStrength() {
		return signalStrength;
	}

	/**
	 * @param signalStrength
	 */
	public void setSignalStrength(double signalStrength) {
		this.signalStrength = signalStrength;
	}




	/**
	 * @return Closer to which side
	 */
	public int getCloserToObs() {
		return closerToObs;
	}

	/**
	 * @param closerToObs
	 */
	public void setCloserToObs(int closerToObs) {
		this.closerToObs = closerToObs;
	}

	/**
	 * @param angularPosition
	 */
	public void setAngularPosition(int angularPosition) {
		this.angularPosition = angularPosition;
	}

	/**
	 * @return angular position of node
	 */
	public int getAngularPosition() {
		return angularPosition;
	}

	/**
	 * @param angularRegion
	 */
	public void setAngularRegion(int angularRegion) {
		this.angularRegion = angularRegion;
	}

	/**
	 * @return Angular region of the node
	 */
	public int getAngularRegion() {
		return angularRegion;
	}

	private int trustLevel; 
	
	private double energy;

	private double powerAvailable;
	
	private int networkCost;
	
	private int buffer;
	
	private int angularRegion;
	
	private boolean zoneLeaderFlag;
	
	private double signalStrength;
	
	private int angularPosition;
	
	private int closerToObs;
	
}
