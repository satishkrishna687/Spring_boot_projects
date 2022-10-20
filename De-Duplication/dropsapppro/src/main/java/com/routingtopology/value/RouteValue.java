package com.routingtopology.value;

public class RouteValue {

	private int zoneId;

	private int directTrust;

	/**
	 * @return direct trust
	 */
	public int getDirectTrust() {
		return directTrust;
	}

	/**
	 * @param directTrust
	 */
	public void setDirectTrust(int directTrust) {
		this.directTrust = directTrust;
	}

	/**
	 * @return indirect trust
	 */
	public int getIndirectTrust() {
		return indirectTrust;
	}

	/**
	 * @param indirectTrust
	 */
	public void setIndirectTrust(int indirectTrust) {
		this.indirectTrust = indirectTrust;
	}

	/**
	 * @return remaining power
	 */
	public double getPowerRemaning() {
		return powerRemaning;
	}

	/**
	 * @param powerRemaning
	 */
	public void setPowerRemaning(double powerRemaning) {
		this.powerRemaning = powerRemaning;
	}

	/**
	 * @return Energy Remaning
	 */
	public double getEnergyRemaning() {
		return energyRemaning;
	}

	/**
	 * @param energyRemaning
	 */
	public void setEnergyRemaning(double energyRemaning) {
		this.energyRemaning = energyRemaning;
	}

	/**
	 * @return id of the node
	 */
	public int getNodeId() {
		return nodeId;
	}

	/**
	 * @param nodeId
	 */
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	/**
	 * @param zoneId
	 */
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	/**
	 * @return zoneId
	 */
	public int getZoneId() {
		return zoneId;
	}

	private int indirectTrust;

	private double powerRemaning;

	private double energyRemaning;

	private int nodeId;

	private double eigenTrust;

	/**
	 * @return eigen trust of the node
	 */
	public double getEigenTrust() {
		return eigenTrust;
	}

	/**
	 * @param eigenTrust
	 */
	public void setEigenTrust(double eigenTrust) {
		this.eigenTrust = eigenTrust;
	}

	/**
	 * @return dempster trust of the node
	 */
	public double getDempsterTrust() {
		return dempsterTrust;
	}

	/**
	 * @param dempsterTrust
	 */
	public void setDempsterTrust(double dempsterTrust) {
		this.dempsterTrust = dempsterTrust;
	}

	private double dempsterTrust;

}
