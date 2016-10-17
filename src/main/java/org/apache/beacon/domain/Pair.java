package org.apache.beacon.domain;

public class Pair {
	private String remoteBeaconEndpoint;
	private String name;//name of Cluster
	public String getRemoteBeaconEndpoint() {
		return remoteBeaconEndpoint;
	}
	public void setRemoteBeaconEndpoint(String remoteBeaconEndpoint) {
		this.remoteBeaconEndpoint = remoteBeaconEndpoint;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
