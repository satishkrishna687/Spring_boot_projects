package com.routingtopology.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.routingtopology.dao.inter.NetworkCostParametersDAOIF;

/**
 * This is the network cost parameters DAO Implementation
 *
 */
@Repository
public class NetworkCostParametersDAOImpl extends RoutingDaoImpl implements NetworkCostParametersDAOIF {
	
	private static final String CLASS_NAME = "Class--->TrustParametersDAOImpl:";

	private static final String METHOD_NAME = "Method--->";

	private static final String START_NAME = "START";

	private static final String END_NAME = "END";

	private static final String EXCEPTION = "Exception-->";

	@Override
	public boolean createNetworkCostTable(String dynamicName) {
		boolean createNetworkCost = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "createNetworkCostTable()"
				+ START_NAME);
		try {
			createNetworkCost = createTable(CREATE_NETWORKCOST_TABLE_START_QUERY,
					dynamicName, CREATE_NETWORKCOST_TABLE_END_QUERY);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "createNetworkCostTable()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "createNetworkCostTable()"
				+ END_NAME);
		return createNetworkCost;
	}

	@Override
	public boolean deleteNetworkCost(String dynamicTableName) {
		boolean deleteNetworkCost = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteNetworkCost()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					DELETE_NETWORKCOST_TABLE_START_QUERY, null, null, null);
			String sql2 = dynamicTableName;
			String sql = sql1 + SPACE + sql2;
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteNetworkCost()"
					+ "Query=" + sql);
			deleteNetworkCost = deleteWithCompleteQuery(sql);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteNetworkCost()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteNetworkCost()"
				+ END_NAME);
		return deleteNetworkCost;
	}

	@Override
	public boolean dropNetworkCostTable(String dynamicName) {
		boolean dropBuffer = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "dropTable()"
				+ START_NAME);
		try {
			dropBuffer = dropTable(DROP_NETWORKCOST_TABLE_START_QUERY, dynamicName);
			dropBuffer=true;
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "dropTable()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "dropTable()" + END_NAME);
		return dropBuffer;
	}

	@Override
	public boolean insertNetworkCost(String dynamicTableName, double networkCost) {
		boolean insertNetworkCost = false;
		try {
			String sql1 = sqlProperties.getMessage(
					INSERT_NETWORKCOST_TABLE_START_QUERY, null, null, null);
			String sql2 = sqlProperties.getMessage(
					INSERT_NETWORKCOST_TABLE_END_QUERY, null, null, null);
			String sqlQuery = sql1 + SPACE + dynamicTableName + sql2;
			System.out.println("Query="+sqlQuery);
			insertNetworkCost = insertBasedOnQuery(sqlQuery,
					createNetworkMap(networkCost));
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "insertNetworkCost()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "insertNetworkCost()"
				+ END_NAME);
		return insertNetworkCost;
	}

	@Override
	public int retriveNetworkCost(String dynamicTableName) {
		int networkCost = 0;
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveNetworkCost()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					RETRIVE_NETWORKCOST_TABLE_START_QUERY, null, null, null);
			String sqlQuery = sql1 + SPACE + dynamicTableName;
			System.out.println("Query="+sqlQuery);
			networkCost = queryForIntUsingQuery(sqlQuery);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "retriveNetworkCost()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveNetworkCost()"
				+ END_NAME);
		return networkCost;
	}

	@Override
	public boolean updateNetworkCost(String dynamicTableName, int networkCost) {
		boolean updateTrust = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "updateNetworkCost()"
				+ START_NAME);
		try {
			updateTrust = updateDynamicQuery(UPDATE_NETWORKCOST_TABLE_START_QUERY,
					dynamicTableName, UPDATE_NETWORKCOST_TABLE_END_QUERY,
					createNetworkMap(networkCost));
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "updateNetworkCost()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "updateNetworkCost()"
				+ END_NAME);
		return updateTrust;
	}
	
	private Map<String, Object> createNetworkMap(double networkCost) {
		Map<String, Object> energyMap = new HashMap<String, Object>();
		energyMap.put(NETWORKCOST, networkCost);
		return energyMap;
	}

}
