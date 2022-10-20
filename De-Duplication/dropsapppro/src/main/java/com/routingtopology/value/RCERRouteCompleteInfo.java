package com.routingtopology.value;

public class RCERRouteCompleteInfo {

	private RCERFirstRRouteWithErrInfo rCERFirstRRouteWithErrInfo;

	/**
	 * @param rCERFirstRRouteWithErrInfo
	 */
	public void setrCERFirstRRouteWithErrInfo(RCERFirstRRouteWithErrInfo rCERFirstRRouteWithErrInfo) {
		this.rCERFirstRRouteWithErrInfo = rCERFirstRRouteWithErrInfo;
	}

	/**
	 * @return rCERFirstRRouteWithErrInfo
	 */
	public RCERFirstRRouteWithErrInfo getrCERFirstRRouteWithErrInfo() {
		return rCERFirstRRouteWithErrInfo;
	};

	private RCERSecondRouteWithErrInfo rCERSecondRouteWithErrInfo;

	/**
	 * @param rCERSecondRouteWithErrInfo
	 */
	public void setrCERSecondRouteWithErrInfo(RCERSecondRouteWithErrInfo rCERSecondRouteWithErrInfo) {
		this.rCERSecondRouteWithErrInfo = rCERSecondRouteWithErrInfo;
	}

	/**
	 * @return RCERSecondRouteWithErrInfo Object
	 */
	public RCERSecondRouteWithErrInfo getrCERSecondRouteWithErrInfo() {
		return rCERSecondRouteWithErrInfo;
	}

	private String errCode;

	/**
	 * @param errCode
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	/**
	 * @return Error Code
	 */
	public String getErrCode() {
		return errCode;
	}

	private String errMsg;

	/**
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	/**
	 * @return Error Message
	 */
	public String getErrMsg() {
		return errMsg;
	}

	private double timeTaken1;

	/**
	 * @param timeTaken1
	 */
	public void setTimeTaken1(double timeTaken1) {
		this.timeTaken1 = timeTaken1;
	}

	/**
	 * @return Time Taken1
	 */
	public double getTimeTaken1() {
		return timeTaken1;
	}

	private double timeTaken2;

	/**
	 * @param timeTaken2
	 */
	public void setTimeTaken2(double timeTaken2) {
		this.timeTaken2 = timeTaken2;
	}

	/**
	 * @return timeTaken2
	 */
	public double getTimeTaken2() {
		return timeTaken2;
	}

	private double powerConsumedOnRoute1;

	/**
	 * @param powerConsumedOnRoute1
	 */
	public void setPowerConsumedOnRoute1(double powerConsumedOnRoute1) {
		this.powerConsumedOnRoute1 = powerConsumedOnRoute1;
	}

	/**
	 * @return power consumed on route1
	 */
	public double getPowerConsumedOnRoute1() {
		return powerConsumedOnRoute1;
	}

	private double powerConsumedOnRoute2;

	/**
	 * @param powerConsumedOnRoute2
	 */
	public void setPowerConsumedOnRoute2(double powerConsumedOnRoute2) {
		this.powerConsumedOnRoute2 = powerConsumedOnRoute2;
	}

	/**
	 * @return powerConsumedOnRoute2
	 */
	public double getPowerConsumedOnRoute2() {
		return powerConsumedOnRoute2;
	}

}
