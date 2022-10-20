package com.model;

public class ComparePower {

	private int iterationNo;

	/**
	 * @return iterationNo
	 */
	public int getIterationNo() {
		return iterationNo;
	}

	/**
	 * @param iterationNo
	 */
	public void setIterationNo(int iterationNo) {
		this.iterationNo = iterationNo;
	}

	/**
	 * @return power
	 */
	public double getRequisitePower() {
		return requisitePower;
	}

	/**
	 * @param requisitePower
	 */
	public void setRequisitePower(double requisitePower) {
		this.requisitePower = requisitePower;
	}

	/**
	 * @return normalPower
	 */
	public double getNormalPower() {
		return normalPower;
	}

	/**
	 * @param normalPower
	 */
	public void setNormalPower(double normalPower) {
		this.normalPower = normalPower;
	}

	private double requisitePower;

	private double normalPower;

}
