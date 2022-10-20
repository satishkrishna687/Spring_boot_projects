package com.routingtopology.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.routingtopology.dao.inter.BufferParametersDAOIF;

@Repository
public class BufferParametersDAOImpl extends RoutingDaoImpl implements BufferParametersDAOIF {

	private static final String CLASS_NAME = "Class--->BufferParametersDAOImpl:";

	private static final String METHOD_NAME = "Method--->";

	private static final String START_NAME = "START";

	private static final String END_NAME = "END";

	private static final String EXCEPTION = "Exception-->";

	@Override
	public boolean createBufferTable(String dynamicName) {
		boolean createBuffer = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "createBufferTable()"
				+ START_NAME);
		try {
			createBuffer = createTable(CREATE_BUFFER_TABLE_START_QUERY,
					dynamicName, CREATE_BUFFER_TABLE_END_QUERY);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "createBufferTable()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "createBufferTable()"
				+ END_NAME);
		return createBuffer;
	}

	@Override
	public boolean deleteBuffer(String dynamicTableName) {
		boolean deleteBuffer = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteBuffer()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					DELETE_BUFFER_TABLE_START_QUERY, null, null, null);
			String sql2 = dynamicTableName;
			String sql = sql1 + SPACE + sql2;
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteBuffer()"
					+ "Query=" + sql);
			deleteBuffer = deleteWithCompleteQuery(sql);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteBuffer()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteBuffer()"
				+ END_NAME);
		return deleteBuffer;
	}

	@Override
	public boolean dropBufferTable(String dynamicName) {
		boolean dropBuffer = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "dropTable()"
				+ START_NAME);
		try {
			dropBuffer = dropTable(DROP_BUFFER_TABLE_START_QUERY, dynamicName);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "dropTable()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "dropTable()" + END_NAME);
		return dropBuffer;
	}

	@Override
	public boolean insertBuffer(String dynamicTableName, int buffer) {
		boolean insertBuffer = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "insertBuffer()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					INSERT_BUFFER_TABLE_START_QUERY, null, null, null);
			String sql2 = sqlProperties.getMessage(
					INSERT_BUFFER_TABLE_END_QUERY, null, null, null);
			String sqlQuery = sql1 + SPACE + dynamicTableName + sql2;
			insertBuffer = insertBasedOnQuery(sqlQuery,
					createBufferMap(buffer));
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "insertBuffer()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "insertBuffer()"
				+ END_NAME);
		return insertBuffer;
	}

	@Override
	public int retriveBuffer(String dynamicTableName) {
		int energy = 0;
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveBuffer()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					RETRIVE_BUFFER_TABLE_START_QUERY, null, null, null);
			String sqlQuery = sql1 + SPACE + dynamicTableName;
			energy = queryForIntUsingQuery(sqlQuery);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "retriveBuffer()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveBuffer()"
				+ END_NAME);
		return energy;
	}

	@Override
	public boolean updateBuffer(String dynamicTableName, int buffer) {
		boolean updateEnergy = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "updateBuffer()"
				+ START_NAME);
		try {
			updateEnergy = updateDynamicQuery(UPDATE_BUFFER_TABLE_START_QUERY,
					dynamicTableName, UPDATE_BUFFER_TABLE_END_QUERY,
					createBufferMap(buffer));
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "updateBuffer()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "updateBuffer()"
				+ END_NAME);
		return updateEnergy;
	}

	private Map<String, Object> createBufferMap(int buffer) {
		Map<String, Object> energyMap = new HashMap<String, Object>();
		energyMap.put(BUFFER, buffer);
		return energyMap;
	}

}
