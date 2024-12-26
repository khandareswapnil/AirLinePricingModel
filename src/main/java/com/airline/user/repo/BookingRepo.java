package com.airline.user.repo;

import java.util.ArrayList;
import java.util.List;

import com.airline.entity.ViewFlightsScheduleByUser;
import com.ariline.config.DBConfig;

public class BookingRepo extends DBConfig {
	List<Integer> list=new ArrayList<>();
	
	public List<Integer> showAvailableSeats(int fsid){
		try {
			stmt=conn.prepareStatement("select S_NO ,status from seatmaster where fsid=? AND status=?");
			stmt.setInt(1, fsid);
			stmt.setInt(2, 0);
			rs=stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt(1));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
}
