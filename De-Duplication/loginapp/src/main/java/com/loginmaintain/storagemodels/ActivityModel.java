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
@Table(name = "activities")
public class ActivityModel  extends AuditModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String activityName;

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityDesc() {
		return activityDesc;
	}

	public void setActivityDesc(String activityDesc) {
		this.activityDesc = activityDesc;
	}

	@Column
	private String activityDesc;

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

}
