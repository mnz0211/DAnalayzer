

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.ResultSet;


public class JDBCBridge 
{

	static Connection connection = null;
	
	public static void intiate()
	{
		try 
		{
			connection = connectionString.getConnection() ;
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	//JDBC Exception handlings (SQLExceptions basically) for debug
	public static void processException(SQLException ex)
	{
		System.err.println("Error Message:" + ex.getMessage());
		System.err.println("Error Code:  "+ ex.getErrorCode());
		System.err.println("SQL State   " + ex.getSQLState());

	}

	
}

