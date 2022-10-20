package com.routingtopology.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.routingtopology.constants.RoutingServiceConstantsIF;
import com.routingtopology.constants.RoutingTableConstantsIF;
import com.routingtopology.constants.TopologyConstantsIF;
import com.routingtopology.dao.inter.RoutingTableDAOIF;
import com.routingtopology.service.inter.RoutingTableServiceIF;
import com.routingtopology.value.AngleBasedRoutingTable;
import com.routingtopology.value.AnglePos;
import com.routingtopology.value.ClusterHeads;
import com.routingtopology.value.LeaderInfoValue;
import com.routingtopology.value.NodeId;
import com.routingtopology.value.NodeParameters;
import com.routingtopology.value.NormalRoutingTable;
import com.routingtopology.value.PerformanceTimeTaken;
import com.routingtopology.value.TopologyInfoValue;
import com.routingtopology.value.VerticalRoutingTable;
import com.routingtopology.value.ZoneId;
import com.routingtopology.value.ZoneRoutingTable;

/**
 * This is the routing table DAO
 * 
 */
@Repository
public class RoutingTableDAOImpl extends RoutingDaoImpl implements
		RoutingTableDAOIF {

	private static final String CLASS_NAME = "Class:RoutingTableDAOImpl-->";

	private static final String METHOD_NAME = "Method:";

	private static final String START = "Start";

	private static final String END = "End";

	private static final String EXCEPTION = "Exception";

	@Override
	public boolean createTable(String intermediateQuery) {

		System.out.println(CLASS_NAME + METHOD_NAME + "createTable()" + START);
		boolean createTableFlag = false;
		try {

			createTableFlag = createTable(CREATE_RTTABLE_START_QUERY,
					intermediateQuery, CREATE_RTTABLE_END_QUERY);
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME + "createTable()"
					+ EXCEPTION + e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME + "createTable()" + END);

		return createTableFlag;

	}

	@Override
	public boolean dropTable(String intermediateQuery) {
		System.out.println(CLASS_NAME + METHOD_NAME + "dropTable()" + START);
		boolean dropTableFlag = false;
		try {

			dropTableFlag = dropTable(DROP_RTTABLE_START_QUERY,
					intermediateQuery);
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME + "dropTable()"
					+ EXCEPTION + e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME + "dropTable()" + END);

		return dropTableFlag;
	}

	@Override
	public boolean insertRoutingTable(NormalRoutingTable normalRoutingTable,
			String intermediateQuery) {
		System.out.println(CLASS_NAME + METHOD_NAME + "insertRoutingTable()"
				+ START);
		boolean insertTableFlag = false;
		try {

			insertTableFlag = insertDynamicQuery(INSERT_RTTABLE_START_QUERY,
					intermediateQuery, INSERT_RTTABLE_END_QUERY,
					createRoutingTableMap(normalRoutingTable));
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "insertRoutingTable()" + EXCEPTION + e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME + "insertRoutingTable()"
				+ END);
		return insertTableFlag;
	}

	@Override
	public boolean insertVerticalRoutingTable(
			VerticalRoutingTable verticalRoutingTable, String intermediateQuery) {
		System.out.println(CLASS_NAME + METHOD_NAME + "insertRoutingTable()"
				+ START);
		boolean insertTableFlag = false;
		try {

			insertTableFlag = insertDynamicQuery(INSERT_RTTABLE_START_QUERY,
					intermediateQuery, INSERT_VERTICAL_RTTABLE_END_QUERY,
					createVerticalRoutingTableMap(verticalRoutingTable));
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "insertRoutingTable()" + EXCEPTION + e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME + "insertRoutingTable()"
				+ END);
		return insertTableFlag;
	}

	private Map<String, Object> createRoutingTableMap(
			NormalRoutingTable normalRoutingTable) {
		Map<String, Object> createMap = new HashMap<String, Object>();
		createMap.put(TopologyConstantsIF.NODEID_COL, normalRoutingTable
				.getNodeId());
		createMap.put(TopologyConstantsIF.DISTANCE_COL, normalRoutingTable
				.getDistance());
		return createMap;
	}

	private Map<String, Object> createVerticalRoutingTableMap(
			VerticalRoutingTable normalRoutingTable) {
		Map<String, Object> createMap = new HashMap<String, Object>();
		createMap.put(TopologyConstantsIF.NODEID_COL, normalRoutingTable
				.getNodeId());
		createMap.put(TopologyConstantsIF.DISTANCE_COL, normalRoutingTable
				.getDistance());
		createMap.put(TopologyConstantsIF.VERTICALBELONG_COL,
				normalRoutingTable.getVerticalBelong());
		return createMap;
	}

	@Override
	public List<NormalRoutingTable> retriveNormalRoutingTables(
			String intermediateQuery) {
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveNormalRoutingTables()" + START);
		List<NormalRoutingTable> normalRoutingTableList = null;
		try {
			normalRoutingTableList = retriveNormalRoutingTable(
					SELECT_RTTABLE_START_QUERY, intermediateQuery);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveNormalRoutingTables()" + EXCEPTION
					+ e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveNormalRoutingTables()" + END);
		return normalRoutingTableList;
	}

	@Override
	public List<VerticalRoutingTable> retriveVerticalRoutingTables(
			String intermediateQuery) {
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveNormalRoutingTables()" + START);
		List<VerticalRoutingTable> normalRoutingTableList = null;
		try {
			normalRoutingTableList = retriveVerticalRoutingTable(
					SELECT_VERTICAL_RTTABLE_START_QUERY, intermediateQuery);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveNormalRoutingTables()" + EXCEPTION
					+ e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveNormalRoutingTables()" + END);
		return normalRoutingTableList;
	}

	@Override
	public boolean updateRoutingTable(NormalRoutingTable normalRoutingTable,
			String intermediateQuery) {
		System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTable()"
				+ START);
		boolean updateTableFlag = false;
		try {

			updateTableFlag = updateDynamicQuery(UPDATE_RTTABLE_START_QUERY,
					intermediateQuery, UPDATE_RTTABLE_END_QUERY,
					createRoutingTableMap(normalRoutingTable));
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "updateRoutingTable()" + EXCEPTION + e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTable()"
				+ END);
		return updateTableFlag;
	}

	@Override
	public boolean updateVerticalRoutingTable(
			VerticalRoutingTable normalRoutingTable, String intermediateQuery) {
		System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTable()"
				+ START);
		boolean updateTableFlag = false;
		try {

			updateTableFlag = updateDynamicQuery(UPDATE_RTTABLE_START_QUERY,
					intermediateQuery, UPDATE_VERTICAL_RTTABLE_END_QUERY,
					createVerticalRoutingTableMap(normalRoutingTable));
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "updateRoutingTable()" + EXCEPTION + e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME + "updateRoutingTable()"
				+ END);
		return updateTableFlag;
	}

	@Override
	public boolean createTableAngleBased(String intermediateQuery) {
		System.out.println(CLASS_NAME + METHOD_NAME + "createTableAngleBased()"
				+ START);
		boolean createTableFlag = false;
		try {

			createTableFlag = createTable(CREATE_RTTABLE_START_QUERY,
					intermediateQuery, CREATE_ANGLEBASED_RTTABLE_END_QUERY);
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "createTableAngleBased()" + EXCEPTION + e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME + "createTableAngleBased()"
				+ END);
		return createTableFlag;
	}

	@Override
	public boolean createTableZoneBased(String intermediateQuery) {
		System.out.println(CLASS_NAME + METHOD_NAME + "createTableZoneBased()"
				+ START);
		boolean createTableFlag = false;
		try {

			createTableFlag = createTable(CREATE_RTTABLE_START_QUERY,
					intermediateQuery, CREATE_ZONEBASEDTABLE_END_QUERY);
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "createTableZoneBased()" + EXCEPTION + e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME + "createTableZoneBased()"
				+ END);
		return createTableFlag;
	}

	@Override
	public boolean dropTableAngleBased(String intermediateQuery) {
		System.out.println(CLASS_NAME + METHOD_NAME + "dropTableAngleBased()"
				+ START);
		boolean dropTableAngleFlag = false;
		try {

			dropTableAngleFlag = dropTable(DROP_RTTABLE_START_QUERY,
					intermediateQuery);
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "dropTableAngleBased()" + EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "dropTableAngleBased()"
				+ END);
		return dropTableAngleFlag;
	}

	@Override
	public boolean dropTableZoneBased(String intermediateQuery) {
		System.out.println(CLASS_NAME + METHOD_NAME + "dropTableZoneBased()"
				+ START);
		boolean dropTableFlag = false;
		try {

			dropTableFlag = dropTable(DROP_RTTABLE_START_QUERY,
					intermediateQuery);
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "dropTableZoneBased()" + EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "dropTableZoneBased()"
				+ END);
		return dropTableFlag;
	}

	@Override
	public boolean insertRoutingTableZoneBased(
			ZoneRoutingTable zoneRoutingTable, String intermediateQuery) {
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "insertRoutingTableZoneBased()" + START);
		boolean insertZoneBasedTableFlag = false;
		try {

			insertZoneBasedTableFlag = insertDynamicQuery(
					INSERT_RTTABLE_START_QUERY, intermediateQuery,
					INSERT_ZONEBASED_RTTABLE_END_QUERY,
					createZoneBasedRoutingTableMap(zoneRoutingTable));
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "insertRoutingTableZoneBased()" + EXCEPTION
					+ e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "insertRoutingTableZoneBased()" + END);
		return insertZoneBasedTableFlag;

	}

	private Map<String, Object> createZoneBasedRoutingTableMap(
			ZoneRoutingTable zoneRoutingTable) {
		Map<String, Object> createMap = new HashMap<String, Object>();
		createMap.put(TopologyConstantsIF.NODEID_COL, zoneRoutingTable
				.getNodeId());
		createMap.put(TopologyConstantsIF.DISTANCE_COL, zoneRoutingTable
				.getDistance());
		createMap.put(TopologyConstantsIF.ZONEID_COL, zoneRoutingTable
				.getZoneId());
		System.out.println("zone idsjkjaskjdk" + zoneRoutingTable.getZoneId());
		createMap.put(TopologyConstantsIF.ZONELEADER_COL, zoneRoutingTable
				.isZoneLeader() == true ? 1 : 0);
		return createMap;
	}

	@Override
	public List<ZoneRoutingTable> retriveZoneBasedRoutingTables(
			String intermediateQuery) {
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveZoneBasedRoutingTables()" + START);
		List<ZoneRoutingTable> zoneBasedRoutingTableList = null;
		try {
			zoneBasedRoutingTableList = queryForZoneRoutingTopology(
					SELECT_ZONEBASED_RTTABLE_START_QUERY, intermediateQuery);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveZoneBasedRoutingTables()" + EXCEPTION
					+ e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveZoneBasedRoutingTables()" + END);
		return zoneBasedRoutingTableList;
	}

	@Override
	public boolean updateRoutingTableZoneBased(
			ZoneRoutingTable zoneRoutingTable, String intermediateQuery) {
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "updateRoutingTableZoneBased()" + START);
		boolean updateTableFlag = false;
		try {

			updateTableFlag = updateDynamicQuery(UPDATE_RTTABLE_START_QUERY,
					intermediateQuery, UPDATE_ZONEBASED_RTTABLE_END_QUERY,
					createZoneBasedRoutingTableMap(zoneRoutingTable));
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "updateRoutingTableZoneBased()" + EXCEPTION
					+ e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "updateRoutingTableZoneBased()" + END);
		return updateTableFlag;
	}

	@Override
	public boolean insertRoutingTableAngleBased(
			AngleBasedRoutingTable angleRoutingTable, String intermediateQuery) {

		System.out.println(CLASS_NAME + METHOD_NAME
				+ "insertRoutingTableAngleBased()" + START);
		boolean insertZoneBasedTableFlag = false;
		try {

			insertZoneBasedTableFlag = insertDynamicQuery(
					INSERT_RTTABLE_START_QUERY, intermediateQuery,
					INSERT_ANGLEBASED_RTTABLE_END_QUERY,
					createAngleBasedRoutingTableMap(angleRoutingTable));
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "insertRoutingTableAngleBased()" + EXCEPTION
					+ e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "insertRoutingTableAngleBased()" + END);
		return insertZoneBasedTableFlag;

	}

	private Map<String, Object> createAngleBasedRoutingTableMap(
			AngleBasedRoutingTable angleRoutingTable) {
		Map<String, Object> createMap = new HashMap<String, Object>();
		createMap.put(TopologyConstantsIF.NODEID_COL, angleRoutingTable
				.getNodeId());
		createMap.put(TopologyConstantsIF.ZONEID_COL, angleRoutingTable
				.getZoneId());
		createMap.put(TopologyConstantsIF.ZONELEADER_COL, angleRoutingTable
				.isZoneLeader() == true ? 1 : 0);
		createMap.put(TopologyConstantsIF.ANGULARPOSWITHBS_COL,
				angleRoutingTable.getAngularPos());
		createMap.put(TopologyConstantsIF.CLOSERTOOBSTRACLE_COL,
				angleRoutingTable.getCloseToObs());
		return createMap;

	}

	@Override
	public boolean updateRoutingTableAngleBased(
			AngleBasedRoutingTable angleRoutingTable, String intermediateQuery) {

		System.out.println(CLASS_NAME + METHOD_NAME
				+ "updateRoutingTableAngleBased()" + START);
		boolean updateTableFlag = false;
		try {

			updateTableFlag = updateDynamicQuery(UPDATE_RTTABLE_START_QUERY,
					intermediateQuery, UPDATE_ANGLEBASED_RTTABLE_END_QUERY,
					createAngleBasedRoutingTableMap(angleRoutingTable));
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "updateRoutingTableAngleBased()" + EXCEPTION
					+ e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "updateRoutingTableAngleBased()" + END);
		return updateTableFlag;
	}

	@Override
	public List<AngleBasedRoutingTable> retriveAngleBasedRoutingTables(
			String intermediateQuery) {

		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveZoneBasedRoutingTables()" + START);
		List<AngleBasedRoutingTable> zoneBasedRoutingTableList = null;
		try {
			zoneBasedRoutingTableList = queryForAngleBasedRoutingTable(
					SELECT_ANGLEBASED_RTTABLE_START_QUERY, intermediateQuery);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveZoneBasedRoutingTables()" + EXCEPTION
					+ e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveZoneBasedRoutingTables()" + END);
		return zoneBasedRoutingTableList;
	}

	@Override
	public boolean deleteRoutingTable(String tableToDelete) {
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteRoutingTable()"
				+ START);
		boolean deleteTableFlag = false;
		try {

			String sql1 = sqlProperties.getMessage(DELETE_RTTABLE_START_QUERY,
					null, null, null);
			String sql2 = SPACE + tableToDelete;
			String sql = sql1 + sql2;
			System.out.println("Class:RoutingTableDAOImpl" + sql);
			deleteTableFlag = deleteWithCompleteQuery(sql);
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "deleteRoutingTable()" + EXCEPTION + e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteRoutingTable()"
				+ END);
		return deleteTableFlag;
	}

	@Override
	public boolean deleteFromRoutingTable(String tableToDelete,
			int nodeIdWhichToDelete) {
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "deleteFromRoutingTable()" + START);
		boolean deleteTableFlag = false;
		try {

			String sql1 = sqlProperties.getMessage(DELETE_RTTABLE_START_QUERY,
					null, null, null);
			String sql2 = SPACE + tableToDelete;
			String sql = sql1 + sql2;
			System.out.println("Class:RoutingTableDAOImpl" + sql);
			Map<String, Object> map;
			deleteTableFlag = deleteWithCompleteQuery(sql,
					createNodeIdMap(nodeIdWhichToDelete));
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "deleteRoutingTable()" + EXCEPTION + e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "deleteFromRoutingTable()" + END);
		return deleteTableFlag;
	}

	private Map<String, Object> createNodeIdMap(int nodeIdWhichToDelete) {
		Map<String, Object> nodeIdMap = new HashMap<String, Object>();
		nodeIdMap.put(RoutingTableConstantsIF.NODEID, nodeIdWhichToDelete);
		return nodeIdMap;
	}

	private Map<String, Object> createZoneIdMap(int zoneIdWhichToDelete) {
		Map<String, Object> zoneIdMap = new HashMap<String, Object>();
		zoneIdMap.put(RoutingTableConstantsIF.ZONEID, zoneIdWhichToDelete);
		return zoneIdMap;
	}

	private Map<String, Object> createZoneIdAndZoneLeaderMap(
			int zoneIdWhichToDelete, int zoneLeader) {
		Map<String, Object> zoneIdAndZoneLeaderMap = new HashMap<String, Object>();
		zoneIdAndZoneLeaderMap.put(RoutingTableConstantsIF.ZONEID,
				zoneIdWhichToDelete);
		zoneIdAndZoneLeaderMap.put(RoutingTableConstantsIF.ZONELEADER,
				zoneLeader);
		return zoneIdAndZoneLeaderMap;
	}

	@Override
	public boolean createTableVerticalBased(String intermediateQuery) {
		System.out.println(CLASS_NAME + METHOD_NAME + "createTableAngleBased()"
				+ START);
		boolean createTableFlag = false;
		try {

			createTableFlag = createTable(CREATE_RTTABLE_START_QUERY,
					intermediateQuery, CREATE_VERTICALBASED_RTTABLE_END_QUERY);
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "createTableAngleBased()" + EXCEPTION + e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME + "createTableAngleBased()"
				+ END);
		return createTableFlag;
	}

	@Override
	public int retriveZoneIdBasedOnNodeId(String tableName, int nodeId) {
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveZoneIdBasedOnNodeId()" + START);
		int zoneId = -1;
		try {

			/*
			 * SqlParameterSource parameterSource = new MapSqlParameterSource(
			 * RoutingTableConstantsIF.NODEID, nodeId);
			 */
			String sql1 = sqlProperties.getMessage(RETRIVE_RT_ZONEID_START,
					null, null, null);
			String sql2 = SPACE + tableName + SPACE;
			String sql3 = sqlProperties.getMessage(WHERE_CLAUSE_NODEID, null,
					null, null);

			String sql = sql1 + sql2 + sql3;
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveZoneIdBasedOnNodeId()" + "SQL=" + sql);
			// zoneId = namedJdbcTemplate.queryForInt(sql, parameterSource);

			List<ZoneId> zoneIdList = queryForZoneId(sql,
					createNodeIdMap(nodeId));
			System.out.println("Zone ID List=" + zoneIdList);
			if (zoneIdList != null && zoneIdList.size() == 1) {
				zoneId = zoneIdList.get(0).getZoneId();
			}

		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveZoneIdBasedOnNodeId()" + EXCEPTION
					+ e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveZoneIdBasedOnNodeId()" + END);
		return zoneId;
	}

	private Map<String, Object> createNodeIdMapNew(int nodeId) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int retriveZoneLeaderBasedOnNodeId(String tableName, int nodeId) {
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveZoneIdBasedOnNodeId()" + START);
		int zoneId = -1;
		try {
			System.out.println("nodeId" + nodeId);
			SqlParameterSource parameterSource = new MapSqlParameterSource(
					RoutingTableConstantsIF.NODEID, nodeId);
			String sql1 = sqlProperties.getMessage(RETRIVE_RT_ZONELEADER_START,
					null, null, null);
			String sql2 = SPACE + tableName + SPACE;
			String sql3 = sqlProperties.getMessage(WHERE_CLAUSE_NODEID, null,
					null, null);

			String sql = sql1 + sql2 + sql3;
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveZoneLeaderBasedOnNodeId()" + "SQL=" + sql);
			
			Map<String,Object> paramMap = null;
			
			zoneId = namedJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveZoneLeaderBasedOnNodeId()" + EXCEPTION
					+ e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveZoneLeaderBasedOnNodeId()" + END);
		return zoneId;
	}

	@Override
	public boolean deleteUnwantedNodeIds(String tableName, int zoneIdOfNode) {

		System.out.println("zoneIdOfNode" + zoneIdOfNode);
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteUnwantedNodeIds()"
				+ START);
		boolean deleteTableFlag = false;
		try {

			String sql1 = sqlProperties.getMessage(DELETE_FROM, null, null,
					null);
			String sql2 = SPACE + tableName + SPACE;
			String sql3 = sqlProperties.getMessage(
					WHERE_UNWANTED_ZONEID_DELETE_CLAUSE, null, null, null);
			// Query
			String sql = sql1 + sql2 + sql3;
			System.out
					.println("Class:RoutingTableDAOImpl-->+deleteUnwantedNodeIds()-->Query"
							+ sql);
			deleteTableFlag = deleteWithCompleteQuery(sql,
					createZoneIdMap(zoneIdOfNode));
			System.out
					.println("Class:RoutingTableDAOImpl-->+deleteUnwantedNodeIds()-->Deletion Status"
							+ deleteTableFlag);

		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "deleteUnwantedNodeIds()" + EXCEPTION + e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteUnwantedNodeIds()"
				+ END);
		return deleteTableFlag;
	}

	/**
	 * @param s
	 */
	/*
	 * public static void main(String s[]) { ApplicationContext context = new
	 * ClassPathXmlApplicationContext( "/topology-routing.xml");
	 * RoutingTableDAOIF topologyServiceIF = (RoutingTableDAOIF) context
	 * .getBean("routingTableDao");
	 * 
	 * topologyServiceIF.deleteUnwantedNodeIdsForZoneLeader(
	 * RoutingServiceConstantsIF.SQUARE_NODE_APPENDER_RT+"10",2,1);
	 * 
	 * }
	 */

	@Override
	public boolean deleteUnwantedNodeIdsForZoneLeader(String tableName,
			int zoneIdOfNode, int zoneLeaderVal) {
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "deleteUnwantedNodeIdsForZoneLeader()" + START);
		boolean deleteTableFlag = false;
		try {

			String sql1 = sqlProperties.getMessage(DELETE_FROM, null, null,
					null);
			String sql2 = SPACE + tableName + SPACE;
			String sql3 = sqlProperties.getMessage(
					WHERE_UNWANTED_ZONEID_ZONELEADER_DELETE_CLAUSE, null, null,
					null);

			// Query
			String sql = sql1 + sql2 + sql3;

			System.out
					.println("Class:RoutingTableDAOImpl-->+deleteUnwantedNodeIdsForZoneLeader()-->Query"
							+ sql);
			deleteTableFlag = deleteWithCompleteQuery(sql,
					createZoneIdAndZoneLeaderMap(zoneIdOfNode, zoneLeaderVal));
			System.out
					.println("Class:RoutingTableDAOImpl-->+deleteUnwantedNodeIdsForZoneLeader()-->Deletion Status"
							+ deleteTableFlag);

		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "deleteUnwantedNodeIdsForZoneLeader()" + EXCEPTION
					+ e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "deleteUnwantedNodeIdsForZoneLeader()" + END);
		return deleteTableFlag;
	}

	@Override
	public List<Integer> getNeigbours(String tableName, double coverageDistance) {
		System.out.println(CLASS_NAME + METHOD_NAME + "getNeigbours()" + START);
		List<Integer> neigbourList = null;
		try {

			String sql1 = sqlProperties.getMessage(SELECT_FROM_QUERY, null,
					null, null);
			String sql2 = SPACE + tableName + SPACE;
			String sql3 = sqlProperties.getMessage(WHERE_DISTANCE_CLAUSE_QUERY,
					null, null, null);

			// Query
			String sql = sql1 + sql2 + sql3;

			System.out
					.println("Class:RoutingTableDAOImpl-->+getNeigbours()-->Query"
							+ sql);
			SqlParameterSource parameterSource = new MapSqlParameterSource(
					DISTANCE_COL, coverageDistance);

			neigbourList = namedJdbcTemplate.queryForList(sql, parameterSource,
					Integer.class);

			System.out
					.println("Class:RoutingTableDAOImpl-->+getNeigbours()-->Neigbour List"
							+ neigbourList);

		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME + "getNeigbours()"
					+ EXCEPTION + e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME + "getNeigbours()" + END);
		return neigbourList;
	}

	@Override
	public int findZoneLeaderOfZone(String tableName, int zoneId,
			int zoneLeaderFlag) {
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveZoneIdBasedOnNodeId()" + START);
		int nodeId = -1;
		try {
			System.out.println("ZOne Id=" + zoneId);
			System.out.println("zoneleaderflag" + zoneLeaderFlag);

			System.out.println("BLASBBBBBB");

			/*
			 * SqlParameterSource parameterSource = new MapSqlParameterSource(
			 * RoutingTableConstantsIF.NODEID, nodeId);
			 */
			String sql1 = sqlProperties.getMessage(RETRIVE_RT_NODEID_START,
					null, null, null);
			String sql2 = SPACE + tableName + SPACE;
			String sql3 = sqlProperties.getMessage(
					WHERE_CLAUSE_ZONEID_ZONE_LEADER, null, null, null);

			String sql = sql1 + sql2 + sql3;
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "findZoneLeaderOfZone()" + "SQL=" + sql);
			// zoneId = namedJdbcTemplate.queryForInt(sql, parameterSource);

			List<NodeId> zoneIdList = queryForNodeId(sql,
					createZoneAndZoneLeaderMap(zoneId, zoneLeaderFlag));
			System.out.println("Zone ID List=" + zoneIdList);
			if (zoneIdList != null && zoneIdList.size() == 1) {
				nodeId = zoneIdList.get(0).getNodeId();
			}

		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveZoneIdBasedOnNodeId()" + EXCEPTION
					+ e.getMessage());

			e.printStackTrace();

		}
		System.out.println(CLASS_NAME + METHOD_NAME + "findZoneLeaderOfZone()"
				+ END + nodeId);
		return nodeId;
	}

	private Map<String, Object> createZoneAndZoneLeaderMap(int zoneId,
			int zoneLeaderFlag) {
		Map<String, Object> nodeIdMap = new HashMap<String, Object>();
		nodeIdMap.put(RoutingTableConstantsIF.ZONEID, zoneId);
		nodeIdMap.put(RoutingTableConstantsIF.ZONELEADER, zoneLeaderFlag);
		return nodeIdMap;
	}

	@Override
	public List<ClusterHeads> retriveClusterHeads(String tableName, int zoneId,
			int zoneLeaderFlag) {
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveClusterHeads()"
				+ START);
		List<ClusterHeads> clusterHeads = null;
		try {

			String sql1 = sqlProperties.getMessage(SELECT_ZONEID_NODEID_QUERY,
					null, null, null);
			String sql2 = SPACE + tableName + SPACE;
			String sql3 = sqlProperties.getMessage(
					WHERE_NOTEQUAL_ZONEID_EQUAL_ZONELEADER, null, null, null);
			String query = sql1 + sql2 + sql3;
			clusterHeads = queryForClusterHead(query,
					createZoneIdZoneLeaderMap(zoneId, zoneLeaderFlag));
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveClusterHeads()" + EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveClusterHeads()"
				+ END);
		return clusterHeads;
	}

	private Map<String, Object> createZoneIdZoneLeaderMap(int zoneId,
			int zoneLeaderFlag) {
		Map<String, Object> createMap = new HashMap<String, Object>();
		createMap.put(TopologyConstantsIF.ZONEID_COL, zoneId);
		createMap.put(TopologyConstantsIF.ZONELEADER_COL, zoneLeaderFlag);
		return createMap;
	}

	@Override
	public List<Integer> retriveNodesInZone(String tableName, int sourceNode) {

		System.out.println(CLASS_NAME + METHOD_NAME + "retriveNodesInZone()"
				+ START);
		List<Integer> nodeIdList = null;
		try {

			String sql1 = sqlProperties.getMessage(SELECT_NODEID_QUERY, null,
					null, null);
			String sql2 = SPACE + tableName + SPACE;
			String sql3 = sqlProperties.getMessage(WHERE_NOTEQUAL_NODEID, null,
					null, null);
			String query = sql1 + sql2 + sql3;
			nodeIdList = namedJdbcTemplate.queryForList(query,
					createNodeIdMap(sourceNode), Integer.class);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveNodesInZone()" + EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveNodesInZone()"
				+ END);
		return nodeIdList;
	}

	@Override
	public List<Integer> retriveNodesInZoneUsingZoneLeaderAndZoneId(
			String tableName, int zoneId, int sourceNode) {
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveNodesInZone()"
				+ START);
		List<Integer> nodeIdList = null;
		try {

			String sql1 = sqlProperties.getMessage(SELECT_NODEID_QUERY, null,
					null, null);
			String sql2 = SPACE + tableName + SPACE;
			String sql3 = sqlProperties.getMessage(
					WHERE_NOTEQUAL_NODEID_EQUAL_ZONEID, null, null, null);
			String query = sql1 + sql2 + sql3;
			nodeIdList = namedJdbcTemplate.queryForList(query,
					createNodeIdZoneIdMap(sourceNode, zoneId), Integer.class);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveNodesInZoneUsingZoneLeaderAndZoneId()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveNodesInZone()"
				+ END);
		return nodeIdList;
	}

	private Map<String, Object> createNodeIdZoneIdMap(int sourceNode, int zoneId) {
		Map<String, Object> nodeIdMap = new HashMap<String, Object>();
		nodeIdMap.put(RoutingTableConstantsIF.NODEID, sourceNode);
		nodeIdMap.put(RoutingTableConstantsIF.ZONEID, zoneId);
		return nodeIdMap;
	}

	@Override
	public List<Integer> obtainNodesApartFromZoneLeaderAndDestNode(
			String tableName, int zoneId, int zoneLeaderNode) {

		System.out.println(CLASS_NAME + METHOD_NAME
				+ "obtainNodesApartFromZoneLeaderAndDestNode()" + START);
		List<Integer> nodeIdList = null;
		try {

			String sql1 = sqlProperties.getMessage(SELECT_NODEID_QUERY, null,
					null, null);
			String sql2 = SPACE + tableName + SPACE;
			String sql3 = sqlProperties.getMessage(
					WHERE_NOTEQUAL_NODEID_EQUAL_TO_ZONEID, null, null, null);
			String query = sql1 + sql2 + sql3;
			nodeIdList = namedJdbcTemplate.queryForList(query,
					createNodeIdZoneIdMap(zoneLeaderNode, zoneId),
					Integer.class);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "obtainNodesApartFromZoneLeaderAndDestNode()" + EXCEPTION
					+ e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "obtainNodesApartFromZoneLeaderAndDestNode()" + END);
		return nodeIdList;

	}

	@Override
	public double distanceBetweenNodes(String tableName, int nodeId) {

		System.out.println(CLASS_NAME + METHOD_NAME + "distanceBetweenNodes()"
				+ START);
		double distance = 0.0;
		try {

			String sql1 = sqlProperties.getMessage(SELECT_DISTANCE_QUERY, null,
					null, null);
			String sql2 = SPACE + tableName + SPACE;
			String sql3 = sqlProperties.getMessage(WHERE_NODEID_EQUALTO, null,
					null, null);
			String sql = sql1 + sql2 + sql3;
			distance = executeForObjectUsingQuery(sql, createNodeIdMap(nodeId), new DistanceMapper());
				} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "distanceBetweenNodes()" + EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "distanceBetweenNodes()"
				+ END);
		return distance;
	}

	

	final class DistanceMapper implements
			RowMapper<Double> {
		public Double mapRow(ResultSet rs, int arg1)
				throws SQLException {
			Double distance=rs.getDouble(DISTANCE_COL);
			return distance;
		}
	}

	@Override
	public List<Integer> retriveNodesApartFromSNZLAndSNAndNonObs(String tableName,
			int zoneId, int sourceNode, int obsSite,int zoneLeader) {
		
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "obtainNodesApartFromZoneLeaderAndDestNode()" + START);
		List<Integer> nodeIdList = null;
		try {

			String sql1 = sqlProperties.getMessage(SELECT_NODEID_QUERY, null,
					null, null);
			String sql2 = SPACE + tableName + SPACE;
			String sql3 = sqlProperties.getMessage(
					WHERE_NOTEQUAL_NODEID_NOTEQUAL_ZONELEADER_NOTEQUAL_CLOSERTOOBS_EQUAL_ZONEID, null, null, null);
			String query = sql1 + sql2 + sql3;
			nodeIdList = namedJdbcTemplate.queryForList(query,
					createZoneID_SN_OS_ZL(zoneId, sourceNode,obsSite,zoneLeader),
					Integer.class);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "obtainNodesApartFromZoneLeaderAndDestNode()" + EXCEPTION
					+ e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "obtainNodesApartFromZoneLeaderAndDestNode()" + END);
		return nodeIdList;
	}
	private Map<String,Object> createZoneID_SN_OS_ZL(int zoneId,
			int sourceNode, int obsSite, int zoneLeader) {
		Map<String,Object>  map=new HashMap<String, Object>();
		map.put(TopologyConstantsIF.ZONEID_COL,zoneId);
		map.put(TopologyConstantsIF.NODEID_COL,sourceNode);
		map.put(TopologyConstantsIF.CLOSERTOOBSTRACLE,sourceNode);
		map.put(TopologyConstantsIF.ZONELEADER_COL,zoneLeader);
		return map;
	}
	@Override
	public int retriveAngleBasedOnNodeId(String tableName, Integer nodeId) {
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveZoneIdBasedOnNodeId()" + START);
		int angle = -1;
		try {

			/*
			 * SqlParameterSource parameterSource = new MapSqlParameterSource(
			 * RoutingTableConstantsIF.NODEID, nodeId);
			 */
			String sql1 = sqlProperties.getMessage(RETRIVE_ANGULARPOSWITHBS_START,
					null, null, null);
			String sql2 = SPACE + tableName + SPACE;
			String sql3 = sqlProperties.getMessage(WHERE_CLAUSE_NODEID, null,
					null, null);

			String sql = sql1 + sql2 + sql3;
			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveAngleBasedOnNodeId()" + "SQL=" + sql);
			// zoneId = namedJdbcTemplate.queryForInt(sql, parameterSource);

			List<AnglePos> angleList = queryForAnglePos(sql, 
					createNodeIdMap(nodeId));
			System.out.println("Zone ID List=" + angleList);
			if (angleList != null && angleList.size() == 1) {
				angle = angleList.get(0).getAnglePos();
			}

		} catch (Exception e) {

			System.out.println(CLASS_NAME + METHOD_NAME
					+ "retriveAngleBasedOnNodeId()" + EXCEPTION
					+ e.getMessage());

		}
		System.out.println(CLASS_NAME + METHOD_NAME
				+ "retriveAngleBasedOnNodeId()" + END);
		return angle;
	}
}