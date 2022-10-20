package com.routingtopology.value;

/**
 * This is the vaablelue object for zone based routing 
 * table
 * */
public class ZoneRoutingTable extends NormalRoutingTable {
	
	private int zoneId;
	
	/**
	 * @return Zone id of the zone
	 */
	public int getZoneId() {
		return zoneId;
	}

	/**
	 * @param zoneId
	 */
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	/**
	 * @return Zone Leader of the zone
	 */
	public boolean isZoneLeader() {
		return zoneLeader;
	}

	/**
	 * @param zoneLeader
	 */
	public void setZoneLeader(boolean zoneLeader) {
		this.zoneLeader = zoneLeader;
	}

	private boolean zoneLeader;

}
