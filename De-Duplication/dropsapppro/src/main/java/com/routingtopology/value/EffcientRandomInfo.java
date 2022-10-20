package com.routingtopology.value;


public class EffcientRandomInfo {
	
	
	private RandomRouteInfo randomRouteInfo;

	private EffcientNodeRouteInfo effRouteInfo;
	
	/**
	 * @return true if everything is right
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status
	 *            false if some of the information is invalid
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return Error Message if any
	 */
	public String getErrMsg() {
		return errMsg;
	}

	/**
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	/**
	 * @return Exception Message if it has occured
	 */
	public String getExceptionMsg() {
		return exceptionMsg;
	}

	/**
	 * @param exceptionMsg
	 */
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	/**
	 * @return Exception Details if it has occured
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
	 * @param randomRouteInfo
	 */
	public void setRandomRouteInfo(RandomRouteInfo randomRouteInfo) {
		this.randomRouteInfo = randomRouteInfo;
	}

	/**
	 * @return RandomRouteInfo
	 */
	public RandomRouteInfo getRandomRouteInfo() {
		return randomRouteInfo;
	}


	
	

	/**
	 * @param effRouteInfo
	 */
	public void setEffRouteInfo(EffcientNodeRouteInfo effRouteInfo) {
		this.effRouteInfo = effRouteInfo;
	}

	/**
	 * @return EffcientNodeRouteInfo
	 */
	public EffcientNodeRouteInfo getEffRouteInfo() {
		return effRouteInfo;
	}





	private boolean status;

	private String errMsg;

	private String exceptionMsg;

	private String exceptionDetails;
	
	
	

}
