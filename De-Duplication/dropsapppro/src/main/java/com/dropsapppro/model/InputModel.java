package com.dropsapppro.model;

import java.io.Serializable;

public class InputModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String secret;
	
	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}



	private String data;

}
