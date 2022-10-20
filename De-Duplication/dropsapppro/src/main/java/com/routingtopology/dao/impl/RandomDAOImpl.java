package com.routingtopology.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.routingtopology.dao.impl.RoutingDaoImpl.NodeIdMappers;
import com.routingtopology.dao.inter.RandomDAOIF;
import com.routingtopology.exception.RoutingException;
import com.routingtopology.value.TopologyInfoValue;

@Repository
public class RandomDAOImpl extends RoutingDaoImpl implements RandomDAOIF {

	@Override
	public boolean deleteRandomTopology() {
		System.out
				.println("Class-->RandomDAOImpl:Method-->deleteRandomTopology() Start");

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_RANDOMTOPOLOGY_QUERY);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		System.out
				.println("Class-->RandomDAOImpl:Method-->deleteRandomTopology() End");

		return deleteFlag;

	}

	@Override
	public boolean insertRandomTopology(
			List<TopologyInfoValue> topologyInfoValue) throws RoutingException {

		System.out
				.println("Class--->RandomDAOImpl:Method--->insertRandomTopology()");
		boolean insertionFlag = false;
		try {
			insertionFlag = insertTopology(topologyInfoValue,
					INSERT_RANDOMTOPOLOGY_QUERY);
		} catch (DataAccessException dae) {
			throw new RoutingException(
					"Exception during insertion of random topology"
							+ dae.getMessage());
		}

		return insertionFlag;
	}

	@Override
	public List<TopologyInfoValue> retriveRandomTopology()
			throws RoutingException {

		System.out
				.println("Class--->RandomDAOImpl:Method-->retriveRandomTopology() Start");
		List<TopologyInfoValue> topologyInfoValueList = null;
		try {
			topologyInfoValueList = retriveTopology(RETRIVE_RANDOMTOPOLOGY_QUERY);

		} catch (DataAccessException dae) {
			throw new RoutingException(dae.getMessage());
		} catch (Exception e) {
			System.out
					.println("Class--->TopologyDAOImpl:Method-->retriveRandomTopology() Exception"
							+ e.getMessage());
		}
		System.out
				.println("Class--->RandomDAOImpl:Method-->retriveRandomTopology() End");
		return topologyInfoValueList;
	}

	@Override
	public boolean updateRandomTopology(
			List<TopologyInfoValue> topologyInfoValue) {
		System.out
				.println("Class-->RandomDAOImpl:Method-->updateRandomTopology() Start");
		boolean updationFlag = false;
		try {

			for (TopologyInfoValue topInfoValue : topologyInfoValue) {
				Map<String, Object> map = createTopologyMap(topInfoValue);
				update(UPDATE_RANDOMTOPOLOGY_QUERY, map);
				updationFlag = true;
			}

		} catch (Exception e) {
			System.out.println("Exception-->" + e.getMessage());
		}
		System.out
				.println("Class-->RandomDAOImpl:Method-->updateRandomTopology() End");

		return updationFlag;
	}

	@Override
	public int retriveRandomTopologyCount() {
		System.out.println("Class-->RandomDAOImpl:Method-->"
				+ "retriveRandomTopologyCount()" + "Start");
		int noOfRecords = 0;
		try {
			noOfRecords = queryForInt(RETRIVE_RANDOMTOPOLOGY_COUNT);
		} catch (Exception e) {
			System.out.println("Class-->RandomDAOImpl:Method-->"
					+ "retriveRandomTopologyCount() Exception"
					+ e.getMessage());
		}
		System.out.println("Class-->RandomDAOImpl:Method-->"
				+ "retriveRandomTopologyCount()" + "End");
		return noOfRecords;
	}

	public List<Integer> findNodesNotInvolvedInRouting(List<Integer> listDistinctForPaymentSave) {

		Map<String, Object> rowMap = new HashMap<String, Object>();
		rowMap.put("NODEIDS", listDistinctForPaymentSave);
		return namedJdbcTemplate.query("SELECT NODEID FROM RANDOMTOPOLOGY WHERE NODEID NOT IN(:NODEIDS)", rowMap,
				new NodeIdMappers());
	}
}
