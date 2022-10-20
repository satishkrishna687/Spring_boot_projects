package com.routingtopology.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.routingtopology.constants.TopologyConstantsIF;
import com.routingtopology.dao.inter.TopologyDAOIF;
import com.routingtopology.exception.RoutingException;
import com.routingtopology.value.NodeCordinateValue;
import com.routingtopology.value.NodeParameters;
import com.routingtopology.value.TopologyInfoValue;

@Repository
public class TopologyDAOImpl extends RoutingDaoImpl implements TopologyDAOIF {

	@Override
	public boolean insertVerticalTopology(
			List<TopologyInfoValue> topologyInfoList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TopologyInfoValue> retriveAngularTopology() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TopologyInfoValue> retriveGridTopology() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAngularTopology(
			List<TopologyInfoValue> topologyInfoValueList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertAngularTopology(
			List<TopologyInfoValue> topologyInfoValueList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertGridTopology(List<TopologyInfoValue> topologyInfoList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateGridTopology(
			List<TopologyInfoValue> topologyInfoValueList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateVerticalTopology(
			List<TopologyInfoValue> topologyInfoList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TopologyInfoValue> retriveVerticalTopology() {
		// TODO Auto-generated method stub
		return null;
	}

}
