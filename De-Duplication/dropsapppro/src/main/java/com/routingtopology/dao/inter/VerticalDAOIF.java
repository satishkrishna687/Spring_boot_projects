package com.routingtopology.dao.inter;

import java.util.List;

import com.routingtopology.exception.RoutingException;
import com.routingtopology.value.TopologyInfoValue;

/**
 * This is the Vertical DAO which is responsible
 * for insertion, updation,deletion and fetching of
 * vertical topology
 * */
public interface VerticalDAOIF {
	
	/**
	 * @return true if all rows are successfully deleted otherwise it is false
	 */
	public boolean deleteVerticalTopology();

	/**
	 * @param topologyInfoValue
	 *            topology to insert the randomized topology
	 * @return true if the topology is successfully inserted otherwise
	 * @throws RoutingException
	 */
	public boolean insertVerticalTopology(
			List<TopologyInfoValue> topologyInfoValue) throws RoutingException;

	/**
	 * @param nodeId
	 * @return Topology Information for a Vertical Network
	 * @throws RoutingException
	 */
	public List<TopologyInfoValue> retriveVerticalTopology()
			throws RoutingException;

	/**
	 * @param topologyInfoValue
	 *            this is the topology information to be inserted
	 * @param nodeId
	 * @return Topology Information for a Vertical Network
	 */
	public boolean updateVerticalTopology(
			List<TopologyInfoValue> topologyInfoValue);


	/**
	 * @return records used  for angular topology
	 */
	public int retriveVerticalTopologyCount();
}
