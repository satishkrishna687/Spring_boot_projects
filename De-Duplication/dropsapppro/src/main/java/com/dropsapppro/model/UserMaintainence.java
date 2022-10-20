package com.dropsapppro.model;

import java.util.ArrayList;

import javax.persistence.Column;

import com.dropsapppro.storageobjects.AuditModel;
import com.dropsapppro.storageobjects.AuditModelTemp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class UserMaintainence extends AuditModelTemp{

	public UserMaintainence() {

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int loginType;

	private String password;

	public int getLoginType() {
		return loginType;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String phoneNo;

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	private UserMaintainId userMaintainId;

	public UserMaintainId getUserMaintainId() {
		return userMaintainId;
	}

	public void setUserMaintainId(UserMaintainId userMaintainId) {
		this.userMaintainId = userMaintainId;
	}

	private String dob;

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	private String country;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	private String streetAddressLine1;

	public String getStreetAddressLine1() {
		return streetAddressLine1;
	}

	public void setStreetAddressLine1(String streetAddressLine1) {
		this.streetAddressLine1 = streetAddressLine1;
	}

	private String streetAddressLine2;

	public String getStreetAddressLine2() {
		return streetAddressLine2;
	}

	public void setStreetAddressLine2(String streetAddressLine2) {
		this.streetAddressLine2 = streetAddressLine2;
	}


	private String pinCode;

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	private String usnNumber;

	public String getUsnNumber() {
		return usnNumber;
	}

	public void setUsnNumber(String usnNumber) {
		this.usnNumber = usnNumber;
	}

	private String collegeName;

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getSecretQuestion1() {
		return secretQuestion1;
	}

	public void setSecretQuestion1(String secretQuestion1) {
		this.secretQuestion1 = secretQuestion1;
	}

	public String getSecretQuestion2() {
		return secretQuestion2;
	}

	public void setSecretQuestion2(String secretQuestion2) {
		this.secretQuestion2 = secretQuestion2;
	}

	public String getSecretAnswer1() {
		return secretAnswer1;
	}

	public void setSecretAnswer1(String secretAnswer1) {
		this.secretAnswer1 = secretAnswer1;
	}

	public String getSecretAnswer2() {
		return secretAnswer2;
	}

	public void setSecretAnswer2(String secretAnswer2) {
		this.secretAnswer2 = secretAnswer2;
	}

	public String getIsAccountLocked() {
		return isAccountLocked;
	}

	public void setIsAccountLocked(String isAccountLocked) {
		this.isAccountLocked = isAccountLocked;
	}

	public int getNoOfWrongPasswords() {
		return noOfWrongPasswords;
	}

	public void setNoOfWrongPasswords(int noOfWrongPasswords) {
		this.noOfWrongPasswords = noOfWrongPasswords;
	}

	private String university;

	private String secretQuestion1;

	private String secretQuestion2;

	private String secretAnswer1;

	private String secretAnswer2;

	private String isAccountLocked;

	private int noOfWrongPasswords;

	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	private int age;

	private transient AdditionalConfig additionalConfig;

	public AdditionalConfig getAdditionalConfig() {
		return additionalConfig;
	}

	public void setAdditionalConfig(AdditionalConfig additionalConfig) {
		this.additionalConfig = additionalConfig;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private String branch;

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	private String projectTitle;

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	private int yearOfProject;

	public int getYearOfProject() {
		return yearOfProject;
	}

	public void setYearOfProject(int yearOfProject) {
		this.yearOfProject = yearOfProject;
	}

	private transient ArrayList<String> skillSetNames;

	public ArrayList<String> getSkillSetNames() {
		return skillSetNames;
	}

	public void setSkillSetNames(ArrayList<String> skillSetNames) {
		this.skillSetNames = skillSetNames;
	}

	private transient ArrayList<ServicesTempModel> services;

	public ArrayList<ServicesTempModel> getServices() {
		return services;
	}

	public void setServices(ArrayList<ServicesTempModel> services) {
		this.services = services;
	}

	private double totalCostAllServices;

	public double getTotalCostAllServices() {
		return totalCostAllServices;
	}

	public void setTotalCostAllServices(double totalCostAllServices) {
		this.totalCostAllServices = totalCostAllServices;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description;

	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	private double totalRating;

	public double getTotalRating() {
		return totalRating;
	}

	public void setTotalRating(double totalRating) {
		this.totalRating = totalRating;
	}

	private String serviceType;

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

}
