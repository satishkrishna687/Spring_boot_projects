package com.routing.formulas.inter;

import java.util.List;

public interface FormulaIF {
	/* Pr=PtGtGr(lamda/4pir)2* */

	/**
	 * @param Pt
	 * @param Pr
	 * @param Gt
	 * @param Gr
	 * @param lamda
	 * @return distance beween tx an rx
	 */
	public double computeDistanceOfAngular(double Pt, double Pr, double Gt,
			double Gr, double lamda);

	/**
	 * @param radius
	 * @param pAvg
	 * @return signal strength
	 */
	public double computeNewSignalStrength(double radius, double pAvg);

	/**
	 * @param powerRequiredForTrans
	 * @param environmentalFactor
	 * @param distanceBetweenNodes
	 * @return Power Consumed
	 */
	public double applyPowerConsumedFormula(double powerRequiredForTrans,
			double environmentalFactor, double distanceBetweenNodes);

	/**
	 * @param poweConsumed
	 * @param roundTripTime
	 * @return Energy Consumed
	 */
	public double applyEnergyConsumedFormula(double poweConsumed,
			double roundTripTime);

	/**
	 * @param current
	 * @param voltage
	 * @param timeToTransmit
	 * @return energy required for transmission
	 */
	public double energyReqForTransHeaReception(double current, double voltage,
			double timeToTransmit);

	/**
	 * @param energyRecep
	 * @param energyTrans
	 * @param energyHear
	 * @return total energy required
	 */
	public double totalEnergyReq(double energyRecep, double energyTrans,
			double energyHear);

	/**
	 * @param noOfHops
	 * @param energy
	 * @return energy of the node
	 */
	public double energyHops(int noOfHops, double energy);

	/**
	 * @param distanceList
	 * @return totalDistance
	 */
	public double computeTotalDistance(List<Double> distanceList);

	/**
	 * @param energyList
	 * @param distanceList
	 * @return Goodness ratio of the route
	 */
	public List<Double> computeGoodNessRatio(List<Double> energyList,
			List<Double> distanceList);

	/**
	 * @param alpha
	 * @param beta
	 * @param gamma
	 * @param n
	 * @param residualEnergy
	 * @param initialEnergy
	 * @param index
	 * @param trust
	 * @return PI Value of a node
	 */
	public double computePIValue(double alpha, double beta, double gamma,
			double n, double residualEnergy, double initialEnergy, int index,
			double trust);

	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return Power Consumption on the route
	 */
	public double applyDistanceFormula(double x1, double y1, double x2,
			double y2);

	/**
	 * @param totaldistance
	 * @param noOfHops
	 * @param energyForTx
	 * @param energyForAmp
	 * @param auttunationFactaor
	 * @return Energy Consumption for a WSN network
	 */
	public double eneryConsumedFormulaForWSN(double totaldistance,
			double noOfHops, double energyForTx, double energyForAmp,
			double auttunationFactaor);

	/**
	 * @param k1
	 * @param residualEnergy
	 * @param maximumEnergy
	 * @param distanceCHNode
	 * @param distanceNodeBS
	 * @param k2
	 * @param alpha
	 * @return Relay Node value
	 */
	public double computeRelayNode(int k1, double residualEnergy,
			double maximumEnergy, double distanceCHNode, double distanceNodeBS,
			int k2, double alpha);

	public double computeSINR(double initialNoiseFigure, double signalBW, double noiseFigure, double transmissionPower,
			double pathLoss, double powerGain);

	public double computeCQI(double SINR);

	public double computePathLoss(double distance, double freq);

}
