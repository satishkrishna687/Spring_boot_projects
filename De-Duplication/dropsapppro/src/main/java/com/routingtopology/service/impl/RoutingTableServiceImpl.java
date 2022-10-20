package com.routingtopology.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routingtopology.constants.TopologyTypesIF;
import com.routingtopology.dao.impl.RoutingTableDAOImpl;
import com.routingtopology.service.inter.RoutingTableServiceIF;
import com.routingtopology.value.AngleBasedRoutingTable;
import com.routingtopology.value.ClusterHeads;
import com.routingtopology.value.NormalRoutingTable;
import com.routingtopology.value.TopologyInfoValue;
import com.routingtopology.value.VerticalRoutingTable;
import com.routingtopology.value.ZoneRoutingTable;


@Service
public class RoutingTableServiceImpl implements RoutingTableServiceIF {

	private static final String CLASS_NAME = "Class:RoutingTableServiceImpl-->";

	private static final String METHOD_N = "Method:";

	private static final String START_TAG = "Start";

	private static final String END_TAG = "End";

	private static final String EXCEPTION_TAG = "Exception";

	private static final String SPACE = " ";

	private static final String METHOD_NAME = "Method:";

	private static final String START = "Start";

	private static final String EXCEPTION = "Exception--->";

	private static final String END = "End";

	@Autowired
	private TopologyRoutingServiceImpl topologyRoutingServiceIF;

	@Autowired
	private RoutingTableDAOImpl routingTableDAOIF;

	@Override
	public boolean createTable(String topologyKey) {
		boolean createTableFlag = false;
		try {
			System.out.println(CLASS_NAME + METHOD_N + "createTable()" + START_TAG);
			if (topologyKey.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
				System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "topologyKey" + topologyKey);
				int count = topologyRoutingServiceIF.retriveLinearTopologyCount();
				System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "retriveLinearTopologyCount" + count);
				if (count > 0) {
					for (int nodeId = 1; nodeId <= count; nodeId++) {
						createTableFlag = routingTableDAOIF
								.dropTable(LINEAR_NODE_APPENDER_RT + Integer.toString(nodeId));
					}

					for (int nodeId = 1; nodeId <= count; nodeId++) {
						createTableFlag = routingTableDAOIF
								.createTable(LINEAR_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "creation sucess");
					createTableFlag = true;
					return createTableFlag;
				}
			} else if (topologyKey.equals(TopologyTypesIF.GRID_TOPOLOGY)) {
				System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "topologyKey" + topologyKey);
				int count = topologyRoutingServiceIF.retriveGridTopologyCount();
				System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "retriveGridTopologyCount" + count);
				if (count > 0) {
					for (int nodeId = 1; nodeId <= count; nodeId++) {
						createTableFlag = routingTableDAOIF.dropTable(GRID_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					for (int nodeId = 1; nodeId <= count; nodeId++) {
						createTableFlag = routingTableDAOIF
								.createTable(GRID_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "creation sucess");
					createTableFlag = true;
					return createTableFlag;
				}
			} else if (topologyKey.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {
				System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "topologyKey" + topologyKey);
				int count = topologyRoutingServiceIF.retriveRandomTopologyCount();
				System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "retriveRandomTopologyCount" + count);
				if (count > 0) {
					for (int nodeId = 1; nodeId <= count; nodeId++) {
						createTableFlag = routingTableDAOIF
								.dropTable(RANDOM_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					for (int nodeId = 1; nodeId <= count; nodeId++) {
						createTableFlag = routingTableDAOIF
								.createTable(RANDOM_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "creation sucess");
					createTableFlag = true;
					return createTableFlag;
				}
			} else if (topologyKey.equals(TopologyTypesIF.VERTICAL_TOPOLOGY)) {
				System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "topologyKey" + topologyKey);
				int count1 = topologyRoutingServiceIF.retriveVerticalTopologyCount();
				System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "retriveVerticalTopologyCount()" + count1);
				if (count1 > 0) {
					for (int nodeId = 1; nodeId <= count1; nodeId++) {
						createTableFlag = routingTableDAOIF
								.dropTable(VERTICAL_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					for (int nodeId = 1; nodeId <= count1; nodeId++) {
						createTableFlag = routingTableDAOIF
								.createTableVerticalBased(VERTICAL_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					createTableFlag = true;
					System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "creation sucess");
					return createTableFlag;
				}
			} else if (topologyKey.equals(TopologyTypesIF.SQUARE_TOPOLOGY)) {
				System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "topologyKey" + topologyKey);
				int count1 = topologyRoutingServiceIF.retriveSquareZoneTopologyCount();
				System.out
						.println(CLASS_NAME + METHOD_N + "createTable()" + "retriveSquareZoneTopologyCount()" + count1);
				if (count1 > 0) {
					for (int nodeId = 1; nodeId <= count1; nodeId++) {
						createTableFlag = routingTableDAOIF
								.dropTableZoneBased(SQUARE_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					for (int nodeId = 1; nodeId <= count1; nodeId++) {
						createTableFlag = routingTableDAOIF
								.createTableZoneBased(SQUARE_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "creation sucess");
					createTableFlag = true;
					return createTableFlag;
				}
			} else if (topologyKey.equals(TopologyTypesIF.ANGLE_TOPOLOGY)) {
				System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "topologyKey" + topologyKey);
				int count1 = topologyRoutingServiceIF.retriveAngularTopologyCount();
				System.out
						.println(CLASS_NAME + METHOD_N + "createTable()" + "retriveSquareZoneTopologyCount()" + count1);
				if (count1 > 0) {

					for (int nodeId = 1; nodeId <= count1; nodeId++) {
						createTableFlag = routingTableDAOIF
								.dropTableAngleBased(ANGLE_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					for (int nodeId = 1; nodeId <= count1; nodeId++) {
						createTableFlag = routingTableDAOIF
								.createTableAngleBased(ANGLE_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					createTableFlag = true;
					System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "creation sucess");
					return createTableFlag;
				}
			} else if (topologyKey.equals(TopologyTypesIF.LEEACH_TOPOLOGY)) {
				System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "topologyKey" + topologyKey);
				int count1 = topologyRoutingServiceIF.retriveSquareZoneTopologyCountLEEACH();
				System.out.println(
						CLASS_NAME + METHOD_N + "createTable()" + "retriveSquareZoneTopologyCountLEEACH()" + count1);
				if (count1 > 0) {
					for (int nodeId = 1; nodeId <= count1; nodeId++) {
						createTableFlag = routingTableDAOIF
								.createTableZoneBased(LEEACH_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					createTableFlag = true;
					System.out.println(CLASS_NAME + METHOD_N + "createTable()" + "creation sucess");
					return createTableFlag;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
			createTableFlag = false;
		}
		return createTableFlag;
	}

	@Override
	public boolean dropTable(String topologyType) {
		boolean dropTableFlag = false;
		try {
			if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
				int count = topologyRoutingServiceIF.retriveLinearTopologyCount();
				if (count > 0) {
					for (int nodeId = 1; nodeId <= count; nodeId++) {
						dropTableFlag = routingTableDAOIF
								.dropTable(SPACE + LINEAR_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					dropTableFlag = true;
				}
				return dropTableFlag;
			} else if (topologyType.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {
				int count = topologyRoutingServiceIF.retriveRandomTopologyCount();
				if (count > 0) {
					for (int nodeId = 1; nodeId <= count; nodeId++) {
						dropTableFlag = routingTableDAOIF
								.dropTable(SPACE + RANDOM_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					dropTableFlag = true;
				}
				return dropTableFlag;
			} else if (topologyType.equals(TopologyTypesIF.VERTICAL_TOPOLOGY)) {
				int count = topologyRoutingServiceIF.retriveVerticalTopologyCount();
				if (count > 0) {
					for (int nodeId = 1; nodeId <= count; nodeId++) {
						dropTableFlag = routingTableDAOIF
								.dropTable(SPACE + VERTICAL_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					dropTableFlag = true;
				}
				return dropTableFlag;
			} else if (topologyType.equals(TopologyTypesIF.GRID_TOPOLOGY)) {
				int count = topologyRoutingServiceIF.retriveGridTopologyCount();
				if (count > 0) {
					for (int nodeId = 1; nodeId <= count; nodeId++) {
						dropTableFlag = routingTableDAOIF
								.dropTable(SPACE + GRID_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					dropTableFlag = true;
				}
				return dropTableFlag;
			} else if (topologyType.equals(TopologyTypesIF.SQUARE_TOPOLOGY)) {
				int count = topologyRoutingServiceIF.retriveSquareZoneTopologyCount();
				if (count > 0) {
					for (int nodeId = 1; nodeId <= count; nodeId++) {
						dropTableFlag = routingTableDAOIF
								.dropTableZoneBased(SPACE + SQUARE_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					dropTableFlag = true;
				}
			} else if (topologyType.equals(TopologyTypesIF.ANGLE_TOPOLOGY)) {
				int count = topologyRoutingServiceIF.retriveAngularTopologyCount();
				if (count > 0) {
					for (int nodeId = 1; nodeId <= count; nodeId++) {
						dropTableFlag = routingTableDAOIF
								.dropTableZoneBased(SPACE + ANGLE_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					dropTableFlag = true;
				}
				return dropTableFlag;
			} else if (topologyType.equals(TopologyTypesIF.LEEACH_TOPOLOGY)) {
				int count = topologyRoutingServiceIF.retriveSquareZoneTopologyCountLEEACH();
				if (count > 0) {
					for (int nodeId = 1; nodeId <= count; nodeId++) {
						dropTableFlag = routingTableDAOIF
								.dropTableZoneBased(SPACE + LEEACH_NODE_APPENDER_RT + Integer.toString(nodeId));
					}
					dropTableFlag = true;
				}
				return dropTableFlag;
			}
		} catch (Exception e) {
			System.out.println("Exception is=" + e.getMessage());
		}
		return dropTableFlag;
	}

	@Override
	public boolean insertRoutingTable(String topologyType) {
		boolean insertRoutingTableFlag = false;
		try {
			if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
				int count = topologyRoutingServiceIF.retriveLinearTopologyCount();
				if (count > 0) {
					List<TopologyInfoValue> linearTopology = topologyRoutingServiceIF.retriveLinearTopologyForView();
					for (int nodeIdIndex = 1; nodeIdIndex <= count; nodeIdIndex++) {
						int nodeCurrentXCor = linearTopology.get(nodeIdIndex - 1).getNodeCoordiante().getX_cor();
						int nodeCurrentYCor = linearTopology.get(nodeIdIndex - 1).getNodeCoordiante().getY_cor();
						for (TopologyInfoValue topologyInfoValue : linearTopology) {
							int nodeId = topologyInfoValue.getNodeId();
							int xCor = topologyInfoValue.getNodeCoordiante().getX_cor();
							int yCor = topologyInfoValue.getNodeCoordiante().getY_cor();
							double distance = calculateDistance(nodeCurrentXCor, xCor, nodeCurrentYCor, yCor);

							NormalRoutingTable normalRoutingTable = new NormalRoutingTable();
							normalRoutingTable.setNodeId(nodeId);
							normalRoutingTable.setDistance(distance);
							insertRoutingTableFlag = routingTableDAOIF.insertRoutingTable(normalRoutingTable,
									SPACE + LINEAR_NODE_APPENDER_RT + Integer.toString(nodeIdIndex));
							if (insertRoutingTableFlag == false) {
								return insertRoutingTableFlag;
							}
						}
					}
					insertRoutingTableFlag = true;
				}
			} else if (topologyType.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {
				int count = topologyRoutingServiceIF.retriveRandomTopologyCount();
				if (count > 0) {
					List<TopologyInfoValue> linearTopology = topologyRoutingServiceIF.retriveRandomTopologyForView();
					for (int nodeIdIndex = 1; nodeIdIndex <= count; nodeIdIndex++) {
						int nodeCurrentXCor = linearTopology.get(nodeIdIndex - 1).getNodeCoordiante().getX_cor();
						int nodeCurrentYCor = linearTopology.get(nodeIdIndex - 1).getNodeCoordiante().getY_cor();
						for (TopologyInfoValue topologyInfoValue : linearTopology) {
							int nodeId = topologyInfoValue.getNodeId();
							int xCor = topologyInfoValue.getNodeCoordiante().getX_cor();
							int yCor = topologyInfoValue.getNodeCoordiante().getY_cor();
							double distance = calculateDistance(nodeCurrentXCor, xCor, nodeCurrentYCor, yCor);

							NormalRoutingTable normalRoutingTable = new NormalRoutingTable();
							normalRoutingTable.setNodeId(nodeId);
							normalRoutingTable.setDistance(distance);
							insertRoutingTableFlag = routingTableDAOIF.insertRoutingTable(normalRoutingTable,
									SPACE + RANDOM_NODE_APPENDER_RT + Integer.toString(nodeIdIndex));
							if (insertRoutingTableFlag == false) {
								return insertRoutingTableFlag;
							}
						}
					}
					insertRoutingTableFlag = true;
				}
			} else if (topologyType.equals(TopologyTypesIF.GRID_TOPOLOGY)) {
				int count = topologyRoutingServiceIF.retriveGridTopologyCount();
				if (count > 0) {
					List<TopologyInfoValue> linearTopology = topologyRoutingServiceIF.retriveGridTopologyForView();
					for (int nodeIdIndex = 1; nodeIdIndex <= count; nodeIdIndex++) {
						int nodeCurrentXCor = linearTopology.get(nodeIdIndex - 1).getNodeCoordiante().getX_cor();
						int nodeCurrentYCor = linearTopology.get(nodeIdIndex - 1).getNodeCoordiante().getY_cor();
						for (TopologyInfoValue topologyInfoValue : linearTopology) {
							int nodeId = topologyInfoValue.getNodeId();
							int xCor = topologyInfoValue.getNodeCoordiante().getX_cor();
							int yCor = topologyInfoValue.getNodeCoordiante().getY_cor();
							double distance = calculateDistance(nodeCurrentXCor, xCor, nodeCurrentYCor, yCor);
							NormalRoutingTable normalRoutingTable = new NormalRoutingTable();
							normalRoutingTable.setNodeId(nodeId);
							normalRoutingTable.setDistance(distance);
							insertRoutingTableFlag = routingTableDAOIF.insertRoutingTable(normalRoutingTable,
									SPACE + GRID_NODE_APPENDER_RT + Integer.toString(nodeIdIndex));
							if (insertRoutingTableFlag == false) {
								return insertRoutingTableFlag;
							}
						}
					}
					insertRoutingTableFlag = true;
				}
			} else if (topologyType.equals(TopologyTypesIF.VERTICAL_TOPOLOGY)) {
				int count = topologyRoutingServiceIF.retriveVerticalTopologyCount();
				if (count > 0) {
					List<TopologyInfoValue> linearTopology = topologyRoutingServiceIF.retriveVerticalTopologyForView();
					for (int nodeIdIndex = 1; nodeIdIndex <= count; nodeIdIndex++) {
						int nodeCurrentXCor = linearTopology.get(nodeIdIndex - 1).getNodeCoordiante().getX_cor();
						int nodeCurrentYCor = linearTopology.get(nodeIdIndex - 1).getNodeCoordiante().getY_cor();
						for (TopologyInfoValue topologyInfoValue : linearTopology) {
							int nodeId = topologyInfoValue.getNodeId();
							int xCor = topologyInfoValue.getNodeCoordiante().getX_cor();
							int yCor = topologyInfoValue.getNodeCoordiante().getY_cor();
							double distance = calculateDistance(nodeCurrentXCor, xCor, nodeCurrentYCor, yCor);
							int verticalBelong = topologyInfoValue.getNodeParameters().getVerticalBelong();
							VerticalRoutingTable normalRoutingTable = new VerticalRoutingTable();
							normalRoutingTable.setNodeId(nodeId);
							normalRoutingTable.setDistance(distance);
							normalRoutingTable.setVerticalBelong(verticalBelong);
							insertRoutingTableFlag = routingTableDAOIF.insertVerticalRoutingTable(normalRoutingTable,
									SPACE + VERTICAL_NODE_APPENDER_RT + Integer.toString(nodeIdIndex));
							if (insertRoutingTableFlag == false) {
								return insertRoutingTableFlag;
							}
						}
					}
					insertRoutingTableFlag = true;
				}
			}

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return insertRoutingTableFlag;
	}

	private double calculateDistance(int nodeCurrentXCor, int xCor, int nodeCurrentYCor, int yCor) {
		double xValue = xCor - nodeCurrentXCor;
		double yValue = yCor - nodeCurrentYCor;
		double xValueSquare = Math.pow(xValue, 2);
		double yValueSquare = Math.pow(yValue, 2);
		double summer = xValueSquare + yValueSquare;
		double distance = Math.sqrt(summer);
		return distance;
	}

	@Override
	public boolean insertRoutingTableAngleBased() {
		boolean insertRoutingTableAngleFlag = false;
		try {
			int count = topologyRoutingServiceIF.retriveAngularTopologyCount();
			if (count > 0) {
				List<TopologyInfoValue> angularTopology = topologyRoutingServiceIF.retriveAngularTopologyForView();
				for (int nodeIdIndex = 1; nodeIdIndex < count; nodeIdIndex++) {
					for (TopologyInfoValue topologyInfoValue : angularTopology) {
						int nodeId = topologyInfoValue.getNodeId();
						AngleBasedRoutingTable angleRoutingTable = new AngleBasedRoutingTable();
						angleRoutingTable.setNodeId(nodeId);
						angleRoutingTable.setAngularPos(topologyInfoValue.getNodeParameters().getAngularPos());
						angleRoutingTable.setCloseToObs(topologyInfoValue.getNodeParameters().getCloseObstracle());
						angleRoutingTable.setZoneId(topologyInfoValue.getNodeParameters().getAngularRegion());
						angleRoutingTable.setZoneLeader(topologyInfoValue.getLeaderInfo().isLeader());
						insertRoutingTableAngleFlag = routingTableDAOIF.insertRoutingTableAngleBased(angleRoutingTable,
								SPACE + ANGLE_NODE_APPENDER_RT + Integer.toString(nodeIdIndex));
						// Now deleting the entries of other nodes
						if (insertRoutingTableAngleFlag == false) {
							return insertRoutingTableAngleFlag;
						}
					}
				}
				// Now deleting the entries of other nodes
				insertRoutingTableAngleFlag = deleteRoutingTableEntriesUsingAngularLogic(count);
				insertRoutingTableAngleFlag = true;
			}

		} catch (Exception e) {
			System.out.println(
					CLASS_NAME + METHOD_NAME + "insertRoutingTableAngleBased()" + "Exception" + e.getMessage());
		}
		return insertRoutingTableAngleFlag;
	}

	private boolean deleteRoutingTableEntriesUsingAngularLogic(int count) {

		System.out.println(CLASS_NAME + METHOD_NAME + "deleteRoutingTables()--->" + START);
		boolean deleteRoutingTable = false;
		try {
			for (int nodeId = 1; nodeId <= count; nodeId++) {
				System.out.println("nodeId=" + nodeId);
				int zoneIdOfNode = routingTableDAOIF
						.retriveZoneIdBasedOnNodeId(ANGLE_NODE_APPENDER_RT + Integer.toString(nodeId), nodeId);
				System.out.println("Zone Id of Node=" + zoneIdOfNode);

				if (zoneIdOfNode >= 0) {
					int zoneLeader = routingTableDAOIF
							.retriveZoneLeaderBasedOnNodeId(ANGLE_NODE_APPENDER_RT + Integer.toString(nodeId), nodeId);
					System.out.println("ZONE LEADER=" + zoneLeader);

					if (zoneLeader == 0) {
						System.out.println("NOT ZONE LEADER");
						System.out.println("ZONE ID=" + zoneIdOfNode);
						System.out.println("table name" + ANGLE_NODE_APPENDER_RT + Integer.toString(nodeId));
						routingTableDAOIF.deleteUnwantedNodeIds(ANGLE_NODE_APPENDER_RT + Integer.toString(nodeId),
								zoneIdOfNode);
					} else if (zoneLeader == 1) {
						System.out.println("ZONE LEADER");
						System.out.println("ZONE ID=" + zoneIdOfNode);
						routingTableDAOIF.deleteUnwantedNodeIdsForZoneLeader(
								ANGLE_NODE_APPENDER_RT + Integer.toString(nodeId), zoneIdOfNode, zoneLeader);
					}

				}
			}
			deleteRoutingTable = true;
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteRoutingTables()--->" + EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteRoutingTables()--->" + END);
		return deleteRoutingTable;
	}

	@Override
	public boolean insertRoutingTableZoneBased() {
		boolean insertRoutingTableFlag = false;
		try {

			int count = topologyRoutingServiceIF.retriveSquareZoneTopologyCount();
			for (int nodeId = 1; nodeId <= count; nodeId++) {
				deleteRoutingTable(TopologyTypesIF.SQUARE_TOPOLOGY, nodeId);
			}
			System.out.println("Count=" + count);
			if (count > 0) {
				List<TopologyInfoValue> linearTopology = topologyRoutingServiceIF.retriveSquareTopologyForView();
				for (int nodeIdIndex = 1; nodeIdIndex <= count; nodeIdIndex++) {

					System.out.println("NODE ID INDEX=" + nodeIdIndex);

					int nodeCurrentXCor = linearTopology.get(nodeIdIndex - 1).getNodeCoordiante().getX_cor();
					int nodeCurrentYCor = linearTopology.get(nodeIdIndex - 1).getNodeCoordiante().getY_cor();
					for (TopologyInfoValue topologyInfoValue : linearTopology) {
						int nodeId = topologyInfoValue.getNodeId();
						int xCor = topologyInfoValue.getNodeCoordiante().getX_cor();
						int yCor = topologyInfoValue.getNodeCoordiante().getY_cor();
						double distance = calculateDistance(nodeCurrentXCor, xCor, nodeCurrentYCor, yCor);

						ZoneRoutingTable zoneRoutingTable = new ZoneRoutingTable();
						zoneRoutingTable.setNodeId(nodeId);
						zoneRoutingTable.setDistance(distance);
						zoneRoutingTable.setZoneId(topologyInfoValue.getNodeParameters().getZoneId());
						System.out.println("Zone Id=" + topologyInfoValue.getNodeParameters().getZoneId());
						zoneRoutingTable.setZoneLeader(topologyInfoValue.getLeaderInfo().isLeader());

						insertRoutingTableFlag = routingTableDAOIF.insertRoutingTableZoneBased(zoneRoutingTable,
								SPACE + SQUARE_NODE_APPENDER_RT + Integer.toString(nodeIdIndex));

					}
				}

				insertRoutingTableFlag = deleteRoutingTableEntriesUsingLogic(count);
				if (insertRoutingTableFlag == false) {
					return insertRoutingTableFlag;
				}

				insertRoutingTableFlag = true;
			}
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return insertRoutingTableFlag;
	}

	private boolean deleteRoutingTableEntriesUsingLogicLEEACH(int noOfNodes) {
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteRoutingTables()--->" + START);
		boolean deleteRoutingTable = false;
		try {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				System.out.println("nodeId=" + nodeId);
				int zoneIdOfNode = routingTableDAOIF
						.retriveZoneIdBasedOnNodeId(LEEACH_NODE_APPENDER_RT + Integer.toString(nodeId), nodeId);
				System.out.println("Zone Id of Node=" + zoneIdOfNode);

				if (zoneIdOfNode > 0) {
					int zoneLeader = routingTableDAOIF
							.retriveZoneLeaderBasedOnNodeId(LEEACH_NODE_APPENDER_RT + Integer.toString(nodeId), nodeId);
					System.out.println("ZONE LEADER=" + zoneLeader);
					routingTableDAOIF.deleteUnwantedNodeIds(LEEACH_NODE_APPENDER_RT + Integer.toString(nodeId),
							zoneIdOfNode);

				}
			}
			deleteRoutingTable = true;
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteRoutingTables()--->" + EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteRoutingTables()--->" + END);
		return deleteRoutingTable;
	}

	private boolean deleteRoutingTableEntriesUsingLogic(int noOfNodes) {
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteRoutingTables()--->" + START);
		boolean deleteRoutingTable = false;
		try {
			for (int nodeId = 1; nodeId <= noOfNodes; nodeId++) {
				System.out.println("nodeId=" + nodeId);
				int zoneIdOfNode = routingTableDAOIF
						.retriveZoneIdBasedOnNodeId(SQUARE_NODE_APPENDER_RT + Integer.toString(nodeId), nodeId);
				System.out.println("Zone Id of Node=" + zoneIdOfNode);

				if (zoneIdOfNode > 0) {
					int zoneLeader = routingTableDAOIF
							.retriveZoneLeaderBasedOnNodeId(SQUARE_NODE_APPENDER_RT + Integer.toString(nodeId), nodeId);
					System.out.println("ZONE LEADER=" + zoneLeader);

					if (zoneLeader == 0) {
						System.out.println("NOT ZONE LEADER");
						System.out.println("ZONE ID=" + zoneIdOfNode);
						System.out.println("table name" + SQUARE_NODE_APPENDER_RT + Integer.toString(nodeId));
						routingTableDAOIF.deleteUnwantedNodeIds(SQUARE_NODE_APPENDER_RT + Integer.toString(nodeId),
								zoneIdOfNode);
					} else if (zoneLeader == 1) {
						System.out.println("ZONE LEADER");
						System.out.println("ZONE ID=" + zoneIdOfNode);
						routingTableDAOIF.deleteUnwantedNodeIdsForZoneLeader(
								SQUARE_NODE_APPENDER_RT + Integer.toString(nodeId), zoneIdOfNode, zoneLeader);
					}

				}
			}
			deleteRoutingTable = true;
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteRoutingTables()--->" + EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteRoutingTables()--->" + END);
		return deleteRoutingTable;
	}

	@Override
	public List<NormalRoutingTable> retriveNormalRoutingTables(int nodeId, String topologyType) {

		System.out.println(CLASS_NAME + METHOD_NAME + "retriveNormalRoutingTables()" + START);
		List<NormalRoutingTable> normalRoutingTableList = null;
		try {
			if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
				System.out.println(
						CLASS_NAME + METHOD_NAME + "retriveNormalRoutingTables()" + TopologyTypesIF.LINEAR_TOPOLOGY);
				normalRoutingTableList = routingTableDAOIF
						.retriveNormalRoutingTables(SPACE + LINEAR_NODE_APPENDER_RT + Integer.toString(nodeId));
				System.out.println(CLASS_NAME + METHOD_NAME + "retriveNormalRoutingTables() Size="
						+ normalRoutingTableList.size());

			} else if (topologyType.equals(TopologyTypesIF.GRID_TOPOLOGY)) {
				System.out.println(
						CLASS_NAME + METHOD_NAME + "retriveNormalRoutingTables()" + TopologyTypesIF.GRID_TOPOLOGY);
				normalRoutingTableList = routingTableDAOIF
						.retriveNormalRoutingTables(SPACE + GRID_NODE_APPENDER_RT + Integer.toString(nodeId));
				System.out.println(CLASS_NAME + METHOD_NAME + "retriveNormalRoutingTables() Size="
						+ normalRoutingTableList.size());
			} else if (topologyType.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {
				System.out.println(
						CLASS_NAME + METHOD_NAME + "retriveNormalRoutingTables()" + TopologyTypesIF.RANDOM_TOPOLOGY);
				normalRoutingTableList = routingTableDAOIF
						.retriveNormalRoutingTables(SPACE + RANDOM_NODE_APPENDER_RT + Integer.toString(nodeId));
				System.out.println(CLASS_NAME + METHOD_NAME + "retriveNormalRoutingTables() Size="
						+ normalRoutingTableList.size());
			}
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "retriveNormalRoutingTables()" + EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveNormalRoutingTables()" + END);
		return normalRoutingTableList;
	}

	@Override
	public List<AngleBasedRoutingTable> retriveAngleBasedRoutingTables(int nodeId) {
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveAngleBasedRoutingTables()" + START);
		List<AngleBasedRoutingTable> angleRoutingTableList = null;
		try {
			System.out.println(
					CLASS_NAME + METHOD_NAME + "retriveNormalRoutingTables()" + TopologyTypesIF.ANGLE_TOPOLOGY);
			angleRoutingTableList = routingTableDAOIF
					.retriveAngleBasedRoutingTables(SPACE + ANGLE_NODE_APPENDER_RT + Integer.toString(nodeId));
			System.out.println(
					CLASS_NAME + METHOD_NAME + "retriveAngleBasedRoutingTables() Size=" + angleRoutingTableList.size());

		} catch (Exception e) {
			System.out.println(
					CLASS_NAME + METHOD_NAME + "retriveAngleBasedRoutingTables()" + EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveAngleBasedRoutingTables()" + END);
		return angleRoutingTableList;
	}

	@Override
	public List<ZoneRoutingTable> retriveZoneBasedRoutingTables(int nodeId) {
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveZoneBasedRoutingTables()" + START);
		List<ZoneRoutingTable> zoneRoutingTableList = null;
		try {
			System.out.println(
					CLASS_NAME + METHOD_NAME + "retriveZoneBasedRoutingTables()" + TopologyTypesIF.SQUARE_TOPOLOGY);
			zoneRoutingTableList = routingTableDAOIF
					.retriveZoneBasedRoutingTables(SPACE + SQUARE_NODE_APPENDER_RT + Integer.toString(nodeId));
			System.out.println(
					CLASS_NAME + METHOD_NAME + "retriveZoneBasedRoutingTables() Size=" + zoneRoutingTableList.size());

		} catch (Exception e) {
			System.out
					.println(CLASS_NAME + METHOD_NAME + "retriveZoneBasedRoutingTables()" + EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveZoneBasedRoutingTables()" + END);
		return zoneRoutingTableList;
	}

	@Override
	public List<ZoneRoutingTable> retriveZoneBasedRoutingTablesForLEEACH(int nodeId) {
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveZoneBasedRoutingTables()" + START);
		List<ZoneRoutingTable> zoneRoutingTableList = null;
		try {
			System.out.println(
					CLASS_NAME + METHOD_NAME + "retriveZoneBasedRoutingTables()" + TopologyTypesIF.LEEACH_TOPOLOGY);
			zoneRoutingTableList = routingTableDAOIF
					.retriveZoneBasedRoutingTables(SPACE + LEEACH_NODE_APPENDER_RT + Integer.toString(nodeId));
			System.out.println(
					CLASS_NAME + METHOD_NAME + "retriveZoneBasedRoutingTables() Size=" + zoneRoutingTableList.size());

		} catch (Exception e) {
			System.out
					.println(CLASS_NAME + METHOD_NAME + "retriveZoneBasedRoutingTables()" + EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveZoneBasedRoutingTables()" + END);
		return zoneRoutingTableList;
	}

	@Override
	public boolean updateRoutingTable(NormalRoutingTable normalRoutingTable, int nodeIdOfRoutingTable,
			String topologyType) {
		boolean updateFlag = false;
		try {
			System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTable()" + START);
			if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
				System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTable()" + TopologyTypesIF.LINEAR_TOPOLOGY);
				updateFlag = routingTableDAOIF.updateRoutingTable(normalRoutingTable,
						SPACE + LINEAR_NODE_APPENDER_RT + Integer.toString(nodeIdOfRoutingTable));
				System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTable()" + "updateFlag" + updateFlag);
				return updateFlag;
			} else if (topologyType.equals(TopologyTypesIF.GRID_TOPOLOGY)) {
				System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTable()" + TopologyTypesIF.GRID_TOPOLOGY);
				updateFlag = routingTableDAOIF.updateRoutingTable(normalRoutingTable,
						SPACE + GRID_NODE_APPENDER_RT + Integer.toString(nodeIdOfRoutingTable));
				System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTable()" + "updateFlag" + updateFlag);
				return updateFlag;
			} else if (topologyType.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {
				System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTable()" + TopologyTypesIF.RANDOM_TOPOLOGY);
				updateFlag = routingTableDAOIF.updateRoutingTable(normalRoutingTable,
						SPACE + RANDOM_NODE_APPENDER_RT + Integer.toString(nodeIdOfRoutingTable));
				System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTable()" + "updateFlag" + updateFlag);
				return updateFlag;
			}
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTable()" + e.getMessage());
			updateFlag = false;
		}

		return updateFlag;
	}

	@Override
	public boolean updateRoutingTableAngleBased(AngleBasedRoutingTable angleRoutingTable, int routingTableNodeId) {
		boolean updateFlag = false;
		try {
			System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTableAngleBased()" + START);
			updateFlag = routingTableDAOIF.updateRoutingTableAngleBased(angleRoutingTable,
					SPACE + ANGLE_NODE_APPENDER_RT + Integer.toString(routingTableNodeId));
			System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTableAngleBased()" + "updateFlag" + updateFlag);
			return updateFlag;
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTableAngleBased()" + e.getMessage());
			updateFlag = false;
		}
		return updateFlag;
	}

	@Override
	public boolean updateRoutingTableZoneBased(ZoneRoutingTable zoneRoutingTable, int routingTableNodeId) {
		boolean updateFlag = false;
		try {
			System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTableZoneBased()" + START);
			updateFlag = routingTableDAOIF.updateRoutingTableZoneBased(zoneRoutingTable,
					SPACE + SQUARE_NODE_APPENDER_RT + Integer.toString(routingTableNodeId));
			System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTableZoneBased()" + "updateFlag" + updateFlag);
			return updateFlag;
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTableZoneBased()" + e.getMessage());
			updateFlag = false;
		}
		return updateFlag;
	}

	@Override
	public boolean updateRoutingTableZoneBasedLEEACH(ZoneRoutingTable zoneRoutingTable, int routingTableNodeId) {
		boolean updateFlag = false;
		try {
			System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTableZoneBasedLEEACH()" + START);
			updateFlag = routingTableDAOIF.updateRoutingTableZoneBased(zoneRoutingTable,
					SPACE + LEEACH_NODE_APPENDER_RT + Integer.toString(routingTableNodeId));
			System.out.println(
					CLASS_NAME + METHOD_NAME + "updateRoutingTableZoneBasedLEEACH()" + "updateFlag" + updateFlag);
			return updateFlag;
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTableZoneBasedLEEACH()" + e.getMessage());
			updateFlag = false;
		}
		return updateFlag;
	}

	@Override
	public List<VerticalRoutingTable> retriveVerticalRoutingTables(int nodeId) {
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveVerticalRoutingTables()" + START);
		List<VerticalRoutingTable> angleRoutingTableList = null;
		try {
			System.out.println(
					CLASS_NAME + METHOD_NAME + "retriveNormalRoutingTables()" + TopologyTypesIF.ANGLE_TOPOLOGY);
			angleRoutingTableList = routingTableDAOIF
					.retriveVerticalRoutingTables(SPACE + VERTICAL_NODE_APPENDER_RT + Integer.toString(nodeId));
			System.out.println(
					CLASS_NAME + METHOD_NAME + "retriveVerticalRoutingTables() Size=" + angleRoutingTableList.size());

		} catch (Exception e) {
			System.out
					.println(CLASS_NAME + METHOD_NAME + "retriveVerticalRoutingTables()" + EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveVerticalRoutingTables()" + END);
		return angleRoutingTableList;
	}

	@Override
	public boolean updateRoutingTableVerticalBased(VerticalRoutingTable verticalRoutingTable, int routingTableNodeId) {
		boolean updateFlag = false;
		try {
			System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTableVerticalBased()" + START);
			updateFlag = routingTableDAOIF.updateVerticalRoutingTable(verticalRoutingTable,
					SPACE + VERTICAL_NODE_APPENDER_RT + Integer.toString(routingTableNodeId));
			System.out.println(
					CLASS_NAME + METHOD_NAME + "updateRoutingTableVerticalBased()" + "updateFlag" + updateFlag);
			return updateFlag;
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTableVerticalBased()" + e.getMessage());
			updateFlag = false;
		}
		return updateFlag;
	}

	@Override
	public boolean deleteRoutingTable(String topologyType, int nodeIdRoutingTable) {
		boolean deleteFlag = false;
		try {
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteRoutingTable()" + START);

			if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
				deleteFlag = routingTableDAOIF
						.deleteRoutingTable(LINEAR_NODE_APPENDER_RT + Integer.toString(nodeIdRoutingTable));
			}
			if (topologyType.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {
				deleteFlag = routingTableDAOIF
						.deleteRoutingTable(RANDOM_NODE_APPENDER_RT + Integer.toString(nodeIdRoutingTable));
			}
			if (topologyType.equals(TopologyTypesIF.VERTICAL_TOPOLOGY)) {
				deleteFlag = routingTableDAOIF
						.deleteRoutingTable(VERTICAL_NODE_APPENDER_RT + Integer.toString(nodeIdRoutingTable));
			}
			if (topologyType.equals(TopologyTypesIF.SQUARE_TOPOLOGY)) {
				deleteFlag = routingTableDAOIF
						.deleteRoutingTable(SQUARE_NODE_APPENDER_RT + Integer.toString(nodeIdRoutingTable));
			}
			if (topologyType.equals(TopologyTypesIF.ANGLE_TOPOLOGY)) {
				deleteFlag = routingTableDAOIF
						.deleteRoutingTable(ANGLE_NODE_APPENDER_RT + Integer.toString(nodeIdRoutingTable));
			}
			if (topologyType.equals(TopologyTypesIF.GRID_TOPOLOGY)) {
				deleteFlag = routingTableDAOIF
						.deleteRoutingTable(GRID_NODE_APPENDER_RT + Integer.toString(nodeIdRoutingTable));
			}
			if (topologyType.equals(TopologyTypesIF.LEEACH_TOPOLOGY)) {
				deleteFlag = routingTableDAOIF
						.deleteRoutingTable(LEEACH_NODE_APPENDER_RT + Integer.toString(nodeIdRoutingTable));
			}
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteRoutingTable()" + "updateFlag" + deleteFlag);
			return deleteFlag;
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteRoutingTable()" + e.getMessage());
			deleteFlag = false;
		}
		return deleteFlag;

	}

	@Override
	public List<Integer> getNeigbours(String topologyType, int nodeId, double coverageDistance) {

		System.out.println(CLASS_NAME + METHOD_NAME + "getNeigbours()" + START);
		List<Integer> neigboursList = null;
		try {
			if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
				System.out.println(CLASS_NAME + METHOD_NAME + "getNeigbours()" + TopologyTypesIF.LINEAR_TOPOLOGY);
				neigboursList = routingTableDAOIF
						.getNeigbours(SPACE + LINEAR_NODE_APPENDER_RT + Integer.toString(nodeId), coverageDistance);
				System.out.println(CLASS_NAME + METHOD_NAME + "getNeigbours() Size=" + neigboursList.size());

			} else if (topologyType.equals(TopologyTypesIF.GRID_TOPOLOGY)) {
				System.out.println(CLASS_NAME + METHOD_NAME + "getNeigbours()" + TopologyTypesIF.GRID_TOPOLOGY);
				neigboursList = routingTableDAOIF.getNeigbours(SPACE + GRID_NODE_APPENDER_RT + Integer.toString(nodeId),
						coverageDistance);
				System.out.println(CLASS_NAME + METHOD_NAME + "getNeigbours() Size=" + neigboursList.size());
			} else if (topologyType.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {
				System.out.println(
						CLASS_NAME + METHOD_NAME + "retriveNormalRoutingTables()" + TopologyTypesIF.RANDOM_TOPOLOGY);
				neigboursList = routingTableDAOIF
						.getNeigbours(SPACE + RANDOM_NODE_APPENDER_RT + Integer.toString(nodeId), coverageDistance);
				System.out.println(CLASS_NAME + METHOD_NAME + "getNeigbours() Size=" + neigboursList.size());
			}
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "getNeigbours()" + EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "getNeigbours()" + END);
		return neigboursList;
	}

	@Override
	public int retriveZoneIdBasedOnNodeId(int nodeId) {
		int zoneLeader = 0;
		try {
			zoneLeader = routingTableDAOIF
					.retriveZoneIdBasedOnNodeId(SQUARE_NODE_APPENDER_RT + Integer.toString(nodeId), nodeId);

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return zoneLeader;
	}

	@Override
	public int issourceNodeZoneLeader(int sourceNode) {
		int zoneLeader = 0;
		try {
			zoneLeader = routingTableDAOIF
					.retriveZoneLeaderBasedOnNodeId(SQUARE_NODE_APPENDER_RT + Integer.toString(sourceNode), sourceNode);

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return zoneLeader;
	}

	@Override
	public int retriveZoneLeaderOfNode(int sourceNode, int zoneId) {
		int zoneLeader = 0;
		try {
			zoneLeader = routingTableDAOIF.findZoneLeaderOfZone(SQUARE_NODE_APPENDER_RT + Integer.toString(sourceNode),
					zoneId, ZONE_LEADER_FLAG);

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return zoneLeader;
	}

	@Override
	public List<ClusterHeads> getClusterHeadsOfAllZones(int zoneId, int zoneLeaderOfSourceNode) {
		List<ClusterHeads> clusterHeads = null;
		try {
			clusterHeads = routingTableDAOIF.retriveClusterHeads(
					SQUARE_NODE_APPENDER_RT + Integer.toString(zoneLeaderOfSourceNode), zoneId, ZONE_LEADER_FLAG);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return clusterHeads;
	}

	@Override
	public List<Integer> retriveNodesInZone(int sourceNode) {

		List<Integer> nodesInZone = null;
		try {
			nodesInZone = routingTableDAOIF.retriveNodesInZone(SQUARE_NODE_APPENDER_RT + Integer.toString(sourceNode),
					sourceNode);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return nodesInZone;

	}

	@Override
	public List<Integer> retriveNodesInZoneUsingZoneLeader(ClusterHeads clusterHead) {
		List<Integer> nodesInZone = null;
		try {
			nodesInZone = routingTableDAOIF.retriveNodesInZoneUsingZoneLeaderAndZoneId(
					SQUARE_NODE_APPENDER_RT + Integer.toString(clusterHead.getNodeId()), clusterHead.getZoneId(),
					clusterHead.getNodeId());
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return nodesInZone;
	}

	@Override
	public List<Integer> obtainNodesApartFromZoneLeaderAndDestNode(int zoneId, int zoneLeaderNode,
			int destinationNode) {

		List<Integer> nodesInZone = null;
		try {
			nodesInZone = routingTableDAOIF.obtainNodesApartFromZoneLeaderAndDestNode(
					SQUARE_NODE_APPENDER_RT + Integer.toString(zoneLeaderNode), zoneId, zoneLeaderNode);
			if (nodesInZone != null) {
				int index = nodesInZone.indexOf(destinationNode);
				if (index >= 0) {
					nodesInZone.remove(index);
				}
			}

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return nodesInZone;

	}

	@Override
	public double distance(int nodeIdTableToLook, int nodeIdWhereClause, String topologyType) {
		System.out.println(CLASS_NAME + METHOD_NAME + "distance()" + START);
		double distance = 0.0;
		try {
			if (topologyType != null) {
				if (topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)) {
					distance = routingTableDAOIF.distanceBetweenNodes(
							LINEAR_NODE_APPENDER_RT + Integer.toString(nodeIdTableToLook), nodeIdWhereClause);
				} else if (topologyType.equals(TopologyTypesIF.RANDOM_TOPOLOGY)) {
					distance = routingTableDAOIF.distanceBetweenNodes(
							RANDOM_NODE_APPENDER_RT + Integer.toString(nodeIdTableToLook), nodeIdWhereClause);
				} else if (topologyType.equals(TopologyTypesIF.SQUARE_TOPOLOGY)) {
					distance = routingTableDAOIF.distanceBetweenNodes(
							SQUARE_NODE_APPENDER_RT + Integer.toString(nodeIdTableToLook), nodeIdWhereClause);
				} else if (topologyType.equals(TopologyTypesIF.GRID_TOPOLOGY)) {
					distance = routingTableDAOIF.distanceBetweenNodes(
							GRID_NODE_APPENDER_RT + Integer.toString(nodeIdTableToLook), nodeIdWhereClause);
				} else if (topologyType.equals(TopologyTypesIF.VERTICAL_TOPOLOGY)) {
					distance = routingTableDAOIF.distanceBetweenNodes(
							VERTICAL_NODE_APPENDER_RT + Integer.toString(nodeIdTableToLook), nodeIdWhereClause);
				}

			}
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return distance;

	}

	@Override
	public boolean insertRoutingTableZoneBasedForLEEACH() {
		boolean insertRoutingTableFlag = false;
		try {

			int count = topologyRoutingServiceIF.retriveSquareZoneTopologyCountLEEACH();
			for (int nodeId = 1; nodeId <= count; nodeId++) {
				deleteRoutingTable(TopologyTypesIF.LEEACH_TOPOLOGY, nodeId);
			}
			System.out.println("Count=" + count);
			if (count > 0) {
				List<TopologyInfoValue> linearTopology = topologyRoutingServiceIF.retriveSquareTopologyForViewLEEACH();
				for (int nodeIdIndex = 1; nodeIdIndex <= count; nodeIdIndex++) {

					System.out.println("NODE ID INDEX=" + nodeIdIndex);

					int nodeCurrentXCor = linearTopology.get(nodeIdIndex - 1).getNodeCoordiante().getX_cor();
					int nodeCurrentYCor = linearTopology.get(nodeIdIndex - 1).getNodeCoordiante().getY_cor();
					for (TopologyInfoValue topologyInfoValue : linearTopology) {
						int nodeId = topologyInfoValue.getNodeId();
						int xCor = topologyInfoValue.getNodeCoordiante().getX_cor();
						int yCor = topologyInfoValue.getNodeCoordiante().getY_cor();
						double distance = calculateDistance(nodeCurrentXCor, xCor, nodeCurrentYCor, yCor);

						ZoneRoutingTable zoneRoutingTable = new ZoneRoutingTable();
						zoneRoutingTable.setNodeId(nodeId);
						zoneRoutingTable.setDistance(distance);
						zoneRoutingTable.setZoneId(topologyInfoValue.getNodeParameters().getZoneId());
						System.out.println("Zone Id=" + topologyInfoValue.getNodeParameters().getZoneId());
						zoneRoutingTable.setZoneLeader(topologyInfoValue.getLeaderInfo().isLeader());

						insertRoutingTableFlag = routingTableDAOIF.insertRoutingTableZoneBased(zoneRoutingTable,
								SPACE + LEEACH_NODE_APPENDER_RT + Integer.toString(nodeIdIndex));

					}
				}

				insertRoutingTableFlag = deleteRoutingTableEntriesUsingLogicLEEACH(count);
				if (insertRoutingTableFlag == false) {
					return insertRoutingTableFlag;
				}

				insertRoutingTableFlag = true;
			}
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return insertRoutingTableFlag;
	}

	@Override
	public int retriveZoneIdBasedOnNodeIdLEEACH(int nodeId) {
		int zoneLeader = 0;
		try {
			zoneLeader = routingTableDAOIF
					.retriveZoneIdBasedOnNodeId(LEEACH_NODE_APPENDER_RT + Integer.toString(nodeId), nodeId);

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return zoneLeader;
	}

	@Override
	public int retriveZoneLeaderOfNodeLEEACH(int sourceNode, int zoneId) {
		int zoneLeader = 0;
		try {
			zoneLeader = routingTableDAOIF.findZoneLeaderOfZone(LEEACH_NODE_APPENDER_RT + Integer.toString(sourceNode),
					zoneId, ZONE_LEADER_FLAG);

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return zoneLeader;
	}

	@Override
	public int issourceNodeZoneLeaderLEEACH(int sourceNode) {
		int zoneLeader = 0;
		try {
			zoneLeader = routingTableDAOIF
					.retriveZoneLeaderBasedOnNodeId(LEEACH_NODE_APPENDER_RT + Integer.toString(sourceNode), sourceNode);

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return zoneLeader;
	}

	@Override
	public List<ClusterHeads> getClusterHeadsOfAllZonesLEEACH(int zoneId, int zoneLeaderOfSourceNode) {
		List<ClusterHeads> clusterHeads = null;
		try {
			clusterHeads = routingTableDAOIF.retriveClusterHeads(
					LEEACH_NODE_APPENDER_RT + Integer.toString(zoneLeaderOfSourceNode), zoneId, ZONE_LEADER_FLAG);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return clusterHeads;
	}

	@Override
	public List<Integer> retriveNodesInZoneLEEACH(int sourceNode) {
		List<Integer> nodesInZone = null;
		try {
			nodesInZone = routingTableDAOIF.retriveNodesInZone(LEEACH_NODE_APPENDER_RT + Integer.toString(sourceNode),
					sourceNode);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return nodesInZone;
	}

	@Override
	public List<Integer> retriveNodesInZoneUsingZoneLeaderLEEACH(ClusterHeads clusterHead) {
		List<Integer> nodesInZone = null;
		try {
			nodesInZone = routingTableDAOIF.retriveNodesInZoneUsingZoneLeaderAndZoneId(
					LEEACH_NODE_APPENDER_RT + Integer.toString(clusterHead.getNodeId()), clusterHead.getZoneId(),
					clusterHead.getNodeId());
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return nodesInZone;
	}

	@Override
	public List<Integer> obtainNodesApartFromZoneLeaderAndDestNodeLEEACH(int zoneId, int zoneLeaderNode,
			int destinationNode) {

		List<Integer> nodesInZone = null;
		try {
			nodesInZone = routingTableDAOIF.obtainNodesApartFromZoneLeaderAndDestNode(
					LINEAR_NODE_APPENDER_RT + Integer.toString(zoneLeaderNode), zoneId, zoneLeaderNode);
			if (nodesInZone != null) {
				int index = nodesInZone.indexOf(destinationNode);
				if (index >= 0) {
					nodesInZone.remove(index);
				}
			}

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return nodesInZone;
	}

	@Override
	public int retriveZoneIdBasedOnNodeIdForAngular(int nodeId) {
		int zoneLeader = 0;
		try {
			zoneLeader = routingTableDAOIF.retriveZoneIdBasedOnNodeId(ANGLE_NODE_APPENDER_RT + Integer.toString(nodeId),
					nodeId);

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return zoneLeader;
	}

	@Override
	public List<Integer> retriveNodesInZoneForAngular(int sourceNode) {

		List<Integer> nodesInZone = null;
		try {
			nodesInZone = routingTableDAOIF.retriveNodesInZone(ANGLE_NODE_APPENDER_RT + Integer.toString(sourceNode),
					sourceNode);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return nodesInZone;

	}

	@Override
	public int retriveZoneLeaderOfNodeForAngular(int sourceNode, int zoneId) {
		int zoneLeader = 0;
		try {
			zoneLeader = routingTableDAOIF.findZoneLeaderOfZone(ANGLE_NODE_APPENDER_RT + Integer.toString(sourceNode),
					zoneId, ZONE_LEADER_FLAG);

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return zoneLeader;
	}

	@Override
	public List<ClusterHeads> getClusterHeadsOfAllZonesForAngular(int zoneId, int zoneLeaderOfSourceNode) {

		List<ClusterHeads> clusterHeads = null;
		try {
			clusterHeads = routingTableDAOIF.retriveClusterHeads(
					ANGLE_NODE_APPENDER_RT + Integer.toString(zoneLeaderOfSourceNode), zoneId, ZONE_LEADER_FLAG);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return clusterHeads;
	}

	@Override
	public List<Integer> retriveNodesInZoneUsingZoneLeaderForAngular(ClusterHeads clusterHead) {
		List<Integer> nodesInZone = null;
		try {
			nodesInZone = routingTableDAOIF.retriveNodesInZoneUsingZoneLeaderAndZoneId(
					ANGLE_NODE_APPENDER_RT + Integer.toString(clusterHead.getNodeId()), clusterHead.getZoneId(),
					clusterHead.getNodeId());
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return nodesInZone;
	}

	@Override
	public List<Integer> retriveNodesApartFromSNZLAndSNAndNonObs(int zoneLeader, int zoneId, int sourceNode,
			int obsSite) {
		List<Integer> nodesInZone = null;
		try {
			nodesInZone = routingTableDAOIF.retriveNodesApartFromSNZLAndSNAndNonObs(
					ANGLE_NODE_APPENDER_RT + Integer.toString(sourceNode), zoneId, sourceNode, obsSite, zoneLeader);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return nodesInZone;
	}

	@Override
	public int getAngleOfNode(Integer nodeId) {

		int angleOfNode = 0;
		try {
			angleOfNode = routingTableDAOIF.retriveAngleBasedOnNodeId(ANGLE_NODE_APPENDER_RT + Integer.toString(nodeId),
					nodeId);

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return angleOfNode;
	}

	@Override
	public int issourceNodeZoneLeaderForAngular(int sourceNode) {
		int zoneLeader = 0;
		try {
			zoneLeader = routingTableDAOIF
					.retriveZoneLeaderBasedOnNodeId(ANGLE_NODE_APPENDER_RT + Integer.toString(sourceNode), sourceNode);

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return zoneLeader;
	}

}
