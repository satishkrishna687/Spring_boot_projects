package com.routingtopology.value;


public class EffcientDataNodeCriteria {

	

	private double dataRateOfRoute;

	private double energyTx;

	/**
	 * @return Energy Required for Tx
	 */
	public double getEnergyTx() {
		return energyTx;
	}

	/**
	 * @param energyTx
	 */
	public void setEnergyTx(double energyTx) {
		this.energyTx = energyTx;
	}

	/**
	 * @return Attunuation Factor
	 */
	public double getAttFactor() {
		return attFactor;
	}

	/**
	 * @param attFactor
	 */
	public void setAttFactor(double attFactor) {
		this.attFactor = attFactor;
	}

	private double energyAmp;

	private double attFactor;

	private int sourceNode;

	/**
	 * @return source node
	 */
	public int getSourceNode() {
		return sourceNode;
	}

	/**
	 * @param sourceNode
	 */
	public void setSourceNode(int sourceNode) {
		this.sourceNode = sourceNode;
	}

	/**
	 * @return destination node
	 */
	public int getDestinationNode() {
		return destinationNode;
	}

	/**
	 * @param destinationNode
	 */
	public void setDestinationNode(int destinationNode) {
		this.destinationNode = destinationNode;
	}

	/**
	 * @return TTL of node
	 */
	public int getTtl() {
		return ttl;
	}

	/**
	 * @param ttl
	 */
	public void setTtl(int ttl) {
		this.ttl = ttl;
	}

	/**
	 * @return coverage area
	 */
	public double getCoverageArea() {
		return coverageArea;
	}

	/**
	 * @param coverageArea
	 */
	public void setCoverageArea(double coverageArea) {
		this.coverageArea = coverageArea;
	}

	/**
	 * @return battery power of node
	 */
	public double getThresholdBattery() {
		return thresholdBattery;
	}

	/**
	 * @param thresholdBattery
	 */
	public void setThresholdBattery(double thresholdBattery) {
		this.thresholdBattery = thresholdBattery;
	}

	/**
	 * @return power required for transmission
	 */
	public double getPowerTransmission() {
		return powerTransmission;
	}

	/**
	 * @param powerTransmission
	 */
	public void setPowerTransmission(double powerTransmission) {
		this.powerTransmission = powerTransmission;
	}

	/**
	 * @return environmwnt factor
	 */
	public double getEnvironmentFactor() {
		return environmentFactor;
	}

	/**
	 * @param environmentFactor
	 */
	public void setEnvironmentFactor(double environmentFactor) {
		this.environmentFactor = environmentFactor;
	}

	

	/**
	 * @param dataRateOfRoute
	 */
	public void setDataRateOfRoute(double dataRateOfRoute) {
		this.dataRateOfRoute = dataRateOfRoute;
	}

	/**
	 * @return Data Rate of the route
	 */
	public double getDataRateOfRoute() {
		return dataRateOfRoute;
	}

	/**
	 * @param energyAmp
	 */
	public void setEnergyAmp(double energyAmp) {
		this.energyAmp = energyAmp;
	}

	/**
	 * @return Energy Required For Amplification
	 */
	public double getEnergyAmp() {
		return energyAmp;
	}

	private int destinationNode;

	private int ttl;

	private double coverageArea;

	private double thresholdBattery;

	private double powerTransmission;

	private double environmentFactor;

}
