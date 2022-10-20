package com.constants;

/**
 * This is the interface used for server side messages on PEEBR
 * 
 */
public interface EEDRServerMessages {

	/**
	 * 
	 */
	public static final String TOPOLOGY_SUCESS = "Topology Sucessfully Created";
	/**
	 * 
	 */
	public static final String ROUTINGTABLECREATION_SUCESS = "Routing Assignment Sucessfully Created";
	/**
	 * 
	 */
	public static final String ROUTINGTABLECREATION_FAILURE = "Routing Assignment Creation Failed";
	/**
	 * 
	 */
	public static final String ROUTINGTABLE_INSERT_SUCESS = "Routing Assignment Insertion Sucessful";

	/**
	 * 
	 */
	public static final String ROUTINGTABLE_INSERT_FAILURE = "Routing Assignment Insertion Failed";

	/**
	 * 
	 */
	public static final String ENERGY_INSERT_SUCESS = "Energy Insertion is sucessful";
	/**
	 * 
	 */
	public static final String ENERGY_INSERT_FAILURE = "Energy Insertion has failed";
	/**
	 * 
	 */
	public static final String POWER_TABLECREATION_SUCESS = "Energy Assignment Created Sucessful";

	/**
	 * 
	 */
	public static final String POWER_TABLE_CREATION_FAILURE = "Energy Assignment Failure";
	/**
	 * 
	 */
	public static final String POWER_INSERT_SUCESS = "Energy Assignment is sucessful";

	/**
	 * 
	 */
	public static final String POWER_INSERT_FAILURE = "Energy Assignment has failed";

	/**
	 * 
	 */

	public static final String VIEW_ROUTEOUT_NAME = "eedrout";
	/**
	 * 
	 */
	public static final String MODEL_ROUTEOUT_NAME = "routeObj";

	/**
	 * 
	 */
	public static final String FAILURE = "failure";
	/**
	 * 
	 */
	public static final String MESSAGE1 = "Destination Node canot be Greater than no of nodes";
	/**
	 * 
	 */
	public static final String MESSAGE = "message";

	public static final String CANNOT_RECOVER_NODES = "Cannot Recover the Fault Nodes at this instant of Time. Please try later";

	public static final String COMPARE_NOOFHOPS = "Comparison of Number of Hops is Sucessful";

	public static final String COMPARE_DEADNODES = "Comparison of Dead Nodes is Sucessful";

	public static final String COMPARE_ALIVENODES = "Comparison of Alive Nodes is Sucessful";

	public static final String COMPARE_PACKETLOSS = "Comparison of Packet Loss is Sucessful";

	public static final String DEADNODES_ALGO1 = "No of Dead Nodes Retrival for Grade Diffusion is Sucessful";

	public static final String DEADNODES_ALGO2 = "No of Dead Nodes Retrival for Fault Node is Sucessful";

	public static final String ALIVENODES_ALGO1 = "No of Alive Nodes Retrival for Grade Diffusion is Sucessful";

	public static final String ALIVENODES_ALGO2 = "No of Dead Nodes Retrival for Fault Node is Sucessful";

	public static final String NOOFHOPS_ALGO1 = "No of Hops Retrival for Grade Diffusion is Sucessful";

	public static final String NOOFHOPS_ALGO2 = "No of Hops Retrival for Fault Node is Sucessful";

	public static final String PACKETLOSS_ALGO1 = "Packet Loss Retrival for Grade Diffusion is Sucessful";

	public static final String PACKETLOSS_ALGO2 = "Packet Loss Retrival for Fault Node is Sucessful";

	public static final String SOURCENODE_EMPTY = "Source Node cannot be Empty";

	public static final String DESTNODE_EMPTY = "Destination Node Cannot be Empty";

	public static final String DATAPAYLOAD_EMPTY = "Data Payload cannot be Empty";
	public static final String COVAREA_EMPTY = "Coverage Area cannot be Empty";
	public static final String INITIALENERGY_EMPTY = "Initial Energy cannot be Empty";
	public static final String SOURCENODE_NUMBER = "Source Node must be  Numeric";
	public static final String DESTNODE_NUMBER = "Destination Node must be Numeric";
	public static final String COVAREA_NUMBER = "Coverage Area must be Numeric";
	public static final String INITIALENERGY_NUMER = "Intial Energy must be Numeric";
	public static final String FAILURELIST = "failurelist";
	public static final String ENERGY_TABLECREATION_SUCESS = "Energy Assignment Creation is Sucessful";
	public static final String ENERGY_TABLE_CREATION_FAILURE = "Energy Assignment Creation has Failed";
	public static final String SUCESS_PAGE = "sucess";
	public static final String FREQ_EMPTY = "Frequency Cannot be Empty";
	public static final String TTL_EMPTY = "TTL is Empty";
	public static final String FAILED_TOPOLOGY_TYPE_UPDATE = "Failed to Update Topology Type";
	public static final String UPDATE_TOPOLOGY_SUCESS = "Topology Updation is SUuessful";
	public static final String COMPARE_RESIDUALENERGY = "Comparision of Residual Energy is Sucessful";
	public static final String COMPARE_LIFETIMERATIO = "Comparision of Life Time Ratio is Sucessful";
	public static final String COMPARE_ROUTINGOVERHEAD = "Comparision of Routing Overhead is Sucessful";
	public static final String IPADRESS_TABLECREATION_FAILURE = "IP Address has Failed to be Created";
	public static final String IPADRESS_TABLECREATION_SUCESS = "IP Address  has been created Sucessful";
	public static final String IPADRESS_EMPTY = "IP Address Cannot be Empty";
	public static final String NODEID_EMPTY = "Please Select a Node Id";
	public static final String DATA_PACKET = "Data Payload must be given";
	public static final String IPADRESS_TABLEREMOVE_SUCESS = "IP Address can be removed sucessfully";
	public static final String IPADRESS_TABLEREMOVE_FAILURE = "IP Address removal has Failed";
	public static final String TYPE_EMPTY = "Please Select the Type";
	public static final String PERF_TABLEREMOVE_SUCESS = "Performance Data has been removed";
	public static final String DELETE_DATA_SUCESS = "Deleting the data is sucessfully";
	public static final String FAILED_TO_DELETE_CRITICAL_DATA = "Failed to delete Critical Data";
	public static final String FAILED_TO_DELETE_DATA = "Could not remove data";
	public static final String SESSION_EXPIRED = "Session has Expired";
	public static final String MULTIPARTFILE_EMPTY = "Multipart File is Empty";
	public static final String CONTENTTYPE_EMPTY = "Content Type is Empty";
	public static final String FILECONTENTS_EMPTY = "File Content cannot be Empty";

	interface Keys {

		static final String OBJ = "OBJ";
	}

	interface EEDRAlgoConstant {

		double FREQ = 100;

		double INITIAL_NOISE_FIGURE = 400 * Math.pow(10, -3);

		double SIGNAL_BW = 1.45;

		double NOISE_FIGURE = 4.8 * Math.pow(10, -2);

		double POWER_GAIN = 1;

		int UPPER_LIMIT = 100;
	}

}
