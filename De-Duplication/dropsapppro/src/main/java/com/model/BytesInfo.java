package com.model;

import java.io.Serializable;

public class BytesInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double encryptionBytes;

	public double getEncryptionBytes() {
		return encryptionBytes;
	}

	public void setEncryptionBytes(double encryptionBytes) {
		this.encryptionBytes = encryptionBytes;
	}

}
