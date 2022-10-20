package com.routingtopology.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.model.PerformanceResidualEnergy;
import com.routingtopology.dao.impl.PerformanceDAOImpl;
import com.routingtopology.service.inter.PerformanceServiceIF;
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


@Service
public class PerformanceServiceImpl implements PerformanceServiceIF {

	@Autowired
	private PerformanceDAOImpl performanceDao;

	@Override
	public boolean insertEnergyAlgo1(double energy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertEnergyAlgo1()");
		boolean insertionEnergyFlag = false;
		try {
			insertionEnergyFlag = performanceDao.insertEnergyAlgo1(energy);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertionEnergyFlag;
	}

	@Override
	public boolean insertEnergyAlgo2(double energy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertEnergyAlgo1()");
		boolean insertionEnergyFlag = false;
		try {
			insertionEnergyFlag = performanceDao.insertEnergyAlgo2(energy);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertionEnergyFlag;
	}

	@Override
	public boolean insertNoOfHopsAlgo1(int noOfHops) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfHopsAlgo1()");
		boolean insertionNoOfHopsFlag = false;
		try {
			if (noOfHops >= 0) {

				insertionNoOfHopsFlag = performanceDao.insertNoOfHopsAlgo1(noOfHops);
			}
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertionNoOfHopsFlag;
	}

	@Override
	public boolean insertNoOfHopsAlgo2(int noOfHops) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfHopsAlgo2()");
		boolean insertionNoOfHopsFlag = false;
		try {
			if (noOfHops >= 0) {
				insertionNoOfHopsFlag = performanceDao.insertNoOfHopsAlgo2(noOfHops);
			}
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertionNoOfHopsFlag;
	}

	@Override
	public boolean insertPowerAlgo1(double power) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfHopsAlgo2()");
		boolean insertionPower1 = false;
		try {
			if (power >= 0) {
				insertionPower1 = performanceDao.insertPowerAlgo1(power);
			}
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertionPower1;
	}

	@Override
	public boolean insertPowerAlgo2(double power) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertPowerAlgo2()");
		boolean insertionPower2 = false;
		try {
			if (power >= 0) {
				insertionPower2 = performanceDao.insertPowerAlgo2(power);
			}
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertionPower2;
	}

	@Override
	public boolean insertRoundTripTimeAlgo1(double timeTaken) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertPowerAlgo2()");
		boolean insertionPower2 = false;
		try {
			if (timeTaken >= 0) {
				insertionPower2 = performanceDao.insertRoundTripTimeAlgo1(timeTaken);
			}
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return insertionPower2;
	}

	@Override
	public boolean insertRoundTripTimeAlgo2(double timeTaken) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoundTripTimeAlgo2()");
		boolean insertRTT = false;
		try {
			if (timeTaken >= 0) {
				insertRTT = performanceDao.insertRoundTripTimeAlgo2(timeTaken);
			}
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return insertRTT;
	}

	@Override
	public List<PerformanceEnergy> retriveEnergyAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoundTripTimeAlgo2()");
		List<PerformanceEnergy> performanceEnergy = null;
		try {
			performanceEnergy = performanceDao.retriveEnergyAlgo1();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return performanceEnergy;
	}

	@Override
	public List<PerformanceEnergy> retriveEnergyAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveEnergyAlgo2()");
		List<PerformanceEnergy> performanceEnergy = null;
		try {
			performanceEnergy = performanceDao.retriveEnergyAlgo2();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return performanceEnergy;
	}

	@Override
	public List<PerformanceHops> retriveNoOfHopsAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveNoOfHopsAlgo1()");
		List<PerformanceHops> performanceHops = null;
		try {
			performanceHops = performanceDao.retriveNoOfHopsAlgo1();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return performanceHops;
	}

	@Override
	public List<PerformanceHops> retriveNoOfHopsAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveNoOfHopsAlgo2()");
		List<PerformanceHops> performanceHops = null;
		try {
			performanceHops = performanceDao.retriveNoOfHopsAlgo2();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return performanceHops;
	}

	@Override
	public List<PerformancePower> retrivePowerAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retrivePowerAlgo1()");
		List<PerformancePower> performanceHops = null;
		try {
			performanceHops = performanceDao.retrivePowerAlgo1();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return performanceHops;
	}

	@Override
	public List<PerformancePower> retrivePowerAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retrivePowerAlgo2()");
		List<PerformancePower> performancePower = null;
		try {
			performancePower = performanceDao.retrivePowerAlgo2();
		} catch (Exception dae) {
			System.out.println("Exception during Retrival of Power " + dae.getMessage());
		}
		return performancePower;
	}

	@Override
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveRoundTripTimeAlgo1()");
		List<PerformanceTimeTaken> timeTaken = null;
		try {
			timeTaken = performanceDao.retriveRoundTripTimeAlgo1();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return timeTaken;
	}

	@Override
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveRoundTripTimeAlgo2()");
		List<PerformanceTimeTaken> timeTaken = null;
		try {
			timeTaken = performanceDao.retriveRoundTripTimeAlgo2();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return timeTaken;
	}

	@Override
	public boolean insertTrustAlgo1(double trustLevel) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertTrustAlgo1()");
		boolean insertionTrustFlag = false;
		try {
			if (trustLevel >= 0 || trustLevel >= -4) {
				insertionTrustFlag = performanceDao.insertTrustAlgo1(trustLevel);
			}
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertionTrustFlag;
	}

	@Override
	public boolean insertTrustAlgo2(double trustLevel) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertTrustAlgo2()");
		boolean insertionTrustFlag = false;
		try {
			if (trustLevel >= 0 & trustLevel >= -4) {
				insertionTrustFlag = performanceDao.insertTrustAlgo2(trustLevel);
			}
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertionTrustFlag;
	}

	@Override
	public List<PerformanceTrust> retriveTrustlAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveTrustlAlgo1()");
		List<PerformanceTrust> trustList = null;
		try {
			trustList = performanceDao.retriveTrustlAlgo1();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return trustList;
	}

	@Override
	public List<PerformanceTrust> retriveTrustlAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveTrustlAlgo2()");
		List<PerformanceTrust> trustList = null;
		try {
			trustList = performanceDao.retriveTrustlAlgo2();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return trustList;
	}

	@Override
	public boolean insertNoOfHopsAlgo3(int noOfHops) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfHopsAlgo3()");
		boolean insertionNoOfHopsFlag = false;
		try {
			if (noOfHops >= 0) {
				insertionNoOfHopsFlag = performanceDao.insertNoOfHopsAlgo3(noOfHops);
			}
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Number of Hops For Algorithm 3" + dae.getMessage());
		}

		return insertionNoOfHopsFlag;
	}

	@Override
	public boolean insertNoOfHopsAlgo4(int noOfHops) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfHopsAlgo4()");
		boolean insertionNoOfHopsFlag = false;
		try {
			if (noOfHops >= 0) {
				insertionNoOfHopsFlag = performanceDao.insertNoOfHopsAlgo4(noOfHops);
			}
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Number of Hops For Algorithm 4" + dae.getMessage());
		}

		return insertionNoOfHopsFlag;
	}

	@Override
	public boolean insertNoOfHopsAlgo5(int noOfHops) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertNoOfHopsAlgo5()");
		boolean insertionNoOfHopsFlag = false;
		try {
			if (noOfHops >= 0) {
				insertionNoOfHopsFlag = performanceDao.insertNoOfHopsAlgo5(noOfHops);
			}
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Number of Hops For Algorithm 5" + dae.getMessage());
		}

		return insertionNoOfHopsFlag;
	}

	@Override
	public List<PerformanceHops> retriveNoOfHopsAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveNoOfHopsAlgo3()");
		List<PerformanceHops> performanceHops = null;
		try {
			performanceHops = performanceDao.retriveNoOfHopsAlgo3();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of Number of Hops for Algorithm 3" + dae.getMessage());
		}
		return performanceHops;
	}

	@Override
	public List<PerformanceHops> retriveNoOfHopsAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveNoOfHopsAlgo4()");
		List<PerformanceHops> performanceHops = null;
		try {
			performanceHops = performanceDao.retriveNoOfHopsAlgo4();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of Number of Hops for Algorithm 4" + dae.getMessage());
		}
		return performanceHops;
	}

	@Override
	public List<PerformanceHops> retriveNoOfHopsAlgo5() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveNoOfHopsAlgo5()");
		List<PerformanceHops> performanceHops = null;
		try {
			performanceHops = performanceDao.retriveNoOfHopsAlgo5();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of Number of Hops for Algorithm 5" + dae.getMessage());
		}
		return performanceHops;
	}

	@Override
	public boolean insertRoundTripTimeAlgo3(double timeTaken) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoundTripTimeAlgo3()");
		boolean insertRTT = false;
		try {
			if (timeTaken >= 0) {
				insertRTT = performanceDao.insertRoundTripTimeAlgo3(timeTaken);
			}
		} catch (Exception dae) {
			System.out.println("Exception during insertion of Round Trip Time For Algorithm3" + dae.getMessage());
		}
		return insertRTT;
	}

	@Override
	public boolean insertRoundTripTimeAlgo4(double timeTaken) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoundTripTimeAlgo4()");
		boolean insertRTT = false;
		try {
			if (timeTaken >= 0) {
				insertRTT = performanceDao.insertRoundTripTimeAlgo4(timeTaken);
			}
		} catch (Exception dae) {
			System.out.println("Exception during insertion of Round Trip Time For Algorithm 4 " + dae.getMessage());
		}
		return insertRTT;
	}

	@Override
	public boolean insertRoundTripTimeAlgo5(double timeTaken) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoundTripTimeAlgo5()");
		boolean insertRTT = false;
		try {
			if (timeTaken >= 0) {
				insertRTT = performanceDao.insertRoundTripTimeAlgo5(timeTaken);
			}
		} catch (Exception dae) {
			System.out.println("Exception during insertion of Round Trip Time For Algorithm 5 " + dae.getMessage());
		}
		return insertRTT;
	}

	@Override
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveRoundTripTimeAlgo3()");
		List<PerformanceTimeTaken> timeTaken = null;
		try {
			timeTaken = performanceDao.retriveRoundTripTimeAlgo3();
		} catch (Exception dae) {
			System.out.println("Exception during Retrival of Round Trip Time For Algorithm3" + dae.getMessage());
		}
		return timeTaken;
	}

	@Override
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveRoundTripTimeAlgo4()");
		List<PerformanceTimeTaken> timeTaken = null;
		try {
			timeTaken = performanceDao.retriveRoundTripTimeAlgo4();
		} catch (Exception dae) {
			System.out.println("Exception during Retrival of Round Trip Time For Algorithm 4" + dae.getMessage());
		}
		return timeTaken;
	}

	@Override
	public List<PerformanceTimeTaken> retriveRoundTripTimeAlgo5() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveRoundTripTimeAlgo5()");
		List<PerformanceTimeTaken> timeTaken = null;
		try {
			timeTaken = performanceDao.retriveRoundTripTimeAlgo5();
		} catch (Exception dae) {
			System.out.println("Exception during Retrival of Round Trip Time For Algorithm 5" + dae.getMessage());
		}
		return timeTaken;
	}

	@Override
	public boolean insertPowerAlgo3(double power) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertPowerAlgo3()");
		boolean insertionPower3 = false;
		try {
			if (power >= 0) {
				insertionPower3 = performanceDao.insertPowerAlgo3(power);
			}
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Power For Algorithm3" + dae.getMessage());
		}

		return insertionPower3;
	}

	@Override
	public boolean insertPowerAlgo4(double power) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertPowerAlgo4()");
		boolean insertionPower4 = false;
		try {
			if (power >= 0) {
				insertionPower4 = performanceDao.insertPowerAlgo4(power);
			}
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Power For Algorithm 4" + dae.getMessage());
		}

		return insertionPower4;
	}

	@Override
	public boolean insertPowerAlgo5(double power) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertPowerAlgo5()");
		boolean insertionPower5 = false;
		try {
			if (power >= 0) {
				insertionPower5 = performanceDao.insertPowerAlgo5(power);
			}
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Power For Algorithm 5" + dae.getMessage());
		}

		return insertionPower5;
	}

	@Override
	public List<PerformancePower> retrivePowerAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retrivePowerAlgo3()");
		List<PerformancePower> performancePower = null;
		try {
			performancePower = performanceDao.retrivePowerAlgo3();
		} catch (Exception dae) {
			System.out.println("Exception during Retrival of Power for Algorithm3 " + dae.getMessage());
		}
		return performancePower;
	}

	@Override
	public List<PerformancePower> retrivePowerAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retrivePowerAlgo4()");
		List<PerformancePower> performancePower = null;
		try {
			performancePower = performanceDao.retrivePowerAlgo4();
		} catch (Exception dae) {
			System.out.println("Exception during Retrival of Power for Algorithm 4 " + dae.getMessage());
		}
		return performancePower;
	}

	@Override
	public List<PerformancePower> retrivePowerAlgo5() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retrivePowerAlgo5()");
		List<PerformancePower> performancePower = null;
		try {
			performancePower = performanceDao.retrivePowerAlgo5();
		} catch (Exception dae) {
			System.out.println("Exception during Retrival of Power for Algorithm 5 " + dae.getMessage());
		}
		return performancePower;
	}

	@Override
	public boolean insertEnergyAlgo3(double energy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertEnergyAlgo3()");
		boolean insertionEnergyFlag = false;
		try {
			insertionEnergyFlag = performanceDao.insertEnergyAlgo3(energy);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Energy For Algorithm 3" + dae.getMessage());
		}

		return insertionEnergyFlag;
	}

	@Override
	public boolean insertEnergyAlgo4(double energy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertEnergyAlgo4()");
		boolean insertionEnergyFlag = false;
		try {
			insertionEnergyFlag = performanceDao.insertEnergyAlgo4(energy);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Energy For Algorithm 4" + dae.getMessage());
		}

		return insertionEnergyFlag;
	}

	@Override
	public boolean insertEnergyAlgo5(double energy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertEnergyAlgo5()");
		boolean insertionEnergyFlag = false;
		try {
			insertionEnergyFlag = performanceDao.insertEnergyAlgo5(energy);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Energy For Algorithm 5" + dae.getMessage());
		}

		return insertionEnergyFlag;
	}

	@Override
	public List<PerformanceEnergy> retriveEnergyAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveEnergyAlgo2()");
		List<PerformanceEnergy> performanceEnergy = null;
		try {
			performanceEnergy = performanceDao.retriveEnergyAlgo3();
		} catch (Exception dae) {
			System.out.println("Exception during Retrival of Energy For Algorithm3" + dae.getMessage());
		}
		return performanceEnergy;
	}

	@Override
	public List<PerformanceEnergy> retriveEnergyAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveEnergyAlgo4()");
		List<PerformanceEnergy> performanceEnergy = null;
		try {
			performanceEnergy = performanceDao.retriveEnergyAlgo4();
		} catch (Exception dae) {
			System.out.println("Exception during Retrival of Energy For Algorithm 4" + dae.getMessage());
		}
		return performanceEnergy;
	}

	@Override
	public List<PerformanceEnergy> retriveEnergyAlgo5() {
		System.out.println("Class--->PerformanceServiceImpl:Method--->retriveEnergyAlgo5()");
		List<PerformanceEnergy> performanceEnergy = null;
		try {
			performanceEnergy = performanceDao.retriveEnergyAlgo5();
		} catch (Exception dae) {
			System.out.println("Exception during Retrival of Energy For Algorithm 5" + dae.getMessage());
		}
		return performanceEnergy;
	}

	@Override
	public boolean insertNoOfDeadNodesAlgo1(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertNoOfDeadNodesAlgo1()");
		boolean insertionNoOfDeadNodesFlag = false;
		try {
			insertionNoOfDeadNodesFlag = performanceDao.insertNoOfDeadNodesAlgo1(noOfDeadNodes);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion No of Dead Nodes For Algorithm1" + dae.getMessage());
		}

		return insertionNoOfDeadNodesFlag;
	}

	@Override
	public boolean insertNoOfDeadNodesAlgo2(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertNoOfDeadNodesAlgo2()");
		boolean insertionNoOfDeadNodesFlag = false;
		try {
			insertionNoOfDeadNodesFlag = performanceDao.insertNoOfDeadNodesAlgo2(noOfDeadNodes);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion No of Dead Nodes For Algorithm2" + dae.getMessage());
		}

		return insertionNoOfDeadNodesFlag;
	}

	@Override
	public boolean insertNoOfDeadNodesAlgo3(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertNoOfDeadNodesAlgo3()");
		boolean insertionNoOfDeadNodesFlag = false;
		try {
			insertionNoOfDeadNodesFlag = performanceDao.insertNoOfDeadNodesAlgo3(noOfDeadNodes);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion No of Dead Nodes For Algorithm 3" + dae.getMessage());
		}

		return insertionNoOfDeadNodesFlag;
	}

	@Override
	public boolean insertNoOfDeadNodesAlgo4(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertNoOfDeadNodesAlgo4()");
		boolean insertionNoOfDeadNodesFlag = false;
		try {
			insertionNoOfDeadNodesFlag = performanceDao.insertNoOfDeadNodesAlgo4(noOfDeadNodes);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion No of Dead Nodes For Algorithm 4" + dae.getMessage());
		}

		return insertionNoOfDeadNodesFlag;
	}

	@Override
	public boolean insertNoOfDeadNodesAlgo5(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertNoOfDeadNodesAlgo5()");
		boolean insertionNoOfDeadNodesFlag = false;
		try {
			insertionNoOfDeadNodesFlag = performanceDao.insertNoOfDeadNodesAlgo5(noOfDeadNodes);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion No of Dead Nodes For Algorithm 5" + dae.getMessage());
		}

		return insertionNoOfDeadNodesFlag;
	}

	@Override
	public boolean insertNoOfDeadNodesAlgo6(int noOfDeadNodes) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertNoOfDeadNodesAlgo6()");
		boolean insertionNoOfDeadNodesFlag = false;
		try {
			insertionNoOfDeadNodesFlag = performanceDao.insertNoOfDeadNodesAlgo6(noOfDeadNodes);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion No of Dead Nodes For Algorithm 6" + dae.getMessage());
		}

		return insertionNoOfDeadNodesFlag;
	}

	@Override
	public boolean insertNoOfAliveNodesAlgo1(int noOfAliveNodes) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertNoOfAliveNodesAlgo1()");
		boolean insertionNoOfAliveNodesFlag = false;
		try {
			insertionNoOfAliveNodesFlag = performanceDao.insertNoOfAliveNodesAlgo1(noOfAliveNodes);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion No of Alive Nodes For Algorithm 1" + dae.getMessage());
		}

		return insertionNoOfAliveNodesFlag;
	}

	@Override
	public boolean insertNoOfAliveNodesAlgo2(int noOfAliveNodes) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertNoOfAliveNodesAlgo2()");
		boolean insertionNoOfAliveNodesFlag = false;
		try {
			insertionNoOfAliveNodesFlag = performanceDao.insertNoOfAliveNodesAlgo2(noOfAliveNodes);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion No of Alive Nodes For Algorithm 2" + dae.getMessage());
		}

		return insertionNoOfAliveNodesFlag;
	}

	@Override
	public boolean insertNoOfAliveNodesAlgo3(int noOfAliveNodes) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertNoOfAliveNodesAlgo3()");
		boolean insertionNoOfAliveNodesFlag = false;
		try {
			insertionNoOfAliveNodesFlag = performanceDao.insertNoOfAliveNodesAlgo3(noOfAliveNodes);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion No of Alive Nodes For Algorithm 3" + dae.getMessage());
		}

		return insertionNoOfAliveNodesFlag;
	}

	@Override
	public boolean insertNoOfAliveNodesAlgo4(int noOfAliveNodes) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertNoOfAliveNodesAlgo4()");
		boolean insertionNoOfAliveNodesFlag = false;
		try {
			insertionNoOfAliveNodesFlag = performanceDao.insertNoOfAliveNodesAlgo4(noOfAliveNodes);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion No of Alive Nodes For Algorithm 4" + dae.getMessage());
		}

		return insertionNoOfAliveNodesFlag;
	}

	@Override
	public boolean insertNoOfAliveNodesAlgo5(int noOfAliveNodes) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertNoOfAliveNodesAlgo5()");
		boolean insertionNoOfAliveNodesFlag = false;
		try {
			insertionNoOfAliveNodesFlag = performanceDao.insertNoOfAliveNodesAlgo5(noOfAliveNodes);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion No of Alive Nodes For Algorithm 5" + dae.getMessage());
		}

		return insertionNoOfAliveNodesFlag;
	}

	@Override
	public boolean insertNoOfAliveNodesAlgo6(int noOfAliveNodes) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertNoOfAliveNodesAlgo6()");
		boolean insertionNoOfAliveNodesFlag = false;
		try {
			insertionNoOfAliveNodesFlag = performanceDao.insertNoOfAliveNodesAlgo6(noOfAliveNodes);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion No of Alive Nodes For Algorithm 6" + dae.getMessage());
		}

		return insertionNoOfAliveNodesFlag;
	}

	@Override
	public boolean insertPacketLossForAlgo1(int packetLoss) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertPacketLossForAlgo1()");
		boolean insertPacketLossFlag = false;
		try {
			insertPacketLossFlag = performanceDao.insertPacketLossForAlgo1(packetLoss);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Packet Loss For Algorithm 1" + dae.getMessage());
		}

		return insertPacketLossFlag;
	}

	@Override
	public boolean insertPacketLossForAlgo2(int packetLoss) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertPacketLossForAlgo2()");
		boolean insertPacketLossFlag = false;
		try {
			insertPacketLossFlag = performanceDao.insertPacketLossForAlgo2(packetLoss);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Packet Loss For Algorithm 2" + dae.getMessage());
		}

		return insertPacketLossFlag;
	}

	@Override
	public boolean insertPacketLossForAlgo3(int packetLoss) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertPacketLossForAlgo3()");
		boolean insertPacketLossFlag = false;
		try {
			insertPacketLossFlag = performanceDao.insertPacketLossForAlgo3(packetLoss);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Packet Loss For Algorithm 3" + dae.getMessage());
		}

		return insertPacketLossFlag;
	}

	@Override
	public boolean insertPacketLossForAlgo4(int packetLoss) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertPacketLossForAlgo4()");
		boolean insertPacketLossFlag = false;
		try {
			insertPacketLossFlag = performanceDao.insertPacketLossForAlgo3(packetLoss);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Packet Loss For Algorithm 4" + dae.getMessage());
		}

		return insertPacketLossFlag;
	}

	@Override
	public boolean insertPacketLossForAlgo5(int packetLoss) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertPacketLossForAlgo5()");
		boolean insertPacketLossFlag = false;
		try {
			insertPacketLossFlag = performanceDao.insertPacketLossForAlgo5(packetLoss);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Packet Loss For Algorithm 5" + dae.getMessage());
		}

		return insertPacketLossFlag;
	}

	@Override
	public boolean insertPacketLossForAlgo6(int packetLoss) {
		System.out.println("Class--->PerformanceServiceImpl:Method--->insertPacketLossForAlgo6()");
		boolean insertPacketLossFlag = false;
		try {
			insertPacketLossFlag = performanceDao.insertPacketLossForAlgo6(packetLoss);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of Packet Loss For Algorithm 6" + dae.getMessage());
		}

		return insertPacketLossFlag;
	}

	@Override
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveAliveNodesForAlgo1()");
		List<PerformanceAliveNodes> performanceNoOfAliveNodes = null;
		try {
			performanceNoOfAliveNodes = performanceDao.retriveAliveNodesForAlgo1();
		} catch (Exception dae) {
			System.out.println(
					"Exception during Retrival of Number of Alive Nodes for the Algorithm 1" + dae.getMessage());
		}
		return performanceNoOfAliveNodes;
	}

	@Override
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveAliveNodesForAlgo2()");
		List<PerformanceAliveNodes> performanceNoOfAliveNodes = null;
		try {
			performanceNoOfAliveNodes = performanceDao.retriveAliveNodesForAlgo2();
		} catch (Exception dae) {
			System.out.println(
					"Exception during Retrival of Number of Alive Nodes for the Algorithm 2" + dae.getMessage());
		}
		return performanceNoOfAliveNodes;
	}

	@Override
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveAliveNodesForAlgo3()");
		List<PerformanceAliveNodes> performanceNoOfAliveNodes = null;
		try {
			performanceNoOfAliveNodes = performanceDao.retriveAliveNodesForAlgo3();
		} catch (Exception dae) {
			System.out.println(
					"Exception during Retrival of Number of Alive Nodes for the Algorithm 3" + dae.getMessage());
		}
		return performanceNoOfAliveNodes;
	}

	@Override
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo5() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveAliveNodesForAlgo5()");
		List<PerformanceAliveNodes> performanceNoOfAliveNodes = null;
		try {
			performanceNoOfAliveNodes = performanceDao.retriveAliveNodesForAlgo5();
		} catch (Exception dae) {
			System.out.println(
					"Exception during Retrival of Number of Alive Nodes for the Algorithm 5" + dae.getMessage());
		}
		return performanceNoOfAliveNodes;
	}

	@Override
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveAliveNodesForAlgo4()");
		List<PerformanceAliveNodes> performanceNoOfAliveNodes = null;
		try {
			performanceNoOfAliveNodes = performanceDao.retriveAliveNodesForAlgo4();
		} catch (Exception dae) {
			System.out.println(
					"Exception during Retrival of Number of Alive Nodes for the Algorithm 4" + dae.getMessage());
		}
		return performanceNoOfAliveNodes;
	}

	@Override
	public List<PerformanceAliveNodes> retriveAliveNodesForAlgo6() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveAliveNodesForAlgo6()");
		List<PerformanceAliveNodes> performanceNoOfAliveNodes = null;
		try {
			performanceNoOfAliveNodes = performanceDao.retriveAliveNodesForAlgo6();
		} catch (Exception dae) {
			System.out.println(
					"Exception during Retrival of Number of Alive Nodes for the Algorithm 6" + dae.getMessage());
		}
		return performanceNoOfAliveNodes;
	}

	@Override
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveDeadNodesForAlgo1()");
		List<PerformanceDeadNodes> performanceNoOfDeadNodes = null;
		try {
			performanceNoOfDeadNodes = performanceDao.retriveDeadNodesForAlgo1();
		} catch (Exception dae) {
			System.out.println(
					"Exception during Retrival of Number of Dead Nodes for the Algorithm 1" + dae.getMessage());
		}
		return performanceNoOfDeadNodes;
	}

	@Override
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveDeadNodesForAlgo2()");
		List<PerformanceDeadNodes> performanceNoOfDeadNodes = null;
		try {
			performanceNoOfDeadNodes = performanceDao.retriveDeadNodesForAlgo2();
		} catch (Exception dae) {
			System.out.println(
					"Exception during Retrival of Number of Dead Nodes for the Algorithm 2" + dae.getMessage());
		}
		return performanceNoOfDeadNodes;
	}

	@Override
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveDeadNodesForAlgo3()");
		List<PerformanceDeadNodes> performanceNoOfDeadNodes = null;
		try {
			performanceNoOfDeadNodes = performanceDao.retriveDeadNodesForAlgo3();
		} catch (Exception dae) {
			System.out.println(
					"Exception during Retrival of Number of Dead Nodes for the Algorithm 3" + dae.getMessage());
		}
		return performanceNoOfDeadNodes;
	}

	@Override
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveDeadNodesForAlgo4()");
		List<PerformanceDeadNodes> performanceNoOfDeadNodes = null;
		try {
			performanceNoOfDeadNodes = performanceDao.retriveDeadNodesForAlgo4();
		} catch (Exception dae) {
			System.out.println(
					"Exception during Retrival of Number of Dead Nodes for the Algorithm 4" + dae.getMessage());
		}
		return performanceNoOfDeadNodes;
	}

	@Override
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo5() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveDeadNodesForAlgo5()");
		List<PerformanceDeadNodes> performanceNoOfDeadNodes = null;
		try {
			performanceNoOfDeadNodes = performanceDao.retriveDeadNodesForAlgo5();
		} catch (Exception dae) {
			System.out.println(
					"Exception during Retrival of Number of Dead Nodes for the Algorithm 5" + dae.getMessage());
		}
		return performanceNoOfDeadNodes;
	}

	@Override
	public List<PerformanceDeadNodes> retriveDeadNodesForAlgo6() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveDeadNodesForAlgo6()");
		List<PerformanceDeadNodes> performanceNoOfDeadNodes = null;
		try {
			performanceNoOfDeadNodes = performanceDao.retriveDeadNodesForAlgo6();
		} catch (Exception dae) {
			System.out.println(
					"Exception during Retrival of Number of Dead Nodes for the Algorithm 6" + dae.getMessage());
		}
		return performanceNoOfDeadNodes;
	}

	@Override
	public List<PerformancePacketLoss> retrivePacketLossForAlgo1() {
		System.out.println("Class--->PerformanceServiceImpl:Method--->retrivePacketLossForAlgo1()");
		List<PerformancePacketLoss> packetLossMeasure = null;
		try {
			packetLossMeasure = performanceDao.retrivePacketLossForAlgo1();
		} catch (Exception dae) {
			System.out.println("Exception during Retrival of Packet Loss for the Algorithm 1" + dae.getMessage());
		}
		return packetLossMeasure;
	}

	@Override
	public List<PerformancePacketLoss> retrivePacketLossForAlgo2() {
		System.out.println("Class--->PerformanceServiceImpl:Method--->retrivePacketLossForAlgo2()");
		List<PerformancePacketLoss> packetLossMeasure = null;
		try {
			packetLossMeasure = performanceDao.retrivePacketLossForAlgo2();
		} catch (Exception dae) {
			System.out.println("Exception during Retrival of Packet Loss for the Algorithm 2" + dae.getMessage());
		}
		return packetLossMeasure;
	}

	@Override
	public List<PerformancePacketLoss> retrivePacketLossForAlgo3() {
		System.out.println("Class--->PerformanceServiceImpl:Method--->retrivePacketLossForAlgo2()");
		List<PerformancePacketLoss> packetLossMeasure = null;
		try {
			packetLossMeasure = performanceDao.retrivePacketLossForAlgo2();
		} catch (Exception dae) {
			System.out.println("Exception during Retrival of Packet Loss for the Algorithm 2" + dae.getMessage());
		}
		return packetLossMeasure;
	}

	@Override
	public List<PerformancePacketLoss> retrivePacketLossForAlgo4() {
		System.out.println("Class--->PerformanceServiceImpl:Method--->retrivePacketLossForAlgo4()");
		List<PerformancePacketLoss> packetLossMeasure = null;
		try {
			packetLossMeasure = performanceDao.retrivePacketLossForAlgo4();
		} catch (Exception dae) {
			System.out.println("Exception during Retrival of Packet Loss for the Algorithm 4" + dae.getMessage());
		}
		return packetLossMeasure;
	}

	@Override
	public List<PerformancePacketLoss> retrivePacketLossForAlgo5() {
		System.out.println("Class--->PerformanceServiceImpl:Method--->retrivePacketLossForAlgo5()");
		List<PerformancePacketLoss> packetLossMeasure = null;
		try {
			packetLossMeasure = performanceDao.retrivePacketLossForAlgo5();
		} catch (Exception dae) {
			System.out.println("Exception during Retrival of Packet Loss for the Algorithm 5" + dae.getMessage());
		}
		return packetLossMeasure;
	}

	@Override
	public List<PerformancePacketLoss> retrivePacketLossForAlgo6() {
		System.out.println("Class--->PerformanceServiceImpl:Method--->retrivePacketLossForAlgo6()");
		List<PerformancePacketLoss> packetLossMeasure = null;
		try {
			packetLossMeasure = performanceDao.retrivePacketLossForAlgo6();
		} catch (Exception dae) {
			System.out.println("Exception during Retrival of Packet Loss for the Algorithm 5" + dae.getMessage());
		}
		return packetLossMeasure;
	}

	@Override
	public boolean insertRoutingOverheadAlgo1(double routingOverhead) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoutingOverheadAlgo1()");
		boolean insertROFlag = false;
		try {
			insertROFlag = performanceDao.insertRoutingOverheadAlgo1(routingOverhead);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertROFlag;
	}

	@Override
	public boolean insertRoutingOverheadAlgo2(double routingOverhead) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoutingOverheadAlgo2()");
		boolean insertROFlag = false;
		try {
			insertROFlag = performanceDao.insertRoutingOverheadAlgo2(routingOverhead);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertROFlag;
	}

	@Override
	public boolean insertRoutingOverheadAlgo3(double routingOverhead) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertRoutingOverheadAlgo2()");
		boolean insertROFlag = false;
		try {
			insertROFlag = performanceDao.insertRoutingOverheadAlgo3(routingOverhead);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertROFlag;
	}

	@Override
	public List<PerformanceRoutingOverhead> retriveRoutingOverheadAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveRoutingOverheadAlgo1()");
		List<PerformanceRoutingOverhead> perfROList = null;
		try {
			perfROList = performanceDao.retriveRoutingOverheadAlgo1();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return perfROList;
	}

	@Override
	public List<PerformanceRoutingOverhead> retriveRoutingOverheadAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveRoutingOverheadAlgo2()");
		List<PerformanceRoutingOverhead> perfROList = null;
		try {
			perfROList = performanceDao.retriveRoutingOverheadAlgo2();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return perfROList;
	}

	@Override
	public List<PerformanceRoutingOverhead> retriveRoutingOverheadAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveRoutingOverheadAlgo3()");
		List<PerformanceRoutingOverhead> perfROList = null;
		try {
			perfROList = performanceDao.retriveRoutingOverheadAlgo3();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return perfROList;
	}

	@Override
	public boolean insertLifeTimeAlgo1(double lifeTimeRatio) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertLifeTimeAlgo1()");
		boolean insertLifeTimeRatio = false;
		try {
			insertLifeTimeRatio = performanceDao.insertLifeTimeAlgo1(lifeTimeRatio);
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertLifeTimeRatio;
	}

	@Override
	public boolean insertLifeTimeAlgo2(double lifeTimeRatio) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertLifeTimeAlgo2()");
		boolean insertLifeTimeRatio = false;
		try {
			insertLifeTimeRatio = performanceDao.insertLifeTimeAlgo2(lifeTimeRatio);
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertLifeTimeRatio;

	}

	@Override
	public boolean insertLifeTimeAlgo3(double lifeTimeRatio) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertLifeTimeAlgo3()");
		boolean insertLifeTimeRatio = false;
		try {
			insertLifeTimeRatio = performanceDao.insertLifeTimeAlgo3(lifeTimeRatio);
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertLifeTimeRatio;
	}

	@Override
	public List<PerformanceLifeTimeRatio> retriveLifeTimeRatioAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveLifeTimeRatioAlgo1()");
		List<PerformanceLifeTimeRatio> lifeTimeRatioList = null;
		try {
			lifeTimeRatioList = performanceDao.retriveLifeTimeRatioAlgo1();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return lifeTimeRatioList;
	}

	@Override
	public List<PerformanceLifeTimeRatio> retriveLifeTimeRatioAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveLifeTimeRatioAlgo2()");
		List<PerformanceLifeTimeRatio> lifeTimeRatioList = null;
		try {
			lifeTimeRatioList = performanceDao.retriveLifeTimeRatioAlgo2();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return lifeTimeRatioList;
	}

	@Override
	public List<PerformanceLifeTimeRatio> retriveLifeTimeRatioAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveLifeTimeRatioAlgo3()");
		List<PerformanceLifeTimeRatio> lifeTimeRatioList = null;
		try {
			lifeTimeRatioList = performanceDao.retriveLifeTimeRatioAlgo3();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return lifeTimeRatioList;
	}

	@Override
	public boolean insertThroughputAlgo1(double throughput) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertThroughputAlgo1()");
		boolean insertThroughputFlag = false;
		try {
			insertThroughputFlag = performanceDao.insertThroughputAlgo1(throughput);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertThroughputFlag;
	}

	@Override
	public boolean insertThroughputAlgo2(double throughput) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertThroughputAlgo2()");
		boolean insertThroughputFlag = false;
		try {
			insertThroughputFlag = performanceDao.insertThroughputAlgo2(throughput);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertThroughputFlag;
	}

	@Override
	public boolean insertThroughputAlgo3(double throughput) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertThroughputAlgo3()");
		boolean insertThroughputFlag = false;
		try {
			insertThroughputFlag = performanceDao.insertThroughputAlgo3(throughput);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertThroughputFlag;
	}

	@Override
	public List<PerformanceThroughput> retriveThroughputAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveThroughputAlgo1()");
		List<PerformanceThroughput> performanceThroughput = null;
		try {
			performanceThroughput = performanceDao.retriveThroughputAlgo1();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return performanceThroughput;
	}

	@Override
	public List<PerformanceThroughput> retriveThroughputAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveThroughputAlgo2()");
		List<PerformanceThroughput> performanceThroughput = null;
		try {
			performanceThroughput = performanceDao.retriveThroughputAlgo2();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return performanceThroughput;
	}

	@Override
	public List<PerformanceThroughput> retriveThroughputAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveThroughputAlgo3()");
		List<PerformanceThroughput> performanceThroughput = null;
		try {
			performanceThroughput = performanceDao.retriveThroughputAlgo3();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return performanceThroughput;
	}

	@Override
	public boolean insertResidualEnergyAlgo1(double residualEnergy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertResidualEnergyAlgo1()");
		boolean insertREFlag = false;
		try {
			insertREFlag = performanceDao.insertResidualEnergyAlgo1(residualEnergy);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertREFlag;
	}

	@Override
	public boolean insertResidualEnergyAlgo2(double residualEnergy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertResidualEnergyAlgo2()");
		boolean insertREFlag = false;
		try {
			insertREFlag = performanceDao.insertResidualEnergyAlgo2(residualEnergy);

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
			insertREFlag = performanceDao.insertResidualEnergyAlgo3(residualEnergy);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertREFlag;
	}

	@Override
	public List<PerformanceResidualEnergy> retriveResidualEnergyAlgo1() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveResidualEnergyAlgo1()");
		List<PerformanceResidualEnergy> perfResidualEnergyList = null;
		try {
			perfResidualEnergyList = performanceDao.retriveResidualEnergyAlgo1();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return perfResidualEnergyList;
	}

	@Override
	public List<PerformanceResidualEnergy> retriveResidualEnergyAlgo2() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveResidualEnergyAlgo2()");
		List<PerformanceResidualEnergy> perfResidualEnergyList = null;
		try {
			perfResidualEnergyList = performanceDao.retriveResidualEnergyAlgo2();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return perfResidualEnergyList;
	}

	@Override
	public List<PerformanceResidualEnergy> retriveResidualEnergyAlgo3() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveResidualEnergyAlgo3()");
		List<PerformanceResidualEnergy> perfResidualEnergyList = null;
		try {
			perfResidualEnergyList = performanceDao.retriveResidualEnergyAlgo3();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return perfResidualEnergyList;
	}

	@Override
	public boolean removeAllAlgorithmsData(String type) {

		boolean isAlgoIssue = false;
		try {

			if (type != null) {

				if (type.equals("TIMETAKEN")) {
					performanceDao.deleteTimeTaken1();
					performanceDao.deleteTimeTaken2();
					performanceDao.deleteTimeTaken3();
				} else if (type.equals("HOPS")) {
					performanceDao.deleteHopsAlgo1();
					performanceDao.deleteHopsAlgo2();
					performanceDao.deleteHopsAlgo3();
				} else if (type.equals("ENERGYCONSUMED")) {
					performanceDao.deleteEnergyConsumedAlgo1();
					performanceDao.deleteEnergyConsumedAlgo2();
					performanceDao.deleteEnergyConsumedAlgo3();
				} else if (type.equals("RESIDUALENERGY")) {
					performanceDao.deleteResidualEnergyAlgo1();
					performanceDao.deleteResidualEnergyAlgo2();
					performanceDao.deleteResidualEnergyAlgo3();
				} else if (type.equals("ALIVENODES")) {
					performanceDao.deleteAliveNodesAlgo1();
					performanceDao.deleteAliveNodesAlgo2();
					performanceDao.deleteAliveNodesAlgo3();
				} else if (type.equals("DEADNODES")) {
					performanceDao.deleteDeadNodesAlgo1();
					performanceDao.deleteDeadNodesAlgo2();
					performanceDao.deleteDeadNodesAlgo3();
				} else if (type.equals("LTR")) {
					performanceDao.deleteLTRAlgo1();
					performanceDao.deleteLTRAlgo2();
					performanceDao.deleteLTRAlgo3();
				} else if (type.equals("RO")) {
					performanceDao.deleteROAlgo1();
					performanceDao.deleteROAlgo2();
					performanceDao.deleteROAlgo3();
				} else if (type.equals("THROUGHPUT")) {
					performanceDao.deleteThroughputAlgo1();
					performanceDao.deleteThroughputAlgo2();
					performanceDao.deleteThroughputAlgo3();
				}
				isAlgoIssue = true;
			} else {
				isAlgoIssue = false;
			}

		} catch (Exception e) {
			System.out.println("Exception during removal of algorithm data" + e.getMessage());
			isAlgoIssue = false;
		}
		return isAlgoIssue;

	}

	public boolean insertLifeTimeAlgo4(double lifeTimeRatio) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertLifeTimeAlgo3()");
		boolean insertLifeTimeRatio = false;
		try {
			insertLifeTimeRatio = performanceDao.insertLifeTimeAlgo4(lifeTimeRatio);
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertLifeTimeRatio;

	}

	public boolean insertResidualEnergyAlgo4(Double residualEnergy) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertResidualEnergyAlgo4()");
		boolean insertREFlag = false;
		try {
			insertREFlag = performanceDao.insertResidualEnergyAlgo4(residualEnergy);
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
			insertROFlag = performanceDao.insertRoutingOverheadAlgo4(routingOverhead);
		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertROFlag;
		
	}

	public boolean insertThroughputAlgo4(Double throughput) {
		System.out.println("Class--->PerformanceDAOImpl:Method--->insertThroughputAlgo4()");
		boolean insertThroughputFlag = false;
		try {
			insertThroughputFlag = performanceDao.insertThroughputAlgo4(throughput);

		} catch (DataAccessException dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}

		return insertThroughputFlag;
		
	}

	public List<PerformanceLifeTimeRatio> retriveLifeTimeRatioAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveLifeTimeRatioAlgo3()");
		List<PerformanceLifeTimeRatio> lifeTimeRatioList = null;
		try {
			lifeTimeRatioList = performanceDao.retriveLifeTimeRatioAlgo4();
		} catch (Exception dae) {
			System.out.println("Exception during insertion of random topology" + dae.getMessage());
		}
		return lifeTimeRatioList;
	}

	public List<PerformanceResidualEnergy> retriveResidualEnergyAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveResidualEnergyAlgo4()");
		List<PerformanceResidualEnergy> perfResidualEnergyList = null;
		try {
			perfResidualEnergyList = performanceDao.retriveResidualEnergyAlgo4();
		} catch (Exception dae) {
			System.out.println("Exception during retriveResidualEnergyAlgo4" + dae.getMessage());
		}
		return perfResidualEnergyList;
	}

	public List<PerformanceRoutingOverhead> retriveRoutingOverheadAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveRoutingOverheadAlgo4()");
		List<PerformanceRoutingOverhead> perfROList = null;
		try {
			perfROList = performanceDao.retriveRoutingOverheadAlgo4();
		} catch (Exception dae) {
			System.out.println("Exception during retriveRoutingOverheadAlgo4" + dae.getMessage());
		}
		return perfROList;
	}

	public List<PerformanceThroughput> retriveThroughputAlgo4() {
		System.out.println("Class--->PerformanceDAOImpl:Method--->retriveThroughputAlgo4()");
		List<PerformanceThroughput> performanceThroughput = null;
		try {
			performanceThroughput = performanceDao.retriveThroughputAlgo4();
		} catch (Exception dae) {
			System.out.println("Exception during retriveThroughputAlgo4" + dae.getMessage());
		}
		return performanceThroughput;
	}

}
