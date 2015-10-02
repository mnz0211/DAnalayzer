import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.sql.ResultSet;
import java.util.*;

public class connectionString {
	
	public static Connection connection = null;
	public static Statement stmt = null;
	
	public static ResultSet rs = null; 
	public static final String URL = "jdbc:ucanaccess://C:/Oil/ProvoEast.accdb";
	
	//Getting Connection
	public static Connection getConnection() throws SQLException
	{
      return DriverManager.getConnection(URL);	
	}	

	//-----MIAN------
	public static void main(String[] args) throws Exception 
	{
		// Preventing a SQLException
		try
		{
			
			connection = connectionString.getConnection();
			stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//----TESTING
			
			//--------TESTING INSERTS--------
//			
//			Beans.singlePRD bean = new Beans.singlePRD();
//			
//			
//			bean.setUID(inputHelper.getInput("UID:  "));
//			bean.setDate(inputHelper.getDateInput("Date:   "));
//			bean.setHours(inputHelper.getIntInput("Hours:   "));
//			bean.setOil(inputHelper.getDoubleInput("Oil:   "));
//			bean.setGas(inputHelper.getDoubleInput("Gas:   "));
//			bean.setWater(inputHelper.getDoubleInput("Water:   "));
//			bean.setCOND(inputHelper.getIntInput("COND:   "));
//		    bean.setONPROD(inputHelper.getIntInput("ONPROD:   "));
//			
//			
//			
//			PRD.insert(bean);
			//----PRD UPDATE
			
			//---------TESTING UPDATES---------------
//			PRD.displayData();
//			
//			// the inputHelper is getting the input from the user one by one and storing it according to 'index number'
//			
////			//those are the Primary Keys 
////			String UID = inputHelper.getInput("Enter a UID to update :");
////			Date date = inputHelper.getDateInput("Enter Date (corresponding to entered UID) to update");
////			
//			
//			String UID = inputHelper.getInput("Enter a UID to update :");
//			Date date = inputHelper.getDateInput("Enter Date (corresponding to entered UID) to update");
//			
//			Beans.singlePRD bean = PRD.getRow(date);
//		
//			
//			
//			System.out.println("Update the following data");
//			
//			int Hours = inputHelper.getIntInput("new HOURS:  ");
//			bean.setHours(Hours);
//			double OilPRD = inputHelper.getDoubleInput("new Oil:  ");
//			bean.setOil(OilPRD);
//			double GasPRD = inputHelper.getDoubleInput("new Gas:  ");
//			bean.setGas(GasPRD);
//			double WaterPRD = inputHelper.getDoubleInput("new Water:  ");
//			bean.setWater(WaterPRD);
//			int COND = inputHelper.getIntInput("new COND:  ");
//			bean.setCOND(COND);
//			int ONPROD = inputHelper.getIntInput("new ONPROD:  ");
//			bean.setONPROD(ONPROD);
			
			
			//those are the Primary Keys 
//			System.out.println("enter your primary keys to update your row:");
//			String UID = inputHelper.getInput("Enter a UID to update :");
//			bean.setUID(UID);
//			Date date = inputHelper.getDateInput("Enter Date (corresponding to entered UID) to update");
//			bean.setDate(date);
//			
//			//boolean returns true is DB was updated
//			if(PRD.update(bean))
//			{
//				System.out.println("Success");
//			}else 
//			{
//				System.out.println("Try Again!");
//			}
//			
//			
//		
			SC.displayData();
			
			String UID = inputHelper.getInput("Enter a UID to update :");
			
			Beans.singleSC bean = SC.getRow(UID);
			
			if (bean == null)
			{
				System.err.println("Row not found");
				return;
			}
			
			
//			String UID = inputHelper.getInput("UID update :");
//			bean.setUID(UID);
			String geometry = inputHelper.getInput("Geometry update :");
			bean.setGeometry(geometry);
			String field = inputHelper.getInput("field update :");
			bean.setField(field);
			String pool = inputHelper.getInput("Pool update : ");
			bean.setPool(pool);
			String operator = inputHelper.getInput("Operator update :");
			bean.setOperator(operator);
			String status = inputHelper.getInput("Status update :");
			bean.setStatus(status);
			String zone = inputHelper.getInput("Zone update :");
			bean.setZone(zone);
			String flow_Station = inputHelper.getInput("FLOW_STATION update :");
			bean.setFlow_Station(flow_Station);
			
			SC.displayData();
			if(SC.update(bean))
				{
					System.out.println("Success");
				}else 
				{
					System.out.println("Try Again!");
				}
				
			//UPDATES HERE
			
			
	
			
			
			//-------------------------------
	
		}
		catch (SQLException ex)
		{
			JDBCBridge.processException(ex);
			//System.err.println(ex);
		}
		//closing resources when done with
		finally
		{
			if (rs != null) 
			{
				rs.close();
			}
			if (stmt != null) 
			{
				stmt.close();
			}
			if (connection != null) 
			{
				connection.close();
			}
		}
	}
	

}