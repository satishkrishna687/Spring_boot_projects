package com.model;

import java.io.Serializable;

public class IPAdressVOFrontEnd extends NodeIdObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ipAddress;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}
