package com.routingtopology.value;

/**
 * 
 */
public class RelayNodeFunction {
	
	private int nodeId;
	
	/**
	 * @return Node ID of the Node
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
	 * @return Zone Id of the Node
	 */
	public int getZoneId() {
		return zoneId;
	}

	/**
	 * @param zoneId
	 */
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	/**
	 * @return K1 of the Node
	 */
	public int getK1() {
		return k1;
	}

	/**
	 * @param k1
	 */
	public void setK1(int k1) {
		this.k1 = k1;
	}

	/**
	 * @return K2 of the Node
	 */
	public int getK2() {
		return k2;
	}

	/**
	 * @param k2
	 */
	public void setK2(int k2) {
		this.k2 = k2;
	}

	/**
	 * @return Residual Energy
	 */
	public double getResidualEnergy() {
		return residualEnergy;
	}

	/**
	 * @param residualEnergy
	 */
	public void setResidualEnergy(double residualEnergy) {
		this.residualEnergy = residualEnergy;
	}

	/**
	 * @return Maximum Energy of Node
	 */
	public double getMaxEnergy() {
		return maxEnergy;
	}

	/**
	 * @param maxEnergy
	 */
	public void setMaxEnergy(double maxEnergy) {
		this.maxEnergy = maxEnergy;
	}

	/**
	 * @return Distance Between Node and CH
	 */
	public double getDistanceBetweenNodeCH() {
		return distanceBetweenNodeCH;
	}

	/**
	 * @param distanceBetweenNodeCH
	 */
	public void setDistanceBetweenNodeCH(double distanceBetweenNodeCH) {
		this.distanceBetweenNodeCH = distanceBetweenNodeCH;
	}

	/**
	 * @return Alpha position of Node
	 */
	public double getAlpha() {
		return alpha;
	}

	/**
	 * @param alpha
	 */
	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	/**
	 * @param distanceBetweenNodeBS
	 */
	public void setDistanceBetweenNodeBS(double distanceBetweenNodeBS) {
		this.distanceBetweenNodeBS = distanceBetweenNodeBS;
	}

	/**
	 * @return Distance Between Node and BS
	 */
	public double getDistanceBetweenNodeBS() {
		return distanceBetweenNodeBS;
	}

	/**
	 * @param relayFn
	 */
	public void setRelayFn(double relayFn) {
		this.relayFn = relayFn;
	}

	/**
	 * @return RelayFn
	 */
	public double getRelayFn() {
		return relayFn;
	}

	private int zoneId;
	
	private int k1;
	
	private int k2;
	
	private double residualEnergy;
	
	private double maxEnergy;
	
	private double distanceBetweenNodeCH;
	
	private double distanceBetweenNodeBS;
	
	private double alpha;
	
	
	
	private double relayFn;
}
