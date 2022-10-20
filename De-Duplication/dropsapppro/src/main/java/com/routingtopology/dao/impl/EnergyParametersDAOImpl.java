package com.routingtopology.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.routingtopology.dao.inter.EnergyParametersDAOIF;

/**
 * This is the class used for all energy parameters measurement
 * 
 */
@Repository
public class EnergyParametersDAOImpl extends RoutingDaoImpl implements
		EnergyParametersDAOIF {

	private static final String CLASS_NAME = "Class--->EnergyParametersDAOImpl:";

	private static final String METHOD_NAME = "Method--->";

	private static final String START_NAME = "START";

	private static final String END_NAME = "END";

	private static final String EXCEPTION = "Exception-->";

	@Override
	public boolean createEnergyTable(String dynamicName) {
		boolean createEnery = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "createEnergyTable()"
				+ START_NAME);
		try {
			createEnery = createTable(CREATE_ENERGY_TABLE_START_QUERY,
					dynamicName, CREATE_ENERGY_TABLE_END_QUERY);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "createEnergyTable()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "createEnergyTable()"
				+ END_NAME);
		return createEnery;

	}

	@Override
	public boolean deleteEnergy(String dynamicTableName) {
		boolean deleteEnery = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteEnergy()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					DELETE_ENERGY_TABLE_START_QUERY, null, null, null);
			String sql2 = dynamicTableName;
			String sql = sql1 + SPACE + sql2;
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteEnergy()"
					+ "Query=" + sql);
			deleteEnery = deleteWithCompleteQuery(sql);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteEnergy()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteEnergy()"
				+ END_NAME);
		return deleteEnery;
	}

	@Override
	public boolean dropEnergyTable(String dynamicName) {
		boolean dropEnergy = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "dropTable()"
				+ START_NAME);
		try {
			dropEnergy = dropTable(DROP_ENERGY_TABLE_START_QUERY, dynamicName);
			dropEnergy=true;
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "dropTable()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "dropTable()" + END_NAME);
		return dropEnergy;
	}

	@Override
	public boolean insertEnergy(String dynamicTableName, double energyValue) {
		boolean insertEnergy = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "insertEnergy()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					INSERT_ENERGY_TABLE_START_QUERY, null, null, null);
			String sql2 = sqlProperties.getMessage(
					INSERT_ENERGY_TABLE_END_QUERY, null, null, null);
			String sqlQuery = sql1 + SPACE + dynamicTableName + sql2;
			insertEnergy = insertBasedOnQuery(sqlQuery,
					createEnergyMap(energyValue));
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "insertEnergy()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "insertEnergy()"
				+ END_NAME);
		return insertEnergy;
	}

	private Map<String, Object> createEnergyMap(double energyValue) {
		Map<String, Object> energyMap = new HashMap<String, Object>();
		energyMap.put(ENERGY, energyValue);
		return energyMap;
	}

	@Override
	public double retriveEnergy(String dynamicTableName) {
		double energy = 0;
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveEnergy()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					RETRIVE_ENERGY_TABLE_START_QUERY, null, null, null);
			String sqlQuery = sql1 + SPACE + dynamicTableName;
			energy = queryForDouble(sqlQuery);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "retriveEnergy()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveEnergy()"
				+ END_NAME);
		return energy;
	}

	@Override
	public boolean updateEnergy(String dynamicTableName, double energyValue) {
		boolean updateEnergy = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "updateEnergy()"
				+ START_NAME);
		try {
			updateEnergy = updateDynamicQuery(UPDATE_ENERGY_TABLE_START_QUERY,
					dynamicTableName, UPDATE_ENERGY_TABLE_END_QUERY,
					createEnergyMap(energyValue));
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "insertEnergy()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "insertEnergy()"
				+ END_NAME);
		return updateEnergy;
	}

}
