package com.routingtopology.value;


public class FindLEEACHRouteValue {
	
	
	private double xPosBS;
	
	/**
	 * @return X position of Base Station
	 */
	public double getxPosBS() {
		return xPosBS;
	}

	/**
	 * @param xPosBS
	 */
	public void setxPosBS(double xPosBS) {
		this.xPosBS = xPosBS;
	}

	/**
	 * @return Y Position of Base Station
	 */
	public double getyPosBs() {
		return yPosBs;
	}

	/**
	 * @param yPosBs
	 */
	public void setyPosBs(double yPosBs) {
		this.yPosBs = yPosBs;
	}

	private double yPosBs;
	
	
	private int baseStationId;
	

	private double environmentFactor;

	private double transmissionPower;

	
	private int sourceNode;

	/**
	 * @return source node id
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

	private int destinationNode;

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
	 * @param transmissionPower
	 */
	public void setTransmissionPower(double transmissionPower) {
		this.transmissionPower = transmissionPower;
	}

	/**
	 * @return transmission power
	 */
	public double getTransmissionPower() {
		return transmissionPower;
	}

	/**
	 * @param environmentFactor
	 */
	public void setEnvironmentFactor(double environmentFactor) {
		this.environmentFactor = environmentFactor;
	}

	/**
	 * @return environment factor
	 */
	public double getEnvironmentFactor() {
		return environmentFactor;
	}

	/**
	 * @return Base Station ID
	 */
	public int getBaseStationId() {
		return baseStationId;
	}

	/**
	 * @param baseStationId
	 */
	public void setBaseStationId(int baseStationId) {
		this.baseStationId = baseStationId;
	}

}
