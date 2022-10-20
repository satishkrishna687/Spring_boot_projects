package com.routingtopology.constants;

/**
 * This is the Topology information
 * 
 */
public interface TopologyConstantsIF extends RoutingTableConstantsIF {

	/**
	 * This is the zone leader information
	 */
	public static final String UPDATE_ZONELEADER_FORNODEID_ANGULARTOPOLOGY = "UPDATE_ZONELEADER_FORNODEID_ANGULARTOPOLOGY";

	/**
	 * 
	 */
	public static final String RETRIVE_NODEIDS_WHO_ARE_ZONE_LEADERS_ANGULAR_TOPOLOGY = "RETRIVE_NODEIDS_WHO_ARE_ZONE_LEADERS_ANGULAR_TOPOLOGY";

	/**
	 * This is angular information
	 */
	public static final String RETRIVE_ZONEID_ANGULAR_TOPOLOGY = "RETRIVE_ZONEID_ANGULAR_TOPOLOGY";

	/**
	 * This is the Angular Position
	 */
	public static final String RETRIVE_ANGULARPOSWITHBS_START = "RETRIVE_ANGULARPOSWITHBS_START";

	/**
	 * This is used find the list of nodes which are not closer to obs
	 */
	public static final String WHERE_NOTEQUAL_NODEID_NOTEQUAL_ZONELEADER_NOTEQUAL_CLOSERTOOBS_EQUAL_ZONEID = "WHERE_NOTEQUAL_NODEID_NOTEQUAL_ZONELEADER_NOTEQUAL_CLOSERTOOBS_EQUAL_ZONEID";

	/**
	 * This is used to create table
	 */
	public static final String CREATE_SIGNAL_TABLE_START_QUERY = "CREATE_SIGNAL_TABLE_START_QUERY";

	/**
	 * This is used for create table end query
	 */
	public static final String CREATE_SIGNAL_TABLE_END_QUERY = "CREATE_SIGNAL_TABLE_START_QUERY";

	/**
	 * 
	 */
	public static final String DROP_SIGNAL_TABLE_START_QUERY = "DROP_SIGNAL_TABLE_START_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_SIGNAL_TABLE_START_QUERY = "RETRIVE_SIGNAL_TABLE_START_QUERY";

	/**
	 * 
	 */
	public static final String UPDATE_SIGNAL_TABLE_START_QUERY = "UPDATE_SIGNAL_TABLE_START_QUERY";

	/**
	 * 
	 */
	public static final String UPDATE_SIGNAL_TABLE_END_QUERY = "UPDATE_SIGNAL_TABLE_END_QUERY";

	/**
	 * 
	 */
	public static final String DELETE_SIGNAL_TABLE_START_QUERY = "DELETE_SIGNAL_TABLE_START_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_SIGNAL_TABLE_START_QUERY = "INSERT_SIGNAL_TABLE_START_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_SIGNAL_TABLE_END_QUERY = "INSERT_SIGNAL_TABLE_END_QUERY";

	/**
	 * This is signal strength
	 */
	public static final String SIGNAL_STRENGTH = "SIGNALSTRENGTH";
	/**
	 * This is the query used for order by PI Value
	 */
	public static final String NODE_SELECT_QUERY_ORDER_BY_PI = "NODE_SELECT_QUERY_ORDER_BY_PI";

	/**
	 * This is the column for retriving the PI Count
	 */
	public static final String RETRIVE_PI_COUNT = "RETRIVE_PI_COUNT";

	/**
	 * This is the query to select pi query
	 */
	public static final String PI_SELECT_QUERY = "PI_SELECT_QUERY";

	/**
	 * This is insert pi query
	 */
	public static final String INSERT_PI_QUERY = "INSERT_PI_QUERY";

	/**
	 * This is query used to clear PI table
	 */
	public static final String DELETE_PI_QUERY = "DELETE_PI_QUERY";

	/**
	 * This is the query used to retrive the zone leaders
	 */

	public static final String RETRIVE_NODEIDS_WHO_ARE_ZONE_LEADERS_SQUARE_TOPOLOGY = "RETRIVE_NODEIDS_WHO_ARE_ZONE_LEADERS_SQUARE_TOPOLOGY";

	/**
	 * This is Retrive Hook Count query
	 */
	public static final String RETRIVE_HOOK_COUNT = "RETRIVE_HOOK_COUNT";

	/**
	 * Query for Delete Hook
	 */
	public static final String DELETE_HOOK_QUERY = "DELETE_HOOK_QUERY";

	/**
	 * Query for Insert Hook
	 */
	public static final String HOOK_INSERT_QUERY = "HOOK_INSERT_QUERY";

	/**
	 * Query for Select Hook
	 */
	public static final String HOOK_SELECT_QUERY = "HOOK_SELECT_QUERY";

	/**
	 * Query to update the zone leader for a square topology
	 */
	public static final String UPDATE_ZONELEADER_FORNODEID_SQUARETOPOLOGY = "UPDATE_ZONELEADER_FORNODEID_SQUARETOPOLOGY";

	/**
	 * Query to retrive the node ids and its positions of square topology
	 */
	public static final String RETRIVE_NODEIDS_DETAILS_FOR_ZONEID_SQUARETOPOLOGY = "RETRIVE_NODEIDS_DETAILS_FOR_ZONEID_SQUARETOPOLOGY";

	/**
	 * Query to retrive the zone ids of square topology
	 */
	public static final String RETRIVE_ZONEIDSQUARETOPOLOGY = "RETRIVE_ZONEIDSQUARETOPOLOGY";

	/**
	 * Query to retrive the square topology
	 */
	public static final String RETRIVE_SQUARETOPOLOGY_QUERY = "RETRIVE_SQUARETOPOLOGY_QUERY";

	/**
	 * Query to update the square topology
	 */
	public static final String UPDATE_SQUAREZONETOPOLOGY_QUERY = "UPDATE_SQUAREZONETOPOLOGY_QUERY";

	/**
	 * Query to insert the square topology
	 */
	public static final String INSERT_SQUAREZONETOPOLOGY_QUERY = "INSERT_SQUAREZONETOPOLOGY_QUERY";

	/**
	 * Query to delete square topology
	 */
	public static final String DELETE_SQUAREZONETOPOLOGY_QUERY = "DELETE_SQUAREZONETOPOLOGY";

	/**
	 * Query for retriving nodeids for for zoneid
	 */
	public static final String RETRIVE_NODEIDS_FOR_ZONEID_ANGULARTOPOLOGY_QUERY = "RETRIVE_NODEIDS_FOR_ZONEID_ANGULARTOPOLOGY";

	/**
	 * Query for updating zone leader for node id
	 */
	public static final String UPDATE_ZONELEADER_FORNODEID_ANGULARTOPOLOGY_QUERY = "UPDATE_ZONELEADER_FORNODEID_ANGULARTOPOLOGY";

	/**
	 * Close to which value
	 */

	public static final int CLOSENESS1 = 1;

	/**
	 * 
	 */
	public static final int CLOSENESS2 = 2;

	/**
	 * 
	 */
	public static final int CLOSENESS3 = 3;

	/**
	 * This is the delete query for the angular topology
	 */

	public static final String DELETE_ANGULARTOPOLOGY_QUERY = "DELETE_ANGULARTOPOLOGY_QUERY";

	/**
	 * Query to insert the random topology
	 */
	public static final String INSERT_RANDOMTOPOLOGY_QUERY = "INSERT_RANDOMTOPOLOGY_QUERY";

	/**
	 * Query to retrive the random topology
	 */
	public static final String RETRIVE_RANDOMTOPOLOGY_QUERY = "RETRIVE_RANDOMTOPOLOGY_QUERY";

	/**
	 * Query to update the random topology
	 */
	public static final String UPDATE_RANDOMTOPOLOGY_QUERY = "UPDATE_RANDOMTOPOLOGY_QUERY";

	/**
	 * Query to delete the random topology
	 */
	public static final String DELETE_RANDOMTOPOLOGY_QUERY = "DELETE_RANDOMTOPOLOGY_QUERY";

	/**
	 * Query to delete the Linear Topology
	 */
	public static final String DELETE_LINEARTOPOLOGY_QUERY = "DELETE_LINEARTOPOLOGY_QUERY";

	/**
	 * Query to insert the grid topology
	 */
	public static final String INSERT_GRIDTOPOLOGY_QUERY = "INSERT_GRIDTOPOLOGY_QUERY";

	/**
	 * Query to retrive the grid topology
	 */
	public static final String RETRIVE_GRIDTOPOLOGY_QUERY = "RETRIVE_GRIDTOPOLOGY_QUERY";

	/**
	 * Query to delete the Grid Topology
	 */
	public static final String DELETE_GRIDTOPOLOGY_QUERY = "DELETE_GRIDTOPOLOGY_QUERY";

	/**
	 * Query for updating the grid topology
	 */
	public static final String UPDATE_GRIDTOPOLOGY_QUERY = "UPDATE_GRIDTOPOLOGY_QUERY";

	/**
	 * Query for inserting the Linear topology
	 */
	public static final String INSERT_LINEARTOPOLOGY_QUERY = "INSERT_LINEARTOPOLOGY_QUERY";

	/**
	 * Query for Updating the Linear topology
	 */
	public static final String UPDATE_LINEARTOPOLOGY_QUERY = "UPDATE_LINEARTOPOLOGY_QUERY";

	/**
	 * Query for Retrving the Linear topology
	 */
	public static final String RETRIVE_LINEARTOPOLOGY_QUERY = "RETRIVE_LINEARTOPOLOGY_QUERY";

	/**
	 * Query for Inserting the Vertical topology
	 */
	public static final String INSERT_VERTICALTOPOLOGY_QUERY = "INSERT_VERTICALTOPOLOGY_QUERY";

	/**
	 * Query to Update the Vertical topology
	 */
	public static final String UPDATE_VERTICALTOPOLOGY_QUERY = "UPDATE_VERTICALTOPOLOGY_QUERY";

	/**
	 * Query to Retrive the Vertical topology
	 */
	public static final String RETRIVE_VERTICALTOPOLOGY_QUERY = "RETRIVE_VERTICALTOPOLOGY_QUERY";

	/**
	 * Query to delete Vertical topology
	 */
	public static final String DELETE_VERTICALTOPOLOGY_QUERY = "DELETE_VERTICALTOPOLOGY_QUERY";

	/**
	 * Query to Insert the Angular topology
	 */
	public static final String INSERT_ANGULARTOPOLOGY_QUERY = "INSERT_ANGULARTOPOLOGY_QUERY";

	/**
	 * Query to Update the Angular topology
	 */
	public static final String UPDATE_ANGULARTOPOLOGY_QUERY = "UPDATE_ANGULARTOPOLOGY_QUERY";

	/**
	 * Query to Retrive the Angular topology
	 */
	public static final String RETRIVE_ANGULARTOPOLOGY_QUERY = "RETRIVE_ANGULARTOPOLOGY_QUERY";
	
	// These are the Keys Used in the SQL Property Files for insertion of number of Dead Nodes in the network

	/**
	 * This Query is used insert the Number of Dead Nodes in the Network
	 */
	public static final String INSERT_DEADNODES_ITERATION_ALGO1_QUERY = "INSERT_DEADNODES_ITERATION_ALGO1_QUERY";
	
	/**
	 * This Query is used insert the Number of Dead Nodes in the Network
	 */
	public static final String INSERT_DEADNODES_ITERATION_ALGO2_QUERY = "INSERT_DEADNODES_ITERATION_ALGO2_QUERY";
	
	/**
	 * This Query is used insert the Number of Dead Nodes in the Network
	 */
	public static final String INSERT_DEADNODES_ITERATION_ALGO3_QUERY = "INSERT_DEADNODES_ITERATION_ALGO3_QUERY";
	
	/**
	 * This Query is used insert the Number of Dead Nodes in the Network
	 */
	public static final String INSERT_DEADNODES_ITERATION_ALGO4_QUERY = "INSERT_DEADNODES_ITERATION_ALGO4_QUERY";
	
	/**
	 * This Query is used insert the Number of Dead Nodes in the Network
	 */
	public static final String INSERT_DEADNODES_ITERATION_ALGO5_QUERY = "INSERT_DEADNODES_ITERATION_ALGO5_QUERY";
	
	/**
	 * This Query is used insert the Number of Dead Nodes in the Network
	 */
	public static final String INSERT_DEADNODES_ITERATION_ALGO6_QUERY = "INSERT_DEADNODES_ITERATION_ALGO6_QUERY";
	
	
	// These are the Keys Used in the SQL Property Files for insertion of number of Alive Nodes in the network
	
	/**
	 * This Query is used insert the Number of Alive Nodes in the Network for Algorithm 1
	 */
	public static final String INSERT_ALIVENODES_ITERATION_ALGO1_QUERY = "INSERT_ALIVENODES_ITERATION_ALGO1_QUERY";
		
	/**
	 * This Query is used insert the Number of Alive Nodes in the Network for Algorithm 2
	 */
	public static final String INSERT_ALIVENODES_ITERATION_ALGO2_QUERY = "INSERT_ALIVENODES_ITERATION_ALGO2_QUERY";
	
	/**
	 * This Query is used insert the Number of Alive Nodes in the Network for Algorithm 3
	 */
	public static final String INSERT_ALIVENODES_ITERATION_ALGO3_QUERY = "INSERT_ALIVENODES_ITERATION_ALGO3_QUERY";
	
	/**
	 * This Query is used insert the Number of Alive Nodes in the Network for Algorithm 4
	 */
	public static final String INSERT_ALIVENODES_ITERATION_ALGO4_QUERY = "INSERT_ALIVENODES_ITERATION_ALGO4_QUERY";
	
	/**
	 * This Query is used insert the Number of Alive Nodes in the Network for Algorithm 5
	 */
	public static final String INSERT_ALIVENODES_ITERATION_ALGO5_QUERY = "INSERT_ALIVENODES_ITERATION_ALGO5_QUERY";
	
	
	/**
	 * This Query is used insert the Number of Alive Nodes in the Network for Algorithm 6
	 */
	public static final String INSERT_ALIVENODES_ITERATION_ALGO6_QUERY = "INSERT_ALIVENODES_ITERATION_ALGO6_QUERY";
	
	// This is for insertion Packet Loss for the Algorithms
	
	
	/**
	 * This Query is used insert the Packet Loss in the Network for Algorithm 1
	 */
	public static final String INSERT_PACKETLOSS_ITERATION_ALGO1_QUERY = "INSERT_PACKETLOSS_ITERATION_ALGO1_QUERY";
	
	/**
	 * This Query is used insert the Packet Loss in the Network for Algorithm 1
	 */
	public static final String INSERT_PACKETLOSS_ITERATION_ALGO2_QUERY = "INSERT_PACKETLOSS_ITERATION_ALGO2_QUERY";
	
	
	/**
	 * This Query is used insert the Packet Loss in the Network for Algorithm 1
	 */
	public static final String INSERT_PACKETLOSS_ITERATION_ALGO3_QUERY = "INSERT_PACKETLOSS_ITERATION_ALGO3_QUERY";
	
	
	/**
	 * This Query is used insert the Packet Loss in the Network for Algorithm 1
	 */
	public static final String INSERT_PACKETLOSS_ITERATION_ALGO4_QUERY = "INSERT_PACKETLOSS_ITERATION_ALGO4_QUERY";
	
	
	/**
	 * This Query is used insert the Packet Loss in the Network for Algorithm 1
	 */
	public static final String INSERT_PACKETLOSS_ITERATION_ALGO5_QUERY = "INSERT_PACKETLOSS_ITERATION_ALGO5_QUERY";
	
	
	/**
	 * This Query is used insert the Packet Loss in the Network for Algorithm 1
	 */
	public static final String INSERT_PACKETLOSS_ITERATION_ALGO6_QUERY = "INSERT_PACKETLOSS_ITERATION_ALGO6_QUERY";
	
	
	//These are the Keys used in the SQL Property File for retrival of the Dead Nodes in the Network
	
	/**
	 * This Query is used to Retrive the Dead Nodes in the Network for Algorithm 1
	 */
	public static final String RETRIVE_DEADNODES_ITERATION_ALGO1_QUERY = "RETRIVE_DEADNODES_ITERATION_ALGO1_QUERY";
	
	/**
	 * This Query is used to Retrive the Dead Nodes in the Network for Algorithm 2
	 */
	public static final String RETRIVE_DEADNODES_ITERATION_ALGO2_QUERY = "RETRIVE_DEADNODES_ITERATION_ALGO2_QUERY";
	
	
	/**
	 * This Query is used to Retrive the Dead Nodes in the Network for Algorithm 3
	 */
	public static final String RETRIVE_DEADNODES_ITERATION_ALGO3_QUERY = "RETRIVE_DEADNODES_ITERATION_ALGO3_QUERY";
	
	
	/**
	 * This Query is used to Retrive the Dead Nodes in the Network for Algorithm 4
	 */
	public static final String RETRIVE_DEADNODES_ITERATION_ALGO4_QUERY = "RETRIVE_DEADNODES_ITERATION_ALGO4_QUERY";
	
	/**
	 * This Query is used to Retrive the Dead Nodes in the Network for Algorithm 5
	 */
	public static final String RETRIVE_DEADNODES_ITERATION_ALGO5_QUERY = "RETRIVE_DEADNODES_ITERATION_ALGO5_QUERY";
	
	
	/**
	 * This Query is used to Retrive the Dead Nodes in the Network for Algorithm 6
	 */
	public static final String RETRIVE_DEADNODES_ITERATION_ALGO6_QUERY = "RETRIVE_DEADNODES_ITERATION_ALGO6_QUERY";
	
	//These are the Keys used in the SQL proeprty File to retrive the Number of Alive Nodes 
	

	/**
	 * This Query is used to Retrive the Alive Nodes in the Network for Algorithm 1
	 */
	public static final String RETRIVE_ALIVENODES_ITERATION_ALGO1_QUERY = "RETRIVE_ALIVENODES_ITERATION_ALGO1_QUERY";
	
	/**
	 * This Query is used to Retrive the Alive Nodes in the Network for Algorithm 2
	 */
	public static final String RETRIVE_ALIVENODES_ITERATION_ALGO2_QUERY = "RETRIVE_ALIVENODES_ITERATION_ALGO2_QUERY";
	
	/**
	 * This Query is used to Retrive the Alive Nodes in the Network for Algorithm 3
	 */
	public static final String RETRIVE_ALIVENODES_ITERATION_ALGO3_QUERY = "RETRIVE_ALIVENODES_ITERATION_ALGO3_QUERY";
	
	/**
	 * This Query is used to Retrive the Alive Nodes in the Network for Algorithm 4
	 */
	public static final String RETRIVE_ALIVENODES_ITERATION_ALGO4_QUERY = "RETRIVE_ALIVENODES_ITERATION_ALGO4_QUERY";
	
	/**
	 * This Query is used to Retrive the Alive Nodes in the Network for Algorithm 5
	 */
	public static final String RETRIVE_ALIVENODES_ITERATION_ALGO5_QUERY = "RETRIVE_ALIVENODES_ITERATION_ALGO5_QUERY";
	
	/**
	 * This Query is used to Retrive the Alive Nodes in the Network for Algorithm 6
	 */
	public static final String RETRIVE_ALIVENODES_ITERATION_ALGO6_QUERY = "RETRIVE_ALIVENODES_ITERATION_ALGO6_QUERY";
	
	//These are the Keys used in the SQL proeprty File to retrive the Packet Loss
	
	/**
	 * This Query is used to Retrive the Packet Loss in the Network for Algorithm 1
	 */
	public static final String RETRIVE_PACKETLOSS_ITERATION_ALGO1_QUERY = "RETRIVE_PACKETLOSS_ITERATION_ALGO1_QUERY";
	
	/**
	 * This Query is used to Retrive the Packet Loss in the Network for Algorithm 2
	 */
	public static final String RETRIVE_PACKETLOSS_ITERATION_ALGO2_QUERY = "RETRIVE_PACKETLOSS_ITERATION_ALGO2_QUERY";
	
	
	/**
	 * This Query is used to Retrive the Packet Loss in the Network for Algorithm 3
	 */
	public static final String RETRIVE_PACKETLOSS_ITERATION_ALGO3_QUERY = "RETRIVE_PACKETLOSS_ITERATION_ALGO3_QUERY";
	
	/**
	 * This Query is used to Retrive the Packet Loss in the Network for Algorithm 4
	 */
	public static final String RETRIVE_PACKETLOSS_ITERATION_ALGO4_QUERY = "RETRIVE_PACKETLOSS_ITERATION_ALGO4_QUERY";
	
	/**
	 * This Query is used to Retrive the Packet Loss in the Network for Algorithm 5
	 */
	public static final String RETRIVE_PACKETLOSS_ITERATION_ALGO5_QUERY = "RETRIVE_PACKETLOSS_ITERATION_ALGO5_QUERY";
	
	
	/**
	 * This Query is used to Retrive the Packet Loss in the Network for Algorithm 6
	 */
	public static final String RETRIVE_PACKETLOSS_ITERATION_ALGO6_QUERY = "RETRIVE_PACKETLOSS_ITERATION_ALGO6_QUERY";
	
	
	// These are the Keys use for insertion of Energy Consumption for each of the algorithms

	/**
	 * 
	 */
	public static final String INSERT_ENERGY_ITERATION_ALGO1_QUERY = "INSERT_ENERGY_ITERATION_ALGO1_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_ENERGY_ITERATION_ALGO2_QUERY = "INSERT_ENERGY_ITERATION_ALGO2_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_ENERGY_ITERATION_ALGO3_QUERY = "INSERT_ENERGY_ITERATION_ALGO3_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_ENERGY_ITERATION_ALGO4_QUERY = "INSERT_ENERGY_ITERATION_ALGO4_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_ENERGY_ITERATION_ALGO5_QUERY = "INSERT_ENERGY_ITERATION_ALGO5_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_ENERGY_ITERATION_ALGO6_QUERY = "INSERT_ENERGY_ITERATION_ALGO6_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_HOPS_ITERATION_ALGO1_QUERY = "INSERT_HOPS_ITERATION_ALGO1_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_HOPS_ITERATION_ALGO2_QUERY = "INSERT_HOPS_ITERATION_ALGO2_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_HOPS_ITERATION_ALGO3_QUERY = "INSERT_HOPS_ITERATION_ALGO3_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_HOPS_ITERATION_ALGO4_QUERY = "INSERT_HOPS_ITERATION_ALGO4_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_HOPS_ITERATION_ALGO5_QUERY = "INSERT_HOPS_ITERATION_ALGO5_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_HOPS_ITERATION_ALGO6_QUERY = "INSERT_HOPS_ITERATION_ALGO6_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_POWER_ITERATION_ALGO1_QUERY = "INSERT_POWER_ITERATION_ALGO1_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_POWER_ITERATION_ALGO2_QUERY = "INSERT_POWER_ITERATION_ALGO2_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_POWER_ITERATION_ALGO3_QUERY = "INSERT_POWER_ITERATION_ALGO3_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_POWER_ITERATION_ALGO4_QUERY = "INSERT_POWER_ITERATION_ALGO4_QUERY";

	/** 
	 */
	public static final String INSERT_POWER_ITERATION_ALGO5_QUERY = "INSERT_POWER_ITERATION_ALGO5_QUERY";

	/** 
	 */
	public static final String INSERT_POWER_ITERATION_ALGO6_QUERY = "INSERT_POWER_ITERATION_ALGO6_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_TIME_ITERATION_ALGO1_QUERY = "INSERT_TIME_ITERATION_ALGO1_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_TIME_ITERATION_ALGO2_QUERY = "INSERT_TIME_ITERATION_ALGO2_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_TIME_ITERATION_ALGO3_QUERY = "INSERT_TIME_ITERATION_ALGO3_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_TIME_ITERATION_ALGO4_QUERY = "INSERT_TIME_ITERATION_ALGO4_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_TIME_ITERATION_ALGO5_QUERY = "INSERT_TIME_ITERATION_ALGO5_QUERY";

	/**
	 * 
	 */
	public static final String INSERT_TIME_ITERATION_ALGO6_QUERY = "INSERT_TIME_ITERATION_ALGO6_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_ENERGY_ITERATION_ALGO1_QUERY = "RETRIVE_ENERGY_ITERATION_ALGO1_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_ENERGY_ITERATION_ALGO2_QUERY = "RETRIVE_ENERGY_ITERATION_ALGO2_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_ENERGY_ITERATION_ALGO3_QUERY = "RETRIVE_ENERGY_ITERATION_ALGO3_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_ENERGY_ITERATION_ALGO4_QUERY = "RETRIVE_ENERGY_ITERATION_ALGO4_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_ENERGY_ITERATION_ALGO5_QUERY = "RETRIVE_ENERGY_ITERATION_ALGO5_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_ENERGY_ITERATION_ALGO6_QUERY = "RETRIVE_ENERGY_ITERATION_ALGO6_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_HOPS_ITERATION_ALGO1_QUERY = "RETRIVE_HOPS_ITERATION_ALGO1_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_HOPS_ITERATION_ALGO2_QUERY = "RETRIVE_HOPS_ITERATION_ALGO2_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_HOPS_ITERATION_ALGO3_QUERY = "RETRIVE_HOPS_ITERATION_ALGO3_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_HOPS_ITERATION_ALGO4_QUERY = "RETRIVE_HOPS_ITERATION_ALGO4_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_HOPS_ITERATION_ALGO5_QUERY = "RETRIVE_HOPS_ITERATION_ALGO5_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_HOPS_ITERATION_ALGO6_QUERY = "RETRIVE_HOPS_ITERATION_ALGO6_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_POWER_ITERATION_ALGO1_QUERY = "RETRIVE_POWER_ITERATION_ALGO1_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_POWER_ITERATION_ALGO2_QUERY = "RETRIVE_POWER_ITERATION_ALGO2_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_POWER_ITERATION_ALGO3_QUERY = "RETRIVE_POWER_ITERATION_ALGO3_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_POWER_ITERATION_ALGO4_QUERY = "RETRIVE_POWER_ITERATION_ALGO4_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_POWER_ITERATION_ALGO5_QUERY = "RETRIVE_POWER_ITERATION_ALGO5_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_POWER_ITERATION_ALGO6_QUERY = "RETRIVE_POWER_ITERATION_ALGO6_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_TIME_ITERATION_ALGO1_QUERY = "RETRIVE_TIME_ITERATION_ALGO1_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_TIME_ITERATION_ALGO2_QUERY = "RETRIVE_TIME_ITERATION_ALGO2_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_TIME_ITERATION_ALGO3_QUERY = "RETRIVE_TIME_ITERATION_ALGO3_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_TIME_ITERATION_ALGO4_QUERY = "RETRIVE_TIME_ITERATION_ALGO4_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_TIME_ITERATION_ALGO5_QUERY = "RETRIVE_TIME_ITERATION_ALGO5_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_TIME_ITERATION_ALGO6_QUERY = "RETRIVE_TIME_ITERATION_ALGO6_QUERY";

	/**
	 * This is for trust iteration 1
	 */
	public static final String INSERT_TRUST_ITERATION_ALGO1_QUERY = "INSERT_TRUST_ITERATION_ALGO1_QUERY";

	/**
	 * This is for trust iteration 2
	 */
	public static final String INSERT_TRUST_ITERATION_ALGO2_QUERY = "INSERT_TRUST_ITERATION_ALGO2_QUERY";

	/**
	 * This is for trust iteration 3
	 */
	public static final String INSERT_TRUST_ITERATION_ALGO3_QUERY = "INSERT_TRUST_ITERATION_ALGO3_QUERY";

	/**
	 * This is for trust iteration 4
	 */
	public static final String INSERT_TRUST_ITERATION_ALGO4_QUERY = "INSERT_TRUST_ITERATION_ALGO4_QUERY";

	/**
	 * This is for trust iteration 5
	 */
	public static final String INSERT_TRUST_ITERATION_ALGO5_QUERY = "INSERT_TRUST_ITERATION_ALGO5_QUERY";

	/**
	 * This is for trust iteration 6
	 */
	public static final String INSERT_TRUST_ITERATION_ALGO6_QUERY = "INSERT_TRUST_ITERATION_ALGO6_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_TRUST_ITERATION_ALGO1_QUERY = "RETRIVE_TRUST_ITERATION_ALGO1_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_TRUST_ITERATION_ALGO2_QUERY = "RETRIVE_TRUST_ITERATION_ALGO2_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_TRUST_ITERATION_ALGO3_QUERY = "RETRIVE_TRUST_ITERATION_ALGO3_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_TRUST_ITERATION_ALGO4_QUERY = "RETRIVE_TRUST_ITERATION_ALGO4_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_TRUST_ITERATION_ALGO5_QUERY = "RETRIVE_TRUST_ITERATION_ALGO5_QUERY";

	/**
	 * 
	 */
	public static final String RETRIVE_TRUST_ITERATION_ALGO6_QUERY = "RETRIVE_TRUST_ITERATION_ALGO6_QUERY";

	/**
	 * Alive Nodes Column of the topology
	 */
	public static final String PACKETLOSS_COL = "PACKETLOSS";
	
	
	
	/**
	 * Alive Nodes Column of the topology
	 */
	public static final String ALIVENODES_COL = "ALIVENODES";
	
	
	/**
	 * Dead Nodes Column of the topology
	 */
	public static final String DEADNODES_COL = "DEADNODES";

	/**
	 * Energy Column of the topology
	 */
	public static final String ENERGY_COL = "ENERGY";
	
	String RESIDUALENERGY_COL="RESIDUALENERGY";
	
	
	String THROUGHPUT_COL="THROUGHPUT";

	/**
	 * Time Taken Column of the topology
	 */
	public static final String TIMETAKEN_COL = "TIME";

	/**
	 * Energy Column of the topology
	 */
	public static final String POWER_COL = "POWER";

	/**
	 * Iteration no Column of the topology
	 */
	public static final String ITERATION_COL = "ITERATION";

	/**
	 * Hops Column of the topology
	 */
	public static final String ROUTINGOVERHEAD_COL = "ROUTINGOVERHEAD";
	
	/**
	 * Hops Column of the topology
	 */
	public static final String HOPS_COL = "HOPS";

	/**
	 * Power Available Column of the topology
	 */
	public static final String POWERAVAILABLE_COL = "POWERAVAILABLE";

	/**
	 * Node Id Column of the topology
	 */
	public static final String NODEID_COL = "NODEID";
	
	/**
	 * 
	 * Alpha Column for Topology
	 */
	
	public static final String ALPHA_COL="ALPHA";

	/**
	 * X-cordinate column of the topology
	 */
	public static final String XCORDINATE_COL = "XCORDINATE";

	/**
	 * Y-cordinate column of the topology
	 */
	public static final String YCORDINATE_COL = "YCORDINATE";

	/**
	 * Trust Column of topology
	 */
	public static final String TRUST_COL = "TRUSTLEVEL";

	/**
	 * Trust Column of topology
	 */
	public static final String TRUSTPERF_COL = "TRUST";

	/**
	 * Buffer Column of topology
	 */
	public static final String BUFFER_COL = "BUFFER";

	/**
	 * Network Cost Column of topology
	 */
	public static final String NETWORKCOST_COL = "NETWORKCOST";

	/**
	 * This is the Vertical Belong Column
	 */
	public static final String VERTICALBELONG_COL = "VERTICALBELONG";

	/**
	 * This is the signal strength column name
	 */
	public static final String SIGNALSTRENGTH_COL = "SIGNALSTRENGTH";

	/**
	 * This is the closer to which obstracle
	 */
	public static final String CLOSERTOOBSTRACLE_COL = "CLOSERTOOBSTRACLE";

	/**
	 * This is the zone id or not column name
	 */
	public static final String ZONEID_COL = "ZONEID";

	/**
	 * This is the column name for XCENTER
	 */
	public static final String XCENTER_COL = "XCENTER";

	/**
	 * This is the column name for YCENTER
	 */
	public static final String YCENTER_COL = "YCENTER";

	/**
	 * This is the Angular position with respect to base station column
	 */
	public static final String ANGULARPOSWITHBS_COL = "ANGULARPOSWITHBS";

	/**
	 * This is the Zone Leader Information Column
	 */
	public static final String ZONELEADER_COL = "ZONELEADER";

	/**
	 * 
	 */
	public static final String RETRIVE_ZONEIDANGULARTOPOLOGY_QUERY = "RETRIVE_ZONEIDANGULARTOPOLOGY";

	/**
	 * This is the flag used in Topology Service
	 */
	public static final int ZONELEADER_FLAG = 1;

	/**
	 * This is the Distance Number Column
	 */
	public static final String DISTANCE_COL = "DISTANCE";

	/**
	 * This is select from
	 */

	public static final String SELECT_FROM_QUERY = "SELECT_FROM_QUERY";

	/**
	 * This is Where Distance clause
	 */
	public static final String WHERE_DISTANCE_CLAUSE_QUERY = "WHERE_DISTANCE_CLAUSE_QUERY";

	/**
	 * This is the HOOK column
	 */
	public static final String HOOKID_COL = "HOOKID";

	/**
	 * This is Hook Value Column
	 */
	public static final String HOOKVALUE_COL = "HOOKVALUE";

	/**
	 * This is to indicate the node is not a zone leader
	 */
	public static final int NOT_ZONELEADER = 0;

	/**
	 * This is used to store the PI Value
	 */
	public static final String PI_COL = "PI";
	
	
	static final String LIFETIME_COL = "LIFETIME";

	/**
	 * this is the query
	 */
	public static final String CLOSERTOOBSTRACLE = "CLOSERTOOBSTRACLE";
	
	/**
	 * 
	 */
	public static final String RETRIVE_ZONELEADER_FOR_ZONEID_SQUARE_TOPOLOGY_SQL="RETRIVE_ZONELEADER_FOR_ZONEID_SQUARE_TOPOLOGY_SQL";
	
	/**
	 * 
	 */
	public static final String RETRIVE_SQUARETOPOLOGY_FOR_NODEID_SQL="RETRIVE_SQUARETOPOLOGY_FOR_NODEID_QUERY";
	
	public static final String INSERT_ROUTINGOVERHEAD_ITERATION_ALGO1_QUERY = "INSERT_ROUTINGOVERHEAD_ITERATION_ALGO1_QUERY";
	
	public static final String INSERT_ROUTINGOVERHEAD_ITERATION_ALGO2_QUERY = "INSERT_ROUTINGOVERHEAD_ITERATION_ALGO2_QUERY";
	
	public static final String INSERT_ROUTINGOVERHEAD_ITERATION_ALGO3_QUERY = "INSERT_ROUTINGOVERHEAD_ITERATION_ALGO3_QUERY";
	
	public static final String RETRIVE_ROUTINGOVERHEAD_ITERATION_ALGO1_QUERY="RETRIVE_ROUTINGOVERHEAD_ITERATION_ALGO1_QUERY";
	
	public static final String RETRIVE_ROUTINGOVERHEAD_ITERATION_ALGO2_QUERY="RETRIVE_ROUTINGOVERHEAD_ITERATION_ALGO2_QUERY";
	
	public static final String RETRIVE_ROUTINGOVERHEAD_ITERATION_ALGO3_QUERY="RETRIVE_ROUTINGOVERHEAD_ITERATION_ALGO3_QUERY";
	
	String INSERT_LIFETIME_ITERATION_ALGO1_QUERY="INSERT_LIFETIME_ITERATION_ALGO1_QUERY";
	String INSERT_LIFETIME_ITERATION_ALGO2_QUERY="INSERT_LIFETIME_ITERATION_ALGO2_QUERY";
	String INSERT_LIFETIME_ITERATION_ALGO3_QUERY="INSERT_LIFETIME_ITERATION_ALGO3_QUERY";
	String INSERT_LIFETIME_ITERATION_ALGO4_QUERY="INSERT_LIFETIME_ITERATION_ALGO4_QUERY";
	
	public static final String RETRIVE_LIFETIME_ITERATION_ALGO1_QUERY="RETRIVE_LIFETIME_ITERATION_ALGO1_QUERY";
	
	public static final String RETRIVE_LIFETIME_ITERATION_ALGO2_QUERY="RETRIVE_LIFETIME_ITERATION_ALGO2_QUERY";
	
	public static final String RETRIVE_LIFETIME_ITERATION_ALGO3_QUERY="RETRIVE_LIFETIME_ITERATION_ALGO3_QUERY";

	public static final String TOPOLOGY_TYPE = "TOPOLOGYTYPE";
	
	String INSERT_THROUGHPUT_ITERATION_ALGO1_QUERY="INSERT_THROUGHPUT_ITERATION_ALGO1_QUERY";
	String INSERT_THROUGHPUT_ITERATION_ALGO2_QUERY="INSERT_THROUGHPUT_ITERATION_ALGO2_QUERY";
	String INSERT_THROUGHPUT_ITERATION_ALGO3_QUERY="INSERT_THROUGHPUT_ITERATION_ALGO3_QUERY";
	
	String RETRIVE_THROUGHPUT_ITERATION_ALGO1_QUERY="RETRIVE_THROUGHPUT_ITERATION_ALGO1_QUERY";
	String RETRIVE_THROUGHPUT_ITERATION_ALGO2_QUERY="RETRIVE_THROUGHPUT_ITERATION_ALGO2_QUERY";
	String RETRIVE_THROUGHPUT_ITERATION_ALGO3_QUERY="RETRIVE_THROUGHPUT_ITERATION_ALGO3_QUERY";
	
	
	String INSERT_RESIDUALENERGY_ITERATION_ALGO1_QUERY="INSERT_RESIDUALENERGY_ITERATION_ALGO1_QUERY";
	
	String INSERT_RESIDUALENERGY_ITERATION_ALGO2_QUERY="INSERT_RESIDUALENERGY_ITERATION_ALGO2_QUERY";
	
	String INSERT_RESIDUALENERGY_ITERATION_ALGO3_QUERY="INSERT_RESIDUALENERGY_ITERATION_ALGO3_QUERY";
	
	String INSERT_RESIDUALENERGY_ITERATION_ALGO4_QUERY="INSERT_RESIDUALENERGY_ITERATION_ALGO4_QUERY";
	
	String RETRIVE_RESIDUALENERGY_ITERATION_ALGO1_QUERY="RETRIVE_RESIDUALENERGY_ITERATION_ALGO1_QUERY";
	String RETRIVE_RESIDUALENERGY_ITERATION_ALGO2_QUERY="RETRIVE_RESIDUALENERGY_ITERATION_ALGO2_QUERY";
	String RETRIVE_RESIDUALENERGY_ITERATION_ALGO3_QUERY="RETRIVE_RESIDUALENERGY_ITERATION_ALGO3_QUERY";
	
	String INSERT_ROUTINGOVERHEAD_ITERATION_ALGO4_QUERY="INSERT_ROUTINGOVERHEAD_ITERATION_ALGO4_QUERY";

	
	String UPDATE_SETTINGS_QUERY="UPDATE_SETTINGS_QUERY";

	String RETRIVE_PROPERTY_VALUE_FOR_PROPERTY_NAME_QUERY="RETRIVE_PROPERTY_VALUE_FOR_PROPERTY_NAME_QUERY";
		
	String UPDATE_IPADDRESS_QUERY="UPDATE_IPADDRESS_QUERY";
	
	String INSERT_IPADDRESS_QUERY="INSERT_IPADDRESS_QUERY";
	
	String RETRIVE_IPADRESS_QUERY="RETRIVE_IPADRESS_QUERY";
	
	String RETRIVE_IPADRESS_FOR_NODEID_QUERY="RETRIVE_IPADRESS_FOR_NODEID_QUERY";

	String DELETE_FROM_IPADDRESS_WHERE_NODEID="DELETE_FROM_IPADDRESS_WHERE_NODEID";
	
	
	/* Delete SQL */
	
	String DELETE_FROM_TIME_ALGO1="DELETE_FROM_TIME_ALGO1";
	
	String DELETE_FROM_TIME_ALGO2="DELETE_FROM_TIME_ALGO2";
	
	String DELETE_FROM_TIME_ALGO3="DELETE_FROM_TIME_ALGO3";
	
	String DELETE_FROM_HOPS_ALGO1="DELETE_FROM_HOPS_ALGO1";
	
	String DELETE_FROM_HOPS_ALGO2="DELETE_FROM_HOPS_ALGO2";
	
	String DELETE_FROM_HOPS_ALGO3="DELETE_FROM_HOPS_ALGO3";
	
	
	String DELETE_FROM_ENERGY_ALGO1="DELETE_FROM_ENERGY_ALGO1";
	
	String DELETE_FROM_ENERGY_ALGO2="DELETE_FROM_ENERGY_ALGO2";
	
	String DELETE_FROM_ENERGY_ALGO3="DELETE_FROM_ENERGY_ALGO3";
	
	String DELETE_FROM_RESIDUALENERGY_ALGO1="DELETE_FROM_RESIDUALENERGY_ALGO1";
	
	String DELETE_FROM_RESIDUALENERGY_ALGO2="DELETE_FROM_RESIDUALENERGY_ALGO2";
	
	String DELETE_FROM_RESIDUALENERGY_ALGO3="DELETE_FROM_RESIDUALENERGY_ALGO3";
	
	String DELETE_FROM_THROUGHPUT_ALGO3="DELETE_FROM_THROUGHPUT_ALGO3";
	
	String DELETE_FROM_THROUGHPUT_ALGO2="DELETE_FROM_THROUGHPUT_ALGO2";
	
	String DELETE_FROM_THROUGHPUT_ALGO1="DELETE_FROM_THROUGHPUT_ALGO1";
	
	String DELETE_FROM_ALIVENODES_ALGO3="DELETE_FROM_ALIVENODES_ALGO3";
	
	String DELETE_FROM_ALIVENODES_ALGO2="DELETE_FROM_ALIVENODES_ALGO2";
	
	String DELETE_FROM_ALIVENODES_ALGO1="DELETE_FROM_ALIVENODES_ALGO1";
	
	String DELETE_FROM_DEADNODES_ALGO1="DELETE_FROM_DEADNODES_ALGO1";
	
	String DELETE_FROM_DEADNODES_ALGO2="DELETE_FROM_DEADNODES_ALGO2";
	
	String DELETE_FROM_DEADNODES_ALGO3="DELETE_FROM_DEADNODES_ALGO3";
	
	String DELETE_FROM_ROUTINGOVERHEAD_ALGO1="DELETE_FROM_ROUTINGOVERHEAD_ALGO1";
	
	String DELETE_FROM_ROUTINGOVERHEAD_ALGO2="DELETE_FROM_ROUTINGOVERHEAD_ALGO2";
	
	String DELETE_FROM_ROUTINGOVERHEAD_ALGO3="DELETE_FROM_ROUTINGOVERHEAD_ALGO3";

	String DELETE_FROM_LIFETIME_ALGO1="DELETE_FROM_LIFETIME_ALGO1";
	
	String DELETE_FROM_LIFETIME_ALGO2="DELETE_FROM_LIFETIME_ALGO2";
	
	String DELETE_FROM_LIFETIME_ALGO3="DELETE_FROM_LIFETIME_ALGO3";
	
	String INSERT_THROUGHPUT_ITERATION_ALGO4_QUERY="INSERT_THROUGHPUT_ITERATION_ALGO4_QUERY";
	
	String RETRIVE_LIFETIME_ITERATION_ALGO4_QUERY="RETRIVE_LIFETIME_ITERATION_ALGO4_QUERY";
	
	String RETRIVE_RESIDUALENERGY_ITERATION_ALGO4_QUERY="RETRIVE_RESIDUALENERGY_ITERATION_ALGO4_QUERY";
	
	String RETRIVE_ROUTINGOVERHEAD_ITERATION_ALGO4_QUERY="RETRIVE_ROUTINGOVERHEAD_ITERATION_ALGO4_QUERY";
	
	String RETRIVE_THROUGHPUT_ITERATION_ALGO4_QUERY="RETRIVE_THROUGHPUT_ITERATION_ALGO4_QUERY";
	
}

