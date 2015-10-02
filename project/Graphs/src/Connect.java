//import java.sql.*;
//
//
//public class Connect {
//
//	//	private Connection conn;
//	//		
//	//	public Connect() throws SQLException{		
//	//		conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\asd\\Desktop\\Provo East 2.accdb");		
//	//	}
//	//
//	//	public Connection getConn() {
//	//		return conn;
//	//	}
//	//
//	//	public void setConn(Connection conn) {
//	//		this.conn = conn;
//	//	}
//
//	public static void main(String[] args) {
//
//		Connection conn = null;
//		Statement st = null;
//		PreparedStatement preSt = null;
//		PreparedStatement preSt2 = null;
//		ResultSet rs1 = null;
//		ResultSet rs2 = null;
//		try{
//
//			//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\asd\\Desktop\\Provo East 2.accdb");
//			String wName = "PVEA0131";
//			String wellName = "PVEA2_0731";
//			preSt = conn.prepareStatement("select * from PRD where UID = '" + wellName+"'");
//			preSt2 = conn.prepareStatement("select * from PRD where UID = '" + wName+"'");
//			rs1 = preSt.executeQuery();
//			rs2 = preSt2.executeQuery();
//			//			st = conn.createStatement();
//			//			rs = st.executeQuery("select * from PRD");
//			boolean flag1 = rs1.next();
//			boolean flag2 = rs2.next();
//			while(flag1 || flag2 ){
//				
//				if(flag1 && flag2){
//					if(rs1.getDate(2).equals(rs2.getDate(2))){
//						System.out.println("date1: " + rs1.getDate(2) + " date2: " + rs2.getDate(2)+ " Oil: " + (rs1.getDouble(4)+rs2.getDouble(4)));
//						flag1 = rs1.next();
//						flag2 = rs2.next();
//					}else{
//						if(rs1.getDate(2).before(rs2.getDate(2))){
//							System.out.println("date1: " + rs1.getDate(2) + " Oil: " + rs1.getDouble(4));
//							flag1 = rs1.next();
//						}else{
//							System.out.println("date2: " + rs2.getDate(2) + " Oil: " + rs2.getDouble(4));
//							flag2 = rs2.next();
//						}
//					}
//				}else{
//					if(flag1){
//						System.out.println("date1: " + rs1.getString(2) + " Oil: " + rs1.getDouble(4));
//						flag1 = rs1.next();
//					}else{
//						System.out.println("date2: " + rs2.getString(2)+ " Oil: " + rs2.getDouble(4));
//						flag2 = rs2.next();
//					}
//				}
//				
////				if(flag1 && flag2){
////					//					if(rs1.getString(2).equals(rs2.getString(2)))
////					System.out.println("date1: " + rs1.getString(2) + " date2: " + rs2.getString(2)+ " Oil: " + (rs1.getDouble(4)+rs2.getDouble(4)));
////				}else{
////					if(flag1){
////						System.out.println("date1: " + rs1.getString(2) + " Oil: " + rs1.getDouble(4));
////					}else
////						System.out.println("date2: " + rs2.getString(2)+ " Oil: " + rs2.getDouble(4));
////				}
////				//				System.out.print("UID: " + rs1.getString(1)+" ");
////				//				System.out.print("Date: " + rs1.getString(2)+" ");
////				//				System.out.print("Hours: " + rs1.getString(3)+" ");
////				//				System.out.print("Oil: " + rs1.getString(4)+" ");
////				//				System.out.print("Gas: " + rs1.getString(5)+" ");
////				//				System.out.print("Water: " + rs1.getString(6));
////				//				System.out.println();
////				flag1 = rs1.next();
////				flag2 = rs2.next();
//
//			}
//
//		}catch(Exception e){
//			System.out.println(e);
//		}
//
//	}
//
//}
