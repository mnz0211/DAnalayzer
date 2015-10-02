
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class XY 
{
	
	//public static void displayData(ResultSet rs) throws SQLException
	public static void displayData() throws SQLException
	{
		
		String sql = "SELECT * FROM XY";
		
		try (
		Connection conn = connectionString.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);		)
		{
			System.out.println("XY TABLE: ");
	
		
			while (rs.next())
			{
				//Collecting data from 1+ columns
				StringBuffer buffer = new StringBuffer() ;
				//primary Key
				buffer.append(rs.getString("UID") + "   ");
				//rest
				buffer.append(rs.getString("WELLNAME") + "   ");
				buffer.append(rs.getString("ALIAS") + "   ");
				buffer.append(rs.getDouble("XCOORD") + "   ");
				buffer.append(rs.getDouble("YCOORD") + "   ");
				buffer.append(rs.getDouble("BOTTOMX") + "   ");
				buffer.append(rs.getDouble("BOTTOMY") + "   ");
				buffer.append(rs.getDouble("KBELEV") + "   ");
				buffer.append(rs.getDouble("TDEPTH") + "   ");
				buffer.append(rs.getDate("CDATE") + "   ");
				buffer.append(rs.getString("ONPRODDATE") + "   ");
				buffer.append(rs.getDouble("Latitude") + "   ");
				buffer.append(rs.getDouble("Longitude") + "   ");


			
				System.out.println(buffer.toString());
			}
		}
	}
	

	public static Beans.singleXY getRow(String UID) throws SQLException
	{
		String sql = "SELECT * FROM XY WHERE UID = ?";
		ResultSet rs = null;
		
		try(
			Connection conn = connectionString.getConnection();
				PreparedStatement stmt= conn.prepareStatement(sql))
		{
			stmt.setString(1, UID);
			rs = stmt.executeQuery();
			//checking if input is relevant to db (if false)
			if (rs.next())
			{
				Beans.singleXY bean = new Beans.singleXY();
				//set keys
				bean.setUID(UID);
				bean.setWELLNAME(rs.getString("WELLNAME"));
				bean.setALIAS(rs.getString("ALIAS"));
				bean.setXCOORD(rs.getDouble("XCOORD"));
				bean.setYCOORD(rs.getDouble("YCOORD"));
				bean.setBOTTOMX(rs.getDouble("BOTTOMX"));
				bean.setBOTTOMY(rs.getDouble("BOTTOMY"));
				bean.setKBELEV(rs.getDouble("KBELEV"));
				bean.setTDEPTH(rs.getDouble("TDEPTH"));
				bean.setCDATE(rs.getDate("CDATE"));
				bean.setONPRODDATE(rs.getString("ONPRODDATE"));
				bean.setLatitude(rs.getDouble("Latitude"));
				bean.setLongitude(rs.getDouble("Longitude"));
				
			
				
				return bean;
			}else
			{
				System.err.println("No Rows were Found with specified UID");
				return null;
			}
			
			
			
		}
	}
	
	public static boolean insert (Beans.singleXY bean) throws SQLException
	{

		String sql = "INSERT INTO PRD (UID, WELLNAME,  ALIAS, XCOORD, YCOORD, BOTTOMX, BOTTOMY, KBELEV,TDEPTH,CDATE,ONPRODDATE,Latitude,Longitude)" +"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		
		try(
					Connection conn = connectionString.getConnection();
					PreparedStatement stmt= conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
			{
			stmt.setString(1, bean.getUID());
			stmt.setString(2, bean.getWELLNAME());
			stmt.setDouble(3, bean.getXCOORD());
			stmt.setDouble(4, bean.getYCOORD());
			
			stmt.setDouble(5, bean.getBOTTOMX());
			stmt.setDouble(6, bean.getBOTTOMY());
			stmt.setDouble(7, bean.getKBELEV());
			stmt.setDouble(8, bean.getTDEPTH());
			stmt.setDate(9, bean.getCDATE());
			stmt.setString(10, bean.getONPRODDATE());
			stmt.setDouble(11, bean.getLatitude());
			stmt.setDouble(12, bean.getLongitude());
		
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
	
//	public static boolean update(Beans.singlePRD bean) throws Exception
//	{
//
//		String sql = "UPDATE PRD " + "SET" + " HOURS= ? , Oil = ?, Gas=?, Water =?, getCOND = ? , getONPROD = ? " + "WHERE" + " UID = ? , Date = ?";
//		
//	//	ResultSet keys = null;
//		
//		try(
//					Connection conn = connectionString.getConnection();
//					PreparedStatement stmt= conn.prepareStatement(sql))
//			{
//			
//			
//			stmt.setInt(1, bean.getHours());
//			stmt.setDouble(2, bean.getOil());
//			stmt.setDouble(3, bean.getGas());
//			stmt.setDouble(4, bean.getWater());
//			stmt.setInt(5,bean.getCOND());
//			stmt.setInt(6,bean.getONPROD());
//			
//			stmt.setString(7, bean.getUID());
//			stmt.setDate(8, new java.sql.Date(bean.getDate().getTime()));
//			
//			
//			//TEST WHETHER EXECUTION WAS SUCCESSFUL
//			
//		int perfect = stmt.executeUpdate();
//			 if (perfect == 1) 
//			 {
//				 return true;
//				
//			 } else 
//			 {
//				 System.err.println("No rows affected");
//				 return false;
//
//			 }
//			}catch (SQLException e)
//		{
//				System.err.println(e);
//				return false;
//		} 
//	}
//	
//
}
