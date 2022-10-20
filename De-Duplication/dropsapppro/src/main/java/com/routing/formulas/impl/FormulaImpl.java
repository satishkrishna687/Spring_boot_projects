package com.routing.formulas.impl;

import java.util.ArrayList;
import java.util.List;

import com.routing.formulas.inter.FormulaIF;

public class FormulaImpl implements FormulaIF {

	@Override
	public double applyEnergyConsumedFormula(double poweConsumed, double roundTripTime) {
		double energyConsumed = 0.0;
		if (roundTripTime > 0) {
			energyConsumed = poweConsumed / roundTripTime;
		}
		return energyConsumed;
	}

	@Override
	public double applyPowerConsumedFormula(double powerRequiredForTrans, double environmentalFactor,
			double distanceBetweenNodes) {
		double numerator = powerRequiredForTrans;
		double distancePower = Math.pow(distanceBetweenNodes, environmentalFactor);
		double denominator = 1 + distancePower;
		double powerConsumed = numerator / denominator;
		return powerConsumed;
	}

	@Override
	public double energyReqForTransHeaReception(double current, double voltage, double timeToTransmit) {

		return current * voltage * timeToTransmit;
	}

	@Override
	public double totalEnergyReq(double energyRecep, double energyTrans, double energyHear) {
		return energyRecep + energyTrans + energyHear;
	}

	@Override
	public double energyHops(int noOfHops, double energy) {
		return noOfHops * energy;
	}

	@Override
	public List<Double> computeGoodNessRatio(List<Double> energyList, List<Double> distanceList) {
		List<Double> goodNessRatioList = new ArrayList<Double>();
		int index = 0;
		for (double dis : distanceList) {
			double goodNessRatioNum = dis * energyList.get(index);
			double goodNessRatioDenom = denomForGoodNessRatio(energyList, distanceList);
			double goodNessratio = goodNessRatioNum / goodNessRatioDenom;
			goodNessRatioList.add(goodNessratio);
			index = index + 1;
		}
		System.out.println("Good ness ratio----->" + goodNessRatioList);
		return goodNessRatioList;
	}

	private double denomForGoodNessRatio(List<Double> energyList, List<Double> distanceList) {
		double denom = 0.0;

		if (energyList.size() == distanceList.size()) {
			int index = 0;
			for (double energyFactor : energyList) {
				denom = denom + energyFactor * distanceList.get(index);
			}
			index++;
		}
		return denom;
	}

	@Override
	public double computeTotalDistance(List<Double> distanceList) {
		double distance = 0;
		for (double distanceTemp : distanceList) {
			distance = distance + distanceTemp;
		}
		return distance;
	}

	@Override
	public double computePIValue(double alpha, double beta, double gamma, double n, double residualEnergy,
			double initialEnergy, int index, double trust) {

		double piValue = alpha * ((double) (residualEnergy / initialEnergy)) + (beta * trust) - (gamma * n);

		return piValue;
	}

	@Override
	public double applyDistanceFormula(double x1, double y1, double x2, double y2) {

		double squareRootBlock1 = x2 - x1;

		double squareRootBlock2 = y2 - y1;

		double squareRootBlock1SQURe = Math.pow(squareRootBlock1, 2);

		double squareRootBlock2SQURe = Math.pow(squareRootBlock2, 2);

		double add = squareRootBlock1SQURe + squareRootBlock2SQURe;

		double addSQRT = Math.sqrt(add);

		return addSQRT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.routing.formulas.inter.FormulaIF#computeNewSignalStrength(double,
	 * double)
	 * 
	 * e=9.48/r*sqrt(pAvg)
	 */

	@Override
	public double computeNewSignalStrength(double radius, double pAvg) {

		double signalLoss = ((double) ((double) 9.48 / (double) radius) * Math.sqrt(pAvg));

		return signalLoss;
	}

	@Override
	public double computeDistanceOfAngular(double Pt, double Pr, double Gt, double Gr, double lamda) {

		double distanceTemp = 0;
		double num_inside_square = Pt * Gr * Gt;
		double denom_inside_square = Pt * Gr * Gt;
		double num_val = Math.sqrt(num_inside_square) * lamda;
		double deno_val = Math.sqrt(denom_inside_square) * 4 * 3.14;
		distanceTemp = ((double) ((double) num_val / (double) deno_val));
		return distanceTemp;

	}

	@Override
	public double eneryConsumedFormulaForWSN(double totaldistance, double noOfHops, double energyForTx,
			double energyForAmp, double auttunationFactor) {

		double energyTxPart = 2 * energyForTx;

		double energyAmpPart = energyForAmp * Math.pow(totaldistance, auttunationFactor);

		double totalEnergyParts = energyTxPart + energyAmpPart;

		double energyConsumed = totalEnergyParts * noOfHops;
		return energyConsumed;

	}

	@Override
	public double computeRelayNode(int k1, double residualEnergy, double maximumEnergy, double distanceCHNode,
			double distanceNodeBS, int k2, double alpha) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double computeSINR(double initialNoiseFigure, double signalBW, double noiseFigure, double transmissionPower,
			double pathLoss, double powerGain) {

		double SINR = 0;
		try {

			double num1 = (double) ((double) transmissionPower / (double) pathLoss);

			double numSINR = (double) num1 * powerGain;

			double denomSINR = (double) initialNoiseFigure * signalBW * noiseFigure;

			if (denomSINR > 0) {

				SINR = (double) ((double) numSINR / (double) denomSINR);
			}

		} catch (Exception e) {

			return SINR;
		}

		return SINR;

	}

	@Override
	public double computeCQI(double SINR) {
		double CQI = 0;
		try {

			double value = (double) ((double) SINR / (double) 1.02);

			CQI = value + 16.62;

		} catch (Exception e) {

			return CQI;
		}

		return CQI;
	}

	@Override
	public double computePathLoss(double distance, double freq) {
		double pathLoss = 0;
		try {

			pathLoss = (double) (20 * Math.log(distance) + 20 * Math.log(freq) + 92.5);

		} catch (Exception e) {

			return pathLoss;
		}

		return pathLoss;
	}

}
