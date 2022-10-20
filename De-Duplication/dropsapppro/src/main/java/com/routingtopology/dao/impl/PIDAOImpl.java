package com.routingtopology.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.routingtopology.constants.TopologyConstantsIF;
import com.routingtopology.dao.inter.PIDAOIF;
import com.routingtopology.exception.RoutingException;
import com.routingtopology.value.PIInfo;


@Repository
public class PIDAOImpl extends RoutingDaoImpl implements PIDAOIF {

	@Override
	public boolean deletePI() {
	
		System.out.println("Class-->PIDAOImpl:Method-->deleteHook() Start");

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_PI_QUERY);
		} catch (Exception e) {
			System.out
					.println("Class-->PIDAOImpl:Method-->deleteHook() Exception"
							+ e.getMessage());
		}
		System.out.println("Class-->PIDAOImpl:Method-->deleteHook() End");
		return deleteFlag;
		
	}

	@Override
	public boolean insertPI(int nodeId, double pi, int trust, double energy,int zoneId)
			throws RoutingException {
		
		if(trust<0)
		{
			trust=0;
		}
		
		System.out.println("Class--->PIDAOImpl:Method--->insertPI() Start");

		boolean insertLinearTopology = false;
		try {
			insertLinearTopology = update(INSERT_PI_QUERY, createPIMap(
					nodeId,pi,trust,energy,zoneId));
		} catch (Exception e) {
			System.out
					.println("Class--->PIDAOImpl:Method--->insertPI() Exception"
							+ e.getMessage());
		}
		System.out.println("Class--->PIDAOImpl:Method--->insertPI() End");
		return insertLinearTopology;
	}

	private Map<String, Object> createPIMap(int nodeId, double pi,
			int trust, double energy,int zoneId) {
		
		Map<String, Object> piMap = new HashMap<String, Object>();
		piMap.put(TopologyConstantsIF.PI_COL, pi);
		piMap.put(TopologyConstantsIF.NODEID_COL, nodeId);
		piMap.put(TopologyConstantsIF.TRUST_COL, trust);//purpose fully trust perp bcoz for pi calculation
		piMap.put(TopologyConstantsIF.ENERGY_COL, energy);
		piMap.put(TopologyConstantsIF.ZONEID_COL, zoneId);
		return piMap; 
		
		
	}

	@Override
	public List<PIInfo> retrivePI() throws RoutingException {
				System.out.println("Class--->GridDAOImpl:Method-->retrivePI() Start");
				List<PIInfo> piLIst = null; 
				try {
					piLIst = retrivePIInfo(PI_SELECT_QUERY);

				} catch (DataAccessException dae) {
					throw new RoutingException(dae.getMessage());
				} catch (Exception e) {
					System.out
							.println("Class--->GridDAOImpl:Method-->retrivePI() Exception"
									+ e.getMessage());
				}
				System.out.println("Class--->GridDAOImpl:Method-->retrivePI() End");
				return piLIst;
	}

	@Override
	public int retrivePICount() {
		System.out.println("Class-->PIDAOImpl:Method-->"
				+ "retrivePICount()" + "Start");
		int noOfRecords = 0;
		try {
			noOfRecords = queryForInt(RETRIVE_PI_COUNT);
		} catch (Exception e) {
			System.out
					.println("Class-->PIDAOImpl:Method-->"
							+ "retrivePICount()-->Exception"
							+ e.getMessage());
		}
		System.out.println("Class-->PIDAOImpl:Method-->"
				+ "retrivePICount()-->End");
		return noOfRecords;
	}

	@Override
	public List<Integer> retriveNodeIdsForZoneOrderByPI(int zoneId) throws RoutingException {
		
		System.out.println("Class--->GridDAOImpl:Method-->retriveNodeIdsForZoneOrderByPI() Start");
		List<Integer> piLIst = null; 
		try {
			piLIst = retriveNodeIDOrderByPIForZoneId(NODE_SELECT_QUERY_ORDER_BY_PI,creatZoneIdMap(zoneId));

		} catch (DataAccessException dae) {
			throw new RoutingException(dae.getMessage());
		} catch (Exception e) {
			System.out
					.println("Class--->GridDAOImpl:Method-->retriveNodeIdsForZoneOrderByPI() Exception"
							+ e.getMessage());
		}
		System.out.println("Class--->GridDAOImpl:Method-->retriveNodeIdsForZoneOrderByPI() End");
		return piLIst;
	}

	private Map<String, Object> creatZoneIdMap(int zoneId) {
		Map<String, Object> piMap = new HashMap<String, Object>();
		piMap.put(TopologyConstantsIF.ZONEID_COL, zoneId);
		return piMap; 
	}

}
