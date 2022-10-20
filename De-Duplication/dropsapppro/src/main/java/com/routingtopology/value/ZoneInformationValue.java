package com.routingtopology.value;

import java.util.List;

public class ZoneInformationValue {

	private ZoneIdValue zoneId;

	/**
	 * @param zoneId
	 */
	public void setZoneId(ZoneIdValue zoneId) {
		this.zoneId = zoneId;
	}

	/**
	 * @return the zone id values
	 */
	public ZoneIdValue getZoneId() {
		return zoneId;
	}

	private int noOfRegions;

	/**
	 * @return number of regions
	 */
	public int getNoOfRegions() {
		return noOfRegions;
	}

	/**
	 * @param noOfRegions
	 */
	public void setNoOfRegions(int noOfRegions) {
		this.noOfRegions = noOfRegions;
	}

	/**
	 * @return number of districts of a node
	 */
	public int getNoOfDistricts() {
		return noOfDistricts;
	}

	/**
	 * @param noOfDistricts
	 */
	public void setNoOfDistricts(int noOfDistricts) {
		this.noOfDistricts = noOfDistricts;
	}

	/**
	 * @param regionLimits
	 */
	public void setRegionLimits(List<Integer> regionLimits) {
		this.regionLimits = regionLimits;
	}

	/**
	 * @return List of region end points
	 */
	public List<Integer> getRegionLimits() {
		return regionLimits;
	}

	/**
	 * @param districtLimits
	 */
	public void setDistrictLimits(List<Integer> districtLimits) {
		this.districtLimits = districtLimits;
	}

	/**
	 * @return Number of Districts
	 */
	public List<Integer> getDistrictLimits() {
		return districtLimits;
	}

	/**
	 * @param angularLimits
	 */
	public void setAngularLimits(List<Integer> angularLimits) {
		this.angularLimits = angularLimits;
	}

	/**
	 * @return Angular Separation for the node
	 */
	public List<Integer> getAngularLimits() {
		return angularLimits;
	}

	private int noOfDistricts;

	private List<Integer> regionLimits;

	private List<Integer> districtLimits;

	private List<Integer> angularLimits;

}
