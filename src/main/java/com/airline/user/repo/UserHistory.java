package com.airline.user.repo;

import java.sql.SQLException;
import java.util.List;

import com.ariline.config.DBConfig;

public class UserHistory extends DBConfig {
	public List isGetUserHistory(int uid)  {
		String query= "SELECT f.flightsname, ci.cityname AS start_city, ci2.cityname AS end_city, fs.date AS flight_date, t.time AS flight_time"+
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
