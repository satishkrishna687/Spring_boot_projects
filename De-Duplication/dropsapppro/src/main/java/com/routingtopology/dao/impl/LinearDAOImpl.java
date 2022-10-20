package com.routingtopology.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.routingtopology.dao.inter.LinearDAOIF;
import com.routingtopology.exception.RoutingException;
import com.routingtopology.value.TopologyInfoValue;

/**
 * Linear DAO is a DAO layer used for deletion,retrieval,insertion and updation
 * of linear topology
 * 
 */
@Repository
public class LinearDAOImpl extends RoutingDaoImpl implements LinearDAOIF {

	@Override
	public boolean deleteLinearTopology() {
		System.out.println("Class-->LinearDAOImpl:Method-->deleteLinearTopology() Start");

		boolean deleteFlag = false;
		try {
			deleteFlag = delete(DELETE_LINEARTOPOLOGY_QUERY);
		} catch (Exception e) {
			System.out.println("Class-->LinearDAOImpl:Method-->deleteLinearTopology() Exception" + e.getMessage());
		}
		System.out.println("Class-->LinearDAOImpl:Method-->deleteLinearTopology() End");
		return deleteFlag;
	}

	@Override
	public boolean insertLinearTopology(List<TopologyInfoValue> topologyInfo) {

		System.out.println("Class--->LinearDAOImpl:Method--->insertLinearTopology() Start");

		boolean insertLinearTopology = false;
		try {
			insertLinearTopology = insertTopology(topologyInfo, INSERT_LINEARTOPOLOGY_QUERY);
		} catch (Exception e) {
			System.out.println("Class--->LinearDAOImpl:Method--->insertLinearTopology() Exception" + e.getMessage());
		}
		System.out.println("Class--->LinearDAOImpl:Method--->insertLinearTopology() End");

		return insertLinearTopology;
	}

	@Override
	public List<TopologyInfoValue> retriveLinearTopology() throws RoutingException {
		// TODO Auto-generated method stub
		System.out.println("Class--->LinearDAOImpl:Method-->retriveRandomTopology() Start");
		List<TopologyInfoValue> topologyInfoValueList = null;
		try {
			topologyInfoValueList = retriveTopology(RETRIVE_LINEARTOPOLOGY_QUERY);

		} catch (DataAccessException dae) {
			throw new RoutingException(dae.getMessage());
		} catch (Exception e) {
			System.out.println("Class--->LinearDAOImpl:Method-->retriveRandomTopology() Exception" + e.getMessage());
		}
		System.out.println("Class--->LinearDAOImpl:Method-->retriveRandomTopology() End");
		return topologyInfoValueList;
	}

	@Override
	public boolean updateLinearTopology(List<TopologyInfoValue> topologyInfo) {
		System.out.println("Class-->LinearDAOImpl:Method-->updateLinearTopology() Start");
		boolean updationFlag = false;
		try {

			for (TopologyInfoValue topInfoValue : topologyInfo) {
				Map<String, Object> map = createTopologyMap(topInfoValue);
				update(UPDATE_LINEARTOPOLOGY_QUERY, map);
				updationFlag = true;
			}

		} catch (Exception e) {
			System.out.println("Class-->LinearDAOImpl:Method-->updateLinearTopology() Exception-->" + e.getMessage());
		}
		System.out.println("Class-->LinearDAOImpl:Method-->updateLinearTopology() End");

		return updationFlag;
	}

	@Override
	public int retriveLinearTopologyCount() {
		System.out.println("Class-->LinearDAOImpl:Method-->" + "retriveLinearTopologyCount()" + "Start");
		int noOfRecords = 0;
		try {
			noOfRecords = queryForInt(RETRIVE_LINEARTOPOLOGY_COUNT);
		} catch (Exception e) {
			System.out.println(
					"Class-->LinearDAOImpl:Method-->" + "retriveLinearTopologyCount()-->Exception" + e.getMessage());
		}
		System.out.println("Class-->LinearDAOImpl:Method-->" + "retriveLinearTopologyCount()-->End");
		return noOfRecords;
	}

	public List<Integer> findNodesNotInvolvedInRouting(List<Integer> listDistinctForPaymentSave) {

		Map<String, Object> rowMap = new HashMap<String, Object>();
		rowMap.put("NODEIDS", listDistinctForPaymentSave);
		return namedJdbcTemplate.query("SELECT NODEID FROM LINEARTOPOLOGY WHERE NODEID NOT IN(:NODEIDS)", rowMap,
				new NodeIdMappers());
	}



}
