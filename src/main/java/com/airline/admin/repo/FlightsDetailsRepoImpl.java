package com.airline.admin.repo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.airline.entity.AddDistanceOfCity;
import com.airline.entity.FlightsDetails;
import com.airline.entity.FlightsName;
import com.airline.entity.FlightsSeatsAndBasePrice;
import com.airline.entity.FlightsTimes;
import com.ariline.config.DBConfig;

public class FlightsDetailsRepoImpl extends DBConfig implements FlightsDetailsRepo {

	@Override
	public boolean isFlightsName(FlightsName fname) {
		try {
				stmt=conn.prepareStatement("insert into flightsinfomaster values('0',?)");
				stmt.setString(1,fname.getFlightname());
				int val=stmt.executeUpdate();
				return val>0?true:false;
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean isAddTime(FlightsTimes fTime) {
		try {
			stmt=conn.prepareStatement("insert into flightstiming_master values('0',?)");
			stmt.setString(1, fTime.getTime());
			int val=stmt.executeUpdate();
			return val>0?true:false;

		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isAddSeatAndBasePrice(FlightsSeatsAndBasePrice fSABP) {
		try {
			stmt=conn.prepareStatement("insert into seat_base_price_master values('0',?,?)");
			stmt.setInt(1,fSABP.getNo_OF_Seats());
			stmt.setInt(2,fSABP.getBasePrice());
			int val=stmt.executeUpdate();
			return val>0?true:false;

		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isAddDistance(AddDistanceOfCity addDistnace,String startCity,String endCity) {
		try {
			int flag=0;
			stmt=conn.prepareStatement("select cityid from citymaster where cityname=?");
			stmt.setString(1, startCity);
			int sid=0;
			rs=stmt.executeQuery();
			if(rs.next())
			{
				sid=rs.getInt(1);
				
				if(sid!=0)
				{
					stmt=conn.prepareStatement("select cityid from citymaster where cityname=?");
					stmt.setString(1, endCity);
					int eid=0;
					rs=stmt.executeQuery();
					if(rs.next())
					{
						eid=rs.getInt(1);
						if(eid!=0)
						{
							stmt=conn.prepareStatement("insert into start_end_city_join values(?,?,?)");
							stmt.setInt(1, sid);
							stmt.setInt(2, eid);
							stmt.setInt(3,addDistnace.getDistance());
							int val=stmt.executeUpdate();
							return val>0?true:false;
						}
					}
				}
			}
			
			
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return false;
	}

	@Override
	public List<FlightsName> isGetFlightName() {
		try {
			List<FlightsName> list=new ArrayList<>();
			stmt=conn.prepareStatement("select *from flightsinfomaster");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				FlightsName flightName=new FlightsName();
				flightName.setFlightname(rs.getString(2));
				list.add(flightName);
			}
			return list;
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return null;
	}

	@Override
	public List<FlightsTimes> isGetTime() {
		try {
			List<FlightsTimes> list=new ArrayList<>();
			stmt=conn.prepareStatement("select *from flightstiming_master");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				FlightsTimes time=new FlightsTimes();
				time.setTime(rs.getString(2));
				list.add(time);
			}
			return list;
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return null;
	}

	@Override
	public List<FlightsSeatsAndBasePrice> isGetSeat() {
		try {
			List<FlightsSeatsAndBasePrice> list=new ArrayList<>();
			stmt=conn.prepareStatement("select *from seat_base_price_master");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				FlightsSeatsAndBasePrice fSABP=new FlightsSeatsAndBasePrice();
				fSABP.setNo_OF_Seats(rs.getInt(2));
				fSABP.setBasePrice(rs.getInt(3));
				list.add(fSABP);
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return null;
	}

	@Override

	public boolean isAddFlightSchedule(FlightsDetails fDetails) {
		try {
			int scid=0;
			int ecid=0;
			int fid=0;
			int tid=0;
			int sbpid=0;
			stmt=conn.prepareStatement("select * from CityMaster where cityName=?");
			stmt.setString(1,fDetails.getStartCity());
			rs=stmt.executeQuery();
			if(rs.next())
			{
				  scid=rs.getInt(1);
				if(scid!=0)
				{
					stmt=conn.prepareStatement("select *from cityMaster where cityName=?");
					stmt.setString(1, fDetails.getEndCity());
					rs=stmt.executeQuery();
					if(rs.next())
					{
						ecid=rs.getInt(1);
					}
				}
			
			}
			stmt=conn.prepareStatement("select *from flightsinfomaster where flightsname=?");
			stmt.setString(1, fDetails.getFname());
			rs=stmt.executeQuery();
			if(rs.next())
			{
				fid=rs.getInt(1);
			}
			
			stmt=conn.prepareStatement("select * from flightstiming_master where time=?");
			stmt.setString(1, fDetails.getTime());
			rs=stmt.executeQuery();
			if(rs.next())
			{
				tid=rs.getInt(1);
			}
			stmt=conn.prepareStatement("select * from seat_base_price_master where no_seats=? and base_price=?");
			stmt.setInt(1, fDetails.getNo_seats());
			stmt.setInt(2, fDetails.getBasePrice());
			rs=stmt.executeQuery();
			if(rs.next())
			{
				sbpid=rs.getInt(1);
			}
			
			if( scid!=0 && ecid!=0 &&fid!=0 && tid!=0 && sbpid!=0)
			{
				stmt=conn.prepareStatement("insert into flightschedule values('0',?,?,?,?,?,?)");
				stmt.setInt(1, scid);
				stmt.setInt(2, ecid);
				stmt.setInt(3, fid);
				stmt.setInt(4, tid);
				stmt.setInt(5, sbpid);
				stmt.setString(6,fDetails.getDate());
				int val=stmt.executeUpdate();
				return val>0?true:false;
			}
			else 
			{
				return false;
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public int isUpdateFlightsName() {
		
		return 0;
	}

	@Override
	public List<FlightsName> isSearchName(FlightsName fname) {
		try {
		stmt=conn.prepareStatement("select * from flightsinfomaster where flightsname=?");
		stmt.setString(1, fname.getFlightname());
		rs=stmt.executeQuery();
		List<FlightsName> list=null;
		if(rs.next())
		{			
			list=new ArrayList<>();
			FlightsName fname1 =new FlightsName();
			fname1.setFlightname(rs.getString(2));
			list.add(fname1);
		}
		return list;
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
		
	
	}

	@Override
	public boolean isUpdate(String fname,String newName) {
		try {
			stmt=conn.prepareStatement("update  flightsinfomaster set flightsname=? where flightsname=?");
			stmt.setString(1, newName);
			stmt.setString(2, fname);
			int val=stmt.executeUpdate();
			return val>0?true:false;
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isDeleteFlight(FlightsName fname) {
		try
		{
			stmt=conn.prepareStatement("delete from flightsinfomaster where flightsname=?");
			stmt.setString(1, fname.getFlightname());
			int val=stmt.executeUpdate();
			return val>0?true:false;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	
	}
		
}

