package com.routingtopology.dao.inter;

import java.util.List;

import com.routingtopology.exception.RoutingException;
import com.routingtopology.value.TopologyInfoValue;

/**
 * This is the Angular DAO Implementation
 *for formation of the network into angular form
 */
public interface AngularDAOIF {
	
	/**
	 * @return true if all rows are successfully deleted otherwise it is false
	 */
	public boolean deleteAngularTopology();

	/**
	 * @param topologyInfoValue
	 *            topology to insert the randomized topology
	 * @return true if the topology is successfully inserted otherwise
	 * @throws RoutingException
	 */
	public boolean insertAngularTopology(
			List<TopologyInfoValue> topologyInfoValue) throws RoutingException;

	/**
	 * @param nodeId
	 * @return Topology Information for a Randomized Ad-Hoc Network
	 * @throws RoutingException
	 */
	public List<TopologyInfoValue> retriveAngularTopology()
			throws RoutingException;

	/**
	 * @param topologyInfoValue
	 *            this is the topology information to be inserted
	 * @param nodeId
	 * @return Topology Information for a Randomized Ad-Hoc Network
	 */
	public boolean updateAngularTopology(
			List<TopologyInfoValue> topologyInfoValue);

	/**
	 * @return List of Zone Ids in which nodes are spread
	 */
	public List<Integer> retriveDistinctZoneIds();
	
	
	/**
	 * @param zoneId  Zone Id 
	 * @return List of Node Ids present in a zone
	 */
	public List<Integer> retriveNodeIdsForZoneID(int zoneId);
	
	/**
	 * @param nodeId
	 * @param leaderValue
	 * @return true if sucessdully updated
	 */
	public boolean updateNodeIdWithLeader(int nodeId,int leaderValue);
	
	
	/**
	 * @return records used  for angular topology
	 */
	public int retriveAngularTopologyCount();
	/**
	 * @return List of Zone IDS
	 */
	public List<Integer> retriveDistinctZoneIDsForAngular();

	/**
	 * @return List of Zone Leaders
	 */
	public List<Integer> retriveZoneLeadersForAngular();

	/**
	 * @param nodeId
	 * @param notZoneleader
	 * @return true if all updates of leaders as false
	 */
	public boolean updateNodeIdWithLeaderAngularZone(Integer nodeId,
			int notZoneleader);
	
}
