package com.routingtopology.value;

/**
 * nawaza This class is used to add information about the Grade
 * Diffusion Algorithm as well as Faault Node Recovery Algorithm
 */
public class GradeFaultInfo {

	private FaultNodeRouteInfo faultNodeRouteInfo;

	/**
	 * @param faultNodeRouteInfo
	 */
	public void setFaultNodeRouteInfo(FaultNodeRouteInfo faultNodeRouteInfo) {
		this.faultNodeRouteInfo = faultNodeRouteInfo;
	}

	/**
	 * @return Fault Node Route Information
	 */
	public FaultNodeRouteInfo getFaultNodeRouteInfo() {
		return faultNodeRouteInfo;
	}

	private GradeRouteInfo gradeRouteInfo;

	/**
	 * @return true if everything is right
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status
	 *               false if some of the information is invalid
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
	 * @param gradeRouteInfo
	 */
	public void setGradeRouteInfo(GradeRouteInfo gradeRouteInfo) {
		this.gradeRouteInfo = gradeRouteInfo;
	}

	/**
	 * @return GradeRouteInfo Object
	 */
	public GradeRouteInfo getGradeRouteInfo() {
		return gradeRouteInfo;
	}

	private boolean status;

	private String errMsg;

	private String exceptionMsg;

	private String exceptionDetails;

}
