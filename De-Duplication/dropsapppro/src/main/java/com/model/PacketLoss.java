package com.model;

public class PacketLoss {
	
	public int getNoOfIterations() {
		return noOfIterations;
	}

	public void setNoOfIterations(int noOfIterations) {
		this.noOfIterations = noOfIterations;
	}

	public int getPacketLossFaultNode() {
		return packetLossFaultNode;
	}

	public void setPacketLossFaultNode(int packetLossFaultNode) {
		this.packetLossFaultNode = packetLossFaultNode;
	}

	public int getPacketLossGradeDiffusion() {
		return packetLossGradeDiffusion;
	}

	public void setPacketLossGradeDiffusion(int packetLossGradeDiffusion) {
		this.packetLossGradeDiffusion = packetLossGradeDiffusion;
	}

	private int noOfIterations;
	
	private int packetLossFaultNode;
	
	private int packetLossGradeDiffusion;

}
