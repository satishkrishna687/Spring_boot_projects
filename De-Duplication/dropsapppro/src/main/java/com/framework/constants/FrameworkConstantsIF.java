package com.framework.constants;

public interface FrameworkConstantsIF {

	/**
	 * 
	 */
	public static final String SOURCENODE_EMPTY = "Source Node Cannot Be Empty";
	/**
	 * 
	 */
	public static final String DESTNODE_EMPTY = "Destination Node Cannot Be Empty";
	/**
	 * 
	 */
	public static final String COVERAGEAREA_EMPTY = "Coverage Area Cannot Be Empty";
	/**
	 * 
	 */
	public static final String NEIGBOURS_EMPTY = "Neigbour List Cannot be Empty";
	/**
	 * 
	 */
	public static final String TTL_INVALID = "Invalid value for TTL";

	/**
	 * 
	 */
	public static final String NONEIGBOURS_FOUND = "Neigbours not found at this time";

	/**
	 * 
	 */
	public static final String ROUTE_EMPTY_SNSAME = "Source node and Destination node are same";

	/**
	 * 
	 */
	public static final String TRANSPOWER_EMPTY = "Transmission power cannot be empty";

	/**
	 * 
	 */
	public static final String ENVFACTOR_EMPTY = "Environment Factor cannot be empty";

	/**
	 * 
	 */
	public static final String CURRENT_EMPTY = "Current cannot be empty";

	/**
	 * 
	 */
	public static final String VOLTAGE_EMPTY = "Voltage cannot be empty";

	/**
	 * 
	 */
	public static final String PACKTRANSTIME_EMPTY = "Packet Transmit Time is empty";

	/**
	 * This is the Threshold Battery empty Message
	 */
	public static final String THBATTERY_EMPTY = "THRESHOLD BATTERY CANNOT BE EMPTY";
	/**
	 * This is a message generated from Frame Work if the Data Rate is Empty
	 */
	public static final String DATARATE_EMPTY = "DATA RATE CANNOT BE EMPTY";

	/**
	 * This is the Message to be Displayed if the Energy Required For
	 * Transmission is Empty
	 */
	public static final String ENERGYFORTX_EMPTY = "Energy Required For Transmission is Empty";

	/**
	 * This is the Message to be Displayed if the Energy Required For
	 * Amplification is Empty
	 */
	public static final String ENERGYFORAMP_EMPTY = "Energy Required For Amplification is Empty";
	/**
	 * This is the Message to be Displayed if the Attunuation Factor is Empty
	 */
	public static final String ATTFACTOR_EMPTY = "Attunuation Factor Cannot Be Empty";
	/**
	 * This is the Message to be Displayed if the TTL is Empty
	 */
	public static final String TTL_EMPTY = "TTL Cannot be Empty";

	/**
	 * This is the Message to be Displayed if the Topology Does not Exist
	 */
	public static final String TOPOLOGY_NOT_EXISTS = "There Seems to be No Topology. Please Create a Topology First and then Reexecute";

	/**
	 * This is the Message to be Displayed if there are no dead nodes in the
	 * network to be recovered
	 */
	public static final String NO_DEAD_NODES = "There are no Dead Nodes in the Network to be Recovered";

	/**
	 * This is the Message to be Displayed if Battery Power Could not be Updated
	 * for the Nodes
	 */
	public static final String COULD_NOT_UPDATE_POWER = "Could Not Update the Battery Power of the Nodes in the Network";

	/**
	 * This is the Message to be Displayed if Dead Nodes were Recovered
	 * Sucessfully
	 */
	public static final String DEAD_NODES_RECOVERED = "Dead Nodes have Been Recovered Sucessfully";
	/**
	 * This is the message for if inserting the number of hops for Algorithm 1
	 * has Failed
	 */
	public static final String COULD_NOT_INSERT_HOPS_FOR_ALGO1 = "Could not Insert the Number of Hops For Algorithm 1 into the Performance Tables";

	/**
	 * This is the message for if inserting the number of hops for Algorithm 2
	 * has Failed
	 */
	public static final String COULD_NOT_INSERT_HOPS_FOR_ALGO2 = "Could not Insert the Number of Hops For Algorithm 2 into the Performance Tables";

	/**
	 * This is the message for if inserting the Power Consumption Measure for
	 * Algorithm 1 has Failed
	 */
	public static final String COULD_NOT_INSERT_POWER_CONSUMED_FOR_ALGO1 = "Could not Insert the Power Consumption for Algorithm 1 into the Performance Tables";

	/**
	 * This is the message for if inserting the Power Consumption Measure for
	 * Algorithm 2 has Failed
	 */
	public static final String COULD_NOT_INSERT_POWER_CONSUMED_FOR_ALGO2 = "Could not Insert the Power Consumption for Algorithm 2 into the Performance Tables";

	/**
	 * This is the message for if inserting the Energy Consumption Measure for
	 * Algorithm 2 has Failed
	 */
	public static final String COULD_NOT_INSERT_ENERGY_CONSUMED_FOR_ALGO1 = "Could not Insert the Energy Consumption for Algorithm 1 into the Performance Tables";

	/**
	 * This is the message for if inserting the Energy Consumption Measure for
	 * Algorithm 2 has Failed
	 */
	public static final String COULD_NOT_INSERT_ENERGY_CONSUMED_FOR_ALGO2 = "Could not Insert the Energy Consumption for Algorithm 2 into the Performance Tables";

	/**
	 * This is the message for if inserting the No of ALive Nodes for Algorithm
	 * 1 has Failed
	 */
	public static final String COULD_NOT_INSERT_ALIVENODES_FOR_ALGO1 = "Could not Insert the Number of ALive Nodes for Algorithm 1 into the Performance Tables";

	/**
	 * This is the message for if inserting the No of ALive Nodes for Algorithm
	 * 2 has Failed
	 */
	public static final String COULD_NOT_INSERT_ALIVENODES_CONSUMED_FOR_ALGO2 = "Could not Insert the Number of ALive Nodes for Algorithm 2 into the Performance Tables";

	/**
	 * This is the message for if inserting the No of Dead Nodes for Algorithm 1
	 * has Failed
	 */
	public static final String COULD_NOT_INSERT_DEADNODES_FOR_ALGO1 = "Could not Insert the Number of Dead Nodes for Algorithm 1 into the Performance Tables";

	/**
	 * This is the message for if inserting the No of Dead Nodes for Algorithm 2
	 * has Failed
	 */
	public static final String COULD_NOT_INSERT_DEADNODES_FOR_ALGO2 = "Could not Insert the Number of Dead Nodes for Algorithm 2 into the Performance Tables";

	/**
	 * This is the message for if inserting the No of Dead Nodes for Algorithm 1
	 * has Failed
	 */
	public static final String COULD_NOT_INSERT_PACKETLOSS_FOR_ALGO1 = "Could not Insert the Number of Packet Loss for Algorithm 1 into the Performance Tables";

	/**
	 * This is the message for if inserting the No of Dead Nodes for Algorithm 2
	 * has Failed
	 */
	public static final String COULD_NOT_INSERT_PACKETLOSS_FOR_ALGO2 = "Could not Insert the Number of Packet Loss for Algorithm 2 into the Performance Tables";
	/**
	 * This is the energy required for Transmission
	 */
	public static final String ENERGYTX_INVALID = "Energy Required for Transmission is Invalid";

	/**
	 * 
	 */
	public static final String ENERGYAMP_INVALID = "Energy Required for Amplification is Invalid";

	/**
	 * 
	 */
	public static final String ATTFACTOR_INVALID = "Attunuation Factor is Invalid";
	public static final String ENERGYTX_ERROR = "Energy Required for Transmission Cannot be Empty";
	public static final String NO_OF_ITERATIONS_EMPTY = "Number of Iterations Cannot be Empty";

}
