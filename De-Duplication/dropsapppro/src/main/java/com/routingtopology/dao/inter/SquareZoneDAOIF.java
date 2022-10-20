package com.routingtopology.dao.inter;

import java.util.List;

import com.routingtopology.exception.RoutingException;
import com.routingtopology.value.NodeInfoForSquare;
import com.routingtopology.value.TopologyInfoValue;

/**
 * This is the Zone DAO Object used for
 * zone formation. updation,deletion and fetching
 */
public interface SquareZoneDAOIF {
	
	
	/**
	 * @return true if all rows are successfully deleted otherwise it is false
	 */
	public boolean deleteSquareZoneTopology();

	/**
	 * @param topologyInfoValue
	 *            topology to insert the Square Zone topology
	 * @return true if the topology is successfully inserted otherwise
	 * @throws RoutingException
	 */
	public boolean insertSquareZoneTopology(
			List<TopologyInfoValue> topologyInfoValue) throws RoutingException;

	/**
	 * @param nodeId
	 * @return Topology Information for a Square Zone Network
	 * @throws RoutingException
	 */
	public List<TopologyInfoValue> retriveSquareZoneTopology()
			throws RoutingException;

	/**
	 * @param topologyInfoValue
	 *            this is the topology information to be inserted
	 * @param nodeId
	 * @return Topology Information for a Square Zone Network
	 */
	public boolean updateSquareZoneTopology(
			List<TopologyInfoValue> topologyInfoValue);
	
	/**
	 * @return List of Zone Ids in which nodes are spread
	 */
	public List<Integer> retriveDistinctSquareZoneIds();
	
	
	/**
	 * @param zoneId  Zone Id 
	 * @return List of Node Ids present in a zone
	 */
	public List<NodeInfoForSquare> retriveNodeInfoForZoneIDSquareZone(int zoneId);
	
	/**
	 * @param nodeId
	 * @param leaderValue
	 * @return true if sucessdully updated
	 */
	public boolean updateNodeIdWithLeaderSquareZone(int nodeId,int leaderValue);

	/**
	 * @return records used  for angular topology
	 */
	public int retriveSquareZoneTopologyCount();
	
	
	/**
	 * @return List of node ids acting as zone leaders
	 */
	public List<Integer> retriveZoneLeaders();

	/**
	 * @param zoneId
	 * @return Zone Leader of the Zone
	 */
	public int retriveZoneLeaderForZoneId(Integer zoneId);

	/**
	 * @param nodeId
	 * @return TopologyInfoValue Object
	 */
	public TopologyInfoValue retriveTopologyForNodeIdSquareTopology(int nodeId);  
	
	
}
