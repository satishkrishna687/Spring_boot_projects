package com.routingtopology.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routingtopology.constants.TopologyConstantsIF;
import com.routingtopology.constants.TopologyTypesIF;
import com.routingtopology.dao.impl.AngularDAOImpl;
import com.routingtopology.dao.impl.BASESTATIONDAOImpl;
import com.routingtopology.dao.impl.GridDAOImpl;
import com.routingtopology.dao.impl.LinearDAOImpl;
import com.routingtopology.dao.impl.RandomDAOImpl;
import com.routingtopology.dao.impl.SquareZoneDAOImpl;
import com.routingtopology.dao.impl.SquareZoneLEEACHDAOImpl;
import com.routingtopology.dao.impl.TopologyDAOImpl;
import com.routingtopology.dao.impl.VerticalDAOImpl;
import com.routingtopology.dao.inter.AngularDAOIF;
import com.routingtopology.dao.inter.BASESTATIONDAOIF;
import com.routingtopology.dao.inter.GridDAOIF;
import com.routingtopology.dao.inter.LinearDAOIF;
import com.routingtopology.dao.inter.RandomDAOIF;
import com.routingtopology.dao.inter.SquareZoneDAOIF;
import com.routingtopology.dao.inter.SquareZoneLEEACHDAOIF;
import com.routingtopology.dao.inter.TopologyDAOIF;
import com.routingtopology.dao.inter.VerticalDAOIF;
import com.routingtopology.service.inter.TopologyRoutingServiceIF;
import com.routingtopology.value.NodeInfoForSquare;
import com.routingtopology.value.TopologyCriteriaValue;
import com.routingtopology.value.TopologyInfoValue;
import com.routingtopologyhelper.impl.TopologyGenerationImpl;
import com.routingtopologyhelper.inter.TopologyGenerationIF;

/**
 * This is the Topology Service used for topology generation retrival updation
 * and deletion for all kinds of routing topologies
 * 
 */
@Service
public class TopologyRoutingServiceImpl implements TopologyRoutingServiceIF {

	@Autowired
	private SquareZoneLEEACHDAOImpl squareLeeachDao;

	@Autowired
	private BASESTATIONDAOImpl baseStationDao;

	@Autowired
	private AngularDAOImpl angularDao;

	@Autowired
	private GridDAOImpl gridDao;

	@Autowired
	private LinearDAOImpl linearDao;

	@Autowired
	private RandomDAOImpl randomDao;

	@Autowired
	private VerticalDAOImpl verticalDao;

	@Autowired
	private SquareZoneDAOImpl squareDao;

	@Autowired
	private TopologyDAOImpl topologyDao;

	@Autowired
	private TopologyGenerationImpl topologyHelper;

	private static final String CLASS_NAME = "TopologyRoutingServiceImpl";

	private static final String CLASS_COLON = "CLASS:";

	private static final String ARROW = "--->";

	private static final String METHOD = "METHOD";

	private static final String START = "START";

	private static final String END = "END";

	private static final String METHOD_NAME = "Method:";

	@Override
	public boolean generateRandomTopologyAndStore(TopologyCriteriaValue criteria) {
		System.out
				.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateRandomTopologyAndStore" + ARROW + START);
		boolean generationFlag = false;
		List<TopologyInfoValue> topologyInfoList = null;
		try {
			topologyInfoList = topologyHelper.getRandomTopology(criteria);
			if (null == topologyInfoList) {
				return false;
			}
			if (topologyInfoList != null && topologyInfoList.size() > 0) {
				boolean random = randomDao.deleteRandomTopology();
				if (random) {
					generationFlag = randomDao.insertRandomTopology(topologyInfoList);
				}
				if (!random) {
					return false;
				}
			}

		} catch (Exception e) {
			System.out.println("Exception:-->" + e.getMessage());
			generationFlag = false;
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateRandomTopologyAndStore" + ARROW + END);
		return generationFlag;
	}

	@Override
	public List<TopologyInfoValue> retriveRandomTopologyForView() {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveRandomTopologyForView" + ARROW + START);
		List<TopologyInfoValue> randomTopologyList = null;
		try {
			randomTopologyList = randomDao.retriveRandomTopology();
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
			randomTopologyList = null;
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveRandomTopologyForView" + ARROW + END);
		return randomTopologyList;
	}

	@Override
	public boolean deleteRandomTopology() {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "deleteRandomTopology" + ARROW + START);
		boolean deleteRandomFlag = false;
		try {
			deleteRandomFlag = randomDao.deleteRandomTopology();
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "deleteRandomTopology" + ARROW + END);
		return deleteRandomFlag;
	}

	@Override
	public boolean updateRandomTopology(List<TopologyInfoValue> topologyInfoValueList) {
		// TODO Auto-generated method stub
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateRandomTopology" + ARROW + START);
		boolean updateFlag = false;
		try {
			if (topologyInfoValueList != null && topologyInfoValueList.size() > 0) {
				updateFlag = randomDao.updateRandomTopology(topologyInfoValueList);
			}
		} catch (Exception e) {
			System.out.println(
					"Class-->TopologyRoutingServiceImpl:Method-->updateRandomTopology() Exception" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateRandomTopology" + ARROW + END);
		return updateFlag;
	}

	@Override
	public boolean deleteLinearTopology() {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "deleteLinearTopology" + ARROW + START);
		boolean deleteLinearFlag = false;
		try {
			deleteLinearFlag = linearDao.deleteLinearTopology();
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "deleteLinearTopology" + ARROW + END);
		return deleteLinearFlag;
	}

	@Override
	public boolean generateLinearTopologyAndStore(TopologyCriteriaValue criteria) {
		System.out
				.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateLinearTopologyAndStore" + ARROW + START);
		boolean generationFlag = false;
		List<TopologyInfoValue> topologyInfoList = null;
		try {
			topologyInfoList = topologyHelper.getLinearTopology(criteria);
			if (null == topologyInfoList) {
				return false;
			}
			if (topologyInfoList != null && topologyInfoList.size() > 0) {
				boolean linear = linearDao.deleteLinearTopology();
				if (linear) {
					generationFlag = linearDao.insertLinearTopology(topologyInfoList);
				}
				if (!linear) {
					return false;
				}
			}

		} catch (Exception e) {
			System.out.println("Exception:-->" + e.getMessage());
			generationFlag = false;
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateLinearTopologyAndStore" + ARROW + END);
		return generationFlag;
	}

	@Override
	public List<TopologyInfoValue> retriveLinearTopologyForView() {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveLinearTopologyForView" + ARROW + START);
		List<TopologyInfoValue> linearTopologyList = null;
		try {
			linearTopologyList = linearDao.retriveLinearTopology();
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
			linearTopologyList = null;
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveLinearTopologyForView" + ARROW + END);
		return linearTopologyList;
	}

	@Override
	public boolean updateLinearTopology(List<TopologyInfoValue> topologyInfoValueList) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateLinearTopology" + ARROW + START);
		boolean updateRandomFlag = false;
		try {
			updateRandomFlag = linearDao.updateLinearTopology(topologyInfoValueList);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateLinearTopology" + ARROW + END);
		return updateRandomFlag;
	}

	@Override
	public boolean generateGridTopologyAndStore(TopologyCriteriaValue criteria) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "getGridTopologyAndStore" + ARROW + START);
		boolean generationFlag = false;
		List<TopologyInfoValue> topologyInfoList = null;
		try {
			topologyInfoList = topologyHelper.getGridTopology(criteria);
			if (null == topologyInfoList) {
				return false;
			}
			if (topologyInfoList != null && topologyInfoList.size() > 0) {
				boolean flag = gridDao.deleteGridTopology();
				if (!flag) {
					return false;
				}
				if (flag) {
					generationFlag = gridDao.insertGridTopology(topologyInfoList);
				}
			}

		} catch (Exception e) {
			System.out.println("Exception:-->" + e.getMessage());
			generationFlag = false;
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "getGridTopologyAndStore" + ARROW + END);
		return generationFlag;
	}

	@Override
	public List<TopologyInfoValue> retriveGridTopologyForView() {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveGridTopologyForView" + ARROW + START);
		List<TopologyInfoValue> gridTopologyList = null;
		try {
			gridTopologyList = gridDao.retriveGridTopology();
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
			gridTopologyList = null;
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveGridTopologyForView" + ARROW + END);
		return gridTopologyList;
	}

	@Override
	public boolean updateGridTopology(List<TopologyInfoValue> topologyInfoValueList) {
		// TODO Auto-generated method stub
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateGridTopology" + ARROW + START);
		boolean updateGridFlag = false;
		try {
			if (topologyInfoValueList != null && topologyInfoValueList.size() > 0) {
				updateGridFlag = gridDao.updateGridTopology(topologyInfoValueList);
			}
		} catch (Exception e) {
			System.out.println(
					"Class-->TopologyRoutingServiceImpl:Method-->updateGridTopology() Exception" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateGridTopology" + ARROW + END);
		return updateGridFlag;
	}

	@Override
	public boolean deleteGridTopology() {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "deleteGridTopology" + ARROW + START);
		boolean deleteGridFlag = false;
		try {
			deleteGridFlag = gridDao.deleteGridTopology();
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "deleteGridTopology" + ARROW + END);
		return deleteGridFlag;
	}

	@Override
	public boolean deleteVerticalTopology() {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "deleteVerticalTopology" + ARROW + START);
		boolean deleteVerticalFlag = false;
		try {
			deleteVerticalFlag = verticalDao.deleteVerticalTopology();
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "deleteVerticalTopology" + ARROW + END);
		return deleteVerticalFlag;
	}

	@Override
	public boolean generateVerticalTopologyAndStore(TopologyCriteriaValue criteria) {
		System.out.println(
				CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateVerticalTopologyAndStore" + ARROW + START);
		boolean value = false;
		List<TopologyInfoValue> verticalTopologyList = null;
		try {
			boolean flag = verticalDao.deleteVerticalTopology();
			if (!flag) {
				return false;
			}
			if (flag) {
				if (criteria != null) {
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateVerticalTopologyAndStore"
							+ ARROW + "criteria=" + criteria);
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateVerticalTopologyAndStore"
							+ ARROW + "noofnodes=" + criteria.getNoOfNodes());
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateVerticalTopologyAndStore"
							+ ARROW + "getNoOfNodesInEachVertical=" + criteria.getNoOfNodesInEachVertical());
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateVerticalTopologyAndStore"
							+ ARROW + "getVerticalLinesPoints=" + criteria.getVerticalLinesPoints());
					if (criteria.getNoOfNodes() > 0 && criteria.getNoOfNodesInEachVertical() != null
							&& criteria.getVerticalLinesPoints() != null) {
						int noOfNodes = criteria.getNoOfNodes();
						List<Integer> noOfNodesInEachVerticalList = criteria.getNoOfNodesInEachVertical();
						boolean validateNoOfNodes = validateNoOfNodes(noOfNodes, noOfNodesInEachVerticalList);
						System.out
								.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateVerticalTopologyAndStore"
										+ ARROW + "VALIDATION NO OF NODES=" + validateNoOfNodes);
						if (!validateNoOfNodes) {
							return false;
						}
						if (validateNoOfNodes) {
							List<Integer> verticalEndPoints = criteria.getVerticalLinesPoints();
							boolean validateEndPoints = validateTheEndPointsofTopology(verticalEndPoints);
							System.out.println(
									CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateVerticalTopologyAndStore"
											+ ARROW + "VALIDATION END POINTS=" + validateEndPoints);
							if (!validateEndPoints) {
								return false;
							}
							if (validateEndPoints) {
								verticalTopologyList = topologyHelper.getVerticalTopology(criteria);
								if (verticalTopologyList != null && verticalTopologyList.size() > 0) {
									value = verticalDao.insertVerticalTopology(verticalTopologyList);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		System.out
				.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateVerticalTopologyAndStore" + ARROW + END);
		return value;
	}

	@Override
	public List<TopologyInfoValue> retriveVerticalTopologyForView() {
		System.out
				.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveVerticalTopologyForView" + ARROW + START);
		List<TopologyInfoValue> verticalTopologyList = null;
		try {
			verticalTopologyList = verticalDao.retriveVerticalTopology();
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
			verticalTopologyList = null;
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveVerticalTopologyForView" + ARROW + END);
		return verticalTopologyList;
	}

	@Override
	public boolean updateVerticalTopology(List<TopologyInfoValue> topologyInfoValueList) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateVerticalTopology" + ARROW + START);
		boolean updateVerticalFlag = false;
		try {
			updateVerticalFlag = verticalDao.updateVerticalTopology(topologyInfoValueList);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateVerticalTopology" + ARROW + END);
		return updateVerticalFlag;
	}

	private boolean validateNoOfNodes(int noOfNodes, List<Integer> noOfNodesInEachVerticalList) {
		boolean validateNoOfNodesFlag = false;

		if (noOfNodes > 0 && noOfNodesInEachVerticalList != null && noOfNodesInEachVerticalList.size() > 0) {

			int sumNodes = 0;

			for (int i = 0; i < noOfNodesInEachVerticalList.size(); i++) {
				sumNodes += noOfNodesInEachVerticalList.get(i);
			}

			if (sumNodes == noOfNodes) {
				validateNoOfNodesFlag = true;
				return validateNoOfNodesFlag;
			}
			if (sumNodes != noOfNodes) {
				validateNoOfNodesFlag = false;
				return validateNoOfNodesFlag;
			}
		}
		return validateNoOfNodesFlag;
	}

	private boolean validateTheEndPointsofTopology(List<Integer> verticalEndPoints) {
		boolean validateTheEndPointFlag = true;
		if (null == verticalEndPoints || verticalEndPoints.size() == 0) {
			return false;
		}

		if (verticalEndPoints != null && verticalEndPoints.size() > 0) {
			int verticalSize = verticalEndPoints.size();
			for (int verIndex = 0; verIndex < verticalSize; verIndex++) {
				if (verIndex == verticalSize - 1) {
					break;
				}
				if (verticalEndPoints.get(verIndex + 1) < verticalEndPoints.get(verIndex)) {
					validateTheEndPointFlag = false;
					break;
				}
			}
		}
		return validateTheEndPointFlag;
	}

	@Override
	public boolean deleteAngularTopology() {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "deleteAngularTopology" + ARROW + START);
		boolean deleteAngularFlag = false;
		try {
			deleteAngularFlag = angularDao.deleteAngularTopology();
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "deleteAngularTopology" + ARROW + END);
		return deleteAngularFlag;

	}

	@Override
	public boolean generateAngularTopologyAndStore(TopologyCriteriaValue criteria) {
		System.out
				.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateAngularTopologyAndStore" + ARROW + START);
		boolean generationFlag = false;
		List<TopologyInfoValue> angularTopologyList = null;
		try {
			boolean flag = angularDao.deleteAngularTopology();
			if (!flag) {
				return false;
			}
			if (flag) {
				if (criteria != null) {
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateAngularTopologyAndStore"
							+ ARROW + "criteria=" + criteria);
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateAngularTopologyAndStore"
							+ ARROW + "noofnodes=" + criteria.getNoOfNodes());
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateAngularTopologyAndStore"
							+ ARROW + "getNoOfNodesInEachAngularRegion=" + criteria.getNoOfNodesInEachAngularRegion());
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateAngularTopologyAndStore"
							+ ARROW + "getAngularEndPoints=" + criteria.getAngularEndPoints());
					if (criteria.getNoOfNodes() > 0 && criteria.getNoOfNodesInEachAngularRegion() != null
							&& criteria.getAngularEndPoints() != null) {
						int noOfNodes = criteria.getNoOfNodes();
						List<Integer> noOfNodesInEachAngularRegion = criteria.getNoOfNodesInEachAngularRegion();
						boolean validateNoOfNodes = validateNoOfNodes(noOfNodes, noOfNodesInEachAngularRegion);
						System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateAngularTopologyAndStore"
								+ ARROW + "VALIDATION NO OF NODES=" + validateNoOfNodes);
						if (!validateNoOfNodes) {
							return false;
						}
						if (validateNoOfNodes) {
							List<Integer> angularEndPoints = criteria.getAngularEndPoints();
							boolean validateEndPoints = validateTheEndPointsofTopology(angularEndPoints);
							System.out.println(
									CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateAngularTopologyAndStore"
											+ ARROW + "VALIDATION END POINTS=" + validateEndPoints);
							if (!validateEndPoints) {
								return false;
							}
							if (validateEndPoints) {
								angularTopologyList = topologyHelper.getAngularTopology(criteria);
								System.out.println(
										CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateAngularTopologyAndStore"
												+ ARROW + "angularTopologyFromHelper" + angularTopologyList);
								if (angularTopologyList != null && angularTopologyList.size() > 0) {
									System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
											+ "generateAngularTopologyAndStore" + ARROW
											+ "angularTopology generated is not empty");
									generationFlag = angularDao.insertAngularTopology(angularTopologyList);
									System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
											+ "generateAngularTopologyAndStore" + ARROW
											+ "angularTopology insertion flag" + generationFlag);

									if (generationFlag) {
										List<Integer> zoneIds = angularDao.retriveDistinctZoneIds();
										System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
												+ "generateAngularTopologyAndStore" + ARROW + "distinct zone ids"
												+ zoneIds);
										if (zoneIds != null) {
											for (int zoneId : zoneIds) {
												List<Integer> nodeIdsOfZone = new ArrayList<Integer>();
												nodeIdsOfZone = angularDao.retriveNodeIdsForZoneID(zoneId);
												System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
														+ "generateAngularTopologyAndStore" + ARROW + "nodeIds Of zone"
														+ zoneId + "are" + nodeIdsOfZone);
												if (nodeIdsOfZone != null) {
													int sizeOfCluster = nodeIdsOfZone.size();
													Random rand = new Random();
													int randomIndex = rand.nextInt(sizeOfCluster);
													int nodeIdZoneLeader = nodeIdsOfZone.get(randomIndex);
													System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
															+ "generateAngularTopologyAndStore" + ARROW
															+ "Zone Leader Of zone" + nodeIdZoneLeader);
													generationFlag = angularDao.updateNodeIdWithLeader(nodeIdZoneLeader,
															TopologyConstantsIF.ZONELEADER_FLAG);
													System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
															+ "generateAngularTopologyAndStore" + ARROW
															+ "Zone Leader updation flag zone" + generationFlag);
												}
											}

										}

									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateAngularTopologyAndStore" + ARROW
					+ "Exception " + e.getMessage());
			generationFlag = false;
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateAngularTopologyAndStore" + ARROW + END);
		return generationFlag;
	}

	@Override
	public List<TopologyInfoValue> retriveAngularTopologyForView() {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveAngularTopologyForView" + ARROW + START);
		List<TopologyInfoValue> angularTopologyList = null;
		try {
			angularTopologyList = angularDao.retriveAngularTopology();
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
			angularTopologyList = null;
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveAngularTopologyForView" + ARROW + END);
		return angularTopologyList;

	}

	@Override
	public boolean updateAngularTopology(List<TopologyInfoValue> topologyInfoValueList) {
		// TODO Auto-generated method stub
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateAngularTopology" + ARROW + START);
		boolean updateFlag = false;
		try {
			if (topologyInfoValueList != null && topologyInfoValueList.size() > 0) {
				updateFlag = angularDao.updateAngularTopology(topologyInfoValueList);
			}
		} catch (Exception e) {
			System.out.println(
					"Class-->TopologyRoutingServiceImpl:Method-->updateAngularTopology() Exception" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateAngularTopology" + ARROW + END);
		return updateFlag;

	}

	@Override
	public boolean deleteSquareTopology() {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "deleteSquareTopology" + ARROW + START);
		boolean deleteSquareFlag = false;
		try {
			deleteSquareFlag = squareDao.deleteSquareZoneTopology();
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "deleteSquareTopology" + ARROW + END);
		return deleteSquareFlag;
	}

	@Override
	public boolean deleteSquareTopologyLEEACH() {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "deleteSquareTopologyLEEACH" + ARROW + START);
		boolean deleteSquareFlagLEEACH = false;
		try {
			deleteSquareFlagLEEACH = squareLeeachDao.deleteSquareZoneTopology();
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "deleteSquareTopologyLEEACH" + ARROW + END);
		return deleteSquareFlagLEEACH;
	}

	@Override
	public boolean generateSquareTopologyAndStore(TopologyCriteriaValue criteria) {
		System.out
				.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore" + ARROW + START);
		boolean generationFlag = false;
		List<TopologyInfoValue> squareTopologyList = null;
		try {
			boolean flag = squareDao.deleteSquareZoneTopology();
			if (!flag) {
				return false;
			}
			if (flag) {
				if (criteria != null) {
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore"
							+ ARROW + "criteria=" + criteria);
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore"
							+ ARROW + "noofnodes=" + criteria.getNoOfNodes());
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore"
							+ ARROW + "getNoOfNodesPerZone=" + criteria.getNoOfNodesPerZone());
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore"
							+ ARROW + "getHorizontalEndPoints=" + criteria.getHorizontalEndPoints());
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore"
							+ ARROW + "getVerticalEndPoints=" + criteria.getVerticalEndPoints());
					if (criteria.getNoOfNodes() > 0 && criteria.getNoOfNodesPerZone() != null
							&& criteria.getHorizontalEndPoints() != null && criteria.getVerticalEndPoints() != null) {
						int noOfNodes = criteria.getNoOfNodes();
						List<Integer> noOfNodesInEachZone = criteria.getNoOfNodesPerZone();
						boolean validateNoOfNodes = validateNoOfNodesSquareZone(noOfNodes, noOfNodesInEachZone);
						System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore"
								+ ARROW + "VALIDATION NO OF NODES=" + validateNoOfNodes);
						if (!validateNoOfNodes) {
							return false;
						}
						if (validateNoOfNodes) {
							List<Integer> horizontalEndPoints = criteria.getHorizontalEndPoints();
							boolean validateHorizontalEndPoints = validateTheEndPointsofTopology(horizontalEndPoints);
							System.out.println(
									CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore" + ARROW
											+ "VALIDATION END POINTS=" + validateHorizontalEndPoints);
							if (!validateHorizontalEndPoints) {
								return false;
							}
							if (validateHorizontalEndPoints) {

								List<Integer> verticalEndPoints = criteria.getVerticalEndPoints();
								boolean validateVerticalEndPoints = validateTheEndPointsofTopology(verticalEndPoints);
								System.out.println(
										CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore"
												+ ARROW + "VALIDATION END POINTS=" + validateVerticalEndPoints);

								if (!validateVerticalEndPoints) {
									return false;
								}
								if (validateVerticalEndPoints) {
									squareTopologyList = topologyHelper.getSquareTopology(criteria);
									System.out.println(
											CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore"
													+ ARROW + "getSquareTopologyFromHelper" + squareTopologyList);
									if (squareTopologyList != null && squareTopologyList.size() > 0) {
										System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
												+ "generateSquareTopologyAndStore" + ARROW
												+ "square Topology generated is not empty");
										generationFlag = squareDao.insertSquareZoneTopology(squareTopologyList);
										System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
												+ "generateSquareTopologyAndStore" + ARROW
												+ "squareTopology insertion flag" + generationFlag);

										if (generationFlag) {
											List<Integer> zoneIds = squareDao.retriveDistinctSquareZoneIds();
											System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
													+ "generateAngularTopologyAndStore" + ARROW + "distinct zone ids"
													+ zoneIds);
											if (zoneIds != null) {
												for (int zoneId : zoneIds) {
													List<NodeInfoForSquare> nodeIdsOfZone = new ArrayList<NodeInfoForSquare>();
													nodeIdsOfZone = squareDao
															.retriveNodeInfoForZoneIDSquareZone(zoneId);
													System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
															+ "generateAngularTopologyAndStore" + ARROW
															+ "nodeIds Of zone" + zoneId + "are" + nodeIdsOfZone);
													if (nodeIdsOfZone != null) {
														int sizeOfCluster = nodeIdsOfZone.size();
														int nodeIdZoneLeader = getZoneLeaderBasedOnCentre(
																nodeIdsOfZone);
														System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
																+ "generateAngularTopologyAndStore" + ARROW
																+ "Zone Leader Of zone" + nodeIdZoneLeader);
														generationFlag = squareDao.updateNodeIdWithLeaderSquareZone(
																nodeIdZoneLeader, TopologyConstantsIF.ZONELEADER_FLAG);
														System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
																+ "generateAngularTopologyAndStore" + ARROW
																+ "Zone Leader updation flag zone" + generationFlag);
													}
												}

											}

										}
									}
								}
							}
						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateAngularTopologyAndStore" + ARROW
					+ "Exception " + e.getMessage());
			generationFlag = false;
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateAngularTopologyAndStore" + ARROW + END);
		return generationFlag;

	}

	@Override
	public boolean generateSquareTopologyAndStoreLEEACH(TopologyCriteriaValue criteria) {

		System.out
				.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore" + ARROW + START);
		boolean generationFlag = false;
		List<TopologyInfoValue> squareTopologyList = null;
		try {
			boolean flag = squareLeeachDao.deleteSquareZoneTopology();
			if (!flag) {
				return false;
			}
			if (flag) {
				if (criteria != null) {
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore"
							+ ARROW + "criteria=" + criteria);
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore"
							+ ARROW + "noofnodes=" + criteria.getNoOfNodes());
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore"
							+ ARROW + "getNoOfNodesPerZone=" + criteria.getNoOfNodesPerZone());
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore"
							+ ARROW + "getHorizontalEndPoints=" + criteria.getHorizontalEndPoints());
					System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore"
							+ ARROW + "getVerticalEndPoints=" + criteria.getVerticalEndPoints());
					if (criteria.getNoOfNodes() > 0 && criteria.getNoOfNodesPerZone() != null
							&& criteria.getHorizontalEndPoints() != null && criteria.getVerticalEndPoints() != null) {
						int noOfNodes = criteria.getNoOfNodes();
						List<Integer> noOfNodesInEachZone = criteria.getNoOfNodesPerZone();
						boolean validateNoOfNodes = validateNoOfNodesSquareZone(noOfNodes, noOfNodesInEachZone);
						System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore"
								+ ARROW + "VALIDATION NO OF NODES=" + validateNoOfNodes);
						if (!validateNoOfNodes) {
							return false;
						}
						if (validateNoOfNodes) {
							List<Integer> horizontalEndPoints = criteria.getHorizontalEndPoints();
							boolean validateHorizontalEndPoints = validateTheEndPointsofTopology(horizontalEndPoints);
							System.out.println(
									CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore" + ARROW
											+ "VALIDATION END POINTS=" + validateHorizontalEndPoints);
							if (!validateHorizontalEndPoints) {
								return false;
							}
							if (validateHorizontalEndPoints) {

								List<Integer> verticalEndPoints = criteria.getVerticalEndPoints();
								boolean validateVerticalEndPoints = validateTheEndPointsofTopology(verticalEndPoints);
								System.out.println(
										CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore"
												+ ARROW + "VALIDATION END POINTS=" + validateVerticalEndPoints);

								if (!validateVerticalEndPoints) {
									return false;
								}
								if (validateVerticalEndPoints) {
									squareTopologyList = topologyHelper.getSquareTopology(criteria);
									System.out.println(
											CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateSquareTopologyAndStore"
													+ ARROW + "getSquareTopologyFromHelper" + squareTopologyList);
									if (squareTopologyList != null && squareTopologyList.size() > 0) {
										System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
												+ "generateSquareTopologyAndStore" + ARROW
												+ "square Topology generated is not empty");
										generationFlag = squareLeeachDao.insertSquareZoneTopology(squareTopologyList);
										System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
												+ "generateSquareTopologyAndStore" + ARROW
												+ "squareTopology insertion flag" + generationFlag);

										if (generationFlag) {
											List<Integer> zoneIds = squareLeeachDao.retriveDistinctSquareZoneIds();
											System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
													+ "generateAngularTopologyAndStore" + ARROW + "distinct zone ids"
													+ zoneIds);
											if (zoneIds != null) {
												for (int zoneId : zoneIds) {
													List<NodeInfoForSquare> nodeIdsOfZone = new ArrayList<NodeInfoForSquare>();
													nodeIdsOfZone = squareLeeachDao
															.retriveNodeInfoForZoneIDSquareZone(zoneId);
													System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
															+ "generateAngularTopologyAndStore" + ARROW
															+ "nodeIds Of zone" + zoneId + "are" + nodeIdsOfZone);
													if (nodeIdsOfZone != null) {
														int sizeOfCluster = nodeIdsOfZone.size();
														int nodeIdZoneLeader = getZoneLeaderRandomly(nodeIdsOfZone);
														System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
																+ "generateAngularTopologyAndStore" + ARROW
																+ "Zone Leader Of zone" + nodeIdZoneLeader);
														generationFlag = squareLeeachDao
																.updateNodeIdWithLeaderSquareZone(nodeIdZoneLeader,
																		TopologyConstantsIF.ZONELEADER_FLAG);
														System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD
																+ "generateAngularTopologyAndStore" + ARROW
																+ "Zone Leader updation flag zone" + generationFlag);
													}
												}

											}

										}
									}
								}
							}
						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateAngularTopologyAndStore" + ARROW
					+ "Exception " + e.getMessage());
			generationFlag = false;
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "generateAngularTopologyAndStore" + ARROW + END);
		return generationFlag;

	}

	private int getZoneLeaderRandomly(List<NodeInfoForSquare> nodeIdsOfZone) {
		int nodeId = 0;
		if (nodeIdsOfZone != null) {

			int size = nodeIdsOfZone.size();
			int rand = new Random().nextInt(size);
			nodeId = nodeIdsOfZone.get(rand).getNodeId();

		}
		return nodeId;
	}

	private boolean validateNoOfNodesSquareZone(int noOfNodes, List<Integer> noOfNodesInEachZone) {

		boolean validateNoOfNodesFlag = false;

		if (noOfNodes > 0 && noOfNodesInEachZone != null && noOfNodesInEachZone.size() > 0) {

			int sumNodes = 0;

			for (int i = 0; i < noOfNodesInEachZone.size(); i++) {
				sumNodes += noOfNodesInEachZone.get(i);
			}

			if (sumNodes == noOfNodes) {
				validateNoOfNodesFlag = true;
				return validateNoOfNodesFlag;
			}
			if (sumNodes != noOfNodes) {
				validateNoOfNodesFlag = false;
				return validateNoOfNodesFlag;
			}
		}
		return validateNoOfNodesFlag;

	}

	private int getZoneLeaderBasedOnCentre(List<NodeInfoForSquare> nodeIdsOfZone) {

		int nodeId = 0;
		if (nodeIdsOfZone != null) {
			List<Double> distanceList = new ArrayList<Double>();
			Map<Double, Integer> mapOfNodeIdDistance = new HashMap<Double, Integer>();
			for (NodeInfoForSquare nodeInfoForSquare : nodeIdsOfZone) {
				int nodeIdTemp = nodeInfoForSquare.getNodeId();
				int xCor = nodeInfoForSquare.getxCordinate();
				int yCor = nodeInfoForSquare.getyCordinate();
				double xCenter = nodeInfoForSquare.getxCenter();
				double yCenter = nodeInfoForSquare.getyCentre();
				double distance = getDistance(xCor, yCor, xCenter, yCenter);
				mapOfNodeIdDistance.put(distance, nodeIdTemp);
				distanceList.add(distance);
			}
			mapOfNodeIdDistance.entrySet();
			double minDistance = Collections.min(distanceList);
			nodeId = mapOfNodeIdDistance.get(minDistance);
		}
		return nodeId;
	}

	/**
	 * This is used to calculate distance between center and node Id Cordinate
	 * 
	 * @param nodeXCor1
	 * @param nodeYCor1
	 * @param centerX
	 * @param centerY
	 * @return distance between nodes
	 */

	public double getDistance(int nodeXCor1, int nodeYCor1, double centerX, double centerY) {
		double xValue = centerX - nodeXCor1;
		double yValue = centerY - nodeYCor1;
		double xValueSquare = Math.pow(xValue, 2);
		double yValueSquare = Math.pow(yValue, 2);
		double summer = xValueSquare + yValueSquare;
		double distance = Math.sqrt(summer);
		return distance;
	}

	@Override
	public List<TopologyInfoValue> retriveSquareTopologyForView() {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveSquareTopologyForView" + ARROW + START);
		List<TopologyInfoValue> angularTopologyList = null;
		try {
			angularTopologyList = squareDao.retriveSquareZoneTopology();
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
			angularTopologyList = null;
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveSquareTopologyForView" + ARROW + END);
		return angularTopologyList;
	}

	@Override
	public List<TopologyInfoValue> retriveSquareTopologyForViewLEEACH() {
		System.out.println(
				CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveSquareTopologyForViewLEEACH" + ARROW + START);
		List<TopologyInfoValue> leeachTopologyList = null;
		try {
			leeachTopologyList = squareLeeachDao.retriveSquareZoneTopology();
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
			leeachTopologyList = null;
		}
		System.out.println(
				CLASS_COLON + CLASS_NAME + ARROW + METHOD + "retriveSquareTopologyForViewLEEACH" + ARROW + END);
		return leeachTopologyList;
	}

	@Override
	public boolean updateSquareTopology(List<TopologyInfoValue> topologyInfoValueList) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateSquareTopology" + ARROW + START);
		boolean updateFlag = false;
		try {
			if (topologyInfoValueList != null && topologyInfoValueList.size() > 0) {
				updateFlag = squareDao.updateSquareZoneTopology(topologyInfoValueList);
			}
		} catch (Exception e) {
			System.out.println(
					"Class-->TopologyRoutingServiceImpl:Method-->updateSquareTopology() Exception" + e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateSquareTopology" + ARROW + END);
		return updateFlag;
	}

	@Override
	public boolean updateSquareTopologyLEEACH(List<TopologyInfoValue> topologyInfoValueList) {
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateSquareTopologyLEEACH" + ARROW + START);
		boolean updateFlag = false;
		try {
			if (topologyInfoValueList != null && topologyInfoValueList.size() > 0) {
				updateFlag = squareLeeachDao.updateSquareZoneTopology(topologyInfoValueList);
			}
		} catch (Exception e) {
			System.out.println("Class-->TopologyRoutingServiceImpl:Method-->updateSquareTopologyLEEACH() Exception"
					+ e.getMessage());
		}
		System.out.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateSquareTopologyLEEACH" + ARROW + END);
		return updateFlag;
	}

	@Override
	public int retriveAngularTopologyCount() {

		System.out.println(CLASS_NAME + METHOD_NAME + "retriveAngularTopologyCount()" + START);
		int noOfRecords = 0;
		try {
			noOfRecords = angularDao.retriveAngularTopologyCount();
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "retriveAngularTopologyCount() Exception" + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveAngularTopologyCount()" + END);
		return noOfRecords;
	}

	@Override
	public int retriveGridTopologyCount() {
		System.out.println("Class-->GridDAOImpl:Method-->" + "retriveGridTopologyCount()" + "Start");
		int noOfRecords = 0;
		try {
			noOfRecords = gridDao.retriveGridTopologyCount();
		} catch (Exception e) {
			System.out.println(
					"Class-->GridDAOImpl:Method-->" + "retriveGridTopologyCount()-->Exception" + e.getMessage());
		}
		System.out.println("Class-->GridDAOImpl:Method-->" + "retriveGridTopologyCount()-->End");
		return noOfRecords;
	}

	@Override
	public int retriveLinearTopologyCount() {
		System.out.println("Class-->LinearDAOImpl:Method-->" + "retriveLinearTopologyCount()" + "Start");
		int noOfRecords = 0;
		try {
			noOfRecords = linearDao.retriveLinearTopologyCount();
		} catch (Exception e) {
			System.out.println(
					"Class-->LinearDAOImpl:Method-->" + "retriveLinearTopologyCount()-->Exception" + e.getMessage());
		}
		System.out.println("Class-->LinearDAOImpl:Method-->" + "retriveLinearTopologyCount()-->End");
		return noOfRecords;
	}

	@Override
	public int retriveRandomTopologyCount() {
		System.out.println("Class-->RandomDAOImpl:Method-->" + "retriveRandomTopologyCount()" + "Start");
		int noOfRecords = 0;
		try {
			noOfRecords = randomDao.retriveRandomTopologyCount();
		} catch (Exception e) {
			System.out.println(
					"Class-->RandomDAOImpl:Method-->" + "retriveRandomTopologyCount() Exception" + e.getMessage());
		}
		System.out.println("Class-->RandomDAOImpl:Method-->" + "retriveRandomTopologyCount()" + "End");
		return noOfRecords;
	}

	@Override
	public int retriveSquareZoneTopologyCount() {
		System.out.println("Class-->SquareZoneDAOImpl:Method-->" + "retriveSquareZoneTopologyCount()" + "Start");
		int noOfRecords = 0;
		try {
			noOfRecords = squareDao.retriveSquareZoneTopologyCount();
		} catch (Exception e) {
			System.out.println("Class-->SquareZoneDAOImpl:Method-->" + "retriveSquareZoneTopologyCount()" + " Exception"
					+ e.getMessage());
		}
		System.out.println("Class-->SquareZoneDAOImpl:Method-->" + "retriveSquareZoneTopologyCount()" + "End");
		return noOfRecords;
	}

	@Override
	public int retriveSquareZoneTopologyCountLEEACH() {
		System.out.println("Class-->SquareZoneDAOImpl:Method-->" + "retriveSquareZoneTopologyCountLEEACH()" + "Start");
		int noOfRecords = 0;
		try {
			noOfRecords = squareLeeachDao.retriveSquareZoneTopologyCount();
		} catch (Exception e) {
			System.out.println("Class-->SquareZoneDAOImpl:Method-->" + "retriveSquareZoneTopologyCountLEEACH()"
					+ " Exception" + e.getMessage());
		}
		System.out.println("Class-->SquareZoneDAOImpl:Method-->" + "retriveSquareZoneTopologyCountLEEACH()" + "End");
		return noOfRecords;
	}

	@Override
	public int retriveVerticalTopologyCount() {
		System.out.println("Class-->VerticalDAOImpl:Method-->" + "retriveVerticalTopologyCount()" + "Start");
		int noOfRecords = 0;
		try {
			noOfRecords = verticalDao.retriveVerticalTopologyCount();
		} catch (Exception e) {
			System.out.println("Class-->VerticalDAOImpl:Method-->" + "retriveVerticalTopologyCount()" + " Exception"
					+ e.getMessage());
		}
		System.out.println("Class-->VerticalDAOImpl:Method-->" + "retriveVerticalTopologyCount()" + "End");
		return noOfRecords;
	}

	@Override
	public boolean clearAllSquareZoneLeaderInfo() {

		System.out.println("Class-->TopologyRoutingServiceImpl-->" + "clearAllSquareZoneLeaderInfo()" + "Start");
		boolean noOfRecords = false;
		List<Integer> nodeIds = null;
		try {

			nodeIds = new ArrayList<Integer>();
			nodeIds = squareDao.retriveZoneLeaders();
			if (nodeIds != null) {
				for (Integer nodeId : nodeIds) {

					boolean flag = squareDao.updateNodeIdWithLeaderSquareZone(nodeId,
							TopologyConstantsIF.NOT_ZONELEADER);
					if (flag == false) {
						return false;
					}

				}
				return true;
			}

		} catch (Exception e) {
			System.out.println("Class-->TopologyRoutingServiceImpl:Method-->" + "clearAllSquareZoneLeaderInfo()"
					+ " Exception" + e.getMessage());
		}
		System.out.println("Class-->TopologyRoutingServiceImpl:Method-->" + "clearAllSquareZoneLeaderInfo()" + "End");
		return noOfRecords;

	}

	@Override
	public boolean clearAllSquareZoneLeaderInfoLEEACH() {

		System.out.println("Class-->TopologyRoutingServiceImpl-->" + "clearAllSquareZoneLeaderInfoLEEACH()" + "Start");
		boolean noOfRecords = false;
		List<Integer> nodeIds = null;
		try {

			nodeIds = new ArrayList<Integer>();
			nodeIds = squareLeeachDao.retriveZoneLeaders();
			if (nodeIds != null) {
				for (Integer nodeId : nodeIds) {

					boolean flag = squareLeeachDao.updateNodeIdWithLeaderSquareZone(nodeId,
							TopologyConstantsIF.NOT_ZONELEADER);
					if (flag == false) {
						return false;
					}

				}
				return true;
			}

		} catch (Exception e) {
			System.out.println("Class-->TopologyRoutingServiceImpl:Method-->" + "clearAllSquareZoneLeaderInfoLEEACH()"
					+ " Exception" + e.getMessage());
		}
		System.out.println(
				"Class-->TopologyRoutingServiceImpl:Method-->" + "clearAllSquareZoneLeaderInfoLEEACH()" + "End");
		return noOfRecords;
	}

	@Override
	public List<Integer> retriveDistinctZoneIDs() {
		System.out.println("Class-->TopologyRoutingServiceImpl-->" + "retriveDistinctZoneIDs()" + "Start");
		List<Integer> nodeIds = null;
		try {

			nodeIds = new ArrayList<Integer>();
			nodeIds = squareDao.retriveDistinctSquareZoneIds();
			if (nodeIds != null) {

				return nodeIds;
			}

		} catch (Exception e) {
			System.out.println("Class-->TopologyRoutingServiceImpl:Method-->" + "retriveDistinctZoneIDs()"
					+ " Exception" + e.getMessage());
		}
		System.out.println("Class-->TopologyRoutingServiceImpl:Method-->" + "retriveDistinctZoneIDs()" + "End");
		return nodeIds;
	}

	@Override
	public List<Integer> retriveDistinctZoneIDsLEEACH() {
		System.out.println("Class-->TopologyRoutingServiceImpl-->" + "retriveDistinctZoneIDsLEEACH()" + "Start");
		List<Integer> nodeIds = null;
		try {

			nodeIds = new ArrayList<Integer>();
			nodeIds = squareLeeachDao.retriveDistinctSquareZoneIds();
			if (nodeIds != null) {

				return nodeIds;
			}

		} catch (Exception e) {
			System.out.println("Class-->TopologyRoutingServiceImpl:Method-->" + "retriveDistinctZoneIDsLEEACH()"
					+ " Exception" + e.getMessage());
		}
		System.out.println("Class-->TopologyRoutingServiceImpl:Method-->" + "retriveDistinctZoneIDsLEEACH()" + "End");
		return nodeIds;
	}

	@Override
	public boolean updateNodeIdWithLeaderSquareZone(int nodeId, int leaderValue) {

		System.out.println(
				CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateNodeIdWithLeaderSquareZone" + ARROW + START);
		boolean generationFlag = false;
		try {
			boolean value = squareDao.updateNodeIdWithLeaderSquareZone(nodeId, leaderValue);
			if (value) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Exception:-->" + e.getMessage());
			generationFlag = false;
			return generationFlag;
		}
		System.out
				.println(CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateNodeIdWithLeaderSquareZone" + ARROW + END);
		return generationFlag;
	}

	@Override
	public boolean updateNodeIdWithLeaderSquareZoneLEEACH(int nodeId, int leaderValue) {
		System.out.println(
				CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateNodeIdWithLeaderSquareZoneLEEACH" + ARROW + START);
		boolean generationFlag = false;
		try {
			boolean value = squareLeeachDao.updateNodeIdWithLeaderSquareZone(nodeId, leaderValue);
			if (value) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Exception:-->" + e.getMessage());
			generationFlag = false;
			return generationFlag;
		}
		System.out.println(
				CLASS_COLON + CLASS_NAME + ARROW + METHOD + "updateNodeIdWithLeaderSquareZoneLEEACH" + ARROW + END);
		return generationFlag;
	}

	@Override
	public List<Integer> retriveDistinctZoneIDsForAngular() {
		System.out.println("Class-->TopologyRoutingServiceImpl-->" + "retriveDistinctZoneIDsForAngular()" + "Start");
		List<Integer> nodeIds = null;
		try {
			nodeIds = new ArrayList<Integer>();
			nodeIds = angularDao.retriveDistinctZoneIDsForAngular();
			if (nodeIds != null) {
				return nodeIds;
			}
		} catch (Exception e) {
			System.out.println("Class-->TopologyRoutingServiceImpl:Method-->" + "retriveDistinctZoneIDsForAngular()"
					+ " Exception" + e.getMessage());
		}
		System.out
				.println("Class-->TopologyRoutingServiceImpl:Method-->" + "retriveDistinctZoneIDsForAngular()" + "End");
		return nodeIds;
	}

	@Override
	public boolean clearAllAngularZoneLeaderInfo() {
		System.out.println("Class-->TopologyRoutingServiceImpl-->" + "clearAllAngularZoneLeaderInfo()" + "Start");
		boolean noOfRecords = false;
		List<Integer> nodeIds = null;
		try {

			nodeIds = new ArrayList<Integer>();
			nodeIds = angularDao.retriveZoneLeadersForAngular();
			if (nodeIds != null) {
				for (Integer nodeId : nodeIds) {

					boolean flag = angularDao.updateNodeIdWithLeaderAngularZone(nodeId,
							TopologyConstantsIF.NOT_ZONELEADER);
					if (flag == false) {
						return false;
					}

				}
				return true;
			}

		} catch (Exception e) {
			System.out.println("Class-->TopologyRoutingServiceImpl:Method-->" + "clearAllAngularZoneLeaderInfo()"
					+ " Exception" + e.getMessage());
		}
		System.out.println("Class-->TopologyRoutingServiceImpl:Method-->" + "clearAllAngularZoneLeaderInfo()" + "End");
		return noOfRecords;
	}

	@Override
	public List<NodeInfoForSquare> retriveNodeIdsForZoneId(int zoneId, String topologyType) {

		List<NodeInfoForSquare> nodeIdList = null;
		try {
			nodeIdList = new ArrayList<NodeInfoForSquare>();

			if (topologyType.equals(TopologyTypesIF.SQUARE_TOPOLOGY)) {
				nodeIdList = squareDao.retriveNodeInfoForZoneIDSquareZone(zoneId);
			}
			if (topologyType.equals(TopologyTypesIF.LEEACH_TOPOLOGY)) {
				nodeIdList = squareLeeachDao.retriveNodeInfoForZoneIDSquareZone(zoneId);
			}

		} catch (Exception e) {
			return null;
		}
		return nodeIdList;
	}

	@Override
	public int retriveZoneLeaderOfNodeForSquareZone(Integer zoneId) {
		System.out.println(
				"Class-->TopologyRoutingServiceImpl:Method-->" + "retriveZoneLeaderOfNodeForSquareZone()" + "Start");
		int zoneLeader = 0;
		try {
			zoneLeader = squareDao.retriveZoneLeaderForZoneId(zoneId);
		} catch (Exception e) {
			System.out.println("Class-->TopologyRoutingServiceImpl:Method-->"
					+ "retriveZoneLeaderOfNodeForSquareZone()-->Exception" + e.getMessage());
		}
		System.out.println(
				"Class-->TopologyRoutingServiceImpl:Method-->" + "retriveZoneLeaderOfNodeForSquareZone()-->End");
		return zoneLeader;
	}

	@Override
	public TopologyInfoValue retriveTopologyForNodeIdSquareTopology(int nodeId) {
		System.out.println("Class-->RandomDAOImpl:Method-->" + "retriveTopologyForNodeIdSquareTopology()" + "Start");
		TopologyInfoValue topologyInfoValue = null;
		try {
			topologyInfoValue = squareDao.retriveTopologyForNodeIdSquareTopology(nodeId);
		} catch (Exception e) {
			System.out.println("Class-->RandomDAOImpl:Method-->" + "retriveTopologyForNodeIdSquareTopology() Exception"
					+ e.getMessage());
		}
		System.out.println("Class-->RandomDAOImpl:Method-->" + "retriveTopologyForNodeIdSquareTopology()" + "End");
		return topologyInfoValue;
	}

	public List<Integer> findNodesWhichAreNotInvolvedForReplication(List<Integer> listDistinctForPaymentSave,
			String topologyType) {
		
		List<Integer> nodesList = null;
		try{
			if(topologyType.equals(TopologyTypesIF.LINEAR_TOPOLOGY)){
				
				nodesList = linearDao.findNodesNotInvolvedInRouting(listDistinctForPaymentSave);
			}else{
				nodesList = randomDao.findNodesNotInvolvedInRouting(listDistinctForPaymentSave);
			}
			
		}catch(Exception e){
			
		}
		
		return nodesList;
	}

}
