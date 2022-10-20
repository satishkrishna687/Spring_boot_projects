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
@Table(name = "filereplicastorage")
public class FileReplicaStorage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long filereplicaid;

	public Long getFilereplicaid() {
		return filereplicaid;
	}

	public void setFilereplicaid(Long filereplicaid) {
		this.filereplicaid = filereplicaid;
	}

	public String getDatachunk() {
		return datachunk;
	}

	public void setDatachunk(String datachunk) {
		this.datachunk = datachunk;
	}

	public int getSequeneno() {
		return sequeneno;
	}

	public void setSequeneno(int sequeneno) {
		this.sequeneno = sequeneno;
	}

	public String getEncryptedchunk() {
		return encryptedchunk;
	}

	public void setEncryptedchunk(String encryptedchunk) {
		this.encryptedchunk = encryptedchunk;
	}

	public FileStorage getFilestorage() {
		return filestorage;
	}

	public void setFilestorage(FileStorage filestorage) {
		this.filestorage = filestorage;
	}

	public String getAlgorithmName() {
		return algorithmName;
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	@Column(columnDefinition = "TEXT")
	private String datachunk;

	@Column
	private int sequeneno;

	@Column(columnDefinition = "TEXT")
	private String encryptedchunk;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "filestoragereplica_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private FileStorage filestorage;

	@Column
	private String algorithmName;

	@Column
	private int nodeId;
	
	@Column
	private int pageNo;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
	@Column
	private String sessionId;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	@Column
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
