package com.routingtopology.dao.inter;

import java.util.List;
import com.routingtopology.value.TopologyInfoValue;

/**
 * This is the interface used to form the routing tables
 * 
 */
public interface TopologyDAOIF {

	/**
	 * @param topologyInfoList
	 *            -This is the list containing the topology info
	 * @return true if the insertion is success
	 */

	public boolean insertGridTopology(List<TopologyInfoValue> topologyInfoList);

	/**
	 * @return Topology Information for a Grid Network
	 */
	public List<TopologyInfoValue> retriveGridTopology();

	/**
	 * @param topologyInfoValueList
	 *            Topology Information for a Grid Network
	 * @return true if the topology updation is successful
	 */
	public boolean updateGridTopology(
			List<TopologyInfoValue> topologyInfoValueList);

	/**
	 * @param topologyInfoList
	 *            Topology Information for a Vertical Network
	 * @return true if the insertion is successful otherwise return false
	 * */
	public boolean insertVerticalTopology(
			List<TopologyInfoValue> topologyInfoList);

	/**
	 * @param topologyInfoList
	 *            Topology Information for a Vertical Network
	 * @return true if the insertion is successful otherwise return false
	 */
	public boolean updateVerticalTopology(
			List<TopologyInfoValue> topologyInfoList);

	/**
	 * @return topologyInfoList Topology Information for a Vertical Network
	 */
	public List<TopologyInfoValue> retriveVerticalTopology();

	/**
	 * @return topology information for a network with respect to angle of
	 *         orientation
	 */
	public List<TopologyInfoValue> retriveAngularTopology();

	/**
	 * @param topologyInfoValueList
	 *            topology information for a network with respect to angle of
	 *            orientation
	 * @return true if successful insertion otherwise not
	 */
	public boolean insertAngularTopology(
			List<TopologyInfoValue> topologyInfoValueList);

	/**
	 * @param topologyInfoValueList
	 *            topology information for a network with respect to angle of
	 *            orientation
	 * @return true if successful updation otherwise not
	 */

	public boolean updateAngularTopology(
			List<TopologyInfoValue> topologyInfoValueList);

}
