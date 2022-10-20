package com.routingtopology.value;

/**
 * 
 *
 */
public class RelayNodeInfo {

	private int relayNodeId;

	/**
	 * @return Relay Node
	 */
	public int getRelayNodeId() {
		return relayNodeId;
	}

	/**
	 * @param relayNodeId
	 */
	public void setRelayNodeId(int relayNodeId) {
		this.relayNodeId = relayNodeId;
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
