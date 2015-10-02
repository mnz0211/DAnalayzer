package Beans;

import java.io.Serializable;

public class singleSC implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4306981764224003546L;
	
	private String UID, Geometry, Field, Pool, Operator, Status, Zone, Flow_Station;

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public String getGeometry() {
		return Geometry;
	}

	public void setGeometry(String geometry) {
		Geometry = geometry;
	}

	public String getField() {
		return Field;
	}

	public void setField(String field) {
		Field = field;
	}

	public String getPool() {
		return Pool;
	}

	public void setPool(String pool) {
		Pool = pool;
	}

	public String getOperator() {
		return Operator;
	}

	public void setOperator(String operator) {
		Operator = operator;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getZone() {
		return Zone;
	}

	public void setZone(String zone) {
		Zone = zone;
	}

	public String getFlow_Station() {
		return Flow_Station;
	}

	public void setFlow_Station(String flow_Station) {
		Flow_Station = flow_Station;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
