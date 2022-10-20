package com.routingtopology.value;



/**
 *  * 
 *
 */
public class TopologyInfoValue {
	
	
private CentreCordinate centreCordinates;
	
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

	
	private int nodeId;
	
	
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
	 * @return parameters of the node
	 */
	public NodeParameters getNodeParameters() {
		return nodeParameters;
	}

	/**
	 * @param nodeId
	 */
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	/**
	 * @return id of the node
	 */
	public int getNodeId() {
		return nodeId;
	}

	
	/**
	 * @param centreCordinates
	 */
	public void setCentreCordinates(CentreCordinate centreCordinates) {
		this.centreCordinates = centreCordinates;
	}

	/**
	 * @return Centre Cordinate of zone
	 */
	public CentreCordinate getCentreCordinates() {
		return centreCordinates;
	}


	private NodeParameters  nodeParameters;
	
	private LeaderInfoValue leaderInfo;
	
	private ZoneInformationValue zoneInformation;
	
	private int noOfNodes;
	
	private int noOfVerticals;
	
	private Context context;
	
	private GridInfo gridInfo;
	
}
