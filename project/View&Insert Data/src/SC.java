

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SC 
{

	public static void displayData() throws SQLException
	{
		String sql = "SELECT * FROM SC";
		
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
				buffer.append(rs.getString("Geometry") + "   ");
				buffer.append(rs.getString("Field") + "   ");
				buffer.append(rs.getString("Pool") + "   ");
				buffer.append(rs.getString("Operator") + "   ");
				buffer.append(rs.getString("Status") + "   ");
				buffer.append(rs.getString("Zone") + "   ");
				buffer.append(rs.getString("Flow_Station") + "   ");
	
				
				System.out.println(buffer.toString());
			}
		}
	}
	//ENTERING NEW DATA
	
	//------UPDATING EXISTING------
	public static Beans.singleSC getRow(String UID) throws SQLException
	{
		String sql = "SELECT * FROM SC WHERE UID = ?";
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
				Beans.singleSC bean = new Beans.singleSC();
				//set keys
				bean.setUID(UID);
				bean.setGeometry(rs.getString("Geometry"));
				bean.setField(rs.getString("Field"));
				bean.setPool(rs.getString("Pool"));
				bean.setOperator(rs.getString("Operator"));
				bean.setStatus(rs.getString("Status"));
				bean.setZone(rs.getString("Zone"));
				bean.setFlow_Station(rs.getString("Flow_Station"));
				
				return bean;
			}else
			{
				System.err.println("No Rows were Found with specified UID");
				return null;
			}
		}
	}
	
	public static boolean insert (Beans.singleSC bean) throws SQLException
	{
		String sql = "INSERT into SC (UID,Geometry, Field, Pool, Operator, Status, Zone, Flow_Station)" +
	"VALUES (?,?,?,?,?,?,?,?)";
		
		
		//ResultSet rs = null;
		
		try(
					Connection conn = connectionString.getConnection();
					PreparedStatement stmt= conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
					//PreparedStatement stmt= conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE))
			{
			stmt.setString(1, bean.getUID());
			stmt.setString(2, bean.getGeometry());
			stmt.setString(3, bean.getField());
			stmt.setString(4, bean.getPool());
			stmt.setString(5, bean.getOperator());
			stmt.setString(6, bean.getStatus());
			stmt.setString(7, bean.getZone());
			stmt.setString(8, bean.getFlow_Station());
			
			//TEST WHETHER EXECUTION WAS SUCCESSFUL
			// int perfect = stmt.executeUpdate();
			
			 stmt.executeUpdate();
			 
			 return true;
//			 if (rs.next()) {
//				 rs.updateString("UID", bean.getUID());
//				 rs.updateString("Geometry", bean.getGeometry());
//				 rs.updateString("Field", bean.getField());
//				 rs.updateString("Field", bean.getField());
//				 rs.updateString("Pool", bean.getPool());
//				 rs.updateString("Operator", bean.getOperator());
//				 rs.updateString("Status", bean.getStatus());
//				 rs.updateString("Zone", bean.getZone());
//				 return true;
//				
//			} else {
//				return false;
//
//			}
			 
//			 if (perfect == 1) 
//			 {
//				 keys = stmt.getGeneratedKeys();
//				 keys.next();
//				 String newkey = keys.getString(1);
//				 bean.setUID(newkey);;
//				
//			 } else 
//			 {
//				 System.err.println("No rows affected");
//
//			 }
			
			}catch (SQLException e)
		{
				System.err.println(e);
				return false;
		} //closing rs
//		finally
//		{
//			if (keys!=null) keys.close();
//		}

	}
	public static boolean update(Beans.singleSC bean) throws Exception
	{

//		String sql = "UPDATE SC " + "SET" + "Geometry = ?, Field = ?, Pool = ?, Operator = ?, Status = ?, Zone = ?, Flow_Station = ?" + 
//		"WHERE UID = ?";
//		
		String sql = "SELECT * FROM SC WHERE UID = ? ";
		
		ResultSet rs = null;
		
		try(
					Connection conn = connectionString.getConnection();
					PreparedStatement stmt= conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE))
			{
			
			stmt.setString(1, bean.getUID());
			
//			stmt.setString(2, bean.getGeometry());
//			stmt.setString(3, bean.getField());
//			stmt.setString(4, bean.getPool());
//			stmt.setString(5, bean.getStatus());
//			stmt.setString(6, bean.getZone());
//			stmt.setString(7, bean.getFlow_Station());
//		
			//TEST WHETHER EXECUTION WAS SUCCESSFUL
//			
//		    stmt.executeUpdate();
//		    stmt.close();
//		    return true;
			 
			 rs = stmt.executeQuery();
			 
			 
			 if (rs.next()) {
				 rs.updateString("Geometry", bean.getGeometry());
				 rs.updateString("Field", bean.getField());
				 rs.updateString("Field", bean.getField());
				 rs.updateString("Pool", bean.getPool());
				 rs.updateString("Operator", bean.getOperator());
				 rs.updateString("Status", bean.getStatus());
				 rs.updateString("Zone", bean.getZone());
				 return true;
				
			} else {
				return false;

			}

			}catch (SQLException e)
		{
				System.err.println(e);
				return false;
		} 
	}
			
			
}
