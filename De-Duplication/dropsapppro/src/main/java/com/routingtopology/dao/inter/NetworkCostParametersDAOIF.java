package com.routingtopology.dao.inter;

import com.routingtopology.constants.NetworkCostConstantsDAOIF;

/**
 * This is the DAO which is used to update,delete,retrive,create,drop
 *the performance related tables 
 */
public interface NetworkCostParametersDAOIF extends NetworkCostConstantsDAOIF{
	
	/**
	 * @param dynamicName
	 * @return true if energy of the table is sucessful created
	 */
	public boolean createNetworkCostTable(String dynamicName);
	
	/**
	 * @param dynamicName
	 * @return droping energy tables
	 */
	public boolean dropNetworkCostTable(String dynamicName);
	
	/**
	 * @param dynamicTableName
	 * @return network cost value of the node
	 */
	public int retriveNetworkCost(String dynamicTableName);
	
	/**
	 * @param dynamicTableName
	 * @param networkCost 
	 * @return true if insertion
	 */
	public boolean insertNetworkCost(String dynamicTableName,double networkCost);
	
	/**
	 * @param dynamicTableName
	 * @return true if insertion
	 */
	public boolean deleteNetworkCost(String dynamicTableName);
	
	
	/**
	 * @param dynamicTableName
	 * @param networkCost
	 * @return true if insertion
	 */
	public boolean updateNetworkCost(String dynamicTableName,int networkCost);

}
