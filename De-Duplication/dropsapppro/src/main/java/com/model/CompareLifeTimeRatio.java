package com.model;

import java.io.Serializable;

public class CompareLifeTimeRatio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int iterationNo;

	public int getIterationNo() {
		return iterationNo;
	}

	public void setIterationNo(int iterationNo) {
		this.iterationNo = iterationNo;
	}

	public double getLifeTimeRatio1() {
		return lifeTimeRatio1;
	}

	public void setLifeTimeRatio1(double lifeTimeRatio1) {
		this.lifeTimeRatio1 = lifeTimeRatio1;
	}

	public double getLifeTimeRatio2() {
		return lifeTimeRatio2;
	}

	public void setLifeTimeRatio2(double lifeTimeRatio2) {
		this.lifeTimeRatio2 = lifeTimeRatio2;
	}

	public double getLifeTimeRatio3() {
		return lifeTimeRatio3;
	}

	public void setLifeTimeRatio3(double lifeTimeRatio3) {
		this.lifeTimeRatio3 = lifeTimeRatio3;
	}

	public double getLifeTimeRatio4() {
		return lifeTimeRatio4;
	}

	public void setLifeTimeRatio4(double lifeTimeRatio4) {
		this.lifeTimeRatio4 = lifeTimeRatio4;
	}

	private double lifeTimeRatio1;

	private double lifeTimeRatio2;

	private double lifeTimeRatio3;
	
	private double lifeTimeRatio4;

}
