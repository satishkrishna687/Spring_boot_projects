package com.routingtopology.dao.inter;

import java.util.List;

import com.routingtopology.value.RelayNodeFunction;

/**
 *This is the Class which 
 *is used to Compute Relay
 *Values
 *
 */
public interface RelayFuncDAOIF {
	
	
	/**
	 * This is the Constant used for Relay Information
	 */
	public static final String DELETE_RELAYINFORMATION_SQL="DELETE_RELAYINFORMATION_SQL";
	
	/**
	 * This is the Constant used for Insertion of Relay Information
	 */
	public static final String INSERT_RELAYINFORMATION_SQL="INSERT_RELAYINFORMATION_SQL";
	
	/**
	 * This is the Constant used for REtrivel of Relay Information
	 */
	public static final String RETRIVE_RELAYFUNCINFORMATION_SQL="RETRIVE_RELAYFUNCINFORMATION_SQL";
	
	/**
	 * This is Column for K1 in DB
	 */
	public static final String K1_COL="K1";
	
	/**
	 * This is Column for K2 in DB
	 */
	public static final String K2_COL="K1";
	
	/**
	 * This is Column for RESIDUAL ENERGY in DB
	 */
	public static final String RESIDUALENERGY_COL="RESIDUALENERGY";
	
	/**
	 * This is Column for MAX ENERGY in DB
	 */
	public static final String MAXENERGY_COL="MAXENERGY";
	
	/**
	 * This is Column for DISTANCEBSNODE in DB
	 */
	public static final String DISTANCEBSNODE_COL="DISTANCEBSNODE";
	
	/**
	 * This is Column for DISTANCEBSNODE in DB
	 */
	public static final String DISTANCENODECH_COL="DISTANCENODECH";
	
	
	
	/**
	 * @return true if deleted otherwise false
	 * 
	 */
	public boolean deleteRelayFunc(); 
	
	/**
	 * @return List of the Relay Node Information
	 */
	public List<RelayNodeFunction> retriveRelayFuncAll();
	
	
	/**
	 * @param relayFn
	 * @return true if the Relay is Inserted otherwise false
	 */
	public boolean insertRelayFn(RelayNodeFunction relayFn);
	
	
	/**
	 * @param nodeId
	 * @return RelayNodeFunction for a Node
	 */
	public RelayNodeFunction retriveRelayForNode(int nodeId);
	

}
