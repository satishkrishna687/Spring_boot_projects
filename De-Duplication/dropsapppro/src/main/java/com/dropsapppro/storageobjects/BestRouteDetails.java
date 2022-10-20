package com.dropsapppro.storageobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bestroutedetails")
public class BestRouteDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bestroutedetailid;

	public Long getBestroutedetailid() {
		return bestroutedetailid;
	}

	public void setBestroutedetailid(Long bestroutedetailid) {
		this.bestroutedetailid = bestroutedetailid;
	}

	public int getNodeid() {
		return nodeid;
	}

	public void setNodeid(int nodeid) {
		this.nodeid = nodeid;
	}

	public UserInfoRouteSession getUserinforoutesession() {
		return userinforoutesession;
	}

	public void setUserinforoutesession(UserInfoRouteSession userinforoutesession) {
		this.userinforoutesession = userinforoutesession;
	}

	@Column
	private int nodeid;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "routeno_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private UserInfoRouteSession userinforoutesession;

}
