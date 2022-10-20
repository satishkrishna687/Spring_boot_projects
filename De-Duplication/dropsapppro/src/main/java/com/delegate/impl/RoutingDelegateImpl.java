package com.delegate.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.routingtopology.value.TopologyCriteriaValue;
import com.algorithm.comparefacade.impl.OptimizedAndOtherAlgorithmsCompareFacadeImpl;
import com.delegate.inter.RoutingDelegateIF;
import com.dropsapppro.repository.BestRouteDetailsRepository;
import com.dropsapppro.repository.BestRouteReplicaDetailsRepository;
import com.dropsapppro.repository.CompareAlgoResultsRepository;
import com.dropsapppro.repository.FileChunkStorageRepository;
import com.dropsapppro.repository.FileEncStorageRepository;
import com.dropsapppro.repository.FileReplicaStorageRepository;
import com.dropsapppro.repository.FileStorageRepository;
import com.dropsapppro.repository.UserInfoRouteSessionRepository;
import com.dropsapppro.services.OptimizedEncryptionService;
import com.dropsapppro.storageobjects.BestRouteDetails;
import com.dropsapppro.storageobjects.BestRouteReplicaDetails;
import com.dropsapppro.storageobjects.FileChunckStorage;
import com.dropsapppro.storageobjects.FileEncStorage;
import com.dropsapppro.storageobjects.FileReplicaStorage;
import com.dropsapppro.storageobjects.FileStorage;
import com.dropsapppro.storageobjects.UserInfoRouteSession;
import com.model.CompareOptimizedInfo;
import com.model.Buffer;
import com.model.CompareEnergy;
import com.model.CompareHops;
import com.model.CompareLifeTimeRatio;
import com.model.CompareNoOfAliveNodes;
import com.model.CompareNoOfDeadNodes;
import com.model.ComparePower;
import com.model.CompareResidualEnergy;
import com.model.CompareRoutingOverhead;
import com.model.CompareThroughput;
import com.model.CompareTime;
import com.model.EEDRModel;
import com.model.Energy;
import com.model.FaultNodeTopologyView;
import com.model.IPAdressVO;
import com.model.NetworkCost;
import com.model.NodeId;
import com.model.PerformanceResidualEnergy;
import com.model.Power;
import com.model.StatusInfo;
import com.model.messages.Messages;
import com.routingtopology.constants.ParametersTypeIF;
import com.routingtopology.constants.TopologyConstantsIF;
import com.routingtopology.constants.TopologyTypesIF;
import com.routingtopology.dao.impl.IPAddressMaintainenceDAOImpl;
import com.routingtopology.dao.impl.SettingsDAOImpl;
import com.routingtopology.service.impl.ParametersServiceImpl;
import com.routingtopology.service.impl.PerformanceServiceImpl;
import com.routingtopology.service.impl.RoutingTableServiceImpl;
import com.routingtopology.service.impl.TopologyRoutingServiceImpl;
import com.routingtopology.value.ClosenessCentralityCriteria;
import com.routingtopology.value.ECentralityCriteria;
import com.routingtopology.value.BetweenCentralityCriteria;
import com.routingtopology.value.OptimizedCriteria;
import com.routingtopology.value.OptimizedRouteInfo;
import com.routingtopology.value.NormalRoutingTable;
import com.routingtopology.value.ParameterValue;
import com.routingtopology.value.PerformanceAliveNodes;
import com.routingtopology.value.PerformanceDeadNodes;
import com.routingtopology.value.PerformanceEnergy;
import com.routingtopology.value.PerformanceHops;
import com.routingtopology.value.PerformanceLifeTimeRatio;
import com.routingtopology.value.PerformancePower;
import com.routingtopology.value.PerformanceRoutingOverhead;
import com.routingtopology.value.PerformanceThroughput;
import com.routingtopology.value.PerformanceTimeTaken;
import com.routingtopology.value.RouteInfo;
import com.routingtopology.value.TopologyInfoValue;
import com.routingtopology.value.TopologyTypeVO;

@Service
@PropertySource("classpath:custom.properties")
public class RoutingDelegateImpl implements RoutingDelegateIF {

	private static final long MEGABYTE = 1024L * 1024L;

	public static long bytesToMegabytes(long bytes) {
		return bytes / MEGABYTE;
	}

	@Autowired
	protected PerformanceServiceImpl performanceServiceIF;

	private static final String CLASS_NAME = "RoutingDelegateImpl";

	private static final String CLASS_COLON = "CLASS:";

	private static final String ARROW = "--->";

	private static final String METHOD = "METHOD";

	private static final String START = "START";

	private static final String END = "END";

	private static final String METHOD_NAME = "Method:";

	@Autowired
	protected TopologyRoutingServiceImpl topologyRoutingServiceIF;

	@Autowired
	protected RoutingTableServiceImpl routingTableServiceIF;

	@Autowired
	protected ParametersServiceImpl parametersServiceIF;

	@Autowired
	protected OptimizedAndOtherAlgorithmsCompareFacadeImpl eedrAodvDsdvCompareFacade;

	@Autowired
	protected SettingsDAOImpl settingsDao;

	@Autowired
	protected IPAddressMaintainenceDAOImpl ipAddressMaintainenceDao;

	@Autowired
	protected UserInfoRouteSessionRepository userInfoRouteSessionRepository;

	@Autowired
	protected BestRouteDetailsRepository bestRouteDetailsRepository;

	@Autowired
	protected FileStorageRepository fileStorageRepository;

	@Autowired
	protected BestRouteReplicaDetailsRepository bestRouteReplicaDetailsRepository;

	@Autowired
	protected FileChunkStorageRepository fileChunkStorageRepository;

	@Autowired
	protected FileReplicaStorageRepository fileReplicaStorageRepository;

	@Autowired
	protected FileEncStorageRepository fileEncStorageRepository;

	@Autowired
	protected CompareAlgoResultsRepository compareAlgoResultsRepository;

	@Autowired
	protected Environment environment;

	@Override
	public boolean createFaultNodeTopologyAndStore(TopologyCriteriaValue criteria, String topologyType) {
		System.out.println(
				CLASS_COLON + CLASS_NAME + ARROW + METHOD_NAME + "createFaultNodeTopologyAndStore" + ARROW + START);
		boolean generationFlag = false;

		try {
			if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
				generationFlag = topologyRoutingServiceIF.generateLinearTopologyAndStore(criteria);
			} else if (topologyType.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {
				generationFlag = topologyRoutingServiceIF.generateRandomTopologyAndStore(criteria);
			}

		} catch (Exception e) {
			System.out.println("Exception:-->" + e.getMessage());
			generationFlag = false;
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "createFaultNodeTopologyAndStore" + ARROW + END);
		return generationFlag;
	}

	@Override
	public List<FaultNodeTopologyView> retriveFaultNodeTopology(String topologyType) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveFaultNodeTopology" + ARROW + START);

		List<FaultNodeTopologyView> peebrTopologyViewList = null;

		try {
			List<TopologyInfoValue> topologyInfoValue = null;
			if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {

				topologyInfoValue = topologyRoutingServiceIF.retriveLinearTopologyForView();
			} else if (topologyType.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {

				topologyInfoValue = topologyRoutingServiceIF.retriveRandomTopologyForView();
			}
			if (topologyInfoValue != null) {
				peebrTopologyViewList = populateFaultNodeTopologyView(topologyInfoValue);
			}

		} catch (Exception e) {
			System.out.println("Exception:-->" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveFaultNodeTopology" + ARROW + END);
		return peebrTopologyViewList;
	}

	private List<FaultNodeTopologyView> populateFaultNodeTopologyView(List<TopologyInfoValue> topologyInfoValue) {
		List<FaultNodeTopologyView> faultNodeTopologyList = new ArrayList<FaultNodeTopologyView>();

		for (TopologyInfoValue topoInfoValue : topologyInfoValue) {
			FaultNodeTopologyView faultTopologyView = new FaultNodeTopologyView();
			faultTopologyView.setEnergy(topoInfoValue.getNodeParameters().getEnergy());
			faultTopologyView.setNetworkCost(topoInfoValue.getNodeParameters().getNetworkCost());
			faultTopologyView.setPowerConsumed(topoInfoValue.getNodeParameters().getAvailableBatteryPower());
			faultTopologyView.setBuffer(topoInfoValue.getNodeParameters().getBuffer());
			faultTopologyView.setxCordinate(topoInfoValue.getNodeCoordiante().getX_cor());
			faultTopologyView.setyCordinate(topoInfoValue.getNodeCoordiante().getY_cor());
			faultTopologyView.setNodeId(topoInfoValue.getNodeId());
			faultNodeTopologyList.add(faultTopologyView);
		}
		return faultNodeTopologyList;
	}

	@Override
	public List<NormalRoutingTable> retriveNormalRoutingTables(int nodeId, String topologyType) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveNormalRoutingTables" + ARROW + START);

		List<NormalRoutingTable> normalRoutingTable = null;
		try {
			if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
				normalRoutingTable = routingTableServiceIF.retriveNormalRoutingTables(nodeId,
						TopologyTypesIF.LINEAR_TOPOLOGY);
			}

			if (topologyType.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {
				normalRoutingTable = routingTableServiceIF.retriveNormalRoutingTables(nodeId,
						TopologyTypesIF.RANDOM_TOPOLOGY);
			}
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveNormalRoutingTables" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveNormalRoutingTables" + ARROW + END);
		return normalRoutingTable;
	}

	@Override
	public boolean createRoutingTable(String topologyType) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "createRoutingTable" + ARROW + START);
		boolean createRoutingTable = false;
		try {
			if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
				createRoutingTable = routingTableServiceIF.createTable(TopologyTypesIF.LINEAR_TOPOLOGY);
			}

			if (topologyType.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {
				createRoutingTable = routingTableServiceIF.createTable(TopologyTypesIF.RANDOM_TOPOLOGY);
			}
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveNormalRoutingTables" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveNormalRoutingTables" + ARROW + END);
		return createRoutingTable;
	}

	@Override
	public List<NodeId> retriveNodeIds(String topologyType) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveNodeIds" + ARROW + START);

		List<NodeId> nodeIdsList = null;
		try {
			int nodeIdCount = 0;
			if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
				nodeIdCount = topologyRoutingServiceIF.retriveLinearTopologyCount();
			}

			if (topologyType.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {
				nodeIdCount = topologyRoutingServiceIF.retriveRandomTopologyCount();
			}

			if (nodeIdCount > 0) {
				nodeIdsList = new ArrayList<NodeId>();
				for (int nodeId = 1; nodeId <= nodeIdCount; nodeId++) {
					NodeId nodeIdValue = new NodeId();
					nodeIdValue.setNodeId(nodeId);
					nodeIdsList.add(nodeIdValue);
				}
			}
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveNodeIds" + ARROW + "Exception:-->"
					+ e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveNodeIds" + ARROW + END);
		return nodeIdsList;
	}

	@Override
	public boolean insertRoutingTables(String topologyType) {
		boolean insertRoutingTables = false;
		try {
			insertRoutingTables = routingTableServiceIF.insertRoutingTable(topologyType);

		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "insertRoutingTables" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "insertRoutingTables" + ARROW + END);
		return insertRoutingTables;
	}

	@Override
	public boolean createEnergyTables(String topologyType) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "createEnergyTables" + ARROW + START);
		boolean energyTable = false;
		try {
			energyTable = parametersServiceIF.createParameterTables(ParametersTypeIF.ENERGY, topologyType);
			if (energyTable) {
				parametersServiceIF.insertAllParameters(ParametersTypeIF.ENERGY, topologyType);
			}

		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "createEnergyTables" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "createEnergyTables" + ARROW + END);
		return energyTable;
	}

	@Override
	public Energy retriveEnergyTables(int nodeId) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveEnergyTables" + ARROW + START);

		Energy energy = null;
		try {
			ParameterValue parameterValue = parametersServiceIF.retriveParameter(ParametersTypeIF.ENERGY, nodeId);
			energy = new Energy();
			energy.setEnergy(parameterValue.getEnergy());

		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveEnergyTables" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveEnergyTables" + ARROW + END);
		return energy;
	}

	@Override
	public boolean createPowerTables(String topologyType) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "createPowerTables" + ARROW + START);
		boolean powerTable = false;
		try {

			powerTable = parametersServiceIF.createParameterTables(ParametersTypeIF.POWER, topologyType);

			if (powerTable) {
				powerTable = parametersServiceIF.insertAllParameters(ParametersTypeIF.POWER, topologyType);
			}

		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "createPowerTables" + ARROW + "Exception:-->"
					+ e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "createPowerTables" + ARROW + END);
		return powerTable;
	}

	@Override
	public Power retrivePowerTable(int nodeId) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerTable" + ARROW + START);

		Power power = null;
		try {
			ParameterValue parameterValue = parametersServiceIF.retriveParameter(ParametersTypeIF.POWER, nodeId);
			power = new Power();
			power.setPower(parameterValue.getPower());

		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerTable" + ARROW + "Exception:-->"
					+ e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerTable" + ARROW + END);
		return power;
	}

	@Override
	public List<PerformanceEnergy> retriveEnergyAlgo1() {

		List<PerformanceEnergy> compareEnergyList = null;
		try {
			compareEnergyList = performanceServiceIF.retriveEnergyAlgo1();
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveEnergyAlgo1" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return compareEnergyList;

	}

	@Override
	public List<PerformanceEnergy> retriveEnergyAlgo2() {

		List<PerformanceEnergy> compareEnergyList = null;
		try {
			compareEnergyList = performanceServiceIF.retriveEnergyAlgo2();
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveEnergyAlgo2" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return compareEnergyList;
	}

	@Override
	public List<PerformancePower> retrivePowerAlgo1() {
		List<PerformancePower> comparePowerList = null;
		try {
			comparePowerList = performanceServiceIF.retrivePowerAlgo1();
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerAlgo1" + ARROW + "Exception:-->"
					+ e.getMessage());
		}
		return comparePowerList;
	}

	@Override
	public List<PerformancePower> retrivePowerAlgo2() {
		List<PerformancePower> comparePowerList = null;
		try {
			comparePowerList = performanceServiceIF.retrivePowerAlgo2();
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerAlgo2" + ARROW + "Exception:-->"
					+ e.getMessage());
		}
		return comparePowerList;
	}

	@Override
	public List<PerformanceTimeTaken> retriveTimeAlgo1() {
		List<PerformanceTimeTaken> compareTimeTakenList = null;
		try {
			compareTimeTakenList = performanceServiceIF.retriveRoundTripTimeAlgo1();
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveTimeAlgo1" + ARROW + "Exception:-->"
					+ e.getMessage());
		}
		return compareTimeTakenList;
	}

	@Override
	public List<PerformanceTimeTaken> retriveTimeAlgo2() {
		List<PerformanceTimeTaken> compareTimeTakenList = null;
		try {
			compareTimeTakenList = performanceServiceIF.retriveRoundTripTimeAlgo2();
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveTimeAlgo1" + ARROW + "Exception:-->"
					+ e.getMessage());
		}
		return compareTimeTakenList;
	}

	@Override
	public List<ComparePower> retrivePowerComparison() {

		List<ComparePower> comparePowerList = null;
		try {
			comparePowerList = new ArrayList<ComparePower>();

			List<PerformancePower> perfPower1 = performanceServiceIF.retrivePowerAlgo1();

			List<PerformancePower> perfPower2 = performanceServiceIF.retrivePowerAlgo2();

			int countPower1 = perfPower1.size();

			int countPower2 = perfPower2.size();

			List<Integer> powerCount = new ArrayList<Integer>();
			powerCount.add(countPower1);
			powerCount.add(countPower2);

			int count = Collections.min(powerCount);

			for (int i = 1; i <= count; i++) {
				ComparePower comparePower = new ComparePower();
				comparePower.setIterationNo(i);
				comparePower.setNormalPower(perfPower1.get(i - 1).getPowerConsumed());
				comparePower.setRequisitePower(perfPower2.get(i - 1).getPowerConsumed());
				comparePowerList.add(comparePower);
			}
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerComparison" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return comparePowerList;
	}

	@Override
	public List<CompareEnergy> retriveEnergyComparison() {
		List<CompareEnergy> compareEnergyList = null;
		try {
			compareEnergyList = new ArrayList<CompareEnergy>();
			List<PerformanceEnergy> perfEnergy1 = performanceServiceIF.retriveEnergyAlgo1();
			List<PerformanceEnergy> perfEnergy2 = performanceServiceIF.retriveEnergyAlgo2();
			List<PerformanceEnergy> perfEnergy3 = performanceServiceIF.retriveEnergyAlgo3();
			List<PerformanceEnergy> perfEnergy4 = performanceServiceIF.retriveEnergyAlgo4();

			int countEnergy1 = perfEnergy1.size();
			int countEnergy2 = perfEnergy2.size();
			int countEnergy3 = perfEnergy3.size();
			int countEnergy4 = perfEnergy4.size();

			List<Integer> energyCount = new ArrayList<Integer>();
			energyCount.add(countEnergy1);
			energyCount.add(countEnergy2);
			energyCount.add(countEnergy3);
			energyCount.add(countEnergy4);

			int count = Collections.min(energyCount);
			for (int i = 1; i <= count; i++) {
				CompareEnergy compareEnergy = new CompareEnergy();
				compareEnergy.setIterationNo(i);
				compareEnergy.setEnergyAlgo1(perfEnergy1.get(i - 1).getEnergyConsumed());
				compareEnergy.setEnergyAlgo2(perfEnergy2.get(i - 1).getEnergyConsumed());
				compareEnergy.setEnergyAlgo3(perfEnergy3.get(i - 1).getEnergyConsumed());
				compareEnergy.setEnergyAlgo4(perfEnergy4.get(i - 1).getEnergyConsumed());

				compareEnergyList.add(compareEnergy);
			}
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveEnergyComparison" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return compareEnergyList;
	}

	@Override
	public List<CompareTime> retriveTimeComparison() {
		List<CompareTime> compareTimeList = null;
		try {
			compareTimeList = new ArrayList<CompareTime>();
			List<PerformanceTimeTaken> perfTime1 = performanceServiceIF.retriveRoundTripTimeAlgo1();
			List<PerformanceTimeTaken> perfTime2 = performanceServiceIF.retriveRoundTripTimeAlgo2();
			List<PerformanceTimeTaken> perfTime3 = performanceServiceIF.retriveRoundTripTimeAlgo3();
			List<PerformanceTimeTaken> perfTime4 = performanceServiceIF.retriveRoundTripTimeAlgo4();
			int countTime1 = perfTime1.size();
			int countTime2 = perfTime2.size();
			int countTime3 = perfTime3.size();
			int countTime4 = perfTime4.size();

			List<Integer> timeCount = new ArrayList<Integer>();
			timeCount.add(countTime1);
			timeCount.add(countTime2);
			timeCount.add(countTime3);
			timeCount.add(countTime4);

			int count = Collections.min(timeCount);
			for (int i = 1; i <= count; i++) {
				CompareTime compareTime = new CompareTime();
				compareTime.setIterationNo(i);
				compareTime.setTimeAlgo1((perfTime1.get(i - 1).getTimeTaken()));
				compareTime.setTimeAlgo2(perfTime2.get(i - 1).getTimeTaken());
				compareTime.setTimeAlgo3(perfTime3.get(i - 1).getTimeTaken());
				compareTime.setTimeAlgo4(perfTime4.get(i - 1).getTimeTaken());
				compareTimeList.add(compareTime);
			}
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerComparison" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return compareTimeList;
	}

	@Override
	public Power retriveEnergyTableForEEDR(Integer nodeId) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerTableForFaultNode" + ARROW + START);

		Power power = null;
		try {
			ParameterValue parameterValue = parametersServiceIF.retriveParameter(ParametersTypeIF.ENERGY, nodeId);
			power = new Power();
			power.setPower(parameterValue.getEnergy());

		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerTableForFaultNode" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerTableForFaultNode" + ARROW + END);
		return power;
	}

	@Override
	public List<CompareHops> retriveHopsComparison() {
		List<CompareHops> compareHopsList = null;
		try {
			compareHopsList = new ArrayList<CompareHops>();
			List<PerformanceHops> hopsAlgo1 = performanceServiceIF.retriveNoOfHopsAlgo1();
			List<PerformanceHops> hopsAlgo2 = performanceServiceIF.retriveNoOfHopsAlgo2();
			List<PerformanceHops> hopsAlgo3 = performanceServiceIF.retriveNoOfHopsAlgo3();
			List<PerformanceHops> hopsAlgo4 = performanceServiceIF.retriveNoOfHopsAlgo4();

			int hopSize1 = hopsAlgo1.size();
			int hopSize2 = hopsAlgo2.size();
			int hopSize3 = hopsAlgo3.size();
			int hopSize4 = hopsAlgo4.size();

			List<Integer> hopCOunt = new ArrayList<Integer>();
			hopCOunt.add(hopSize1);
			hopCOunt.add(hopSize2);
			hopCOunt.add(hopSize3);
			hopCOunt.add(hopSize4);

			int count = Collections.min(hopCOunt);
			for (int i = 1; i <= count; i++) {
				CompareHops performanceHops = new CompareHops();
				performanceHops.setIterationNo(i);
				performanceHops.setHopsAlgo2(hopsAlgo2.get(i - 1).getNoOfHops());
				performanceHops.setHopsAlgo1(hopsAlgo1.get(i - 1).getNoOfHops());
				performanceHops.setHopsAlgo3(hopsAlgo3.get(i - 1).getNoOfHops());
				performanceHops.setHopsAlgo4(hopsAlgo4.get(i - 1).getNoOfHops());
				compareHopsList.add(performanceHops);
			}
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveHopsComparison" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return compareHopsList;
	}

	@Override
	public List<PerformanceHops> retriveNoOfHopsAlgo1() {
		List<PerformanceHops> noOfHopsListForGradeDiffusion = null;
		try {
			noOfHopsListForGradeDiffusion = performanceServiceIF.retriveNoOfHopsAlgo1();
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveNoOfHopsAlgo1" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return noOfHopsListForGradeDiffusion;
	}

	@Override
	public List<PerformanceHops> retriveNoOfHopsAlgo2() {
		List<PerformanceHops> noOfHopsListForFaultNode = null;
		try {
			noOfHopsListForFaultNode = performanceServiceIF.retriveNoOfHopsAlgo2();
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveNoOfHopsAlgo2" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return noOfHopsListForFaultNode;
	}

	@Override
	public List<CompareNoOfDeadNodes> retriveDeadNodesComparison() {
		List<CompareNoOfDeadNodes> compareDeadNodesList = null;
		try {
			compareDeadNodesList = new ArrayList<CompareNoOfDeadNodes>();
			List<PerformanceDeadNodes> deadNodes1 = performanceServiceIF.retriveDeadNodesForAlgo1();
			List<PerformanceDeadNodes> deadNodes2 = performanceServiceIF.retriveDeadNodesForAlgo2();
			List<PerformanceDeadNodes> deadNodes3 = performanceServiceIF.retriveDeadNodesForAlgo3();
			List<PerformanceDeadNodes> deadNodes4 = performanceServiceIF.retriveDeadNodesForAlgo4();

			int hopSize1 = deadNodes1.size();
			int hopSize2 = deadNodes2.size();
			int hopSize3 = deadNodes3.size();
			int deadnodesSize4 = deadNodes4.size();

			List<Integer> hopCOunt = new ArrayList<Integer>();
			hopCOunt.add(hopSize1);
			hopCOunt.add(hopSize2);
			hopCOunt.add(hopSize3);
			hopCOunt.add(deadnodesSize4);

			int count = Collections.min(hopCOunt);
			for (int i = 1; i <= count; i++) {
				CompareNoOfDeadNodes performanceDeadNodes = new CompareNoOfDeadNodes();
				performanceDeadNodes.setNoOfIterations(i);
				performanceDeadNodes.setDeadNodes1(deadNodes1.get(i - 1).getNoOfDeadNodes());
				performanceDeadNodes.setDeadNodes2(deadNodes2.get(i - 1).getNoOfDeadNodes());
				performanceDeadNodes.setDeadNodes3(deadNodes3.get(i - 1).getNoOfDeadNodes());
				performanceDeadNodes.setDeadNodes4(deadNodes4.get(i - 1).getNoOfDeadNodes());
				compareDeadNodesList.add(performanceDeadNodes);
			}
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveDeadNodesComparison" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return compareDeadNodesList;
	}

	@Override
	public List<CompareNoOfAliveNodes> retriveAliveNodesComparison() {
		List<CompareNoOfAliveNodes> compareAliveNodesList = null;
		try {
			compareAliveNodesList = new ArrayList<CompareNoOfAliveNodes>();
			List<PerformanceAliveNodes> aliveNodesList1 = performanceServiceIF.retriveAliveNodesForAlgo1();
			List<PerformanceAliveNodes> aliveNodesList2 = performanceServiceIF.retriveAliveNodesForAlgo2();
			List<PerformanceAliveNodes> aliveNodesList3 = performanceServiceIF.retriveAliveNodesForAlgo3();
			List<PerformanceAliveNodes> aliveNodesList4 = performanceServiceIF.retriveAliveNodesForAlgo4();

			int hopSize1 = aliveNodesList1.size();
			int hopSize2 = aliveNodesList2.size();
			int hopSize3 = aliveNodesList3.size();
			int hopSize4 = aliveNodesList4.size();

			List<Integer> hopCOunt = new ArrayList<Integer>();
			hopCOunt.add(hopSize1);
			hopCOunt.add(hopSize2);
			hopCOunt.add(hopSize3);
			hopCOunt.add(hopSize4);
			int count = Collections.min(hopCOunt);
			for (int i = 1; i <= count; i++) {
				CompareNoOfAliveNodes aliveNodesComparision = new CompareNoOfAliveNodes();
				aliveNodesComparision.setNoOfIterations(i);
				aliveNodesComparision.setAliveNodes1(aliveNodesList1.get(i - 1).getNoOfAliveNodes());
				aliveNodesComparision.setAliveNodes2(aliveNodesList2.get(i - 1).getNoOfAliveNodes());
				aliveNodesComparision.setAliveNodes3(aliveNodesList3.get(i - 1).getNoOfAliveNodes());
				aliveNodesComparision.setAliveNodes4(aliveNodesList4.get(i - 1).getNoOfAliveNodes());
				compareAliveNodesList.add(aliveNodesComparision);
			}
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveAliveNodesComparison" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return compareAliveNodesList;
	}

	@Override
	public List<PerformanceDeadNodes> retriveDeadNodesAlgo1() {
		List<PerformanceDeadNodes> deadNodesListForGrade = null;
		try {
			deadNodesListForGrade = performanceServiceIF.retriveDeadNodesForAlgo1();
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveDeadNodesAlgo1" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return deadNodesListForGrade;
	}

	@Override
	public List<PerformanceDeadNodes> retriveDeadNodesAlgo2() {
		List<PerformanceDeadNodes> deadNodesListForFaultNode = null;
		try {
			deadNodesListForFaultNode = performanceServiceIF.retriveDeadNodesForAlgo2();
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveDeadNodesAlgo2" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return deadNodesListForFaultNode;
	}

	@Override
	public List<PerformanceAliveNodes> retriveAliveNodesAlgo1() {
		List<PerformanceAliveNodes> aliveNodesListForGrade = null;
		try {
			aliveNodesListForGrade = performanceServiceIF.retriveAliveNodesForAlgo1();
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveAliveNodesAlgo1" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return aliveNodesListForGrade;
	}

	@Override
	public List<PerformanceAliveNodes> retriveAliveNodesAlgo2() {
		List<PerformanceAliveNodes> aliveNodesListForFaultNode = null;
		try {
			aliveNodesListForFaultNode = performanceServiceIF.retriveAliveNodesForAlgo2();
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveAliveNodesAlgo2" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return aliveNodesListForFaultNode;
	}

	@Override
	public boolean createEnergyTablesForDSDV(String topologyType) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "createEnergyTablesForDSDV" + ARROW + START);
		boolean powerTable = false;
		try {

			powerTable = parametersServiceIF.createParameterTables(ParametersTypeIF.NETWORKCOST, topologyType);

			if (powerTable) {
				powerTable = parametersServiceIF.insertAllParameters(ParametersTypeIF.NETWORKCOST, topologyType);
			}

		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "createEnergyTablesForDSDV" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "createEnergyTablesForDSDV" + ARROW + END);
		return powerTable;
	}

	@Override
	public Power viewEnergyTableForDSDV(Integer nodeId) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerTableForFaultNode" + ARROW + START);

		Power power = null;
		try {
			ParameterValue parameterValue = parametersServiceIF.retriveParameter(ParametersTypeIF.NETWORKCOST, nodeId);
			power = new Power();
			power.setPower(parameterValue.getNetworkCost());

		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerTableForFaultNode" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerTableForFaultNode" + ARROW + END);
		return power;
	}

	@Override
	public boolean updatedSettings(String topologyType) {
		TopologyTypeVO topologyTypeObj = new TopologyTypeVO();
		topologyTypeObj.setPropertyName(TopologyConstantsIF.TOPOLOGY_TYPE);
		topologyTypeObj.setPropertyValue(topologyType);
		return settingsDao.updateTopologyType(topologyTypeObj);
	}

	@Override
	public String retrivePropertyValueForPropertyName(String topologyType) {
		return settingsDao.retrivePropertyValueForPropertyName(topologyType);
	}

	@Override
	public List<CompareResidualEnergy> retriveResidualEnergyComparison() {
		List<CompareResidualEnergy> compareEnergyList = null;
		try {
			compareEnergyList = new ArrayList<CompareResidualEnergy>();
			List<PerformanceResidualEnergy> perfEnergy1 = performanceServiceIF.retriveResidualEnergyAlgo1();
			List<PerformanceResidualEnergy> perfEnergy2 = performanceServiceIF.retriveResidualEnergyAlgo2();
			List<PerformanceResidualEnergy> perfEnergy3 = performanceServiceIF.retriveResidualEnergyAlgo3();
			List<PerformanceResidualEnergy> perfEnergy4 = performanceServiceIF.retriveResidualEnergyAlgo4();

			int countEnergy1 = perfEnergy1.size();
			int countEnergy2 = perfEnergy2.size();
			int countEnergy3 = perfEnergy3.size();
			int countEnergy4 = perfEnergy4.size();

			List<Integer> energyCount = new ArrayList<Integer>();
			energyCount.add(countEnergy1);
			energyCount.add(countEnergy2);
			energyCount.add(countEnergy3);
			energyCount.add(countEnergy4);

			int count = Collections.min(energyCount);
			for (int i = 1; i <= count; i++) {
				CompareResidualEnergy compareEnergy = new CompareResidualEnergy();
				compareEnergy.setIterationNo(i);
				compareEnergy.setResidualEnergy1(perfEnergy1.get(i - 1).getResidualEnergy());
				compareEnergy.setResidualEnergy2(perfEnergy2.get(i - 1).getResidualEnergy());
				compareEnergy.setResidualEnergy3(perfEnergy3.get(i - 1).getResidualEnergy());
				compareEnergy.setResidualEnergy4(perfEnergy4.get(i - 1).getResidualEnergy());

				compareEnergyList.add(compareEnergy);
			}
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveEnergyComparison" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return compareEnergyList;
	}

	@Override
	public List<CompareLifeTimeRatio> retriveComparisonLifeTimeRatio() {
		List<CompareLifeTimeRatio> compareLifeTimeRatioList = null;
		try {
			compareLifeTimeRatioList = new ArrayList<CompareLifeTimeRatio>();
			List<PerformanceLifeTimeRatio> perfEnergy1 = performanceServiceIF.retriveLifeTimeRatioAlgo1();
			List<PerformanceLifeTimeRatio> perfEnergy2 = performanceServiceIF.retriveLifeTimeRatioAlgo2();
			List<PerformanceLifeTimeRatio> perfEnergy3 = performanceServiceIF.retriveLifeTimeRatioAlgo3();
			List<PerformanceLifeTimeRatio> perfEnergy4 = performanceServiceIF.retriveLifeTimeRatioAlgo4();

			int countEnergy1 = perfEnergy1.size();
			int countEnergy2 = perfEnergy2.size();
			int countEnergy3 = perfEnergy3.size();
			int countEnergy4 = perfEnergy4.size();

			List<Integer> energyCount = new ArrayList<Integer>();
			energyCount.add(countEnergy1);
			energyCount.add(countEnergy2);
			energyCount.add(countEnergy3);
			energyCount.add(countEnergy4);

			int count = Collections.min(energyCount);
			for (int i = 1; i <= count; i++) {
				CompareLifeTimeRatio compareLifeTimeRatio = new CompareLifeTimeRatio();
				compareLifeTimeRatio.setIterationNo(i);
				compareLifeTimeRatio.setLifeTimeRatio1(perfEnergy1.get(i - 1).getLifeTimeRatio());
				compareLifeTimeRatio.setLifeTimeRatio2(perfEnergy2.get(i - 1).getLifeTimeRatio());
				compareLifeTimeRatio.setLifeTimeRatio3(perfEnergy3.get(i - 1).getLifeTimeRatio());
				compareLifeTimeRatio.setLifeTimeRatio4(perfEnergy4.get(i - 1).getLifeTimeRatio());
				compareLifeTimeRatioList.add(compareLifeTimeRatio);
			}
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveEnergyComparison" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return compareLifeTimeRatioList;
	}

	@Override
	public List<CompareRoutingOverhead> retriveCompareRoutingOverhead() {
		List<CompareRoutingOverhead> compareRoutingOverheadList = null;
		try {
			compareRoutingOverheadList = new ArrayList<CompareRoutingOverhead>();
			List<PerformanceRoutingOverhead> overhead1 = performanceServiceIF.retriveRoutingOverheadAlgo1();
			List<PerformanceRoutingOverhead> overhead2 = performanceServiceIF.retriveRoutingOverheadAlgo2();
			List<PerformanceRoutingOverhead> overhead3 = performanceServiceIF.retriveRoutingOverheadAlgo3();
			List<PerformanceRoutingOverhead> overhead4 = performanceServiceIF.retriveRoutingOverheadAlgo4();

			int count1 = overhead1.size();
			int count2 = overhead2.size();
			int count3 = overhead3.size();
			int count4 = overhead4.size();

			List<Integer> overheadCount = new ArrayList<Integer>();
			overheadCount.add(count1);
			overheadCount.add(count2);
			overheadCount.add(count3);
			overheadCount.add(count4);

			int count = Collections.min(overheadCount);
			for (int i = 1; i <= count; i++) {
				CompareRoutingOverhead compareOverhead = new CompareRoutingOverhead();
				compareOverhead.setIterationNo(i);
				compareOverhead.setRoutingOverhead1(overhead1.get(i - 1).getRoutingOverhead());
				compareOverhead.setRoutingOverhead2(overhead2.get(i - 1).getRoutingOverhead());
				compareOverhead.setRoutingOverhead3(overhead3.get(i - 1).getRoutingOverhead());
				compareOverhead.setRoutingOverhead4(overhead4.get(i - 1).getRoutingOverhead());
				compareRoutingOverheadList.add(compareOverhead);
			}
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveEnergyComparison" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return compareRoutingOverheadList;
	}

	@Override
	public List<CompareThroughput> retriveCompareThroughput() {
		List<CompareThroughput> compareThroughputList = null;
		try {
			compareThroughputList = new ArrayList<CompareThroughput>();
			List<PerformanceThroughput> throughput1 = performanceServiceIF.retriveThroughputAlgo1();
			List<PerformanceThroughput> throughput2 = performanceServiceIF.retriveThroughputAlgo2();
			List<PerformanceThroughput> throughput3 = performanceServiceIF.retriveThroughputAlgo3();
			List<PerformanceThroughput> throughput4 = performanceServiceIF.retriveThroughputAlgo4();

			int count1 = throughput1.size();
			int count2 = throughput2.size();
			int count3 = throughput3.size();
			int count4 = throughput4.size();

			List<Integer> throughputCount = new ArrayList<Integer>();
			throughputCount.add(count1);
			throughputCount.add(count2);
			throughputCount.add(count3);
			throughputCount.add(count4);

			int count = Collections.min(throughputCount);
			for (int i = 1; i <= count; i++) {
				CompareThroughput compareThroughput = new CompareThroughput();
				compareThroughput.setIterationNo(i);
				compareThroughput.setThroughput1(throughput1.get(i - 1).getThroughput());
				compareThroughput.setThroughput2(throughput2.get(i - 1).getThroughput());
				compareThroughput.setThroughput3(throughput3.get(i - 1).getThroughput());
				compareThroughput.setThroughput4(throughput4.get(i - 1).getThroughput());
				compareThroughputList.add(compareThroughput);
			}
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveCompareThroughput" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		return compareThroughputList;
	}

	@Override
	public List<IPAdressVO> retriveIPAddressList() {

		List<IPAdressVO> ipAddressList = null;

		try {
			ipAddressList = ipAddressMaintainenceDao.retriveIPAddressList();

		} catch (Exception e) {
			System.out.println("Exception:-->" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveFaultNodeTopology" + ARROW + END);
		return ipAddressList;
	}

	@Override
	public boolean storeIpAddress(IPAdressVO ipAdressVO) {

		boolean storageValue = false;
		try {

			IPAdressVO ipAdressVO2 = ipAddressMaintainenceDao.getIPAddressInfo(ipAdressVO.getNodeId());

			if (null == ipAdressVO2) {

				storageValue = ipAddressMaintainenceDao.insertIPAddressVO(ipAdressVO);
			} else {
				storageValue = ipAddressMaintainenceDao.updateIPAddressVO(ipAdressVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
			storageValue = false;
		}

		return storageValue;

	}

	@Override
	public StatusInfo removeIpAddress(IPAdressVO ipAdressVONew) {

		StatusInfo statusInfo = new StatusInfo();

		try {

			IPAdressVO ipAdressVO2 = ipAddressMaintainenceDao.getIPAddressInfo(ipAdressVONew.getNodeId());

			if (null == ipAdressVO2) {

				statusInfo.setStatus(false);
				statusInfo.setErrMsg("Ip Address is not present for the given Node Id");

				return statusInfo;
			} else {
				boolean storageValue = ipAddressMaintainenceDao.removeIPAddressVO(ipAdressVONew);

				if (!storageValue) {
					statusInfo.setStatus(false);
					statusInfo.setErrMsg("Could not remove IP Address");
					return statusInfo;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());

			return statusInfo;
		}

		statusInfo.setStatus(true);

		return statusInfo;
	}

	@Override
	public StatusInfo removeAllAlgorithmsData(String type) {
		StatusInfo statusInfo = new StatusInfo();

		try {

			boolean isAlgo = performanceServiceIF.removeAllAlgorithmsData(type);

			if (isAlgo) {

				statusInfo.setStatus(true);
				return statusInfo;

			} else {
				statusInfo.setStatus(false);
				statusInfo.setErrMsg("Could not Delete Data");
				return statusInfo;
			}

		} catch (Exception e) {

			statusInfo.setStatus(false);
			statusInfo.setErrMsg(e.getMessage());

			return statusInfo;
		}
	}

	@Override
	public boolean deleteData(String type) {

		boolean deleteData = false;

		try {

			deleteData = performanceServiceIF.removeAllAlgorithmsData(type);

		} catch (Exception e) {

			deleteData = false;
		}

		return deleteData;
	}

	public boolean createEnergyTablesForECentrality(String topologyType) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "createPowerTables" + ARROW + START);
		boolean powerTable = false;
		try {

			powerTable = parametersServiceIF.createParameterTables(ParametersTypeIF.BUFFER, topologyType);

			if (powerTable) {
				powerTable = parametersServiceIF.insertAllParameters(ParametersTypeIF.BUFFER, topologyType);
			}

		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "createPowerTables" + ARROW + "Exception:-->"
					+ e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "createPowerTables" + ARROW + END);
		return powerTable;
	}

	public Power viewEnergyTablesForECentric(Integer nodeId) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerTableForFaultNode" + ARROW + START);

		Power power = null;
		try {
			ParameterValue parameterValue = parametersServiceIF.retriveParameter(ParametersTypeIF.TRUST, nodeId);
			power = new Power();
			power.setPower(parameterValue.getTrustLevel());

		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerTableForFaultNode" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerTableForFaultNode" + ARROW + END);
		return power;
	}

	public Buffer retriveBufferTable(Integer nodeId) {
		Buffer buffer = null;
		try {
			ParameterValue parameterValue = parametersServiceIF.retriveParameter(ParametersTypeIF.BUFFER, nodeId);
			buffer = new Buffer();
			buffer.setBuffer(parameterValue.getBuffer());

		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerTableForFaultNode" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerTableForFaultNode" + ARROW + END);
		return buffer;
	}

	public NetworkCost retriveNetworkCostTable(Integer nodeId) {
		NetworkCost buffer = null;
		try {
			ParameterValue parameterValue = parametersServiceIF.retriveParameter(ParametersTypeIF.NETWORKCOST, nodeId);
			buffer = new NetworkCost();
			buffer.setNetworkCost(parameterValue.getNetworkCost());

		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerTableForFaultNode" + ARROW
					+ "Exception:-->" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retrivePowerTableForFaultNode" + ARROW + END);
		return buffer;
	}

}
