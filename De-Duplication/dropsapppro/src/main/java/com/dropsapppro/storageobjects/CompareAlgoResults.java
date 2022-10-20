package com.dropsapppro.storageobjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comparealgoresults")
public class CompareAlgoResults {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private double betweenCentralityTime;

	@Column
	private double eCentralityTime;

	@Column
	private double optimizedTime;

	@Column
	private double memoryConsumedClosenessCentrality;

	@Column
	private double memoryConsumedBetweenCentrality;

	@Column
	private double memoryConsumedECentrality;

	@Column
	private double memoryConsumedOptimized;

	@Column
	private double encBytesClosenessCentrality;

	@Column
	private double encBytesBetweenCentrality;

	@Column
	private double encBytesECentrality;

	@Column
	private double encBytesOptimized;

	@Column
	private double closenessCentralityTime;

	public Long getId() {
		return id;
	}

	public double getClosenessCentralityTime() {
		return closenessCentralityTime;
	}

	public void setClosenessCentralityTime(double closenessCentralityTime) {
		this.closenessCentralityTime = closenessCentralityTime;
	}

	public double getBetweenCentralityTime() {
		return betweenCentralityTime;
	}

	public void setBetweenCentralityTime(double betweenCentralityTime) {
		this.betweenCentralityTime = betweenCentralityTime;
	}

	public double geteCentralityTime() {
		return eCentralityTime;
	}

	public void seteCentralityTime(double eCentralityTime) {
		this.eCentralityTime = eCentralityTime;
	}

	public double getOptimizedTime() {
		return optimizedTime;
	}

	public void setOptimizedTime(double optimizedTime) {
		this.optimizedTime = optimizedTime;
	}

	public double getMemoryConsumedClosenessCentrality() {
		return memoryConsumedClosenessCentrality;
	}

	public void setMemoryConsumedClosenessCentrality(double memoryConsumedClosenessCentrality) {
		this.memoryConsumedClosenessCentrality = memoryConsumedClosenessCentrality;
	}

	public double getMemoryConsumedBetweenCentrality() {
		return memoryConsumedBetweenCentrality;
	}

	public void setMemoryConsumedBetweenCentrality(double memoryConsumedBetweenCentrality) {
		this.memoryConsumedBetweenCentrality = memoryConsumedBetweenCentrality;
	}

	public double getMemoryConsumedECentrality() {
		return memoryConsumedECentrality;
	}

	public void setMemoryConsumedECentrality(double memoryConsumedECentrality) {
		this.memoryConsumedECentrality = memoryConsumedECentrality;
	}

	public double getMemoryConsumedOptimized() {
		return memoryConsumedOptimized;
	}

	public void setMemoryConsumedOptimized(double memoryConsumedOptimized) {
		this.memoryConsumedOptimized = memoryConsumedOptimized;
	}

	public double getEncBytesClosenessCentrality() {
		return encBytesClosenessCentrality;
	}

	public void setEncBytesClosenessCentrality(double encBytesClosenessCentrality) {
		this.encBytesClosenessCentrality = encBytesClosenessCentrality;
	}

	public double getEncBytesBetweenCentrality() {
		return encBytesBetweenCentrality;
	}

	public void setEncBytesBetweenCentrality(double encBytesBetweenCentrality) {
		this.encBytesBetweenCentrality = encBytesBetweenCentrality;
	}

	public double getEncBytesECentrality() {
		return encBytesECentrality;
	}

	public void setEncBytesECentrality(double encBytesECentrality) {
		this.encBytesECentrality = encBytesECentrality;
	}

	public double getEncBytesOptimized() {
		return encBytesOptimized;
	}

	public void setEncBytesOptimized(double encBytesOptimized) {
		this.encBytesOptimized = encBytesOptimized;
	}

}
