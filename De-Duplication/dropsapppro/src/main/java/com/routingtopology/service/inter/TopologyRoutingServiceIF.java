package com.routingtopology.service.inter;

import java.util.List;

import com.routingtopology.value.NodeInfoForSquare;
import com.routingtopology.value.TopologyCriteriaValue;
import com.routingtopology.value.TopologyInfoValue;

/**
 * This is the interface used for topology generation and retrival
 * 
 */
public interface TopologyRoutingServiceIF {
	
	/**
	 * @param criteria
	 *            for finding the topology
	 * @return true if Topology Information for a Square Network is
	 *         sucessfully generated
	 */
	public boolean generateSquareTopologyAndStore(TopologyCriteriaValue criteria);
	
	/**
	 * @param criteria
	 *            for finding the topology
	 * @return true if Topology Information for a Square Network is
	 *         sucessfully generated
	 */
	public boolean generateSquareTopologyAndStoreLEEACH(TopologyCriteriaValue criteria);

	/**
	 * @param criteria
	 *            for finding the topology
	 * @return List of Topology Information for Square Network if
	 *         exists otherwise null
	 */
	public List<TopologyInfoValue> retriveSquareTopologyForView();
	
	
	/**
	 * @param criteria
	 *            for finding the topology
	 * @return List of Topology Information for Square Network if
	 *         exists otherwise null
	 */
	public List<TopologyInfoValue> retriveSquareTopologyForViewLEEACH();
	

	/**
	 * @return true if the topology is Square topology
	 */
	public boolean deleteSquareTopology();
	

	/**
	 * @return true if the topology is Square topology
	 */
	public boolean deleteSquareTopologyLEEACH();
	
	
	

	/**
	 * @param topologyInfoValueList
	 * @return true if topology updation is successful
	 */
	public boolean updateSquareTopology(
			List<TopologyInfoValue> topologyInfoValueList);
	
	

	/**
	 * @param topologyInfoValueList
	 * @return true if topology updation is successful
	 */
	public boolean updateSquareTopologyLEEACH(
			List<TopologyInfoValue> topologyInfoValueList);
	


	/**
	 * @param criteria
	 *            for finding the topology
	 * @return true if Topology Information for a Angular Ad-Hoc Network is
	 *         sucessfully generated
	 */
	public boolean generateAngularTopologyAndStore(TopologyCriteriaValue criteria);

	/**
	 * @param criteria
	 *            for finding the topology
	 * @return List of Topology Information for a Angular Ad-Hoc Network if
	 *         exists otherwise null
	 */
	public List<TopologyInfoValue> retriveAngularTopologyForView();

	/**
	 * @return true if the topology is random topology
	 */
	public boolean deleteAngularTopology();

	/**
	 * @param topologyInfoValueList
	 * @return true if topology updation is successful
	 */
	public boolean updateAngularTopology(
			List<TopologyInfoValue> topologyInfoValueList);

	

	/**
	 * @param criteria
	 *            for finding the topology
	 * @return true if Topology Information for a Randomized Ad-Hoc Network is
	 *         sucessfully generated
	 */
	public boolean generateRandomTopologyAndStore(TopologyCriteriaValue criteria);

	/**
	 * @param criteria
	 *            for finding the topology
	 * @return List of Topology Information for a Randomized Ad-Hoc Network if
	 *         exists otherwise null
	 */
	public List<TopologyInfoValue> retriveRandomTopologyForView();

	/**
	 * @return true if the topology is random topology
	 */
	public boolean deleteRandomTopology();

	/**
	 * @param topologyInfoValueList
	 * @return true if topology updation is successful
	 */
	public boolean updateRandomTopology(
			List<TopologyInfoValue> topologyInfoValueList);

	/**
	 * @param criteria
	 *            for finding the topology
	 * @return true if Topology Information for a Randomized Ad-Hoc Network is
	 *         sucessfully generated
	 */
	public boolean generateLinearTopologyAndStore(TopologyCriteriaValue criteria);

	/**
	 * @param criteria
	 *            for finding the topology
	 * @return List of Topology Information for a Randomized Ad-Hoc Network if
	 *         exists otherwise null
	 */
	public List<TopologyInfoValue> retriveLinearTopologyForView();

	/**
	 * @return true if the topology is random topology
	 */
	public boolean deleteLinearTopology();

	/**
	 * @param topologyInfoValueList
	 * @return true if topology updation is successful
	 */
	public boolean updateLinearTopology(
			List<TopologyInfoValue> topologyInfoValueList);

	/**
	 * @param criteria
	 *            for finding the topology
	 * @return true if Topology Information for a Grid Network is successful
	 *         otherwise return false
	 */

	public boolean generateGridTopologyAndStore(TopologyCriteriaValue criteria);

	/**
	 * @param criteria
	 *            for finding the topology
	 * @return List of Topology Information for a Grid Network if exists
	 *         otherwise null
	 */
	public List<TopologyInfoValue> retriveGridTopologyForView();
	
	/**
	 * @param topologyInfoValueList
	 * @return true if grid topology is successful otherwise return false
	 */
	public boolean updateGridTopology(
			List<TopologyInfoValue> topologyInfoValueList);


	/**
	 * @return true if the topology is grid topology
	 */
	public boolean deleteGridTopology();
	
	/**
	 * @param criteria
	 *            for finding the topology
	 * @return true if Topology Information for a Vertical Network is successful
	 *         otherwise return false
	 */

	public boolean generateVerticalTopologyAndStore(TopologyCriteriaValue criteria);

	/**
	 * @param criteria
	 *            for finding the topology
	 * @return List of Topology Information for a Vertical Network if exists
	 *         otherwise null
	 */
	public List<TopologyInfoValue> retriveVerticalTopologyForView();
	
	/**
	 * @param topologyInfoValueList
	 * @return true if Vertical topology is successful otherwise return false
	 */
	public boolean updateVerticalTopology(
			List<TopologyInfoValue> topologyInfoValueList);


	/**
	 * @return true if the topology is Vertical topology and gets deleted
	 */
	public boolean deleteVerticalTopology();
	

	/**
	 * @return records used  for angular topology
	 */
	public int retriveAngularTopologyCount();
	
	/**
	 * @return records used  for grid topology
	 */
	public int retriveGridTopologyCount();
	
	
	/**
	 * @return records used  for Linear topology
	 */
	public int retriveLinearTopologyCount();
	
	/**
	 * @return records used  for Random topology
	 */
	public int retriveRandomTopologyCount();

	/**
	 * @return records used  for Square topology
	 */
	public int retriveSquareZoneTopologyCount();
	
	/**
	 * @return records used  for Square topology
	 */
	public int retriveSquareZoneTopologyCountLEEACH();
	
	
	/**
	 * @return records used  for Vertical topology
	 */
	public int retriveVerticalTopologyCount();
	
	
	/**
	 * @return true if all nodes made false
	 */
	public boolean clearAllSquareZoneLeaderInfo();
	

	/**
	 * @return true if all nodes made false
	 */
	public boolean clearAllSquareZoneLeaderInfoLEEACH();
	
	
	/**
	 * @return List of Integer i.e distinct zone Ids
	 */
	public List<Integer> retriveDistinctZoneIDs();
	
	/**
	 * @return List of Integer i.e distinct zone Ids
	 */
	public List<Integer> retriveDistinctZoneIDsLEEACH();
	
	/**
	 * @param zoneId
	 * @param topologyType
	 * @return List of Nodes of a Particular Zone
	 */
	public List<NodeInfoForSquare> retriveNodeIdsForZoneId(int zoneId,String topologyType);
	

	/**
	 * @param nodeId
	 * @param leaderValue
	 * @return true if sucessdully updated
	 */
	public boolean updateNodeIdWithLeaderSquareZone(int nodeId,int leaderValue);
	
	/**
	 * @param nodeId
	 * @param leaderValue
	 * @return true if sucessdully updated
	 */
	public boolean updateNodeIdWithLeaderSquareZoneLEEACH(int nodeId,int leaderValue);
	/**
	 * @return List of Distinct Zone IDS
	 */
	public List<Integer> retriveDistinctZoneIDsForAngular();

	/**
	 * @return true if cleared
	 */
	public boolean clearAllAngularZoneLeaderInfo();

	/**
	 * @param zoneId
	 * @return Integer representing zone id of a Zone
	 */
	public int retriveZoneLeaderOfNodeForSquareZone(Integer zoneId);

	/**
	 * @param nodeId
	 * @return TopologyInfoValue
	 */
	public TopologyInfoValue retriveTopologyForNodeIdSquareTopology(int nodeId); 
	
}
