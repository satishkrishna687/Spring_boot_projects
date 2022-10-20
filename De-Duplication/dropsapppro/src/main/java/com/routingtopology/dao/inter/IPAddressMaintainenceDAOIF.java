package com.routingtopology.dao.inter;

import java.util.List;

import com.model.IPAdressVO;

public interface IPAddressMaintainenceDAOIF {
	
	public IPAdressVO getIPAddressInfo(int nodeId);
	
	public List<IPAdressVO> retriveIPAddressList();

	boolean updateIPAddressVO(IPAdressVO ipAddressVO);

	boolean insertIPAddressVO(IPAdressVO ipAddressVO);

	public boolean removeIPAddressVO(IPAdressVO ipAdressVONew); 
	
	

}
