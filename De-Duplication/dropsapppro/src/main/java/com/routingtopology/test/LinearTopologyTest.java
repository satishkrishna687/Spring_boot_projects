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


public class LinearTopologyTest {


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

		NodeModel topologyModel = new NodeModel();
		topologyModel.setBuffer(500);
		topologyModel.setEnergy(100);
		topologyModel.setNetworkCost(10);
		topologyModel.setPower(1000);
		topologyModel.setNodeId(5);
		topologyModel.setxCordinate(560);
		topologyModel.setyCordinate(0);

		topologyInfoValueList.add(mapToTopologyValue(topologyModel));
		boolean test = topologyServiceIF
				.updateLinearTopology(topologyInfoValueList);

		System.out.println("Test" + test);

	}

	private static void deleteTopology(
			TopologyRoutingServiceIF topologyServiceIF) {

		boolean v = topologyServiceIF.deleteLinearTopology();
		System.out.println("Value" + v);
	}

	private static void showTopology(TopologyRoutingServiceIF topologyServiceIF) {

		List<TopologyInfoValue> topologyList = topologyServiceIF
				.retriveLinearTopologyForView();

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
		}

	}

	private static TopologyInfoValue mapToTopologyValue(NodeModel topologyModel) {

		TopologyInfoValue topologyCriteriaValue = new TopologyInfoValue();
		NodeParameters nodeParameters = new NodeParameters();
		nodeParameters.setBuffer(topologyModel.getBuffer());
		nodeParameters.setAvailableBatteryPower(topologyModel.getPower());
		nodeParameters.setNetworkCost(topologyModel.getNetworkCost());
		nodeParameters.setEnergy(topologyModel.getEnergy());
		topologyCriteriaValue.setNodeParameters(nodeParameters);
		NodeCordinateValue nodeCordinateValue = new NodeCordinateValue();
		nodeCordinateValue.setX_cor(topologyModel.getxCordinate());
		nodeCordinateValue.setY_cor(topologyModel.getyCordinate());
		topologyCriteriaValue.setNodeCoordiante(nodeCordinateValue);
		topologyCriteriaValue.setNodeId(topologyModel.getNodeId());
		return topologyCriteriaValue;
	}

	private static TopologyCriteriaValue mapToCriteriaValue(
			TopologyModel topologyModel) {

		TopologyCriteriaValue topologyCriteriaValue = new TopologyCriteriaValue();
		NodeParameters nodeParameters = new NodeParameters();
		nodeParameters.setBuffer(topologyModel.getBuffer());
		nodeParameters.setAvailableBatteryPower(topologyModel.getPower());
		nodeParameters.setNetworkCost(topologyModel.getNetworkCost());
		nodeParameters.setEnergy(topologyModel.getEnergy());
		topologyCriteriaValue.setNodeParameters(nodeParameters);
		topologyCriteriaValue.setMaxXCordinate(topologyModel.getMaxXArea());
		topologyCriteriaValue.setMinXCordinate(topologyModel.getMinXArea());
		topologyCriteriaValue.setMinYCordinate(topologyModel.getMinYArea());
		topologyCriteriaValue.setMaxYCordinate(topologyModel.getMaxYArea());
		topologyCriteriaValue.setNoOfNodes(topologyModel.getNoOfNodes());
		topologyCriteriaValue.setDistanceBetweenNodes(topologyModel
				.getDistanceBetweenNodes());
		return topologyCriteriaValue;
	}

	private static void createTopology(
			TopologyRoutingServiceIF topologyServiceIF) {

		TopologyModel topologyModel = new TopologyModel();
		topologyModel.setBuffer(1);
		topologyModel.setEnergy(5000);
		topologyModel.setNetworkCost(1);
		topologyModel.setPower(5000);
		topologyModel.setNoOfNodes(25);
		topologyModel.setMinXArea(1);
		topologyModel.setMaxXArea(100);
		topologyModel.setMinYArea(1);
		topologyModel.setMaxYArea(100);
		topologyModel.setDistanceBetweenNodes(10);

		boolean hel = topologyServiceIF
				.generateLinearTopologyAndStore(mapToCriteriaValue(topologyModel));

		System.out.println("Linear" + hel);

	}

}
