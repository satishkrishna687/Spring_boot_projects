package com.routingtopology.value;

/**
 * This class represents Vertical Routing Table
 *
 */
public class VerticalRoutingTable extends NormalRoutingTable {
	
	private int verticalBelong;

	/**
	 * @param verticalBelong
	 */
	public void setVerticalBelong(int verticalBelong) {
		this.verticalBelong = verticalBelong;
	}

	/**
	 * @return Vertical Belong of the node
	 */
	public int getVerticalBelong() {
		return verticalBelong;
	}

}
