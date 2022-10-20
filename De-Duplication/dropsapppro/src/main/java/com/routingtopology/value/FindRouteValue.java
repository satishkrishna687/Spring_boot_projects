package com.routingtopology.value;


public class FindRouteValue {
	
	private int obsSite;
	
	private boolean isObsAware;
	
	
	private double Pr;
	
	/**
	 * @return Power Recieved
	 */
	public double getPr() {
		return Pr;
	}

	/**
	 * @param pr
	 */
	public void setPr(double pr) {
		Pr = pr;
	}

	/**
	 * @return Power for transmission
	 */
	public double getPt() {
		return Pt;
	}

	/**
	 * @param pt
	 */
	public void setPt(double pt) {
		Pt = pt;
	}

	/**
	 * @return Gain of tx
	 */
	public double getGt() {
		return Gt;
	}

	/**
	 * @param gt
	 */
	public void setGt(double gt) {
		Gt = gt;
	}

	/**
	 * @return Gr
	 */
	public double getGr() {
		return Gr;
	}

	/**
	 * @param gr
	 */
	public void setGr(double gr) {
		Gr = gr;
	}

	/**
	 * @return lamda value
	 */
	public double getLamda() {
		return lamda;
	}

	/**
	 * @param lamda
	 */
	public void setLamda(double lamda) {
		this.lamda = lamda;
	}

	private double Pt;
	
	private double Gt;
		
	private double Gr;
	
	private double lamda;
	
	

	private int noOfCorporativeNodes;

	private double environmentFactor;

	private double transmissionPower;

	private String trustType;

	private int sourceNode;

	/**
	 * @return source node id
	 */
	public int getSourceNode() {
		return sourceNode;
	}

	/**
	 * @param sourceNode
	 */
	public void setSourceNode(int sourceNode) {
		this.sourceNode = sourceNode;
	}

	private int destinationNode;

	/**
	 * @return destination node
	 */
	public int getDestinationNode() {
		return destinationNode;
	}

	/**
	 * @param destinationNode
	 */
	public void setDestinationNode(int destinationNode) {
		this.destinationNode = destinationNode;
	}

	/**
	 * @param trustType
	 */
	public void setTrustType(String trustType) {
		this.trustType = trustType;
	}

	/**
	 * @return trust type of the route
	 */
	public String getTrustType() {
		return trustType;
	}

	private int dataPacketEvidence;

	/**
	 * @param dataPacketEvidence
	 */
	public void setDataPacketEvidence(int dataPacketEvidence) {
		this.dataPacketEvidence = dataPacketEvidence;
	}

	/**
	 * @return Data Packet Evidence
	 */
	public int getDataPacketEvidence() {
		return dataPacketEvidence;
	}

	private int controlPacketEvidence;

	/**
	 * @param controlPacketEvidence
	 */
	public void setControlPacketEvidence(int controlPacketEvidence) {
		this.controlPacketEvidence = controlPacketEvidence;
	}

	/**
	 * @return Control Packet Evidence
	 */
	public int getControlPacketEvidence() {
		return controlPacketEvidence;
	}

	/**
	 * @param transmissionPower
	 */
	public void setTransmissionPower(double transmissionPower) {
		this.transmissionPower = transmissionPower;
	}

	/**
	 * @return transmission power
	 */
	public double getTransmissionPower() {
		return transmissionPower;
	}

	/**
	 * @param environmentFactor
	 */
	public void setEnvironmentFactor(double environmentFactor) {
		this.environmentFactor = environmentFactor;
	}

	/**
	 * @return enviroment factor
	 */
	public double getEnvironmentFactor() {
		return environmentFactor;
	}

	/**
	 * @param noOfCorporativeNodes
	 */
	public void setNoOfCorporativeNodes(int noOfCorporativeNodes) {
		this.noOfCorporativeNodes = noOfCorporativeNodes;
	}

	/**
	 * @return number of corporative nodes
	 */
	public int getNoOfCorporativeNodes() {
		return noOfCorporativeNodes;
	}

	/**
	 * @param isObsAware
	 */
	public void setObsAware(boolean isObsAware) {
		this.isObsAware = isObsAware;
	}

	/**
	 * @return obs is present or not
	 */
	public boolean isObsAware() {
		return isObsAware;
	}

	/**
	 * @param obsSite
	 */
	public void setObsSite(int obsSite) {
		this.obsSite = obsSite;
	}

	/**
	 * @return Obs Aware Site
	 */
	public int getObsSite() {
		return obsSite;
	}

}
