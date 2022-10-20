package com.routingtopology.value;

/**
 * 
 *
 */
public class RelayNodeCriteria {
	
	private int k1;
	
	/**
	 * @return K1 constant
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
	 * @return K2 constant
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
	 * @return Maximum Energy
	 */
	public double getMaximumEnergy() {
		return maximumEnergy;
	}

	/**
	 * @param maximumEnergy
	 */
	public void setMaximumEnergy(double maximumEnergy) {
		this.maximumEnergy = maximumEnergy;
	}

	/**
	 * @param xposofBS
	 */
	public void setXposofBS(double xposofBS) {
		this.xposofBS = xposofBS;
	}

	/**
	 * @return X position of Base Station
	 */
	public double getXposofBS() {
		return xposofBS;
	}

	/**
	 * @param yPosOfBS
	 */
	public void setyPosOfBS(double yPosOfBS) {
		this.yPosOfBS = yPosOfBS;
	}

	/**
	 * @return Y position of BS
	 */
	public double getyPosOfBS() {
		return yPosOfBS;
	}

	private int k2;
	
	private double maximumEnergy;
	
	private double xposofBS;
	
	private double yPosOfBS;
	
	
	

}
