package com.routingtopology.dao.inter;

import com.routingtopology.constants.TrustConstantsDAOIF;

/**
 * This is the trust parameter
 * 
 */
public interface DempsterParameterDAOIF extends TrustConstantsDAOIF {

	/**
	 * @param dynamicName
	 * @return true if energy of the table is sucessful created
	 */
	public boolean createDempterTrustTable(String dynamicName);

	/**
	 * @param dynamicName
	 * @return droping energy tables
	 */
	public boolean dropDempterTrustTable(String dynamicName);

	/**
	 * @param dynamicTableName
	 * @return energy value of the node
	 */
	public double retriveDempterTrust(String dynamicTableName);

	/**
	 * @param dynamicTableName
	 * @param trustLevel
	 * @return true if insertion
	 */
	public boolean insertDempterTrust(String dynamicTableName, double trustLevel);

	/**
	 * @param dynamicTableName
	 * @return true if insertion
	 */
	public boolean deleteDempterTrust(String dynamicTableName);

	/**
	 * @param dynamicTableName
	 * @param trustLevel
	 * @return true if updated otherwise false
	 */
	public boolean updateDempterTrust(String dynamicTableName, double trustLevel);

}
