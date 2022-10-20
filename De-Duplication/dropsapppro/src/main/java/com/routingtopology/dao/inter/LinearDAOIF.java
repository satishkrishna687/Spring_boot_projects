package com.routingtopology.dao.inter;

import java.util.List;

import com.routingtopology.exception.RoutingException;
import com.routingtopology.value.TopologyInfoValue;


public interface LinearDAOIF {

	/**
	 * @param topologyInfo
	 *            Topology Information for a Linear Network
	 * @return true if the insertion is successful
	 */
	public boolean insertLinearTopology(List<TopologyInfoValue> topologyInfo);

	/**
	 * @param topologyInfo
	 *            Topology Information for a Linear Network
	 * @return true if the insertion is successful
	 */
	public boolean updateLinearTopology(List<TopologyInfoValue> topologyInfo);

	/**
	 * @return topologyInfo Topology Information for a Linear Network
	 * @throws RoutingException 
	 */
	public List<TopologyInfoValue> retriveLinearTopology() throws RoutingException;
	
	/**
	 * @return true if Topology Information for a Linear Network is deleted else false
	 */
	public boolean deleteLinearTopology();

	/**
	 * @return records used  for angular topology
	 */
	public int retriveLinearTopologyCount();

}
