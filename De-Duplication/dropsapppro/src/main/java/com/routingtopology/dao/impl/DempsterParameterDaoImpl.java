package com.routingtopology.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.routingtopology.dao.inter.DempsterParameterDAOIF;

@Repository
public class DempsterParameterDaoImpl extends RoutingDaoImpl implements DempsterParameterDAOIF {

	private static final String CLASS_NAME = "Class--->EigenParameterDaoImpl:";

	private static final String METHOD_NAME = "Method--->";

	private static final String START_NAME = "START";

	private static final String END_NAME = "END";

	private static final String EXCEPTION = "Exception-->";

	@Override
	public boolean createDempterTrustTable(String dynamicName) {
		boolean createEigenTrust = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "createDempterTrustTable()"
				+ START_NAME);
		try {
			createEigenTrust = createTable(CREATE_DEMPTER_EIGEN_TRUST_TABLE_START_QUERY,
					dynamicName, CREATE_DEMPTER_EIGEN_TRUST_TABLE_END_QUERY);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "createDempterTrustTable()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "createDempterTrustTable()"
				+ END_NAME);
		return createEigenTrust;
	}

	@Override
	public boolean deleteDempterTrust(String dynamicTableName) {
		boolean deleteTrust = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteDempterTrust()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					DELETE_DEMPTER_EIGEN_TRUST_TABLE_START_QUERY, null, null, null);
			String sql2 = dynamicTableName;
			String sql = sql1 + SPACE + sql2;
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteDempterTrust()"
					+ "Query=" + sql);
			deleteTrust = deleteWithCompleteQuery(sql);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "deleteDempterTrust()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "deleteDempterTrust()"
				+ END_NAME);
		return deleteTrust;
	}

	@Override
	public boolean dropDempterTrustTable(String dynamicName) {
		boolean dropEigenTrust = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "dropDempterTrustTable()"
				+ START_NAME);
		try {
			dropEigenTrust = dropTable(DROP_DEMPTER_EIGEN_TRUST_TABLE_START_QUERY, dynamicName);
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "dropDempterTrustTable()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "dropDempterTrustTable()" + END_NAME);
		return dropEigenTrust;
	}

	@Override
	public boolean insertDempterTrust(String dynamicTableName, double trustLevel) {
		boolean insertTrust = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "insertDempterTrust()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					INSERT_DEMPTER_EIGEN_TRUST_TABLE_START_QUERY, null, null, null);
			String sql2 = sqlProperties.getMessage(
					INSERT_DEMPTER_EIGEN_TRUST_TABLE_END_QUERY, null, null, null);
			String sqlQuery = sql1 + SPACE + dynamicTableName + sql2;
			System.out.println("Query=" + sqlQuery);
			insertTrust = insertBasedOnQuery(sqlQuery,
					createDempsterTrustMap(trustLevel));
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "insertDempterTrust()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "insertDempterTrust()"
				+ END_NAME);
		return insertTrust;
	}

	@Override
	public double retriveDempterTrust(String dynamicTableName) {
		double trustLevel = 0;
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveDempterTrust()"
				+ START_NAME);
		try {
			String sql1 = sqlProperties.getMessage(
					RETRIVE_DEMPTER_EIGEN_TRUST_TABLE_START_QUERY, null, null, null);
			String sqlQuery = sql1 + SPACE + dynamicTableName;
			System.out.println("Query=" + sqlQuery);
			trustLevel = queryForDOubleUsingQuery(sqlQuery);

		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "retriveDempterTrust()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "retriveDempterTrust()"
				+ END_NAME);
		return trustLevel;
	}

	@Override
	public boolean updateDempterTrust(String dynamicTableName, double trustLevel) {
		boolean updateTrust = false;
		System.out.println(CLASS_NAME + METHOD_NAME + "updateEigenTrust()"
				+ START_NAME);
		try {
			updateTrust = updateDynamicQuery(UPDATE_DEMPTER_EIGEN_TRUST_TABLE_START_QUERY,
					dynamicTableName, UPDATE_DEMPTER_EIGEN_TRUST_TABLE_END_QUERY,
					createDempsterTrustMap(trustLevel));
		} catch (Exception e) {
			System.out.println(CLASS_NAME + METHOD_NAME + "updateEigenTrust()"
					+ EXCEPTION + e.getMessage());
		}
		System.out.println(CLASS_NAME + METHOD_NAME + "updateEigenTrust()"
				+ END_NAME);
		return updateTrust;
	}

	private Map<String, Object> createDempsterTrustMap(double trustLevel) {
		Map<String, Object> trustMap = new HashMap<String, Object>();
		trustMap.put(TRUST, trustLevel);
		return trustMap;
	}

}
