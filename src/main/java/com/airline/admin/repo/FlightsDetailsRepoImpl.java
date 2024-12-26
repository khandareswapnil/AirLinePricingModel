package com.airline.admin.repo;

import java.sql.ResultSet;
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
	public boolean isAddDistance(AddDistanceOfCity addDistnace) {
		try {
			int flag=0;
			stmt=conn.prepareStatement("select cityid from citymaster where cityname=?");
			stmt.setString(1,addDistnace.getScity() );
			int sid=0;
			rs=stmt.executeQuery();
			if(rs.next())
			{
				sid=rs.getInt(1);
				
				if(sid!=0)
				{
					stmt=conn.prepareStatement("select cityid from citymaster where cityname=?");
					stmt.setString(1, addDistnace.getEcity());
					int eid=0;
					rs=stmt.executeQuery();
					if(rs.next())
					{
						eid=rs.getInt(1);
						if(eid!=0)
						{
							stmt=conn.prepareStatement("insert into start_end_city_join values(?,?,?,'0')");
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
				time.setId(rs.getInt(1));
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
				if(val!=0) {
					stmt=conn.prepareStatement("select fsid from flightschedule where start_city_id=? AND end_city_id=? AND flight_id=? AND tid=? AND sbpid=?");
					stmt.setInt(1, scid);
					stmt.setInt(2, ecid);
					stmt.setInt(3, fid);
					stmt.setInt(4, tid);
					stmt.setInt(5, sbpid);
					rs=stmt.executeQuery();
					if(rs.next()) 
					{
						int fsid=rs.getInt(1);
						int noOfSits = 0;
					stmt=conn.prepareStatement("select no_seats from seat_base_price_master where sbpid=?");
					stmt.setInt(1, sbpid);
					rs=stmt.executeQuery();
					   if(rs.next())
					   {
						noOfSits=rs.getInt(1);
					   }
					  for(int i=1;i<=noOfSits;i++) {
						  stmt=conn.prepareStatement("insert into seatmaster values('0',?,?,?)");
						  stmt.setInt(1, fsid);
						  stmt.setInt(2, i);
						  stmt.setInt(3, 0);
						  stmt.executeUpdate();
					  }
					}
					return true;
				}
				else return false;
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

	@Override
	public List<AddDistanceOfCity> isSearchCityDistRecord(String startCity, String endCity) {
		// TODO Auto-generated method stub
		List<AddDistanceOfCity> li= null;
		int startCityId=0;
		int endCityId=0;
		try {
			stmt=conn.prepareStatement("select * from citymaster where cityname=?");
			stmt.setString(1, startCity);
			rs=stmt.executeQuery();
			if(rs.next()) startCityId=rs.getInt(1);
			
			stmt=conn.prepareStatement("select * from citymaster where cityname=?");
			stmt.setString(1, endCity);
			rs=stmt.executeQuery();
			if(rs.next()) endCityId=rs.getInt(1);

			stmt=conn.prepareStatement("select * from start_end_city_join where startCity_id=? AND EndCity_id=?");
			stmt.setInt(1, startCityId);
			stmt.setInt(2, endCityId);
			rs=stmt.executeQuery();
			while(rs.next()) 
			{
			li= new ArrayList<>();
		    int dist=rs.getInt(3);
		    AddDistanceOfCity ad =new AddDistanceOfCity(startCity,endCity,dist); 
		    li.add(ad); 
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return li;	 
		
	}

	@Override
	public List<AddDistanceOfCity> isViewAllDistanceRecords() {
		// TODO Auto-generated method stub
		List<AddDistanceOfCity> li= new ArrayList<>();
		try {
			stmt=conn.prepareStatement("select *from start_end_city_join");
			rs=stmt.executeQuery();
			while(rs.next()) 
			{
			int scid=rs.getInt(1);
			int ecid=rs.getInt(2);
			int dist=rs.getInt(3);
			String startCity = null;
			String endCity = null;
			stmt=conn.prepareStatement("select *from citymaster where cityid=? ");
			stmt.setInt(1, scid);
			ResultSet rs2;
			rs2=stmt.executeQuery();
			if(rs2.next())
			{
				 startCity=rs2.getString(2);
			}
			stmt=conn.prepareStatement("select *from citymaster where cityid=? ");
			stmt.setInt(1, ecid);
			rs2=stmt.executeQuery();
			if(rs2.next())
			{
				endCity=rs2.getString(2);
			}
		   
		    AddDistanceOfCity ad =new AddDistanceOfCity(startCity,endCity,dist); 
		    li.add(ad); 
			}
			
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return li;
	}

	@Override
	public boolean isUpdateCityDistRecord(String startCity, String endCity, int dist) {
		// TODO Auto-generated method stub
		int startCityId =0;
		int endCityId=0;
		try {
			stmt=conn.prepareStatement("select *from citymaster where cityname=? ");
			stmt.setString(1, startCity);
			
			rs=stmt.executeQuery();
			if(rs.next())
			{
				 startCityId = rs.getInt(1);
			}
			stmt=conn.prepareStatement("select *from citymaster where cityname=? ");
			stmt.setString(1, endCity);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				endCityId = rs.getInt(1);
			}
			stmt=conn.prepareStatement("update start_end_city_join set distnace=? where startCity_id=? AND  EndCity_id=?");
			stmt.setInt(1, dist);
			stmt.setInt(2,startCityId );
			stmt.setInt(3, endCityId);
			int val=stmt.executeUpdate();
			if(val!=0) return true;
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isDeleteCityDistRecord(String startCity, String endCity) {
		// TODO Auto-generated method stub
		try {
			stmt=conn.prepareStatement("delete secj from start_end_city_join secj JOIN citymaster c1 ON c1.cityid=secj.startCity_id"+
		                               " JOIN citymaster c2 ON c2.cityid=secj.EndCity_id"+
									   " where c1.cityname=? AND"+
		                               " c2.cityname=?");
			stmt.setString(1, startCity);
			stmt.setString(2, endCity);
			int value=stmt.executeUpdate();
			if(value!=0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<FlightsSeatsAndBasePrice> isSearchSeatAndBasePriceExists(FlightsSeatsAndBasePrice fsabp) {
		// TODO Auto-generated method stub
		 List<FlightsSeatsAndBasePrice> li=new ArrayList<>();
		try {
			stmt=conn.prepareStatement("select *from seat_base_price_master where no_seats=? OR base_price=?");
			stmt.setInt(1, fsabp.getNo_OF_Seats());
			stmt.setInt(2, fsabp.getBasePrice());
			rs=stmt.executeQuery();
			while(rs.next())
			{
				li.add(fsabp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return li;
	}

	@Override
	public List<FlightsSeatsAndBasePrice> isViewALlSeatAndBasePriceRecords() {
		// TODO Auto-generated method stub
		 List<FlightsSeatsAndBasePrice> li=new ArrayList<>();
		 try {
			 stmt=conn.prepareStatement("select *from seat_base_price_master");
			 rs=stmt.executeQuery();
			 while(rs.next())
				{
				 	int noOfSits=rs.getInt(2);
				 	int basePrice=rs.getInt(3);
				 	FlightsSeatsAndBasePrice fsabp =new FlightsSeatsAndBasePrice(noOfSits,basePrice);
					li.add(fsabp);
				}
		 }
		 catch(Exception ex) {
			 ex.printStackTrace();
		 }
		return li;
	}

	// *********************************************************************************************************************//
	
	@Override
	public boolean isUpdateSeatAndBasePriceRecord(int noOfSits,int bprice) {
		// TODO Auto-generated method stub
		try {
			stmt=conn.prepareStatement("update seat_base_price_master set base_price=? where no_seats=?");
			stmt.setInt(1, bprice);
			stmt.setInt(2, noOfSits);
			int val=stmt.executeUpdate();
			if(val!=0) return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isDeleteSeatAndBasePriceRecord(int seats) {
		// TODO Auto-generated method stub
		try {
			stmt=conn.prepareStatement("delete from seat_base_price_master where no_seats=?");
			stmt.setInt(1, seats);
			int val=stmt.executeUpdate();
			if(val!=0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public boolean isUpdateFlightsDetaisl(FlightsDetails fDetails)
	{
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
				stmt=conn.prepareStatement("update flightschedule set tid=?, date=? where start_city_id=? and end_city_id=? and flight_id=? and sbpid=?");
				
				stmt.setInt(1, tid);
				stmt.setString(2,fDetails.getDate());
				stmt.setInt(3, scid);
				stmt.setInt(4, ecid);
				stmt.setInt(5, fid);
				stmt.setInt(6, sbpid);
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
	public int isSearchByCityDateNameTime(String startCity, String endCity, String fname, String date, String time) {
		String query="select fshedule.fsid from flightschedule fshedule"+
				" INNER JOIN citymaster c ON fshedule.start_city_id = c.cityid"+
				" INNER JOIN citymaster c1 ON fshedule.end_city_id = c1.cityid"+
				" inner join flightsinfomaster finame on fshedule.flight_id=finame.fid"+
				" INNER JOIN flightstiming_master ftime ON fshedule.tid = ftime.tid"+
				" where  c.cityName=? and c1.cityName=? and finame.flightsname=? and ftime.time=? and fshedule.date=? ";
		int fsid=0;
		try {
			
			stmt=conn.prepareStatement(query);
			stmt.setString(1, startCity);
			stmt.setString(2, endCity);
			stmt.setString(3, fname);
			stmt.setString(4, time);
			stmt.setString(5, date);
			
			rs=stmt.executeQuery();
			while(rs.next())
			{
				fsid=rs.getInt(1);
			}
			return fsid;
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return fsid;
	}

	@Override
	public int isUpdate(int fsid, int tid) {
			try {
				stmt=conn.prepareStatement("update flightschedule set tid=? where fsid=?");
				stmt.setInt(1, tid);
				stmt.setInt(2, fsid);
				int val=stmt.executeUpdate();
				return val;
				
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		return 0;
	}

	@Override
	public boolean isDeleteSchedule(int fsid) {
		try {
			stmt=conn.prepareStatement("delete from flightschedule where fsid=?");
			stmt.setInt(1, fsid);
			int val=stmt.executeUpdate();
			return val>0?true:false;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}		
}

