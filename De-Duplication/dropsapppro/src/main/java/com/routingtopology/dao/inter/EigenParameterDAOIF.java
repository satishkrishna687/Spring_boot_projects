package com.routingtopology.dao.inter;

import com.routingtopology.constants.TrustConstantsDAOIF;

/**
 * This is the trust parameter
 * 
 */
public interface EigenParameterDAOIF extends TrustConstantsDAOIF {

	/**
	 * @param dynamicName
	 * @return true if energy of the table is sucessful created
	 */
	public boolean createEigenTrustTable(String dynamicName);

	/**
	 * @param dynamicName
	 * @return droping energy tables
	 */
	public boolean dropEigenTrustTable(String dynamicName);

	/**
	 * @param dynamicTableName
	 * @return energy value of the node
	 */
	public double retriveEigenTrust(String dynamicTableName);

	/**
	 * @param dynamicTableName
	 * @param trustLevel
	 * @return true if insertion
	 */
	public boolean insertEigenTrust(String dynamicTableName, double trustLevel);

	/**
	 * @param dynamicTableName
	 * @return true if insertion
	 */
	public boolean deleteEigenTrust(String dynamicTableName);

	/**
	 * @param dynamicTableName
	 * @param trustLevel
	 * @return true if updated otherwise false
	 */
	public boolean updateEigenTrust(String dynamicTableName, double trustLevel);

}
