package com.routingtopology.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.routingtopology.dao.inter.EigenParameterDAOIF;

@Repository
public class EigenParameterDaoImpl extends RoutingDaoImpl implements EigenParameterDAOIF {

	private static final String CLASS_NAME = "Class--->EigenParameterDaoImpl:";

	private static final String METHOD_NAME = "Method--->";

	private static final String START_NAME = "START";

	private static final String END_NAME = "END";

	private static final String EXCEPTION = "Exception-->";

	@Override
	public boolean createEigenTrustTable(String dynamicName) {
		boolean createEigenTrust = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "createEigenTrustTable()"
				+ START_NAME);
		try {
			createEigenTrust = createTable(CREATE_EIGEN_TRUST_TABLE_START_QUERY,
					dynamicName, CREATE_EIGEN_TRUST_TABLE_END_QUERY);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "createEigenTrustTable()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "createEigenTrustTable()"
				+ END_NAME);
		return createEigenTrust;
	}

	@Override
	public boolean deleteEigenTrust(String dynamicTableName) {
		boolean deleteTrust = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteEigenTrust()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					DELETE_EIGEN_TRUST_TABLE_START_QUERY, null, null, null);
			String sql2 = dynamicTableName;
			String sql = sql1 + SPACE + sql2;
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteEigenTrust()"
					+ "Query=" + sql);
			deleteTrust = deleteWithCompleteQuery(sql);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteEigenTrust()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteEigenTrust()"
				+ END_NAME);
		return deleteTrust;
	}

	@Override
	public boolean dropEigenTrustTable(String dynamicName) {
		boolean dropEigenTrust = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "dropEigenTrustTable()"
				+ START_NAME);
		try {
			dropEigenTrust = dropTable(DROP_EIGEN_TRUST_TABLE_START_QUERY, dynamicName);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "dropEigenTrustTable()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "dropEigenTrustTable()" + END_NAME);
		return dropEigenTrust;
	}

	@Override
	public boolean insertEigenTrust(String dynamicTableName, double trustLevel) {
		boolean insertTrust = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "insertEigenTrust()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					INSERT_EIGEN_TRUST_TABLE_START_QUERY, null, null, null);
			String sql2 = sqlProperties.getMessage(
					INSERT_EIGEN_TRUST_TABLE_END_QUERY, null, null, null);
			String sqlQuery = sql1 + SPACE + dynamicTableName + sql2;
			System.out.println("Query=" + sqlQuery);
			insertTrust = insertBasedOnQuery(sqlQuery,
					createEigenTrustMap(trustLevel));
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "insertEigenTrust()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "insertEigenTrust()"
				+ END_NAME);
		return insertTrust;
	}

	@Override
	public double retriveEigenTrust(String dynamicTableName) {
		double trustLevel = 0;
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveEigenTrust()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					RETRIVE_EIGEN_TRUST_TABLE_START_QUERY, null, null, null);
			String sqlQuery = sql1 + SPACE + dynamicTableName;
			System.out.println("Query=" + sqlQuery);
			trustLevel = queryForDOubleUsingQuery(sqlQuery);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "retriveEigenTrust()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveEigenTrust()"
				+ END_NAME);
		return trustLevel;
	}

	@Override
	public boolean updateEigenTrust(String dynamicTableName, double trustLevel) {
		boolean updateTrust = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "updateEigenTrust()"
				+ START_NAME);
		try {
			updateTrust = updateDynamicQuery(UPDATE_EIGEN_TRUST_TABLE_START_QUERY,
					dynamicTableName, UPDATE_EIGEN_TRUST_TABLE_END_QUERY,
					createEigenTrustMap(trustLevel));
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "updateEigenTrust()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "updateEigenTrust()"
				+ END_NAME);
		return updateTrust;
	}

	private Map<String, Object> createEigenTrustMap(double trustLevel) {
		Map<String, Object> trustMap = new HashMap<String, Object>();
		trustMap.put(TRUST, trustLevel);
		return trustMap;
	}

}
