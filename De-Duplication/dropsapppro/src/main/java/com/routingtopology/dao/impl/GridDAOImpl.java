package com.routingtopology.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.routingtopology.dao.inter.GridDAOIF;
import com.routingtopology.exception.RoutingException;
import com.routingtopology.value.TopologyInfoValue;

/**
 * This is the DAO class used for grid topology updation,retrival,creation and
 * deletion
 * 
 */
@Repository
public class GridDAOImpl extends RoutingDaoImpl implements GridDAOIF {

	@Override
	public boolean deleteGridTopology() {
		System.out
				.println("Class-->GridDAOImpl:Method-->deleteGridTopology() Start");

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_GRIDTOPOLOGY_QUERY);
		} catch (Exception e) {
			System.out
					.println("Class-->GridDAOImpl:Method-->deleteGridTopology() Exception"
							+ e.getMessage());
		}
		System.out
				.println("Class-->GridDAOImpl:Method-->deleteGridTopology() End");
		return deleteFlag;
	}

	@Override
	public boolean insertGridTopology(List<TopologyInfoValue> topologyInfoValue)
			throws RoutingException {
		System.out
				.println("Class--->GridDAOImpl:Method--->insertGridTopology() Start");

		boolean insertLinearTopology = false;
		try {
			insertLinearTopology = insertTopologyWithTrust(topologyInfoValue,
					INSERT_GRIDTOPOLOGY_QUERY);
		} catch (Exception e) {
			System.out
					.println("Class--->GridDAOImpl:Method--->insertGridTopology() Exception"
							+ e.getMessage());
		}
		System.out
				.println("Class--->GridDAOImpl:Method--->insertGridTopology() End");
		return insertLinearTopology;
	}

	@Override
	public List<TopologyInfoValue> retriveGridTopology()
			throws RoutingException {
		// TODO Auto-generated method stub
		System.out
				.println("Class--->GridDAOImpl:Method-->retriveGridTopology() Start");
		List<TopologyInfoValue> topologyInfoValueList = null;
		try {
			topologyInfoValueList = retriveTopologyWithTrust(RETRIVE_GRIDTOPOLOGY_QUERY);

		} catch (DataAccessException dae) {
			throw new RoutingException(dae.getMessage());
		} catch (Exception e) {
			System.out
					.println("Class--->GridDAOImpl:Method-->retriveGridTopology() Exception"
							+ e.getMessage());
		}
		System.out
				.println("Class--->GridDAOImpl:Method-->retriveGridTopology() End");
		return topologyInfoValueList;

	}

	@Override
	public boolean updateGridTopology(List<TopologyInfoValue> topologyInfoValue) {
		// TODO Auto-generated method stub
		System.out
				.println("Class-->GridDAOImpl:Method-->updateGridTopology() Start");
		
		boolean updationFlag = false;
		try {
			if(topologyInfoValue!=null &&topologyInfoValue.size()>0)
			{
				for (TopologyInfoValue topInfoValue : topologyInfoValue) {
				Map<String, Object> map = createTopologyMapWithTrust(topInfoValue);
				update(UPDATE_GRIDTOPOLOGY_QUERY, map);
				updationFlag = true;
				}
			}

		} catch (Exception e) {
			System.out
					.println("Class-->GridDAOImpl:Method-->updateGridTopology() Exception-->"
							+ e.getMessage());
		}
		System.out
				.println("Class-->GridDAOImpl:Method-->updateGridTopology() End");

		return updationFlag;

	}

	@Override
	public int retriveGridTopologyCount() {
		System.out.println("Class-->GridDAOImpl:Method-->"
				+ "retriveGridTopologyCount()" + "Start");
		int noOfRecords = 0;
		try {
			noOfRecords = queryForInt(RETRIVE_GRIDTOPOLOGY_COUNT);
		} catch (Exception e) {
			System.out.println("Class-->GridDAOImpl:Method-->"
					+ "retriveGridTopologyCount()-->Exception"
					+ e.getMessage());
		}
		System.out.println("Class-->GridDAOImpl:Method-->"
				+ "retriveGridTopologyCount()-->End");
		return noOfRecords;
	}

}
