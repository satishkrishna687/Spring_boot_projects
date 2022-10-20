package com.routingtopology.dao.impl;

import com.routingtopology.value.TopologyTypeVO;

public interface SettingsDAOIF  {
	
	public boolean updateTopologyType(TopologyTypeVO topologyType);

	public String retrivePropertyValueForPropertyName(String topologyType); 

}
