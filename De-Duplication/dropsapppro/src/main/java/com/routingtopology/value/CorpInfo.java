package com.routingtopology.value;

import java.util.List;


public class CorpInfo {
	
	
	private List<Integer> corpNodeIds;
	
	
	private List<HookInfo> allNodes;
	
	private List<HookInfo> corpNodes;

	/**
	 * @param allNodes
	 */
	public void setAllNodes(List<HookInfo> allNodes) {
		this.allNodes = allNodes;
	}

	/**
	 * @return List of HookInfo
	 */
	public List<HookInfo> getAllNodes() {
		return allNodes;
	}

	/**
	 * @param corpNodes
	 */
	public void setCorpNodes(List<HookInfo> corpNodes) {
		this.corpNodes = corpNodes;
	}

	/**
	 * @return List of HookInfo
	 */
	public List<HookInfo> getCorpNodes() {
		return corpNodes;
	}

	/**
	 * @param corpNodeIds
	 */
	public void setCorpNodeIds(List<Integer> corpNodeIds) {
		this.corpNodeIds = corpNodeIds;
	}

	/**
	 * @return List of Corporative Nodes Information
	 */
	public List<Integer> getCorpNodeIds() {
		return corpNodeIds;
	}

}
