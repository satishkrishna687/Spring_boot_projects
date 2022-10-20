package com.routingtopology.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sun.font.CreatedFontTracker;

import com.routingtopology.service.inter.TopologyRoutingServiceIF;
import com.routingtopology.value.NodeCordinateValue;
import com.routingtopology.value.NodeParameters;
import com.routingtopology.value.TopologyCriteriaValue;
import com.routingtopology.value.TopologyInfoValue;

public class VerticalTopologyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/topology-routing.xml");
		TopologyRoutingServiceIF topologyServiceIF = (TopologyRoutingServiceIF) context
				.getBean("topologyService");
		// createTopology(topologyServiceIF);
		// showTopology(topologyServiceIF);
		// deleteTopology(topologyServiceIF);
		updateTopology(topologyServiceIF);
	}

	private static void updateTopology(
			TopologyRoutingServiceIF topologyServiceIF) {

		List<TopologyInfoValue> topologyInfoValueList = new ArrayList<TopologyInfoValue>();

		VerticalModelUpdate verticalModel = new VerticalModelUpdate();

		verticalModel.setBuffer(1000);
		verticalModel.setEnergy(5000);
		verticalModel.setPower(3000);
		verticalModel.setNetworkCost(50);
		verticalModel.setTrustLevel(5);
		verticalModel.setNodeId(5);
		verticalModel.setX_cor(10);
		verticalModel.setY_cor(20);
		verticalModel.setVerticalBelong(1);

		topologyInfoValueList.add(mapToTopologyValueUsingVerticalModel(verticalModel));
		boolean test = topologyServiceIF
				.updateVerticalTopology(topologyInfoValueList);

		System.out.println("Test" + test);

	}

	private static TopologyInfoValue mapToTopologyValueUsingVerticalModel(
			VerticalModelUpdate verticalModel) {
		TopologyInfoValue topologyCriteriaValue = new TopologyInfoValue();
		NodeParameters nodeParameters = new NodeParameters();
		nodeParameters.setBuffer(verticalModel.getBuffer());
		nodeParameters.setAvailableBatteryPower(verticalModel.getPower());
		nodeParameters.setTrustLevel(verticalModel.getTrustLevel());
		nodeParameters.setNetworkCost(verticalModel.getNetworkCost());
		nodeParameters.setEnergy(verticalModel.getEnergy());
		nodeParameters.setVerticalBelong(verticalModel.getVerticalBelong());
		topologyCriteriaValue.setNodeParameters(nodeParameters);
		NodeCordinateValue nodeCordinateValue = new NodeCordinateValue();
		nodeCordinateValue.setX_cor(verticalModel.getX_cor());
		nodeCordinateValue.setY_cor(verticalModel.getY_cor());
		topologyCriteriaValue.setNodeCoordiante(nodeCordinateValue);
		topologyCriteriaValue.setNodeId(verticalModel.getNodeId());

		return topologyCriteriaValue;
	}

	private static void deleteTopology(
			TopologyRoutingServiceIF topologyServiceIF) {

		boolean v = topologyServiceIF.deleteVerticalTopology();
		System.out.println("Value" + v);
	}

	private static void showTopology(TopologyRoutingServiceIF topologyServiceIF) {

		List<TopologyInfoValue> topologyList = topologyServiceIF
				.retriveVerticalTopologyForView();

		for (TopologyInfoValue topologyVal : topologyList) {
			System.out.println("NodeId" + topologyVal.getNodeId());
			System.out.println("XCordinate"
					+ topologyVal.getNodeCoordiante().getX_cor());
			System.out.println("YCordinate"
					+ topologyVal.getNodeCoordiante().getY_cor());
			System.out.println("Enery"
					+ topologyVal.getNodeParameters().getEnergy());
			System.out.println("Power"
					+ topologyVal.getNodeParameters()
							.getAvailableBatteryPower());
			System.out.println("Network Cost"
					+ topologyVal.getNodeParameters().getNetworkCost());
			System.out.println("Buffer"
					+ topologyVal.getNodeParameters().getBuffer());
			System.out.println("Vertical Section"
					+ topologyVal.getNodeParameters().getVerticalBelong());
			System.out.println("Trust Level"
					+ topologyVal.getNodeParameters().getTrustLevel());
		}

	}

	private static void createTopology(
			TopologyRoutingServiceIF topologyServiceIF) {

		VerticalModel verticalModel = new VerticalModel();
		verticalModel.setBuffer(1000);
		verticalModel.setEnergy(1000);
		verticalModel.setNetworkCost(10);
		verticalModel.setPower(1000);
		verticalModel.setNoOfNodes(50);
		verticalModel.setMinXArea(1);
		verticalModel.setMaxXArea(100);
		verticalModel.setMinYArea(1);
		verticalModel.setMaxYArea(100);
		verticalModel.setTrustLevel(5);

		List<Integer> listEP = new ArrayList<Integer>();
		listEP.add(1);
		listEP.add(10);
		listEP.add(20);
		listEP.add(30);
		listEP.add(40);
		listEP.add(50);

		verticalModel.setVerticalEndPointsList(listEP);
		List<Integer> listNON = new ArrayList<Integer>();
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		listNON.add(10);
		verticalModel.setVerticalNoOfNodes(listNON);
		boolean hel = topologyServiceIF
				.generateVerticalTopologyAndStore(mapToCriteriaVerticalModelValue(verticalModel));

		System.out.println("hell" + hel);

	}

	private static TopologyCriteriaValue mapToCriteriaVerticalModelValue(
			VerticalModel verticalModel) {
		TopologyCriteriaValue topologyCriteriaValue = new TopologyCriteriaValue();
		NodeParameters nodeParameters = new NodeParameters();
		nodeParameters.setBuffer(verticalModel.getBuffer());
		nodeParameters.setAvailableBatteryPower(verticalModel.getPower());
		nodeParameters.setNetworkCost(verticalModel.getNetworkCost());
		nodeParameters.setEnergy(verticalModel.getEnergy());
		nodeParameters.setTrustLevel(verticalModel.getTrustLevel());
		topologyCriteriaValue.setNodeParameters(nodeParameters);
		topologyCriteriaValue.setMaxXCordinate(verticalModel.getMaxXArea());
		topologyCriteriaValue.setMinXCordinate(verticalModel.getMinXArea());
		topologyCriteriaValue.setMinYCordinate(verticalModel.getMinYArea());
		topologyCriteriaValue.setMaxYCordinate(verticalModel.getMaxYArea());
		topologyCriteriaValue.setNoOfNodes(verticalModel.getNoOfNodes());
		topologyCriteriaValue.setNoOfNodesInEachVertical(verticalModel.getVerticalNoOfNodes());
		topologyCriteriaValue.setVerticalLinesPoints(verticalModel.getVerticalEndPointsList());
		return topologyCriteriaValue;
	}

}
