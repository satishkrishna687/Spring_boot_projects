package com.loginmaintain.model;

import java.io.Serializable;

public class EncryptDecryptData implements Serializable{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	private boolean status;
	
	
	private String errMessage;
	
	private String data;
	
}
