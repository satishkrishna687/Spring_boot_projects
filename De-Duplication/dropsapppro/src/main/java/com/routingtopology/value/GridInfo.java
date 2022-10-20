package com.routingtopology.value;

/**
 * 
 * keeps a look up of N*N grid
 * 
 * 
 */
public class GridInfo {

	private int noOfXpos;

	private int noOfYpos;

	/**
	 * @param noOfXpos
	 */
	public void setNoOfXpos(int noOfXpos) {
		this.noOfXpos = noOfXpos;
	}

	/**
	 * @return no of x positions
	 */
	public int getNoOfXpos() {
		return noOfXpos;
	}

	/**
	 * @param noOfYpos
	 */
	public void setNoOfYpos(int noOfYpos) {
		this.noOfYpos = noOfYpos;
	}

	/**
	 * @return number of y positions
	 */
	public int getNoOfYpos() {
		return noOfYpos;
	}
	

}
