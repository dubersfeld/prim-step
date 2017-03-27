package com.dub.site.minimumSpanningTree;


/** container object for AJAX response 
 * on initGraph request should return a component in a suitable form 
 **/
public class MSTResponse {
	private Status status;
	private JSONSnapshot snapshot;
	

	public MSTResponse() {
		status = null;
		snapshot = null;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public JSONSnapshot getSnapshot() {
		return snapshot;
	}

	public void setSnapshot(JSONSnapshot snapshot) {
		this.snapshot = snapshot;
	}

	

	public static enum Status {
		OK, ERROR, INIT
	}
}
