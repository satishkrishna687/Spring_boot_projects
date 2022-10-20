package com.dropsapppro.storageobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "userinforoutesession")
public class UserInfoRouteSession extends AuditModel {
	
	
	public UserInfoRouteSession(){
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Long getRouteno() {
		return routeno;
	}

	public void setRouteno(Long routeno) {
		this.routeno = routeno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public String getRouteinstrformat() {
		return routeinstrformat;
	}

	public void setRouteinstrformat(String routeinstrformat) {
		this.routeinstrformat = routeinstrformat;
	}

	public String getAlgorithmtype() {
		return algorithmtype;
	}

	public void setAlgorithmtype(String algorithmtype) {
		this.algorithmtype = algorithmtype;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long routeno;

	

	@Column
	private String username;

	@Column
	private String sessionid;

	@Column
	private String routeinstrformat;
	
	@Column
	private String algorithmtype;

	

	

}
