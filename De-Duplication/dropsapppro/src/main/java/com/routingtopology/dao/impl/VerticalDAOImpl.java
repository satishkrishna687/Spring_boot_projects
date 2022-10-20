package com.routingtopology.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.routingtopology.dao.inter.VerticalDAOIF;
import com.routingtopology.exception.RoutingException;
import com.routingtopology.value.TopologyInfoValue;

/**
 * This is the Vertical DAO Implementation
 * 
 */
@Repository
public class VerticalDAOImpl extends RoutingDaoImpl implements VerticalDAOIF {

	@Override
	public boolean deleteVerticalTopology() {
		System.out
				.println("Class-->VerticalDAOImpl:Method-->deleteVerticalTopology() Start");

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_VERTICALTOPOLOGY_QUERY);
		} catch (Exception e) {
			System.out
					.println("Class-->VerticalDAOImpl:Method-->deleteVerticalTopology() Exception"
							+ e.getMessage());
		}
		System.out
				.println("Class-->VerticalDAOImpl:Method-->deleteVerticalTopology() End");
		return deleteFlag;

	}

	@Override
	public boolean insertVerticalTopology(
			List<TopologyInfoValue> topologyInfoValue) throws RoutingException {

		System.out
				.println("Class--->VerticalDAOImpl:Method--->insertVerticalTopology() Start");

		boolean insertLinearTopology = false;
		try {
			insertLinearTopology = insertVerticalBaseTopology(
					topologyInfoValue, INSERT_VERTICALTOPOLOGY_QUERY);
		} catch (Exception e) {
			System.out
					.println("Class--->VerticalDAOImpl:Method--->insertVerticalTopology() Exception"
							+ e.getMessage());
		}
		System.out
				.println("Class--->VerticalDAOImpl:Method--->insertVerticalTopology() End");

		return insertLinearTopology;

	}

	@Override
	public List<TopologyInfoValue> retriveVerticalTopology()
			throws RoutingException {

		// TODO Auto-generated method stub
		System.out
				.println("Class--->VerticalDAOImpl:Method-->retriveVerticalTopology() Start");
		List<TopologyInfoValue> topologyInfoValueList = null;
		try {
			topologyInfoValueList = retriveVerticalTopology(RETRIVE_VERTICALTOPOLOGY_QUERY);

		} catch (DataAccessException dae) {
			throw new RoutingException(dae.getMessage());
		} catch (Exception e) {
			System.out
					.println("Class--->VerticalDAOImpl:Method-->retriveVerticalTopology() Exception"
							+ e.getMessage());
		}
		System.out
				.println("Class--->VerticalDAOImpl:Method-->retriveVerticalTopology() End");
		return topologyInfoValueList;
	}

	@Override
	public boolean updateVerticalTopology(
			List<TopologyInfoValue> topologyInfoValue) {
		System.out
				.println("Class-->VerticalDAOImpl:Method-->updateVerticalTopology() Start");
		boolean updationFlag = false;
		try {

			for (TopologyInfoValue topInfoValue : topologyInfoValue) {
				Map<String, Object> map = createTopologyMapWithVertical(topInfoValue);
				update(UPDATE_VERTICALTOPOLOGY_QUERY, map);
				updationFlag = true;
			}

		} catch (Exception e) {
			System.out
					.println("Class-->VerticalDAOImpl:Method-->updateVerticalTopology() Exception-->"
							+ e.getMessage());
		}
		System.out
				.println("Class-->VerticalDAOImpl:Method-->updateVerticalTopology() End");

		return updationFlag;

	}

	@Override
	public int retriveVerticalTopologyCount() {
		System.out.println("Class-->VerticalDAOImpl:Method-->"
				+ "retriveVerticalTopologyCount()" + "Start");
		int noOfRecords = 0;
		try {
			noOfRecords = queryForInt(RETRIVE_VERTICALTOPOLOGY_COUNT);
		} catch (Exception e) {
			System.out.println("Class-->VerticalDAOImpl:Method-->"
					+ "retriveVerticalTopologyCount()" + " Exception"
					+ e.getMessage());
		}
		System.out.println("Class-->VerticalDAOImpl:Method-->"
				+ "retriveVerticalTopologyCount()" + "End");
		return noOfRecords;
	}

}
