package com.routingtopology.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.routingtopology.dao.inter.PowerParametersDAOIF;


@Repository
public class PowerParametersDAOImpl extends RoutingDaoImpl implements PowerParametersDAOIF {
	
	private static final String CLASS_NAME = "Class--->PowerParametersDAOImpl:";

	private static final String METHOD_NAME = "Method--->";

	private static final String START_NAME = "START";

	private static final String END_NAME = "END";

	private static final String EXCEPTION = "Exception-->";

	@Override
	public boolean createPowerTable(String dynamicName) {
		boolean createPower = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "createPowerTable()"
				+ START_NAME);
		try {
			createPower = createTable(CREATE_POWER_TABLE_START_QUERY,
					dynamicName, CREATE_POWER_TABLE_END_QUERY);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "createPowerTable()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "createPowerTable()"
				+ END_NAME);
		return createPower;
	}

	@Override
	public boolean deletePower(String dynamicTableName) {
		boolean deletePower = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "deletePower()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					DELETE_POWER_TABLE_START_QUERY, null, null, null);
			String sql2 = dynamicTableName;
			String sql = sql1 + SPACE + sql2;
			System.out.println(CLASS_NAME + METHOD_NAME + "deletePower()"
					+ "Query=" + sql);
			deletePower = deleteWithCompleteQuery(sql);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "deletePower()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "deletePower()"
				+ END_NAME);
		return deletePower;
	}

	@Override
	public boolean insertPower(String dynamicTableName, double powerValue) {
		boolean insertEnergy = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "insertPower()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					INSERT_POWER_TABLE_START_QUERY, null, null, null);
			String sql2 = sqlProperties.getMessage(
					INSERT_POWER_TABLE_END_QUERY, null, null, null);
			String sqlQuery = sql1 + SPACE + dynamicTableName + sql2;
			insertEnergy = insertBasedOnQuery(sqlQuery,
					createPowerMap(powerValue));
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "insertPower()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "insertPower()"
				+ END_NAME);
		return insertEnergy;
	}

	

	@Override
	public double retrivePower(String dynamicTableName) {
		double power = 0;
		System.out.println(CLASS_NAME + METHOD_NAME + "retrivePower()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					RETRIVE_POWER_TABLE_START_QUERY, null, null, null);
			String sqlQuery = sql1 + SPACE + dynamicTableName;
			power = queryForDouble(sqlQuery);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "retrivePower()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retrivePower()"
				+ END_NAME);
		return power;
	}

	@Override
	public boolean updatePower(String dynamicTableName, double powerValue) {
		boolean updatePower = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "updatePower()"
				+ START_NAME);
		try {
			updatePower = updateDynamicQuery(UPDATE_POWER_TABLE_START_QUERY,
					dynamicTableName, UPDATE_POWER_TABLE_END_QUERY,
					createPowerMap(powerValue));
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "updatePower()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "updatePower()"
				+ END_NAME);
		return updatePower;
	}

	@Override
	public boolean dropPowerTable(String dynamicName) {
		boolean dropPower = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "dropPowerTable()"
				+ START_NAME);
		try {
			dropPower = dropTable(DROP_POWER_TABLE_START_QUERY, dynamicName);
			dropPower=true;
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "dropPowerTable()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "dropPowerTable()" + END_NAME);
		return dropPower;
	}
	
	
	private Map<String, Object> createPowerMap(double power) {
		Map<String, Object> energyMap = new HashMap<String, Object>();
		energyMap.put(POWER, power);
		return energyMap;
	}


}
