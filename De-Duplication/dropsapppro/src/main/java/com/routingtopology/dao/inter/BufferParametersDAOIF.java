package com.routingtopology.dao.inter;

import com.routingtopology.constants.BufferConstantsDAOIF;

/**
 * This is the DAO which is used to update,delete,retrive,create,drop
 *the performance related tables 
 */
public interface BufferParametersDAOIF extends BufferConstantsDAOIF {
	
	/**
	 * @param dynamicName
	 * @return true if energy of the table is sucessful created
	 */
	public boolean createBufferTable(String dynamicName);
	
	/**
	 * @param dynamicName
	 * @return droping energy tables
	 */
	public boolean dropBufferTable(String dynamicName);
	
	/**
	 * @param dynamicTableName
	 * @return energy value of the node
	 */
	public int retriveBuffer(String dynamicTableName);
	
	/**
	 * @param dynamicTableName
	 * @param buffer
	 * @return true if insertion
	 */
	public boolean insertBuffer(String dynamicTableName,int buffer);
	
	/**
	 * @param dynamicTableName
	 * @return true if insertion
	 */
	public boolean deleteBuffer(String dynamicTableName);
	
	
	/**
	 * @param dynamicTableName
	 * @param buffer
	 * @return true if insertion
	 */
	public boolean updateBuffer(String dynamicTableName,int buffer);

}
