package com.airline.reposiroty;
import java.sql.*;
import java.util.Properties;
import java.io.*;
public class DbConfig {
	protected static Connection conn;
	protected static PreparedStatement stmt;
	protected static ResultSet rs;
	
	private static DbConfig db;
	
	//we are making singalton class so private constructor
	
	private DbConfig ()
	{
		//connection logic can generate exception
		
		try {
			
			File f = new File("");
			String path = f.getAbsolutePath();
			//System.out.println(path);
			FileInputStream inputStream = new FileInputStream("D:/Exam4_12/AirlineTicketPricingModel/src/main/resources/dbconfig.properties");
			Properties p = new Properties();
			p.load(inputStream);       // property file loaded
			
			String driverClassName =p.getProperty("driver");  //fetching data from properties file
			String url =p.getProperty("url");
			String username=p.getProperty("username");
			String password=p.getProperty("password");
			//System.out.println(username+"\t"+password+"\t"+url);
			
			Class.forName(driverClassName);
			//System.out.println("Driver loaded successfully..");
			
			 conn=DriverManager.getConnection(url,username,password);
			/* if(conn!=null)
			 {
				 System.out.println("Database connected Successfully");
			 }*/
			
		}
		catch(Exception ex)
		{
			System.out.println("Error is : "+ex);
		}
		
		
	}
	
	public static DbConfig getInstance() {
		if(db==null) {
			db=new DbConfig();
		}
		return db;
	}
	
	public static Connection getConnection() {
		return conn;
	}
	
	public static PreparedStatement getStatement()
	{
		return stmt;
	}
	
	public static ResultSet getResultSet()
	{
		return rs;
	}
	
	/*public static void main(String x[])
	{
		new DbConfig();
	} */


}
