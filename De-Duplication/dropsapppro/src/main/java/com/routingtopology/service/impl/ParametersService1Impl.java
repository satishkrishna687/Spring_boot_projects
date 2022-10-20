package com.routingtopology.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routingtopology.constants.ParametersTypeIF;
import com.routingtopology.constants.TopologyTypesIF;
import com.routingtopology.dao.impl.BufferParametersDAOImpl;
import com.routingtopology.dao.impl.DempsterParameterDaoImpl;
import com.routingtopology.dao.impl.EigenParameterDaoImpl;
import com.routingtopology.dao.impl.EnergyParametersDAOImpl;
import com.routingtopology.dao.impl.NetworkCostParametersDAOImpl;
import com.routingtopology.dao.impl.PowerParametersDAOImpl;
import com.routingtopology.dao.impl.SignalStengthDAOImpl;
import com.routingtopology.dao.impl.TrustParametersDAOImpl;
import com.routingtopology.dao.inter.BufferParametersDAOIF;
import com.routingtopology.dao.inter.DempsterParameterDAOIF;
import com.routingtopology.dao.inter.EigenParameterDAOIF;
import com.routingtopology.dao.inter.EnergyParametersDAOIF;
import com.routingtopology.dao.inter.NetworkCostParametersDAOIF;
import com.routingtopology.dao.inter.PowerParametersDAOIF;
import com.routingtopology.dao.inter.SignalStrengthParameterDAOIF;
import com.routingtopology.dao.inter.TrustParameterDAOIF;
import com.routingtopology.service.inter.ParametersService1IF;
import com.routingtopology.service.inter.TopologyRoutingServiceIF;
import com.routingtopology.value.ParameterValue;
import com.routingtopology.value.TopologyInfoValue;

/**
 * This is the implementation for the routing parameters
 * 
 */
@Service
public class ParametersService1Impl implements ParametersService1IF {

	private static final String CLASS_NAME = "Class--->ParametersServiceImpl:";

	private static final String METHOD_NAME = "Method--->";

	private static final String START_NAME = "START";

	private static final String END_NAME = "END";

	private static final String EXCEPTION = "Exception-->";

	@Autowired
	private TopologyRoutingServiceImpl topologyRoutingServiceIF;

	@Autowired
	private BufferParametersDAOImpl bufferParametersDAOIF;

	@Autowired
	private PowerParametersDAOImpl powerParametersDAOIF;

	@Autowired
	private EigenParameterDaoImpl eigenParameterDAOIF;

	@Autowired
	private DempsterParameterDaoImpl dempsterParameterDAOIF;

	@Autowired
	private SignalStengthDAOImpl signalStrengthDAOIF;

	@Autowired
	private TrustParametersDAOImpl trustParameterDAOIF;

	@Autowired
	private EnergyParametersDAOImpl energyParametersDAOIF;

	@Autowired
	private NetworkCostParametersDAOImpl networkCostParametersDAOIF;

	@Override
	public boolean createParameterTables(String parameterType, String topologyType) {

		boolean creatingTables = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "createParameterTables()" + START_NAME);
		System.out.println(CLASS_NAME + METHOD_NAME + "Topology Type=" + topologyType);

		try {
			if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveLinearTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);

				if (noOfNodes > 0) {
					dropTables(parameterType, noOfNodes);
					creatingTables = createtables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "Creation Status=" + creatingTables);
				}

			} else if (topologyType.equals(TopologyTypesIF.GRID_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveGridTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);
				if (noOfNodes > 0) {
					dropTables(parameterType, noOfNodes);
					creatingTables = createtables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "Creation Status=" + creatingTables);
				}
			} else if (topologyType.equals(TopologyTypesIF.VERTICAL_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveVerticalTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);
				if (noOfNodes > 0) {
					dropTables(parameterType, noOfNodes);
					creatingTables = createtables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "Creation Status=" + creatingTables);
				}
			} else if (topologyType.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveRandomTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);
				if (noOfNodes > 0) {
					dropTables(parameterType, noOfNodes);
					creatingTables = createtables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "Creation Status=" + creatingTables);
				}
			} else if (topologyType.equals(TopologyTypesIF.ANGLE_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveAngularTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);
				if (noOfNodes > 0) {
					dropTables(parameterType, noOfNodes);
					creatingTables = createtables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "Creation Status=" + creatingTables);
				}
			} else if (topologyType.equals(TopologyTypesIF.SQUARE_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveSquareZoneTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);
				if (noOfNodes > 0) {
					dropTables(parameterType, noOfNodes);
					creatingTables = createtables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "Creation Status=" + creatingTables);
				}
			}
		} catch (Exception e) {

		}
		return creatingTables;

	}

	private boolean createtables(String parameterType, int noOfNodes) {
		boolean creation = false;

		if (parameterType.equals(ParametersTypeIF.BUFFER)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = bufferParametersDAOIF.createBufferTable(BUFFER_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.ENERGY)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = energyParametersDAOIF.createEnergyTable(ENERGY_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.POWER)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = powerParametersDAOIF.createPowerTable(POWER_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.TRUST)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = trustParameterDAOIF.createTrustTable(TRUST_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.NETWORKCOST)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = networkCostParametersDAOIF
						.createNetworkCostTable(NETWORKCOST_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.EIGEN_TRUST)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = eigenParameterDAOIF.createEigenTrustTable(EIGENTRUST_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.DEMPSTER_TRUST)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = dempsterParameterDAOIF
						.createDempterTrustTable(DEMPTER_TRUST_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.SIGNALSTRENGTH)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = signalStrengthDAOIF
						.createSignalStrengthTable(SIGNALSTRENGTH_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		}
		return creation;
	}

	private boolean insertParameter(String parameterType, int noOfNodes, List<TopologyInfoValue> topologyInfoValue) {
		boolean creation = false;

		if (parameterType.equals(ParametersTypeIF.BUFFER)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				bufferParametersDAOIF.deleteBuffer(BUFFER_NODE + Integer.toString(nodeId));
				creation = bufferParametersDAOIF.insertBuffer(BUFFER_NODE + Integer.toString(nodeId),
						topologyInfoValue.get(nodeId - 1).getNodeParameters().getBuffer());
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.ENERGY)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				energyParametersDAOIF.deleteEnergy(ENERGY_NODE + Integer.toString(nodeId));
				creation = energyParametersDAOIF.insertEnergy(ENERGY_NODE + Integer.toString(nodeId),
						topologyInfoValue.get(nodeId - 1).getNodeParameters().getEnergy());
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.POWER)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				powerParametersDAOIF.deletePower(POWER_NODE + Integer.toString(nodeId));
				creation = powerParametersDAOIF.insertPower(POWER_NODE + Integer.toString(nodeId),
						topologyInfoValue.get(nodeId - 1).getNodeParameters().getAvailableBatteryPower());
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.TRUST)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				trustParameterDAOIF.deleteTrust(TRUST_NODE + Integer.toString(nodeId));
				creation = trustParameterDAOIF.insertTrust(TRUST_NODE + Integer.toString(nodeId),
						topologyInfoValue.get(nodeId - 1).getNodeParameters().getTrustLevel());
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.NETWORKCOST)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {

				networkCostParametersDAOIF.deleteNetworkCost(NETWORKCOST_NODE + Integer.toString(nodeId));
				creation = networkCostParametersDAOIF.insertNetworkCost(NETWORKCOST_NODE + Integer.toString(nodeId),
						topologyInfoValue.get(nodeId - 1).getNodeParameters().getNetworkCost());
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.EIGEN_TRUST)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = eigenParameterDAOIF.insertEigenTrust(EIGENTRUST_NODE + Integer.toString(nodeId), 0);
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.DEMPSTER_TRUST)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = dempsterParameterDAOIF.insertDempterTrust(DEMPTER_TRUST_NODE + Integer.toString(nodeId), 0);
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.SIGNALSTRENGTH)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = signalStrengthDAOIF.insertSignalStrength(SIGNALSTRENGTH_NODE + Integer.toString(nodeId), 0);
				if (creation == false) {
					break;
				}
			}
		}
		return creation;
	}

	/**
	 * @param parameterType
	 * @param nodeIdToInsert
	 * @param topologyInfoValue
	 * @return true if the parameter is inserted
	 */
	public boolean insertSingleParameter(String parameterType, int nodeIdToInsert,
			TopologyInfoValue topologyInfoValue) {
		boolean insertionFlag = false;

		if (parameterType.equals(ParametersTypeIF.BUFFER)) {
			insertionFlag = bufferParametersDAOIF.insertBuffer(BUFFER_NODE + Integer.toString(nodeIdToInsert),
					topologyInfoValue.getNodeParameters().getBuffer());

		} else if (parameterType.equals(ParametersTypeIF.ENERGY)) {

			insertionFlag = energyParametersDAOIF.insertEnergy(ENERGY_NODE + Integer.toString(nodeIdToInsert),
					topologyInfoValue.getNodeParameters().getEnergy());

		} else if (parameterType.equals(ParametersTypeIF.POWER)) {
			insertionFlag = powerParametersDAOIF.insertPower(POWER_NODE + Integer.toString(nodeIdToInsert),
					topologyInfoValue.getNodeParameters().getPowerConsumed());
		} else if (parameterType.equals(ParametersTypeIF.TRUST)) {
			insertionFlag = trustParameterDAOIF.insertTrust(TRUST_NODE + Integer.toString(nodeIdToInsert),
					topologyInfoValue.getNodeParameters().getTrustLevel());
		} else if (parameterType.equals(ParametersTypeIF.NETWORKCOST)) {
			insertionFlag = networkCostParametersDAOIF.insertNetworkCost(
					NETWORKCOST_NODE + Integer.toString(nodeIdToInsert),
					topologyInfoValue.getNodeParameters().getTrustLevel());
		} else if (parameterType.equals(ParametersTypeIF.EIGEN_TRUST)) {
			insertionFlag = eigenParameterDAOIF.insertEigenTrust(EIGENTRUST_NODE + Integer.toString(nodeIdToInsert),
					topologyInfoValue.getNodeParameters().getEigenTrustLevel());
		} else if (parameterType.equals(ParametersTypeIF.DEMPSTER_TRUST)) {
			insertionFlag = eigenParameterDAOIF.insertEigenTrust(DEMPTER_TRUST_NODE + Integer.toString(nodeIdToInsert),
					topologyInfoValue.getNodeParameters().getDempsterTrustLevel());
		} else if (parameterType.equals(ParametersTypeIF.SIGNALSTRENGTH)) {
			insertionFlag = signalStrengthDAOIF.insertSignalStrength(
					SIGNALSTRENGTH_NODE + Integer.toString(nodeIdToInsert),
					topologyInfoValue.getNodeParameters().getSignalStrengthOfNode());
		}
		return insertionFlag;
	}

	@Override
	public boolean deleteAllParameters(String parameterType, String topologyType) {

		boolean deletingTables = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteAllParameters()" + START_NAME);
		System.out.println(CLASS_NAME + METHOD_NAME + "Topology Type=" + topologyType);

		try {
			if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveLinearTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);

				if (noOfNodes > 0) {
					deletingTables = deleteTables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "delete Status=" + deletingTables);
				}

			} else if (topologyType.equals(TopologyTypesIF.GRID_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveGridTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);
				if (noOfNodes > 0) {
					deletingTables = deleteTables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "Delete Status=" + deletingTables);
				}
			} else if (topologyType.equals(TopologyTypesIF.VERTICAL_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveVerticalTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);
				if (noOfNodes > 0) {
					deletingTables = deleteTables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "Delete Status" + deletingTables);
				}
			} else if (topologyType.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveRandomTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);
				if (noOfNodes > 0) {
					deletingTables = deleteTables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "Delete Status=" + deletingTables);
				}
			} else if (topologyType.equals(TopologyTypesIF.ANGLE_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveAngularTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);
				if (noOfNodes > 0) {
					deletingTables = deleteTables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "Delete Status=" + deletingTables);
				}
			} else if (topologyType.equals(TopologyTypesIF.SQUARE_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveSquareZoneTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);
				if (noOfNodes > 0) {
					deletingTables = deleteTables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "Delete Status=" + deletingTables);
				}
			}
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + EXCEPTION + "deleteAllParameters()" + e.getMessage());
		}
		return deletingTables;
	}

	@Override
	public boolean deleteSpecficParameter(String parameterType, int nodeIdToDelete) {
		boolean specficTable = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteSpecficParameter()" + START_NAME);
		System.out.println(CLASS_NAME + METHOD_NAME + "ParameterType Type=" + parameterType);
		try {
			if (parameterType.equals(ParametersTypeIF.BUFFER)) {
				specficTable = bufferParametersDAOIF.deleteBuffer(BUFFER_NODE + Integer.toString(nodeIdToDelete));
			} else if (parameterType.equals(ParametersTypeIF.ENERGY)) {
				specficTable = energyParametersDAOIF.deleteEnergy(ENERGY_NODE + Integer.toString(nodeIdToDelete));
			} else if (parameterType.equals(ParametersTypeIF.POWER)) {
				specficTable = powerParametersDAOIF.deletePower(POWER_NODE + Integer.toString(nodeIdToDelete));
			} else if (parameterType.equals(ParametersTypeIF.TRUST)) {
				specficTable = trustParameterDAOIF.deleteTrust(TRUST_NODE + Integer.toString(nodeIdToDelete));
			} else if (parameterType.equals(ParametersTypeIF.NETWORKCOST)) {
				specficTable = networkCostParametersDAOIF
						.dropNetworkCostTable(NETWORKCOST_NODE + Integer.toString(nodeIdToDelete));
			}
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + EXCEPTION + "deleteSpecficParameter()" + e.getMessage());
		}

		return specficTable;
	}

	@Override
	public boolean dropSpecficTable(String parameterType, int nodeIdToDrop) {
		boolean specficTable = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "dropSpecficTable()" + START_NAME);
		System.out.println(CLASS_NAME + METHOD_NAME + "ParameterType Type=" + parameterType);
		try {
			if (parameterType.equals(ParametersTypeIF.BUFFER)) {
				specficTable = bufferParametersDAOIF.dropBufferTable(BUFFER_NODE + Integer.toString(nodeIdToDrop));
			} else if (parameterType.equals(ParametersTypeIF.ENERGY)) {
				specficTable = energyParametersDAOIF.dropEnergyTable(ENERGY_NODE + Integer.toString(nodeIdToDrop));
			} else if (parameterType.equals(ParametersTypeIF.POWER)) {
				specficTable = powerParametersDAOIF.dropPowerTable(POWER_NODE + Integer.toString(nodeIdToDrop));
			} else if (parameterType.equals(ParametersTypeIF.TRUST)) {
				specficTable = trustParameterDAOIF.dropTrustTable(TRUST_NODE + Integer.toString(nodeIdToDrop));
			} else if (parameterType.equals(ParametersTypeIF.NETWORKCOST)) {
				specficTable = networkCostParametersDAOIF
						.dropNetworkCostTable(NETWORKCOST_NODE + Integer.toString(nodeIdToDrop));
			} else if (parameterType.equals(ParametersTypeIF.EIGEN_TRUST)) {
				specficTable = eigenParameterDAOIF
						.dropEigenTrustTable(EIGENTRUST_NODE + Integer.toString(nodeIdToDrop));
			} else if (parameterType.equals(ParametersTypeIF.DEMPSTER_TRUST)) {
				specficTable = dempsterParameterDAOIF
						.dropDempterTrustTable(DEMPTER_TRUST_NODE + Integer.toString(nodeIdToDrop));
			}
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + EXCEPTION + "dropSpecficTable()" + e.getMessage());
		}

		return specficTable;
	}

	@Override
	public boolean insertAllParameters(String parameterType, String topologyType) {
		boolean creatingTables = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "insertAllParameters()" + START_NAME);
		System.out.println(CLASS_NAME + METHOD_NAME + "Topology Type=" + topologyType);

		try {
			if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveLinearTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);

				List<TopologyInfoValue> topologyInfoValues = topologyRoutingServiceIF.retriveLinearTopologyForView();
				System.out.println(CLASS_NAME + METHOD_NAME + "Topology Information=" + noOfNodes);

				if (noOfNodes > 0 && topologyInfoValues.size() > 0 && topologyInfoValues != null) {

					boolean deleteFirstIfExist = deleteAllParameters(parameterType, topologyType);

					if (deleteFirstIfExist) {
						creatingTables = insertParameter(parameterType, noOfNodes, topologyInfoValues);
						System.out.println(CLASS_NAME + METHOD_NAME + "Creation Status=" + creatingTables);
					}
				}

			} else if (topologyType.equals(TopologyTypesIF.GRID_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveGridTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);

				List<TopologyInfoValue> topologyInfoValues = topologyRoutingServiceIF.retriveGridTopologyForView();
				System.out.println(CLASS_NAME + METHOD_NAME + "Topology Information=" + noOfNodes);

				if (noOfNodes > 0 && topologyInfoValues.size() > 0 && topologyInfoValues != null) {

					boolean deleteFirstIfExist = deleteAllParameters(parameterType, topologyType);

					if (deleteFirstIfExist) {
						creatingTables = insertParameter(parameterType, noOfNodes, topologyInfoValues);
						System.out.println(CLASS_NAME + METHOD_NAME + "Creation Status=" + creatingTables);
					}
				}
			} else if (topologyType.equals(TopologyTypesIF.VERTICAL_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveVerticalTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);

				List<TopologyInfoValue> topologyInfoValues = topologyRoutingServiceIF.retriveVerticalTopologyForView();
				System.out.println(CLASS_NAME + METHOD_NAME + "Topology Information=" + noOfNodes);

				if (noOfNodes > 0 && topologyInfoValues.size() > 0 && topologyInfoValues != null) {

					boolean deleteFirstIfExist = deleteAllParameters(parameterType, topologyType);

					if (deleteFirstIfExist) {
						creatingTables = insertParameter(parameterType, noOfNodes, topologyInfoValues);
						System.out.println(CLASS_NAME + METHOD_NAME + "Creation Status=" + creatingTables);
					}
				}
			} else if (topologyType.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveRandomTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);

				List<TopologyInfoValue> topologyInfoValues = topologyRoutingServiceIF.retriveRandomTopologyForView();
				System.out.println(CLASS_NAME + METHOD_NAME + "Topology Information=" + noOfNodes);

				if (noOfNodes > 0 && topologyInfoValues.size() > 0 && topologyInfoValues != null) {

					boolean deleteFirstIfExist = deleteAllParameters(parameterType, topologyType);

					if (deleteFirstIfExist) {
						creatingTables = insertParameter(parameterType, noOfNodes, topologyInfoValues);
						System.out.println(CLASS_NAME + METHOD_NAME + "Creation Status=" + creatingTables);
					}
				}
			} else if (topologyType.equals(TopologyTypesIF.ANGLE_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveAngularTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);

				List<TopologyInfoValue> topologyInfoValues = topologyRoutingServiceIF.retriveAngularTopologyForView();
				System.out.println(CLASS_NAME + METHOD_NAME + "Topology Information=" + noOfNodes);

				if (noOfNodes > 0 && topologyInfoValues.size() > 0 && topologyInfoValues != null) {

					boolean deleteFirstIfExist = deleteAllParameters(parameterType, topologyType);

					if (deleteFirstIfExist) {
						creatingTables = insertParameter(parameterType, noOfNodes, topologyInfoValues);
						System.out.println(CLASS_NAME + METHOD_NAME + "Creation Status=" + creatingTables);
					}
				}
			} else if (topologyType.equals(TopologyTypesIF.SQUARE_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveSquareZoneTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);

				List<TopologyInfoValue> topologyInfoValues = topologyRoutingServiceIF.retriveSquareTopologyForView();
				System.out.println(CLASS_NAME + METHOD_NAME + "Topology Information=" + noOfNodes);

				if (noOfNodes > 0 && topologyInfoValues.size() > 0 && topologyInfoValues != null) {

					boolean deleteFirstIfExist = deleteAllParameters(parameterType, topologyType);

					if (deleteFirstIfExist) {
						creatingTables = insertParameter(parameterType, noOfNodes, topologyInfoValues);
						System.out.println(CLASS_NAME + METHOD_NAME + "Creation Status=" + creatingTables);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + EXCEPTION + "insertAllParameters" + e.getMessage());
		}
		return creatingTables;
	}

	@Override
	public boolean updateParameter(String parameterType, int nodeIdToUpdate, TopologyInfoValue topologyInfoValue) {
		boolean updationFlag = false;
		if (parameterType.equals(ParametersTypeIF.BUFFER)) {
			updationFlag = bufferParametersDAOIF.updateBuffer(BUFFER_NODE + Integer.toString(nodeIdToUpdate),
					topologyInfoValue.getNodeParameters().getBuffer());
		} else if (parameterType.equals(ParametersTypeIF.ENERGY)) {
			updationFlag = energyParametersDAOIF.insertEnergy(ENERGY_NODE + Integer.toString(nodeIdToUpdate),
					topologyInfoValue.getNodeParameters().getEnergy());

		} else if (parameterType.equals(ParametersTypeIF.POWER)) {
			updationFlag = powerParametersDAOIF.insertPower(POWER_NODE + Integer.toString(nodeIdToUpdate),
					topologyInfoValue.getNodeParameters().getPowerConsumed());
		} else if (parameterType.equals(ParametersTypeIF.TRUST)) {
			updationFlag = trustParameterDAOIF.insertTrust(TRUST_NODE + Integer.toString(nodeIdToUpdate),
					topologyInfoValue.getNodeParameters().getTrustLevel());
		} else if (parameterType.equals(ParametersTypeIF.NETWORKCOST)) {
			updationFlag = networkCostParametersDAOIF.insertNetworkCost(
					NETWORKCOST_NODE + Integer.toString(nodeIdToUpdate),
					topologyInfoValue.getNodeParameters().getTrustLevel());
		} else if (parameterType.equals(ParametersTypeIF.SIGNALSTRENGTH)) {
			updationFlag = signalStrengthDAOIF.insertSignalStrength(
					SIGNALSTRENGTH_NODE + Integer.toString(nodeIdToUpdate),
					topologyInfoValue.getNodeParameters().getSignalStrengthOfNode());
		}
		return updationFlag;
	}

	@Override
	public boolean dropAllTables(String parameterType, String topologyType) {
		boolean creatingTables = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "createParameterTables()" + START_NAME);
		System.out.println(CLASS_NAME + METHOD_NAME + "Topology Type=" + topologyType);

		try {
			if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveLinearTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);

				if (noOfNodes > 0) {
					creatingTables = dropTables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "Dropped Status=" + creatingTables);
				}

			} else if (topologyType.equals(TopologyTypesIF.GRID_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveGridTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);
				if (noOfNodes > 0) {
					creatingTables = dropTables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "Dropped Status=" + creatingTables);
				}
			} else if (topologyType.equals(TopologyTypesIF.VERTICAL_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveVerticalTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);
				if (noOfNodes > 0) {
					creatingTables = dropTables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "Dropped Status=" + creatingTables);
				}
			} else if (topologyType.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveRandomTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);
				if (noOfNodes > 0) {
					creatingTables = dropTables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "Dropped Status=" + creatingTables);
				}
			} else if (topologyType.equals(TopologyTypesIF.ANGLE_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveAngularTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);
				if (noOfNodes > 0) {
					creatingTables = dropTables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "Dropped Status=" + creatingTables);
				}
			} else if (topologyType.equals(TopologyTypesIF.SQUARE_TOPOLOGY)) {
				int noOfNodes = topologyRoutingServiceIF.retriveSquareZoneTopologyCount();
				System.out.println(CLASS_NAME + METHOD_NAME + "Count No of nodes=" + noOfNodes);
				if (noOfNodes > 0) {
					creatingTables = dropTables(parameterType, noOfNodes);
					System.out.println(CLASS_NAME + METHOD_NAME + "Dropped Status=" + creatingTables);
				}
			}
		} catch (Exception e) {

		}
		return creatingTables;
	}

	private boolean dropTables(String parameterType, int noOfNodes) {
		boolean creation = false;

		if (parameterType.equals(ParametersTypeIF.BUFFER)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = bufferParametersDAOIF.dropBufferTable(BUFFER_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.ENERGY)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = energyParametersDAOIF.dropEnergyTable(ENERGY_NODE + Integer.toString(nodeId));
				System.out.println("Dropped table-->" + ENERGY_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.POWER)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = powerParametersDAOIF.dropPowerTable(POWER_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.TRUST)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = trustParameterDAOIF.dropTrustTable(TRUST_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.NETWORKCOST)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = networkCostParametersDAOIF.dropNetworkCostTable(NETWORKCOST_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.SIGNALSTRENGTH)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = signalStrengthDAOIF.dropSignalStrengthTable(SIGNALSTRENGTH_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		}
		return creation;
	}

	private boolean deleteTables(String parameterType, int noOfNodes) {
		boolean creation = false;

		if (parameterType.equals(ParametersTypeIF.BUFFER)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = bufferParametersDAOIF.deleteBuffer(BUFFER_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.ENERGY)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = energyParametersDAOIF.deleteEnergy(ENERGY_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.POWER)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = powerParametersDAOIF.deletePower(POWER_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.TRUST)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = trustParameterDAOIF.deleteTrust(TRUST_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.NETWORKCOST)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = networkCostParametersDAOIF.deleteNetworkCost(NETWORKCOST_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.EIGEN_TRUST)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = eigenParameterDAOIF.deleteEigenTrust(EIGENTRUST_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.DEMPSTER_TRUST)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = dempsterParameterDAOIF.deleteDempterTrust(DEMPTER_TRUST_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		} else if (parameterType.equals(ParametersTypeIF.SIGNALSTRENGTH)) {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				creation = signalStrengthDAOIF.deleteSignalStrength(SIGNALSTRENGTH_NODE + Integer.toString(nodeId));
				if (creation == false) {
					break;
				}
			}
		}
		return creation;
	}

	@Override
	public ParameterValue retriveParameter(String parameterType, int parameterNodeId) {
		ParameterValue parameterValue = new ParameterValue();
		if (parameterType.equals(ParametersTypeIF.BUFFER)) {
			int buffer = bufferParametersDAOIF.retriveBuffer(BUFFER_NODE + Integer.toString(parameterNodeId));
			parameterValue.setBuffer(buffer);
			return parameterValue;
		} else if (parameterType.equals(ParametersTypeIF.ENERGY)) {
			double energy = energyParametersDAOIF.retriveEnergy(ENERGY_NODE + Integer.toString(parameterNodeId));
			parameterValue.setEnergy(energy);
			return parameterValue;
		} else if (parameterType.equals(ParametersTypeIF.POWER)) {
			double power = powerParametersDAOIF.retrivePower(POWER_NODE + Integer.toString(parameterNodeId));
			parameterValue.setPower(power);
			return parameterValue;

		} else if (parameterType.equals(ParametersTypeIF.TRUST)) {
			int trustLevel = trustParameterDAOIF.retriveTrust(TRUST_NODE + Integer.toString(parameterNodeId));
			parameterValue.setTrustLevel(trustLevel);
			return parameterValue;
		} else if (parameterType.equals(ParametersTypeIF.NETWORKCOST)) {
			int networkCost = networkCostParametersDAOIF
					.retriveNetworkCost(NETWORKCOST_NODE + Integer.toString(parameterNodeId));
			parameterValue.setNetworkCost(networkCost);
			return parameterValue;
		} else if (parameterType.equals(ParametersTypeIF.EIGEN_TRUST)) {
			double eigenTrust = eigenParameterDAOIF
					.retriveEigenTrust(EIGENTRUST_NODE + Integer.toString(parameterNodeId));
			parameterValue.setEigenTrust(eigenTrust);
			return parameterValue;
		} else if (parameterType.equals(ParametersTypeIF.DEMPSTER_TRUST)) {
			double dempsterTrust = dempsterParameterDAOIF
					.retriveDempterTrust(DEMPTER_TRUST_NODE + Integer.toString(parameterNodeId));
			parameterValue.setDempsterTrust(dempsterTrust);
			return parameterValue;
		} else if (parameterType.equals(ParametersTypeIF.SIGNALSTRENGTH)) {
			double signalStrength = signalStrengthDAOIF
					.retriveSignalStrengthTable(SIGNALSTRENGTH_NODE + Integer.toString(parameterNodeId));
			parameterValue.setSignalStrength(signalStrength);
			return parameterValue;
		}
		return parameterValue;
	}

}
