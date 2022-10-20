package com.routingtopology.value;

/**
 * This is the vaablelue object for zone based routing table
 * */
public class AngleBasedRoutingTable {

	private int nodeId;

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

	/**
	 * @param angularPos
	 */
	public void setAngularPos(int angularPos) {
		this.angularPos = angularPos;
	}

	/**
	 * @return angular position
	 */
	public int getAngularPos() {
		return angularPos;
	}

	/**
	 * @param closeToObs
	 */
	public void setCloseToObs(int closeToObs) {
		this.closeToObs = closeToObs;
	}

	/**
	 * @return close to which obstracle
	 */
	public int getCloseToObs() {
		return closeToObs;
	}

	private boolean zoneLeader;

	private int angularPos;
	
	private int closeToObs;

}
