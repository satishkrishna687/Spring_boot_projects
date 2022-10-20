package com.model;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


public class EEDRModel {

	private double dataRateOfRoute;

	private double energyTx;

	/**
	 * @return Energy Required for Tx
	 */
	public double getEnergyTx() {
		return energyTx;
	}

	/**
	 * @param energyTx
	 */
	public void setEnergyTx(double energyTx) {
		this.energyTx = energyTx;
	}

	/**
	 * @return Attunuation Factor
	 */
	public double getAttFactor() {
		return attFactor;
	}

	/**
	 * @param attFactor
	 */
	public void setAttFactor(double attFactor) {
		this.attFactor = attFactor;
	}

	private double energyAmp;

	private double attFactor;

	private String sourceNode;

	/**
	 * @return TTL of node
	 */
	public int getTtl() {
		return ttl;
	}

	/**
	 * @param ttl
	 */
	public void setTtl(int ttl) {
		this.ttl = ttl;
	}

	/**
	 * @return battery power of node
	 */
	public double getThresholdBattery() {
		return thresholdBattery;
	}

	/**
	 * @param thresholdBattery
	 */
	public void setThresholdBattery(double thresholdBattery) {
		this.thresholdBattery = thresholdBattery;
	}

	/**
	 * @return power required for transmission
	 */
	public double getPowerTransmission() {
		return powerTransmission;
	}

	/**
	 * @param powerTransmission
	 */
	public void setPowerTransmission(double powerTransmission) {
		this.powerTransmission = powerTransmission;
	}

	/**
	 * @return environmwnt factor
	 */
	public double getEnvironmentFactor() {
		return environmentFactor;
	}

	/**
	 * @param environmentFactor
	 */
	public void setEnvironmentFactor(double environmentFactor) {
		this.environmentFactor = environmentFactor;
	}

	/**
	 * @param dataRateOfRoute
	 */
	public void setDataRateOfRoute(double dataRateOfRoute) {
		this.dataRateOfRoute = dataRateOfRoute;
	}

	/**
	 * @return Data Rate of the route
	 */
	public double getDataRateOfRoute() {
		return dataRateOfRoute;
	}

	/**
	 * @param energyAmp
	 */
	public void setEnergyAmp(double energyAmp) {
		this.energyAmp = energyAmp;
	}

	/**
	 * @return Energy Required For Amplification
	 */
	public double getEnergyAmp() {
		return energyAmp;
	}

	/**
	 * @param dataPayload
	 */
	public void setDataPayload(String dataPayload) {
		this.dataPayload = dataPayload;
	}

	/**
	 * @return dataPayload
	 */
	public String getDataPayload() {
		return dataPayload;
	}

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
	 * @return upperLimit
	 */
	public int getUpperLimit() {
		return upperLimit;
	}

	/**
	 * @param upperLimit
	 */
	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}

	/**
	 * @return sensingRange
	 */
	public double getSensingRange() {
		return sensingRange;
	}

	/**
	 * @param sensingRange
	 */
	public void setSensingRange(double sensingRange) {
		this.sensingRange = sensingRange;
	}

	public String getDestinationNode() {
		return destinationNode;
	}

	public void setDestinationNode(String destinationNode) {
		this.destinationNode = destinationNode;
	}

	public String getCoverageArea() {
		return coverageArea;
	}

	public void setCoverageArea(String coverageArea) {
		this.coverageArea = coverageArea;
	}

	public String getInitialEnergy() {
		return initialEnergy;
	}

	public void setInitialEnergy(String initialEnergy) {
		this.initialEnergy = initialEnergy;
	}

	public String getSourceNode() {
		return sourceNode;
	}

	public void setSourceNode(String sourceNode) {
		this.sourceNode = sourceNode;
	}

	public double getPropogationEffciency() {
		return propogationEffciency;
	}

	public void setPropogationEffciency(double propogationEffciency) {
		this.propogationEffciency = propogationEffciency;
	}

	public double getPowerRx() {
		return powerRx;
	}

	public void setPowerRx(double powerRx) {
		this.powerRx = powerRx;
	}

	public double getInitialNoiseFigure() {
		return initialNoiseFigure;
	}

	public void setInitialNoiseFigure(double initialNoiseFigure) {
		this.initialNoiseFigure = initialNoiseFigure;
	}

	public double getSignalBW() {
		return signalBW;
	}

	public void setSignalBW(double signalBW) {
		this.signalBW = signalBW;
	}

	public double getNoiseFigure() {
		return noiseFigure;
	}

	public void setNoiseFigure(double noiseFigure) {
		this.noiseFigure = noiseFigure;
	}

	public double getPowerGain() {
		return powerGain;
	}

	public void setPowerGain(double powerGain) {
		this.powerGain = powerGain;
	}

	public double getFreq() {
		return freq;
	}

	public void setFreq(double freq) {
		this.freq = freq;
	}

	public boolean isIPSame() {
		return isIPSame;
	}

	public void setIPSame(boolean isIPSame) {
		this.isIPSame = isIPSame;
	}

	public String getDataPacket() {
		return dataPacket;
	}

	public void setDataPacket(String dataPacket) {
		this.dataPacket = dataPacket;
	}

	public String getSameIP() {
		return sameIP;
	}

	public void setSameIP(String sameIP) {

		if (sameIP != null && sameIP.equals("YES")) {
			this.sameIP = sameIP;
			this.setIPSame(true);
		} else {
			
			this.setIPSame(false);

		}
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	private String destinationNode;

	private int ttl;

	private String coverageArea;

	private double thresholdBattery;

	private double powerTransmission;

	private double environmentFactor;

	private String dataPayload;

	private double alpha;

	private String initialEnergy;

	private int upperLimit;

	private double sensingRange;

	private double propogationEffciency;

	private double powerRx;

	private double initialNoiseFigure;
	private double signalBW;
	private double noiseFigure;
	private double powerGain;

	private double freq;

	private boolean isIPSame;

	private String dataPacket;

	private String sameIP;
	
	
	private MultipartFile multipartFile;
	
	private int fileSize;

}
