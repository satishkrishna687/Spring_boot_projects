package com.model;

public class ACOModel {

	private String dataPayload;

	private double current;

	private double voltage;

	private double packetTransmitTime;

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
	 * @param packetTransmitTime
	 */
	public void setPacketTransmitTime(double packetTransmitTime) {
		this.packetTransmitTime = packetTransmitTime;
	}

	/**
	 * @return packet transmit time
	 */
	public double getPacketTransmitTime() {
		return packetTransmitTime;
	}

	/**
	 * @param current
	 */
	public void setCurrent(double current) {
		this.current = current;
	}

	/**
	 * @return current of node
	 */
	public double getCurrent() {
		return current;
	}

	/**
	 * @param voltage
	 */
	public void setVoltage(double voltage) {
		this.voltage = voltage;
	}

	/**
	 * @return voltage
	 */
	public double getVoltage() {
		return voltage;
	}

	/**
	 * @param dataPayload
	 */
	public void setDataPayload(String dataPayload) {
		this.dataPayload = dataPayload;
	}

	/**
	 * @return data payload
	 */
	public String getDataPayload() {
		return dataPayload;
	}

	private int destinationNode;

	private int ttl;

	private double coverageArea;

	private double thresholdBattery;

	private double powerTransmission;

	private double environmentFactor;

}
