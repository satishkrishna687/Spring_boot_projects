package com.routingtopology.dao.inter;

import java.util.List;

import com.model.PerformanceResidualEnergy;
import com.routingtopology.value.PerformanceAliveNodes;
import com.routingtopology.value.PerformanceDeadNodes;
import com.routingtopology.value.PerformanceEnergy;
import com.routingtopology.value.PerformanceHops;
import com.routingtopology.value.PerformanceLifeTimeRatio;
import com.routingtopology.value.PerformancePacketLoss;
import com.routingtopology.value.PerformancePower;
import com.routingtopology.value.PerformanceRoutingOverhead;
import com.routingtopology.value.PerformanceThroughput;
import com.routingtopology.value.PerformanceTimeTaken;
import com.routingtopology.value.PerformanceTrust;

/**
 * This interface is used for various performance measurement
 * 
 */
public interface PerformanceDAOIF {

	/**
	 * @param noOfHops
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertNoOfHopsAlgo1(int noOfHops);

	/**
	 * @return List contaning no of hops
	 */
	public List<PerformanceHops> retriveNoOfHopsAlgo1();

	/**
	 * @param timeTaken
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertRoundTripTimeAlgo1(double timeTaken);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo1();

	/**
	 * @param power
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertPowerAlgo1(double power);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformancePower> retrivePowerAlgo1();

	/**
	 * @param energy
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertEnergyAlgo1(double energy);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceEnergy> retriveEnergyAlgo1();

	/**
	 * @param noOfHops
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertNoOfHopsAlgo2(int noOfHops);

	/**
	 * @return List contaning no of hops
	 */
	public List<PerformanceHops> retriveNoOfHopsAlgo2();

	/**
	 * @param timeTaken
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertRoundTripTimeAlgo2(double timeTaken);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo2();

	/**
	 * @param power
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertPowerAlgo2(double power);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformancePower> retrivePowerAlgo2();

	/**
	 * @param energy
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertEnergyAlgo2(double energy);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceEnergy> retriveEnergyAlgo2();

	/**
	 * @param trustLevel
	 * @param iterationNo
	 * @return true if trust is inserted
	 */
	public boolean insertTrustAlgo1(double trustLevel);

	/**
	 * @param trustLevel
	 * @param iterationNo
	 * @return true if trust is inserted
	 */
	public boolean insertTrustAlgo2(double trustLevel);

	/**
	 * @return Performance Trust List
	 */
	public List<PerformanceTrust> retriveTrustlAlgo1();

	/**
	 * @return List of Performance
	 */
	public List<PerformanceTrust> retriveTrustlAlgo2();

	// --------------

	/**
	 * @param noOfHops
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertNoOfHopsAlgo3(int noOfHops);

	/**
	 * @return List contaning no of hops
	 */
	public List<PerformanceHops> retriveNoOfHopsAlgo3();

	/**
	 * @param timeTaken
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertRoundTripTimeAlgo3(double timeTaken);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo3();

	/**
	 * @param power
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertPowerAlgo3(double power);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformancePower> retrivePowerAlgo3();

	/**
	 * @param energy
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertEnergyAlgo3(double energy);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceEnergy> retriveEnergyAlgo3();

	/**
	 * @param noOfHops
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertNoOfHopsAlgo4(int noOfHops);

	/**
	 * @return List contaning no of hops
	 */
	public List<PerformanceHops> retriveNoOfHopsAlgo4();

	/**
	 * @param timeTaken
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertRoundTripTimeAlgo4(double timeTaken);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo4();

	/**
	 * @param power
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertPowerAlgo4(double power);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformancePower> retrivePowerAlgo4();

	/**
	 * @param energy
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertEnergyAlgo4(double energy);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceEnergy> retriveEnergyAlgo4();

	/**
	 * @param trustLevel
	 * @param iterationNo
	 * @return true if trust is inserted
	 */
	public boolean insertTrustAlgo3(double trustLevel);

	/**
	 * @param trustLevel
	 * @param iterationNo
	 * @return true if trust is inserted
	 */
	public boolean insertTrustAlgo4(double trustLevel);

	/**
	 * @return Performance Trust List
	 */
	public List<PerformanceTrust> retriveTrustlAlgo3();

	/**
	 * @return List of Performance
	 */
	public List<PerformanceTrust> retriveTrustlAlgo4();

	// -------------------------------------

	/**
	 * @param noOfHops
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertNoOfHopsAlgo5(int noOfHops);

	/**
	 * @return List contaning no of hops
	 */
	public List<PerformanceHops> retriveNoOfHopsAlgo5();

	/**
	 * @param timeTaken
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertRoundTripTimeAlgo5(double timeTaken);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo5();

	/**
	 * @param power
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertPowerAlgo5(double power);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformancePower> retrivePowerAlgo5();

	/**
	 * @param energy
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertEnergyAlgo5(double energy);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceEnergy> retriveEnergyAlgo5();

	/**
	 * @param noOfHops
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertNoOfHopsAlgo6(int noOfHops);

	/**
	 * @return List contaning no of hops
	 */
	public List<PerformanceHops> retriveNoOfHopsAlgo6();

	/**
	 * @param timeTaken
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertRoundTripTimeAlgo6(double timeTaken);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo6();

	/**
	 * @param power
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertPowerAlgo6(double power);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformancePower> retrivePowerAlgo6();

	/**
	 * @param energy
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertEnergyAlgo6(double energy);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceEnergy> retriveEnergyAlgo6();

	/**
	 * @param trustLevel
	 * @param iterationNo
	 * @return true if trust is inserted
	 */
	public boolean insertTrustAlgo5(double trustLevel);

	/**
	 * @param trustLevel
	 * @param iterationNo
	 * @return true if trust is inserted
	 */
	public boolean insertTrustAlgo6(double trustLevel);

	/**
	 * @return Performance Trust List
	 */
	public List<PerformanceTrust> retriveTrustlAlgo5();

	/**
	 * @return List of Performance
	 */
	public List<PerformanceTrust> retriveTrustlAlgo6();

	/**
	 * @param noOfDeadNodes
	 * @return True if insertion is sucessful for Number of Dead Nodes specific
	 *         to Algorithm1
	 */
	public boolean insertNoOfDeadNodesAlgo1(int noOfDeadNodes);

	/**
	 * @param noOfDeadNodes
	 * @return True if insertion is sucessful for Number of Dead Nodes specific
	 *         to Algorithm2
	 */
	public boolean insertNoOfDeadNodesAlgo2(int noOfDeadNodes);

	/**
	 * @param noOfDeadNodes
	 * @return True if insertion is sucessful for Number of Dead Nodes specific
	 *         to Algorithm3
	 */
	public boolean insertNoOfDeadNodesAlgo3(int noOfDeadNodes);

	/**
	 * @param noOfDeadNodes
	 * @return True if insertion is sucessful for Number of Dead Nodes specific
	 *         to Algorithm4
	 */
	public boolean insertNoOfDeadNodesAlgo4(int noOfDeadNodes);

	/**
	 * @param noOfDeadNodes
	 * @return True if insertion is sucessful for Number of Dead Nodes specific
	 *         to Algorithm5
	 */
	public boolean insertNoOfDeadNodesAlgo5(int noOfDeadNodes);

	/**
	 * @param noOfDeadNodes
	 * @return True if insertion is sucessful for Number of Dead Nodes specific
	 *         to Algorithm6
	 */
	public boolean insertNoOfDeadNodesAlgo6(int noOfDeadNodes);

	/**
	 * @param noOfAliveNodes
	 * @return True if insertion is sucessful for Number of Alive Nodes specific
	 *         to Algorithm1
	 */
	public boolean insertNoOfAliveNodesAlgo1(int noOfAliveNodes);

	/**
	 * @param noOfAliveNodes
	 * @return True if insertion is sucessful for Number of Alive Nodes specific
	 *         to Algorithm 2
	 */
	public boolean insertNoOfAliveNodesAlgo2(int noOfAliveNodes);

	/**
	 * @param noOfAliveNodes
	 * @return True if insertion is sucessful for Number of Alive Nodes specific
	 *         to Algorithm 3
	 */
	public boolean insertNoOfAliveNodesAlgo3(int noOfAliveNodes);

	/**
	 * @param noOfAliveNodes
	 * @return True if insertion is sucessful for Number of Alive Nodes specific
	 *         to Algorithm 4
	 */
	public boolean insertNoOfAliveNodesAlgo4(int noOfAliveNodes);

	/**
	 * @param noOfAliveNodes
	 * @return True if insertion is sucessful for Number of Alive Nodes specific
	 *         to Algorithm 5
	 */
	public boolean insertNoOfAliveNodesAlgo5(int noOfAliveNodes);

	/**
	 * @param noOfAliveNodes
	 * @return True if insertion is sucessful for Number of Alive Nodes specific
	 *         to Algorithm6
	 */
	public boolean insertNoOfAliveNodesAlgo6(int noOfAliveNodes);

	/**
	 * @param packetLoss
	 * @return True if insertion is sucessful for Number of Packets Lost to
	 *         Algorithm1
	 */
	public boolean insertPacketLossForAlgo1(int packetLoss);

	/**
	 * @param packetLoss
	 * @return True if insertion is sucessful for Number of Packets Lost to
	 *         Algorithm1
	 */
	public boolean insertPacketLossForAlgo2(int packetLoss);

	/**
	 * @param packetLoss
	 * @return True if insertion is successful for Number of Packets Lost to
	 *         Algorithm1
	 */
	public boolean insertPacketLossForAlgo3(int packetLoss);

	/**
	 * @param packetLoss
	 * @return True if insertion is successful for Number of Packets Lost to
	 *         Algorithm1
	 */
	public boolean insertPacketLossForAlgo4(int packetLoss);

	/**
	 * @param packetLoss
	 * @return True if insertion is successful for Number of Packets Lost to
	 *         Algorithm1
	 */
	public boolean insertPacketLossForAlgo5(int packetLoss);

	/**
	 * @param packetLoss
	 * @return True if insertion is successful for Number of Packets Lost to
	 *         Algorithm1
	 */
	public boolean insertPacketLossForAlgo6(int packetLoss);

	/**
	 * @return List containing the Number of Dead Nodes in the Network For
	 *         Algorithm 1
	 */
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo1();

	/**
	 * @return List containing the Number of Dead Nodes in the Network For
	 *         Algorithm 2
	 */
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo2();

	/**
	 * @return List containing the Number of Dead Nodes in the Network For
	 *         Algorithm 3
	 */
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo3();

	/**
	 * @return List containing the Number of Dead Nodes in the Network For
	 *         Algorithm 4
	 */
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo4();

	/**
	 * @return List containing the Number of Dead Nodes in the Network For
	 *         Algorithm 5
	 */
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo5();

	/**
	 * @return List containing the Number of Dead Nodes in the Network For
	 *         Algorithm 6
	 */
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo6();

	/**
	 * @return List containing the Number of Alive Nodes in the Network For
	 *         Algorithm 1
	 */
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo1();

	/**
	 * @return List containing the Number of Alive Nodes in the Network For
	 *         Algorithm 2
	 */
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo2();

	/**
	 * @return List containing the Number of Alive Nodes in the Network For
	 *         Algorithm 3
	 */
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo3();

	/**
	 * @return List containing the Number of Alive Nodes in the Network For
	 *         Algorithm 4
	 */
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo4();

	/**
	 * @return List containing the Number of Alive Nodes in the Network For
	 *         Algorithm 5
	 */
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo5();

	/**
	 * @return List containing the Number of Alive Nodes in the Network For
	 *         Algorithm 6
	 */
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo6();

	/**
	 * @return List containing the Packet Loss in the Network For Algorithm 1
	 */
	public List<PerformancePacketLoss> retrivePacketLossForAlgo1();

	/**
	 * @return List containing the Packet Loss in the Network For Algorithm 2
	 */
	public List<PerformancePacketLoss> retrivePacketLossForAlgo2();

	/**
	 * @return List containing the Packet Loss in the Network For Algorithm 3
	 */
	public List<PerformancePacketLoss> retrivePacketLossForAlgo3();

	/**
	 * @return List containing the Packet Loss in the Network For Algorithm 4
	 */
	public List<PerformancePacketLoss> retrivePacketLossForAlgo4();

	/**
	 * @return List containing the Packet Loss in the Network For Algorithm 5
	 */
	public List<PerformancePacketLoss> retrivePacketLossForAlgo5();
	
	/**
	 * @return List containing the Packet Loss in the Network For Algorithm 6
	 */
	public List<PerformancePacketLoss> retrivePacketLossForAlgo6();

	public boolean insertRoutingOverheadAlgo1(double routingOverhead);

	public boolean insertRoutingOverheadAlgo2(double routingOverhead);

	public boolean insertRoutingOverheadAlgo3(double routingOverhead);

	public List<PerformanceRoutingOverhead> retriveRoutingOverheadAlgo1();

	public List<PerformanceRoutingOverhead> retriveRoutingOverheadAlgo2();

	public List<PerformanceRoutingOverhead> retriveRoutingOverheadAlgo3();

	public boolean insertLifeTimeAlgo1(double lifeTimeRatio);

	public boolean insertLifeTimeAlgo2(double lifeTimeRatio);

	public boolean insertLifeTimeAlgo3(double lifeTimeRatio);

	public List<PerformanceLifeTimeRatio> retriveLifeTimeRatioAlgo1();

	public List<PerformanceLifeTimeRatio> retriveLifeTimeRatioAlgo2();

	public List<PerformanceLifeTimeRatio> retriveLifeTimeRatioAlgo3();

	public boolean insertThroughputAlgo1(double throughput);

	public boolean insertThroughputAlgo2(double throughput);

	public boolean insertThroughputAlgo3(double throughput);

	public List<PerformanceThroughput> retriveThroughputAlgo1();

	public List<PerformanceThroughput> retriveThroughputAlgo2();

	public List<PerformanceThroughput> retriveThroughputAlgo3();

	public boolean insertResidualEnergyAlgo1(double residualEnergy);

	public boolean insertResidualEnergyAlgo2(double residualEnergy);

	public boolean insertResidualEnergyAlgo3(double residualEnergy);

	public List<PerformanceResidualEnergy> retriveResidualEnergyAlgo1();

	public List<PerformanceResidualEnergy> retriveResidualEnergyAlgo2();

	public List<PerformanceResidualEnergy> retriveResidualEnergyAlgo3();

	boolean deleteTimeTaken1();

	boolean deleteTimeTaken2();

	boolean deleteTimeTaken3();

	boolean deleteHopsAlgo1();

	boolean deleteHopsAlgo2();

	boolean deleteHopsAlgo3();

	boolean deleteEnergyConsumedAlgo1();

	boolean deleteEnergyConsumedAlgo2();

	boolean deleteEnergyConsumedAlgo3();

	boolean deleteResidualEnergyAlgo1();

	boolean deleteResidualEnergyAlgo2();

	boolean deleteResidualEnergyAlgo3();

	boolean deleteThroughputAlgo1();

	boolean deleteThroughputAlgo2();

	boolean deleteThroughputAlgo3();

	boolean deleteAliveNodesAlgo3();

	boolean deleteAliveNodesAlgo1();

	boolean deleteAliveNodesAlgo2();

	boolean deleteDeadNodesAlgo1();

	boolean deleteDeadNodesAlgo3();

	boolean deleteDeadNodesAlgo2();

	boolean deleteROAlgo1();

	boolean deleteROAlgo3();

	boolean deleteROAlgo2();

	boolean deleteLTRAlgo1();

	boolean deleteLTRAlgo3();

	boolean deleteLTRAlgo2();

}
