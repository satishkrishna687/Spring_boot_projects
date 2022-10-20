package com.routingtopology.dao.inter;

import java.util.List;

import com.routingtopology.exception.RoutingException;
import com.routingtopology.value.HookInfo;
import com.routingtopology.value.PIInfo;


public interface PIDAOIF {

	/**
	 * @return true if all rows are successfully deleted otherwise it is false
	 */
	public boolean deletePI();

	/**
	 * @param nodeId
	 * @param pi
	 * @param trust
	 * @param energy
	 * @param zoneId
	 * @return true
	 * @throws RoutingException
	 */
	public boolean insertPI(int nodeId, double pi, int trust, double energy,
			int zoneId) throws RoutingException;

	/**
	 * @return List of Energy Info
	 * @throws RoutingException
	 */
	public List<PIInfo> retrivePI() throws RoutingException; 

	/**
	 * @return records used for angular topology
	 */
	public int retrivePICount();

	/**
	 * @param zoneId
	 * @param nodeId
	 * @return List of Node IDS for a given zone id
	 * @throws RoutingException 
	 */
	public List<Integer> retriveNodeIdsForZoneOrderByPI(int zoneId) throws RoutingException;

}
