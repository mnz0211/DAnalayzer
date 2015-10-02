

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import org.hsqldb.types.DateTimeType;

public class PRD 
{


	public static void displayData() throws SQLException
	{

		String sql = "SELECT * FROM PRD";
		
		try (
		Connection conn = connectionString.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);		)
		{
			System.out.println("PRD TABLE: ");
		
	
		while (rs.next())
			{
				//Collecting data from 1+ columns
				StringBuffer buffer = new StringBuffer() ;
				//primary Key
				buffer.append(rs.getString("UID") + "   ");
				//rest
				buffer.append(rs.getDate("Date") + "   ");
				buffer.append(rs.getInt("HOURS") + "   ");
				buffer.append(rs.getDouble("OIL") + "   ");
				buffer.append(rs.getDouble("GAS") + "   ");
				buffer.append(rs.getDouble("WATER") + "   ");
				buffer.append(rs.getInt("COND") + "   ");
				buffer.append(rs.getInt("ONPROD") + "   ");
			
				System.out.println(buffer.toString());
			}
		}
	}
		
	//------PICKING ROWS------
	public static Beans.singlePRD getRow(java.sql.Date Date) throws SQLException
	{
		String sql = "SELECT * FROM PRD WHERE Date = ?";
		ResultSet rs = null;
		
		try(
			Connection conn = connectionString.getConnection();
				PreparedStatement stmt= conn.prepareStatement(sql))
		{
			stmt.setDate(1, Date);
			rs = stmt.executeQuery();
			//checking if input is relevant to db (if false)
			if (rs.next())
			{
				Beans.singlePRD bean = new Beans.singlePRD();
				//set keys
				bean.setDate(rs.getDate("Date"));
				bean.setUID(rs.getString("UID"));
				//bean.setDate(rs.getString("Date"));
				bean.setHours(rs.getInt("HOURS"));
				bean.setOil(rs.getDouble("OIL"));
				bean.setGas(rs.getDouble("GAS"));
				bean.setWater(rs.getDouble("WATER"));
				bean.setCOND(rs.getInt("COND"));
				bean.setONPROD(rs.getInt("ONPROD"));
				
	
				return bean;
			}else
			{
				System.err.println("No Rows were Found with specified Date");
				return null;
			}
			
			
			
		}
	}
	//ENTERING NEW DATA-----------------------
	
	public static boolean insert (Beans.singlePRD bean) throws SQLException
	{

		String sql = "INSERT INTO PRD (UID, Date,  HOURS, OIL, GAS, WATER, COND, ONPROD)" +"VALUES (?,?,?,?,?,?,?,?)";
		
		
		try(
					Connection conn = connectionString.getConnection();
					PreparedStatement stmt= conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
			{
			stmt.setString(1, bean.getUID());
			stmt.setDate(2, new java.sql.Date(bean.getDate().getTime()));
			stmt.setInt(3, bean.getHours());
			stmt.setDouble(4, bean.getOil());
			stmt.setDouble(5, bean.getGas());
			stmt.setDouble(6, bean.getWater());
			stmt.setInt(7,bean.getCOND());
			stmt.setInt(8,bean.getONPROD());
			
			//TEST WHETHER EXECUTION WAS SUCCESSFUL
			
			stmt.executeUpdate();
			stmt.close();
//
			return true;
			}catch (SQLException e)
		{
				System.err.println(e);
				return false;
		} 
	}
	
	public static boolean update(Beans.singlePRD bean) throws Exception
	{

		String sql = "UPDATE PRD " + "SET" + " HOURS= ? , Oil = ?, Gas=?, Water =?, getCOND = ? , getONPROD = ? " + "WHERE" + " UID = ? , Date = ?";
		
	//	ResultSet keys = null;
		
		try(
					Connection conn = connectionString.getConnection();
					PreparedStatement stmt= conn.prepareStatement(sql))
			{
			
			
			stmt.setInt(1, bean.getHours());
			stmt.setDouble(2, bean.getOil());
			stmt.setDouble(3, bean.getGas());
			stmt.setDouble(4, bean.getWater());
			stmt.setInt(5,bean.getCOND());
			stmt.setInt(6,bean.getONPROD());
			
			stmt.setString(7, bean.getUID());
			stmt.setDate(8, new java.sql.Date(bean.getDate().getTime()));
			
			
			//TEST WHETHER EXECUTION WAS SUCCESSFUL
			
		int perfect = stmt.executeUpdate();
			 if (perfect == 1) 
			 {
				 return true;
				
			 } else 
			 {
				 System.err.println("No rows affected");
				 return false;

			 }
			}catch (SQLException e)
		{
				System.err.println(e);
				return false;
		} 
	}
	
	
}

