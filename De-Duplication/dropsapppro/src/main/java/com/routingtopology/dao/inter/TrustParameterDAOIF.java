package com.routingtopology.dao.inter;

import com.routingtopology.constants.TrustConstantsDAOIF;

/**
 * This is the trust parameter
 *
 */
public interface TrustParameterDAOIF  extends TrustConstantsDAOIF{
	
	/**
	 * @param dynamicName
	 * @return true if energy of the table is sucessful created
	 */
	public boolean createTrustTable(String dynamicName);
	
	/**
	 * @param dynamicName
	 * @return droping energy tables
	 */
	public boolean dropTrustTable(String dynamicName);
	
	/**
	 * @param dynamicTableName
	 * @return energy value of the node
	 */
	public int  retriveTrust(String dynamicTableName);
	
	/**
	 * @param dynamicTableName
	 * @param trustLevel 
	 * @return true if insertion
	 */
	public boolean insertTrust(String dynamicTableName,int trustLevel);
	
	/**
	 * @param dynamicTableName
	 * @return true if insertion
	 */
	public boolean deleteTrust(String dynamicTableName);
	
	
	
	/**
	 * @param dynamicTableName
	 * @param trustLevel
	 * @return true if updated otherwise false
	 */
	public boolean updateTrust(String dynamicTableName, int trustLevel);
	

}
