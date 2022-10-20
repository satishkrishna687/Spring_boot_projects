package com.routingtopology.value;

import java.util.List;

/**
 * This java class is responsible for setting the criteria for the topology
 * generation
 * 
 */
public class TopologyCriteriaValue {
	
	
	
	private List<Integer> horizontalEndPoints;
	
	/**
	 * @return number of horizontal end points
	 */
	public List<Integer> getHorizontalEndPoints() {
		return horizontalEndPoints;
	}

	/**
	 * @param horizontalEndPoints
	 */
	public void setHorizontalEndPoints(List<Integer> horizontalEndPoints) {
		this.horizontalEndPoints = horizontalEndPoints;
	}

	/** 
	 * @return number of vertical end points
	 */
	public List<Integer> getVerticalEndPoints() {
		return verticalEndPoints;
	}

	/**
	 * @param verticalEndPoints
	 */
	public void setVerticalEndPoints(List<Integer> verticalEndPoints) {
		this.verticalEndPoints = verticalEndPoints;
	}

	private List<Integer> verticalEndPoints;
	
	private List<Integer> noOfNodesPerZone;
	
	private double intialSignalStrength;

	private List<Integer> noOfNodesInEachAngularRegion;

	private List<Integer> angularEndPoints;

	private List<Integer> noOfNodesInEachVertical;

	private List<Integer> verticalLinesPoints;

	private int minXCordinate;

	/**
	 * @return minimum value of x coordinate
	 */
	public int getMinXCordinate() {
		return minXCordinate;
	}

	/**
	 * @param minXCordinate
	 */
	public void setMinXCordinate(int minXCordinate) {
		this.minXCordinate = minXCordinate;
	}

	/**
	 * @return minimum y coordinate
	 */
	public int getMinYCordinate() {
		return minYCordinate;
	}

	/**
	 * @param minYCordinate
	 */
	public void setMinYCordinate(int minYCordinate) {
		this.minYCordinate = minYCordinate;
	}

	private int minYCordinate;

	private int maxXCordinate;

	/**
	 * @return maximum value of x cordinate
	 */
	public int getMaxXCordinate() {
		return maxXCordinate;
	}

	/**
	 * @param maxXCordinate
	 */
	public void setMaxXCordinate(int maxXCordinate) {
		this.maxXCordinate = maxXCordinate;
	}

	/**
	 * @return maximum value of y- coordinate
	 */
	public int getMaxYCordinate() {
		return maxYCordinate;
	}

	/**
	 * @param maxYCordinate
	 */
	public void setMaxYCordinate(int maxYCordinate) {
		this.maxYCordinate = maxYCordinate;
	}

	private int maxYCordinate;

	private int distanceBetweenNodes;

	private NodeCordinateValue nodeCoordiante;

	/**
	 * @return Node Positions
	 */
	public NodeCordinateValue getNodeCoordiante() {
		return nodeCoordiante;
	}

	/**
	 * @param nodeCoordiante
	 */
	public void setNodeCoordiante(NodeCordinateValue nodeCoordiante) {
		this.nodeCoordiante = nodeCoordiante;
	}

	/**
	 * @return Zone Leader Information or Cluster Head Information
	 */
	public LeaderInfoValue getLeaderInfo() {
		return leaderInfo;
	}

	/**
	 * @param leaderInfo
	 */
	public void setLeaderInfo(LeaderInfoValue leaderInfo) {
		this.leaderInfo = leaderInfo;
	}

	/**
	 * @return Zone Information
	 */
	public ZoneInformationValue getZoneInformation() {
		return zoneInformation;
	}

	/**
	 * @param zoneInformation
	 */
	public void setZoneInformation(ZoneInformationValue zoneInformation) {
		this.zoneInformation = zoneInformation;
	}

	/**
	 * @param noOfNodes
	 */
	public void setNoOfNodes(int noOfNodes) {
		this.noOfNodes = noOfNodes;
	}

	/**
	 * @return No of nodes
	 */
	public int getNoOfNodes() {
		return noOfNodes;
	}

	/**
	 * @param noOfVerticals
	 */
	public void setNoOfVerticals(int noOfVerticals) {
		this.noOfVerticals = noOfVerticals;
	}

	/**
	 * @return number of verticals
	 */
	public int getNoOfVerticals() {
		return noOfVerticals;
	}

	/**
	 * @param context
	 */
	public void setContext(Context context) {
		this.context = context;
	}

	/**
	 * @return Context
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * @param gridInfo
	 */
	public void setGridInfo(GridInfo gridInfo) {
		this.gridInfo = gridInfo;
	}

	/**
	 * @return Information of the grid info of a node
	 */
	public GridInfo getGridInfo() {
		return gridInfo;
	}

	/**
	 * @param nodeParameters
	 */
	public void setNodeParameters(NodeParameters nodeParameters) {
		this.nodeParameters = nodeParameters;
	}

	/**
	 * @return NodeParameters which contains information about the battery power
	 *         and energy remain of the node
	 */
	public NodeParameters getNodeParameters() {
		return nodeParameters;
	}

	/**
	 * @param distanceBetweenNodes
	 */
	public void setDistanceBetweenNodes(int distanceBetweenNodes) {
		this.distanceBetweenNodes = distanceBetweenNodes;
	}

	/**
	 * @return the disatnce between the nodes
	 */
	public int getDistanceBetweenNodes() {
		return distanceBetweenNodes;
	}

	/**
	 * @param verticalLinesPoints
	 */
	public void setVerticalLinesPoints(List<Integer> verticalLinesPoints) {
		this.verticalLinesPoints = verticalLinesPoints;
	}

	/**
	 * @return List f vertical end points
	 */
	public List<Integer> getVerticalLinesPoints() {
		return verticalLinesPoints;
	}

	/**
	 * @param noOfNodesInEachVertical
	 */
	public void setNoOfNodesInEachVertical(List<Integer> noOfNodesInEachVertical) {
		this.noOfNodesInEachVertical = noOfNodesInEachVertical;
	}

	/**
	 * @return number of nodes in each vertical
	 */
	public List<Integer> getNoOfNodesInEachVertical() {
		return noOfNodesInEachVertical;
	}

	/**
	 * @param angularEndPoints
	 */
	public void setAngularEndPoints(List<Integer> angularEndPoints) {
		this.angularEndPoints = angularEndPoints;
	}

	/**
	 * @return Angular End points used by angular topology
	 */
	public List<Integer> getAngularEndPoints() {
		return angularEndPoints;
	}

	/**
	 * @param noOfNodesInEachAngularRegion
	 */
	public void setNoOfNodesInEachAngularRegion(
			List<Integer> noOfNodesInEachAngularRegion) {
		this.noOfNodesInEachAngularRegion = noOfNodesInEachAngularRegion;
	}

	/**
	 * @return No of nodes in each of the angular region
	 */
	public List<Integer> getNoOfNodesInEachAngularRegion() {
		return noOfNodesInEachAngularRegion;
	}

	/**
	 * @param intialSignalStrength
	 */
	public void setIntialSignalStrength(double intialSignalStrength) {
		this.intialSignalStrength = intialSignalStrength;
	}

	/**
	 * @return Initial Signal Strength for all nodes in angular topology
	 */
	public double getIntialSignalStrength() {
		return intialSignalStrength;
	}

	/**
	 * @param noOfNodesPerZone
	 */
	public void setNoOfNodesPerZone(List<Integer> noOfNodesPerZone) {
		this.noOfNodesPerZone = noOfNodesPerZone;
	}

	/**
	 * @return number of nodes in each zone
	 */
	public List<Integer> getNoOfNodesPerZone() {
		return noOfNodesPerZone;
	}

	/**
	 * @param noOfZones
	 */
	public void setNoOfZones(int noOfZones) {
		this.noOfZones = noOfZones;
	}

	/**
	 * @return no of zones
	 */
	public int getNoOfZones() {
		return noOfZones;
	}

	private NodeParameters nodeParameters;
	private LeaderInfoValue leaderInfo;
	private ZoneInformationValue zoneInformation;
	private int noOfNodes;
	private int noOfVerticals;
	private Context context;
	private GridInfo gridInfo;

	private int noOfZones;
}
