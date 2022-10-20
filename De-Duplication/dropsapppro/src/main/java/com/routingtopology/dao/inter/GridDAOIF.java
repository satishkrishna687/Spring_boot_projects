package com.routingtopology.dao.inter;

import java.util.List;

import com.routingtopology.exception.RoutingException;
import com.routingtopology.value.TopologyInfoValue;

/**
 * The GridDAOIF is the DAO is used
 * for insert,update,delete and select
 *
 */
public interface GridDAOIF {
	
	/**
	 * @return true if all rows are successfully deleted otherwise it is false
	 */
	public boolean deleteGridTopology();

	/**
	 * @param topologyInfoValue
	 *            topology to insert the randomized topology
	 * @return true if the topology is successfully inserted otherwise
	 * @throws RoutingException
	 */
	public boolean insertGridTopology(
			List<TopologyInfoValue> topologyInfoValue) throws RoutingException;

	/**
	 * @param nodeId
	 * @return Topology Information for a Randomized Ad-Hoc Network
	 * @throws RoutingException
	 */
	public List<TopologyInfoValue> retriveGridTopology()
			throws RoutingException;

	/**
	 * @param topologyInfoValue
	 *            this is the topology information to be inserted
	 * @param nodeId
	 * @return Topology Information for a Randomized Ad-Hoc Network
	 */
	public boolean updateGridTopology(
			List<TopologyInfoValue> topologyInfoValue);
	
	/**
	 * @return records used  for angular topology
	 */
	public int retriveGridTopologyCount();
	
}
