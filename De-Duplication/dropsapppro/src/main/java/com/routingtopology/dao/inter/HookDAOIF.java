package com.routingtopology.dao.inter;

import java.util.List;
import com.routingtopology.exception.RoutingException;
import com.routingtopology.value.HookInfo;

public interface HookDAOIF {

	/**
	 * @return true if all rows are successfully deleted otherwise it is false
	 */
	public boolean deleteHook();

	/**
	 * @param nodeId
	 * @param energy
	 * @return true
	 * @throws RoutingException
	 */
	public boolean insertHook(
			int nodeId, double energy) throws RoutingException;

	/**
	 * @return List of Energy Info
	 * @throws RoutingException
	 */
	public List<HookInfo> retriveHook()
			throws RoutingException;

	/**
	 * @return records used for angular topology
	 */
	public int retriveHookCount();

}
