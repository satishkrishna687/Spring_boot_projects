package com.routingtopology.value;

import java.util.List;


public class RouteInfo {
	
	
	private double timeTakenForRouteDiscovery;
	
	private double distance;
	
	private double energyWithHops;
	
	
	private double energyPacRecepTransHear;
	
	
	private List<Integer> routeList;
	
	/**
	 * @return List of nodes
	 */
	public List<Integer> getRouteList() {
		return routeList;
	}

	/**
	 * @param routeList
	 */
	public void setRouteList(List<Integer> routeList) {
		this.routeList = routeList;
	}

	/**
	 * @return total energy
	 */
	public double getTotalEnergy() {
		return totalEnergy;
	}

	/**
	 * @param totalEnergy
	 */
	public void setTotalEnergy(double totalEnergy) {
		this.totalEnergy = totalEnergy;
	}

	/**
	 * @return total power
	 */
	public double getTotalPower() {
		return totalPower;
	}

	/**
	 * @param totalPower
	 */
	public void setTotalPower(double totalPower) {
		this.totalPower = totalPower;
	}

	/**
	 * @return no of hops
	 */
	public double getNoOfHops() {
		return noOfHops;
	}

	/**
	 * @param noOfHops
	 */
	public void setNoOfHops(double noOfHops) {
		this.noOfHops = noOfHops;
	}

	/**
	 * @return goodness factor
	 */
	public double getGoodnessFact() {
		return goodnessFact;
	}

	/**
	 * @param goodnessFact
	 */
	public void setGoodnessFact(double goodnessFact) {
		this.goodnessFact = goodnessFact;
	}

	/**
	 * @param packetReceptionEnergy
	 */
	public void setPacketReceptionEnergy(double packetReceptionEnergy) {
		this.packetReceptionEnergy = packetReceptionEnergy;
	}

	/**
	 * @return packet reception energy
	 */
	public double getPacketReceptionEnergy() {
		return packetReceptionEnergy;
	}
	
	

	/**
	 * @param packetHearingEnergy
	 */
	public void setPacketHearingEnergy(double packetHearingEnergy) {
		this.packetHearingEnergy = packetHearingEnergy;
	}

	/**
	 * @return packet Hearing energy
	 */
	public double getPacketHearingEnergy() {
		return packetHearingEnergy;
	}



	/**
	 * @param packetTransmissionEnergy
	 */
	public void setPacketTransmissionEnergy(double packetTransmissionEnergy) {
		this.packetTransmissionEnergy = packetTransmissionEnergy;
	}

	/**
	 * @return packet transmission energy
	 */
	public double getPacketTransmissionEnergy() {
		return packetTransmissionEnergy;
	}



	/**
	 * @param energyPacRecepTransHear
	 */
	public void setEnergyPacRecepTransHear(double energyPacRecepTransHear) {
		this.energyPacRecepTransHear = energyPacRecepTransHear;
	}

	/**
	 * @return energy required for reception hearing transmission
	 */
	public double getEnergyPacRecepTransHear() {
		return energyPacRecepTransHear;
	}



	/**
	 * @param energyWithHops
	 */
	public void setEnergyWithHops(double energyWithHops) {
		this.energyWithHops = energyWithHops;
	}

	/**
	 * @return energy with hops
	 */
	public double getEnergyWithHops() {
		return energyWithHops;
	}



	/**
	 * @param distance
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * @return distance between nodes
	 */
	public double getDistance() {
		return distance;
	}



	/**
	 * @param timeTakenForRouteDiscovery
	 */
	public void setTimeTakenForRouteDiscovery(double timeTakenForRouteDiscovery) {
		this.timeTakenForRouteDiscovery = timeTakenForRouteDiscovery;
	}

	/**
	 * @return time taken for route discovery
	 */
	public double getTimeTakenForRouteDiscovery() {
		return timeTakenForRouteDiscovery;
	}



	public double getEnergyConsumedOnRoute() {
		return energyConsumedOnRoute;
	}

	public void setEnergyConsumedOnRoute(double energyConsumedOnRoute) {
		this.energyConsumedOnRoute = energyConsumedOnRoute;
	}



	public double getcQIRoute() {
		return cQIRoute;
	}

	public void setcQIRoute(double cQIRoute) {
		this.cQIRoute = cQIRoute;
	}



	private double totalEnergy;
	
	private double totalPower;
	
	private double noOfHops;
	
	private double goodnessFact;
	
	private double packetReceptionEnergy;
	
	private double packetHearingEnergy;
	
	private double packetTransmissionEnergy;
	
	
	private double energyConsumedOnRoute;
	
	private double cQIRoute;
	
	

}
