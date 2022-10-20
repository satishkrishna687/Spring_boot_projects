package com.routingtopologyhelper.inter;

import java.util.List;

import com.routingtopology.value.TopologyCriteriaValue;
import com.routingtopology.value.TopologyInfoValue;

/**
 * @author 
 * 
 * This is the inteface used to generate a N*N random topolgy
 * 
 * N*N grid topology
 * 
 * N- Linear topology
 * 
 * N*N zone topology
 * 
 * Vertical topology
 *
 */
public interface TopologyGenerationIF {
	
	
	/**
	 * @param criteria for  finding the topology
	 * @return Topology Information for a Square  Network
	 */
	public List<TopologyInfoValue> getSquareTopology(TopologyCriteriaValue criteria);
	
	
	/**
	 * @param criteria for  finding the topology
	 * @return Topology Information for a Randomized Ad-Hoc Network
	 */
	public List<TopologyInfoValue> getRandomTopology(TopologyCriteriaValue criteria);
	
	/**
	 * @param criteria for  finding the topology
	 * @return Topology Information for a Grid Network
	 */
		
	public List<TopologyInfoValue> getGridTopology(TopologyCriteriaValue criteria);
	
	/**
	 * @param criteria
	 * @return Topology Information for a Linear Network
	 */
	public List<TopologyInfoValue> getLinearTopology(TopologyCriteriaValue criteria);
	
	/**
	 * @param criteria
	 * @return Topology Information for a Vertical Network
	 */
	public List<TopologyInfoValue> getVerticalTopology(TopologyCriteriaValue criteria);
	
	
	/**
	 * @param criteria
	 * @return topology information for a network with respect to angle of orientation
	 */
	public List<TopologyInfoValue> getAngularTopology(TopologyCriteriaValue criteria);
	
}
