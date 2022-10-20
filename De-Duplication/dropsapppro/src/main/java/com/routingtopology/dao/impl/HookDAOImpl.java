package com.routingtopology.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.routingtopology.constants.TopologyConstantsIF;
import com.routingtopology.dao.inter.HookDAOIF;
import com.routingtopology.exception.RoutingException;
import com.routingtopology.value.EnergyInfo;
import com.routingtopology.value.HookInfo;
import com.routingtopology.value.TopologyInfoValue;

@Repository
public class HookDAOImpl extends RoutingDaoImpl implements HookDAOIF {

	@Override
	public boolean deleteHook() {
		System.out.println("Class-->GridDAOImpl:Method-->deleteHook() Start");

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_HOOK_QUERY);
		} catch (Exception e) {
			System.out
					.println("Class-->GridDAOImpl:Method-->deleteHook() Exception"
							+ e.getMessage());
		}
		System.out.println("Class-->GridDAOImpl:Method-->deleteHook() End");
		return deleteFlag;
	}

	@Override
	public boolean insertHook(int nodeId, double energy)
			throws RoutingException {
		System.out.println("Class--->GridDAOImpl:Method--->insertHook() Start");

		boolean insertLinearTopology = false;
		try {
			insertLinearTopology = update(HOOK_INSERT_QUERY, createHookMap(
					nodeId, energy));
		} catch (Exception e) {
			System.out
					.println("Class--->GridDAOImpl:Method--->insertHook() Exception"
							+ e.getMessage());
		}
		System.out.println("Class--->GridDAOImpl:Method--->insertHook() End");
		return insertLinearTopology;
	}

	private Map<String, Object> createHookMap(int nodeId, double energy) {
		Map<String, Object> topologyMap = new HashMap<String, Object>();
		topologyMap.put(TopologyConstantsIF.HOOKID_COL, nodeId);
		topologyMap.put(TopologyConstantsIF.HOOKVALUE_COL, nodeId);
		return topologyMap;
	}

	@Override
	public List<HookInfo> retriveHook() throws RoutingException {
		// TODO Auto-generated method stub
		System.out.println("Class--->GridDAOImpl:Method-->retriveHook() Start");
		List<HookInfo> hookList = null;
		try {
			hookList = retriveHookInfo(HOOK_SELECT_QUERY);

		} catch (DataAccessException dae) {
			throw new RoutingException(dae.getMessage());
		} catch (Exception e) {
			System.out
					.println("Class--->GridDAOImpl:Method-->retriveHook() Exception"
							+ e.getMessage());
		}
		System.out.println("Class--->GridDAOImpl:Method-->retriveHook() End");
		return hookList;
	}

	@Override
	public int retriveHookCount() {
		System.out.println("Class-->HookDAOImpl:Method-->"
				+ "retriveHookCount()" + "Start");
		int noOfRecords = 0;
		try {
			noOfRecords = queryForInt(RETRIVE_HOOK_COUNT);
		} catch (Exception e) {
			System.out
					.println("Class-->HookDAOImpl:Method-->"
							+ "retriveHookCount()-->Exception"
							+ e.getMessage());
		}
		System.out.println("Class-->HookDAOImpl:Method-->"
				+ "retriveHookCount()-->End");
		return noOfRecords;
	}

}
