package com.routingtopology.dao.inter;

import java.util.List;

import com.routingtopology.value.AlphaInfo;

/**
 * This is the class used to play around the alpha information about the nodes
 * 
 */
public interface AlphaDAOIF {
	
	
	/**
	 * This is the Information for deleting the Alpha Table
	 */
	public static final String DELETE_ALPHAINFORMATION_SQL="DELETE_ALPHAINFORMATION_SQL";
	
	
	/**
	 * This is the query to insert the Alpha Information SQL
	 */
	public static final String INSERT_ALPHAINFORMATION_SQL="INSERT_ALPHAINFORMATION_SQL";
	
	
	/**
	 * This is the query which is used to retrive the count from the ALPHA Table
	 */
	public static final String RETRIVE_ALPHAINFORMATION_COUNT_SQL="RETRIVE_ALPHAINFORMATION_COUNT_SQL";
	
	/**
	 * This is the query which is used to Retrive List of Alpha Values
	 */
	public static final String RETRIVE_ALPHAINFORMATION_SQL="RETRIVE_ALPHAINFORMATION_SQL";
	
	
	/**
	 * This is the Query which is used for Having the Alpha Information for Specfic Node
	 */
	public static final String RETRIVE_ALPHAINFORMATION_FOR_NODEID_SQL="RETRIVE_ALPHAINFORMATION_FOR_NODEID_SQL";

	/**
	 * @param alphaInfo
	 * @return true for Insertion of Alpha
	 */
	public boolean insertAlphaInfo(List<AlphaInfo> alphaInfo);

	/**
	 * @return List of Alpha Information
	 */
	public List<AlphaInfo> retriveAlphaInfo();

	/**
	 * @return true by deleting the Alpha Information
	 */
	public boolean deleteAllAlphaInfo();

	/**
	 * @param nodeId
	 * @return Alpha Information of the Node
	 */
	public AlphaInfo retriveAlphaInformation(int nodeId);
	
	/**
	 * @return Count of records in the Alpha Table
	 */
	public int retriveAlphaCount();
	
	

}
