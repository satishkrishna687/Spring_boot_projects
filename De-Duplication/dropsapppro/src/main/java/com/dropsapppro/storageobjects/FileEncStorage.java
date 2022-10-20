package com.dropsapppro.storageobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "fileencstorage")
public class FileEncStorage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long filestorageid;

	@Column
	private String filename;

	@Column
	private String filetype;

	@Column
	private String orginalname;

	@Column
	private String secretkey;

	@Lob
	private byte[] data;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "filestorage_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private UserInfoRouteSession userinforoutesession;

	public Long getFilestorageid() {
		return filestorageid;
	}

	public void setFilestorageid(Long filestorageid) {
		this.filestorageid = filestorageid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getOrginalname() {
		return orginalname;
	}

	public void setOrginalname(String orginalname) {
		this.orginalname = orginalname;
	}

	public String getSecretkey() {
		return secretkey;
	}

	public void setSecretkey(String secretkey) {
		this.secretkey = secretkey;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public UserInfoRouteSession getUserinforoutesession() {
		return userinforoutesession;
	}

	public void setUserinforoutesession(UserInfoRouteSession userinforoutesession) {
		this.userinforoutesession = userinforoutesession;
	}
	
	public String getAlgorithmname() {
		return algorithmname;
	}

	public void setAlgorithmname(String algorithmname) {
		this.algorithmname = algorithmname;
	}

	@Column
	private String algorithmname;

}
