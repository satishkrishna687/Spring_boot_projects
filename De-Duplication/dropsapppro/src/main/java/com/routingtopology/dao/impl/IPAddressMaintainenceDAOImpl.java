package com.routingtopology.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.model.IPAdressVO;
import com.routingtopology.dao.inter.IPAddressMaintainenceDAOIF;

@Repository
public class IPAddressMaintainenceDAOImpl extends RoutingDaoImpl implements IPAddressMaintainenceDAOIF {

	@Override
	public IPAdressVO getIPAddressInfo(int nodeId) {

		IPAdressVO ipAdressVO = null;
		try {

			String sql = sqlProperties.getMessage(RETRIVE_IPADRESS_FOR_NODEID_QUERY, null, null);
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("NODEID", nodeId);
			ipAdressVO = namedJdbcTemplate.queryForObject(sql, paramMap, new IPAddressMapper());
		} catch (Exception e) {
			ipAdressVO = null;
		}
		return ipAdressVO;
	}

	@Override
	public List<IPAdressVO> retriveIPAddressList() {
		String sql = sqlProperties.getMessage(RETRIVE_IPADRESS_QUERY, null, null);
		Map<String, Object> paramMap = null;
		return namedJdbcTemplate.query(sql, paramMap, new IPAddressMapper());
	}

	final class IPAddressMapper implements RowMapper<IPAdressVO> {

		@Override
		public IPAdressVO mapRow(ResultSet rs, int arg1) throws SQLException {

			IPAdressVO ipAdressVO = new IPAdressVO();

			ipAdressVO.setIpAddress(rs.getString("IPADDRESS"));
			ipAdressVO.setNodeId(rs.getInt("NODEID"));
			return ipAdressVO;
		}

	}

	@Override
	public boolean updateIPAddressVO(IPAdressVO ipAddressVO) {

		boolean topologyTypeFlag = false;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("NODEID", ipAddressVO.getNodeId());
			map.put("IPADDRESS", ipAddressVO.getIpAddress());
			update(UPDATE_IPADDRESS_QUERY, map);
			topologyTypeFlag = true;
		} catch (Exception e) {
			topologyTypeFlag = false;
		}

		return topologyTypeFlag;

	}

	@Override
	public boolean insertIPAddressVO(IPAdressVO ipAddressVO) {

		boolean topologyTypeFlag = false;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("NODEID", ipAddressVO.getNodeId());
			map.put("IPADDRESS", ipAddressVO.getIpAddress());
			update(INSERT_IPADDRESS_QUERY, map);
			topologyTypeFlag = true;
		} catch (Exception e) {
			topologyTypeFlag = false;
		}

		return topologyTypeFlag;

	}

	@Override
	public boolean removeIPAddressVO(IPAdressVO ipAdressVONew) {
		boolean value = false;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("NODEID", ipAdressVONew.getNodeId());

			update(DELETE_FROM_IPADDRESS_WHERE_NODEID, map);
			value = true;
		} catch (Exception e) {
			System.out.println("Delete exception" + e.getMessage());
		}
		return value;
	}

}
