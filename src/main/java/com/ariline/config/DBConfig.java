package com.ariline.config;
import java.sql.*;
import java.util.Properties;
import java.io.*;

public class DBConfig {
		protected static Connection conn;
		protected static PreparedStatement stmt;
		protected static ResultSet rs;
		protected static CallableStatement csmt;
		
		private static DBConfig db;
		
		//we are making singalton class so private constructor
		
		protected DBConfig ()
		{
			//connection logic can generate exception
			
			try {
				
				File f = new File(".");
				String path = f.getAbsolutePath();
				path=path.substring(0, (path.length()-1));
				path=path+"src\\main\\resources\\DbConfig.properties";
				//System.out.println(path);
				FileInputStream inputStream = new FileInputStream(path);
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
//				 if(conn!=null)
//				 {
//					 System.out.println("Database connected Successfully");
//				 }
//				
			}
			catch(Exception ex)
			{
				System.out.println("Error is : "+ex);
			}
			
			
		}
		
		public static DBConfig getInstance() {
			if(db==null) {
				db=new DBConfig();
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
		
		/*
		public static void main(String x[])
		{
			new DBConfig();
		} */


	}

