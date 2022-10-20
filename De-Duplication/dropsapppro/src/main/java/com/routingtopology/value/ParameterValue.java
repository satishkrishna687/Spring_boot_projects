package com.routingtopology.value;

/**
 * This is the Parameter Value
 *
 */
public class ParameterValue {
	
	
	private double signalStrength;
	
	
	private double eigenTrust;
	
	
	private int trustLevel;
	
	/**
	 * @return trust level
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
	 * @return energy
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
	 * @return Power of node
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
	 * @return Buffer
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
	 * @param eigenTrust
	 */
	public void setEigenTrust(double eigenTrust) {
		this.eigenTrust = eigenTrust;
	}

	/**
	 * @return EIgen trust of node
	 */
	public double getEigenTrust() {
		return eigenTrust;
	}

	/**
	 * @param dempsterTrust
	 */
	public void setDempsterTrust(double dempsterTrust) {
		this.dempsterTrust = dempsterTrust;
	}

	/**
	 * @return Demspter Trust 
	 */
	public double getDempsterTrust() {
		return dempsterTrust;
	}

	/**
	 * @param signalStrength
	 */
	public void setSignalStrength(double signalStrength) {
		this.signalStrength = signalStrength;
	}

	/**
	 * @return signal strength of the node
	 */
	public double getSignalStrength() {
		return signalStrength;
	}

	public double getNetworkCost() {
		return networkCost;
	}

	public void setNetworkCost(double networkCost) {
		this.networkCost = networkCost;
	}

	private double dempsterTrust;
	
	private  double energy;
	
	private double power;
	
	private double networkCost;
	
	private int buffer;

}
