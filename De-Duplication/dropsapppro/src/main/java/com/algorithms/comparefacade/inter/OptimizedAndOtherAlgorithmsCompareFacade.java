package com.algorithms.comparefacade.inter;

import java.text.ParseException;

import com.model.CompareOptimizedInfo;
import com.routingtopology.value.ClosenessCentralityCriteria;
import com.routingtopology.value.ECentralityCriteria;
import com.routingtopology.value.BetweenCentralityCriteria;
import com.routingtopology.value.OptimizedCriteria;


public interface OptimizedAndOtherAlgorithmsCompareFacade {

	/**
	 * @param closenessCentralityCriteria
	 * @param betweenCentralityCriteria
	 * @param optimizedCriteria
	 * @param topologyType
	 * @return CompareAODVDSDVEEDRInfo Output of All algorithms
	 * @throws ParseException
	 */
	public CompareOptimizedInfo executeOptimizedCompareAlgorithms(
			ClosenessCentralityCriteria closenessCentralityCriteria,
			BetweenCentralityCriteria betweenCentralityCriteria, OptimizedCriteria optimizedCriteria,
			ECentralityCriteria eCentralityCriteria,
			String topologyType) throws ParseException;

}
