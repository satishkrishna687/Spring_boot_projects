package com.model;

import java.io.Serializable;

public class CompareThroughput implements Serializable {

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

	public double getThroughput1() {
		return throughput1;
	}

	public void setThroughput1(double throughput1) {
		this.throughput1 = throughput1;
	}

	public double getThroughput2() {
		return throughput2;
	}

	public void setThroughput2(double throughput2) {
		this.throughput2 = throughput2;
	}

	public double getThroughput3() {
		return throughput3;
	}

	public void setThroughput3(double throughput3) {
		this.throughput3 = throughput3;
	}

	public double getThroughput4() {
		return throughput4;
	}

	public void setThroughput4(double throughput4) {
		this.throughput4 = throughput4;
	}

	private double throughput1;

	private double throughput2;

	private double throughput3;

	private double throughput4;

}
