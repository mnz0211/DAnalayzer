package Beans;

import java.io.Serializable;
import java.sql.Date;

public class singleXY implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4861397562378764627L;
	private String UID, WELLNAME, ALIAS, ONPRODDATE ;
	Date CDATE;
	private double XCOORD, YCOORD, BOTTOMX, BOTTOMY, KBELEV, TDEPTH, Latitude, Longitude;
	
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String getWELLNAME() {
		return WELLNAME;
	}
	public void setWELLNAME(String wELLNAME) {
		WELLNAME = wELLNAME;
	}
	public String getALIAS() {
		return ALIAS;
	}
	public void setALIAS(String aLIAS) {
		ALIAS = aLIAS;
	}
	public Date getCDATE() {
		return CDATE;
	}
	public void setCDATE(Date date) {
		CDATE = date;
	}
	public String getONPRODDATE() {
		return ONPRODDATE;
	}
	public void setONPRODDATE(String oNPRODDATE) {
		ONPRODDATE = oNPRODDATE;
	}
	public double getXCOORD() {
		return XCOORD;
	}
	public void setXCOORD(double xCOORD) {
		XCOORD = xCOORD;
	}
	public double getYCOORD() {
		return YCOORD;
	}
	public void setYCOORD(double yCOORD) {
		YCOORD = yCOORD;
	}
	public double getBOTTOMX() {
		return BOTTOMX;
	}
	public void setBOTTOMX(double bOTTOMX) {
		BOTTOMX = bOTTOMX;
	}
	public double getBOTTOMY() {
		return BOTTOMY;
	}
	public void setBOTTOMY(double bOTTOMY) {
		BOTTOMY = bOTTOMY;
	}
	public double getKBELEV() {
		return KBELEV;
	}
	public void setKBELEV(double kBELEV) {
		KBELEV = kBELEV;
	}
	public double getTDEPTH() {
		return TDEPTH;
	}
	public void setTDEPTH(double tDEPTH) {
		TDEPTH = tDEPTH;
	}
	public double getLatitude() {
		return Latitude;
	}
	public void setLatitude(double latitude) {
		Latitude = latitude;
	}
	public double getLongitude() {
		return Longitude;
	}
	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

}
