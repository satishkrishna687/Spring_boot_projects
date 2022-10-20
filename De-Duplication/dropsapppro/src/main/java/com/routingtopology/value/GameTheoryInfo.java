package com.routingtopology.value;

public class GameTheoryInfo {
	
	
	
	private int indexParam;

	private double alpha;

	/**
	 * @return alpha
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
	 * @return intial energy of the node
	 */
	public double getIntialEnergy() {
		return intialEnergy;
	}

	/**
	 * @param intialEnergy
	 */
	public void setIntialEnergy(double intialEnergy) {
		this.intialEnergy = intialEnergy;
	}

	/**
	 * @return beta
	 */
	public double getBeta() {
		return beta;
	}

	/**
	 * @param beta
	 */
	public void setBeta(double beta) {
		this.beta = beta;
	}

	/**
	 * @return gamma
	 */
	public double getGamma() {
		return gamma;
	}

	/**
	 * @param gamma
	 */
	public void setGamma(double gamma) {
		this.gamma = gamma;
	}

	/**
	 * @return index parameter
	 */
	public int getIndexParam() {
		return indexParam;
	}

	/**
	 * @param indexParam
	 */
	public void setIndexParam(int indexParam) {
		this.indexParam = indexParam;
	}

	private double intialEnergy;

	private double beta;

	private double gamma;

}
