package com.dropsapppro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "downloadalgorithmicstorage")
public class DownloadAlgorithmicStorage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iterationno;
	
	public int getIterationno() {
		return iterationno;
	}

	public void setIterationno(int iterationno) {
		this.iterationno = iterationno;
	}

	public double getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(double timeTaken) {
		this.timeTaken = timeTaken;
	}

	public double getOrginalFileBytes() {
		return orginalFileBytes;
	}

	public void setOrginalFileBytes(double orginalFileBytes) {
		this.orginalFileBytes = orginalFileBytes;
	}

	@Column
	private double timeTaken;
	
	@Column
	private String algorithmicname;
	
	public String getAlgorithmicname() {
		return algorithmicname;
	}

	public void setAlgorithmicname(String algorithmicname) {
		this.algorithmicname = algorithmicname;
	}

	@Column
	private double orginalFileBytes;

}
