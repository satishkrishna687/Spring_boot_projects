package com.routingtopology.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.routingtopology.dao.inter.AlphaDAOIF;
import com.routingtopology.value.AlphaInfo;

/**
 * This is the Class For CRUD
 * 
 * Operation on Alpha RCER
 * 
 */
@Repository
public class AlphaDAOImpl extends RoutingDaoImpl implements AlphaDAOIF {

	@Override
	public boolean deleteAllAlphaInfo() {
		boolean value = false;
		try {
			String sql = sqlProperties.getMessage(DELETE_ALPHAINFORMATION_SQL, null, null);
			Map<String, Object> map = null;
			template.update(sql, map);
			value = true;
		} catch (Exception e) {
			return false;
		}
		return value;

	}

	@Override
	public boolean insertAlphaInfo(List<AlphaInfo> alphaInfo) {

		boolean flag = false;
		try {
			if (alphaInfo != null) {
				int size = alphaInfo.size();

				String sql = sqlProperties.getMessage(INSERT_ALPHAINFORMATION_SQL, null, null);
				if (size > 0) {

					for (AlphaInfo alphaInfoTemp : alphaInfo) {
						Map<String, Object> alphaMap = createAlphaMap(alphaInfoTemp);
						namedJdbcTemplate.update(sql, alphaMap);

					}
					return true;
				} else {
					return false;
				}

			}

		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	private Map<String, Object> createAlphaMap(AlphaInfo alphaInfoTemp) {
		Map<String, Object> alphaMap = new HashMap<String, Object>();
		alphaMap.put(NODEID, alphaInfoTemp.getNodeId());
		alphaMap.put(ALPHA, alphaInfoTemp.getAlpha());
		return alphaMap;

	}

	@Override
	public int retriveAlphaCount() {

		int count = 0;
		try {
			String sql = sqlProperties.getMessage(RETRIVE_ALPHAINFORMATION_COUNT_SQL, null, null);

			Map<String, Object> paramMap = null;

			count = namedJdbcTemplate.queryForObject(sql, paramMap, Integer.class);

		} catch (Exception e) {
			return 0;

		}
		return count;
	}

	@Override
	public List<AlphaInfo> retriveAlphaInfo() {

		List<AlphaInfo> alphaInfoList = null;
		try {
			String sql = sqlProperties.getMessage(RETRIVE_ALPHAINFORMATION_SQL, null, null);
			alphaInfoList = template.query(sql, new AlphaInfoMapper());
		} catch (Exception e) {
			return null;
		}
		return alphaInfoList;

	}

	final class AlphaInfoMapper implements RowMapper<AlphaInfo> {
		public AlphaInfo mapRow(ResultSet rs, int arg1) throws SQLException {
			AlphaInfo perfTrust = new AlphaInfo();
			perfTrust.setNodeId(rs.getInt(NODEID_COL));
			perfTrust.setAlpha(rs.getDouble(ALPHA_COL));
			return perfTrust;
		}
	}

	@Override
	public AlphaInfo retriveAlphaInformation(int nodeId) {
		AlphaInfo alphaInfo = null;
		try {
			String sql = sqlProperties.getMessage(RETRIVE_ALPHAINFORMATION_FOR_NODEID_SQL, null, null);
			alphaInfo = template.queryForObject(sql, new AlphaInfoMapper(), createMapForNodeId(nodeId));
		} catch (Exception e) {
			return null;
		}
		return alphaInfo;
	}

	private Map<String, Object> createMapForNodeId(int nodeId) {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put(NODEID, nodeId);
		return map;
	}

}
