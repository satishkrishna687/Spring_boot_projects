package com.routingtopology.service.inter;

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


public interface PerformanceServiceIF {

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
	 * @return List<PerformanceAliveNodes> return List of Alive Nodes for
	 *         Algorithm6
	 */
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo6();

	/**
	 * @return List<PerformanceAliveNodes> return List of Alive Nodes for
	 *         Algorithm5
	 */
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo5();

	/**
	 * @return List<PerformanceAliveNodes> return List of Alive Nodes for
	 *         Algorithm4
	 */
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo4();

	/**
	 * @return List<PerformanceAliveNodes> return List of Alive Nodes for
	 *         Algorithm3
	 */
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo3();

	/**
	 * @return List<PerformanceAliveNodes> return List of Alive Nodes for
	 *         Algorithm2
	 */
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo2();

	/**
	 * @return List<PerformanceAliveNodes> return List of Alive Nodes for
	 *         Algorithm1
	 */
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo1();

	/**
	 * @param packetLoss
	 * @return True if insertion is sucessful for Number of Packets Lost to
	 *         Algorithm1
	 */
	public boolean insertPacketLossForAlgo1(int packetLoss);

	/**
	 * @param packetLoss
	 * @return True if insertion is sucessful for Number of Packets Lost to
	 *         Algorithm2
	 */
	public boolean insertPacketLossForAlgo2(int packetLoss);

	/**
	 * @param packetLoss
	 * @return True if insertion is sucessful for Number of Packets Lost to
	 *         Algorithm3
	 */
	public boolean insertPacketLossForAlgo3(int packetLoss);

	/**
	 * @param packetLoss
	 * @return True if insertion is sucessful for Number of Packets Lost to
	 *         Algorithm4
	 */
	public boolean insertPacketLossForAlgo4(int packetLoss);

	/**
	 * @param packetLoss
	 * @return True if insertion is sucessful for Number of Packets Lost to
	 *         Algorithm5
	 */
	public boolean insertPacketLossForAlgo5(int packetLoss);

	/**
	 * @param packetLoss
	 * @return True if insertion is sucessful for Number of Packets Lost to
	 *         Algorithm5
	 */
	public boolean insertPacketLossForAlgo6(int packetLoss);

	/**
	 * @param noOfDeadNodes
	 * @return True if the insertion of number of dead nodes is sucessful for
	 *         Algorithm 1
	 */
	public boolean insertNoOfDeadNodesAlgo1(int noOfDeadNodes);

	/**
	 * @param noOfDeadNodes
	 * @return True if the insertion of number of dead nodes is sucessful for
	 *         Algorithm 2
	 */
	public boolean insertNoOfDeadNodesAlgo2(int noOfDeadNodes);

	/**
	 * @param noOfDeadNodes
	 * @return True if the insertion of number of dead nodes is sucessful for
	 *         Algorithm 3
	 */
	public boolean insertNoOfDeadNodesAlgo3(int noOfDeadNodes);

	/**
	 * @param noOfDeadNodes
	 * @return True if the insertion of number of dead nodes is sucessful for
	 *         Algorithm 4
	 */
	public boolean insertNoOfDeadNodesAlgo4(int noOfDeadNodes);

	/**
	 * @param noOfDeadNodes
	 * @return True if the insertion of number of dead nodes is sucessful for
	 *         Algorithm 5
	 */
	public boolean insertNoOfDeadNodesAlgo5(int noOfDeadNodes);

	/**
	 * @param noOfDeadNodes
	 * @return True if the insertion of number of dead nodes is sucessful for
	 *         Algorithm 6
	 */
	public boolean insertNoOfDeadNodesAlgo6(int noOfDeadNodes);

	/**
	 * @param noOfAliveNodes
	 * @return True if the insertion of number of alive nodes is sucessful for
	 *         Algorithm 1
	 */
	public boolean insertNoOfAliveNodesAlgo1(int noOfAliveNodes);

	/**
	 * @param noOfAliveNodes
	 * @return True if the insertion of number of alive nodes is sucessful for
	 *         Algorithm 2
	 */
	public boolean insertNoOfAliveNodesAlgo2(int noOfAliveNodes);

	/**
	 * @param noOfAliveNodes
	 * @return True if the insertion of number of alive nodes is sucessful for
	 *         Algorithm 3
	 */
	public boolean insertNoOfAliveNodesAlgo3(int noOfAliveNodes);

	/**
	 * @param noOfAliveNodes
	 * @return True if the insertion of number of alive nodes is sucessful for
	 *         Algorithm 4
	 */
	public boolean insertNoOfAliveNodesAlgo4(int noOfAliveNodes);

	/**
	 * @param noOfAliveNodes
	 * @return True if the insertion of number of alive nodes is sucessful for
	 *         Algorithm 5
	 */
	public boolean insertNoOfAliveNodesAlgo5(int noOfAliveNodes);

	/**
	 * @param noOfAliveNodes
	 * @return True if the insertion of number of alive nodes is sucessful for
	 *         Algorithm 6
	 */
	public boolean insertNoOfAliveNodesAlgo6(int noOfAliveNodes);

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
	 * @return true if insertion is sucessful
	 */
	public boolean insertTrustAlgo1(double trustLevel);

	/**
	 * @param trustLevel
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertTrustAlgo2(double trustLevel);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceTrust> retriveTrustlAlgo1();

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceTrust> retriveTrustlAlgo2();

	/**
	 * @param noOfHops
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertNoOfHopsAlgo3(int noOfHops);

	/**
	 * @param noOfHops
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertNoOfHopsAlgo4(int noOfHops);

	/**
	 * @param noOfHops
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertNoOfHopsAlgo5(int noOfHops);

	/**
	 * @return List contaning no of hops
	 */
	public List<PerformanceHops> retriveNoOfHopsAlgo3();

	/**
	 * @return List contaning no of hops
	 */
	public List<PerformanceHops> retriveNoOfHopsAlgo4();

	/**
	 * @return List contaning no of hops
	 */
	public List<PerformanceHops> retriveNoOfHopsAlgo5();

	/**
	 * @param timeTaken
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertRoundTripTimeAlgo3(double timeTaken);

	/**
	 * @param timeTaken
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertRoundTripTimeAlgo4(double timeTaken);

	/**
	 * @param timeTaken
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertRoundTripTimeAlgo5(double timeTaken);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo3();

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo4();

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo5();

	/**
	 * @param power
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertPowerAlgo3(double power);

	/**
	 * @param power
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertPowerAlgo4(double power);

	/**
	 * @param power
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertPowerAlgo5(double power);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformancePower> retrivePowerAlgo3();

	/**
	 * @return List contaning time taken
	 */
	public List<PerformancePower> retrivePowerAlgo4();

	/**
	 * @return List contaning time taken
	 */
	public List<PerformancePower> retrivePowerAlgo5();

	/**
	 * @param energy
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertEnergyAlgo3(double energy);

	/**
	 * @param energy
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertEnergyAlgo4(double energy);

	/**
	 * @param energy
	 * @param iterationNo
	 * @return true if insertion is sucessful
	 */
	public boolean insertEnergyAlgo5(double energy);

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceEnergy> retriveEnergyAlgo3();

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceEnergy> retriveEnergyAlgo4();

	/**
	 * @return List contaning time taken
	 */
	public List<PerformanceEnergy> retriveEnergyAlgo5();

	/**
	 * @param routingOverhead
	 * @param iterationNo
	 * @return true if insertion is successful
	 */
	public boolean insertRoutingOverheadAlgo1(double routingOverhead);

	/**
	 * @param routingOverhead
	 * @param iterationNo
	 * @return true if insertion is successful
	 */
	public boolean insertRoutingOverheadAlgo2(double routingOverhead);

	/**
	 * @param routingOverhead
	 * @param iterationNo
	 * @return true if insertion is successful
	 */
	public boolean insertRoutingOverheadAlgo3(double routingOverhead);

	/**
	 * @return List containing RO
	 */
	public List<PerformanceRoutingOverhead> retriveRoutingOverheadAlgo1();

	/**
	 * ou
	 * 
	 * @return List containing RO
	 */
	public List<PerformanceRoutingOverhead> retriveRoutingOverheadAlgo2();

	/**
	 * @return List containing RO
	 */
	public List<PerformanceRoutingOverhead> retriveRoutingOverheadAlgo3();

	/**
	 * @param lifeTimeRatio
	 * @param iterationNo
	 * @return true if insertion is successful
	 */
	public boolean insertLifeTimeAlgo1(double lifeTimeRatio);

	/**
	 * @param lifeTimeRatio
	 * @param iterationNo
	 * @return true if insertion is successful
	 */
	public boolean insertLifeTimeAlgo2(double lifeTimeRatio);

	/**
	 * @param lifeTimeRatio
	 * @param iterationNo
	 * @return true if insertion is successful
	 */
	public boolean insertLifeTimeAlgo3(double lifeTimeRatio);

	/**
	 * @return List containing RO
	 */
	public List<PerformanceLifeTimeRatio> retriveLifeTimeRatioAlgo1();

	/**
	 * ou
	 * 
	 * @return List containing RO
	 */
	public List<PerformanceLifeTimeRatio> retriveLifeTimeRatioAlgo2();

	/**
	 * @return List containing RO
	 */
	public List<PerformanceLifeTimeRatio> retriveLifeTimeRatioAlgo3();

	/**
	 * @param throughput
	 * @param iterationNo
	 * @return true if insertion is successful
	 */
	public boolean insertThroughputAlgo1(double throughput);

	/**
	 * @param throughput
	 * @param iterationNo
	 * @return true if insertion is successful
	 */
	public boolean insertThroughputAlgo2(double throughput);

	/**
	 * @param throughput
	 * @param iterationNo
	 * @return true if insertion is successful
	 */
	public boolean insertThroughputAlgo3(double throughput);

	/**
	 * @return List containing throughput
	 */
	public List<PerformanceThroughput> retriveThroughputAlgo1();

	/**
	 * @return List containing throughput
	 */
	public List<PerformanceThroughput> retriveThroughputAlgo2();

	/**
	 * @return List containing throughput
	 */
	public List<PerformanceThroughput> retriveThroughputAlgo3();

	boolean insertResidualEnergyAlgo1(double residualEnergy);

	boolean insertResidualEnergyAlgo2(double residualEnergy);

	boolean insertResidualEnergyAlgo3(double residualEnergy);

	List<PerformanceResidualEnergy> retriveResidualEnergyAlgo1();

	List<PerformanceResidualEnergy> retriveResidualEnergyAlgo2();

	List<PerformanceResidualEnergy> retriveResidualEnergyAlgo3();
	
	public boolean removeAllAlgorithmsData(String type);

		
	}
