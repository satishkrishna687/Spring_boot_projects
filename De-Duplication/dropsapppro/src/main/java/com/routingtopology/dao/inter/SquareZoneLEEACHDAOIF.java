package com.routingtopology.dao.inter;

import java.util.List;

import com.routingtopology.exception.RoutingException;
import com.routingtopology.value.NodeInfoForSquare;
import com.routingtopology.value.TopologyInfoValue;

/**
 * This is the Zone DAO Object used for
 * zone formation. updation,deletion and fetching
 */
public interface SquareZoneLEEACHDAOIF {
	
	
	
	/**
	 * 
	 */
	public static final String RETRIVE_SQUARETOPOLOGY_LEEACH_COUNT="RETRIVE_SQUARETOPOLOGY_LEEACH_COUNT";
	
	/**
	 * 
	 */
	public static final String  RETRIVE_NODEIDS_WHO_ARE_ZONE_LEADERS_SQUARE_LEEACH_TOPOLOGY="RETRIVE_NODEIDS_WHO_ARE_ZONE_LEADERS_SQUARE_LEEACH_TOPOLOGY";
	/**
	 * 
	 */
	public static final String RETRIVE_NODEIDS_DETAILS_FOR_ZONEID_SQUARETOPOLOGY_LEEACH="RETRIVE_NODEIDS_DETAILS_FOR_ZONEID_SQUARETOPOLOGY_LEEACH";
	/**
	 * 
	 */
	public static final String UPDATE_ZONELEADER_FORNODEID_SQUARETOPOLOGY_LEEACH="UPDATE_ZONELEADER_FORNODEID_SQUARETOPOLOGY_LEEACH";
	/**
	 * 
	 */
	public static final String RETRIVE_ZONEIDSQUARETOPOLOGY_LEEACH="RETRIVE_ZONEIDSQUARETOPOLOGY_LEEACH";
	/**
	 * 
	 */
	public static final String UPDATE_SQUAREZONETOPOLOGY_LEEACH_QUERY="UPDATE_SQUAREZONETOPOLOGY_LEEACH_QUERY";
	/**
	 * 
	 */
	public static final String DELETE_SQUAREZONETOPOLOGY_LEEACH__QUERY="DELETE_SQUAREZONETOPOLOGY_LEEACH__QUERY";
	
	/**
	 * 
	 */
	public static final String INSERT_SQUAREZONETOPOLOGY_LEEACH_QUERY="INSERT_SQUAREZONETOPOLOGY_LEEACH_QUERY";
	
	/**
	 * 
	 */
	public static final String  RETRIVE_SQUARETOPOLOGY_LEEACH_QUERY="RETRIVE_SQUARETOPOLOGY_LEEACH_QUERY";
	
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
	
	
}
