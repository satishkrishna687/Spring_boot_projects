package com.routingtopology.value;

import java.util.List;


public class DeadNodesInformation {
	
	
	private String validationError;
	
	private boolean status;
	
	private String exceptionInfo;
	
	private String exceptionMsg;
	
	private List<DeadNodesInfo> deadNodesList;

	/**
	 * @param deadNodesList
	 */
	public void setDeadNodesList(List<DeadNodesInfo> deadNodesList) {
		this.deadNodesList = deadNodesList;
	}

	/**
	 * @return List of Dead Nodes in the Network
	 */
	public List<DeadNodesInfo> getDeadNodesList() {
		return deadNodesList;
	}

	/**
	 * @param exceptionInfo
	 */
	public void setExceptionInfo(String exceptionInfo) {
		this.exceptionInfo = exceptionInfo;
	}

	/**
	 * @return Complete Stack trace of the Exception
	 */
	public String getExceptionInfo() {
		return exceptionInfo;
	}

	/**
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return true if computation is done without any errors otherwise return false
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param exceptionMsg
	 */
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	/**
	 * @return Exception that has occured in the Network
	 */
	public String getExceptionMsg() {
		return exceptionMsg;
	}

	/**
	 * @param validationError
	 */
	public void setValidationError(String validationError) {
		this.validationError = validationError;
	}

	/**
	 * @return Non Critical Validation Error If Any
	 */
	public String getValidationError() {
		return validationError;
	}

}
