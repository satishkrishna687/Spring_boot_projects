package com.routingtopology.value;


public class  RCERRouteValue {
	
	
	
	private int zoneId;
	
	/**
	 * @return Zone ID of the Zone
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
	 * @return Node ID of the Node
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
	 * @return true if the Node is a Relay Node
	 */
	public boolean isRelayNode() {
		return isRelayNode;
	}

	/**
	 * @param isRelayNode
	 */
	public void setRelayNode(boolean isRelayNode) {
		this.isRelayNode = isRelayNode;
	}

	/**
	 * @return true if it is a Back Up Node
	 */
	public boolean isBackUpNode() {
		return isBackUpNode;
	}

	/**
	 * @param isBackUpNode
	 */
	public void setBackUpNode(boolean isBackUpNode) {
		this.isBackUpNode = isBackUpNode;
	}

	/**
	 * @return true if it is Cluster Head1
	 */
	public boolean isClusterHead1() {
		return isClusterHead1;
	}

	/**
	 * @param isClusterHead1
	 */
	public void setClusterHead1(boolean isClusterHead1) {
		this.isClusterHead1 = isClusterHead1;
	}

	/**
	 * @return Cluster Head2
	 */
	public boolean isClusterHead2() {
		return isClusterHead2;
	}

	/**
	 * @param isClusterHead2
	 */
	public void setClusterHead2(boolean isClusterHead2) {
		this.isClusterHead2 = isClusterHead2;
	}

	private int nodeId;
	
	private boolean isRelayNode;
	
	private boolean isBackUpNode;
	
	private boolean isClusterHead1;
	
	private boolean isClusterHead2;
}
