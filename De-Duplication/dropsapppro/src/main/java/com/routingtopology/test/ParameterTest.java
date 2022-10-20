package com.routingtopology.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.routingtopology.constants.ParametersTypeIF;
import com.routingtopology.constants.TopologyTypesIF;
import com.routingtopology.service.inter.ParametersServiceIF;
import com.routingtopology.service.inter.TopologyRoutingServiceIF;
import com.routingtopology.value.TopologyInfoValue;


public class ParameterTest {
	
	/**
	 * @param s
	 */
	public static void main(String s[])
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(
		"/topology-routing.xml");
		ParametersServiceIF parametersServiceIF= (ParametersServiceIF) context
		.getBean("parameterService");
		
		TopologyInfoValue topologyInfoValue = new TopologyInfoValue();
		
		parametersServiceIF.createParameterTables(ParametersTypeIF.ENERGY,TopologyTypesIF.RANDOM_TOPOLOGY);
		parametersServiceIF.insertAllParameters(ParametersTypeIF.ENERGY, TopologyTypesIF.RANDOM_TOPOLOGY);
		
	}

}
