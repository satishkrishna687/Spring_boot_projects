package com.routingtopology.value;


public class NodeParameters {

	private int regionId;

	/**
	 * @return region Id of the node
	 */
	public int getRegionId() {
		return regionId;
	}

	/**
	 * @param regionId
	 */
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	/**
	 * @return district id
	 */
	public int getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId
	 */
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	private int districtId;

	private int zoneId;

	private int angularRegion;

	private int angularPos;

	private int closeObstracle;

	private double signalStrengthOfNode;

	private int verticalBelong;

	private int trustLevel;

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
	/**
	 * @return current battery power of the node
	 */
	public double getAvailableBatteryPower() {
		return availableBatteryPower;
	}

	/**
	 * @param availableBatteryPower
	 */
	public void setAvailableBatteryPower(double availableBatteryPower) {
		this.availableBatteryPower = availableBatteryPower;
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
	 * @return the vertical to which the node belongs
	 */
	public int getVerticalBelong() {
		return verticalBelong;
	}

	/**
	 * @param signalStrengthOfNode
	 */
	public void setSignalStrengthOfNode(double signalStrengthOfNode) {
		this.signalStrengthOfNode = signalStrengthOfNode;
	}

	/**
	 * @return Signal Strength of node
	 */
	public double getSignalStrengthOfNode() {
		return signalStrengthOfNode;
	}

	/**
	 * @param closeObstracle
	 */
	public void setCloseObstracle(int closeObstracle) {
		this.closeObstracle = closeObstracle;
	}

	/**
	 * @return this is the closeness of obstracle
	 */
	public int getCloseObstracle() {
		return closeObstracle;
	}

	/**
	 * @param angularPos
	 */
	public void setAngularPos(int angularPos) {
		this.angularPos = angularPos;
	}

	/**
	 * @return Angular Position of the node
	 */
	public int getAngularPos() {
		return angularPos;
	}

	/**
	 * @param angularRegion
	 */
	public void setAngularRegion(int angularRegion) {
		this.angularRegion = angularRegion;
	}

	/**
	 * @return angular region of the node
	 */
	public int getAngularRegion() {
		return angularRegion;
	}

	/**
	 * @param zoneId
	 */
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	/**
	 * @return Zone Id of the zone
	 */
	public int getZoneId() {
		return zoneId;
	}

	/**
	 * @param buffer
	 */
	public void setBuffer(int buffer) {
		this.buffer = buffer;
	}

	/**
	 * @return amout of buffer
	 */
	public int getBuffer() {
		return buffer;
	}

	private double powerConsumed;

	private int buffer;

	private double availableBatteryPower;

	private double networkCost;
	
	private double eigenTrustLevel;
	
	/**
	 * @return eigen trust level
	 */
	public double getEigenTrustLevel() {
		return eigenTrustLevel;
	}

	/**
	 * @param eigenTrustLevel
	 */
	public void setEigenTrustLevel(double eigenTrustLevel) {
		this.eigenTrustLevel = eigenTrustLevel;
	}

	/**
	 * @return dempster trust level
	 */
	public double getDempsterTrustLevel() {
		return dempsterTrustLevel;
	}

	/**
	 * @param dempsterTrustLevel
	 */
	public void setDempsterTrustLevel(double dempsterTrustLevel) {
		this.dempsterTrustLevel = dempsterTrustLevel;
	}

	public double getNetworkCost() {
		return networkCost;
	}

	public void setNetworkCost(double networkCost) {
		this.networkCost = networkCost;
	}

	private double dempsterTrustLevel;

	

}
