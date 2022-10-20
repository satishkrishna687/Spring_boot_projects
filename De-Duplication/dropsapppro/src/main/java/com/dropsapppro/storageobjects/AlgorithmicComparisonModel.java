package com.dropsapppro.storageobjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "algorithmcomparisonmodel")
public class AlgorithmicComparisonModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAlgo1Time() {
		return algo1Time;
	}

	public void setAlgo1Time(double algo1Time) {
		this.algo1Time = algo1Time;
	}

	public double getAlgo2Time() {
		return algo2Time;
	}

	public void setAlgo2Time(double algo2Time) {
		this.algo2Time = algo2Time;
	}

	public double getLevelAlgo1() {
		return levelAlgo1;
	}

	public void setLevelAlgo1(double levelAlgo1) {
		this.levelAlgo1 = levelAlgo1;
	}

	public double getLevelAlgo2() {
		return levelAlgo2;
	}

	public void setLevelAlgo2(double levelAlgo2) {
		this.levelAlgo2 = levelAlgo2;
	}

	@Column
	private double algo1Time;
	
	@Column
	private double algo2Time;
	
	@Column
	private double levelAlgo1;
	
	@Column
	private double levelAlgo2;
	
	
}
