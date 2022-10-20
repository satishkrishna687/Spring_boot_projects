package com.model;

public class ComparisonModelObj extends BytesInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public double getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(double timeTaken) {
		this.timeTaken = timeTaken;
	}

	public Long getMemoryConsumed() {
		return memoryConsumed;
	}

	public void setMemoryConsumed(Long memoryConsumed) {
		this.memoryConsumed = memoryConsumed;
	}

	private double timeTaken;
	
	private Long memoryConsumed;

}
