package com.airline.user.repo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.airline.entity.ViewBookingDetails;
import com.ariline.config.DBConfig;

public class UserHistory extends DBConfig {
	ViewBookingDetails viewBooking;
	List <ViewBookingDetails> list= new ArrayList<>();
	public List<ViewBookingDetails> isGetUserHistory(int uid)  {
		String query= "SELECT ui.name, ui.email, ui.contact, f.flightsname, ci.cityname AS start_city, ci2.cityname AS end_city, fs.date AS flight_date, t.time AS flight_time"+
						" FROM booking_details bd"+ 
						" JOIN userinfo ui ON bd.uid = ui.uid"+
						" JOIN seatmaster sm ON bd.sid = sm.id"+
						" JOIN flightschedule fs ON sm.fsid = fs.fsid"+
						" JOIN flightsinfomaster f ON fs.flight_id = f.fid"+
						" JOIN citymaster ci ON fs.start_city_id = ci.cityid"+
						" JOIN citymaster ci2 ON fs.end_city_id = ci2.cityid"+
						" JOIN seat_base_price_master sb ON fs.sbpid = sb.sbpid"+
						" JOIN flightstiming_master t ON fs.tid = t.tid"+
						" WHERE ui.uid=?";
		try {
			stmt=conn.prepareStatement(query);
			stmt.setInt(1, uid);
			rs=stmt.executeQuery();
			while(rs.next()) {
				String uname=rs.getString(1);
				String uemail=rs.getString(2);
				String ucontact=rs.getString(3);
				String fname=rs.getString(4);
				String scity=rs.getString(5);
				String ecity=rs.getString(6);
				String date=rs.getString(7);
				String time=rs.getString(8);
				viewBooking=new ViewBookingDetails(uname,uemail,ucontact,fname,scity,ecity,date,time);
				list.add(viewBooking);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
