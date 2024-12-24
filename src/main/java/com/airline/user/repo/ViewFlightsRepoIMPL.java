package com.airline.user.repo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.airline.entity.ViewFlightsScheduleByUser;
import com.ariline.config.DBConfig;
public class ViewFlightsRepoIMPL extends DBConfig implements ViewFlightsRepo{
	
	ViewFlightsScheduleByUser obj ;                                            //viewFlight Schedule entity class reference
	List<ViewFlightsScheduleByUser> list ;                                     //  list reference to store found records
	int fsid;
	String flightName;
	String startCity;
	String endCity;
	String date;
	String flightTime;
	int noOfSits;
	int basePrice;   
	String query;                                                            // created string to hold sql query
	int id=1;                                                                // created a id start from 1 to show fetched records sequence number

	
	
	//helper method for to convert flight schedules data int id type to String type. takes resultset as parameter which may contain multiple records in id format
	
	@Override
	public List<ViewFlightsScheduleByUser> fetchFsRecordsInReadableFormat(ResultSet rs) {
		// TODO Auto-generated method stub
		id=1;
		list=new ArrayList<>();
		query = " select fi.flightsname, cm.cityname as StartCity, cm2.cityname as EndCity, fs.date, ftm.time, sbp.no_seats, sbp.base_price" +
                   " from flightschedule fs"+
                   " inner join flightsinfomaster fi ON fs.flight_id=fi.fid"+
                   " inner join citymaster cm ON  fs.start_city_id=cm.cityid"+
                   " inner join citymaster cm2 ON  fs.end_city_id=cm2.cityid"+
                   " inner join flightstiming_master ftm ON fs.tid=ftm.tid"+
                   " inner join seat_base_price_master sbp ON fs.sbpid=sbp.sbpid where fsid=?";
		try {
			while(rs.next())
			{
				fsid=rs.getInt(1);
				stmt=conn.prepareStatement(query);   //join query for fetch details
				stmt.setInt(1, fsid);
				ResultSet rs2= stmt.executeQuery();
				if(rs2.next()) 
				{
					flightName=rs2.getString(1);
					startCity=rs2.getString(2);
					endCity=rs2.getString(3);
					date=rs2.getString(4);
					flightTime=rs2.getString(5);
					noOfSits=rs2.getInt(6);
					basePrice=rs2.getInt(7);
					obj=new ViewFlightsScheduleByUser(id,flightName,startCity,endCity,date,flightTime,noOfSits,basePrice);
					id++;
					list.add(obj);	
				} 
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	@Override
	public List<ViewFlightsScheduleByUser> viewAllFlights() {
		// TODO Auto-generated method stub
		try 
		{
			stmt=conn.prepareStatement("select * from flightschedule");
			rs=stmt.executeQuery();
			list=new ArrayList<>();
			list=fetchFsRecordsInReadableFormat(rs);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	

	@Override
	public List<ViewFlightsScheduleByUser> viewAllFlightsByStartEndCity(String scity, String ecity) {
		// TODO Auto-generated method stub
		
		try {
			int startCityId=0;
			int endCityId=0;
			stmt=conn.prepareStatement("select * from CityMaster where cityName=?");
			stmt.setString(1,scity);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				startCityId=rs.getInt(1);
				if(startCityId!=0)
				{
					stmt=conn.prepareStatement("select *from cityMaster where cityName=?");
					stmt.setString(1, ecity);
					rs=stmt.executeQuery();
					if(rs.next())
					{
						endCityId=rs.getInt(1);
					}
				}
			
			}
			stmt=conn.prepareStatement("select *from flightschedule where start_city_id=? AND end_city_id=?");
			stmt.setInt(1, startCityId);
			stmt.setInt(2, endCityId);
			rs=stmt.executeQuery();
			list = fetchFsRecordsInReadableFormat(rs);			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
		
	
	}


	@Override
	public List<ViewFlightsScheduleByUser> viewAllFlightsByStartEndCityDate(String scity, String ecity, String date) {
		// TODO Auto-generated method stub
		try {
			int startCityId=0;
			int endCityId=0;
			stmt=conn.prepareStatement("select * from CityMaster where cityName=?");
			stmt.setString(1,scity);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				startCityId=rs.getInt(1);
				if(startCityId!=0)
				{
					stmt=conn.prepareStatement("select *from cityMaster where cityName=?");
					stmt.setString(1, ecity);
					rs=stmt.executeQuery();
					if(rs.next())
					{
						endCityId=rs.getInt(1);
					}
				}
			
			}
			stmt=conn.prepareStatement("select *from flightschedule where start_city_id=? AND end_city_id=? AND date=?");
			stmt.setInt(1, startCityId);
			stmt.setInt(2, endCityId);
			stmt.setString(3, date);
			rs=stmt.executeQuery();
			list=fetchFsRecordsInReadableFormat(rs);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
