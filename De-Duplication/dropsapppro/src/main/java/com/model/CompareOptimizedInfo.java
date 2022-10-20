package com.model;

import java.io.Serializable;

import com.routingtopology.value.ClosenessCentralityRouteInfo;
import com.routingtopology.value.ECentralityRouteInfo;
import com.routingtopology.value.BetweenCentralityRouteInfo;
import com.routingtopology.value.OptimizedRouteInfo;

public class CompareOptimizedInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private OptimizedRouteInfo optimizedRouteInfo;

	public OptimizedRouteInfo getOptimizedRouteInfo() {
		return optimizedRouteInfo;
	}

	public void setOptimizedRouteInfo(OptimizedRouteInfo optimizedRouteInfo) {
		this.optimizedRouteInfo = optimizedRouteInfo;
	}

	public ClosenessCentralityRouteInfo getClonessCentralityRouteInfo() {
		return clonessCentralityRouteInfo;
	}

	public void setClonessCentralityRouteInfo(ClosenessCentralityRouteInfo clonessCentralityRouteInfo) {
		this.clonessCentralityRouteInfo = clonessCentralityRouteInfo;
	}

	public BetweenCentralityRouteInfo getBetweenCentralityRouteInfo() {
		return betweenCentralityRouteInfo;
	}

	public void setBetweenCentralityRouteInfo(BetweenCentralityRouteInfo betweenCentralityRouteInfo) {
		this.betweenCentralityRouteInfo = betweenCentralityRouteInfo;
	}

	public ECentralityRouteInfo geteCentralityRouteInfo() {
		return eCentralityRouteInfo;
	}

	public void seteCentralityRouteInfo(ECentralityRouteInfo eCentralityRouteInfo) {
		this.eCentralityRouteInfo = eCentralityRouteInfo;
	}

	private ClosenessCentralityRouteInfo clonessCentralityRouteInfo;

	private BetweenCentralityRouteInfo betweenCentralityRouteInfo;

	private ECentralityRouteInfo eCentralityRouteInfo;

	public String getExceptionDetail() {
		return exceptionDetail;
	}

	public void setExceptionDetail(String exceptionDetail) {
		this.exceptionDetail = exceptionDetail;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	private String exceptionDetail;

	private boolean status;

	private boolean dataTransmissionStatus;

	public boolean isDataTransmissionStatus() {
		return dataTransmissionStatus;
	}

	public void setDataTransmissionStatus(boolean dataTransmissionStatus) {
		this.dataTransmissionStatus = dataTransmissionStatus;
	}

	public String getDataTxError() {
		return dataTxError;
	}

	public void setDataTxError(String dataTxError) {
		this.dataTxError = dataTxError;
	}

	private String dataTxError;

}
