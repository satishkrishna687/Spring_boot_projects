
package com.routingtopology.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.routingtopology.dao.inter.TrustParameterDAOIF;

/**
 * This is the Trust Parameter DAO Implementation
 *
 */
@Repository
public class TrustParametersDAOImpl extends RoutingDaoImpl implements TrustParameterDAOIF {
	
	private static final String CLASS_NAME = "Class--->TrustParametersDAOImpl:";

	private static final String METHOD_NAME = "Method--->";

	private static final String START_NAME = "START";

	private static final String END_NAME = "END";

	private static final String EXCEPTION = "Exception-->";

	@Override
	public boolean createTrustTable(String dynamicName) {
		boolean createTrust = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "createTrustTable()"
				+ START_NAME);
		try {
			createTrust = createTable(CREATE_TRUST_TABLE_START_QUERY,
					dynamicName, CREATE_TRUST_TABLE_END_QUERY);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "createTrustTable()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "createTrustTable()"
				+ END_NAME);
		return createTrust;
	}

	@Override
	public boolean deleteTrust(String dynamicTableName) {
		boolean deleteTrust = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteTrust()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					DELETE_TRUST_TABLE_START_QUERY, null, null, null);
			String sql2 = dynamicTableName;
			String sql = sql1 + SPACE + sql2;
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteTrust()"
					+ "Query=" + sql);
			deleteTrust = deleteWithCompleteQuery(sql);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteTrust()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteTrust()"
				+ END_NAME);
		return deleteTrust;
	}

	@Override
	public boolean dropTrustTable(String dynamicName) {
		boolean dropBuffer = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "dropTable()"
				+ START_NAME);
		try {
			dropBuffer = dropTable(DROP_TRUST_TABLE_START_QUERY, dynamicName);
			dropBuffer=true;
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "dropTable()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "dropTable()" + END_NAME);
		return dropBuffer;
	}

	@Override
	public boolean insertTrust(String dynamicTableName, int trustLevel) {
		boolean insertTrust = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "insertTrust()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					INSERT_TRUST_TABLE_START_QUERY, null, null, null);
			String sql2 = sqlProperties.getMessage(
					INSERT_TRUST_TABLE_END_QUERY, null, null, null);
			String sqlQuery = sql1 + SPACE + dynamicTableName + sql2;
			System.out.println("Query="+sqlQuery);
			insertTrust = insertBasedOnQuery(sqlQuery,
					createTrustMap(trustLevel));
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "insertTrust()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "insertTrust()"
				+ END_NAME);
		return insertTrust;
	}

	@Override
	public int retriveTrust(String dynamicTableName) {
		int trustLevel = 0;
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveTrust()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					RETRIVE_TRUST_TABLE_START_QUERY, null, null, null);
			String sqlQuery = sql1 + SPACE + dynamicTableName;
			System.out.println("Query="+sqlQuery);
			trustLevel = queryForIntUsingQuery(sqlQuery);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "retriveTrust()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveTrust()"
				+ END_NAME);
		return trustLevel;
	}

	@Override
	public boolean updateTrust(String dynamicTableName, int trustLevel) {
		boolean updateTrust = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "updateTrust()"
				+ START_NAME);
		try {
			updateTrust = updateDynamicQuery(UPDATE_TRUST_TABLE_START_QUERY,
					dynamicTableName, UPDATE_TRUST_TABLE_END_QUERY,
					createTrustMap(trustLevel));
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "updateTrust()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "updateTrust()"
				+ END_NAME);
		return updateTrust;
	}
	
	private Map<String, Object> createTrustMap(int buffer) {
		Map<String, Object> energyMap = new HashMap<String, Object>();
		energyMap.put(TRUST, buffer);
		return energyMap;
	}

}
