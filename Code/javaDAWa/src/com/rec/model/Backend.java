package com.rec.model;

public interface Backend {

	public static final Double WEB_API_DB_COST = 2200.0;
	public static final Double BE_MAINTENANCE_COST = 500.0;
	
	public Double createWebAPIAndDBConnectionCost();
	public Double maintenanceCost();
}
