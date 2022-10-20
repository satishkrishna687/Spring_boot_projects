package com.dropsapppro.model;

import java.io.Serializable;

public class ChangePasswordModel extends ForgotPasswordModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String oldPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}

	private String newPassword;

	private String confirmNewPassword;

}
