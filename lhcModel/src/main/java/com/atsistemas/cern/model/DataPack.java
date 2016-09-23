package com.atsistemas.cern.model;

public class DataPack {

	private String id;
	private String experimentId;
	private String someData;
	
	
	public DataPack() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataPack(String experimentId) {
		super();
		this.experimentId = experimentId;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExperimentId() {
		return experimentId;
	}
	public void setExperimentId(String experimentId) {
		this.experimentId = experimentId;
	}
	public String getSomeData() {
		return someData;
	}
	public void setSomeData(String someData) {
		this.someData = someData;
	}
	
}
