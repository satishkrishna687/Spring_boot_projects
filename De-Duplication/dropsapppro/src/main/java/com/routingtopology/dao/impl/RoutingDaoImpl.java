package com.routingtopology.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.model.PerformanceResidualEnergy;
import com.routingtopology.constants.TopologyConstantsIF;
import com.routingtopology.dao.inter.RoutingBaseDao;
import com.routingtopology.value.AngleBasedRoutingTable;
import com.routingtopology.value.AnglePos;
import com.routingtopology.value.CentreCordinate;
import com.routingtopology.value.ClusterHeads;
import com.routingtopology.value.HookInfo;
import com.routingtopology.value.LeaderInfoValue;
import com.routingtopology.value.NodeCordinateValue;
import com.routingtopology.value.NodeId;
import com.routingtopology.value.NodeInfoForSquare;
import com.routingtopology.value.NodeParameters;
import com.routingtopology.value.NormalRoutingTable;
import com.routingtopology.value.PIInfo;
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
import com.routingtopology.value.TopologyInfoValue;
import com.routingtopology.value.VerticalRoutingTable;
import com.routingtopology.value.ZoneId;
import com.routingtopology.value.ZoneRoutingTable;


@Repository
public abstract class RoutingDaoImpl implements RoutingBaseDao {

	@Autowired
	protected JdbcTemplate template;

	@Autowired
	protected NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	protected MessageSource sqlProperties;

	/**
	 * @param topologyInfoValue
	 * @param query
	 * @return true if sucessful insertion
	 */
	protected boolean insertTopologyWithAngularTopology(List<TopologyInfoValue> topologyInfoValue, String query) {
		System.out.println("Class-->RoutingBaseDAOImpl:Method-->insertTopologyWithAngularTopology");
		boolean insertionFlag = false;
		if (topologyInfoValue != null) {
			for (TopologyInfoValue topologyInfo : topologyInfoValue) {
				insertionFlag = update(query, createTopologyMapWithAngular(topologyInfo));
			}

		}
		return insertionFlag;
	}

	/**
	 * @param topologyInfoValue
	 * @param query
	 * @return true if sucessful insertion
	 */
	protected boolean insertTopologyWithSquareConfig(List<TopologyInfoValue> topologyInfoValue, String query) {
		System.out.println("Class-->RoutingBaseDAOImpl:Method-->insertTopologyWithSquareConfig");
		boolean insertionFlag = false;
		if (topologyInfoValue != null) {
			for (TopologyInfoValue topologyInfo : topologyInfoValue) {
				insertionFlag = update(query, createTopologyMapWithSquare(topologyInfo));
			}

		}
		return insertionFlag;
	}

	protected Map<String, Object> createTopologyMapWithSquare(TopologyInfoValue topologyInfo) {
		Map<String, Object> topologyMap = new HashMap<String, Object>();
		topologyMap.put(TopologyConstantsIF.BUFFER_COL, topologyInfo.getNodeParameters().getBuffer());
		topologyMap.put(TopologyConstantsIF.ENERGY_COL, topologyInfo.getNodeParameters().getEnergy());
		topologyMap.put(TopologyConstantsIF.NETWORKCOST_COL, topologyInfo.getNodeParameters().getNetworkCost());
		topologyMap.put(TopologyConstantsIF.NODEID_COL, topologyInfo.getNodeId());
		topologyMap.put(TopologyConstantsIF.POWERAVAILABLE_COL,
				topologyInfo.getNodeParameters().getAvailableBatteryPower());
		topologyMap.put(TopologyConstantsIF.TRUST_COL, topologyInfo.getNodeParameters().getTrustLevel());
		System.out.println("TL=" + topologyInfo.getNodeParameters().getTrustLevel());
		topologyMap.put(TopologyConstantsIF.ZONEID_COL, topologyInfo.getNodeParameters().getZoneId());
		topologyMap.put(TopologyConstantsIF.ZONELEADER_COL, topologyInfo.getLeaderInfo().isLeader() == true ? 1 : 0);
		topologyMap.put(TopologyConstantsIF.XCORDINATE_COL, topologyInfo.getNodeCoordiante().getX_cor());
		topologyMap.put(TopologyConstantsIF.YCORDINATE_COL, topologyInfo.getNodeCoordiante().getY_cor());
		topologyMap.put(TopologyConstantsIF.XCENTER_COL, topologyInfo.getCentreCordinates().getxCorCentre());
		topologyMap.put(TopologyConstantsIF.YCENTER_COL, topologyInfo.getCentreCordinates().getyCorCentre());
		return topologyMap;
	}

	protected Map<String, Object> createTopologyMapWithAngular(TopologyInfoValue topologyInfo) {
		Map<String, Object> topologyMap = new HashMap<String, Object>();
		topologyMap.put(TopologyConstantsIF.BUFFER_COL, topologyInfo.getNodeParameters().getBuffer());
		topologyMap.put(TopologyConstantsIF.ENERGY_COL, topologyInfo.getNodeParameters().getEnergy());
		topologyMap.put(TopologyConstantsIF.NETWORKCOST_COL, topologyInfo.getNodeParameters().getNetworkCost());
		topologyMap.put(TopologyConstantsIF.NODEID_COL, topologyInfo.getNodeId());
		topologyMap.put(TopologyConstantsIF.POWERAVAILABLE_COL,
				topologyInfo.getNodeParameters().getAvailableBatteryPower());
		topologyMap.put(TopologyConstantsIF.TRUST_COL, topologyInfo.getNodeParameters().getTrustLevel());
		topologyMap.put(TopologyConstantsIF.SIGNALSTRENGTH_COL,
				topologyInfo.getNodeParameters().getSignalStrengthOfNode());
		topologyMap.put(TopologyConstantsIF.CLOSERTOOBSTRACLE_COL,
				topologyInfo.getNodeParameters().getCloseObstracle());
		topologyMap.put(TopologyConstantsIF.ANGULARPOSWITHBS_COL, topologyInfo.getNodeParameters().getAngularPos());
		topologyMap.put(TopologyConstantsIF.ZONEID_COL, topologyInfo.getNodeParameters().getAngularRegion());
		topologyMap.put(TopologyConstantsIF.ZONELEADER_COL, topologyInfo.getLeaderInfo().isLeader() == true ? 1 : 0);
		return topologyMap;
	}

	/**
	 * @param <T>
	 * @param sqlKey
	 * @param paramMap
	 * @param rowMapper
	 * @return List
	 */
	protected <T> List<T> execute(String sqlKey, Map<String, ? extends Object> paramMap, RowMapper<T> rowMapper) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);

		return namedJdbcTemplate.query(sql, paramMap, rowMapper);
	}

	/**
	 * @param sqlKey
	 * @param map
	 * @return true if sucessfully updated
	 */
	protected boolean update(String sqlKey, Map<String, Object> map) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		boolean value = false;
		try {
			namedJdbcTemplate.update(sql, map);
			value = true;
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return value;
	}

	/**
	 * @param sqlKey
	 * @param map
	 * @return true if sucessfully updated
	 */
	protected boolean insert(String sqlKey, Map<String, Object> map) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		boolean value = false;
		try {
			namedJdbcTemplate.update(sql, map);
			value = true;
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return value;
	}

	/**
	 * @param sqlQuery
	 * @param sqlKey
	 * @param map
	 * @return true if sucessfully updated
	 */
	protected boolean insertBasedOnQuery(String sqlQuery, Map<String, Object> map) {
		System.out.println("Class-->RoutingDaoImpl:Method-->update");
		boolean insertQuery = false;
		try {
			namedJdbcTemplate.update(sqlQuery, map);
			insertQuery = true;
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return insertQuery;
	}

	/**
	 * @param <T>
	 * @param sqlKey
	 * @param paramMap
	 * @param rowMapper
	 * @return Object
	 */
	protected <T> T executeForObject(String sqlKey, Map<String, ? extends Object> paramMap, RowMapper<T> rowMapper) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return namedJdbcTemplate.queryForObject(sql, paramMap, rowMapper);
	}

	protected <T> T executeForObjectUsingQuery(String sql, Map<String, ? extends Object> paramMap,
			RowMapper<T> rowMapper) {
		return namedJdbcTemplate.queryForObject(sql, paramMap, rowMapper);
	}

	/**
	 * @param sqlKey
	 * @param params
	 * @return List of String objects
	 */
	protected List<String> executeForListOfString(String sqlKey, Map<String, Object> params) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		System.out.println(sql);
		System.out.println(params);

		return namedJdbcTemplate.queryForList(sql, params, String.class);
	}

	/**
	 * @param sqlKey
	 * @param params
	 * @return List of integer values
	 */
	protected List<Integer> executeForListOfInt(String sqlKey, Map<String, Object> params) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		System.out.println(sql);
		System.out.println(params);

		return namedJdbcTemplate.queryForList(sql, params, Integer.class);
	}

	/**
	 * @param sqlKey
	 *            -This is the SQL Key query
	 * @param topologyMapper
	 * @return List of Values
	 */
	protected List<TopologyInfoValue> queryForTopology(String sqlKey, RowMapper<TopologyInfoValue> topologyMapper) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return template.query(sql, topologyMapper);
	}

	/**
	 * @param sqlKey
	 *            -This is the SQL Key query
	 * @param topologyMapper
	 * @return List of Values
	 */
	protected List<NormalRoutingTable> queryForRoutingTopology(String sqlKey,
			RowMapper<NormalRoutingTable> topologyMapper) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return template.query(sql, topologyMapper);
	}

	/**
	 * @param sqlKey
	 * @param topologyMapper
	 * @param params
	 * @return List of Topology Information
	 */
	protected List<NodeInfoForSquare> queryForTopologySquare(String sqlKey, Map<String, Object> params) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return namedJdbcTemplate.query(sql, params, new TopologyInfoValueMapperSquareLimited());
	}

	/**
	 * @param sqlKey
	 * @param topologyMapper
	 * @param params
	 * @return List of Topology Information
	 */
	private List<Integer> queryForZoneLeaders(String sqlKey, Map<String, Object> params) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return namedJdbcTemplate.query(sql, params, new ZoneLeadersMapper());
	}

	final class ZoneLeadersMapper implements RowMapper<Integer> {
		public Integer mapRow(ResultSet rs, int arg1) throws SQLException {

			int nodeId = rs.getInt(NODEID_COL);
			System.out.println("NODE ID VALUE=" + nodeId);
			return nodeId;
		}
	}

	/**
	 * @param sqlKey
	 * @param topologyMapper
	 * @param params
	 * @return List of Topology Information
	 */
	protected List<ClusterHeads> queryForClusterHead(String query, Map<String, Object> params) {
		return namedJdbcTemplate.query(query, params, new ClusterHeadMapper());
	}

	final class ClusterHeadMapper implements RowMapper<ClusterHeads> {
		@Override
		public ClusterHeads mapRow(ResultSet rs, int arg1) throws SQLException {
			ClusterHeads clusterHeads = new ClusterHeads();
			clusterHeads.setNodeId(rs.getInt(NODEID_COL));
			clusterHeads.setZoneId(rs.getInt(ZONEID_COL));
			return clusterHeads;
		}

	}

	/**
	 * @param sqlKey
	 * @param topologyMapper
	 * @param params
	 * @return List of Topology Information
	 */
	protected List<ZoneId> queryForZoneId(String sql, Map<String, Object> params) {
		return namedJdbcTemplate.query(sql, params, new ZoneIdNewMapper());
	}

	final class ZoneIdNewMapper implements RowMapper<ZoneId> {
		public ZoneId mapRow(ResultSet rs, int arg1) throws SQLException {
			System.out.println("amdnanmsndnasmndmnsanm");
			ZoneId zoneId = new ZoneId();
			int zoneIdV = rs.getInt(ZONEID_COL);
			System.out.println("ZONE ID VALUE=" + zoneIdV);
			zoneId.setZoneId(rs.getInt(ZONEID_COL));
			return zoneId;
		}
	}

	protected List<NodeId> queryForNodeId(String sql, Map<String, Object> params) {
		return namedJdbcTemplate.query(sql, params, new NodeIdNewMapper());
	}

	final class NodeIdNewMapper implements RowMapper<NodeId> {
		public NodeId mapRow(ResultSet rs, int arg1) throws SQLException {
			NodeId nodeId = new NodeId();
			nodeId.setNodeId(rs.getInt(NODEID_COL));
			return nodeId;
		}
	}

	protected List<AnglePos> queryForAnglePos(String sql, Map<String, Object> params) {
		return namedJdbcTemplate.query(sql, params, new AnglePosMapper());
	}

	final class AnglePosMapper implements RowMapper<AnglePos> {
		public AnglePos mapRow(ResultSet rs, int arg1) throws SQLException {
			AnglePos anglePos = new AnglePos();
			anglePos.setAnglePos(rs.getInt(ANGULARPOSWITHBS_COL));
			return anglePos;
		}
	}

	/**
	 * @param sqlKey
	 * @return List of Zone IDs
	 */
	protected List<Integer> retriveZoneIDs(String sqlKey) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		System.out.println("Class---->Routing Dao Impl" + "Method:retriveZoneIDsAngular()" + "SQL=" + sql);
		return template.query(sql, new ZoneIdMapper());
	}

	final class ZoneIdMapper implements RowMapper<Integer> {
		public Integer mapRow(ResultSet rs, int arg1) throws SQLException {
			Integer zoneID = rs.getInt(TopologyConstantsIF.ZONEID_COL);
			return zoneID;
		}

	}

	/**
	 * @param sqlKey
	 * @return true if all records are sucessfully deleted
	 */
	public boolean delete(String sqlKey) {
		boolean value = false;
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		try {
			Map<String, ?> id = null;
			template.update(sql);
			value = true;
		} catch (Exception e) {
			System.out.println("Delete exception" + e.getMessage());
		}
		return value;
	}

	/**
	 * @param query
	 * @return true if all records are sucessfully deleted
	 */
	public boolean deleteWithCompleteQuery(String query) {
		boolean value = false;
		try {
			Map<String, ?> id = null;
			template.update(query);
			value = true;
		} catch (Exception e) {
			System.out.println("Delete exception" + e.getMessage());
		}
		return value;
	}

	/**
	 * @param query
	 * @param map
	 * @return true if all records are sucessfully deleted
	 */
	public boolean deleteWithCompleteQuery(String query, Map<String, Object> map) {
		boolean value = false;
		try {
			System.out.println("Delete query map" + map);
			template.update(query, map);
			value = true;
		} catch (Exception e) {
			System.out.println("Delete exception" + e.getMessage());
		}
		return value;
	}

	/**
	 * @param sqlKey
	 * @return true if all records are sucessfully deleted
	 */
	protected boolean deleteRoutingTable(String sqlKey, String query) {
		boolean value = false;
		String sql1 = sqlProperties.getMessage(sqlKey, null, null);
		String sql2 = SPACE + query;
		String sql = sql1 + sql2;
		try {
			Map<String, ?> id = null;
			template.update(sql);
			value = true;
		} catch (Exception e) {
			System.out.println("Delete exception" + e.getMessage());
		}
		return value;
	}

	/**
	 * @param topologyInfoValue
	 * @param query
	 * @return true if success insert topology otherwise false
	 */
	protected boolean insertTopology(List<TopologyInfoValue> topologyInfoValue, String query) {

		System.out.println("Class-->TopologyDAOImpl:Method-->insertTopology");
		boolean insertionFlag = false;
		if (topologyInfoValue != null) {
			for (TopologyInfoValue topologyInfo : topologyInfoValue) {
				update(query, createTopologyMap(topologyInfo));
			}
			insertionFlag = true;
		}
		return insertionFlag;
	}

	/**
	 * @param topologyInfoValue
	 * @param query
	 * @return true if topology is sucessfully inserted
	 */
	protected boolean insertTopologyWithTrust(List<TopologyInfoValue> topologyInfoValue, String query) {
		System.out.println("Class-->RoutingBaseDAOImpl:Method-->insertTopologyWithTrust");
		boolean insertionFlag = false;
		if (topologyInfoValue != null) {
			for (TopologyInfoValue topologyInfo : topologyInfoValue) {
				update(query, createTopologyMapWithTrust(topologyInfo));
			}
			insertionFlag = true;
		}
		return insertionFlag;
	}

	/**
	 * @param topologyInfo
	 * @return Map contaning the node parameters and node positions along with
	 *         trust
	 */
	public Map<String, Object> createTopologyMapWithTrust(TopologyInfoValue topologyInfo) {
		Map<String, Object> topologyMap = new HashMap<String, Object>();
		topologyMap.put(TopologyConstantsIF.BUFFER_COL, topologyInfo.getNodeParameters().getBuffer());
		topologyMap.put(TopologyConstantsIF.ENERGY_COL, topologyInfo.getNodeParameters().getEnergy());
		topologyMap.put(TopologyConstantsIF.NETWORKCOST_COL, topologyInfo.getNodeParameters().getNetworkCost());
		topologyMap.put(TopologyConstantsIF.NODEID_COL, topologyInfo.getNodeId());
		topologyMap.put(TopologyConstantsIF.POWERAVAILABLE_COL,
				topologyInfo.getNodeParameters().getAvailableBatteryPower());
		topologyMap.put(TopologyConstantsIF.XCORDINATE_COL, topologyInfo.getNodeCoordiante().getX_cor());
		topologyMap.put(TopologyConstantsIF.YCORDINATE_COL, topologyInfo.getNodeCoordiante().getY_cor());
		topologyMap.put(TopologyConstantsIF.TRUST_COL, topologyInfo.getNodeParameters().getTrustLevel());
		return topologyMap;
	}

	/**
	 * @param topologyInfo
	 * @return a map of topology
	 */
	public Map<String, Object> createTopologyMap(TopologyInfoValue topologyInfo) {
		Map<String, Object> topologyMap = new HashMap<String, Object>();
		topologyMap.put(TopologyConstantsIF.BUFFER_COL, topologyInfo.getNodeParameters().getBuffer());
		topologyMap.put(TopologyConstantsIF.ENERGY_COL, topologyInfo.getNodeParameters().getEnergy());
		topologyMap.put(TopologyConstantsIF.NETWORKCOST_COL, topologyInfo.getNodeParameters().getNetworkCost());
		topologyMap.put(TopologyConstantsIF.NODEID_COL, topologyInfo.getNodeId());
		topologyMap.put(TopologyConstantsIF.POWERAVAILABLE_COL,
				topologyInfo.getNodeParameters().getAvailableBatteryPower());
		topologyMap.put(TopologyConstantsIF.XCORDINATE_COL, topologyInfo.getNodeCoordiante().getX_cor());
		topologyMap.put(TopologyConstantsIF.YCORDINATE_COL, topologyInfo.getNodeCoordiante().getY_cor());
		return topologyMap;
	}

	/**
	 * @param query
	 * @return List of Topology Information
	 */
	protected List<TopologyInfoValue> retriveTopologyWithTrust(String query) {
		return queryForTopology(query, new TopologyInfoValueMapperWithTrust());
	}

	protected List<HookInfo> retriveHookInfo(String query) {
		return queryForHookInfo(query, new HookMapper());
	}

	protected List<Integer> retriveNodeIDOrderByPIForZoneId(String queryKey, Map<String, Object> map) {
		return queryForNodeIDBasedOnPI(queryKey, map);
	}

	/**
	 * @param sqlKey
	 * @param topologyMapper
	 * @param params
	 * @return List of Topology Information
	 */
	private List<Integer> queryForNodeIDBasedOnPI(String sqlKey, Map<String, Object> params) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return namedJdbcTemplate.query(sql, params, new NodeIDMapperBasedOnPI());
	}

	final class NodeIDMapperBasedOnPI implements RowMapper<Integer> {
		@Override
		public Integer mapRow(ResultSet rs, int arg1) throws SQLException {
			int nodeId = rs.getInt(TopologyConstantsIF.NODEID_COL);
			return nodeId;
		}

	}

	private List<HookInfo> queryForHookInfo(String sqlKey, RowMapper<HookInfo> hookMapper) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return template.query(sql, hookMapper);
	}

	protected List<PIInfo> retrivePIInfo(String query) {
		return queryForPIInfo(query, new PIMapper());
	}

	private List<PIInfo> queryForPIInfo(String sqlKey, RowMapper<PIInfo> hookMapper) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return template.query(sql, hookMapper);
	}

	final class PIMapper implements RowMapper<PIInfo> {

		@Override
		public PIInfo mapRow(ResultSet rs, int arg1) throws SQLException {
			PIInfo piInfo = new PIInfo();
			piInfo.setNodeId(rs.getInt(TopologyConstantsIF.NODEID_COL));
			piInfo.setEnergy(rs.getDouble(TopologyConstantsIF.ENERGY_COL));
			piInfo.setPi(rs.getDouble(TopologyConstantsIF.PI_COL));
			piInfo.setTrust(rs.getInt(TopologyConstantsIF.TRUST_COL));
			piInfo.setEnergy(rs.getInt(TopologyConstantsIF.ENERGY_COL));
			piInfo.setZoneId(rs.getInt(TopologyConstantsIF.ZONEID_COL));
			return piInfo;
		}

	}

	final class TopologyInfoValueMapperWithTrust implements RowMapper<TopologyInfoValue> {

		public TopologyInfoValue mapRow(ResultSet rs, int arg1) throws SQLException {
			TopologyInfoValue topologyInfo = new TopologyInfoValue();
			NodeParameters nodeParameters = new NodeParameters();
			nodeParameters.setAvailableBatteryPower(rs.getDouble(TopologyConstantsIF.POWERAVAILABLE_COL));
			nodeParameters.setBuffer(rs.getInt(TopologyConstantsIF.BUFFER_COL));
			nodeParameters.setEnergy(rs.getDouble(TopologyConstantsIF.ENERGY_COL));
			nodeParameters.setNetworkCost(rs.getInt(TopologyConstantsIF.NETWORKCOST_COL));
			nodeParameters.setTrustLevel(rs.getInt(TopologyConstantsIF.TRUST_COL));
			topologyInfo.setNodeParameters(nodeParameters);
			topologyInfo.setNodeId(rs.getInt(TopologyConstantsIF.NODEID_COL));
			NodeCordinateValue nodeCordinateValue = new NodeCordinateValue();
			nodeCordinateValue.setX_cor(rs.getInt(TopologyConstantsIF.XCORDINATE_COL));
			nodeCordinateValue.setY_cor(rs.getInt(TopologyConstantsIF.YCORDINATE_COL));
			topologyInfo.setNodeCoordiante(nodeCordinateValue);
			return topologyInfo;
		}
	}

	final class HookMapper implements RowMapper<HookInfo> {
		public HookInfo mapRow(ResultSet rs, int arg1) throws SQLException {
			HookInfo hookInfo = new HookInfo();
			hookInfo.setHookId(rs.getInt(TopologyConstantsIF.HOOKID_COL));
			hookInfo.setHookValue(rs.getDouble(TopologyConstantsIF.HOOKVALUE_COL));
			return hookInfo;
		}
	}

	protected List<TopologyInfoValue> retriveTopologyWithAngular(String query) {
		return queryForTopology(query, new TopologyInfoValueMapperAngular());
	}

	final class TopologyInfoValueMapperAngular implements RowMapper<TopologyInfoValue> {
		public TopologyInfoValue mapRow(ResultSet rs, int arg1) throws SQLException {
			TopologyInfoValue topologyInfo = new TopologyInfoValue();
			NodeParameters nodeParameters = new NodeParameters();
			nodeParameters.setAvailableBatteryPower(rs.getDouble(TopologyConstantsIF.POWERAVAILABLE_COL));
			nodeParameters.setBuffer(rs.getInt(TopologyConstantsIF.BUFFER_COL));
			nodeParameters.setEnergy(rs.getDouble(TopologyConstantsIF.ENERGY_COL));
			nodeParameters.setNetworkCost(rs.getInt(TopologyConstantsIF.NETWORKCOST_COL));
			nodeParameters.setTrustLevel(rs.getInt(TopologyConstantsIF.TRUST_COL));
			nodeParameters.setAngularPos(rs.getInt(TopologyConstantsIF.ANGULARPOSWITHBS_COL));
			nodeParameters.setAngularRegion(rs.getInt(TopologyConstantsIF.ZONEID_COL));
			nodeParameters.setSignalStrengthOfNode(rs.getDouble(TopologyConstantsIF.SIGNALSTRENGTH_COL));
			nodeParameters.setCloseObstracle(rs.getInt(TopologyConstantsIF.CLOSERTOOBSTRACLE_COL));
			LeaderInfoValue leaderInfoValue = new LeaderInfoValue();
			leaderInfoValue.setLeader(rs.getInt(TopologyConstantsIF.ZONELEADER_COL) == 1 ? true : false);
			topologyInfo.setLeaderInfo(leaderInfoValue);
			topologyInfo.setNodeParameters(nodeParameters);
			topologyInfo.setNodeId(rs.getInt(TopologyConstantsIF.NODEID_COL));
			return topologyInfo;
		}
	}

	protected List<TopologyInfoValue> retriveTopologyWithSquareConfig(String query) {
		return queryForTopology(query, new TopologyInfoValueMapperSquare());
	}

	final class TopologyInfoValueMapperSquare implements RowMapper<TopologyInfoValue> {
		public TopologyInfoValue mapRow(ResultSet rs, int arg1) throws SQLException {
			TopologyInfoValue topologyInfo = new TopologyInfoValue();
			NodeParameters nodeParameters = new NodeParameters();
			nodeParameters.setAvailableBatteryPower(rs.getDouble(TopologyConstantsIF.POWERAVAILABLE_COL));
			nodeParameters.setBuffer(rs.getInt(TopologyConstantsIF.BUFFER_COL));
			nodeParameters.setEnergy(rs.getDouble(TopologyConstantsIF.ENERGY_COL));
			nodeParameters.setNetworkCost(rs.getInt(TopologyConstantsIF.NETWORKCOST_COL));
			nodeParameters.setTrustLevel(rs.getInt(TopologyConstantsIF.TRUST_COL));
			nodeParameters.setZoneId(rs.getInt(TopologyConstantsIF.ZONEID_COL));
			topologyInfo.setNodeParameters(nodeParameters);
			NodeCordinateValue nodeCordinateValue = new NodeCordinateValue();
			nodeCordinateValue.setX_cor(rs.getInt(TopologyConstantsIF.XCORDINATE_COL));
			nodeCordinateValue.setY_cor(rs.getInt(TopologyConstantsIF.YCORDINATE_COL));
			topologyInfo.setNodeCoordiante(nodeCordinateValue);
			LeaderInfoValue leaderInfoValue = new LeaderInfoValue();
			leaderInfoValue.setLeader(rs.getInt(TopologyConstantsIF.ZONELEADER_COL) == 1 ? true : false);
			topologyInfo.setLeaderInfo(leaderInfoValue);
			topologyInfo.setNodeId(rs.getInt(TopologyConstantsIF.NODEID_COL));
			CentreCordinate centreCordinate = new CentreCordinate();
			centreCordinate.setxCorCentre(rs.getDouble(TopologyConstantsIF.XCENTER_COL));
			centreCordinate.setyCorCentre(rs.getDouble(TopologyConstantsIF.YCENTER_COL));
			topologyInfo.setCentreCordinates(centreCordinate);
			return topologyInfo;
		}
	}

	protected List<NodeInfoForSquare> retriveTopologyWithSquareConfigLimited(String queryKey, Map<String, Object> map) {
		return queryForTopologySquare(queryKey, map);
	}

	protected List<Integer> retriveZoneLeaders(String queryKey, Map<String, Object> map) {
		return queryForZoneLeaders(queryKey, map);
	}

	final class TopologyInfoValueMapperSquareLimited implements RowMapper<NodeInfoForSquare> {
		public NodeInfoForSquare mapRow(ResultSet rs, int arg1) throws SQLException {
			NodeInfoForSquare nodeInfoForSquare = new NodeInfoForSquare();
			nodeInfoForSquare.setNodeId(rs.getInt(TopologyConstantsIF.NODEID_COL));
			nodeInfoForSquare.setxCenter(rs.getDouble(TopologyConstantsIF.XCENTER_COL));
			nodeInfoForSquare.setyCentre(rs.getDouble(TopologyConstantsIF.YCENTER_COL));
			nodeInfoForSquare.setxCordinate(rs.getInt(TopologyConstantsIF.XCORDINATE_COL));
			nodeInfoForSquare.setyCordinate(rs.getInt(TopologyConstantsIF.YCORDINATE_COL));
			return nodeInfoForSquare;
		}
	}

	/**
	 * @param query
	 * @return List of topology info
	 */
	public List<TopologyInfoValue> retriveTopology(String query) {
		return queryForTopology(query, new TopologyInfoValueMapper());
	}

	final class TopologyInfoValueMapper implements RowMapper<TopologyInfoValue> {
		public TopologyInfoValue mapRow(ResultSet rs, int arg1) throws SQLException {
			TopologyInfoValue topologyInfo = new TopologyInfoValue();
			NodeParameters nodeParameters = new NodeParameters();
			nodeParameters.setAvailableBatteryPower(rs.getDouble(TopologyConstantsIF.POWERAVAILABLE_COL));
			nodeParameters.setBuffer(rs.getInt(TopologyConstantsIF.BUFFER_COL));
			nodeParameters.setEnergy(rs.getDouble(TopologyConstantsIF.ENERGY_COL));
			nodeParameters.setNetworkCost(rs.getInt(TopologyConstantsIF.NETWORKCOST_COL));
			topologyInfo.setNodeParameters(nodeParameters);
			topologyInfo.setNodeId(rs.getInt(TopologyConstantsIF.NODEID_COL));
			NodeCordinateValue nodeCordinateValue = new NodeCordinateValue();
			nodeCordinateValue.setX_cor(rs.getInt(TopologyConstantsIF.XCORDINATE_COL));
			nodeCordinateValue.setY_cor(rs.getInt(TopologyConstantsIF.YCORDINATE_COL));
			topologyInfo.setNodeCoordiante(nodeCordinateValue);
			return topologyInfo;
		}
	}

	protected List<TopologyInfoValue> retriveVerticalTopology(String query) {
		return queryForTopology(query, new VerticalTopologyInfoValueMapper());
	}

	final class VerticalTopologyInfoValueMapper implements RowMapper<TopologyInfoValue> {
		public TopologyInfoValue mapRow(ResultSet rs, int arg1) throws SQLException {
			TopologyInfoValue topologyInfo = new TopologyInfoValue();
			NodeParameters nodeParameters = new NodeParameters();
			nodeParameters.setAvailableBatteryPower(rs.getDouble(TopologyConstantsIF.POWERAVAILABLE_COL));
			nodeParameters.setBuffer(rs.getInt(TopologyConstantsIF.BUFFER_COL));
			nodeParameters.setEnergy(rs.getDouble(TopologyConstantsIF.ENERGY_COL));
			nodeParameters.setNetworkCost(rs.getInt(TopologyConstantsIF.NETWORKCOST_COL));
			nodeParameters.setTrustLevel(rs.getInt(TopologyConstantsIF.TRUST_COL));
			nodeParameters.setVerticalBelong((rs.getInt(TopologyConstantsIF.VERTICALBELONG_COL)));
			topologyInfo.setNodeParameters(nodeParameters);
			topologyInfo.setNodeId(rs.getInt(TopologyConstantsIF.NODEID_COL));
			NodeCordinateValue nodeCordinateValue = new NodeCordinateValue();
			nodeCordinateValue.setX_cor(rs.getInt(TopologyConstantsIF.XCORDINATE_COL));
			nodeCordinateValue.setY_cor(rs.getInt(TopologyConstantsIF.YCORDINATE_COL));
			topologyInfo.setNodeCoordiante(nodeCordinateValue);

			return topologyInfo;
		}
	}

	protected boolean insertVerticalBaseTopology(List<TopologyInfoValue> topologyInfoValue, String sqlKey) {
		System.out.println("Class-->RoutingBaseDAOImpl:Method-->insertVerticalBaseTopology Start");
		boolean insertionFlag = false;
		if (topologyInfoValue != null) {
			for (TopologyInfoValue topologyInfo : topologyInfoValue) {
				update(sqlKey, createTopologyMapWithVertical(topologyInfo));
			}
			insertionFlag = true;
		}
		System.out.println("Class-->RoutingBaseDAOImpl:Method-->insertVerticalBaseTopology End");
		return insertionFlag;

	}

	protected Map<String, Object> createTopologyMapWithVertical(TopologyInfoValue topologyInfo) {
		Map<String, Object> topologyMap = new HashMap<String, Object>();
		topologyMap.put(TopologyConstantsIF.BUFFER_COL, topologyInfo.getNodeParameters().getBuffer());
		topologyMap.put(TopologyConstantsIF.ENERGY_COL, topologyInfo.getNodeParameters().getEnergy());
		topologyMap.put(TopologyConstantsIF.NETWORKCOST_COL, topologyInfo.getNodeParameters().getNetworkCost());
		topologyMap.put(TopologyConstantsIF.NODEID_COL, topologyInfo.getNodeId());
		topologyMap.put(TopologyConstantsIF.POWERAVAILABLE_COL,
				topologyInfo.getNodeParameters().getAvailableBatteryPower());
		topologyMap.put(TopologyConstantsIF.XCORDINATE_COL, topologyInfo.getNodeCoordiante().getX_cor());
		topologyMap.put(TopologyConstantsIF.YCORDINATE_COL, topologyInfo.getNodeCoordiante().getY_cor());
		topologyMap.put(TopologyConstantsIF.TRUST_COL, topologyInfo.getNodeParameters().getTrustLevel());
		topologyMap.put(TopologyConstantsIF.VERTICALBELONG_COL, topologyInfo.getNodeParameters().getVerticalBelong());

		return topologyMap;
	}

	protected boolean createTable(String sqlKey1, String intermediateQuery, String sqlKey2) {
		boolean createTable = false;
		System.out.println("Class:RoutingDaoImpl-->Method:createTable()-->Start");
		try {
			String sql1 = sqlProperties.getMessage(sqlKey1, null, null, null);
			String sql2 = SPACE + intermediateQuery + SPACE;
			String sql3 = sqlProperties.getMessage(sqlKey2, null, null, null);
			String sql = sql1 + sql2 + sql3;
			Map<String, Object> map = null;
			System.out.println("named parameter" + namedJdbcTemplate);
			System.out.println("sql=" + sql);
			template.execute(sql);
			System.out.println("Class:RoutingDaoImpl-->Method:createTable()-->End of try");
		} catch (Exception e) {
			System.out.println("Class:RoutingDaoImpl-->Method:createTable()-->Exception" + e.getMessage());
			e.printStackTrace();
			createTable = false;
			return createTable;
		}
		createTable = true;
		return createTable;
	}

	protected boolean dropTable(String sqlKey) {
		boolean createTable = false;
		System.out.println("Class:RoutingDaoImpl-->Method:dropTable()-->Start");
		try {
			String sql = sqlProperties.getMessage(sqlKey, null, null, null);
			Map<String, Object> map = null;
			template.execute(sql);
		} catch (Exception e) {
			System.out.println("Class:RoutingDaoImpl-->Method:dropTable()-->Exception" + e.getMessage());
			createTable = false;
			return createTable;
		}
		createTable = true;
		return createTable;
	}

	protected boolean insertDynamicQuery(String sqlKey1, String intermediateQuery, String sqlKey2,
			Map<String, Object> insertMap) {
		boolean insertDynamicQuery = false;
		System.out.println("Class:RoutingDaoImpl-->Method:insertDynamicQuery()-->Start");
		try {
			String sql1 = sqlProperties.getMessage(sqlKey1, null, null, null);
			String sql2 = SPACE + intermediateQuery + SPACE;
			String sql3 = sqlProperties.getMessage(sqlKey2, null, null, null);
			String sqlQuery = sql1 + sql2 + sql3;
			System.out.println("Zone id SQL=" + sqlQuery);
			insertDynamicQuery = insertBasedOnQuery(sqlQuery, insertMap);
		} catch (Exception e) {
			System.out.println("Class:RoutingDaoImpl-->Method:insertDynamicQuery()-->Exception" + e.getMessage());
			insertDynamicQuery = false;
		}
		return insertDynamicQuery;
	}

	protected boolean updateDynamicQuery(String sqlKey1, String intermediateQuery, String sqlKey2,
			Map<String, Object> insertMap) {
		return insertDynamicQuery(sqlKey1, intermediateQuery, sqlKey2, insertMap);
	}

	/**
	 * @param sqlKey
	 * @param appenderQuery
	 * @param query
	 * @return List of Topology Information
	 */
	protected List<NormalRoutingTable> retriveNormalRoutingTable(String sqlKey, String appenderQuery) {
		String queryStart = sqlProperties.getMessage(sqlKey, null, null);
		String queryEnd = SPACE + appenderQuery;
		String query = queryStart + queryEnd;
		return queryForNormalRoutingTopology(query, new NormalRoutingTableMapper());
	}

	/**
	 * @param sqlKey
	 * @param appenderQuery
	 * @return List of vertical routing table
	 */
	protected List<VerticalRoutingTable> retriveVerticalRoutingTable(String sqlKey, String appenderQuery) {
		String queryStart = sqlProperties.getMessage(sqlKey, null, null);
		String queryEnd = SPACE + appenderQuery;
		String query = queryStart + queryEnd;
		return queryForVerticalRoutingTopology(query, new VerticalRoutingTableMapper());
	}

	/**
	 * @param sqlKey
	 * @param topologyMapper
	 * @return List of normal routing table
	 */
	private List<NormalRoutingTable> queryForNormalRoutingTopology(String querySql,
			RowMapper<NormalRoutingTable> topologyMapper) {
		return template.query(querySql, topologyMapper);
	}

	/**
	 * @param sqlKey
	 * @param topologyMapper
	 * @return List of vertical routing table
	 */
	private List<VerticalRoutingTable> queryForVerticalRoutingTopology(String querySql,
			RowMapper<VerticalRoutingTable> topologyMapper) {
		return template.query(querySql, topologyMapper);
	}

	final class NormalRoutingTableMapper implements RowMapper<NormalRoutingTable> {
		public NormalRoutingTable mapRow(ResultSet rs, int arg1) throws SQLException {
			NormalRoutingTable normalRoutingTable = new NormalRoutingTable();
			normalRoutingTable.setNodeId(rs.getInt(TopologyConstantsIF.NODEID_COL));
			normalRoutingTable.setDistance(rs.getDouble(TopologyConstantsIF.DISTANCE_COL));
			return normalRoutingTable;
		}
	}

	final class VerticalRoutingTableMapper implements RowMapper<VerticalRoutingTable> {
		public VerticalRoutingTable mapRow(ResultSet rs, int arg1) throws SQLException {
			VerticalRoutingTable normalRoutingTable = new VerticalRoutingTable();
			normalRoutingTable.setNodeId(rs.getInt(TopologyConstantsIF.NODEID_COL));
			normalRoutingTable.setDistance(rs.getDouble(TopologyConstantsIF.DISTANCE_COL));
			normalRoutingTable.setVerticalBelong(rs.getInt(TopologyConstantsIF.VERTICALBELONG_COL));
			return normalRoutingTable;
		}
	}

	protected boolean dropTable(String sqlKey1, String intermediateQuery) {
		boolean createTable = false;
		try {
			String sql1 = sqlProperties.getMessage(sqlKey1, null, null, null);
			String sql2 = SPACE + intermediateQuery + SPACE;
			String sql = sql1 + sql2;
			System.out.println("SQL=" + sql);
			template.execute(sql);
		} catch (Exception e) {
			System.out.println("Class:RoutingDaoImpl-->Method:createTable()-->Exception" + e.getMessage());
			createTable = false;
		}
		createTable = true;
		return createTable;
	}

	/**
	 * @param sqlKey
	 * @param topologyMapper
	 * @return List of zone based routing table entries
	 */
	protected List<ZoneRoutingTable> queryForZoneRoutingTopology(String sqlKey1, String intermediateQuery) {
		String queryStart = sqlProperties.getMessage(sqlKey1, null, null);
		String queryEnd = SPACE + intermediateQuery;
		String query = queryStart + queryEnd;
		return template.query(query, new ZoneRoutingTableMapper());
	}

	final class ZoneRoutingTableMapper implements RowMapper<ZoneRoutingTable> {
		public ZoneRoutingTable mapRow(ResultSet rs, int arg1) throws SQLException {
			ZoneRoutingTable zoneBasedRoutingTable = new ZoneRoutingTable();
			zoneBasedRoutingTable.setNodeId(rs.getInt(TopologyConstantsIF.NODEID_COL));
			zoneBasedRoutingTable.setDistance(rs.getDouble(TopologyConstantsIF.DISTANCE_COL));
			zoneBasedRoutingTable.setZoneId(rs.getInt(TopologyConstantsIF.ZONEID_COL));
			zoneBasedRoutingTable.setZoneLeader(rs.getInt(TopologyConstantsIF.ZONELEADER_COL) == 1 ? true : false);
			return zoneBasedRoutingTable;
		}
	}

	/**
	 * @param sqlKey
	 * @param topologyMapper
	 * @return List of angle based routing table entries
	 */
	protected List<AngleBasedRoutingTable> queryForAngleBasedRoutingTable(String sqlKey1, String intermediateQuery) {
		String queryStart = sqlProperties.getMessage(sqlKey1, null, null);
		String queryEnd = SPACE + intermediateQuery;
		String query = queryStart + queryEnd;
		return template.query(query, new AngleBasedRoutingTableMapper());
	}

	final class AngleBasedRoutingTableMapper implements RowMapper<AngleBasedRoutingTable> {
		public AngleBasedRoutingTable mapRow(ResultSet rs, int arg1) throws SQLException {
			AngleBasedRoutingTable angleBasedRoutingTable = new AngleBasedRoutingTable();
			angleBasedRoutingTable.setNodeId(rs.getInt(TopologyConstantsIF.NODEID_COL));
			angleBasedRoutingTable.setZoneId(rs.getInt(TopologyConstantsIF.ZONEID_COL));
			angleBasedRoutingTable.setZoneLeader(rs.getInt(TopologyConstantsIF.ZONELEADER_COL) == 1 ? true : false);
			angleBasedRoutingTable.setAngularPos(rs.getInt(TopologyConstantsIF.ANGULARPOSWITHBS_COL));

			angleBasedRoutingTable.setCloseToObs(rs.getInt(TopologyConstantsIF.CLOSERTOOBSTRACLE_COL));
			return angleBasedRoutingTable;
		}
	}

	/**
	 * @param sqlKey
	 * @return integer value
	 */
	protected double queryForDouble(String query) {
		SqlParameterSource paramSource = null;
		return (Double) namedJdbcTemplate.queryForObject(query, paramSource, Double.class);
	}

	/**
	 * @param sqlKey
	 *            -This is the SQL Key query
	 * @param topologyMapper
	 * @return List of Values
	 */
	protected List<PerformanceEnergy> queryForEnergyPerf(String sqlKey) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return template.query(sql, new PerformanceEnergyMapper());
	}

	final class PerformanceEnergyMapper implements RowMapper<PerformanceEnergy> {
		public PerformanceEnergy mapRow(ResultSet rs, int arg1) throws SQLException {
			PerformanceEnergy perfEnergy = new PerformanceEnergy();
			perfEnergy.setEnergyConsumed(rs.getDouble(ENERGY_COL));
			perfEnergy.setIterationNo(rs.getInt(ITERATION_COL));
			return perfEnergy;
		}
	}

	/**
	 * @param sqlKey
	 *            -This is the SQL Key query
	 * @param topologyMapper
	 * @return List of Values
	 */
	protected List<PerformanceDeadNodes> queryForDeadNodesPerf(String sqlKey) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return template.query(sql, new PerformanceDeadNodesMapper());
	}

	final class PerformanceDeadNodesMapper implements RowMapper<PerformanceDeadNodes> {
		public PerformanceDeadNodes mapRow(ResultSet rs, int arg1) throws SQLException {
			PerformanceDeadNodes perfDeadNodes = new PerformanceDeadNodes();
			perfDeadNodes.setNoOfDeadNodes(rs.getInt(DEADNODES_COL));
			perfDeadNodes.setIterationNo(rs.getInt(ITERATION_COL));
			return perfDeadNodes;
		}
	}

	/**
	 * @param sqlKey
	 *            -This is the SQL Key query
	 * @param topologyMapper
	 * @return List of Values
	 */
	protected List<PerformanceAliveNodes> queryForAliveNodesPerf(String sqlKey) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return template.query(sql, new PerformanceAliveNodesMapper());
	}

	final class PerformanceAliveNodesMapper implements RowMapper<PerformanceAliveNodes> {
		public PerformanceAliveNodes mapRow(ResultSet rs, int arg1) throws SQLException {
			PerformanceAliveNodes perfAliveNodes = new PerformanceAliveNodes();
			perfAliveNodes.setNoOfAliveNodes(rs.getInt(ALIVENODES_COL));
			perfAliveNodes.setIterationNo(rs.getInt(ITERATION_COL));
			return perfAliveNodes;
		}
	}

	/**
	 * @param sqlKey
	 *            -This is the SQL Key query
	 * @param topologyMapper
	 * @return List of Values for the Packet Loss in the Network
	 */
	protected List<PerformancePacketLoss> queryForPacketLossPerf(String sqlKey) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return template.query(sql, new PerformancePacketLossMapper());
	}

	final class PerformancePacketLossMapper implements RowMapper<PerformancePacketLoss> {
		public PerformancePacketLoss mapRow(ResultSet rs, int arg1) throws SQLException {
			PerformancePacketLoss packetLoss = new PerformancePacketLoss();
			packetLoss.setNoOfPacketsLost(rs.getInt(PACKETLOSS_COL));
			packetLoss.setIterationNo(rs.getInt(ITERATION_COL));
			return packetLoss;
		}
	}

	/**
	 * @param sqlKey
	 *            -This is the SQL Key query
	 * @param topologyMapper
	 * @return List of Values
	 */
	protected List<PerformanceHops> queryForHopsPerf(String sqlKey) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return template.query(sql, new PerformanceHopsMapper());
	}

	final class PerformanceHopsMapper implements RowMapper<PerformanceHops> {
		public PerformanceHops mapRow(ResultSet rs, int arg1) throws SQLException {
			PerformanceHops perfHops = new PerformanceHops();
			perfHops.setNoOfHops(rs.getInt(HOPS_COL));
			perfHops.setIterationNo(rs.getInt(ITERATION_COL));
			return perfHops;
		}
	}

	/**
	 * @param sqlKey
	 *            -This is the SQL Key query
	 * @param topologyMapper
	 * @return List of Values
	 */
	protected List<PerformancePower> queryForPowerPerf(String sqlKey) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return template.query(sql, new PerformancePowerMapper());
	}

	final class PerformancePowerMapper implements RowMapper<PerformancePower> {
		public PerformancePower mapRow(ResultSet rs, int arg1) throws SQLException {
			PerformancePower perfPower = new PerformancePower();
			perfPower.setPowerConsumed(rs.getDouble(POWER_COL));
			perfPower.setIterationNo(rs.getInt(ITERATION_COL));
			return perfPower;
		}
	}

	/**
	 * @param sqlKey
	 *            -This is the SQL Key query
	 * @param topologyMapper
	 * @return List of Values
	 */
	protected List<PerformanceTimeTaken> queryForTimeTakenPerf(String sqlKey) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return template.query(sql, new PerformanceTimeTakenMapper());
	}

	final class PerformanceTimeTakenMapper implements RowMapper<PerformanceTimeTaken> {
		public PerformanceTimeTaken mapRow(ResultSet rs, int arg1) throws SQLException {
			PerformanceTimeTaken perfTimeTaken = new PerformanceTimeTaken();
			perfTimeTaken.setTimeTaken(rs.getDouble(TIMETAKEN_COL));
			perfTimeTaken.setIterationNo(rs.getInt(ITERATION_COL));
			return perfTimeTaken;
		}
	}

	protected List<PerformanceTrust> queryForTrustPerf(String sqlKey) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return template.query(sql, new PerformanceTrustMapper());
	}

	final class PerformanceTrustMapper implements RowMapper<PerformanceTrust> {
		public PerformanceTrust mapRow(ResultSet rs, int arg1) throws SQLException {
			PerformanceTrust perfTrust = new PerformanceTrust();
			perfTrust.setTrustLevel(rs.getDouble(TRUSTPERF_COL));
			perfTrust.setIterationNo(rs.getInt(ITERATION_COL));
			return perfTrust;
		}
	}

	/**
	 * @param sqlKey
	 *            -This is the SQL Key query
	 * @param topologyMapper
	 * @return List of Values
	 */
	protected List<PerformanceRoutingOverhead> queryForROPerf(String sqlKey) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return template.query(sql, new PerformanceROMapper());
	}

	final class PerformanceROMapper implements RowMapper<PerformanceRoutingOverhead> {
		public PerformanceRoutingOverhead mapRow(ResultSet rs, int arg1) throws SQLException {
			PerformanceRoutingOverhead perfEnergy = new PerformanceRoutingOverhead();
			perfEnergy.setRoutingOverhead(rs.getDouble(ROUTINGOVERHEAD_COL));
			perfEnergy.setIterationNo(rs.getInt(ITERATION_COL));
			return perfEnergy;
		}
	}

	/**
	 * @param sqlKey
	 *            -This is the SQL Key query
	 * @param topologyMapper
	 * @return List of Values
	 */
	protected List<PerformanceLifeTimeRatio> queryForLifeTimePerf(String sqlKey) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return template.query(sql, new PerformanceLifeTimeRatioMapper());
	}

	final class PerformanceLifeTimeRatioMapper implements RowMapper<PerformanceLifeTimeRatio> {
		public PerformanceLifeTimeRatio mapRow(ResultSet rs, int arg1) throws SQLException {
			PerformanceLifeTimeRatio perfLifeTimeRatio = new PerformanceLifeTimeRatio();
			perfLifeTimeRatio.setLifeTimeRatio(rs.getDouble(LIFETIME_COL));
			perfLifeTimeRatio.setIterationNo(rs.getInt(ITERATION_COL));
			return perfLifeTimeRatio;
		}
	}

	/**
	 * @param sqlKey
	 *            -This is the SQL Key query
	 * @param topologyMapper
	 * @return List of Values
	 */
	protected List<PerformanceThroughput> queryForThroughputPerf(String sqlKey) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return template.query(sql, new PerformanceThroughputRatioMapper());
	}

	final class PerformanceThroughputRatioMapper implements RowMapper<PerformanceThroughput> {
		public PerformanceThroughput mapRow(ResultSet rs, int arg1) throws SQLException {
			PerformanceThroughput perfThroughput = new PerformanceThroughput();
			perfThroughput.setThroughput(rs.getDouble(THROUGHPUT_COL));
			perfThroughput.setIterationNo(rs.getInt(ITERATION_COL));
			return perfThroughput;
		}
	}

	/**
	 * @param sqlKey
	 *            -This is the SQL Key query
	 * @param topologyMapper
	 * @return List of Values
	 */
	protected List<PerformanceResidualEnergy> queryForResidualEnergyPerf(String sqlKey) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		return template.query(sql, new PerformanceResidualEnergyMapper());
	}

	final class PerformanceResidualEnergyMapper implements RowMapper<PerformanceResidualEnergy> {
		public PerformanceResidualEnergy mapRow(ResultSet rs, int arg1) throws SQLException {
			PerformanceResidualEnergy perfResidualEnergy = new PerformanceResidualEnergy();
			perfResidualEnergy.setResidualEnergy((rs.getDouble(RESIDUALENERGY_COL)));
			perfResidualEnergy.setIterationNo(rs.getInt(ITERATION_COL));
			return perfResidualEnergy;
		}
	}
	
	/**
	 * @param sqlKey
	 * @param topologyMapper
	 * @param params
	 * @return List of Topology Information
	 */
	public int queryForInt(String sqlKey) {
		String sql = sqlProperties.getMessage(sqlKey, null, null);
		int noOfRecords = 0;
		try {
			Map<String, Object> paramMap = null;

			noOfRecords = namedJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
		} catch (Exception e) {
			return 0;
		}
		return noOfRecords;
	}
	
	
	
	public int queryForIntUsingQuery(String sqlKey) {
		int noOfRecords = 0;
		try {
			Map<String, Object> paramMap = null;

			noOfRecords = namedJdbcTemplate.queryForObject(sqlKey, paramMap, Integer.class);
		} catch (Exception e) {
			return 0;
		}
		return noOfRecords;
	}

	/**
	 * @param sqlKey
	 * @param topologyMapper
	 * @param params
	 * @return List of Topology Information
	 */
	public double queryForDOubleUsingQuery(String sqlKey) {
		double noOfRecords = 0;
		try {
			Map<String, Object> paramMap = null;

			noOfRecords = namedJdbcTemplate.queryForObject(sqlKey, paramMap, Double.class);
		} catch (Exception e) {
			return 0;
		}
		return noOfRecords;
	}
	
	final class NodeIdMappers implements RowMapper<Integer> {
		public Integer mapRow(ResultSet rs, int arg1) throws SQLException {
			int nodeId = rs.getInt(NODEID_COL);
			return nodeId;
		}
	}
}
