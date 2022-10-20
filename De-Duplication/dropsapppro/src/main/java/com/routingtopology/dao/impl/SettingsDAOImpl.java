package com.routingtopology.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.routingtopology.value.TopologyTypeVO;

@Repository
public class SettingsDAOImpl extends RoutingDaoImpl implements SettingsDAOIF {

	@Override
	public boolean updateTopologyType(TopologyTypeVO topologyType) {

		boolean topologyTypeFlag = false;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("PROPERTYVALUE", topologyType.getPropertyValue());
			map.put("PROPERTYNAME", topologyType.getPropertyName());
			update(UPDATE_SETTINGS_QUERY, map);
			topologyTypeFlag=true;
		} catch (Exception e) {
			topologyTypeFlag = false;
		}

		return topologyTypeFlag;
	}

	@Override
	public String retrivePropertyValueForPropertyName(String topologyType) {

		String propertyValue = null;
		try {

			String sql = sqlProperties.getMessage(RETRIVE_PROPERTY_VALUE_FOR_PROPERTY_NAME_QUERY, null, null);

			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("PROPERTYNAME", topologyType);

			return namedJdbcTemplate.queryForObject(sql, paramMap, String.class);

		} catch (Exception e) {
			propertyValue = null;
		}
		return propertyValue;
	}

}
