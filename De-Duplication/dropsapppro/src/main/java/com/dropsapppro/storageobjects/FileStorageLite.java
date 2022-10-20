package com.dropsapppro.storageobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "filestorage")
public class FileStorageLite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "filestorageid_generator")
	@SequenceGenerator(name = "filestorageid_generator", sequenceName = "filestorageid_sequence", initialValue = 1)
	private Long filestorageid;
	
	@Column
	private String algorithmname;
	
	
	public String getAlgorithmname() {
		return algorithmname;
	}

	public void setAlgorithmname(String algorithmname) {
		this.algorithmname = algorithmname;
	}

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

	public UserInfoRouteSession getUserinforoutesession() {
		return userinforoutesession;
	}

	public void setUserinforoutesession(UserInfoRouteSession userinforoutesession) {
		this.userinforoutesession = userinforoutesession;
	}

	@Column
	private String filename;

	@Column
	private String filetype;

	@Column
	private String orginalname;

	@Column
	private String secretkey;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "filestorage_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "routeno")
	 private UserInfoRouteSession userinforoutesession;
}
