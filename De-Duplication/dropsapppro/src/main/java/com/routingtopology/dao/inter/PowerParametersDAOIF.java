package com.routingtopology.dao.inter;

import com.routingtopology.constants.PowerConstantsDAOIF;

/**
 * This is the power parameter DAO IF
 *
 */
public interface PowerParametersDAOIF extends PowerConstantsDAOIF {
	
	/**
	 * @param dynamicName
	 * @return true if energy of the table is sucessful created
	 */
	public boolean dropPowerTable(String dynamicName);
	
	
	/**
	 * @param dynamicName
	 * @return true if energy of the table is sucessful created
	 */
	public boolean createPowerTable(String dynamicName);
	
	
	/**
	 * @param dynamicTableName
	 * @return energy value of the node
	 */
	public double retrivePower(String dynamicTableName);
	
	/**
	 * @param dynamicTableName
	 * @param powerValue 
	  * @return true if insertion
	 */
	public boolean insertPower(String dynamicTableName,double powerValue);
	
	/**
	 * @param dynamicTableName
	 * @return true if insertion
	 */
	public boolean deletePower(String dynamicTableName);
	
	
	/**
	 * @param dynamicTableName
	 * @param powerValue 
	 * @return true if insertion
	 */
	public boolean updatePower(String dynamicTableName,double powerValue);

}
