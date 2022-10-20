package com.routingtopology.service.inter;

import java.util.List;

import com.routingtopology.constants.RoutingServiceConstantsIF;
import com.routingtopology.constants.RoutingTableConstantsIF;
import com.routingtopology.value.AngleBasedRoutingTable;
import com.routingtopology.value.ClusterHeads;
import com.routingtopology.value.NormalRoutingTable;
import com.routingtopology.value.VerticalRoutingTable;
import com.routingtopology.value.ZoneRoutingTable;

/**
 * This is the routing table service
 * 
 */
public interface RoutingTableServiceIF extends RoutingServiceConstantsIF {

	
	
	/**
	 * @return true if reading from topology and inserting tables is sucess
	 */
	public boolean insertRoutingTableZoneBasedForLEEACH();
	/**
	 * 
	 * @param nodeId
	 * @param topologyType
	 * @return List of Normal Routing Tables
	 */
	public List<NormalRoutingTable> retriveNormalRoutingTables(int nodeId,
			String topologyType);

	/**
	 * @param topologyKey
	 * @return true if creation of table is sucessful
	 */
	public boolean createTable(String topologyKey);

	/**
	 * @param topologyType
	 * @return true if creation of table is sucessful
	 */
	public boolean dropTable(String topologyType);

	/**
	 * @param topologyType
	 * @return true if insertion is sucessful
	 */
	public boolean insertRoutingTable(String topologyType);

	/**
	 * @param normalRoutingTable
	 * @param nodeIdOfRoutingTable
	 * @param topologyType
	 * @return true if insertion is sucessful
	 */
	public boolean updateRoutingTable(NormalRoutingTable normalRoutingTable,
			int nodeIdOfRoutingTable, String topologyType);

	/**
	 * @param nodeId
	 * @return Routing Table based on Zone
	 */
	public List<AngleBasedRoutingTable> retriveAngleBasedRoutingTables(
			int nodeId);

	/**
	 * @return true if insertion is sucessful
	 */
	public boolean insertRoutingTableAngleBased();

	/**
	 * @param angleRoutingTable
	 * @param routingTableNodeId
	 * @return true if insertion is sucessful
	 */
	public boolean updateRoutingTableAngleBased(
			AngleBasedRoutingTable angleRoutingTable, int routingTableNodeId);

	/**
	 * @param angleRoutingTable
	 * @param routingTableNodeId
	 * @return true if insertion is sucessful
	 */
	public boolean updateRoutingTableVerticalBased(
			VerticalRoutingTable angleRoutingTable, int routingTableNodeId);

	/**
	 * @param nodeId
	 * @return Routing Table based on Zone
	 */
	public List<ZoneRoutingTable> retriveZoneBasedRoutingTables(int nodeId);

	/**
	 * @param nodeId
	 * @return Routing Table based on Zone
	 */
	public List<VerticalRoutingTable> retriveVerticalRoutingTables(int nodeId);

	/**
	 * @param zoneRoutingTable
	 * @return true if insertion is sucessful
	 */
	public boolean insertRoutingTableZoneBased();

	/**
	 * @param zoneRoutingTable
	 * @param routingTableNodeId
	 * @return true if insertion is sucessful
	 */
	public boolean updateRoutingTableZoneBased(
			ZoneRoutingTable zoneRoutingTable, int routingTableNodeId);
	
	/**
	 * @param zoneRoutingTable
	 * @param routingTableNodeId
	 * @return true if insertion is sucessful
	 */
	public boolean updateRoutingTableZoneBasedLEEACH(
			ZoneRoutingTable zoneRoutingTable, int routingTableNodeId);

	/**
	 * @param topologyType
	 * @param nodeIdRoutingTable
	 * @return true
	 */
	public boolean deleteRoutingTable(String topologyType,
			int nodeIdRoutingTable);

	/**
	 * @param nodeId
	 * @return zone id of node
	 */
	public int retriveZoneIdBasedOnNodeId(int nodeId);
	
	/**
	 * @param nodeId
	 * @return zone id of node
	 */
	public int retriveZoneIdBasedOnNodeIdLEEACH(int nodeId);

	/**
	 * @param sourceNode
	 * @param zoneId 
	 * @return zone Leader of node
	 */
	public int retriveZoneLeaderOfNode(int sourceNode,int zoneId);
	
	/**
	 * @param sourceNode
	 * @param zoneId 
	 * @return zone Leader of node
	 */
	public int retriveZoneLeaderOfNodeLEEACH(int sourceNode,int zoneId);

	/**
	 * @param sourceNode
	 * @return zone leader id of the node
	 */
	public int issourceNodeZoneLeaderLEEACH(int sourceNode);

	/**
	 * @param topologyType
	 * @param nodeId
	 * @param coverageDistance
	 * @return List of coverage area nodes*/
	public List<Integer> getNeigbours(String topologyType, int nodeId,
			double coverageDistance);

	/**
	 * @param zoneId
	 * @param zoneLeaderOfSourceNode
	 * @return List of nodes
	 */
	public List<ClusterHeads> getClusterHeadsOfAllZones(int zoneId,
			int zoneLeaderOfSourceNode);
	
	
	/**
	 * @param zoneId
	 * @param zoneLeaderOfSourceNode
	 * @return List of nodes
	 */
	public List<ClusterHeads> getClusterHeadsOfAllZonesLEEACH(int zoneId,
			int zoneLeaderOfSourceNode);

	/**
	 * @param sourceNode
	 * @return List of nodes in the zone
	 */
	public List<Integer> retriveNodesInZone(int sourceNode);
	
	/**
	 * @param sourceNode
	 * @return List of nodes in the zone
	 */
	public List<Integer> retriveNodesInZoneLEEACH(int sourceNode);
	

	/**
	 * @param clusterHead
	 * @return List of nodes which are normal excluding zone leaders
	 */
	public List<Integer> retriveNodesInZoneUsingZoneLeader(
			ClusterHeads clusterHead);
	
	

	/**
	 * @param clusterHead
	 * @return List of nodes which are normal excluding zone leaders
	 */
	public List<Integer> retriveNodesInZoneUsingZoneLeaderLEEACH(
			ClusterHeads clusterHead);

	/**
	 * @param zoneId
	 * @param zoneLeaderNode
	 * @param destinationNode
	 * @return List of nodes apart from zone leader node and destination node
	 */
	public List<Integer> obtainNodesApartFromZoneLeaderAndDestNode(int zoneId,
			int zoneLeaderNode, int destinationNode);

	
	/**
	 * @param zoneId
	 * @param zoneLeaderNode
	 * @param destinationNode
	 * @return List of nodes apart from zone leader node and destination node
	 */
	public List<Integer> obtainNodesApartFromZoneLeaderAndDestNodeLEEACH(int zoneId,
			int zoneLeaderNode, int destinationNode);
	/**
	 * @param tableFromWhichToGet
	 * @param nodeIdWhereClause
	 * @param topologyType
	 * @return Distance from current node to next node
	 */
	public double distance(int tableFromWhichToGet, int nodeIdWhereClause,
			String topologyType);
	/**
	 * @param nodeId
	 * @return zone id for a node id
	 */
	public int retriveZoneIdBasedOnNodeIdForAngular(int nodeId);
	/**
	 * @param sourceNode
	 * @return zone leader id of the node
	 */
	public int issourceNodeZoneLeader(int sourceNode);
	/**
	 * @param sourceNode
	 * @return List of Nodes of Angular
	 */
	List<Integer> retriveNodesInZoneForAngular(int sourceNode);

	/**
	 * @param sourceNode
	 * @param zoneId
	 * @return zone leader of angular
	 */
	public int retriveZoneLeaderOfNodeForAngular(int sourceNode, int zoneId);

	/**
	 * @param zoneId
	 * @param zoneLeaderOfSourceNode
	 * @return List of Cluster Heads
	 */
	public List<ClusterHeads> getClusterHeadsOfAllZonesForAngular(int zoneId,
			int zoneLeaderOfSourceNode);

	/**
	 * @param clusterHead
	 * @return List of Cluster Heads
	 */
	public List<Integer> retriveNodesInZoneUsingZoneLeaderForAngular(
			ClusterHeads clusterHead);

	/**
	 * @param zoneLeaderOfSourceNode
	 * @param zoneId
	 * @param sourceNode
	 * @param obsSite 
	 * @return List of nodes which is not closer to obs site and is not zone leader and source node
	 */
	public List<Integer> retriveNodesApartFromSNZLAndSNAndNonObs(
			int zoneLeaderOfSourceNode, int zoneId, int sourceNode,int obsSite);
	/**
	 * @param nodeId
	 * @return Angle of Oreintation of Node
	 */
	public int getAngleOfNode(Integer nodeId);
	
	 /**
	 * @param nodeId
	 * @return List<ZoneRoutingTable> for a given node id
	 */
	public List<ZoneRoutingTable> retriveZoneBasedRoutingTablesForLEEACH(int nodeId);

		/**
	 * @param sourceNode
	 * @return source node zone leader
	 */
	public int issourceNodeZoneLeaderForAngular(int sourceNode);

	

}
