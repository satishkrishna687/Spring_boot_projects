package com.routingtopology.value;

/**
 * 
 *
 */
public class SecondClusterHeadInfo {

	private String errCode;
	
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

	private int nodeId;
	
	/**
	 * @param nodeId
	 */
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	/**
	 * @return Node Id of the Node
	 */
	public int getNodeId() {
		return nodeId;
	}
	
	
	private String errMsg;
	
	/**
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	/**
	 * @return Error Message while finding second cluster head
	 */
	public String getErrMsg() {
		return errMsg;
	}

	


}
