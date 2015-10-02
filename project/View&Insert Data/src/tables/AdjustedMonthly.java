package tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdjustedMonthly
{
	
	public static void displayData(ResultSet rs) throws SQLException
	{
		while (rs.next())
		{
			//Collecting data from 1+ columns
			StringBuffer buffer = new StringBuffer() ;
			//primary Key
			buffer.append("Date :" + rs.getString("Date") + ":  ");
			//rest
			buffer.append(rs.getString("UID") + "   ");
			
			buffer.append(rs.getDouble("Oil"));
			
			
			
			
			
			System.out.println(buffer.toString());
		}
	}

}
