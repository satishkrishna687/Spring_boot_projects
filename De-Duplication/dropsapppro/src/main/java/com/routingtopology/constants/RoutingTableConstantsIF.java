package com.routingtopology.constants;

/**
 * This is the routing table interface constants
 * 
 */
public interface RoutingTableConstantsIF {

	/**
	 * This is delete from clause
	 */
	public static final String DELETE_FROM = "DELETE_FROM";

	/**
	 * This is delete where clause zone id not equal
	 */
	public static final String WHERE_UNWANTED_ZONEID_DELETE_CLAUSE = "WHERE_UNWANTED_ZONEID_DELETE_CLAUSE";

	/**
	 * This is delete where clause zone id not equal and zone leader
	 */
	public static final String WHERE_UNWANTED_ZONEID_ZONELEADER_DELETE_CLAUSE = "WHERE_UNWANTED_ZONEID_ZONELEADER_DELETE_CLAUSE";

	/**
	 * This is routing table start of zone ledaer
	 */
	public static final String RETRIVE_RT_ZONELEADER_START = "RETRIVE_RT_ZONELEADER_START";

	/**
	 * This is the Queries used for square and angle based topology for deleting
	 * the routing table
	 */

	public static final String WHERE_CLAUSE_NODEID = "WHERE_CLAUSE_NODEID";

	/**
	 * This is the start of query using zoneid Start
	 */
	public static final String RETRIVE_RT_ZONEID_START = "RETRIVE_RT_ZONEID_START";

	/**
	 * This is the vertical topology routing table
	 */
	public static final String UPDATE_VERTICAL_RTTABLE_END_QUERY = "UPDATE_VERTICAL_RTTABLE_END_QUERY";

	/**
	 * This is the vertical topology routing table
	 */
	public static final String INSERT_VERTICAL_RTTABLE_END_QUERY = "INSERT_VERTICAL_RTTABLE_END_QUERY";

	/**
	 * This is routing table extra constants
	 */
	public static final String SPACE = " ";

	/**
	 * This is the qury for vertical based end query
	 */

	public static final String CREATE_VERTICALBASED_RTTABLE_END_QUERY = "CREATE_VERTICALBASED_RTTABLE_END_QUERY";

	/**
	 * This is routing table create start query
	 */
	public static final String CREATE_RTTABLE_START_QUERY = "CREATE_RTTABLE_START_QUERY";

	/**
	 * The query belongs to create end query
	 */
	public static final String CREATE_RTTABLE_END_QUERY = "CREATE_RTTABLE_END_QUERY";

	/**
	 * This is the drop routing table
	 */
	public static final String DROP_RTTABLE_START_QUERY = "DROP_RTTABLE_START_QUERY";

	/**
	 * This is insertion Query for Normal routing table
	 */
	public static final String INSERT_RTTABLE_START_QUERY = "INSERT_RTTABLE_START_QUERY";

	/**
	 * This is insertion Query for Normal routing table end query
	 */
	public static final String INSERT_RTTABLE_END_QUERY = "INSERT_RTTABLE_END_QUERY";

	/**
	 * This is update Query for Normal routing table
	 */
	public static final String UPDATE_RTTABLE_START_QUERY = "UPDATE_RTTABLE_START_QUERY";

	/**
	 * This is insertion Query for Normal routing table end query
	 */
	public static final String UPDATE_RTTABLE_END_QUERY = "UPDATE_RTTABLE_END_QUERY";

	/**
	 * This is Delete Query for Normal routing table
	 */
	public static final String DELETE_RTTABLE_START_QUERY = "DELETE_RTTABLE_START_QUERY";

	/**
	 * This is the select query for vertical routing table
	 */
	public static final String SELECT_VERTICAL_RTTABLE_START_QUERY = "SELECT_VERTICAL_RTTABLE_START_QUERY";

	/**
	 * This is Query to retrive data for Normal routing table
	 */
	public static final String SELECT_RTTABLE_START_QUERY = "SELECT_RTTABLE_START_QUERY";

	/**
	 *This is the zone based routing table end query
	 */
	public static final String CREATE_ZONEBASEDTABLE_END_QUERY = "CREATE_ZONEBASEDTABLE_END_QUERY";

	/**
	 *This is the zone based routing table insert query
	 */
	public static final String INSERT_ZONEBASED_RTTABLE_END_QUERY = "INSERT_ZONEBASED_RTTABLE_END_QUERY";

	/**
	 *This is the zone based routing table update end query
	 */
	public static final String UPDATE_ZONEBASED_RTTABLE_END_QUERY = "UPDATE_ZONEBASED_RTTABLE_END_QUERY";

	/**
	 *This is the zone based Select Query
	 */
	public static final String SELECT_ZONEBASED_RTTABLE_START_QUERY = "SELECT_ZONEBASED_RTTABLE_START_QUERY";

	/**
	 *This is the create angle based routing table
	 */
	public static final String CREATE_ANGLEBASED_RTTABLE_END_QUERY = "CREATE_ANGLEBASED_RTTABLE_END_QUERY";

	/**
	 *This is the insert angle based routing table
	 */
	public static final String INSERT_ANGLEBASED_RTTABLE_END_QUERY = "INSERT_ANGLEBASED_RTTABLE_END_QUERY";

	/**
	 *This is the update angle based routing table
	 */
	public static final String UPDATE_ANGLEBASED_RTTABLE_END_QUERY = "UPDATE_ANGLEBASED_RTTABLE_END_QUERY";

	/**
	 *This is the select angle based routing table
	 */
	public static final String SELECT_ANGLEBASED_RTTABLE_START_QUERY = "SELECT_ANGLEBASED_RTTABLE_START_QUERY";

	/**
	 * This is count retrival query for random topology
	 */
	public static final String RETRIVE_RANDOMTOPOLOGY_COUNT = "RETRIVE_RANDOMTOPOLOGY_COUNT";

	/**
	 * This is count retrival query for grid topology
	 */
	public static final String RETRIVE_GRIDTOPOLOGY_COUNT = "RETRIVE_GRIDTOPOLOGY_COUNT";

	/**
	 * This is count retrival query for linear topology
	 */
	public static final String RETRIVE_LINEARTOPOLOGY_COUNT = "RETRIVE_LINEARTOPOLOGY_COUNT";

	/**
	 * This is count retrival query for vertical topology
	 */
	public static final String RETRIVE_VERTICALTOPOLOGY_COUNT = "RETRIVE_VERTICALTOPOLOGY_COUNT";

	/**
	 * This is count retrival query for square zone topology
	 */
	public static final String RETRIVE_SQUARETOPOLOGY_COUNT = "RETRIVE_SQUARETOPOLOGY_COUNT";

	/**
	 * This is count retrival query for angular zone topology
	 */
	public static final String RETRIVE_ANGULARTOPOLOGY_COUNT = "RETRIVE_ANGULARTOPOLOGY_COUNT";

	/**
	 * This is the Node id
	 */
	public static final String NODEID = "NODEID";

	/**
	 * This is the Zone Id
	 */
	public static final String ZONEID = "ZONEID";

	/**
	 * This is Zone Leader Column
	 */
	public static final String ZONELEADER = "ZONELEADER";
	
	
	/**
	 * 
	 */
	public static final String WHERE_CLAUSE_ZONEID_ZONE_LEADER="WHERE_CLAUSE_ZONEID_ZONE_LEADER";
	
	/**
	 * 
	 */
	public static final String RETRIVE_RT_NODEID_START="RETRIVE_RT_NODEID_START";
	
	
	/**
	 * 
	 */
	public static final String SELECT_ZONEID_NODEID_QUERY="SELECT_ZONEID_NODEID_QUERY";
	
	/**
	 * This is zone id of the node
	 */
	public static final String WHERE_NOTEQUAL_ZONEID_EQUAL_ZONELEADER="WHERE_NOTEQUAL_ZONEID_EQUAL_ZONELEADER";
	
	/**
	 * This is selected node id
	 */
	public static final String SELECT_NODEID_QUERY="SELECT_NODEID_QUERY";
	
	/**
	 * This is the node id for the where clause
	 */
	public static final String WHERE_NOTEQUAL_NODEID="WHERE_NOTEQUAL_NODEID";
	
	
	/**
	 *  * 
	 */
	
	public static final String WHERE_NOTEQUAL_NODEID_EQUAL_ZONEID="WHERE_NOTEQUAL_NODEID_EQUAL_ZONEID";
	
	/**
	 * This is the where clause related to  
	 */
	public static final String WHERE_NOTEQUAL_NODEID_EQUAL_TO_ZONEID="WHERE_NOTEQUAL_NODEID_EQUAL_TO_ZONEID";
	
	/**
	 * This is the query for selecting distance
	 */
	public static final String SELECT_DISTANCE_QUERY="SELECT_DISTANCE_QUERY";
	
	/**
	 * This is the query for where clause
	 */
	public static final String WHERE_NODEID_EQUALTO="WHERE_NODEID_EQUALTO";
	
	
	/**
	 * This is the value of the Alpha Parameter used in the  ALpha DAO 
	 */
	public static final String ALPHA="ALPHA";
}
