package com.routingtopology.service.inter;

import com.routingtopology.constants.ParameterServiceConstantsIF;
import com.routingtopology.value.ParameterValue;
import com.routingtopology.value.TopologyInfoValue;

/**
 * This is used for parameter services
 * 
 */
public interface ParametersServiceIF extends ParameterServiceConstantsIF {

	/**
	 * @param parameterType
	 * @param nodeIdToDrop
	 * @return true if specfic table is dropped
	 */
	public boolean dropSpecficTable(String parameterType, int nodeIdToDrop);

	/**
	 * @param parameterType
	 * @param topologyType
	 * @return true if energy of the table is sucessful created
	 */
	public boolean createParameterTables(String parameterType,
			String topologyType);

	/**
	 * @param parameterType
	 * @param topologyType
	 * @return droping energy tables
	 */
	public boolean dropAllTables(String parameterType, String topologyType);

	/**
	 * @param parameterType
	 * @param parameterNodeId
	 * @return ParameterValue of the node
	 */
	public ParameterValue retriveParameter(String parameterType, int parameterNodeId);

	/**
	 * @param parameterType
	 * @param topologyType
	 * @return true if insertion
	 */
	public boolean insertAllParameters(String parameterType, String topologyType);

	/**
	 * @param parameterType
	 * @param nodeIdToInsert
	 * @param topologyInfoValue
	 * @return true if sucessful insertion happens
	 */
	public boolean insertSingleParameter(String parameterType,
			int nodeIdToInsert, TopologyInfoValue topologyInfoValue);

	/**
	 * @param parameterType
	 * @param topologyType
	 * @return true if insertion
	 */
	public boolean deleteAllParameters(String parameterType, String topologyType);

	/**
	 * @param parameterType
	 * @param nodeIdToDelete
	 * @return true if insertion
	 */
	public boolean deleteSpecficParameter(String parameterType,
			int nodeIdToDelete);

	/**
	 * @param parameterType
	 * @param nodeIdToUpdate
	 * @param topologyInfoValue
	 * @return true if insertion
	 */
	public boolean updateParameter(String parameterType, int nodeIdToUpdate,
			TopologyInfoValue topologyInfoValue);

}
