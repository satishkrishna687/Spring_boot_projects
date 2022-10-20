package com.routingtopology.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.routingtopology.dao.impl.AlphaDAOImpl.AlphaInfoMapper;
import com.routingtopology.dao.inter.RelayFuncDAOIF;
import com.routingtopology.value.AlphaInfo;
import com.routingtopology.value.RelayNodeFunction;

/**
 * This is the Class Which is Used For Relay related CRUD operations
 */
@Repository
public class RelayFuncDAOImpl extends RoutingDaoImpl implements RelayFuncDAOIF {

	private static final String RESIDUALENERGY1_COL = "RESIDUALENERGY";

	@Override
	public boolean deleteRelayFunc() {
		boolean value = false;
		try {
			String sql = sqlProperties.getMessage(DELETE_RELAYINFORMATION_SQL,
					null, null);
			Map<String, Object> map = null;
			template.update(sql, map);
			value = true;
		} catch (Exception e) {
			return false;
		}
		return value;
	}

	@Override
	public boolean insertRelayFn(RelayNodeFunction relayFn) {

		boolean flag = false;
		try {
			if (relayFn != null) {

				String sql = sqlProperties.getMessage(
						INSERT_RELAYINFORMATION_SQL, null, null);

				Map<String, Object> alphaMap = createRelayMap(relayFn);
				namedJdbcTemplate.update(sql, alphaMap);

				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return flag;
		}
	}

	private Map<String, Object> createRelayMap(RelayNodeFunction relayFn) {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put(NODEID_COL, relayFn.getNodeId());
		map.put(K1_COL, relayFn.getK1());
		map.put(K2_COL, relayFn.getK2());
		map.put(RESIDUALENERGY1_COL, relayFn.getResidualEnergy());
		map.put(MAXENERGY_COL, relayFn.getResidualEnergy());
		map.put(DISTANCEBSNODE_COL, relayFn.getResidualEnergy());
		map.put(DISTANCENODECH_COL, relayFn.getResidualEnergy());
		map.put(ALPHA_COL, relayFn.getAlpha());

		return map;

	}

	@Override
	public RelayNodeFunction retriveRelayForNode(int nodeId) {
		RelayNodeFunction alphaInfo = null;
		try {
			String sql = sqlProperties.getMessage(
					RETRIVE_RELAYFUNCINFORMATION_SQL, null, null);
			alphaInfo = template.queryForObject(sql, new RelayNodeFnMapper(),
					createMapForNodeId(nodeId));
		} catch (Exception e) {
			return null;
		}
		return alphaInfo;
	}

	private Map<String,Object> createMapForNodeId(int nodeId) {
	
		Map<String,Object> mapNodeId=new HashMap<String,Object>();
		mapNodeId.put(NODEID_COL, nodeId);
		return mapNodeId;
	}

	@Override
	public List<RelayNodeFunction> retriveRelayFuncAll() {
		List<RelayNodeFunction> alphaInfoList = null;
		try {
			String sql = sqlProperties.getMessage(RETRIVE_RELAYFUNCINFORMATION_SQL,
					null, null);
			alphaInfoList = template.query(sql, new RelayNodeFnMapper());
		} catch (Exception e) {
			return null;
		}
		return alphaInfoList;
	}
	
	final class RelayNodeFnMapper implements RowMapper<RelayNodeFunction> {
		public RelayNodeFunction mapRow(ResultSet rs, int arg1) throws SQLException {
			RelayNodeFunction relayNodeTemp = new RelayNodeFunction();
			relayNodeTemp.setNodeId(rs.getInt(NODEID_COL)); 
			relayNodeTemp.setAlpha(rs.getDouble(ALPHA_COL));
			relayNodeTemp.setK1(rs.getInt(K1_COL));
			relayNodeTemp.setK2(rs.getInt(K2_COL));
			relayNodeTemp.setDistanceBetweenNodeBS(rs.getDouble(DISTANCEBSNODE_COL));
			relayNodeTemp.setDistanceBetweenNodeCH(rs.getDouble(DISTANCENODECH_COL));
			return relayNodeTemp;
		}
	}

}
