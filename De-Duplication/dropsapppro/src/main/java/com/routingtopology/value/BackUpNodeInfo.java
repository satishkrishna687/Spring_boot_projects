package com.routingtopology.value;

/**
 * This is the Class for the Back Up Node
 *
 */
public class BackUpNodeInfo {
	
	private int backUpNodeId;
	
	/**
	 * @param backUpNodeId
	 */
	public void setBackUpNodeId(int backUpNodeId) {
		this.backUpNodeId = backUpNodeId;
	}

	/**
	 * @return Back Up NodeId
	 */
	public int getBackUpNodeId() {
		return backUpNodeId;
	}


	

	/**
	 * @return Relay Function
	 */
	public double getRelayFunc() {
		return relayFunc;
	}

	/**
	 * @param relayFunc
	 */
	public void setRelayFunc(double relayFunc) {
		this.relayFunc = relayFunc;
	}

	/**
	 * @return Error Code
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * @param errCode
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	private double relayFunc;

	private String errCode;

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


}
