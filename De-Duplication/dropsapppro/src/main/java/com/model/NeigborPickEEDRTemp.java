package com.model;

import java.io.Serializable;

public class NeigborPickEEDRTemp implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int nodeId;
	
	private double cQI;

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public double getcQI() {
		return cQI;
	}

	public void setcQI(double cQI) {
		this.cQI = cQI;
	}

}
