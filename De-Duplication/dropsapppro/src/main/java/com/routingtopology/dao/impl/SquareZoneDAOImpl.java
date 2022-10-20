package com.routingtopology.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.routingtopology.constants.TopologyConstantsIF;
import com.routingtopology.dao.inter.SquareZoneDAOIF;
import com.routingtopology.exception.RoutingException;
import com.routingtopology.value.NodeId;
import com.routingtopology.value.NodeInfoForSquare;
import com.routingtopology.value.TopologyInfoValue;

@Repository
public class SquareZoneDAOImpl extends RoutingDaoImpl implements
		SquareZoneDAOIF {

	private static final String CLASS_NAME = "Class:SquareZoneDAOImpl--->";
	private static final String METHOD_NAME = "Method:";
	private static final String START_NAME = "START";
	private static final String END_NAME = "END";

	@Override
	public boolean deleteSquareZoneTopology() {
		System.out
				.println("Class-->SquareZoneDAOImpl:Method-->deleteSquareZoneTopology() Start");

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_SQUAREZONETOPOLOGY_QUERY);
		} catch (Exception e) {
			System.out
					.println("Class-->SquareZoneDAOImpl:Method-->deleteSquareZoneTopology() Exception"
							+ e.getMessage());
			deleteFlag = false;
			return deleteFlag;
		}
		System.out
				.println("Class-->SquareZoneDAOImpl:Method-->deleteSquareZoneTopology() End");
		return deleteFlag;

	}

	@Override
	public boolean insertSquareZoneTopology(
			List<TopologyInfoValue> topologyInfoValue) throws RoutingException {

		System.out.println(CLASS_NAME + METHOD_NAME
				+ "insertSquareZoneTopology()" + START_NAME);
		boolean insertAngularTopology = false;
		try {
			insertAngularTopology = insertTopologyWithSquareConfig(
					topologyInfoValue, INSERT_SQUAREZONETOPOLOGY_QUERY);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "insertSquareZoneTopology()" + "Exception:"
					+ e.getMessage());
			insertAngularTopology = false;
			return insertAngularTopology;
		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "insertSquareZoneTopology()" + END_NAME);
		return insertAngularTopology;

	}

	@Override
	public List<TopologyInfoValue> retriveSquareZoneTopology()
			throws RoutingException {
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveSquareZoneTopology()" + START_NAME);
		List<TopologyInfoValue> topologyInfoValueList = null;
		try {
			topologyInfoValueList = retriveTopologyWithSquareConfig(RETRIVE_SQUARETOPOLOGY_QUERY);
		} catch (DataAccessException dae) {
			throw new RoutingException(dae.getMessage());
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveSquareZoneTopology() Exception" + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveSquareZoneTopology() End");
		return topologyInfoValueList;
	}

	@Override
	public boolean updateSquareZoneTopology(
			List<TopologyInfoValue> topologyInfoValue) {

		System.out.println(CLASS_NAME + METHOD_NAME
				+ "updateSquareZoneTopology()" + START_NAME);
		boolean updationFlag = false;
		try {
			if (topologyInfoValue != null && topologyInfoValue.size() > 0) {
				for (TopologyInfoValue topInfoValue : topologyInfoValue) {
					Map<String, Object> map = createTopologyMapWithSquare(topInfoValue);
					update(UPDATE_SQUAREZONETOPOLOGY_QUERY, map);
					updationFlag = true;
				}
			}

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "updateSquareZoneTopology()" + "Exception-->"
					+ e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "updateSquareZoneTopology()" + END_NAME);
		return updationFlag;
	}

	@Override
	public List<Integer> retriveDistinctSquareZoneIds() {
		// TODO Auto-generated method stub
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveDistinctSquareZoneIds()" + START_NAME);
		List<Integer> topologyInfoValueList = null;
		try {
			topologyInfoValueList = retriveZoneIDs(RETRIVE_ZONEIDSQUARETOPOLOGY);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveDistinctSquareZoneIds() Exception"
					+ e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveDistinctSquareZoneIds()" + END_NAME);
		return topologyInfoValueList;
	}

	@Override
	public boolean updateNodeIdWithLeaderSquareZone(int nodeId, int leaderValue) {
		// TODO Auto-generated method stub
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "updateNodeIdWithLeaderSquareZone()" + START_NAME);
		boolean updationFlag = false;
		// making greater than =0
		try {
			if (nodeId > 0 && leaderValue >= 0) {
				Map<String, Object> map = createMapNodeIdLeaderValue(nodeId,
						leaderValue);
				update(UPDATE_ZONELEADER_FORNODEID_SQUARETOPOLOGY, map);
				updationFlag = true;

			}

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "updateNodeIdWithLeaderSquareZone()" + "Exception-->"
					+ e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "updateNodeIdWithLeaderSquareZone()" + END_NAME);
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
	public List<NodeInfoForSquare> retriveNodeInfoForZoneIDSquareZone(int zoneId) {
		// TODO Auto-generated method stub
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveNodeInfoForZoneIDSquareZone()" + START_NAME);
		List<NodeInfoForSquare> topologyInfoValueList = null;
		try {
			topologyInfoValueList = retriveTopologyWithSquareConfigLimited(
					RETRIVE_NODEIDS_DETAILS_FOR_ZONEID_SQUARETOPOLOGY,
					createMapForZoneId(zoneId));

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveNodeInfoForZoneIDSquareZone() Exception"
					+ e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveNodeInfoForZoneIDSquareZone()" + END_NAME);
		return topologyInfoValueList;
	}

	private Map<String, Object> createMapForZoneId(int zoneId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(TopologyConstantsIF.ZONEID_COL, zoneId);
		return map;
	}

	private Map<String, Object> createMapForZoneLeader(boolean zoneLeader) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(TopologyConstantsIF.ZONELEADER_COL, zoneLeader);
		return map;
	}

	@Override
	public int retriveSquareZoneTopologyCount() {
		System.out.println("Class-->SquareZoneDAOImpl:Method-->"
				+ "retriveSquareZoneTopologyCount()" + "Start");
		int noOfRecords = 0;
		try {
			noOfRecords = queryForInt(RETRIVE_SQUARETOPOLOGY_COUNT);
		} catch (Exception e) {
			System.out.println("Class-->SquareZoneDAOImpl:Method-->"
					+ "retriveSquareZoneTopologyCount()" + " Exception"
					+ e.getMessage());
		}
		System.out.println("Class-->SquareZoneDAOImpl:Method-->"
				+ "retriveSquareZoneTopologyCount()" + "End");
		return noOfRecords;
	}

	@Override
	public List<Integer> retriveZoneLeaders() {
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveZoneLeaders()"
				+ START_NAME);
		List<Integer> nodeIdList = null;
		try {
			nodeIdList = retriveZoneLeaders(
					RETRIVE_NODEIDS_WHO_ARE_ZONE_LEADERS_SQUARE_TOPOLOGY,
					createMapForZoneLeader(true));

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveZoneLeaders() Exception" + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveZoneLeaders()"
				+ END_NAME);
		return nodeIdList;
	}

	@Override
	public int retriveZoneLeaderForZoneId(Integer zoneId) {
		List<NodeId> zoneLeader = null;
		try {
			String sql = sqlProperties.getMessage(
					RETRIVE_ZONELEADER_FOR_ZONEID_SQUARE_TOPOLOGY_SQL, null,
					null);
			zoneLeader = namedJdbcTemplate.query(sql, createZoneIdMap(zoneId),
					new NodeIdMapper());

		} catch (Exception e) {
			System.out
					.println(CLASS_NAME + METHOD_NAME
							+ "retriveZoneLeaderForZoneId() Exception"
							+ e.getMessage());
			return 0;
		}
		return zoneLeader.get(0).getNodeId();

	}

	final class NodeIdMapper implements RowMapper<NodeId> {
		public NodeId mapRow(ResultSet rs, int arg1) throws SQLException {
			NodeId nodeId = new NodeId();
			nodeId.setNodeId(rs.getInt(TopologyConstantsIF.NODEID_COL));
			return nodeId;
		}
	}

	private Map<String, Object> createZoneIdMap(int zoneId) {
		Map<String, Object> zoneIdMap = new HashMap<String, Object>();
		zoneIdMap.put(ZONEID, zoneId);
		zoneIdMap.put(ZONELEADER, ZONELEADER_FLAG);
		return zoneIdMap;
	}

	@Override
	public TopologyInfoValue retriveTopologyForNodeIdSquareTopology(int nodeId) {

		TopologyInfoValue topologyInfo = null;
		try {

			String sql = sqlProperties.getMessage(
					RETRIVE_SQUARETOPOLOGY_FOR_NODEID_SQL, null, null);
			topologyInfo = namedJdbcTemplate.queryForObject(sql,
					createNodeIdMap(nodeId), new TopologyInfoValueMapper());

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveTopologyForNodeIdSquareTopology() Exception"
					+ e.getMessage());
			return null;
		}
		return topologyInfo;
	}

	private Map<String, Object> createNodeIdMap(int nodeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(NODEID, nodeId);
		return map;
	}

}