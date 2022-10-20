package com.loginmaintain.storagemodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "services")
public class ServicesModel extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "userName", insertable = true, updatable = false),
			@JoinColumn(name = "appName", insertable = true, updatable = false) })
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private UserMaintainence userMaintainence;

	public UserMaintainence getUserMaintainence() {
		return userMaintainence;
	}

	public void setUserMaintainence(UserMaintainence userMaintainence) {
		this.userMaintainence = userMaintainence;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public String getCompanyNameService() {
		return companyNameService;
	}

	public void setCompanyNameService(String companyNameService) {
		this.companyNameService = companyNameService;
	}

	@Column
	private String companyNameService;
	

	@Column
	private String serviceName;

	@Column
	private double cost;

}
