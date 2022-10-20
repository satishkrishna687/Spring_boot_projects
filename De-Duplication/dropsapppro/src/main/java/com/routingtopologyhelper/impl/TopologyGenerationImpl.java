package com.routingtopologyhelper.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.routingtopology.constants.TopologyConstantsIF;
import com.routingtopology.value.CentreCordinate;
import com.routingtopology.value.GridInfo;
import com.routingtopology.value.LeaderInfoValue;
import com.routingtopology.value.NodeCordinateValue;
import com.routingtopology.value.NodeParameters;
import com.routingtopology.value.TopologyCriteriaValue;
import com.routingtopology.value.TopologyInfoValue;
import com.routingtopologyhelper.inter.TopologyGenerationIF;

/**
 *  This class is responsible for generation of node positions
 *         during network initialization
 * 
 */
@Service
public class TopologyGenerationImpl implements TopologyGenerationIF {

	private static final String CLASS_COLON = "Class:";
	private static final String CLASS_NAME = "TopologyGenerationImpl";
	private static final String ARROW = "-->";
	private static final String METHOD = "Method:";

	@Override
	public List<TopologyInfoValue> getAngularTopology(
			TopologyCriteriaValue criteria) {
		System.out
				.println("Class-->TopologyGenerationImpl:Method-->getAngularTopology");
		List<TopologyInfoValue> angularTopology = null;
		try {
			int noOfNodes = criteria.getNoOfNodes();
			System.out
					.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
							+ "getAngularTopology" + ARROW + "no of nodes="
							+ noOfNodes);
			NodeParameters nodeParameters = criteria.getNodeParameters();
			double intialEnergy = nodeParameters.getEnergy();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getAngularTopology" + ARROW + "intialEnergy="
					+ intialEnergy);
			int initialBuffer = nodeParameters.getBuffer();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getAngularTopology" + ARROW + "initialBuffer="
					+ initialBuffer);
			double initialNetworkCost = nodeParameters.getNetworkCost();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getAngularTopology" + ARROW + "initialNetworkCost="
					+ initialNetworkCost);
			int trustLevel = nodeParameters.getTrustLevel();
			System.out
					.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
							+ "getAngularTopology" + ARROW + "trustLevel="
							+ trustLevel);
			double initialBatteryPower = nodeParameters
					.getAvailableBatteryPower();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getAngularTopology" + ARROW + "initialBatteryPower="
					+ initialBatteryPower);

			List<Integer> angularEndPointsList = criteria.getAngularEndPoints();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getAngularTopology" + ARROW + "verticalEndPointsList="
					+ angularEndPointsList);

			List<Integer> angularNoOfNodes = criteria
					.getNoOfNodesInEachAngularRegion();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getAngularTopology" + ARROW + "verticalNoOfNodes="
					+ angularNoOfNodes);

			double signalStrength = criteria.getIntialSignalStrength();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getAngularTopology" + ARROW + "signalStrength="
					+ signalStrength);

			int angularValue = 0;

			if (noOfNodes > 0
					&& intialEnergy > 0
					&& initialBatteryPower > 0
					&& trustLevel > 0
					&& initialBuffer > 0
					&& initialNetworkCost > 0
					&& signalStrength > 0
					&& angularEndPointsList != null
					&& angularEndPointsList.size() > 0
					&& angularNoOfNodes != null
					&& angularNoOfNodes.size() > 0
					&& angularNoOfNodes.size() == angularEndPointsList.size() - 1) {

				System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
						+ "getAngularTopology" + ARROW
						+ "All Validation passed");
				int noOfVerticalEndPoints = angularEndPointsList.size();
				angularTopology = new ArrayList<TopologyInfoValue>();

				List<Integer> closeList = new ArrayList<Integer>();
				closeList.add(TopologyConstantsIF.CLOSENESS1);
				closeList.add(TopologyConstantsIF.CLOSENESS2);
				closeList.add(TopologyConstantsIF.CLOSENESS3);

				int sizeOfCloseness = closeList.size();

				int nodeId = 1;
				for (int verIndex = 0; verIndex < noOfVerticalEndPoints; verIndex++) {

					if (verIndex == angularEndPointsList.size()) {
						break;
					}
					int minAngleNew = angularEndPointsList.get(verIndex);
					int maxAngleNew = angularEndPointsList.get(verIndex + 1);

					List<Integer> angularList = new ArrayList<Integer>();

					for (int xCorInd = minAngleNew; xCorInd < maxAngleNew; xCorInd++) {
						angularList.add(xCorInd);
					}

					int noOfNodesPerAngularRegion = angularNoOfNodes
							.get(verIndex);

					System.out.println(CLASS_COLON + CLASS_NAME + ARROW
							+ METHOD + "getAngularTopology" + ARROW
							+ "Start For Loop" + verIndex);

					for (int nodeIndex = 1; nodeIndex <= noOfNodesPerAngularRegion; nodeIndex++) {
						TopologyInfoValue topologyInfoValue = new TopologyInfoValue();
						NodeParameters nodeParametersTemp = new NodeParameters();
						Random rand = new Random();
						int angularRandomIndex = rand.nextInt(angularList
								.size());
						int closerRandomIndex = rand.nextInt(sizeOfCloseness);
						int closerToObs = closeList.get(closerRandomIndex);
						angularValue = angularList.get(angularRandomIndex);

						topologyInfoValue.setNodeId(nodeId);
						nodeId++;
						nodeParametersTemp
								.setAvailableBatteryPower(initialBatteryPower);
						int angularRegion = verIndex;
						nodeParametersTemp.setAngularRegion(angularRegion);
						nodeParametersTemp.setAngularPos(angularValue);
						LeaderInfoValue leaderInfoValue = new LeaderInfoValue();
						leaderInfoValue.setLeader(Boolean.FALSE);
						nodeParametersTemp.setCloseObstracle(closerToObs);
						nodeParametersTemp.setBuffer(initialBuffer);
						nodeParametersTemp.setEnergy(intialEnergy);
						nodeParametersTemp.setNetworkCost(initialNetworkCost);
						nodeParametersTemp.setTrustLevel(trustLevel);
						nodeParametersTemp
								.setSignalStrengthOfNode(signalStrength);
						topologyInfoValue.setNodeParameters(nodeParametersTemp);
						topologyInfoValue.setLeaderInfo(leaderInfoValue);
						angularTopology.add(topologyInfoValue);
					}
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW
							+ METHOD + "getAngularTopology" + ARROW
							+ "End For Loop" + verIndex);

				}
			}
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return angularTopology;
	}

	@Override
	public List<TopologyInfoValue> getGridTopology(
			TopologyCriteriaValue criteria) {

		List<TopologyInfoValue> gridTopology = null;
		try {
			int noOfNodes = criteria.getNoOfNodes();
			NodeParameters nodeParameters = criteria.getNodeParameters();
			int trustLevel = nodeParameters.getTrustLevel();
			double intialEnergy = nodeParameters.getEnergy();
			int initialBuffer = nodeParameters.getBuffer();
			double initialNetworkCost = nodeParameters.getNetworkCost();
			double initialBatteryPower = nodeParameters
					.getAvailableBatteryPower();
			int distanceBetweenNodes = criteria.getDistanceBetweenNodes();
			GridInfo gridInfo = criteria.getGridInfo();
			int noOfXPositions = gridInfo.getNoOfXpos();
			int noOfYPositions = gridInfo.getNoOfYpos();

			int noOfNodesToBe = noOfXPositions * noOfYPositions;
			System.out.println("noOfNodesToBe" + noOfNodesToBe);
			if (noOfNodes > 0 && noOfNodesToBe == noOfNodes && intialEnergy > 0
					&& initialBatteryPower > 0 && initialBuffer > 0
					&& initialNetworkCost > 0 && noOfXPositions > 0
					&& noOfYPositions > 0 && trustLevel > 0
					&& noOfXPositions == noOfYPositions) {

				System.out.println("Inside If Condition");
				gridTopology = new ArrayList<TopologyInfoValue>();
				List<Integer> xCordinateLimits = new ArrayList<Integer>();

				for (int xindex = 0; xindex < noOfXPositions; xindex++) {
					xCordinateLimits.add(xindex * distanceBetweenNodes);
				}

				List<Integer> yCordinateLimits = new ArrayList<Integer>();
				for (int yindex = 0; yindex < noOfXPositions; yindex++) {
					yCordinateLimits.add(yindex * distanceBetweenNodes);
				}
				int nodeId = 1;
				for (int yindex = 0; yindex < yCordinateLimits.size(); yindex++) {
					for (int xindex = 0; xindex < xCordinateLimits.size(); xindex++) {
						int xcordinate = 0;
						int ycordinate = 0;
						TopologyInfoValue topologyInfoValue = new TopologyInfoValue();
						NodeCordinateValue nodeCordinateValue = new NodeCordinateValue();
						NodeParameters nodeParametersTemp = new NodeParameters();
						xcordinate = xCordinateLimits.get(xindex);
						ycordinate = yCordinateLimits.get(yindex);
						nodeCordinateValue.setX_cor(xcordinate);
						nodeCordinateValue.setY_cor(ycordinate);
						topologyInfoValue.setNodeCoordiante(nodeCordinateValue);
						nodeParametersTemp
								.setAvailableBatteryPower(initialBatteryPower);
						nodeParametersTemp.setBuffer(initialBuffer);
						nodeParametersTemp.setEnergy(intialEnergy);
						nodeParametersTemp.setNetworkCost(initialNetworkCost);
						nodeParametersTemp.setTrustLevel(trustLevel);
						topologyInfoValue.setNodeParameters(nodeParametersTemp);
						topologyInfoValue.setNodeId(nodeId);
						nodeId++;
						gridTopology.add(topologyInfoValue);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception ----->>>>>>>" + e.getMessage());
		}
		return gridTopology;
	}

	@Override
	public List<TopologyInfoValue> getLinearTopology(
			TopologyCriteriaValue criteria) {
		List<TopologyInfoValue> linearTopology = null;
		try {
			int noOfNodes = criteria.getNoOfNodes();
			NodeParameters nodeParameters = criteria.getNodeParameters();
			double intialEnergy = nodeParameters.getEnergy();
			int initialBuffer = nodeParameters.getBuffer();
			double initialNetworkCost = nodeParameters.getNetworkCost();
			double initialBatteryPower = nodeParameters
					.getAvailableBatteryPower();
			int trustLevel =nodeParameters.getTrustLevel();
			int distanceBetweenNodes = criteria.getDistanceBetweenNodes();
			int xcordinate = 0;
			int ycordinate;
			if (noOfNodes > 0 && intialEnergy > 0 && initialBatteryPower > 0
					&& distanceBetweenNodes > 0) {
				int distanceTemp = 0;
				linearTopology = new ArrayList<TopologyInfoValue>();
				for (int nodeIndex = 1; nodeIndex <= noOfNodes; nodeIndex++) {

					TopologyInfoValue topologyInfoValue = new TopologyInfoValue();

					NodeCordinateValue nodeCordinateValue = new NodeCordinateValue();

					NodeParameters nodeParametersTemp = new NodeParameters();
					if (nodeIndex == 2) {
						distanceTemp = distanceBetweenNodes;
					}

					if (nodeIndex == 1) {
						xcordinate = 0;
						ycordinate = 0;
					} else {
						xcordinate += distanceTemp;
						ycordinate = 0;
					}
					nodeCordinateValue.setX_cor(xcordinate);
					nodeCordinateValue.setY_cor(ycordinate);
					topologyInfoValue.setNodeId(nodeIndex);
					topologyInfoValue.setNodeCoordiante(nodeCordinateValue);
					nodeParametersTemp
							.setAvailableBatteryPower(initialBatteryPower);
					nodeParametersTemp.setBuffer(initialBuffer);
					nodeParametersTemp.setEnergy(intialEnergy);
					nodeParametersTemp.setNetworkCost(initialNetworkCost);
					nodeParametersTemp.setTrustLevel(trustLevel);
					topologyInfoValue.setNodeParameters(nodeParametersTemp);
					linearTopology.add(topologyInfoValue);
				}
			}

		} catch (Exception e) {
			System.out.println("Exception ---->" + e.getMessage());
		}
		return linearTopology;
	}

	@Override
	public List<TopologyInfoValue> getRandomTopology(
			TopologyCriteriaValue criteria) {

		System.out
				.println("Class-->TopologyGenerationImpl:Method-->getRandomTopology");

		List<TopologyInfoValue> linearTopology = null;
		try {
			int noOfNodes = criteria.getNoOfNodes();
			NodeParameters nodeParameters = criteria.getNodeParameters();
			double intialEnergy = nodeParameters.getEnergy();
			int initialBuffer = nodeParameters.getBuffer();
			double initialNetworkCost = nodeParameters.getNetworkCost();
			double initialBatteryPower = nodeParameters
					.getAvailableBatteryPower();
			int minXCordinate = criteria.getMinXCordinate();
			int minYCordinate = criteria.getMinYCordinate();
			int maxXCordinate = criteria.getMaxXCordinate();
			int maxYCordinate = criteria.getMaxYCordinate();

			List<Integer> xCorList = new ArrayList<Integer>();
			List<Integer> yCorList = new ArrayList<Integer>();
			int xcordinate = 0;
			int ycordinate = 0;
			if (noOfNodes > 0 && intialEnergy > 0 && initialBatteryPower > 0
					&& minXCordinate > 0 && minYCordinate > 0
					&& maxXCordinate > minXCordinate
					&& maxYCordinate > minYCordinate) {

				for (int xCorInd = minXCordinate; xCorInd < maxXCordinate; xCorInd++) {
					xCorList.add(xCorInd);
				}

				for (int yCorInd = minYCordinate; yCorInd < maxYCordinate; yCorInd++) {
					yCorList.add(yCorInd);
				}
				linearTopology = new ArrayList<TopologyInfoValue>();
				for (int nodeIndex = 1; nodeIndex <= noOfNodes; nodeIndex++) {

					TopologyInfoValue topologyInfoValue = new TopologyInfoValue();
					NodeCordinateValue nodeCordinateValue = new NodeCordinateValue();
					NodeParameters nodeParametersTemp = new NodeParameters();
					Random rand = new Random();
					int randomIndexX = rand.nextInt(xCorList.size());
					int randomIndexY = rand.nextInt(yCorList.size());
					xcordinate = xCorList.get(randomIndexX);
					ycordinate = yCorList.get(randomIndexY);
					nodeCordinateValue.setX_cor(xcordinate);
					nodeCordinateValue.setY_cor(ycordinate);
					topologyInfoValue.setNodeId(nodeIndex);
					topologyInfoValue.setNodeCoordiante(nodeCordinateValue);
					nodeParametersTemp
							.setAvailableBatteryPower(initialBatteryPower);
					nodeParametersTemp.setBuffer(initialBuffer);
					nodeParametersTemp.setEnergy(intialEnergy);
					nodeParametersTemp.setNetworkCost(initialNetworkCost);
					topologyInfoValue.setNodeParameters(nodeParametersTemp);
					linearTopology.add(topologyInfoValue);
				}
			}
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return linearTopology;
	}

	@Override
	public List<TopologyInfoValue> getVerticalTopology(
			TopologyCriteriaValue criteria) {
		System.out
				.println("Class-->TopologyGenerationImpl:Method-->getVerticalTopology");

		List<TopologyInfoValue> verticalTopology = null;
		try {
			int noOfNodes = criteria.getNoOfNodes();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getVerticalTopology" + ARROW + "no of nodes="
					+ noOfNodes);
			NodeParameters nodeParameters = criteria.getNodeParameters();
			double intialEnergy = nodeParameters.getEnergy();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getVerticalTopology" + ARROW + "intialEnergy="
					+ intialEnergy);
			int initialBuffer = nodeParameters.getBuffer();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getVerticalTopology" + ARROW + "initialBuffer="
					+ initialBuffer);
			double initialNetworkCost = nodeParameters.getNetworkCost();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getVerticalTopology" + ARROW + "initialNetworkCost="
					+ initialNetworkCost);
			int trustLevel = nodeParameters.getTrustLevel();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getVerticalTopology" + ARROW + "trustLevel="
					+ trustLevel);
			double initialBatteryPower = nodeParameters
					.getAvailableBatteryPower();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getVerticalTopology" + ARROW + "initialBatteryPower="
					+ initialBatteryPower);
			int minXCordinate = criteria.getMinXCordinate();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getVerticalTopology" + ARROW + "minXCordinate="
					+ minXCordinate);
			int minYCordinate = criteria.getMinYCordinate();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getVerticalTopology" + ARROW + "minYCordinate="
					+ minYCordinate);
			int maxXCordinate = criteria.getMaxXCordinate();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getVerticalTopology" + ARROW + "maxXCordinate="
					+ maxXCordinate);
			int maxYCordinate = criteria.getMaxYCordinate();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getVerticalTopology" + ARROW + "maxYCordinate="
					+ maxYCordinate);

			List<Integer> verticalEndPointsList = criteria
					.getVerticalLinesPoints();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getVerticalTopology" + ARROW + "verticalEndPointsList="
					+ verticalEndPointsList);

			List<Integer> verticalNoOfNodes = criteria
					.getNoOfNodesInEachVertical();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getVerticalTopology" + ARROW + "verticalNoOfNodes="
					+ verticalNoOfNodes);

			int xcordinate = 0;
			int ycordinate = 0;
			if (noOfNodes > 0
					&& intialEnergy > 0
					&& initialBatteryPower > 0
					&& trustLevel > 0
					&& initialBuffer > 0
					&& initialNetworkCost > 0
					&& minXCordinate > 0
					&& minYCordinate > 0
					&& maxXCordinate > minXCordinate
					&& maxYCordinate > minYCordinate
					&& verticalEndPointsList != null
					&& verticalEndPointsList.size() > 0
					&& verticalNoOfNodes != null
					&& verticalNoOfNodes.size() > 0
					&& verticalNoOfNodes.size() == verticalEndPointsList.size() - 1) {

				System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
						+ "getVerticalTopology" + ARROW
						+ "All Validation passed");
				int noOfVerticalEndPoints = verticalEndPointsList.size();
				verticalTopology = new ArrayList<TopologyInfoValue>();
				int nodeId = 1;
				for (int verIndex = 0; verIndex < noOfVerticalEndPoints; verIndex++) {

					if (verIndex == verticalEndPointsList.size()) {
						break;
					}
					int minXCordinateNew = verticalEndPointsList.get(verIndex);
					int maxXCordinateNew = verticalEndPointsList
							.get(verIndex + 1);

					List<Integer> xCorList = new ArrayList<Integer>();
					List<Integer> yCorList = new ArrayList<Integer>();

					for (int xCorInd = minXCordinateNew; xCorInd < maxXCordinateNew; xCorInd++) {
						xCorList.add(xCorInd);
					}

					for (int yCorInd = minYCordinate; yCorInd < maxYCordinate; yCorInd++) {
						yCorList.add(yCorInd);
					}

					int noOfNodesPerVertical = verticalNoOfNodes.get(verIndex);

					System.out.println(CLASS_COLON + CLASS_NAME + ARROW
							+ METHOD + "getVerticalTopology" + ARROW
							+ "Start For Loop" + verIndex);

					for (int nodeIndex = 1; nodeIndex <= noOfNodesPerVertical; nodeIndex++) {
						TopologyInfoValue topologyInfoValue = new TopologyInfoValue();
						NodeCordinateValue nodeCordinateValue = new NodeCordinateValue();
						NodeParameters nodeParametersTemp = new NodeParameters();
						Random rand = new Random();
						int randomIndexX = rand.nextInt(xCorList.size());
						int randomIndexY = rand.nextInt(yCorList.size());
						xcordinate = xCorList.get(randomIndexX);
						ycordinate = yCorList.get(randomIndexY);
						nodeCordinateValue.setX_cor(xcordinate);
						nodeCordinateValue.setY_cor(ycordinate);
						topologyInfoValue.setNodeId(nodeId);
						nodeId++;
						topologyInfoValue.setNodeCoordiante(nodeCordinateValue);
						nodeParametersTemp
								.setAvailableBatteryPower(initialBatteryPower);
						int verticalBelong = verIndex;
						nodeParametersTemp
								.setVerticalBelong(verticalBelong + 1);
						nodeParametersTemp.setBuffer(initialBuffer);
						nodeParametersTemp.setEnergy(intialEnergy);
						nodeParametersTemp.setNetworkCost(initialNetworkCost);
						nodeParametersTemp.setTrustLevel(trustLevel);
						topologyInfoValue.setNodeParameters(nodeParametersTemp);
						verticalTopology.add(topologyInfoValue);
					}
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW
							+ METHOD + "getVerticalTopology" + ARROW
							+ "End For Loop" + verIndex);

				}
			}
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return verticalTopology;
	}

	@Override
	public List<TopologyInfoValue> getSquareTopology(
			TopologyCriteriaValue criteria) {
		System.out
				.println("Class-->TopologyGenerationImpl:Method-->getSquareTopology");
		List<TopologyInfoValue> squareTopology = null;
		try {
			int noOfNodes = criteria.getNoOfNodes();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getSquareTopology" + ARROW + "no of nodes=" + noOfNodes);
			NodeParameters nodeParameters = criteria.getNodeParameters();
			double intialEnergy = nodeParameters.getEnergy();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getSquareTopology" + ARROW + "intialEnergy="
					+ intialEnergy);
			int initialBuffer = nodeParameters.getBuffer();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getSquareTopology" + ARROW + "initialBuffer="
					+ initialBuffer);
			double initialNetworkCost = nodeParameters.getNetworkCost();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getSquareTopology" + ARROW + "initialNetworkCost="
					+ initialNetworkCost);
			int trustLevel = nodeParameters.getTrustLevel();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getSquareTopology" + ARROW + "trustLevel=" + trustLevel);
			double initialBatteryPower = nodeParameters
					.getAvailableBatteryPower();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getSquareTopology" + ARROW + "initialBatteryPower="
					+ initialBatteryPower);
			List<Integer> horizontalEndPointsList = criteria
					.getHorizontalEndPoints();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getSquareTopology" + ARROW + "horizontalEndPointsList="
					+ horizontalEndPointsList);
			List<Integer> verticalEndPointList = criteria
					.getVerticalEndPoints();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getSquareTopology" + ARROW + "verticalEndPointList="
					+ verticalEndPointList);
			List<Integer> noOfNodesPerZoneList = criteria.getNoOfNodesPerZone();
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
					+ "getSquareTopology" + ARROW + "noOfNodesPerZoneList="
					+ noOfNodesPerZoneList);
			
			int noOfZOnes=criteria.getNoOfZones();

			int xcordinate = 0;
			int ycordinate = 0;
			if (noOfNodes > 0
					&& intialEnergy > 0
					&& initialBatteryPower > 0
					&& trustLevel > 0
					&& initialBuffer > 0
					&& initialNetworkCost > 0
					&& horizontalEndPointsList != null
					&& horizontalEndPointsList.size() > 0
					&& noOfNodesPerZoneList != null
					&& noOfNodesPerZoneList.size() > 0
					&& verticalEndPointList != null
					&& horizontalEndPointsList != null
					&& verticalEndPointList.size() == horizontalEndPointsList
							.size())
					 {

				System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
						+ "getSquareTopology" + ARROW
						+ "All Validation passed");
				squareTopology = new ArrayList<TopologyInfoValue>();
				int nodeId = 1;
				System.out.println("no of zones="+noOfZOnes);
				int tempIndex=0;
				int tempIndexY=0;
				for (int verIndex = 0; verIndex < noOfZOnes; verIndex++) {
					
					
				
					if(tempIndex==horizontalEndPointsList.size()-1)
					{
						System.out.println("inside temp index");
						tempIndex=0;
						tempIndexY++;
					}
					
					int minXCordinateNew = horizontalEndPointsList
							.get(tempIndex);
					int maxXCordinateNew = horizontalEndPointsList
							.get(tempIndex + 1);

					
					
					int minYCordinateNew = verticalEndPointList.get(tempIndexY);
					int maxYCordinateNew = verticalEndPointList
							.get(tempIndexY + 1);

					tempIndex++;
					
					
					System.out.println("minX="+minXCordinateNew);
					System.out.println("maxX="+maxXCordinateNew);
					
					System.out.println("minY="+minYCordinateNew);
					System.out.println("maxY="+maxYCordinateNew);
					
					double centreXCordinate = generateCentreCordinate(
							minXCordinateNew, maxXCordinateNew);

					double centreYCordinate = generateCentreCordinate(
							minYCordinateNew, maxYCordinateNew);
					
					List<Integer> xCorList = new ArrayList<Integer>();
					List<Integer> yCorList = new ArrayList<Integer>();
					for (int xCorInd = minXCordinateNew; xCorInd < maxXCordinateNew; xCorInd++) {
						xCorList.add(xCorInd);
					}
					for (int yCorInd = minYCordinateNew; yCorInd < maxYCordinateNew; yCorInd++) {
						yCorList.add(yCorInd);
					}

					int noOfNodesPerZone = noOfNodesPerZoneList.get(verIndex);
					
					System.out.println("noOfNodesPerZones="+noOfNodesPerZone+"ver index="+verIndex);
					
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW
							+ METHOD + "getSquareTopology" + ARROW
							+ "Start For Loop" + verIndex);
					for (int nodeIndex = 1; nodeIndex <= noOfNodesPerZone; nodeIndex++) {
						TopologyInfoValue topologyInfoValue = new TopologyInfoValue();
						NodeCordinateValue nodeCordinateValue = new NodeCordinateValue();
						NodeParameters nodeParametersTemp = new NodeParameters();
						Random rand = new Random();
						int randomIndexX = rand.nextInt(xCorList.size());
						int randomIndexY = rand.nextInt(yCorList.size());
						xcordinate = xCorList.get(randomIndexX);
						ycordinate = yCorList.get(randomIndexY);
						nodeCordinateValue.setX_cor(xcordinate);
						nodeCordinateValue.setY_cor(ycordinate);
						topologyInfoValue.setNodeId(nodeId);
						nodeId++;
						topologyInfoValue.setNodeCoordiante(nodeCordinateValue);
						nodeParametersTemp
								.setAvailableBatteryPower(initialBatteryPower);
						int zoneBelong = verIndex;
						nodeParametersTemp.setZoneId(zoneBelong + 1);
						nodeParametersTemp.setBuffer(initialBuffer);
						nodeParametersTemp.setEnergy(intialEnergy);
						nodeParametersTemp.setNetworkCost(initialNetworkCost);
						nodeParametersTemp.setTrustLevel(trustLevel);
						topologyInfoValue.setNodeParameters(nodeParametersTemp);
						CentreCordinate centreCordinate=new CentreCordinate();
						centreCordinate.setxCorCentre(centreXCordinate);
						centreCordinate.setyCorCentre(centreYCordinate);
						LeaderInfoValue leaderInfoValue = new LeaderInfoValue();
						leaderInfoValue.setLeader(Boolean.FALSE);
						topologyInfoValue.setLeaderInfo(leaderInfoValue);
						topologyInfoValue.setCentreCordinates(centreCordinate);
						squareTopology.add(topologyInfoValue);
					}
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW
							+ METHOD + "getSquareTopology" + ARROW
							+ "End For Loop" + verIndex);
				}
			}
		} 
		catch(ArrayIndexOutOfBoundsException a)
		{
			System.out.println("Exception"+a.getMessage());
			a.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return squareTopology;
	}

	private double generateCentreCordinate(int min, int max) {
		double centreToAdd = (double) (max - min) / 2;
		double centre = min + centreToAdd;
		return centre;
	}
	
	
	/**
	 * @param s
	 */
	public static void main(String s[])
	{
		
		TopologyGenerationIF topologyGenerationIF=new TopologyGenerationImpl();
		
		TopologyCriteriaValue topologyCriteriaValue=new TopologyCriteriaValue();
		
		topologyCriteriaValue.setNoOfNodes(50);
		
		topologyCriteriaValue.setMinXCordinate(1);
		
		topologyCriteriaValue.setMaxXCordinate(50);
		
		topologyCriteriaValue.setMinYCordinate(1);
		topologyCriteriaValue.setMaxYCordinate(50);
		
		NodeParameters nodeParameters=new NodeParameters();
		
		nodeParameters.setBuffer(1000);
		nodeParameters.setEnergy(1000);
		nodeParameters.setAvailableBatteryPower(1000.25);
		nodeParameters.setNetworkCost(10);
		
		topologyCriteriaValue.setNodeParameters(nodeParameters);
		List<TopologyInfoValue>  topoList=topologyGenerationIF.getRandomTopology(topologyCriteriaValue);
		
		
		
		for(int i=0;i<topoList.size();i++)
		{
			System.out.println("NodeId"+topoList.get(i).getNodeId());
			System.out.println("Xcor="+topoList.get(i).getNodeCoordiante().getX_cor());
			System.out.println("Ycor="+topoList.get(i).getNodeCoordiante().getY_cor());
		}
		
		
		
		
	}
	
	

}
