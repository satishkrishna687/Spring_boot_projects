package com.algorithms.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.algorithms.service.inter.BetweenCentralityServiceIF;
import com.framework.constants.FrameworkConstantsIF;
import com.routing.formulas.impl.FormulaImpl;
import com.routing.formulas.inter.FormulaIF;
import com.routingtopology.constants.ParametersTypeIF;
import com.routingtopology.constants.TopologyTypesIF;
import com.routingtopology.service.impl.ParametersServiceImpl;
import com.routingtopology.service.impl.RoutingTableServiceImpl;
import com.routingtopology.service.impl.TopologyRoutingServiceImpl;
import com.routingtopology.value.BetweenCentralityCriteria;
import com.routingtopology.value.BetweenCentralityRouteInfo;
import com.routingtopology.value.DeadNodesInfo;
import com.routingtopology.value.ErrorMsgObj;
import com.routingtopology.value.NodeParameters;
import com.routingtopology.value.ParameterValue;
import com.routingtopology.value.RouteInfo;
import com.routingtopology.value.TopologyInfoValue;

@Service
public class BetweenCentralityRoutingServiceImpl implements BetweenCentralityServiceIF {

	@Autowired
	private RoutingTableServiceImpl routingTableServiceIF;

	@Autowired
	private ParametersServiceImpl parametersServiceIF;

	@Autowired
	private TopologyRoutingServiceImpl topologyRoutingServiceIF;

	@Override
	public BetweenCentralityRouteInfo findBetweenCentralityRoutes(BetweenCentralityCriteria dsdvCriteria,
			String topologyType) {

		BetweenCentralityRouteInfo betweenCentrailityRouteInfo = null;
		try {

			betweenCentrailityRouteInfo = new BetweenCentralityRouteInfo();
			if (dsdvCriteria != null) {

				int sourceNode = dsdvCriteria.getSourceNode();
				int destinationNode = dsdvCriteria.getDestinationNode();

				boolean srcNodeCorrect = validateSourceNode(sourceNode);
				if (!srcNodeCorrect) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.SOURCENODE_EMPTY);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					betweenCentrailityRouteInfo.setErrorList(errormSgObj);
					betweenCentrailityRouteInfo.setStatus(false);
					return betweenCentrailityRouteInfo;
				}

				boolean destNodeCorrect = validateDestNode(destinationNode);

				if (!destNodeCorrect) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(2);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.DESTNODE_EMPTY);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					betweenCentrailityRouteInfo.setErrorList(errormSgObj);
					betweenCentrailityRouteInfo.setStatus(false);
					return betweenCentrailityRouteInfo;
				}

				if (sourceNode == destinationNode) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.ROUTE_EMPTY_SNSAME);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					betweenCentrailityRouteInfo.setErrorList(errormSgObj);
					betweenCentrailityRouteInfo.setStatus(false);
					return betweenCentrailityRouteInfo;
				}

				boolean rangeCheck = validateRange(dsdvCriteria);
				if (!rangeCheck) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(3);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.COVERAGEAREA_EMPTY);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					betweenCentrailityRouteInfo.setErrorList(errormSgObj);
					betweenCentrailityRouteInfo.setStatus(false);
					return betweenCentrailityRouteInfo;
				}

				double range = dsdvCriteria.getCoverageArea();
				List<Integer> neigbours = routingTableServiceIF.getNeigbours(topologyType, sourceNode, range);
				if (null == neigbours) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.NONEIGBOURS_FOUND);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					betweenCentrailityRouteInfo.setErrorList(errormSgObj);
					betweenCentrailityRouteInfo.setStatus(false);
					return betweenCentrailityRouteInfo;
				}

				double thresholdBattery = dsdvCriteria.getThresholdBattery();

				if (thresholdBattery <= 0.0) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.THBATTERY_EMPTY);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					betweenCentrailityRouteInfo.setErrorList(errormSgObj);
					betweenCentrailityRouteInfo.setStatus(false);
					return betweenCentrailityRouteInfo;
				}

				double energyForTx = dsdvCriteria.getEnergyTx();

				if (energyForTx <= 0.0) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.ENERGYTX_ERROR);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					betweenCentrailityRouteInfo.setErrorList(errormSgObj);
					betweenCentrailityRouteInfo.setStatus(false);
					return betweenCentrailityRouteInfo;
				}

				double energyForAmp = dsdvCriteria.getEnergyAmp();

				if (energyForAmp <= 0.0) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.ENERGYFORAMP_EMPTY);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					betweenCentrailityRouteInfo.setErrorList(errormSgObj);
					betweenCentrailityRouteInfo.setStatus(false);
					return betweenCentrailityRouteInfo;
				}

				double attFactor = dsdvCriteria.getAttFactor();

				if (attFactor <= 0.0) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.ATTFACTOR_EMPTY);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					betweenCentrailityRouteInfo.setErrorList(errormSgObj);
					betweenCentrailityRouteInfo.setStatus(false);
					return betweenCentrailityRouteInfo;
				}

				int maxIterations = dsdvCriteria.getMaxIterations();

				if (maxIterations <= 1) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.NO_OF_ITERATIONS_EMPTY);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					betweenCentrailityRouteInfo.setErrorList(errormSgObj);
					betweenCentrailityRouteInfo.setStatus(false);
					return betweenCentrailityRouteInfo;
				}

				double dataRateOfRoute = dsdvCriteria.getDataRateOfRoute();

				if (dataRateOfRoute <= 0.0) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.DATARATE_EMPTY);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					betweenCentrailityRouteInfo.setErrorList(errormSgObj);
					betweenCentrailityRouteInfo.setStatus(false);
					return betweenCentrailityRouteInfo;
				}

				// This is storing the routes information
				List<RouteInfo> routeInfoList = new ArrayList<RouteInfo>();

				// neigbours

				Set<Integer> globalNeighborsSet = new HashSet<Integer>();

				Set<Integer> globalNeighborsSetTemp = new HashSet<Integer>();

				globalNeighborsSetTemp.addAll(neigbours);

				Iterator<Integer> it = globalNeighborsSetTemp.iterator();

				while (it.hasNext()) {
					int nodeId = (Integer) it.next();
					globalNeighborsSet.add(nodeId);
					List<Integer> tempNeigbors = routingTableServiceIF.getNeigbours(topologyType, nodeId, range);

					for (Integer node : tempNeigbors) {
						List<Integer> tempNeigbors1 = routingTableServiceIF.getNeigbours(topologyType, node, range);
						globalNeighborsSet.addAll(tempNeigbors1);
					}

					globalNeighborsSet.addAll(tempNeigbors);
				}

				globalNeighborsSet.remove(sourceNode);

				// Starting the Route Discovery

				double timeTaken = 0;
				double totalEnergyConsumed = 0;
				int totalNoOfHops = 0;

				Map<Double, Integer> mapBetweenessCentrality = new HashMap<Double, Integer>();

				List<Double> timeTakenList = new ArrayList<Double>();

				List<Double> bestBetweenCentralityList = new ArrayList<Double>();

				Iterator<Integer> itNew = globalNeighborsSet.iterator();
				int i = 0;
				while (itNew.hasNext()) {

					double startTime = System.currentTimeMillis();

					int sourceNodeTemp = itNew.next();

					List<Integer> routeNodes1 = findRouteUsingBetweenCentralityAlgo(sourceNodeTemp, destinationNode,
							range, topologyType, maxIterations, energyForTx, energyForAmp, attFactor);

					// Obtain Actual Route
					List<Integer> routeNodes = new ArrayList<Integer>();
					routeNodes.add(sourceNode);
					routeNodes.addAll(routeNodes1);

					double endTime = System.currentTimeMillis();

					double timeTakenMillis = endTime - startTime;

					double timeTakenInSeconds = ((double) ((double) timeTakenMillis));

					timeTaken = timeTaken + timeTakenInSeconds;

					RouteInfo routeInfo = new RouteInfo();

					routeInfo.setRouteList(routeNodes);

					double energyConsumedOnRoute = computeEnergyConsumedOnRoute(routeNodes, topologyType, energyForTx,
							energyForAmp, attFactor);
					totalEnergyConsumed = totalEnergyConsumed + energyConsumedOnRoute;

					// Compute Distance
					double computedDistance = computeDistanceOnRoute(routeNodes, topologyType);

					timeTakenList.add(timeTakenInSeconds);

					double betweenNessCentrality = ((double) routeNodes1.size()) / ((double) computedDistance);

					bestBetweenCentralityList.add(betweenNessCentrality);

					mapBetweenessCentrality.put(betweenNessCentrality, i);

					int noOfHops = routeNodes.size();
					totalNoOfHops = totalNoOfHops + noOfHops;

					routeInfo.setTimeTakenForRouteDiscovery(timeTakenInSeconds);
					routeInfo.setDistance(computedDistance);
					routeInfo.setEnergyConsumedOnRoute(energyConsumedOnRoute);
					routeInfo.setNoOfHops(noOfHops);

					routeInfoList.add(routeInfo);
					i = i + 1;

				}

				betweenCentrailityRouteInfo.setRouteInfoList(routeInfoList);

				// Adding the time Taken Information
				betweenCentrailityRouteInfo.setTimeTaken(timeTaken);

				betweenCentrailityRouteInfo.setEnergyConsumed(totalEnergyConsumed);

				betweenCentrailityRouteInfo.setNoOfHopsConsumed(totalNoOfHops);

				betweenCentrailityRouteInfo.setBestBetweenCentralityList(bestBetweenCentralityList);

				betweenCentrailityRouteInfo.setMapBetweenessCentrality(mapBetweenessCentrality);

				// Compute Nodes which are dead

				List<DeadNodesInfo> deadNodesList = obtainTheListOfDeadNodes(routeInfoList, thresholdBattery);

				betweenCentrailityRouteInfo.setDeadNodes(deadNodesList);

				int noOfDeadNodes = deadNodesList.size();

				// Set Number of Dead Nodes
				betweenCentrailityRouteInfo.setNoOfDeadNodes(noOfDeadNodes);

				// Compute Number of Alive Nodes

				int totalNoOfNodes = 0;

				if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
					totalNoOfNodes = topologyRoutingServiceIF.retriveLinearTopologyCount();
				}
				if (topologyType.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {
					totalNoOfNodes = topologyRoutingServiceIF.retriveRandomTopologyCount();
				}
				int noOfAliveNodes = totalNoOfNodes - noOfDeadNodes;

				if (noOfAliveNodes < 0) {
					noOfAliveNodes = 0;
				}

				betweenCentrailityRouteInfo.setNoOfAliveNodes(noOfAliveNodes);

				// This is Map of Routing Information
				// Find the best Route Between
				double bestBetweenCentrality = 0;
				if (mapBetweenessCentrality != null && mapBetweenessCentrality.size() > 0) {

					// Best Time Taken
					double bestTimeTaken = Collections.min(timeTakenList);
					betweenCentrailityRouteInfo.setBestTimeTaken(bestTimeTaken);

					bestBetweenCentrality = Collections.min(bestBetweenCentralityList);

					int routeNo = mapBetweenessCentrality.get(bestBetweenCentrality);

					RouteInfo bestRouteInfo = routeInfoList.get(routeNo);

					betweenCentrailityRouteInfo.setBestRoueInfo(bestRouteInfo);

				}

				betweenCentrailityRouteInfo.setBestBetweenCentrality(bestBetweenCentrality);

				// Lifetime Ratio
				double lifeTimeRatio = 0;
				if (noOfDeadNodes == 0) {
					lifeTimeRatio = 1;
				} else {

					lifeTimeRatio = (double) ((double) noOfAliveNodes / (double) noOfDeadNodes);

				}

				betweenCentrailityRouteInfo.setLifeTimeRatio(lifeTimeRatio);

				// Routing Overhead
				double routingOverhead = (double) ((double) (2 * totalNoOfHops) / (double) dataRateOfRoute);

				betweenCentrailityRouteInfo.setRoutingOverhead(routingOverhead);

				// Throughput
				double throughput = (double) ((double) dataRateOfRoute / (double) timeTaken);

				betweenCentrailityRouteInfo.setThroughput(throughput);

				betweenCentrailityRouteInfo.setStatus(true);

			}

		} catch (Exception e) {
			System.out.println("Exception has Occured");
			System.out.println("Class Name: [FaultNodeRecoveryServiceImpl] Method Name:[findRoutes]");
			System.out.println(e.getMessage());
			betweenCentrailityRouteInfo = new BetweenCentralityRouteInfo();
			betweenCentrailityRouteInfo.setStatus(false);
			betweenCentrailityRouteInfo.setExceptionDetails(e.getStackTrace().toString());
			betweenCentrailityRouteInfo.setExceptionInfo(e.getMessage());
			return betweenCentrailityRouteInfo;
		}
		return betweenCentrailityRouteInfo;
	}

	/*
	 * Remember the Number of Dead Nodes Can Repeat per Route
	 */

	private List<DeadNodesInfo> obtainTheListOfDeadNodes(List<RouteInfo> routeInfoList, double thresholdBattery) {

		List<DeadNodesInfo> deadNodesList = new ArrayList<DeadNodesInfo>();
		for (RouteInfo routeInfo : routeInfoList) {
			List<Integer> nodes = routeInfo.getRouteList();
			for (Integer nodeId : nodes) {
				ParameterValue parameter = parametersServiceIF.retriveParameter(ParametersTypeIF.NETWORKCOST, nodeId);
				double batteryPower = parameter.getNetworkCost();

				if (batteryPower <= thresholdBattery) {
					DeadNodesInfo deadNodeInfo = new DeadNodesInfo();
					deadNodeInfo.setBatteryPower(batteryPower);
					deadNodeInfo.setNodeId(nodeId);
					deadNodesList.add(deadNodeInfo);
				}
			}
		}

		// Eliminate Repeated Dead Nodes

		List<DeadNodesInfo> newdeadNodesList = new ArrayList<DeadNodesInfo>();

		for (DeadNodesInfo deadNodesInfo : deadNodesList) {

			if (newdeadNodesList.size() == 0) {
				DeadNodesInfo deadNodesInfoTemp = new DeadNodesInfo();
				deadNodesInfoTemp.setBatteryPower(deadNodesInfo.getBatteryPower());
				deadNodesInfoTemp.setNodeId(deadNodesInfo.getNodeId());
				newdeadNodesList.add(deadNodesInfoTemp);
			}

			if (newdeadNodesList.size() > 0) {
				DeadNodesInfo deadNodesInfoTemp = new DeadNodesInfo();

				List<Integer> deadNodes = new ArrayList<Integer>();

				deadNodes = getListOfIntegerFromDeadNodes(newdeadNodesList);

				int nodeId = deadNodesInfo.getNodeId();

				if (deadNodes.contains(nodeId)) {
					continue;
				} else {
					deadNodesInfoTemp.setBatteryPower(deadNodesInfo.getBatteryPower());
					deadNodesInfoTemp.setNodeId(deadNodesInfo.getNodeId());
					newdeadNodesList.add(deadNodesInfoTemp);
				}

			}

		}

		return newdeadNodesList;
	}

	private List<Integer> getListOfIntegerFromDeadNodes(List<DeadNodesInfo> newdeadNodesList) {

		List<Integer> list = new ArrayList<Integer>();

		for (DeadNodesInfo deadNode : newdeadNodesList) {
			list.add(deadNode.getNodeId());
		}

		return list;

	}

	private double computeDistanceOnRoute(List<Integer> routeNodes, String topologyType) {
		double distance = 0.0;
		for (int i = 0; i < routeNodes.size(); i++) {
			int tableFromWhichToGet = routeNodes.get(i);
			if (i == routeNodes.size() - 1) {
				break;
			}
			int nodeIdWhereClause = routeNodes.get(i + 1);
			double distanceBetweenNodes = routingTableServiceIF.distance(tableFromWhichToGet, nodeIdWhereClause,
					topologyType);
			distance = distance + distanceBetweenNodes;
		}
		return distance;
	}

	private boolean validateDestNode(int destinationNode) {
		boolean value = true;
		if (destinationNode <= 0) {

			value = false;
		}
		return value;
	}

	private boolean validateSourceNode(int sourceNode) {
		boolean value = true;
		if (sourceNode <= 0) {

			value = false;
		}
		return value;
	}

	private boolean checkNeigboursContainDest(List<Integer> neigbours, int destinationNode) {
		boolean check = false;

		if (!neigbours.isEmpty()) {
			if (neigbours.contains(destinationNode)) {
				check = true;
				return check;
			}
		}
		return check;
	}

	private List<Integer> removeNeigbourAndGetNewNeigbours(List<Integer> neigbours, int sourceNode) {

		List<Integer> newNeigbours = new ArrayList<Integer>();
		for (Integer neigbour : neigbours) {
			if (neigbour == sourceNode) {
				continue;
			}
			newNeigbours.add(neigbour);
		}
		return newNeigbours;

	}

	private List<Integer> findRouteUsingBetweenCentralityAlgo(int sourceNode, int destinationNode, double coverageArea,
			String topologyType, int maxIterations, double energyForTx, double energyForAmp, double attFactor) {
		List<Integer> nodes = null;

		try {
			nodes = new ArrayList<Integer>();
			nodes.add(sourceNode);
			int index = 0;
			while ((sourceNode != destinationNode)) {

				index = index + 1;
				if (index == maxIterations) {
					return nodes;
				}
				/* getting neigbours */
				List<Integer> neigbours = routingTableServiceIF.getNeigbours(topologyType, sourceNode, coverageArea);

				neigbours = removeNeigbourAndGetNewNeigbours(neigbours, sourceNode);
				System.out.println("Neigbours of Source Node[" + sourceNode + "]" + neigbours);

				/* checking if neigbours contains destination */
				boolean checkNeigbour = checkNeigboursContainDest(neigbours, destinationNode);
				System.out.println("Check Neigbours--" + checkNeigbour);

				if (checkNeigbour) {

					sourceNode = destinationNode;

					/* Storing the node */
					nodes.add(destinationNode);
					break;
				}
				if (!checkNeigbour) {
					sourceNode = pickNeigbourRandomly(neigbours);
					nodes.add(sourceNode);
					System.out.println("Node Picked Up" + sourceNode);
				}

				if (null != nodes && !nodes.isEmpty()) {
					if (nodes.size() >= 2) {
						//
						int size = nodes.size();
						int curNode = nodes.get(size - 2);
						int nextNode = nodes.get(size - 1);
						updateNodesBattery(curNode, nextNode, topologyType, energyForTx, energyForAmp, attFactor);
					}
				}

			}
		} catch (Exception e) {

		}
		return nodes;
	}

	private Integer pickNeigbourRandomly(List<Integer> nodeIds) {
		int nextNeigbour = 0;

		if (nodeIds != null) {
			int size = nodeIds.size();
			Random rand = new Random();
			int value = rand.nextInt(size);
			nextNeigbour = nodeIds.get(value);
		}
		return nextNeigbour;
	}

	private boolean validateRange(BetweenCentralityCriteria findRoute) {
		boolean value = true;
		double range = findRoute.getCoverageArea();
		if (range <= 0) {

			value = false;
		}
		return value;
	}

	private double computeEnergyConsumedOnRoute(List<Integer> routeNodes, String topologyType, double energyTx,
			double energyAmp, double attFactor) {

		FormulaIF formulaIF = new FormulaImpl();
		double totalEnergyConsumed = 0.0;
		for (int i = 0; i < routeNodes.size(); i++) {
			int tableFromWhichToGet = routeNodes.get(i);
			if (i == routeNodes.size() - 1) {
				break;
			}
			int nodeIdWhereClause = routeNodes.get(i + 1);
			double distanceBetweenNodes = routingTableServiceIF.distance(tableFromWhichToGet, nodeIdWhereClause,
					topologyType);
			double powerConsumed = formulaIF.eneryConsumedFormulaForWSN(distanceBetweenNodes, 1, energyTx, energyAmp,
					attFactor);
			totalEnergyConsumed += powerConsumed;
		}
		return totalEnergyConsumed;
	}

	/**
	 * @param s
	 */
	public static void main(String s[]) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("topology-routing.xml");

		BetweenCentralityServiceIF gradeIf = (BetweenCentralityServiceIF) ctx.getBean("dsdvServiceBean");

		BetweenCentralityCriteria findRouteC = new BetweenCentralityCriteria();

		findRouteC.setAttFactor(0.5);
		findRouteC.setCoverageArea(40);
		findRouteC.setDataRateOfRoute(100);
		findRouteC.setDestinationNode(30);
		findRouteC.setEnergyAmp(0.5);
		findRouteC.setEnergyTx(1);
		findRouteC.setEnvironmentFactor(0.5);
		findRouteC.setPowerTransmission(1);
		findRouteC.setSourceNode(2);
		findRouteC.setThresholdBattery(200);
		findRouteC.setTtl(4);
		findRouteC.setMaxIterations(100);
		BetweenCentralityRouteInfo gradeRouteInf0 = gradeIf.findBetweenCentralityRoutes(findRouteC,
				TopologyTypesIF.LINEAR_TOPOLOGY);

		RouteInfo routeList = gradeRouteInf0.getRouteInfo();

		System.out.println("Fault Node Information" + routeList.getRouteList());

		System.out.println("Dead Nodes" + gradeRouteInf0.getNoOfDeadNodes());

	}

	/*
	 * public double eneryConsumedFormulaForWSN(double totaldistance, double
	 * noOfHops, double energyForTx, double energyForAmp, double
	 * auttunationFactor)
	 */

	private void updateNodesBattery(int curNode, int nextNode, String topologyType, double energyForTx,
			double energyForAmp, double attFactor) {

		FormulaIF formula = new FormulaImpl();
		ParameterValue parameterV = parametersServiceIF.retriveParameter(ParametersTypeIF.NETWORKCOST, curNode);
		double currentPower = parameterV.getNetworkCost();
		int tableFromWhichToGet = curNode;
		int nodeIdWhereClause = nextNode;
		double distanceBetweenNodes = routingTableServiceIF.distance(tableFromWhichToGet, nodeIdWhereClause,
				topologyType);
		double energyConsumed = formula.eneryConsumedFormulaForWSN(distanceBetweenNodes, 1, energyForTx, energyForAmp,
				attFactor);
		double powerToUpdate = currentPower - energyConsumed;
		if (powerToUpdate < 0) {
			powerToUpdate = 0;
		}
		parametersServiceIF.deleteSpecficParameter(ParametersTypeIF.NETWORKCOST, tableFromWhichToGet);

		TopologyInfoValue topologyInfoValue = new TopologyInfoValue();
		NodeParameters nodeParameters = new NodeParameters();
		nodeParameters.setNetworkCost(powerToUpdate);
		topologyInfoValue.setNodeParameters(nodeParameters);
		parametersServiceIF.insertSingleParameter(ParametersTypeIF.NETWORKCOST, tableFromWhichToGet, topologyInfoValue);
	}

}
