package com.routingtopology.value;

/**
 * This is the Node Information 
 *
 */
public class NodeInfoForSquare {
	
	
	/**
	 * @return node id
	 */
	public int getNodeId() {
		return nodeId;
	}

	/**
	 * @param nodeId
	 */
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	/**
	 * @return xcordinate
	 */
	public int getxCordinate() {
		return xCordinate;
	}

	/**
	 * @param xCordinate
	 */
	public void setxCordinate(int xCordinate) {
		this.xCordinate = xCordinate;
	}

	/**
	 * @return ycordinate
	 */
	public int getyCordinate() {
		return yCordinate;
	}

	/**
	 * @param yCordinate
	 */
	public void setyCordinate(int yCordinate) {
		this.yCordinate = yCordinate;
	}

	/**
	 * @return center of zone
	 */
	public double getxCenter() {
		return xCenter;
	}

	/**
	 * @param xCenter
	 */
	public void setxCenter(double xCenter) {
		this.xCenter = xCenter;
	}

	/**
	 * @return centre of y
	 */
	public double getyCentre() {
		return yCentre;
	}

	/**
	 * @param yCentre
	 */
	public void setyCentre(double yCentre) {
		this.yCentre = yCentre;
	}

	private int nodeId;
	
	private int xCordinate;
	
	private int yCordinate;
	
	private double xCenter;
	
	private double yCentre;

}
