package com.model;

import java.io.Serializable;

public class CompareRoutingOverhead implements Serializable{

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

	public double getRoutingOverhead1() {
		return routingOverhead1;
	}

	public void setRoutingOverhead1(double routingOverhead1) {
		this.routingOverhead1 = routingOverhead1;
	}

	public double getRoutingOverhead2() {
		return routingOverhead2;
	}

	public void setRoutingOverhead2(double routingOverhead2) {
		this.routingOverhead2 = routingOverhead2;
	}

	public double getRoutingOverhead3() {
		return routingOverhead3;
	}

	public void setRoutingOverhead3(double routingOverhead3) {
		this.routingOverhead3 = routingOverhead3;
	}

	public double getRoutingOverhead4() {
		return routingOverhead4;
	}

	public void setRoutingOverhead4(double routingOverhead4) {
		this.routingOverhead4 = routingOverhead4;
	}

	private double routingOverhead1;
	
	
	private double routingOverhead2;
	
	private double routingOverhead3;
	
	private double routingOverhead4;
}
