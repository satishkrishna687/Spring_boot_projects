package com.routingtopology.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.routingtopology.constants.TopologyTypesIF;
import com.routingtopology.service.inter.RoutingTableServiceIF;
import com.routingtopology.service.inter.TopologyRoutingServiceIF;

public class RoutingTableTest {

	/**
	 * @param s
	 */
	public static void main(String[] s) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/topology-routing.xml");
		RoutingTableServiceIF topologyServiceIF = (RoutingTableServiceIF) context
				.getBean("routingTableService");

		topologyServiceIF.dropTable(TopologyTypesIF.LINEAR_TOPOLOGY);

	}

}
