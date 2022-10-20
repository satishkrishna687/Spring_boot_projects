package com.dropsapppro.storageobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
public class FileEncStorageDownload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "fileencstorageid_generator")
	@SequenceGenerator(name = "fileencstorageid_generator", sequenceName = "fileencstorageid_sequence", initialValue = 1)
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

	
}
