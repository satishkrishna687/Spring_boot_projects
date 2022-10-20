package com.dropsapppro.uiobjects;

import java.io.Serializable;

public class RequestInfoVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getReqdetails() {
		return reqdetails;
	}

	public void setReqdetails(String reqdetails) {
		this.reqdetails = reqdetails;
	}

	public String getUsernameFromSession() {
		return usernameFromSession;
	}

	public void setUsernameFromSession(String usernameFromSession) {
		this.usernameFromSession = usernameFromSession;
	}

	public String getInformationType() {
		return informationType;
	}

	public void setInformationType(String informationType) {
		this.informationType = informationType;
	}

	private String username;
	
	private String reqdetails;
	
	private String usernameFromSession;
	
	private String informationType;

}
