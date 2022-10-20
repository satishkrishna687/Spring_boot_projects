package com.dropsapppro.model;

public class KeyDistributionInputModel {

	private String userId;

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

	public String getUniqueInformation() {
		return uniqueInformation;
	}

	public void setUniqueInformation(String uniqueInformation) {
		this.uniqueInformation = uniqueInformation;
	}


	private String informationType;
	
	private String uniqueInformation;
	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	
	private String text;

}
