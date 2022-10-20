package com.model;

import java.util.List;

public class VerticalModel extends TopologyModel {

	private List<Integer> verticalEndPointsList;

	/**
	 * @param verticalEndPointsList
	 */
	public void setVerticalEndPointsList(List<Integer> verticalEndPointsList) {
		this.verticalEndPointsList = verticalEndPointsList;
	}

	/**
	 * @return List of Vertical end points
	 */
	public List<Integer> getVerticalEndPointsList() {
		return verticalEndPointsList;
	}

	/**
	 * @param verticalNoOfNodes
	 */
	public void setVerticalNoOfNodes(List<Integer> verticalNoOfNodes) {
		this.verticalNoOfNodes = verticalNoOfNodes;
	}

	/**
	 * @return List of vertical sector nodes
	 */
	public List<Integer> getVerticalNoOfNodes() {
		return verticalNoOfNodes;
	}

	private List<Integer> verticalNoOfNodes;

}
