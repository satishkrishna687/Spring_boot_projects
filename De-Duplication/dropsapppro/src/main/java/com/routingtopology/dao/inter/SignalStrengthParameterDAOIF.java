package com.routingtopology.dao.inter;

import com.routingtopology.constants.TrustConstantsDAOIF;

/**
 * This is the trust parameter
 * 
 */
public interface SignalStrengthParameterDAOIF extends TrustConstantsDAOIF {

	/**
	 * @param dynamicName
	 * @return true if energy of the table is sucessful created
	 */
	public boolean createSignalStrengthTable(String dynamicName);

	/**
	 * @param dynamicName
	 * @return droping energy tables
	 */
	public boolean dropSignalStrengthTable(String dynamicName);

	/**
	 * @param dynamicTableName
	 * @return energy value of the node
	 */
	public double retriveSignalStrengthTable(String dynamicTableName);

	/**
	 * @param dynamicTableName
	 * @param signalstrength
	 * @return true if insertion
	 */
	public boolean insertSignalStrength(String dynamicTableName,
			double signalstrength);

	/**
	 * @param dynamicTableName
	 * @return true if insertion
	 */
	public boolean deleteSignalStrength(String dynamicTableName);

	/**
	 * @param dynamicTableName
	 * @param signalstrength
	 * @param trustLevel
	 * @return true if updated otherwise false
	 */
	public boolean updateSignalStrength(String dynamicTableName,
			double signalstrength);

}
