package com.algorithms.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.algorithms.service.inter.OptimizedServiceIF;
import com.constants.EEDRServerMessages;
import com.framework.constants.FrameworkConstantsIF;
import com.model.EEDRTempComputationObj;
import com.model.NeigborPickEEDRTemp;
import com.routing.formulas.impl.FormulaImpl;
import com.routing.formulas.inter.FormulaIF;
import com.routingtopology.constants.ParametersTypeIF;
import com.routingtopology.constants.TopologyTypesIF;
import com.routingtopology.service.impl.ParametersServiceImpl;
import com.routingtopology.service.impl.RoutingTableServiceImpl;
import com.routingtopology.service.impl.TopologyRoutingServiceImpl;
import com.routingtopology.service.inter.ParametersServiceIF;
import com.routingtopology.service.inter.RoutingTableServiceIF;
import com.routingtopology.service.inter.TopologyRoutingServiceIF;
import com.routingtopology.value.DeadNodesInfo;
import com.routingtopology.value.OptimizedCriteria;
import com.routingtopology.value.OptimizedRouteInfo;
import com.routingtopology.value.ErrorMsgObj;
import com.routingtopology.value.NodeParameters;
import com.routingtopology.value.ParameterValue;
import com.routingtopology.value.RouteInfo;
import com.routingtopology.value.TopologyInfoValue;

@Service
public class OptimizedRoutingServiceImpl implements OptimizedServiceIF {

	@Autowired
	private RoutingTableServiceImpl routingTableServiceIF;

	@Autowired
	private ParametersServiceImpl parametersServiceIF;

	@Autowired
	private TopologyRoutingServiceImpl topologyRoutingServiceIF;

	@Override
	public OptimizedRouteInfo findOptimizedRoutes(OptimizedCriteria eedrCriteria, String topologyType) {

		OptimizedRouteInfo eedrRouteInfo = null;

		try {
			eedrRouteInfo = new OptimizedRouteInfo();
			if (eedrCriteria != null) {

				int sourceNode = eedrCriteria.getSourceNode();
				int destinationNode = eedrCriteria.getDestinationNode();

				boolean srcNodeCorrect = validateSourceNode(sourceNode);
				if (!srcNodeCorrect) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.SOURCENODE_EMPTY);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					eedrRouteInfo.setErrorList(errormSgObj);
					eedrRouteInfo.setStatus(false);
					return eedrRouteInfo;
				}

				boolean destNodeCorrect = validateDestNode(destinationNode);

				if (!destNodeCorrect) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(2);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.DESTNODE_EMPTY);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					eedrRouteInfo.setErrorList(errormSgObj);
					eedrRouteInfo.setStatus(false);
					return eedrRouteInfo;
				}

				if (sourceNode == destinationNode) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.ROUTE_EMPTY_SNSAME);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					eedrRouteInfo.setErrorList(errormSgObj);
					eedrRouteInfo.setStatus(false);
					return eedrRouteInfo;
				}

				boolean rangeCheck = validateRange(eedrCriteria);
				if (!rangeCheck) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(3);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.COVERAGEAREA_EMPTY);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					eedrRouteInfo.setErrorList(errormSgObj);
					eedrRouteInfo.setStatus(false);
					return eedrRouteInfo;
				}

				double range = eedrCriteria.getCoverageArea();
				List<Integer> neigbours = routingTableServiceIF.getNeigbours(topologyType, sourceNode, range);
				if (null == neigbours) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.NONEIGBOURS_FOUND);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					eedrRouteInfo.setErrorList(errormSgObj);
					eedrRouteInfo.setStatus(false);
					return eedrRouteInfo;
				}

				double thresholdBattery = eedrCriteria.getThresholdBattery();

				if (thresholdBattery <= 0.0) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.THBATTERY_EMPTY);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					eedrRouteInfo.setErrorList(errormSgObj);
					eedrRouteInfo.setStatus(false);
					return eedrRouteInfo;
				}

				double dataRateOfRoute = eedrCriteria.getDataRateOfRoute();

				if (dataRateOfRoute <= 0.0) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.DATARATE_EMPTY);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					eedrRouteInfo.setErrorList(errormSgObj);
					eedrRouteInfo.setStatus(false);
					return eedrRouteInfo;
				}

				double energyForTx = eedrCriteria.getEnergyTx();

				if (dataRateOfRoute <= 0.0) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.ENERGYFORTX_EMPTY);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					eedrRouteInfo.setErrorList(errormSgObj);
					eedrRouteInfo.setStatus(false);
					return eedrRouteInfo;
				}

				double energyForAmp = eedrCriteria.getEnergyAmp();

				if (energyForAmp <= 0.0) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.ENERGYFORAMP_EMPTY);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					eedrRouteInfo.setErrorList(errormSgObj);
					eedrRouteInfo.setStatus(false);
					return eedrRouteInfo;
				}

				double attFactor = eedrCriteria.getAttFactor();

				if (attFactor <= 0.0) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.ATTFACTOR_EMPTY);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					eedrRouteInfo.setErrorList(errormSgObj);
					eedrRouteInfo.setStatus(false);
					return eedrRouteInfo;
				}

				int TTL = eedrCriteria.getTtl();

				if (TTL <= 0) {
					ErrorMsgObj errorMsgObj = new ErrorMsgObj();
					errorMsgObj.setErrorId(1);
					errorMsgObj.setErrMsg(FrameworkConstantsIF.TTL_EMPTY);
					List<ErrorMsgObj> errormSgObj = new ArrayList<ErrorMsgObj>();
					errormSgObj.add(errorMsgObj);
					eedrRouteInfo.setErrorList(errormSgObj);
					eedrRouteInfo.setStatus(false);
					return eedrRouteInfo;
				}

				int totalNoOfHops = 0;
				double totalEnergyConsumed = 0;
				double totalTimeTaken = 0;

				Map<Double, Integer> mapCQIRouteNo = new HashMap<Double, Integer>();

				List<Double> CQIList = new ArrayList<Double>();
				// This is storing the routes information
				List<RouteInfo> routeInfoList = new ArrayList<RouteInfo>();

				neigbours.remove(sourceNode);

				for (int i = 0; i < neigbours.size(); i++) {

					double CQIRoute = 0;

					int sourceNodeTemp = neigbours.get(i);

					double startTime = System.currentTimeMillis();
					EEDRTempComputationObj eedrTempComputationObj = findRouteUsingOptimizedAlgo(sourceNodeTemp,
							destinationNode, range, topologyType, thresholdBattery, TTL, energyForTx, energyForAmp,
							attFactor, eedrCriteria.getFreq(), eedrCriteria.getInitialNoiseFigure(),
							eedrCriteria.getSignalBW(), eedrCriteria.getNoiseFigure(), energyForTx,
							eedrCriteria.getPowerGain(), CQIRoute);

					CQIList.add(eedrTempComputationObj.getCQI());

					mapCQIRouteNo.put(eedrTempComputationObj.getCQI(), i);

					// Obtain Actual Route
					List<Integer> routeNodes = new ArrayList<Integer>();
					routeNodes.add(sourceNode);
					routeNodes.addAll(eedrTempComputationObj.getRoute());

					double endTime = System.currentTimeMillis();

					double timeTakenMillis = endTime - startTime;

					double timeTakenInSeconds = ((double) ((double) timeTakenMillis));

					totalTimeTaken = totalTimeTaken + timeTakenInSeconds;
					RouteInfo routeInfo = new RouteInfo();

					routeInfo.setRouteList(routeNodes);

					double energyConsumedOnRoute = computeEnergyConsumedOnRoute(routeNodes, topologyType, energyForTx,
							energyForAmp, attFactor);

					// Compute Distance
					int noOfHops = routeNodes.size();

					totalEnergyConsumed = totalEnergyConsumed + energyConsumedOnRoute;
					totalNoOfHops = totalNoOfHops + noOfHops;
					routeInfo.setTimeTakenForRouteDiscovery(timeTakenInSeconds);
					routeInfo.setEnergyConsumedOnRoute(energyConsumedOnRoute);
					routeInfo.setNoOfHops(noOfHops);
					routeInfo.setcQIRoute(CQIRoute);

					routeInfoList.add(routeInfo);
					// Compute Energy Consumed

				}

				eedrRouteInfo.setEnergyConsumed(totalEnergyConsumed);
				eedrRouteInfo.setTimeTaken(totalTimeTaken);
				eedrRouteInfo.setNoOfHopsConsumed(totalNoOfHops);
				eedrRouteInfo.setRouteInfoList(routeInfoList);

				// Find the best Route Between
				if (mapCQIRouteNo != null && mapCQIRouteNo.size() > 0) {

					// Best CQI
					double bestRouteCQI = Collections.max(CQIList);
					eedrRouteInfo.setBestRouteCQI(bestRouteCQI);

					int routeNo = mapCQIRouteNo.get(bestRouteCQI);

					if (routeNo >= routeInfoList.size()) {
						routeNo = routeInfoList.size() - 1;
					}

					RouteInfo bestRouteInfo = routeInfoList.get(routeNo);

					eedrRouteInfo.setBestRoueInfo(bestRouteInfo);

				}

				// Compute the Number of Dead Nodes
				List<DeadNodesInfo> deadNodesList = obtainTheListOfDeadNodes(routeInfoList, thresholdBattery);
				int noOfDeadNodes = 0;
				if (deadNodesList != null && !deadNodesList.isEmpty()) {
					noOfDeadNodes = deadNodesList.size();
					eedrRouteInfo.setNoOfDeadNodes(noOfDeadNodes);
				}

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

				eedrRouteInfo.setNoOfAliveNodes(noOfAliveNodes);

				// Lifetime Ratio
				double lifeTimeRatio = 0;
				if (noOfDeadNodes == 0) {
					lifeTimeRatio = 1;
				} else {

					lifeTimeRatio = (double) ((double) noOfAliveNodes / (double) noOfDeadNodes);

				}

				eedrRouteInfo.setLifeTimeRatio(lifeTimeRatio);

				// Routing Overhead
				double routingOverhead = (double) ((double) (2 * totalNoOfHops) / (double) dataRateOfRoute);

				eedrRouteInfo.setRoutingOverhead(routingOverhead);

				// Throughput
				double throughput = (double) ((double) dataRateOfRoute / (double) totalTimeTaken);

				eedrRouteInfo.setThroughput(throughput);

				eedrRouteInfo.setStatus(true);

			}

		} catch (Exception e) {
			System.out.println("Exception has Occured");
			System.out.println("Class Name: [FaultNodeRecoveryServiceImpl] Method Name:[findRoutes]");
			System.out.println(e.getMessage());
			eedrRouteInfo = new OptimizedRouteInfo();
			eedrRouteInfo.setStatus(false);
			eedrRouteInfo.setExceptionDetails(e.getStackTrace().toString());
			eedrRouteInfo.setExceptionInfo(e.getMessage());
			return eedrRouteInfo;
		}
		return eedrRouteInfo;
	}

	/*
	 * Remember the Number of Dead Nodes Can Repeat per Route
	 */

	private List<DeadNodesInfo> obtainTheListOfDeadNodes(List<RouteInfo> routeInfoList, double thresholdBattery) {

		List<DeadNodesInfo> deadNodesList = new ArrayList<DeadNodesInfo>();
		for (RouteInfo routeInfo : routeInfoList) {
			List<Integer> nodes = routeInfo.getRouteList();
			for (Integer nodeId : nodes) {
				ParameterValue parameter = parametersServiceIF.retriveParameter(ParametersTypeIF.ENERGY, nodeId);
				double batteryPower = parameter.getEnergy();

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

	private List<Integer> removeRoutesWhichDoNotSatisfyNodeLevel(List<RouteInfo> routeInfoList, String topologyType,
			double thresholdBattery) {
		List<Integer> routeToEliminate = new ArrayList<Integer>();
		for (RouteInfo routeInfo : routeInfoList) {
			List<Integer> nodes = routeInfo.getRouteList();
			int index = 0;
			for (Integer nodeId : nodes) {
				ParameterValue parameter = parametersServiceIF.retriveParameter(ParametersTypeIF.POWER, nodeId);
				double batteryPower = parameter.getPower();

				if (batteryPower <= thresholdBattery) {
					routeToEliminate.add(index);
					break;
				}
			}
		}
		return routeToEliminate;
	}

	private void updateBatteryPowersOfNode(List<RouteInfo> routeInfoList, double energyTx, double energyForAmp,
			double attFact, String topologyType) {

		FormulaIF formula = new FormulaImpl();
		for (RouteInfo routeInfo : routeInfoList) {
			List<Integer> routeNodes = routeInfo.getRouteList();

			for (int i = 0; i < routeNodes.size(); i++) {
				if (i == routeNodes.size() - 1) {
					break;
				}
				ParameterValue parameterV = parametersServiceIF.retriveParameter(ParametersTypeIF.ENERGY,
						routeNodes.get(i));
				double currentPower = parameterV.getEnergy();
				int tableFromWhichToGet = routeNodes.get(i);
				int nodeIdWhereClause = routeNodes.get(i + 1);
				double distanceBetweenNodes = routingTableServiceIF.distance(tableFromWhichToGet, nodeIdWhereClause,
						topologyType);
				double powerConsumed = formula.eneryConsumedFormulaForWSN(distanceBetweenNodes, 1, energyTx,
						energyForAmp, attFact);

				double powerToUpdate = currentPower - powerConsumed;
				if (powerToUpdate < 0) {
					powerToUpdate = 0;
				}
				parametersServiceIF.deleteSpecficParameter(ParametersTypeIF.ENERGY, tableFromWhichToGet);

				TopologyInfoValue topologyInfoValue = new TopologyInfoValue();
				NodeParameters nodeParameters = new NodeParameters();
				nodeParameters.setEnergy(powerToUpdate);
				topologyInfoValue.setNodeParameters(nodeParameters);
				parametersServiceIF.insertSingleParameter(ParametersTypeIF.ENERGY, tableFromWhichToGet,
						topologyInfoValue);
			}
		}
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

	private EEDRTempComputationObj findRouteUsingOptimizedAlgo(int sourceNode, int destinationNode, double coverageArea,
			String topologyType, double thresholdBattery, int TTL, double energyForTx, double energyForAmp,
			double attFactor, double freq, double initialNoiseFigure, double signalBW, double noiseFigure,
			double transmissionPower, double powerGain, double CQIRoute) {

		EEDRTempComputationObj eedrTempComputationObj = new EEDRTempComputationObj();
		List<Integer> nodes = null;

		try {
			nodes = new ArrayList<Integer>();
			nodes.add(sourceNode);
			while ((sourceNode != destinationNode)) {

				while ((TTL != 0)) {

					int sizeOfList = nodes.size();

					int previousSourceNode = 0;
					if (sizeOfList <= 1) {
						previousSourceNode = nodes.get(sizeOfList - 1);
					}
					if (sizeOfList >= 2) {
						previousSourceNode = nodes.get(sizeOfList - 2);
					}
					System.out.println("Previous Node" + previousSourceNode);

					/* getting neigbours */

					List<Integer> neigbours = routingTableServiceIF.getNeigbours(topologyType, sourceNode,
							coverageArea);

					neigbours = removeNeigbourAndGetNewNeigbours(neigbours, sourceNode);

					System.out.println("Neigbours of Source Node[" + sourceNode + "]" + neigbours);

					/* checking if neigbours contains destination */
					boolean checkNeigbour = checkNeigboursContainDest(neigbours, destinationNode);
					System.out.println("Check Neigbours--" + checkNeigbour);

					if (checkNeigbour) {

						sourceNode = destinationNode;

						/* Storing the node */
						nodes.add(destinationNode);
						TTL = 0;
						break;
					}
					if (!checkNeigbour) {
						double CQITemp = 0;

						NeigborPickEEDRTemp nodePickTemp = pickNodeWhichHasMaximumBatteryAndCQI(neigbours, sourceNode,
								freq, initialNoiseFigure, signalBW, noiseFigure, energyForTx, powerGain, CQITemp,
								topologyType);
						CQIRoute = CQIRoute + nodePickTemp.getcQI();
						sourceNode = nodePickTemp.getNodeId();
						nodes.add(sourceNode);
						System.out.println("Node Picked Up" + sourceNode);
					}
					/* decrementing TTL */
					TTL = TTL - 1;
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
				if (sourceNode != destinationNode) {
					/* if the TTL becomes zero callng the MinHOP ROUTING */

					if (TTL == 0) {
						/* get neigbours of sourceNode */
						List<Integer> neigbours = routingTableServiceIF.getNeigbours(topologyType, sourceNode,
								coverageArea);

						neigbours = removeNeigbourAndGetNewNeigbours(neigbours, sourceNode);
						boolean checkNeigbour = checkNeigboursContainDest(neigbours, destinationNode);
						System.out.println("Check Neigbours--" + checkNeigbour);

						if (checkNeigbour) {
							sourceNode = destinationNode;
							nodes.add(sourceNode);
							break;
						}

						System.out.println("Neigbours with TTL==0" + neigbours);
						/* check if neigbour contains destination */

						if (!checkNeigbour) {
							/* picking the neigbour */
							sourceNode = pickMinHopNeigbour(neigbours, destinationNode, topologyType);
							System.out.println("Min hop neigbour" + sourceNode);
							/* Storing the node */
							nodes.add(sourceNode);
						}
						if (null != nodes && !nodes.isEmpty()) {
							if (nodes.size() >= 2) {
								//
								int size = nodes.size();
								int curNode = nodes.get(size - 2);
								int nextNode = nodes.get(size - 1);
								updateNodesBattery(curNode, nextNode, topologyType, energyForTx, energyForAmp,
										attFactor);
							}
						}
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		System.out.println("CQI=" + CQIRoute);
		eedrTempComputationObj.setCQI(CQIRoute);
		eedrTempComputationObj.setRoute(nodes);
		return eedrTempComputationObj;

	}

	/*
	 * If the Customer of Fault Node Recovery requires battery constraint add it
	 * up
	 */

	private int pickMinHopNeigbour(List<Integer> neigbours, int destinationNode, String topologyType) {

		Map<Double, Integer> nodeDistance = new HashMap<Double, Integer>();
		List<Double> distanceList = new ArrayList<Double>();

		for (Integer nodeId : neigbours) {
			double distance = routingTableServiceIF.distance(nodeId, destinationNode, topologyType);
			nodeDistance.put(distance, nodeId);
			distanceList.add(distance);
		}
		double minDistance = Collections.min(distanceList);
		int minHopNodeId = nodeDistance.get(minDistance);
		return minHopNodeId;
	}

	private NeigborPickEEDRTemp pickNodeWhichHasMaximumBatteryAndCQI(List<Integer> neigbours, int sourceNode,
			double freq, double initialNoiseFigure, double signalBW, double noiseFigure, double energyForTx,
			double powerGain, double CQINeigbor, String topologyType) {

		NeigborPickEEDRTemp neigborPickEEDRTemp = new NeigborPickEEDRTemp();
		int nodeIdWithMaxPower = 0;

		List<Double> cqiList = new LinkedList<Double>();

		Map<Double, Integer> hashMapPowerAndNodeId = new HashMap<Double, Integer>();

		// Collecting the batteryPower Information
		for (Integer neigbourNodeId : neigbours) {
			ParameterValue batteryPowerValue = parametersServiceIF.retriveParameter(ParametersTypeIF.ENERGY,
					neigbourNodeId);
			double batteryPower = batteryPowerValue.getEnergy();

			FormulaIF formulaIF = new FormulaImpl();

			double distance = routingTableServiceIF.distance(sourceNode, neigbourNodeId, topologyType);

			double pathLoss = formulaIF.computePathLoss(distance, freq);

			double sinr = formulaIF.computeSINR(initialNoiseFigure, signalBW, noiseFigure, energyForTx, pathLoss,
					powerGain);

			double CQI = formulaIF.computeCQI(sinr);

			double CQITemp = batteryPower + CQI;

			cqiList.add(CQITemp);
			hashMapPowerAndNodeId.put(CQITemp, neigbourNodeId);
		}

		// Getting the Node with maximum CQI

		double maxCQI = Collections.max(cqiList);

		CQINeigbor = maxCQI;

		nodeIdWithMaxPower = hashMapPowerAndNodeId.get(maxCQI);

		neigborPickEEDRTemp.setcQI(CQINeigbor);
		neigborPickEEDRTemp.setNodeId(nodeIdWithMaxPower);

		return neigborPickEEDRTemp;

	}

	private boolean validateRange(OptimizedCriteria findRoute) {
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

	/*
	 * public double eneryConsumedFormulaForWSN(double totaldistance, double
	 * noOfHops, double energyForTx, double energyForAmp, double
	 * auttunationFactor)
	 */

	private void updateNodesBattery(int curNode, int nextNode, String topologyType, double energyForTx,
			double energyForAmp, double attFactor) {

		FormulaIF formula = new FormulaImpl();
		ParameterValue parameterV = parametersServiceIF.retriveParameter(ParametersTypeIF.ENERGY, curNode);
		double currentPower = parameterV.getEnergy();
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
		parametersServiceIF.deleteSpecficParameter(ParametersTypeIF.ENERGY, tableFromWhichToGet);

		TopologyInfoValue topologyInfoValue = new TopologyInfoValue();
		NodeParameters nodeParameters = new NodeParameters();
		nodeParameters.setEnergy(energyConsumed);
		topologyInfoValue.setNodeParameters(nodeParameters);
		parametersServiceIF.insertSingleParameter(ParametersTypeIF.ENERGY, tableFromWhichToGet, topologyInfoValue);
	}

}
