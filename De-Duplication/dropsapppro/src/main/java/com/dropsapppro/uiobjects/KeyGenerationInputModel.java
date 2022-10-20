package com.dropsapppro.uiobjects;

public class KeyGenerationInputModel {

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getInformationType() {
		return informationType;
	}

	public void setInformationType(String informationType) {
		this.informationType = informationType;
	}

	public String getUniqueInformationType() {
		return uniqueInformationType;
	}

	public void setUniqueInformationType(String uniqueInformationType) {
		this.uniqueInformationType = uniqueInformationType;
	}

	private String userId;
	
	private String informationType;
	
	private String uniqueInformationType;

}


