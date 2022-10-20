package com.routingtopology.value;


public class ErrorMsgObj {
	
	private int errorId;
	
	/**
	 * @return error id
	 */
	public int getErrorId() {
		return errorId;
	}

	/**
	 * @param errorId
	 */
	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}

	/**
	 * @return error message of te user
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

	private String errMsg;

}
