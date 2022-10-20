package com.routingtopology.test;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.routingtopology.service.inter.TopologyRoutingServiceIF;
import com.routingtopology.value.CentreCordinate;
import com.routingtopology.value.LeaderInfoValue;
import com.routingtopology.value.NodeCordinateValue;
import com.routingtopology.value.NodeParameters;
import com.routingtopology.value.TopologyCriteriaValue;
import com.routingtopology.value.TopologyInfoValue;


public class SquareTopologyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/topology-routing.xml");
		TopologyRoutingServiceIF topologyServiceIF = (TopologyRoutingServiceIF) context
				.getBean("topologyService");
		//createTopology(topologyServiceIF);
		 //showTopology(topologyServiceIF);
		 deleteTopology(topologyServiceIF);
		//updateTopology(topologyServiceIF);
	}

	private static void updateTopology(
			TopologyRoutingServiceIF topologyServiceIF) {
		List<TopologyInfoValue> topologyInfoValueList = new ArrayList<TopologyInfoValue>();
		SquareTopologyUpdate squareModel = new SquareTopologyUpdate();
		squareModel.setBuffer(1000);
		squareModel.setEnergy(5000);
		squareModel.setPowerAvailable(3000);
		squareModel.setNetworkCost(50);
		squareModel.setTrustLevel(15);
		squareModel.setNodeId(5);
		squareModel.setZoneLeaderFlag(true);
		squareModel.setxCenter(10.5);
		squareModel.setyCenter(20.5);
		squareModel.setXCordinate(1);
		squareModel.setYCordinate(10);
		topologyInfoValueList
				.add(mapToTopologyValueUsingSquareUpdateModel(squareModel));
		boolean test = topologyServiceIF
				.updateSquareTopology(topologyInfoValueList);
		System.out.println("Test" + test);
	}

	private static TopologyInfoValue mapToTopologyValueUsingSquareUpdateModel(
			SquareTopologyUpdate squareUpdateModel) {
		TopologyInfoValue topologyCriteriaValue = new TopologyInfoValue();
		NodeParameters nodeParameters = new NodeParameters();
		nodeParameters.setBuffer(squareUpdateModel.getBuffer());
		nodeParameters.setAvailableBatteryPower(squareUpdateModel
				.getPowerAvailable());
		nodeParameters.setTrustLevel(squareUpdateModel.getTrustLevel());
		nodeParameters.setNetworkCost(squareUpdateModel.getNetworkCost());
		nodeParameters.setEnergy(squareUpdateModel.getEnergy());
		topologyCriteriaValue.setNodeParameters(nodeParameters);
		topologyCriteriaValue.setNodeId(squareUpdateModel.getNodeId());
		
		LeaderInfoValue leaderInfoValue = new LeaderInfoValue();
		leaderInfoValue.setLeader(squareUpdateModel.isZoneLeaderFlag());
		topologyCriteriaValue.setLeaderInfo(leaderInfoValue);
		
		NodeCordinateValue nodeCordinateValue=new NodeCordinateValue();
		nodeCordinateValue.setX_cor(squareUpdateModel.getXCordinate());
		nodeCordinateValue.setY_cor(squareUpdateModel.getYCordinate());
		topologyCriteriaValue.setNodeCoordiante(nodeCordinateValue);
		
		CentreCordinate centreCordinate=new CentreCordinate();
		centreCordinate.setxCorCentre(squareUpdateModel.getxCenter());
		centreCordinate.setyCorCentre(squareUpdateModel.getyCenter());
		topologyCriteriaValue.setCentreCordinates(centreCordinate);
		
		return topologyCriteriaValue;
	}

	private static void deleteTopology(
			TopologyRoutingServiceIF topologyServiceIF) {

		boolean v = topologyServiceIF.deleteSquareTopology();
		System.out.println("Value" + v);
	}

	private static void showTopology(TopologyRoutingServiceIF topologyServiceIF) {
		List<TopologyInfoValue> topologyList = topologyServiceIF
				.retriveSquareTopologyForView();
		for (TopologyInfoValue topologyVal : topologyList) {
			System.out.println("NodeId" + topologyVal.getNodeId());
			System.out.println("Enery"
					+ topologyVal.getNodeParameters().getEnergy());
			System.out.println("Power"
					+ topologyVal.getNodeParameters()
							.getAvailableBatteryPower());
			System.out.println("Network Cost"
					+ topologyVal.getNodeParameters().getNetworkCost());
			System.out.println("Buffer"
					+ topologyVal.getNodeParameters().getBuffer());
			System.out.println("Trust Level"
					+ topologyVal.getNodeParameters().getTrustLevel());
			System.out.println("Zone Leader"
					+ topologyVal.getLeaderInfo().isLeader());
			System.out.println("XCordinate"
					+ topologyVal.getNodeCoordiante().getX_cor());
			System.out.println("YCordinate"
					+ topologyVal.getNodeCoordiante().getY_cor());
			System.out.println("X Center"
					+ topologyVal.getCentreCordinates().getxCorCentre());
			System.out.println("Y Center"
					+ topologyVal.getCentreCordinates().getyCorCentre());
		}
	}

	private static void createTopology(
			TopologyRoutingServiceIF topologyServiceIF) {
		SquareCriteriaModel angularCriteriaModel = new SquareCriteriaModel();
		angularCriteriaModel.setBuffer(1000);
		angularCriteriaModel.setEnergy(1000);
		angularCriteriaModel.setNetworkCost(10);
		angularCriteriaModel.setPower(1000);
		angularCriteriaModel.setNoOfNodes(250);
		angularCriteriaModel.setTrustLevel(5);
		
		angularCriteriaModel.setNoOfZones(25);

		List<Integer> listEP = new ArrayList<Integer>();
		listEP.add(1);
		listEP.add(10);
		listEP.add(20);
		listEP.add(30);
		listEP.add(40);
		listEP.add(50);
		angularCriteriaModel.setHorizontalEndPoints(listEP);

		listEP = new ArrayList<Integer>();
		listEP.add(1);
		listEP.add(10);
		listEP.add(20);
		listEP.add(30);
		listEP.add(40);
		listEP.add(50);
		angularCriteriaModel.setVerticalEndPoints(listEP);

		List<Integer> listNON = new ArrayList<Integer>();
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		
		angularCriteriaModel.setNoOfNodesInEachZone(listNON);
		boolean hel = topologyServiceIF
				.generateSquareTopologyAndStore(mapToCriteriaSquareModelValue(angularCriteriaModel));
		System.out.println("hell" + hel);
	}

	private static TopologyCriteriaValue mapToCriteriaSquareModelValue(
			SquareCriteriaModel squareCriteriaModel) {
		TopologyCriteriaValue topologyCriteriaValue = new TopologyCriteriaValue();
		NodeParameters nodeParameters = new NodeParameters();
		nodeParameters.setBuffer(squareCriteriaModel.getBuffer());
		nodeParameters.setAvailableBatteryPower(squareCriteriaModel.getPower());
		nodeParameters.setNetworkCost(squareCriteriaModel.getNetworkCost());
		nodeParameters.setEnergy(squareCriteriaModel.getEnergy());
		nodeParameters.setTrustLevel(squareCriteriaModel.getTrustLevel());
		topologyCriteriaValue.setNoOfZones(squareCriteriaModel.getNoOfZones());
		topologyCriteriaValue.setNodeParameters(nodeParameters);
		topologyCriteriaValue.setHorizontalEndPoints(squareCriteriaModel
				.getHorizontalEndPoints());
		topologyCriteriaValue.setVerticalEndPoints(squareCriteriaModel
				.getVerticalEndPoints());
		topologyCriteriaValue.setNoOfNodesPerZone(squareCriteriaModel
				.getNoOfNodesInEachZone());
		topologyCriteriaValue.setNoOfNodes(squareCriteriaModel.getNoOfNodes());
		return topologyCriteriaValue;
	}

	private static TopologyCriteriaValue mapToCriteriaAngularModelValue(
			AngularCriteriaModel angularCriteriaModel) {
		TopologyCriteriaValue topologyCriteriaValue = new TopologyCriteriaValue();
		NodeParameters nodeParameters = new NodeParameters();
		nodeParameters.setBuffer(angularCriteriaModel.getBuffer());
		nodeParameters
				.setAvailableBatteryPower(angularCriteriaModel.getPower());
		nodeParameters.setNetworkCost(angularCriteriaModel.getNetworkCost());
		nodeParameters.setEnergy(angularCriteriaModel.getEnergy());
		nodeParameters.setTrustLevel(angularCriteriaModel.getTrustLevel());
		topologyCriteriaValue.setIntialSignalStrength(angularCriteriaModel
				.getIntialSignalStrength());
		topologyCriteriaValue.setNodeParameters(nodeParameters);
		topologyCriteriaValue
				.setNoOfNodesInEachAngularRegion(angularCriteriaModel
						.getNoOfNodesInEachAngularRegion());
		topologyCriteriaValue.setAngularEndPoints(angularCriteriaModel
				.getAngularEndPoints());
		topologyCriteriaValue.setNoOfNodes(angularCriteriaModel.getNoOfNodes());
		return topologyCriteriaValue;
	}

}
