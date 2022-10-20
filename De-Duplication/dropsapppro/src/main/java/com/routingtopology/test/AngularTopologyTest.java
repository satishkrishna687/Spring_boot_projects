package com.routingtopology.test;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.routingtopology.service.inter.TopologyRoutingServiceIF;
import com.routingtopology.value.LeaderInfoValue;
import com.routingtopology.value.NodeParameters;
import com.routingtopology.value.TopologyCriteriaValue;
import com.routingtopology.value.TopologyInfoValue;


public class AngularTopologyTest {

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
		//deleteTopology(topologyServiceIF);
		updateTopology(topologyServiceIF);
	}

	private static void updateTopology(
			TopologyRoutingServiceIF topologyServiceIF) {
		List<TopologyInfoValue> topologyInfoValueList = new ArrayList<TopologyInfoValue>();
		AngularTopologyUpdate verticalModel = new AngularTopologyUpdate();
		verticalModel.setBuffer(1000);
		verticalModel.setEnergy(5000);
		verticalModel.setPowerAvailable(3000);
		verticalModel.setNetworkCost(50);
		verticalModel.setTrustLevel(5);
		verticalModel.setNodeId(5);
		verticalModel.setCloserToObs(2);
		verticalModel.setAngularRegion(1);
		verticalModel.setSignalStrength(1000.20);
		verticalModel.setAngularPosition(10);
		verticalModel.setZoneLeaderFlag(true);
		topologyInfoValueList
				.add(mapToTopologyValueUsingAngularUpdatelModel(verticalModel));
		boolean test = topologyServiceIF
				.updateAngularTopology(topologyInfoValueList);
		System.out.println("Test" + test);
	}

	private static TopologyInfoValue mapToTopologyValueUsingAngularUpdatelModel(
			AngularTopologyUpdate angularUpdateModel) {
		TopologyInfoValue topologyCriteriaValue = new TopologyInfoValue();
		NodeParameters nodeParameters = new NodeParameters();
		nodeParameters.setBuffer(angularUpdateModel.getBuffer());
		nodeParameters.setAvailableBatteryPower(angularUpdateModel
				.getPowerAvailable());
		nodeParameters.setTrustLevel(angularUpdateModel.getTrustLevel());
		nodeParameters.setNetworkCost(angularUpdateModel.getNetworkCost());
		nodeParameters.setEnergy(angularUpdateModel.getEnergy());
		nodeParameters.setAngularPos(angularUpdateModel.getAngularPosition());
		nodeParameters.setAngularRegion(angularUpdateModel.getAngularRegion());
		nodeParameters.setSignalStrengthOfNode(angularUpdateModel.getSignalStrength());
		nodeParameters.setCloseObstracle(angularUpdateModel.getCloserToObs());
		LeaderInfoValue leaderInfoValue = new LeaderInfoValue();
		leaderInfoValue.setLeader(angularUpdateModel.isZoneLeaderFlag());
		topologyCriteriaValue.setNodeParameters(nodeParameters);
		topologyCriteriaValue.setNodeId(angularUpdateModel.getNodeId());
		topologyCriteriaValue.setLeaderInfo(leaderInfoValue);
		return topologyCriteriaValue;
	}


	private static void deleteTopology(
			TopologyRoutingServiceIF topologyServiceIF) {

		boolean v = topologyServiceIF.deleteAngularTopology();
		System.out.println("Value" + v);
	}

	private static void showTopology(TopologyRoutingServiceIF topologyServiceIF) {
		List<TopologyInfoValue> topologyList = topologyServiceIF
				.retriveAngularTopologyForView();
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
			System.out.println("Angular Position"
					+ topologyVal.getNodeParameters().getAngularPos());
			System.out.println("Angular Region"
					+ topologyVal.getNodeParameters().getAngularRegion());
			System.out.println("Closer To Obstracle"
					+ topologyVal.getNodeParameters().getCloseObstracle());
		}
	}

	private static void createTopology(
		TopologyRoutingServiceIF topologyServiceIF) {
		AngularCriteriaModel angularCriteriaModel = new AngularCriteriaModel();
		angularCriteriaModel.setBuffer(1000);
		angularCriteriaModel.setEnergy(1000);
		angularCriteriaModel.setNetworkCost(10);
		angularCriteriaModel.setPower(1000);
		angularCriteriaModel.setNoOfNodes(50);
		angularCriteriaModel.setTrustLevel(5);
		angularCriteriaModel.setIntialSignalStrength(1000);
		List<Integer> listEP = new ArrayList<Integer>();
		listEP.add(1);
		listEP.add(10);
		listEP.add(20);
		listEP.add(30);
		listEP.add(40);
		listEP.add(50);
		angularCriteriaModel.setAngularEndPoints(listEP);
		List<Integer> listNON = new ArrayList<Integer>();
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		angularCriteriaModel.setNoOfNodesInEachAngularRegion(listNON);
		boolean hel = topologyServiceIF
				.generateAngularTopologyAndStore(mapToCriteriaAngularModelValue(angularCriteriaModel));
		System.out.println("hell" + hel);
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
