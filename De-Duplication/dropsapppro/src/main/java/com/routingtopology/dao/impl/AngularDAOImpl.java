package com.routingtopology.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.routingtopology.constants.TopologyConstantsIF;
import com.routingtopology.dao.inter.AngularDAOIF;
import com.routingtopology.exception.RoutingException;
import com.routingtopology.value.TopologyInfoValue;

/**
 * This is a DAO class for angular topology formation
 **/
@Repository
public class AngularDAOImpl extends RoutingDaoImpl implements AngularDAOIF {

	private static final String CLASS_NAME = "Class--->AngularDAOImpl:";

	private static final String METHOD_NAME = "Method--->";

	private static final String START_NAME = "START";

	private static final String END_NAME = "END";

	@Override
	public boolean deleteAngularTopology() {
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteAngularTopology()"
				+ START_NAME);
		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_ANGULARTOPOLOGY_QUERY);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "deleteAngularTopology()Exception" + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteAngularTopology()"
				+ END_NAME);
		return deleteFlag;
	}

	@Override
	public boolean insertAngularTopology(
			List<TopologyInfoValue> topologyInfoValue) throws RoutingException {
		System.out.println(CLASS_NAME + METHOD_NAME + "insertAngularTopology()"
				+ START_NAME);
		boolean insertAngularTopology = false;
		try {
			insertAngularTopology = insertTopologyWithAngularTopology(
					topologyInfoValue, INSERT_ANGULARTOPOLOGY_QUERY);
		} catch (Exception e) {
			System.out
					.println(CLASS_NAME + METHOD_NAME
							+ "insertAngularTopology()" + "Exception:"
							+ e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "insertAngularTopology()"
				+ END_NAME);
		return insertAngularTopology;
	}

	@Override
	public List<TopologyInfoValue> retriveAngularTopology()
			throws RoutingException {
		// TODO Auto-generated method stub
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveAngularTopology()" + START_NAME);
		List<TopologyInfoValue> topologyInfoValueList = null;
		try {
			topologyInfoValueList = retriveTopologyWithAngular(RETRIVE_ANGULARTOPOLOGY_QUERY);

		} catch (DataAccessException dae) {
			throw new RoutingException(dae.getMessage());
		} catch (Exception e) {
			System.out
					.println(CLASS_NAME + METHOD_NAME+"retriveAngularTopology() Exception"
							+ e.getMessage());
		}
		System.out
				.println(CLASS_NAME + METHOD_NAME+"retriveAngularTopology() End");
		return topologyInfoValueList;
	}

	@Override
	public boolean updateAngularTopology(
			List<TopologyInfoValue> topologyInfoValue) {
		// TODO Auto-generated method stub
		System.out.println(CLASS_NAME + METHOD_NAME + "updateAngularTopology()"
				+ START_NAME);
		boolean updationFlag = false;
		try {
			if (topologyInfoValue != null && topologyInfoValue.size() > 0) {
				for (TopologyInfoValue topInfoValue : topologyInfoValue) {
					Map<String, Object> map = createTopologyMapWithAngular(topInfoValue);
					update(UPDATE_ANGULARTOPOLOGY_QUERY, map);
					updationFlag = true;
				}
			}

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "updateAngularTopology()" + "Exception-->"
					+ e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "updateAngularTopology()"
				+ END_NAME);
		return updationFlag;
	}

	@Override
	public List<Integer> retriveDistinctZoneIds() {
		// TODO Auto-generated method stub
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveDistinctZoneIds()" + START_NAME);
		List<Integer> topologyInfoValueList = null;
		try {
			topologyInfoValueList = retriveZoneIDs(RETRIVE_ZONEIDANGULARTOPOLOGY_QUERY);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveDistinctZoneIds() Exception" + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveDistinctZoneIds()" + END_NAME);
		return topologyInfoValueList;
	}

	@Override
	public boolean updateNodeIdWithLeader(int nodeId, int leaderValue) {
		// TODO Auto-generated method stub
		System.out.println(CLASS_NAME + METHOD_NAME + "updateNodeIdWithLeader()"
				+ START_NAME);
		boolean updationFlag = false;
		try {
			if (nodeId>0 && leaderValue > 0) {
				Map<String, Object> map =createMapNodeIdLeaderValue(nodeId,leaderValue) ;
				update(UPDATE_ZONELEADER_FORNODEID_ANGULARTOPOLOGY_QUERY, map);
				updationFlag = true;
				
			}

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "updateAngularTopology()" + "Exception-->"
					+ e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "updateAngularTopology()"
				+ END_NAME);
		return updationFlag;
	}

	private Map<String, Object> createMapNodeIdLeaderValue(int nodeId,
			int leaderValue) {
		Map<String, Object> mapValue = new HashMap<String, Object>();
		mapValue.put(TopologyConstantsIF.NODEID_COL, nodeId);
		mapValue.put(TopologyConstantsIF.ZONELEADER_COL, leaderValue);
		return mapValue;
	}

	@Override
	public List<Integer> retriveNodeIdsForZoneID(int zoneId) {
		// TODO Auto-generated method stub
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveDistinctZoneIds()" + START_NAME);
		List<Integer> topologyInfoValueList = null;
		try {
			topologyInfoValueList = executeForListOfInt(
					RETRIVE_NODEIDS_FOR_ZONEID_ANGULARTOPOLOGY_QUERY,
					createMapForZoneId(zoneId));

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveDistinctZoneIds() Exception" + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveDistinctZoneIds()" + END_NAME);
		return topologyInfoValueList;
	}

	private Map<String, Object> createMapForZoneId(int zoneId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(TopologyConstantsIF.ZONEID_COL, zoneId);
		return map;
	}

	@Override
	public int retriveAngularTopologyCount() {
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveAngularTopologyCount()" + START_NAME);
		int noOfRecords = 0;
		try {

			String sql = sqlProperties.getMessage(RETRIVE_ANGULARTOPOLOGY_COUNT, null, null);

			Map<String, Object> paramMap = null;

			noOfRecords = namedJdbcTemplate.queryForObject(sql, paramMap, Integer.class);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "retriveAngularTopologyCount() Exception" + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveAngularTopologyCount()" + END_NAME);
		return noOfRecords;
	}

	@Override
	public List<Integer> retriveDistinctZoneIDsForAngular() {
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveDistinctSquareZoneIds()" + START_NAME);
		List<Integer> zoneIDList = null; 
		try {
			zoneIDList = retriveZoneIDs(RETRIVE_ZONEID_ANGULAR_TOPOLOGY);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveDistinctSquareZoneIds() Exception" + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveDistinctSquareZoneIds()" + END_NAME);
		return zoneIDList;
	}

	@Override
	public List<Integer> retriveZoneLeadersForAngular() {
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveZoneLeadersForAngular()" + START_NAME);
		List<Integer> nodeIdList = null; 
		try {
			nodeIdList = retriveZoneLeaders(RETRIVE_NODEIDS_WHO_ARE_ZONE_LEADERS_ANGULAR_TOPOLOGY,createMapForZoneLeader(true));

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveZoneLeadersForAngular() Exception" + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveZoneLeadersForAngular()" + END_NAME);
		return nodeIdList;
	}

	private Map<String, Object> createMapForZoneLeader(boolean zoneLeader) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(TopologyConstantsIF.ZONELEADER_COL,zoneLeader);
		return map;
	}
	@Override
	public boolean updateNodeIdWithLeaderAngularZone(Integer nodeId,
			int zoneLeader) {
		
		// TODO Auto-generated method stub
		System.out.println(CLASS_NAME + METHOD_NAME + "updateNodeIdWithLeaderAngularZone()"
				+ START_NAME);
		boolean updationFlag = false;
		//making greater than =0
		try {
			if (nodeId>0 && zoneLeader >=0) { 
				Map<String, Object> map =createMapNodeIdLeaderValue(nodeId,zoneLeader) ;
				update(UPDATE_ZONELEADER_FORNODEID_ANGULARTOPOLOGY, map);
				updationFlag = true;
				
			}

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "updateNodeIdWithLeaderAngularZone()" + "Exception-->"
					+ e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "updateNodeIdWithLeaderAngularZone()"
				+ END_NAME);
		return updationFlag;
	}
}
