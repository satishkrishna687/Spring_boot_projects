package com.routingtopology.dao.impl;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.routingtopology.dao.inter.SignalStrengthParameterDAOIF;


@Repository
public class SignalStengthDAOImpl extends RoutingDaoImpl implements SignalStrengthParameterDAOIF {

	private static final String CLASS_NAME = "Class:SignalStengthDAOImpl-->";
	private static final String METHOD_NAME = "Method:";
	private static final String START_NAME ="Start";
	private static final String EXCEPTION = "Exception:";
	private static final String END_NAME = "End"; 

	@Override
	public boolean createSignalStrengthTable(String dynamicName) {
		
		boolean createBuffer = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "createSignalStrengthTable()"
				+ START_NAME);
		try {
			createBuffer = createTable(CREATE_SIGNAL_TABLE_START_QUERY,
					dynamicName, CREATE_SIGNAL_TABLE_END_QUERY);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "createSignalStrengthTable()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "createSignalStrengthTable()"
				+ END_NAME);
		return createBuffer;
	}

	@Override
	public boolean deleteSignalStrength(String dynamicTableName) {
		boolean deleteSignalStrength = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteSignalStrength()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					DELETE_SIGNAL_TABLE_START_QUERY, null, null, null);
			String sql2 = dynamicTableName;
			String sql = sql1 + SPACE + sql2;
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteSignalStrength()"
					+ "Query=" + sql);
			deleteSignalStrength = deleteWithCompleteQuery(sql);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteSignalStrength()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteSignalStrength()"
				+ END_NAME);
		return deleteSignalStrength; 
		
		
	}

	@Override
	public boolean dropSignalStrengthTable(String dynamicName) {
		boolean dropSignalStrength = false; 
		System.out.println(CLASS_NAME + METHOD_NAME + "dropSignalStrengthTable()"
				+ START_NAME);
		try {
			dropSignalStrength = dropTable(DROP_SIGNAL_TABLE_START_QUERY, dynamicName);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "dropSignalStrengthTable()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "dropSignalStrengthTable()" + END_NAME);
		return dropSignalStrength;
	}

	@Override
	public boolean insertSignalStrength(String dynamicTableName,
			double signalstrength) {
		boolean insertBuffer = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "insertBuffer()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					INSERT_SIGNAL_TABLE_START_QUERY, null, null, null);
			String sql2 = sqlProperties.getMessage(
					INSERT_SIGNAL_TABLE_END_QUERY, null, null, null);
			String sqlQuery = sql1 + SPACE + dynamicTableName + sql2;
			insertBuffer = insertBasedOnQuery(sqlQuery,
					createSignalStrengthMap(signalstrength));
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "insertSignalStrength()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "insertSignalStrength()"
				+ END_NAME);
		return insertBuffer;
	}

	@Override
	public double retriveSignalStrengthTable(String dynamicTableName) {
		double energy = 0;
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveSignalStrengthTable()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					RETRIVE_SIGNAL_TABLE_START_QUERY, null, null, null);
			String sqlQuery = sql1 + SPACE + dynamicTableName;
			energy = queryForDOubleUsingQuery(sqlQuery);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "retriveSignalStrengthTable()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveSignalStrengthTable()"
				+ END_NAME);
		return energy;
	}

	@Override
	public boolean updateSignalStrength(String dynamicTableName,
			double signalstrength) {
		boolean updateEnergy = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "updateSignalStrength()"
				+ START_NAME);
		try {
			updateEnergy = updateDynamicQuery(UPDATE_SIGNAL_TABLE_START_QUERY,
					dynamicTableName, UPDATE_SIGNAL_TABLE_END_QUERY,
					createSignalStrengthMap(signalstrength));
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "updateSignalStrength()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "updateSignalStrength()"
				+ END_NAME);
		return updateEnergy;
	}
	
	private Map<String, Object> createSignalStrengthMap(double signalstrength) {
		Map<String, Object> energyMap = new HashMap<String, Object>();
		energyMap.put(SIGNAL_STRENGTH, signalstrength); 
		return energyMap;
	}

}
