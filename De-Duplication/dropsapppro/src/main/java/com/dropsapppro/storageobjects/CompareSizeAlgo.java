package com.dropsapppro.storageobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comparesizealgo")
public class CompareSizeAlgo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getFileSizeBytesClosenessCentrality() {
		return fileSizeBytesClosenessCentrality;
	}

	public void setFileSizeBytesClosenessCentrality(double fileSizeBytesClosenessCentrality) {
		this.fileSizeBytesClosenessCentrality = fileSizeBytesClosenessCentrality;
	}

	public double getUploadTimeClosenessCentrality() {
		return uploadTimeClosenessCentrality;
	}

	public void setUploadTimeClosenessCentrality(double uploadTimeClosenessCentrality) {
		this.uploadTimeClosenessCentrality = uploadTimeClosenessCentrality;
	}

	public double getMemoryClosenessCentrality() {
		return memoryClosenessCentrality;
	}

	public void setMemoryClosenessCentrality(double memoryClosenessCentrality) {
		this.memoryClosenessCentrality = memoryClosenessCentrality;
	}

	public double getFileSizeBytesBetweenCentrality() {
		return fileSizeBytesBetweenCentrality;
	}

	public void setFileSizeBytesBetweenCentrality(double fileSizeBytesBetweenCentrality) {
		this.fileSizeBytesBetweenCentrality = fileSizeBytesBetweenCentrality;
	}

	public double getUploadTimeBetweenCentrality() {
		return uploadTimeBetweenCentrality;
	}

	public void setUploadTimeBetweenCentrality(double uploadTimeBetweenCentrality) {
		this.uploadTimeBetweenCentrality = uploadTimeBetweenCentrality;
	}

	public double getMemoryBetweenCentrality() {
		return memoryBetweenCentrality;
	}

	public void setMemoryBetweenCentrality(double memoryBetweenCentrality) {
		this.memoryBetweenCentrality = memoryBetweenCentrality;
	}

	public double getFileSizeBytesECentrality() {
		return fileSizeBytesECentrality;
	}

	public void setFileSizeBytesECentrality(double fileSizeBytesECentrality) {
		this.fileSizeBytesECentrality = fileSizeBytesECentrality;
	}

	public double getUploadTimeECentrality() {
		return uploadTimeECentrality;
	}

	public void setUploadTimeECentrality(double uploadTimeECentrality) {
		this.uploadTimeECentrality = uploadTimeECentrality;
	}

	public double getMemoryBetweenECentrality() {
		return memoryBetweenECentrality;
	}

	public void setMemoryBetweenECentrality(double memoryBetweenECentrality) {
		this.memoryBetweenECentrality = memoryBetweenECentrality;
	}

	public double getFileSizeBytesOptimizedCentrality() {
		return fileSizeBytesOptimizedCentrality;
	}

	public void setFileSizeBytesOptimizedCentrality(double fileSizeBytesOptimizedCentrality) {
		this.fileSizeBytesOptimizedCentrality = fileSizeBytesOptimizedCentrality;
	}

	public double getUploadTimeOptimizedCentrality() {
		return uploadTimeOptimizedCentrality;
	}

	public void setUploadTimeOptimizedCentrality(double uploadTimeOptimizedCentrality) {
		this.uploadTimeOptimizedCentrality = uploadTimeOptimizedCentrality;
	}

	public double getMemoryOptimizedCentrality() {
		return memoryOptimizedCentrality;
	}

	public void setMemoryOptimizedCentrality(double memoryOptimizedCentrality) {
		this.memoryOptimizedCentrality = memoryOptimizedCentrality;
	}

	public double getOriginalFileBytes() {
		return originalFileBytes;
	}

	public void setOriginalFileBytes(double originalFileBytes) {
		this.originalFileBytes = originalFileBytes;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private double fileSizeBytesClosenessCentrality;

	@Column
	private double uploadTimeClosenessCentrality;

	@Column
	private double memoryClosenessCentrality;

	@Column
	private double fileSizeBytesBetweenCentrality;

	@Column
	private double uploadTimeBetweenCentrality;

	@Column
	private double memoryBetweenCentrality;

	@Column
	private double fileSizeBytesECentrality;

	@Column
	private double uploadTimeECentrality;

	@Column
	private double memoryBetweenECentrality;

	@Column
	private double fileSizeBytesOptimizedCentrality;

	@Column
	private double uploadTimeOptimizedCentrality;

	@Column
	private double memoryOptimizedCentrality;

	@Column
	private double originalFileBytes;
}
