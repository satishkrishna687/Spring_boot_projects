package com.routingtopology.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.model.PerformanceResidualEnergy;
import com.routingtopology.dao.inter.PerformanceDAOIF;
import com.routingtopology.value.PerformanceAliveNodes;
import com.routingtopology.value.PerformanceDeadNodes;
import com.routingtopology.value.PerformanceEnergy;
import com.routingtopology.value.PerformanceHops;
import com.routingtopology.value.PerformanceLifeTimeRatio;
import com.routingtopology.value.PerformancePacketLoss;
import com.routingtopology.value.PerformancePower;
import com.routingtopology.value.PerformanceRoutingOverhead;
import com.routingtopology.value.PerformanceThroughput;
import com.routingtopology.value.PerformanceTimeTaken;
import com.routingtopology.value.PerformanceTrust;

@Repository
public class PerformanceDAOImpl extends RoutingDaoImpl implements PerformanceDAOIF {

	@Override
	public boolean insertEnergyAlgo1(double energy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertEnergyAlgo1()");
		boolean insertionEnergyFlag = false;
		try {
			insertionEnergyFlag = insert(INSERT_ENERGY_ITERATION_ALGO1_QUERY, createEnergyMap(energy));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertionEnergyFlag;
	}

	private Map<String, Object> createEnergyMap(double energy) {
		Map<String, Object> energyMap = new HashMap<String, Object>();
		energyMap.put(ENERGY_COL, energy);
		return energyMap;
	}

	private Map<String, Object> createPowerMap(double power) {
		Map<String, Object> powerMap = new HashMap<String, Object>();
		powerMap.put(POWER_COL, power);
		return powerMap;
	}

	@Override
	public boolean insertEnergyAlgo2(double energy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertEnergyAlgo2()");
		boolean insertionEnergyFlag = false;
		try {
			insertionEnergyFlag = insert(INSERT_ENERGY_ITERATION_ALGO2_QUERY, createEnergyMap(energy));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertionEnergyFlag;
	}

	@Override
	public boolean insertNoOfHopsAlgo1(int noOfHops) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfHopsAlgo1()");
		boolean insertHopsFlag = false;
		try {
			insertHopsFlag = insert(INSERT_HOPS_ITERATION_ALGO1_QUERY, createHopsMap(noOfHops));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return insertHopsFlag;
	}

	private Map<String, Object> createHopsMap(int noOfHops) {
		Map<String, Object> hopsMap = new HashMap<String, Object>();
		hopsMap.put(HOPS_COL, noOfHops);
		return hopsMap;
	}

	@Override
	public boolean insertNoOfHopsAlgo2(int noOfHops) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfHopsAlgo1()");
		boolean insertHopsFlag = false;
		try {
			insertHopsFlag = insert(INSERT_HOPS_ITERATION_ALGO2_QUERY, createHopsMap(noOfHops));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return insertHopsFlag;

	}

	@Override
	public boolean insertPowerAlgo1(double power) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertPowerAlgo1()");
		boolean insertionPowerFlag = false;
		try {
			insertionPowerFlag = insert(INSERT_POWER_ITERATION_ALGO1_QUERY, createPowerMap(power));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertionPowerFlag;
	}

	@Override
	public boolean insertPowerAlgo2(double power) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertPowerAlgo2()");
		boolean insertionPowerFlag = false;
		try {
			insertionPowerFlag = insert(INSERT_POWER_ITERATION_ALGO2_QUERY, createPowerMap(power));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertionPowerFlag;
	}

	@Override
	public boolean insertRoundTripTimeAlgo1(double timeTaken) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoundTripTimeAlgo1()");
		boolean insertionRTTFlag1 = false;
		try {
			insertionRTTFlag1 = insert(INSERT_TIME_ITERATION_ALGO1_QUERY, createTimeTakenMap(timeTaken));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return insertionRTTFlag1;
	}

	private Map<String, Object> createTimeTakenMap(double timeTaken) {
		Map<String, Object> powerMap = new HashMap<String, Object>();
		powerMap.put(TIMETAKEN_COL, timeTaken);
		return powerMap;
	}

	@Override
	public boolean insertRoundTripTimeAlgo2(double timeTaken) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoundTripTimeAlgo2()");
		boolean insertionRTTFlag2 = false;
		try {
			insertionRTTFlag2 = insert(INSERT_TIME_ITERATION_ALGO2_QUERY, createTimeTakenMap(timeTaken));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return insertionRTTFlag2;
	}

	@Override
	public List<PerformanceEnergy> retriveEnergyAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo1() Start");
		List<PerformanceEnergy> perfEnergyList = null;
		try {
			perfEnergyList = queryForEnergyPerf(RETRIVE_ENERGY_ITERATION_ALGO1_QUERY);

		} catch (DataAccessException dae) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo1() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo1() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRandomTopology() End");
		return perfEnergyList;
	}

	@Override
	public List<PerformanceEnergy> retriveEnergyAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo2() Start");
		List<PerformanceEnergy> perfEnergyList = null;
		try {
			perfEnergyList = queryForEnergyPerf(RETRIVE_ENERGY_ITERATION_ALGO2_QUERY);

		} catch (DataAccessException dae) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo2() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo2() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo2() End");
		return perfEnergyList;
	}

	@Override
	public List<PerformanceHops> retriveNoOfHopsAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo1() Start");
		List<PerformanceHops> persfHopList = null;
		try {
			persfHopList = queryForHopsPerf(RETRIVE_HOPS_ITERATION_ALGO1_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo1() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo1() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo1() End");
		return persfHopList;
	}

	@Override
	public List<PerformanceHops> retriveNoOfHopsAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo2() Start");
		List<PerformanceHops> perfHopsList = null;
		try {
			perfHopsList = queryForHopsPerf(RETRIVE_HOPS_ITERATION_ALGO2_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo2() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo2() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo2() End");
		return perfHopsList;
	}

	@Override
	public List<PerformancePower> retrivePowerAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo1() Start");
		List<PerformancePower> perfPowerList = null;
		try {
			perfPowerList = queryForPowerPerf(RETRIVE_POWER_ITERATION_ALGO1_QUERY);

		} catch (DataAccessException dae) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo1() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo1() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo1() End");
		return perfPowerList;
	}

	@Override
	public List<PerformancePower> retrivePowerAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo2() Start");
		List<PerformancePower> perfPowerList = null;
		try {
			perfPowerList = queryForPowerPerf(RETRIVE_POWER_ITERATION_ALGO2_QUERY);

		} catch (DataAccessException dae) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo2() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo2() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo2() End");
		return perfPowerList;
	}

	@Override
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo1() Start");
		List<PerformanceTimeTaken> timeTakenList = null;
		try {
			timeTakenList = queryForTimeTakenPerf(RETRIVE_TIME_ITERATION_ALGO1_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo1() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo1() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo1() End");
		return timeTakenList;
	}

	@Override
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo2() Start");
		List<PerformanceTimeTaken> timeTakenList = null;
		try {
			timeTakenList = queryForTimeTakenPerf(RETRIVE_TIME_ITERATION_ALGO2_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo2() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo2() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo2() End");
		return timeTakenList;
	}

	@Override
	public boolean insertTrustAlgo1(double trustLevel) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertTrustAlgo1()");
		boolean insertTrustAlgo1 = false;
		try {
			insertTrustAlgo1 = insert(INSERT_TRUST_ITERATION_ALGO1_QUERY, createTrustMap(trustLevel));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return insertTrustAlgo1;
	}

	private Map<String, Object> createTrustMap(double trustLevel) {
		Map<String, Object> trustMap = new HashMap<String, Object>();
		trustMap.put(TRUSTPERF_COL, trustLevel);
		return trustMap;
	}

	@Override
	public boolean insertTrustAlgo2(double trustLevel) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertTrustAlgo2()");
		boolean insertTrustAlgo2 = false;
		try {
			insertTrustAlgo2 = insert(INSERT_TRUST_ITERATION_ALGO2_QUERY, createTrustMap(trustLevel));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return insertTrustAlgo2;
	}

	@Override
	public List<PerformanceTrust> retriveTrustlAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo1() Start");
		List<PerformanceTrust> perfTrustList = null;
		try {
			perfTrustList = queryForTrustPerf(RETRIVE_TRUST_ITERATION_ALGO1_QUERY);

		} catch (DataAccessException dae) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo1() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo1() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo1() End");
		return perfTrustList;
	}

	@Override
	public List<PerformanceTrust> retriveTrustlAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo2() Start");
		List<PerformanceTrust> perfTrustList = null;
		try {
			perfTrustList = queryForTrustPerf(RETRIVE_TRUST_ITERATION_ALGO2_QUERY);

		} catch (DataAccessException dae) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo2() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo2() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo2() End");
		return perfTrustList;

	}

	@Override
	public boolean insertNoOfHopsAlgo3(int noOfHops) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfHopsAlgo3()");
		boolean insertHopsFlag = false;
		try {
			insertHopsFlag = insert(INSERT_HOPS_ITERATION_ALGO3_QUERY, createHopsMap(noOfHops));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Hop Count of Algorithm3" + dae.getMessage());
		}
		return insertHopsFlag;
	}

	@Override
	public List<PerformanceHops> retriveNoOfHopsAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo3() Start");
		List<PerformanceHops> perfHopsList = null;
		try {
			perfHopsList = queryForHopsPerf(RETRIVE_HOPS_ITERATION_ALGO3_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo3() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo3() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo3() End");
		return perfHopsList;
	}

	@Override
	public boolean insertRoundTripTimeAlgo3(double timeTaken) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoundTripTimeAlgo3()");
		boolean insertionRTTFlag2 = false;
		try {
			insertionRTTFlag2 = insert(INSERT_TIME_ITERATION_ALGO3_QUERY, createTimeTakenMap(timeTaken));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Round Trip Time For Algorithm3" + dae.getMessage());
		}
		return insertionRTTFlag2;
	}

	@Override
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo3() Start");
		List<PerformanceTimeTaken> timeTakenList = null;
		try {
			timeTakenList = queryForTimeTakenPerf(RETRIVE_TIME_ITERATION_ALGO3_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo3() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo3() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo3() End");
		return timeTakenList;
	}

	@Override
	public boolean insertPowerAlgo3(double power) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertPowerAlgo3()");
		boolean insertionPowerFlag = false;
		try {
			insertionPowerFlag = insert(INSERT_POWER_ITERATION_ALGO3_QUERY, createPowerMap(power));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Power Computation for Algorithm3" + dae.getMessage());
		}

		return insertionPowerFlag;
	}

	@Override
	public List<PerformancePower> retrivePowerAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo3() Start");
		List<PerformancePower> perfPowerList = null;
		try {
			perfPowerList = queryForPowerPerf(RETRIVE_POWER_ITERATION_ALGO3_QUERY);

		} catch (DataAccessException dae) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo3() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo3() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo3() End");
		return perfPowerList;
	}

	@Override
	public boolean insertEnergyAlgo3(double energy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertEnergyAlgo3()");
		boolean insertionEnergyFlag = false;
		try {
			insertionEnergyFlag = insert(INSERT_ENERGY_ITERATION_ALGO3_QUERY, createEnergyMap(energy));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertionEnergyFlag;
	}

	@Override
	public List<PerformanceEnergy> retriveEnergyAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo3() Start");
		List<PerformanceEnergy> perfEnergyList = null;
		try {
			perfEnergyList = queryForEnergyPerf(RETRIVE_ENERGY_ITERATION_ALGO3_QUERY);

		} catch (DataAccessException dae) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo3() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo3() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo3() End");
		return perfEnergyList;
	}

	@Override
	public boolean insertNoOfHopsAlgo4(int noOfHops) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfHopsAlgo4()");
		boolean insertHopsFlag = false;
		try {
			insertHopsFlag = insert(INSERT_HOPS_ITERATION_ALGO4_QUERY, createHopsMap(noOfHops));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Hop Count of Algorithm 4" + dae.getMessage());
		}
		return insertHopsFlag;
	}

	@Override
	public List<PerformanceHops> retriveNoOfHopsAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo4() Start");
		List<PerformanceHops> perfHopsList = null;
		try {
			perfHopsList = queryForHopsPerf(RETRIVE_HOPS_ITERATION_ALGO4_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo4() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo4() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo4() End");
		return perfHopsList;
	}

	@Override
	public boolean insertRoundTripTimeAlgo4(double timeTaken) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoundTripTimeAlgo4()");
		boolean insertionRTTFlag4 = false;
		try {
			insertionRTTFlag4 = insert(INSERT_TIME_ITERATION_ALGO4_QUERY, createTimeTakenMap(timeTaken));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Round Trip Time For Algorithm 4" + dae.getMessage());
		}
		return insertionRTTFlag4;
	}

	@Override
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo4() Start");
		List<PerformanceTimeTaken> timeTakenList = null;
		try {
			timeTakenList = queryForTimeTakenPerf(RETRIVE_TIME_ITERATION_ALGO4_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo4() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo4() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo4() End");
		return timeTakenList;
	}

	@Override
	public boolean insertPowerAlgo4(double power) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertPowerAlgo4()");
		boolean insertionPowerFlag = false;
		try {
			insertionPowerFlag = insert(INSERT_POWER_ITERATION_ALGO4_QUERY, createPowerMap(power));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Power Computation for Algorithm 4" + dae.getMessage());
		}

		return insertionPowerFlag;
	}

	@Override
	public List<PerformancePower> retrivePowerAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo4() Start");
		List<PerformancePower> perfPowerList = null;
		try {
			perfPowerList = queryForPowerPerf(RETRIVE_POWER_ITERATION_ALGO4_QUERY);

		} catch (DataAccessException dae) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo4() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo4() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo4() End");
		return perfPowerList;
	}

	@Override
	public boolean insertEnergyAlgo4(double energy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertEnergyAlgo4()");
		boolean insertionEnergyFlag = false;
		try {
			insertionEnergyFlag = insert(INSERT_ENERGY_ITERATION_ALGO4_QUERY, createEnergyMap(energy));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertionEnergyFlag;
	}

	@Override
	public List<PerformanceEnergy> retriveEnergyAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo4() Start");
		List<PerformanceEnergy> perfEnergyList = null;
		try {
			perfEnergyList = queryForEnergyPerf(RETRIVE_ENERGY_ITERATION_ALGO4_QUERY);

		} catch (DataAccessException dae) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo4() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo4() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo4() End");
		return perfEnergyList;
	}

	@Override
	public boolean insertTrustAlgo3(double trustLevel) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertTrustAlgo3()");
		boolean insertTrustAlgo3 = false;
		try {
			insertTrustAlgo3 = insert(INSERT_TRUST_ITERATION_ALGO3_QUERY, createTrustMap(trustLevel));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Trust For Algorithm 3" + dae.getMessage());
		}
		return insertTrustAlgo3;
	}

	@Override
	public boolean insertTrustAlgo4(double trustLevel) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertTrustAlgo4()");
		boolean insertTrustAlgo4 = false;
		try {
			insertTrustAlgo4 = insert(INSERT_TRUST_ITERATION_ALGO4_QUERY, createTrustMap(trustLevel));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Trust For Algorithm 4" + dae.getMessage());
		}
		return insertTrustAlgo4;
	}

	@Override
	public List<PerformanceTrust> retriveTrustlAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo3() Start");
		List<PerformanceTrust> perfTrustList = null;
		try {
			perfTrustList = queryForTrustPerf(RETRIVE_TRUST_ITERATION_ALGO3_QUERY);

		} catch (DataAccessException dae) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo3() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo3() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo3() End");
		return perfTrustList;
	}

	@Override
	public List<PerformanceTrust> retriveTrustlAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo4() Start");
		List<PerformanceTrust> perfTrustList = null;
		try {
			perfTrustList = queryForTrustPerf(RETRIVE_TRUST_ITERATION_ALGO4_QUERY);

		} catch (DataAccessException dae) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo4() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo4() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo4() End");
		return perfTrustList;
	}

	@Override
	public boolean insertNoOfHopsAlgo5(int noOfHops) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfHopsAlgo5()");
		boolean insertHopsFlag = false;
		try {
			insertHopsFlag = insert(INSERT_HOPS_ITERATION_ALGO5_QUERY, createHopsMap(noOfHops));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Hop Count of Algorithm 5" + dae.getMessage());
		}
		return insertHopsFlag;
	}

	@Override
	public List<PerformanceHops> retriveNoOfHopsAlgo5() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo5() Start");
		List<PerformanceHops> perfHopsList = null;
		try {
			perfHopsList = queryForHopsPerf(RETRIVE_HOPS_ITERATION_ALGO5_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo5() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo5() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo5() End");
		return perfHopsList;
	}

	@Override
	public boolean insertRoundTripTimeAlgo5(double timeTaken) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoundTripTimeAlgo5()");
		boolean insertionRTTFlag5 = false;
		try {
			insertionRTTFlag5 = insert(INSERT_TIME_ITERATION_ALGO5_QUERY, createTimeTakenMap(timeTaken));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Round Trip Time For Algorithm 5" + dae.getMessage());
		}
		return insertionRTTFlag5;
	}

	@Override
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo5() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo5() Start");
		List<PerformanceTimeTaken> timeTakenList = null;
		try {
			timeTakenList = queryForTimeTakenPerf(RETRIVE_TIME_ITERATION_ALGO5_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo5() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo5() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo5() End");
		return timeTakenList;
	}

	@Override
	public boolean insertPowerAlgo5(double power) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertPowerAlgo5()");
		boolean insertionPowerFlag = false;
		try {
			insertionPowerFlag = insert(INSERT_POWER_ITERATION_ALGO5_QUERY, createPowerMap(power));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Power For Algorithm5" + dae.getMessage());
		}

		return insertionPowerFlag;
	}

	@Override
	public List<PerformancePower> retrivePowerAlgo5() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo5() Start");
		List<PerformancePower> perfPowerList = null;
		try {
			perfPowerList = queryForPowerPerf(RETRIVE_POWER_ITERATION_ALGO5_QUERY);

		} catch (DataAccessException dae) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo5() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo5() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo5() End");
		return perfPowerList;
	}

	@Override
	public boolean insertEnergyAlgo5(double energy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertEnergyAlgo5()");
		boolean insertionEnergyFlag = false;
		try {
			insertionEnergyFlag = insert(INSERT_ENERGY_ITERATION_ALGO5_QUERY, createEnergyMap(energy));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of energy Algorithm 5" + dae.getMessage());
		}

		return insertionEnergyFlag;
	}

	@Override
	public List<PerformanceEnergy> retriveEnergyAlgo5() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo5() Start");
		List<PerformanceEnergy> perfEnergyList = null;
		try {
			perfEnergyList = queryForEnergyPerf(RETRIVE_ENERGY_ITERATION_ALGO5_QUERY);

		} catch (DataAccessException dae) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo5() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo5() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo5() End");
		return perfEnergyList;
	}

	@Override
	public boolean insertNoOfHopsAlgo6(int noOfHops) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfHopsAlgo6()");
		boolean insertHopsFlag = false;
		try {
			insertHopsFlag = insert(INSERT_HOPS_ITERATION_ALGO6_QUERY, createHopsMap(noOfHops));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Hop Count of Algorithm 6" + dae.getMessage());
		}
		return insertHopsFlag;
	}

	@Override
	public List<PerformanceHops> retriveNoOfHopsAlgo6() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo6() Start");
		List<PerformanceHops> perfHopsList = null;
		try {
			perfHopsList = queryForHopsPerf(RETRIVE_HOPS_ITERATION_ALGO6_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo6() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo6() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveNoOfHopsAlgo6() End");
		return perfHopsList;
	}

	@Override
	public boolean insertRoundTripTimeAlgo6(double timeTaken) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoundTripTimeAlgo6()");
		boolean insertionRTTFlag6 = false;
		try {
			insertionRTTFlag6 = insert(INSERT_TIME_ITERATION_ALGO6_QUERY, createTimeTakenMap(timeTaken));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Round Trip Time For Algorithm 6" + dae.getMessage());
		}
		return insertionRTTFlag6;
	}

	@Override
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo6() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo6() Start");
		List<PerformanceTimeTaken> timeTakenList = null;
		try {
			timeTakenList = queryForTimeTakenPerf(RETRIVE_TIME_ITERATION_ALGO6_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo6() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo6() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoundTripTimeAlgo6() End");
		return timeTakenList;
	}

	@Override
	public boolean insertPowerAlgo6(double power) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertPowerAlgo6()");
		boolean insertionPowerFlag = false;
		try {
			insertionPowerFlag = insert(INSERT_POWER_ITERATION_ALGO6_QUERY, createPowerMap(power));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Power For Algorithm 6" + dae.getMessage());
		}

		return insertionPowerFlag;
	}

	@Override
	public List<PerformancePower> retrivePowerAlgo6() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo6() Start");
		List<PerformancePower> perfPowerList = null;
		try {
			perfPowerList = queryForPowerPerf(RETRIVE_POWER_ITERATION_ALGO6_QUERY);

		} catch (DataAccessException dae) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo6() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo6() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePowerAlgo6() End");
		return perfPowerList;
	}

	@Override
	public boolean insertEnergyAlgo6(double energy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertEnergyAlgo5()");
		boolean insertionEnergyFlag = false;
		try {
			insertionEnergyFlag = insert(INSERT_ENERGY_ITERATION_ALGO6_QUERY, createEnergyMap(energy));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of energy Algorithm 5" + dae.getMessage());
		}

		return insertionEnergyFlag;
	}

	@Override
	public List<PerformanceEnergy> retriveEnergyAlgo6() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo6() Start");
		List<PerformanceEnergy> perfEnergyList = null;
		try {
			perfEnergyList = queryForEnergyPerf(RETRIVE_ENERGY_ITERATION_ALGO6_QUERY);

		} catch (DataAccessException dae) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo6() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo6() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveEnergyAlgo6() End");
		return perfEnergyList;
	}

	@Override
	public boolean insertTrustAlgo5(double trustLevel) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertTrustAlgo5()");
		boolean insertTrustAlgo5 = false;
		try {
			insertTrustAlgo5 = insert(INSERT_TRUST_ITERATION_ALGO5_QUERY, createTrustMap(trustLevel));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Trust For Algorithm 5" + dae.getMessage());
		}
		return insertTrustAlgo5;
	}

	@Override
	public boolean insertTrustAlgo6(double trustLevel) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertTrustAlgo6()");
		boolean insertTrustAlgo6 = false;
		try {
			insertTrustAlgo6 = insert(INSERT_TRUST_ITERATION_ALGO6_QUERY, createTrustMap(trustLevel));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Trust For Algorithm 6" + dae.getMessage());
		}
		return insertTrustAlgo6;
	}

	@Override
	public List<PerformanceTrust> retriveTrustlAlgo5() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo5() Start");
		List<PerformanceTrust> perfTrustList = null;
		try {
			perfTrustList = queryForTrustPerf(RETRIVE_TRUST_ITERATION_ALGO5_QUERY);

		} catch (DataAccessException dae) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo5() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo5() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo5() End");
		return perfTrustList;
	}

	@Override
	public List<PerformanceTrust> retriveTrustlAlgo6() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo6() Start");
		List<PerformanceTrust> perfTrustList = null;
		try {
			perfTrustList = queryForTrustPerf(RETRIVE_TRUST_ITERATION_ALGO6_QUERY);

		} catch (DataAccessException dae) {
			System.out
					.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo6() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo6() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveTrustlAlgo6() End");
		return perfTrustList;
	}

	@Override
	public boolean insertNoOfDeadNodesAlgo1(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfDeadNodesAlgo1()");
		boolean insertionNoOfDeadNodesFlag = false;
		try {
			insertionNoOfDeadNodesFlag = insert(INSERT_DEADNODES_ITERATION_ALGO1_QUERY,
					createDeadNodeMap(noOfDeadNodes));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Number of Dead Nodes For Algorithm 1" + dae.getMessage());
		}

		return insertionNoOfDeadNodesFlag;
	}

	private Map<String, Object> createDeadNodeMap(int noOfDeadNodes) {
		Map<String, Object> deadNodeMap = new HashMap<String, Object>();
		deadNodeMap.put(DEADNODES_COL, noOfDeadNodes);
		return deadNodeMap;
	}

	@Override
	public boolean insertNoOfDeadNodesAlgo2(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfDeadNodesAlgo2()");
		boolean insertionNoOfDeadNodesFlag = false;
		try {
			insertionNoOfDeadNodesFlag = insert(INSERT_DEADNODES_ITERATION_ALGO2_QUERY,
					createDeadNodeMap(noOfDeadNodes));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Number of Dead Nodes For Algorithm 2" + dae.getMessage());
		}

		return insertionNoOfDeadNodesFlag;
	}

	@Override
	public boolean insertNoOfDeadNodesAlgo3(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfDeadNodesAlgo3()");
		boolean insertionNoOfDeadNodesFlag = false;
		try {
			insertionNoOfDeadNodesFlag = insert(INSERT_DEADNODES_ITERATION_ALGO3_QUERY,
					createDeadNodeMap(noOfDeadNodes));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Number of Dead Nodes For Algorithm 3" + dae.getMessage());
		}

		return insertionNoOfDeadNodesFlag;
	}

	@Override
	public boolean insertNoOfDeadNodesAlgo4(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfDeadNodesAlgo4()");
		boolean insertNoOfDeadNodes = false;
		try {
			insertNoOfDeadNodes = insert(INSERT_DEADNODES_ITERATION_ALGO4_QUERY, createDeadNodeMap(noOfDeadNodes));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Number of Dead Nodes For Algorithm 4" + dae.getMessage());
		}

		return insertNoOfDeadNodes;
	}

	@Override
	public boolean insertNoOfDeadNodesAlgo5(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfDeadNodesAlgo5()");
		boolean insertionNoOfDeadNodesFlag = false;
		try {
			insertionNoOfDeadNodesFlag = insert(INSERT_DEADNODES_ITERATION_ALGO5_QUERY,
					createDeadNodeMap(noOfDeadNodes));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Number of Dead Nodes For Algorithm 5" + dae.getMessage());
		}

		return insertionNoOfDeadNodesFlag;
	}

	@Override
	public boolean insertNoOfDeadNodesAlgo6(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfDeadNodesAlgo6()");
		boolean insertionNoOfDeadNodesFlag = false;
		try {
			insertionNoOfDeadNodesFlag = insert(INSERT_DEADNODES_ITERATION_ALGO6_QUERY,
					createDeadNodeMap(noOfDeadNodes));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Number of Dead Nodes For Algorithm 6" + dae.getMessage());
		}

		return insertionNoOfDeadNodesFlag;
	}

	@Override
	public boolean insertNoOfAliveNodesAlgo1(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfAliveNodesAlgo1()");
		boolean insertionNoOfAliveNodesFlag = false;
		try {
			insertionNoOfAliveNodesFlag = insert(INSERT_ALIVENODES_ITERATION_ALGO1_QUERY,
					createAliveNodeMap(noOfDeadNodes));
		} catch (DataAccessException dae) {
			System.out
					.println("Exception during insertion of Number of Alive Nodes For Algorithm 1" + dae.getMessage());
		}

		return insertionNoOfAliveNodesFlag;
	}

	private Map<String, Object> createAliveNodeMap(int noOfDeadNodes) {
		Map<String, Object> aliveNodeMap = new HashMap<String, Object>();
		aliveNodeMap.put(ALIVENODES_COL, noOfDeadNodes);
		return aliveNodeMap;
	}

	@Override
	public boolean insertNoOfAliveNodesAlgo2(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfAliveNodesAlgo2()");
		boolean insertionNoOfAliveNodesFlag = false;
		try {
			insertionNoOfAliveNodesFlag = insert(INSERT_ALIVENODES_ITERATION_ALGO2_QUERY,
					createAliveNodeMap(noOfDeadNodes));
		} catch (DataAccessException dae) {
			System.out
					.println("Exception during insertion of Number of Alive Nodes For Algorithm 2" + dae.getMessage());
		}

		return insertionNoOfAliveNodesFlag;
	}

	@Override
	public boolean insertNoOfAliveNodesAlgo3(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfAliveNodesAlgo3()");
		boolean insertionNoOfAliveNodesFlag = false;
		try {
			insertionNoOfAliveNodesFlag = insert(INSERT_ALIVENODES_ITERATION_ALGO3_QUERY,
					createAliveNodeMap(noOfDeadNodes));
		} catch (DataAccessException dae) {
			System.out
					.println("Exception during insertion of Number of Alive Nodes For Algorithm 3" + dae.getMessage());
		}

		return insertionNoOfAliveNodesFlag;
	}

	@Override
	public boolean insertNoOfAliveNodesAlgo4(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfAliveNodesAlgo4()");
		boolean insertionNoOfAliveNodesFlag = false;
		try {
			insertionNoOfAliveNodesFlag = insert(INSERT_ALIVENODES_ITERATION_ALGO4_QUERY,
					createAliveNodeMap(noOfDeadNodes));
		} catch (DataAccessException dae) {
			System.out
					.println("Exception during insertion of Number of Alive Nodes For Algorithm 4" + dae.getMessage());
		}

		return insertionNoOfAliveNodesFlag;
	}

	@Override
	public boolean insertNoOfAliveNodesAlgo5(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfAliveNodesAlgo5()");
		boolean insertionNoOfAliveNodesFlag = false;
		try {
			insertionNoOfAliveNodesFlag = insert(INSERT_ALIVENODES_ITERATION_ALGO5_QUERY,
					createAliveNodeMap(noOfDeadNodes));
		} catch (DataAccessException dae) {
			System.out
					.println("Exception during insertion of Number of Alive Nodes For Algorithm 5" + dae.getMessage());
		}

		return insertionNoOfAliveNodesFlag;
	}

	@Override
	public boolean insertNoOfAliveNodesAlgo6(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfAliveNodesAlgo6()");
		boolean insertionNoOfAliveNodesFlag = false;
		try {
			insertionNoOfAliveNodesFlag = insert(INSERT_ALIVENODES_ITERATION_ALGO6_QUERY,
					createAliveNodeMap(noOfDeadNodes));
		} catch (DataAccessException dae) {
			System.out
					.println("Exception during insertion of Number of Alive Nodes For Algorithm 6" + dae.getMessage());
		}

		return insertionNoOfAliveNodesFlag;
	}

	@Override
	public boolean insertPacketLossForAlgo1(int packetLoss) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertPacketLossForAlgo1()");
		boolean insertionNoOfPacketsLostFlag = false;
		try {
			insertionNoOfPacketsLostFlag = insert(INSERT_PACKETLOSS_ITERATION_ALGO1_QUERY,
					createPacketLosseMap(packetLoss));
		} catch (DataAccessException dae) {
			System.out
					.println("Exception during insertion of Number of Packets Lost For Algorithm 1" + dae.getMessage());
		}

		return insertionNoOfPacketsLostFlag;
	}

	private Map<String, Object> createPacketLosseMap(int packetLoss) {
		Map<String, Object> packetLossMap = new HashMap<String, Object>();
		packetLossMap.put(PACKETLOSS_COL, packetLoss);
		return packetLossMap;
	}

	@Override
	public boolean insertPacketLossForAlgo2(int packetLoss) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertPacketLossForAlgo2()");
		boolean insertionNoOfPacketsLostFlag = false;
		try {
			insertionNoOfPacketsLostFlag = insert(INSERT_PACKETLOSS_ITERATION_ALGO2_QUERY,
					createPacketLosseMap(packetLoss));
		} catch (DataAccessException dae) {
			System.out
					.println("Exception during insertion of Number of Packets Lost For Algorithm 2" + dae.getMessage());
		}

		return insertionNoOfPacketsLostFlag;
	}

	@Override
	public boolean insertPacketLossForAlgo3(int packetLoss) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertPacketLossForAlgo3()");
		boolean insertionNoOfPacketsLostFlag = false;
		try {
			insertionNoOfPacketsLostFlag = insert(INSERT_PACKETLOSS_ITERATION_ALGO3_QUERY,
					createPacketLosseMap(packetLoss));
		} catch (DataAccessException dae) {
			System.out
					.println("Exception during insertion of Number of Packets Lost For Algorithm 3" + dae.getMessage());
		}

		return insertionNoOfPacketsLostFlag;
	}

	@Override
	public boolean insertPacketLossForAlgo4(int packetLoss) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertPacketLossForAlgo4()");
		boolean insertionNoOfPacketsLostFlag = false;
		try {
			insertionNoOfPacketsLostFlag = insert(INSERT_PACKETLOSS_ITERATION_ALGO4_QUERY,
					createPacketLosseMap(packetLoss));
		} catch (DataAccessException dae) {
			System.out
					.println("Exception during insertion of Number of Packets Lost For Algorithm 4" + dae.getMessage());
		}

		return insertionNoOfPacketsLostFlag;
	}

	@Override
	public boolean insertPacketLossForAlgo5(int packetLoss) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertPacketLossForAlgo5()");
		boolean insertionNoOfPacketsLostFlag = false;
		try {
			insertionNoOfPacketsLostFlag = insert(INSERT_PACKETLOSS_ITERATION_ALGO5_QUERY,
					createPacketLosseMap(packetLoss));
		} catch (DataAccessException dae) {
			System.out
					.println("Exception during insertion of Number of Packets Lost For Algorithm 5" + dae.getMessage());
		}

		return insertionNoOfPacketsLostFlag;
	}

	@Override
	public boolean insertPacketLossForAlgo6(int packetLoss) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertPacketLossForAlgo6()");
		boolean insertionNoOfPacketsLostFlag = false;
		try {
			insertionNoOfPacketsLostFlag = insert(INSERT_PACKETLOSS_ITERATION_ALGO6_QUERY,
					createPacketLosseMap(packetLoss));
		} catch (DataAccessException dae) {
			System.out
					.println("Exception during insertion of Number of Packets Lost For Algorithm 6" + dae.getMessage());
		}

		return insertionNoOfPacketsLostFlag;
	}

	@Override
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo1() Start");
		List<PerformanceDeadNodes> perfDeadNodesList = null;
		try {
			perfDeadNodesList = queryForDeadNodesPerf(RETRIVE_DEADNODES_ITERATION_ALGO1_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo1() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo1() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo1() End");
		return perfDeadNodesList;
	}

	@Override
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo2() Start");
		List<PerformanceDeadNodes> perfDeadNodesList = null;
		try {
			perfDeadNodesList = queryForDeadNodesPerf(RETRIVE_DEADNODES_ITERATION_ALGO2_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo2() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo2() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo2() End");
		return perfDeadNodesList;
	}

	@Override
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo3() Start");
		List<PerformanceDeadNodes> perfDeadNodesList = null;
		try {
			perfDeadNodesList = queryForDeadNodesPerf(RETRIVE_DEADNODES_ITERATION_ALGO3_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo3() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo3() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo3() End");
		return perfDeadNodesList;
	}

	@Override
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo4() Start");
		List<PerformanceDeadNodes> perfDeadNodesList = null;
		try {
			perfDeadNodesList = queryForDeadNodesPerf(RETRIVE_DEADNODES_ITERATION_ALGO4_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo4() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo4() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo4() End");
		return perfDeadNodesList;
	}

	@Override
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo5() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo5() Start");
		List<PerformanceDeadNodes> perfDeadNodesList = null;
		try {
			perfDeadNodesList = queryForDeadNodesPerf(RETRIVE_DEADNODES_ITERATION_ALGO5_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo5() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo5() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo5() End");
		return perfDeadNodesList;
	}

	@Override
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo6() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo6() Start");
		List<PerformanceDeadNodes> perfDeadNodesList = null;
		try {
			perfDeadNodesList = queryForDeadNodesPerf(RETRIVE_DEADNODES_ITERATION_ALGO6_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo6() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo6() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveDeadNodesForAlgo6() End");
		return perfDeadNodesList;
	}

	@Override
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo1() Start");
		List<PerformanceAliveNodes> perfAliveNodesList = null;
		try {
			perfAliveNodesList = queryForAliveNodesPerf(RETRIVE_ALIVENODES_ITERATION_ALGO1_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo1() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo1() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo1() End");
		return perfAliveNodesList;
	}

	@Override
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo2() Start");
		List<PerformanceAliveNodes> perfAliveNodesList = null;
		try {
			perfAliveNodesList = queryForAliveNodesPerf(RETRIVE_ALIVENODES_ITERATION_ALGO2_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo2() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo2() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo2() End");
		return perfAliveNodesList;
	}

	@Override
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo3() Start");
		List<PerformanceAliveNodes> perfAliveNodesList = null;
		try {
			perfAliveNodesList = queryForAliveNodesPerf(RETRIVE_ALIVENODES_ITERATION_ALGO3_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo3() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo3() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo3() End");
		return perfAliveNodesList;
	}

	@Override
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo4() Start");
		List<PerformanceAliveNodes> perfAliveNodesList = null;
		try {
			perfAliveNodesList = queryForAliveNodesPerf(RETRIVE_ALIVENODES_ITERATION_ALGO4_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo4() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo4() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo4() End");
		return perfAliveNodesList;
	}

	@Override
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo5() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo5() Start");
		List<PerformanceAliveNodes> perfAliveNodesList = null;
		try {
			perfAliveNodesList = queryForAliveNodesPerf(RETRIVE_ALIVENODES_ITERATION_ALGO5_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo5() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo5() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo5() End");
		return perfAliveNodesList;
	}

	@Override
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo6() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo6() Start");
		List<PerformanceAliveNodes> perfAliveNodesList = null;
		try {
			perfAliveNodesList = queryForAliveNodesPerf(RETRIVE_ALIVENODES_ITERATION_ALGO6_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo6() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo6() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveAliveNodesForAlgo6() End");
		return perfAliveNodesList;
	}

	@Override
	public List<PerformancePacketLoss> retrivePacketLossForAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo1() Start");
		List<PerformancePacketLoss> perfPacketLossList = null;
		try {
			perfPacketLossList = queryForPacketLossPerf(RETRIVE_PACKETLOSS_ITERATION_ALGO1_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo1() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo1() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo1() End");
		return perfPacketLossList;
	}

	@Override
	public List<PerformancePacketLoss> retrivePacketLossForAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo2() Start");
		List<PerformancePacketLoss> perfPacketLossList = null;
		try {
			perfPacketLossList = queryForPacketLossPerf(RETRIVE_PACKETLOSS_ITERATION_ALGO2_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo2() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo2() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo2() End");
		return perfPacketLossList;
	}

	@Override
	public List<PerformancePacketLoss> retrivePacketLossForAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo3() Start");
		List<PerformancePacketLoss> perfPacketLossList = null;
		try {
			perfPacketLossList = queryForPacketLossPerf(RETRIVE_PACKETLOSS_ITERATION_ALGO3_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo3() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo3() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo3() End");
		return perfPacketLossList;
	}

	@Override
	public List<PerformancePacketLoss> retrivePacketLossForAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo4() Start");
		List<PerformancePacketLoss> perfPacketLossList = null;
		try {
			perfPacketLossList = queryForPacketLossPerf(RETRIVE_PACKETLOSS_ITERATION_ALGO4_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo4() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo4() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo4() End");
		return perfPacketLossList;
	}

	@Override
	public List<PerformancePacketLoss> retrivePacketLossForAlgo5() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo5() Start");
		List<PerformancePacketLoss> perfPacketLossList = null;
		try {
			perfPacketLossList = queryForPacketLossPerf(RETRIVE_PACKETLOSS_ITERATION_ALGO5_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo5() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo5() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo5() End");
		return perfPacketLossList;
	}

	@Override
	public List<PerformancePacketLoss> retrivePacketLossForAlgo6() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo5() Start");
		List<PerformancePacketLoss> perfPacketLossList = null;
		try {
			perfPacketLossList = queryForPacketLossPerf(RETRIVE_PACKETLOSS_ITERATION_ALGO6_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo5() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo5() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retrivePacketLossForAlgo5() End");
		return perfPacketLossList;
	}

	@Override
	public boolean insertRoutingOverheadAlgo1(double routingOverhead) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoutingOverheadAlgo1()");
		boolean insertROFlag = false;
		try {
			insertROFlag = insert(INSERT_ROUTINGOVERHEAD_ITERATION_ALGO1_QUERY, createROMap(routingOverhead));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertROFlag;
	}

	private Map<String, Object> createROMap(double routingOverhead) {
		Map<String, Object> hopsMap = new HashMap<String, Object>();
		hopsMap.put(ROUTINGOVERHEAD_COL, routingOverhead);
		return hopsMap;
	}

	@Override
	public boolean insertRoutingOverheadAlgo2(double routingOverhead) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoutingOverheadAlgo1()");
		boolean insertROFlag = false;
		try {
			insertROFlag = insert(INSERT_ROUTINGOVERHEAD_ITERATION_ALGO2_QUERY, createROMap(routingOverhead));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertROFlag;
	}

	@Override
	public boolean insertRoutingOverheadAlgo3(double routingOverhead) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoutingOverheadAlgo1()");
		boolean insertROFlag = false;
		try {
			insertROFlag = insert(INSERT_ROUTINGOVERHEAD_ITERATION_ALGO3_QUERY, createROMap(routingOverhead));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertROFlag;
	}

	@Override
	public List<PerformanceRoutingOverhead> retriveRoutingOverheadAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoutingOverheadAlgo1() Start");
		List<PerformanceRoutingOverhead> perfROList = null;
		try {
			perfROList = queryForROPerf(RETRIVE_ROUTINGOVERHEAD_ITERATION_ALGO1_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoutingOverheadAlgo1() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoutingOverheadAlgo1() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoutingOverheadAlgo1() End");
		return perfROList;
	}

	@Override
	public List<PerformanceRoutingOverhead> retriveRoutingOverheadAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoutingOverheadAlgo2() Start");
		List<PerformanceRoutingOverhead> perfROList = null;
		try {
			perfROList = queryForROPerf(RETRIVE_ROUTINGOVERHEAD_ITERATION_ALGO2_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoutingOverheadAlgo2() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoutingOverheadAlgo2() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoutingOverheadAlgo2() End");
		return perfROList;
	}

	@Override
	public List<PerformanceRoutingOverhead> retriveRoutingOverheadAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoutingOverheadAlgo3() Start");
		List<PerformanceRoutingOverhead> perfROList = null;
		try {
			perfROList = queryForROPerf(RETRIVE_ROUTINGOVERHEAD_ITERATION_ALGO3_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoutingOverheadAlgo3() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoutingOverheadAlgo3() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoutingOverheadAlgo3() End");
		return perfROList;
	}

	@Override
	public boolean insertLifeTimeAlgo1(double lifeTimeRatio) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertLifeTimeAlgo1()");
		boolean insertLifeTimeAlgo1 = false;
		try {
			insertLifeTimeAlgo1 = insert(INSERT_LIFETIME_ITERATION_ALGO1_QUERY, createLifeTimeMap(lifeTimeRatio));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertLifeTimeAlgo1;
	}

	private Map<String, Object> createLifeTimeMap(double energy) {
		Map<String, Object> lifetimeMap = new HashMap<String, Object>();
		lifetimeMap.put(LIFETIME_COL, energy);
		return lifetimeMap;
	}

	@Override
	public boolean insertLifeTimeAlgo2(double lifeTimeRatio) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertLifeTimeAlgo2()");
		boolean insertLifeTimeAlgo2 = false;
		try {
			insertLifeTimeAlgo2 = insert(INSERT_LIFETIME_ITERATION_ALGO2_QUERY, createLifeTimeMap(lifeTimeRatio));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return insertLifeTimeAlgo2;
	}

	@Override
	public boolean insertLifeTimeAlgo3(double lifeTimeRatio) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertLifeTimeAlgo3()");
		boolean insertLifeTimeAlgo3 = false;
		try {
			insertLifeTimeAlgo3 = insert(INSERT_LIFETIME_ITERATION_ALGO3_QUERY, createLifeTimeMap(lifeTimeRatio));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertLifeTimeAlgo3;
	}

	@Override
	public List<PerformanceLifeTimeRatio> retriveLifeTimeRatioAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveLifeTimeRatioAlgo1() Start");
		List<PerformanceLifeTimeRatio> perfLifeTimeRatioList = null;
		try {
			perfLifeTimeRatioList = queryForLifeTimePerf(RETRIVE_LIFETIME_ITERATION_ALGO1_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveLifeTimeRatioAlgo1() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveLifeTimeRatioAlgo1() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveLifeTimeRatioAlgo1() End");
		return perfLifeTimeRatioList;
	}

	@Override
	public List<PerformanceLifeTimeRatio> retriveLifeTimeRatioAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveLifeTimeRatioAlgo2() Start");
		List<PerformanceLifeTimeRatio> perfLifeTimeRatioList = null;
		try {
			perfLifeTimeRatioList = queryForLifeTimePerf(RETRIVE_LIFETIME_ITERATION_ALGO2_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveLifeTimeRatioAlgo2() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveLifeTimeRatioAlgo2() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveLifeTimeRatioAlgo2() End");
		return perfLifeTimeRatioList;
	}

	@Override
	public List<PerformanceLifeTimeRatio> retriveLifeTimeRatioAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveLifeTimeRatioAlgo3() Start");
		List<PerformanceLifeTimeRatio> perfLifeTimeRatioList = null;
		try {
			perfLifeTimeRatioList = queryForLifeTimePerf(RETRIVE_LIFETIME_ITERATION_ALGO3_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveLifeTimeRatioAlgo3() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveLifeTimeRatioAlgo3() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveLifeTimeRatioAlgo3() End");
		return perfLifeTimeRatioList;
	}

	@Override
	public boolean insertThroughputAlgo1(double throughput) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertThroughputAlgo1()");
		boolean insertThrouhputFlag = false;
		try {
			insertThrouhputFlag = insert(INSERT_THROUGHPUT_ITERATION_ALGO1_QUERY, createThroughputMap(throughput));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertThrouhputFlag;
	}

	private Map<String, Object> createThroughputMap(double energy) {
		Map<String, Object> energyMap = new HashMap<String, Object>();
		energyMap.put(THROUGHPUT_COL, energy);
		return energyMap;
	}

	@Override
	public boolean insertThroughputAlgo2(double throughput) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertThroughputAlgo2()");
		boolean insertThrouhputFlag = false;
		try {
			insertThrouhputFlag = insert(INSERT_THROUGHPUT_ITERATION_ALGO2_QUERY, createThroughputMap(throughput));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertThrouhputFlag;
	}

	@Override
	public boolean insertThroughputAlgo3(double throughput) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertThroughputAlgo3()");
		boolean insertThrouhputFlag = false;
		try {
			insertThrouhputFlag = insert(INSERT_THROUGHPUT_ITERATION_ALGO3_QUERY, createThroughputMap(throughput));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertThrouhputFlag;
	}

	@Override
	public List<PerformanceThroughput> retriveThroughputAlgo1() {
		List<PerformanceThroughput> perfThroughputLisr = null;
		try {
			perfThroughputLisr = queryForThroughputPerf(RETRIVE_THROUGHPUT_ITERATION_ALGO1_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveThroughputAlgo1() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveThroughputAlgo1() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveThroughputAlgo1() End");
		return perfThroughputLisr;
	}

	@Override
	public List<PerformanceThroughput> retriveThroughputAlgo2() {
		List<PerformanceThroughput> perfThroughputList = null;
		try {
			perfThroughputList = queryForThroughputPerf(RETRIVE_THROUGHPUT_ITERATION_ALGO2_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveThroughputAlgo2() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveThroughputAlgo2() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveThroughputAlgo2() End");
		return perfThroughputList;
	}

	@Override
	public List<PerformanceThroughput> retriveThroughputAlgo3() {
		List<PerformanceThroughput> perfThroughputList = null;
		try {
			perfThroughputList = queryForThroughputPerf(RETRIVE_THROUGHPUT_ITERATION_ALGO3_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveThroughputAlgo3() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveThroughputAlgo3() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveThroughputAlgo3() End");
		return perfThroughputList;
	}

	@Override
	public boolean insertResidualEnergyAlgo1(double residualEnergy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertResidualEnergyAlgo1()");
		boolean insertREFlag = false;
		try {
			insertREFlag = insert(INSERT_RESIDUALENERGY_ITERATION_ALGO1_QUERY, createREMap(residualEnergy));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertREFlag;
	}

	private Map<String, Object> createREMap(double residualEnergy) {
		Map<String, Object> energyMap = new HashMap<String, Object>();
		energyMap.put(RESIDUALENERGY_COL, residualEnergy);
		return energyMap;
	}

	@Override
	public boolean insertResidualEnergyAlgo2(double residualEnergy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertResidualEnergyAlgo2()");
		boolean insertREFlag = false;
		try {
			insertREFlag = insert(INSERT_RESIDUALENERGY_ITERATION_ALGO2_QUERY, createREMap(residualEnergy));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertREFlag;
	}

	@Override
	public boolean insertResidualEnergyAlgo3(double residualEnergy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertResidualEnergyAlgo3()");
		boolean insertREFlag = false;
		try {
			insertREFlag = insert(INSERT_RESIDUALENERGY_ITERATION_ALGO3_QUERY, createREMap(residualEnergy));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertREFlag;
	}

	@Override
	public List<PerformanceResidualEnergy> retriveResidualEnergyAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveResidualEnergyAlgo1() Start");
		List<PerformanceResidualEnergy> perfEnergyList = null;
		try {
			perfEnergyList = queryForResidualEnergyPerf(RETRIVE_RESIDUALENERGY_ITERATION_ALGO1_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveResidualEnergyAlgo1() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveResidualEnergyAlgo1() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRandomTopology() End");
		return perfEnergyList;
	}

	@Override
	public List<PerformanceResidualEnergy> retriveResidualEnergyAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveResidualEnergyAlgo2() Start");
		List<PerformanceResidualEnergy> perfEnergyList = null;
		try {
			perfEnergyList = queryForResidualEnergyPerf(RETRIVE_RESIDUALENERGY_ITERATION_ALGO2_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveResidualEnergyAlgo2() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveResidualEnergyAlgo2() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveResidualEnergyAlgo2() End");
		return perfEnergyList;
	}

	@Override
	public List<PerformanceResidualEnergy> retriveResidualEnergyAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveResidualEnergyAlgo3() Start");
		List<PerformanceResidualEnergy> perfEnergyList = null;
		try {
			perfEnergyList = queryForResidualEnergyPerf(RETRIVE_RESIDUALENERGY_ITERATION_ALGO3_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveResidualEnergyAlgo3() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveResidualEnergyAlgo3() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveResidualEnergyAlgo3() End");
		return perfEnergyList;
	}

	@Override
	public boolean deleteTimeTaken1() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_TIME_ALGO1);
		} catch (Exception e) {
			System.out.println("Class-->PerformanceDAOImpl:Method-->deleteLinearTopology() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteTimeTaken2() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_TIME_ALGO2);
		} catch (Exception e) {
			System.out.println("Class-->PerformanceDAOImpl:Method-->deleteLinearTopology() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteTimeTaken3() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_TIME_ALGO3);
		} catch (Exception e) {
			System.out.println("Class-->PerformanceDAOImpl:Method-->deleteLinearTopology() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteHopsAlgo1() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_HOPS_ALGO1);
		} catch (Exception e) {
			System.out.println("Class-->PerformanceDAOImpl:Method-->deleteHopsAlgo1() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteHopsAlgo2() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_HOPS_ALGO2);
		} catch (Exception e) {
			System.out.println("Class-->PerformanceDAOImpl:Method-->deleteHopsAlgo2() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteHopsAlgo3() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_HOPS_ALGO3);
		} catch (Exception e) {
			System.out.println("Class-->PerformanceDAOImpl:Method-->deleteHopsAlgo3() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteEnergyConsumedAlgo1() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_ENERGY_ALGO1);
		} catch (Exception e) {
			System.out.println(
					"Class-->PerformanceDAOImpl:Method-->deleteEnergyConsumedAlgo1() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteEnergyConsumedAlgo2() {
		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_ENERGY_ALGO2);
		} catch (Exception e) {
			System.out.println(
					"Class-->PerformanceDAOImpl:Method-->deleteEnergyConsumedAlgo2() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteEnergyConsumedAlgo3() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_ENERGY_ALGO3);
		} catch (Exception e) {
			System.out.println(
					"Class-->PerformanceDAOImpl:Method-->deleteEnergyConsumedAlgo3() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteResidualEnergyAlgo1() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_RESIDUALENERGY_ALGO1);
		} catch (Exception e) {
			System.out.println(
					"Class-->PerformanceDAOImpl:Method-->deleteResidualEnergyAlgo1() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteResidualEnergyAlgo2() {
		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_RESIDUALENERGY_ALGO2);
		} catch (Exception e) {
			System.out.println(
					"Class-->PerformanceDAOImpl:Method-->deleteResidualEnergyAlgo2() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteResidualEnergyAlgo3() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_RESIDUALENERGY_ALGO3);
		} catch (Exception e) {
			System.out.println(
					"Class-->PerformanceDAOImpl:Method-->deleteEnergyConsumedAlgo3() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteThroughputAlgo1() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_THROUGHPUT_ALGO1);
		} catch (Exception e) {
			System.out
					.println("Class-->PerformanceDAOImpl:Method-->deleteThroughputAlgo1() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteThroughputAlgo2() {
		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_THROUGHPUT_ALGO2);
		} catch (Exception e) {
			System.out
					.println("Class-->PerformanceDAOImpl:Method-->deleteThroughputAlgo2() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteThroughputAlgo3() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_THROUGHPUT_ALGO3);
		} catch (Exception e) {
			System.out
					.println("Class-->PerformanceDAOImpl:Method-->deleteThroughputAlgo3() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteAliveNodesAlgo1() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_ALIVENODES_ALGO1);
		} catch (Exception e) {
			System.out
					.println("Class-->PerformanceDAOImpl:Method-->deleteAliveNodesAlgo1() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteAliveNodesAlgo2() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_ALIVENODES_ALGO2);
		} catch (Exception e) {
			System.out
					.println("Class-->PerformanceDAOImpl:Method-->deleteAliveNodesAlgo2() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteAliveNodesAlgo3() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_ALIVENODES_ALGO3);
		} catch (Exception e) {
			System.out
					.println("Class-->PerformanceDAOImpl:Method-->deleteAliveNodesAlgo3() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteDeadNodesAlgo1() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_DEADNODES_ALGO1);
		} catch (Exception e) {
			System.out.println("Class-->PerformanceDAOImpl:Method-->deleteDeadNodesAlgo1() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteDeadNodesAlgo2() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_DEADNODES_ALGO2);
		} catch (Exception e) {
			System.out.println("Class-->PerformanceDAOImpl:Method-->deleteDeadNodesAlgo2() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteDeadNodesAlgo3() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_DEADNODES_ALGO3);
		} catch (Exception e) {
			System.out.println("Class-->PerformanceDAOImpl:Method-->deleteDeadNodesAlgo3() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteROAlgo1() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_ROUTINGOVERHEAD_ALGO1);
		} catch (Exception e) {
			System.out.println("Class-->PerformanceDAOImpl:Method-->deleteROAlgo1() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteROAlgo2() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_ROUTINGOVERHEAD_ALGO2);
		} catch (Exception e) {
			System.out.println("Class-->PerformanceDAOImpl:Method-->deleteROAlgo2() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteROAlgo3() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_ROUTINGOVERHEAD_ALGO3);
		} catch (Exception e) {
			System.out.println("Class-->PerformanceDAOImpl:Method-->deleteROAlgo3() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteLTRAlgo1() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_LIFETIME_ALGO1);
		} catch (Exception e) {
			System.out.println("Class-->PerformanceDAOImpl:Method-->deleteLTRAlgo1() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteLTRAlgo2() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_LIFETIME_ALGO2);
		} catch (Exception e) {
			System.out.println("Class-->PerformanceDAOImpl:Method-->deleteLTRAlgo2() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	@Override
	public boolean deleteLTRAlgo3() {

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_FROM_LIFETIME_ALGO3);
		} catch (Exception e) {
			System.out.println("Class-->PerformanceDAOImpl:Method-->deleteLTRAlgo3() Exception" + e.getMessage());
		}
		return deleteFlag;
	}

	public boolean insertLifeTimeAlgo4(double lifeTimeRatio) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertLifeTimeAlgo4()");
		boolean insertLifeTimeAlgo3 = false;
		try {
			insertLifeTimeAlgo3 = insert(INSERT_LIFETIME_ITERATION_ALGO4_QUERY, createLifeTimeMap(lifeTimeRatio));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertLifeTimeAlgo3;
	}

	public boolean insertResidualEnergyAlgo4(Double residualEnergy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertResidualEnergyAlgo3()");
		boolean insertREFlag = false;
		try {
			insertREFlag = insert(INSERT_RESIDUALENERGY_ITERATION_ALGO4_QUERY, createREMap(residualEnergy));
			insertREFlag = true;
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertREFlag;
	}

	public boolean insertRoutingOverheadAlgo4(Double routingOverhead) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoutingOverheadAlgo4()");
		boolean insertROFlag = false;
		try {
			insertROFlag = insert(INSERT_ROUTINGOVERHEAD_ITERATION_ALGO4_QUERY, createROMap(routingOverhead));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertROFlag;
	}

	public boolean insertThroughputAlgo4(Double throughput) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertThroughputAlgo3()");
		boolean insertThrouhputFlag = false;
		try {
			insertThrouhputFlag = insert(INSERT_THROUGHPUT_ITERATION_ALGO4_QUERY, createThroughputMap(throughput));
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertThrouhputFlag;
	}

	public List<PerformanceLifeTimeRatio> retriveLifeTimeRatioAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveLifeTimeRatioAlgo4() Start");
		List<PerformanceLifeTimeRatio> perfLifeTimeRatioList = null;
		try {
			perfLifeTimeRatioList = queryForLifeTimePerf(RETRIVE_LIFETIME_ITERATION_ALGO4_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveLifeTimeRatioAlgo4() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveLifeTimeRatioAlgo4() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveLifeTimeRatioAlgo4() End");
		return perfLifeTimeRatioList;
	}

	public List<PerformanceResidualEnergy> retriveResidualEnergyAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveResidualEnergyAlgo4() Start");
		List<PerformanceResidualEnergy> perfEnergyList = null;
		try {
			perfEnergyList = queryForResidualEnergyPerf(RETRIVE_RESIDUALENERGY_ITERATION_ALGO4_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveResidualEnergyAlgo3() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveResidualEnergyAlgo4() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveResidualEnergyAlgo4() End");
		return perfEnergyList;
	}

	public List<PerformanceRoutingOverhead> retriveRoutingOverheadAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoutingOverheadAlgo4() Start");
		List<PerformanceRoutingOverhead> perfROList = null;
		try {
			perfROList = queryForROPerf(RETRIVE_ROUTINGOVERHEAD_ITERATION_ALGO4_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoutingOverheadAlgo4() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveRoutingOverheadAlgo4() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveRoutingOverheadAlgo4() End");
		return perfROList;
	}

	public List<PerformanceThroughput> retriveThroughputAlgo4() {
		List<PerformanceThroughput> perfThroughputList = null;
		try {
			perfThroughputList = queryForThroughputPerf(RETRIVE_THROUGHPUT_ITERATION_ALGO4_QUERY);

		} catch (DataAccessException dae) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveThroughputAlgo4() Exception" + dae.getMessage());
		} catch (Exception e) {
			System.out.println(
					"Class--->PerformanceDAOImpl:Method-->retriveThroughputAlgo4() Exception" + e.getMessage());
		}
		System.out.println("Class--->PerformanceDAOImpl:Method-->retriveThroughputAlgo4() End");
		return perfThroughputList;
	}
}
