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
			System.out.println("Error is"+ex);
		}
		return false;
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
			System.out.println("Error is"+ex);
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
			System.out.println("Error is"+ex);
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
			stmt=conn.prepareStatement("select *from citymaster");
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightsSeatsAndBasePrice> isGetSeat() {
		// TODO Auto-generated method stub
		return null;
	}
		
}

