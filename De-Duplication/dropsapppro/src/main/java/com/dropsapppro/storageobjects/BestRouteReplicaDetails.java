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
@Table(name = "bestroutereplicadetails")
public class BestRouteReplicaDetails implements Serializable {

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

	public int getReplicanode() {
		return replicanode;
	}

	public void setReplicanode(int replicanode) {
		this.replicanode = replicanode;
	}

	public UserInfoRouteSession getUserinforoutesession() {
		return userinforoutesession;
	}

	public void setUserinforoutesession(UserInfoRouteSession userinforoutesession) {
		this.userinforoutesession = userinforoutesession;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long routeno;

	@Column
	private int replicanode;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "routenoreplica_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private UserInfoRouteSession userinforoutesession;

}
