package com.routingtopology.dao.inter;

import com.routingtopology.constants.EnergyConstantsDAOIF;

/**
 * This is the DAO which is used to update,delete,retrive,create,drop
 *the performance related tables 
 */
public interface EnergyParametersDAOIF  extends EnergyConstantsDAOIF{
	
	/**
	 * @param dynamicName
	 * @return true if energy of the table is sucessful created
	 */
	public boolean createEnergyTable(String dynamicName);
	
	/**
	 * @param dynamicName
	 * @return droping energy tables
	 */
	public boolean dropEnergyTable(String dynamicName);
	
	/**
	 * @param dynamicTableName
	 * @return energy value of the node
	 */
	public double retriveEnergy(String dynamicTableName);
	
	/**
	 * @param dynamicTableName
	 * @param energyValue
	 * @return true if insertion
	 */
	public boolean insertEnergy(String dynamicTableName,double energyValue);
	
	/**
	 * @param dynamicTableName
	 * @return true if insertion
	 */
	public boolean deleteEnergy(String dynamicTableName);
	
	
	/**
	 * @param dynamicTableName
	 * @param energyValue
	 * @return true if insertion
	 */
	public boolean updateEnergy(String dynamicTableName,double energyValue);

}
