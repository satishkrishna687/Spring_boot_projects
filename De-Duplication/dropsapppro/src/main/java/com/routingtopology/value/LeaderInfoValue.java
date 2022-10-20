package com.routingtopology.value;

public class LeaderInfoValue {

	private boolean isLeader;

	/**
	 * @param isLeader
	 */
	public void setLeader(boolean isLeader) {
		this.isLeader = isLeader;
	}

	/**
	 * @return true if node is zone leader
	 */
	public boolean isLeader() {
		return isLeader;
	}

}
