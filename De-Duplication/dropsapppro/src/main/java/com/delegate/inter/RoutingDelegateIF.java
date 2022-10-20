package com.delegate.inter;

import java.util.List;

import com.model.CompareOptimizedInfo;
import com.dropsapppro.storageobjects.UserInfoRouteSession;
import com.model.CompareEnergy;
import com.model.CompareHops;
import com.model.CompareLifeTimeRatio;
import com.model.CompareNoOfAliveNodes;
import com.model.CompareNoOfDeadNodes;
import com.model.ComparePower;
import com.model.CompareResidualEnergy;
import com.model.CompareRoutingOverhead;
import com.model.CompareThroughput;
import com.model.CompareTime;
import com.model.EEDRModel;
import com.model.Energy;
import com.model.FaultNodeTopologyView;
import com.model.IPAdressVO;
import com.model.NodeId;
import com.model.Power;
import com.model.StatusInfo;
import com.routingtopology.value.NormalRoutingTable;
import com.routingtopology.value.PerformanceAliveNodes;
import com.routingtopology.value.PerformanceDeadNodes;
import com.routingtopology.value.PerformanceEnergy;
import com.routingtopology.value.PerformanceHops;
import com.routingtopology.value.PerformancePower;
import com.routingtopology.value.PerformanceTimeTaken;
import com.routingtopology.value.TopologyCriteriaValue;

/**
 * This is the ACO Inteface
 * 
 */
public interface RoutingDelegateIF {
	
	 static final long MEGABYTE = 1024L * 1024L;

	/**
	 * @return List of Compare Power
	 */
	public List<ComparePower> retrivePowerComparison();

	/**
	 * @return List of Energy
	 */
	public List<CompareEnergy> retriveEnergyComparison();

	/**
	 * @return List of Time
	 */
	public List<CompareTime> retriveTimeComparison();

	/**
	 * @param criteria
	 * @param topologyType
	 * @return true if topology sucessfully generated otherwise false
	 */
	public boolean createFaultNodeTopologyAndStore(TopologyCriteriaValue criteria, String topologyType);

	/**
	 * @param topologyType
	 * @return List of PEEBR Topology information
	 */
	public List<FaultNodeTopologyView> retriveFaultNodeTopology(String topologyType);

	/**
	 * 
	 * @param nodeId
	 * @param topologyType
	 * @return List of Normal Routing Tables
	 */
	public List<NormalRoutingTable> retriveNormalRoutingTables(int nodeId, String topologyType);

	/**
	 * @param topologyType
	 * @return List of node ids
	 */
	public List<NodeId> retriveNodeIds(String topologyType);

	/**
	 * @param topologyType
	 * @return true if sucessful routing table
	 */
	public boolean createRoutingTable(String topologyType);

	/**
	 * @param topologyType
	 * @return true if sucessful routing table insertion
	 */

	public boolean insertRoutingTables(String topologyType);

	/**
	 * @param topologyType
	 * @return true if sucessful routing table
	 */
	public boolean createEnergyTables(String topologyType);

	/**
	 * @param nodeId
	 * @return Energy of node
	 */
	public Energy retriveEnergyTables(int nodeId);

	/**
	 * @param topologyType
	 * @return true if sucessful routing table
	 */
	public boolean createPowerTables(String topologyType);

	/**
	 * @param nodeId
	 * @return Power of node
	 */
	public Power retrivePowerTable(int nodeId);

	/**
	 * @return List<PerformanceEnergy>
	 */
	public List<PerformanceEnergy> retriveEnergyAlgo1();

	/**
	 * @return List<PerformanceEnergy>
	 */
	public List<PerformanceEnergy> retriveEnergyAlgo2();

	/**
	 * @return List<PerformancePower>
	 */
	public List<PerformancePower> retrivePowerAlgo1();

	/**
	 * @return List<PerformancePower>
	 */
	public List<PerformancePower> retrivePowerAlgo2();

	/**
	 * @return List<PerformanceTimeTaken>
	 */
	public List<PerformanceTimeTaken> retriveTimeAlgo1();

	/**
	 * @return List<PerformanceTimeTaken>
	 */
	public List<PerformanceTimeTaken> retriveTimeAlgo2();

	public List<CompareHops> retriveHopsComparison();

	public List<PerformanceHops> retriveNoOfHopsAlgo1();

	public List<PerformanceHops> retriveNoOfHopsAlgo2();

	public List<PerformanceDeadNodes> retriveDeadNodesAlgo1();

	public List<PerformanceDeadNodes> retriveDeadNodesAlgo2();

	public List<PerformanceAliveNodes> retriveAliveNodesAlgo1();

	public List<PerformanceAliveNodes> retriveAliveNodesAlgo2();

	public List<CompareNoOfDeadNodes> retriveDeadNodesComparison();

	public List<CompareNoOfAliveNodes> retriveAliveNodesComparison();

	public boolean createEnergyTablesForDSDV(String topologyType);

	public Power viewEnergyTableForDSDV(Integer nodeId);

	Power retriveEnergyTableForEEDR(Integer nodeId);

	public boolean updatedSettings(String topologyType);

	public String retrivePropertyValueForPropertyName(String topologyType);

	public List<CompareResidualEnergy> retriveResidualEnergyComparison();

	public List<CompareLifeTimeRatio> retriveComparisonLifeTimeRatio();

	public List<CompareRoutingOverhead> retriveCompareRoutingOverhead();

	public List<CompareThroughput> retriveCompareThroughput();

	public List<IPAdressVO> retriveIPAddressList();

	public boolean storeIpAddress(IPAdressVO ipAdressVO);

	public StatusInfo removeIpAddress(IPAdressVO ipAdressVONew);

	public StatusInfo removeAllAlgorithmsData(String type);

	public boolean deleteData(String type);

}
