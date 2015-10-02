package Beans;

import java.io.Serializable;
import java.util.*;


public class singlePRD implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2720699713479443971L;
	private String UID ;
	private java.util.Date Date;
	private double Oil, Gas, Water;
	private int Hours, COND, ONPROD ;
	
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public double getOil() {
		return Oil;
	}
	public void setOil(double oil) {
		Oil = oil;
	}
	public double getGas() {
		return Gas;
	}
	public void setGas(double gas) {
		Gas = gas;
	}
	public double getWater() {
		return Water;
	}
	public void setWater(double water) {
		Water = water;
	}
	public int getHours() {
		return Hours;
	}
	public void setHours(int hours) {
		Hours = hours;
	}
	public int getCOND() {
		return COND;
	}
	public void setCOND(int cOND) {
		COND = cOND;
	}
	public int getONPROD() {
		return ONPROD;
	}
	public void setONPROD(int oNPROD) {
		ONPROD = oNPROD;
	}
	
	
}
