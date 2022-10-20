package com.routingtopology.dao.inter;

import java.util.List;

import com.routingtopology.value.AngleBasedRoutingTable;
import com.routingtopology.value.ClusterHeads;
import com.routingtopology.value.NormalRoutingTable;
import com.routingtopology.value.VerticalRoutingTable;
import com.routingtopology.value.ZoneRoutingTable;

public interface RoutingTableDAOIF {

	/**
	 * @param tableName
	 * @param coverageDistance
	 * @return List of node ids
	 */
	public List<Integer> getNeigbours(String tableName, double coverageDistance);

	/**
	 * @param tableName
	 * @param zoneIdOfNode
	 * @return true if unwanted nodes are deleted
	 */
	public boolean deleteUnwantedNodeIds(String tableName, int zoneIdOfNode);

	/**
	 * @param tableName
	 * @param zoneIdOfNode
	 * @param zoneLeaderVal
	 * @return true if unwanted nodes deleted except zone leader
	 */
	public boolean deleteUnwantedNodeIdsForZoneLeader(String tableName,
			int zoneIdOfNode, int zoneLeaderVal);

	/**
	 * @param tableName
	 * @param nodeId
	 * @return Zone Leader of the node
	 */
	public int retriveZoneLeaderBasedOnNodeId(String tableName, int nodeId);

	/**
	 * @param tableName
	 * @param nodeId
	 * @return Zone id of the node
	 */
	public int retriveZoneIdBasedOnNodeId(String tableName, int nodeId);

	/**
	 * @param intermediateQuery
	 * @return List of Normal Routing Tables
	 */
	public List<NormalRoutingTable> retriveNormalRoutingTables(
			String intermediateQuery);

	/**
	 * @param intermediateQuery
	 * @return true if creation of table is sucessful
	 */
	public boolean createTable(String intermediateQuery);

	/**
	 * @param intermediateQuery
	 * @return true if creation of table is sucessful
	 */
	public boolean dropTable(String intermediateQuery);

	/**
	 * @param normalRoutingTable
	 * @param intermediateQuery
	 * @return true if insertion is sucessful
	 */
	public boolean insertRoutingTable(NormalRoutingTable normalRoutingTable,
			String intermediateQuery);

	/**
	 * @param normalRoutingTable
	 * @param intermediateQuery
	 * @return true if insertion is sucessful
	 */
	public boolean updateRoutingTable(NormalRoutingTable normalRoutingTable,
			String intermediateQuery);

	/**
	 * @param intermediateQuery
	 * @return Routing Table based on Zone
	 */
	public List<AngleBasedRoutingTable> retriveAngleBasedRoutingTables(
			String intermediateQuery);

	/**
	 * @param intermediateQuery
	 * @return true if creation of table is sucessful
	 */
	public boolean createTableAngleBased(String intermediateQuery);

	/**
	 * @param intermediateQuery
	 * @return true if creation of table is sucessful
	 */
	public boolean dropTableAngleBased(String intermediateQuery);

	/**
	 * @param angleRoutingTable
	 * @param intermediateQuery
	 * @return true if insertion is sucessful
	 */
	public boolean insertRoutingTableAngleBased(
			AngleBasedRoutingTable angleRoutingTable, String intermediateQuery);

	/**
	 * @param angleRoutingTable
	 * @param intermediateQuery
	 * @return true if insertion is sucessful
	 */
	public boolean updateRoutingTableAngleBased(
			AngleBasedRoutingTable angleRoutingTable, String intermediateQuery);

	/**
	 * @param intermediateQuery
	 * @return Routing Table based on Zone
	 */
	public List<ZoneRoutingTable> retriveZoneBasedRoutingTables(
			String intermediateQuery);

	/**
	 * @param intermediateQuery
	 * @return true if creation of table is sucessful
	 */
	public boolean createTableZoneBased(String intermediateQuery);

	/**
	 * @param intermediateQuery
	 * @return true if creation of table is sucessful
	 */
	public boolean createTableVerticalBased(String intermediateQuery);

	/**
	 * @param intermediateQuery
	 * @return true if creation of table is sucessful
	 */
	public boolean dropTableZoneBased(String intermediateQuery);

	/**
	 * @param zoneRoutingTable
	 * @param intermediateQuery
	 * @return true if insertion is sucessful
	 */
	public boolean insertRoutingTableZoneBased(
			ZoneRoutingTable zoneRoutingTable, String intermediateQuery);

	/**
	 * @param zoneRoutingTable
	 * @param intermediateQuery
	 * @return true if insertion is sucessful
	 */
	public boolean updateRoutingTableZoneBased(
			ZoneRoutingTable zoneRoutingTable, String intermediateQuery);

	/**
	 * @param tableToDelete
	 * @return true
	 */
	public boolean deleteRoutingTable(String tableToDelete);

	/**
	 * @param verticalRoutingTable
	 * @param intermediateQuery
	 * @return true if inserted sucessfuly
	 */
	public boolean insertVerticalRoutingTable(
			VerticalRoutingTable verticalRoutingTable, String intermediateQuery);

	/**
	 * @param normalRoutingTable
	 * @param intermediateQuery
	 * @return true if updation of vertical topology is sucessfully
	 */
	public boolean updateVerticalRoutingTable(
			VerticalRoutingTable normalRoutingTable, String intermediateQuery);

	/**
	 * @param intermediateQuery
	 * @return List of Vertical Routing Table
	 */
	public List<VerticalRoutingTable> retriveVerticalRoutingTables(
			String intermediateQuery);

	/**
	 * @param tableToDelete
	 * @param nodeIdWhichToDelete
	 * @return true if sucessdul deletion otherwise false
	 */
	public boolean deleteFromRoutingTable(String tableToDelete,
			int nodeIdWhichToDelete);

	/**
	 * @param tableName
	 * @param zoneId
	 * @param zoneLeaderFlag
	 * @return zone leader of zone
	 */
	public int findZoneLeaderOfZone(String tableName, int zoneId,
			int zoneLeaderFlag);

	/**
	 * @param tableName
	 * @param zoneId
	 * @param zoneLeaderFlag
	 * @return List of node ids
	 */
	public List<ClusterHeads> retriveClusterHeads(String tableName, int zoneId,
			int zoneLeaderFlag);

	/**
	 * @param string
	 * @param sourceNode
	 * @return List<Integer> nodes in the zone
	 */
	public List<Integer> retriveNodesInZone(String string, int sourceNode);

	/**
	 * @param tableName
	 * @param zoneId
	 * @param sourceNode
	 * @return List of nodes of a zone
	 */
	List<Integer> retriveNodesInZoneUsingZoneLeaderAndZoneId(String tableName,
			int zoneId, int sourceNode);

	/**
	 * @param string
	 * @param zoneLeaderNode
	 * @param destinationNode
	 * @return List of nodes aprt from zone leader node and destination node
	 */
	public List<Integer> obtainNodesApartFromZoneLeaderAndDestNode(
			String string, int zoneLeaderNode, int destinationNode);

	/**
	 * @param tableName
	 * @param nodeId
	 * @return distance between nodes
	 */
	public double distanceBetweenNodes(String tableName, int nodeId);

	/**
	 * @param zoneId
	 * @param sourceNode
	 * @param obsSite
	 * @param tableName
	 * @param zoneLeaderOfNode
	 * @return List of nodes which are not closer to obstracle
	 */
	public List<Integer> retriveNodesApartFromSNZLAndSNAndNonObs(String tableName,
			int zoneId, int sourceNode, int obsSite, int zoneLeaderOfNode);

	/**
	 * @param tableName
	 * @param nodeId
	 * @return angular oreintation
	 */
	public int retriveAngleBasedOnNodeId(String tableName, Integer nodeId);

}
