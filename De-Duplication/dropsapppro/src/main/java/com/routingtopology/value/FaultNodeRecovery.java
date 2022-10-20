package com.routingtopology.value;




public class FaultNodeRecovery {
	
	/**
	 * 
	 */
	public DeadNodesInformation deadNodesInfo;
	
	/**
	 * @return Information About the Dead Nodes in the Network
	 */
	public DeadNodesInformation getDeadNodesInfo() {
		return deadNodesInfo;
	}

	/**
	 * @param deadNodesInfo
	 */
	public void setDeadNodesInfo(DeadNodesInformation deadNodesInfo) {
		this.deadNodesInfo = deadNodesInfo;
	}

	/**
	 * @param batteryPower
	 */
	public void setBatteryPower(double batteryPower) {
		this.batteryPower = batteryPower;
	}

	/**
	 * @return Battery Power of the Nodes
	 */
	public double getBatteryPower() {
		return batteryPower;
	}

	private double batteryPower;
	
	private boolean status;
	
	/**
	 * @return True if all functions have passed without exception
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return Validation Error Message 
	 */
	public String getValidationErr() {
		return validationErr;
	}

	/**
	 * @param validationErr
	 */
	public void setValidationErr(String validationErr) {
		this.validationErr = validationErr;
	}

	/**
	 * @return Exception Information if any
	 */
	public String getExceptionInfo() {
		return exceptionInfo;
	}

	/**
	 * @param exceptionInfo
	 */
	public void setExceptionInfo(String exceptionInfo) {
		this.exceptionInfo = exceptionInfo;
	}

	/**
	 * @return Full Stack Trace of the Exception
	 */
	public String getExceptionDetails() {
		return exceptionDetails;
	}

	/**
	 * @param exceptionDetails
	 */
	public void setExceptionDetails(String exceptionDetails) {
		this.exceptionDetails = exceptionDetails;
	}

	/**
	 * @param messageIfAny
	 */
	public void setMessageIfAny(String messageIfAny) {
		this.messageIfAny = messageIfAny;
	}

	/**
	 * @return This is the message populated if everything is sucessful but yet We Cant recovcer Ndoes
	 */
	public String getMessageIfAny() {
		return messageIfAny;
	}

	private String validationErr;
	
	private String exceptionInfo;
	
	private String exceptionDetails;
	
	private String messageIfAny;
	
	
	

}
