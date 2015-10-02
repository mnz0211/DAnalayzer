import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class LineGraph extends ApplicationFrame {
	
//	this is the constructor that builds the plot object. the appTitlle takes the name of the window. the chartTitle is the name of the chart. wellname 1 and 2 are specified by the user. he could enter one or both.
//	just create an instance of the class and the plot will appear

	public LineGraph(String apptitle, String chartTitle, String wellName1, String wellName2) throws SQLException{
		super(apptitle);
		if(!wellName1.equals("") && !wellName2.equals("")){
			JFreeChart lineChart = ChartFactory.createLineChart(chartTitle , "Date", "Daily production rate of " + wellName1 + " and " + wellName2 + " bbl/d", createDataSet(wellName1, wellName2), PlotOrientation.VERTICAL, true, true, false);
			ChartPanel chartPanel = new ChartPanel(lineChart);
			chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 560 ) );
			setContentPane( chartPanel );
			this.pack();
			RefineryUtilities.centerFrameOnScreen(this);
			this.setVisible(true);
		}else{
			if(!wellName1.equals("")){
				JFreeChart lineChart = ChartFactory.createLineChart(chartTitle, "Date", "Daily production rate of " + wellName1 +" bbl/d", createDataSet(wellName1), PlotOrientation.VERTICAL, true, true, false);
				ChartPanel chartPanel = new ChartPanel(lineChart);
				chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 560 ) );
				setContentPane( chartPanel );
				this.pack();
				RefineryUtilities.centerFrameOnScreen(this);
				this.setVisible(true);
			}else{
				JFreeChart lineChart = ChartFactory.createLineChart(chartTitle, "Date", "Daily production rate of " + wellName2 +" bbl/d", createDataSet(wellName2), PlotOrientation.VERTICAL, true, true, false);
				ChartPanel chartPanel = new ChartPanel(lineChart);
				chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 560 ) );
				setContentPane( chartPanel );
				this.pack();
				RefineryUtilities.centerFrameOnScreen(this);
				this.setVisible(true);
			}
		}
	}

	public static DefaultCategoryDataset createDataSet(String wellName1, String wellName2) throws SQLException{
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		try{
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\asd\\Desktop\\Provo East 2.accdb");
			PreparedStatement preSt1 = con.prepareStatement("select Date,OIL,WATER,GAS,HOURS from PRD where UID = '" + wellName1 +"'");
			PreparedStatement preSt2 = con.prepareStatement("select Date,OIL,WATER,GAS,HOURS from PRD where UID = '" + wellName2 +"'");
			ResultSet rs1 = preSt1.executeQuery();
			ResultSet rs2 = preSt2.executeQuery();
			boolean flag1 = rs1.next();
			boolean flag2 = rs2.next();
			while(flag1 || flag2 ){

				if(flag1 && flag2){
					if(rs1.getDate(1).equals(rs2.getDate(1))){
						dataSet.addValue(rs1.getDouble(2)*24/rs1.getInt(5)+rs2.getDouble(2)*24/rs2.getInt(5), "OIL", rs1.getDate(1));
						dataSet.addValue(rs1.getDouble(3)*24/rs1.getInt(5)+rs2.getDouble(3)*24/rs2.getInt(5), "WATER", rs1.getDate(1));
						dataSet.addValue(rs1.getDouble(4)*24/rs1.getInt(5)+rs2.getDouble(4)*24/rs2.getInt(5), "GAS", rs1.getDate(1));
						//						System.out.println("date1: " + rs1.getDate(1) + " date2: " + rs2.getDate(1)+ " Oil: " + (rs1.getDouble(2)+rs2.getDouble(2)));
						flag1 = rs1.next();
						flag2 = rs2.next();
					}else{
						if(rs1.getDate(1).before(rs2.getDate(1))){
							dataSet.addValue(rs1.getDouble(2)*24/rs1.getInt(5), "OIL", rs1.getDate(1));
							dataSet.addValue(rs1.getDouble(3)*24/rs1.getInt(5), "WATER", rs1.getDate(1));
							dataSet.addValue(rs1.getDouble(4)*24/rs1.getInt(5), "GAS", rs1.getDate(1));
							//							System.out.println("date1: " + rs1.getDate(1) + " Oil: " + rs1.getDouble(2));
							flag1 = rs1.next();
						}else{
							dataSet.addValue(rs2.getDouble(2)*24/rs2.getInt(5), "OIL", rs2.getDate(1));
							dataSet.addValue(rs2.getDouble(3)*24/rs2.getInt(5), "WATER", rs2.getDate(1));
							dataSet.addValue(rs2.getDouble(4)*24/rs2.getInt(5), "GAS", rs2.getDate(1));
							//							System.out.println("date2: " + rs2.getDate(1) + " Oil: " + rs2.getDouble(2));
							flag2 = rs2.next();
						}
					}
				}else{
					if(flag1){
						dataSet.addValue(rs1.getDouble(2)*24/rs1.getInt(5), "OIL", rs1.getDate(1));
						dataSet.addValue(rs1.getDouble(3)*24/rs1.getInt(5), "WATER", rs1.getDate(1));
						dataSet.addValue(rs1.getDouble(4)*24/rs1.getInt(5), "GAS", rs1.getDate(1));
						//						System.out.println("date1: " + rs1.getString(1) + " Oil: " + rs1.getDouble(2));
						flag1 = rs1.next();
					}else{
						dataSet.addValue(rs2.getDouble(2)*24/rs2.getInt(5), "OIL", rs2.getDate(1));
						dataSet.addValue(rs2.getDouble(3)*24/rs2.getInt(5), "WATER", rs2.getDate(1));
						dataSet.addValue(rs2.getDouble(4)*24/rs2.getInt(5), "GAS", rs2.getDate(1));
						//						System.out.println("date2: " + rs2.getString(1)+ " Oil: " + rs2.getDouble(2));
						flag2 = rs2.next();
					}
				}
			}

		}catch(Exception e){
			System.out.println(e);
		}
		return dataSet;
	}

	public static DefaultCategoryDataset createDataSet(String wellName){
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		try{
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\asd\\Desktop\\Provo East 2.accdb");
			Statement st  = con.createStatement();
			ResultSet rs = st.executeQuery("select Date,OIL,WATER,GAS,HOURS from PRD where UID = '" + wellName +"'");
			while(rs.next()){
				dataSet.addValue((rs.getDouble(2)*24)/rs.getInt(5), "OIL", rs.getString(1).substring(0, 7));
				dataSet.addValue((rs.getDouble(3)*24)/rs.getInt(5), "WATER", rs.getString(1).substring(0, 7));
				dataSet.addValue((rs.getDouble(4)*24)/rs.getInt(5), "GAS", rs.getString(1).substring(0, 7));
//				System.out.println(rs.getString(1) + " " +rs.getString(2));
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return dataSet;
	}

	public static void main(String[] args) throws SQLException {
		LineGraph graph = new LineGraph("first garph","Daily production","","PVEC2_0131");
//		graph.pack();
//		RefineryUtilities.centerFrameOnScreen(graph);
//		graph.setVisible(true);
//		//		createDataSet();
	}

}
