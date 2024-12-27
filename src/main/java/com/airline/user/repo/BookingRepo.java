package com.airline.user.repo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.airline.entity.Seat;
import com.airline.entity.ViewFlightsScheduleByUser;
import com.ariline.config.DBConfig;

public class BookingRepo extends DBConfig {
	List<Seat> list=null;
	Seat seat ;
	
	public List<Seat> showAvailableSeats(int fsid){
		try {
			list=new ArrayList<>();

			stmt=conn.prepareStatement("select S_NO ,status from seatmaster where fsid=?");
			stmt.setInt(1, fsid);
			rs=stmt.executeQuery();	
			while(rs.next()) {
				seat=new Seat();
				seat.setSno(rs.getInt(1));
				seat.setStatus(rs.getInt(2));
				list.add(seat);
			}
			return list;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	
	public boolean bookTicket(int uid, int fsid, int seatNo,int finalPrice) {
		try {
			stmt=conn.prepareStatement("select * from seatmaster where fsid=? AND S_NO=?");
			stmt.setInt(1, fsid);
			stmt.setInt(2, seatNo);
			rs=stmt.executeQuery();
			if(rs.next()) {
				int sid=rs.getInt(1);
				if(rs.getInt(4)!=0) {
					
				}
				else {
					stmt=conn.prepareStatement("insert into booking_details values('0',?,?)");
					stmt.setInt(1, uid);
					stmt.setInt(2, sid);
					int val=stmt.executeUpdate();
					stmt=conn.prepareStatement("update seatmaster set status=?,final_price=? where fsid=? AND S_NO=?");
					stmt.setInt(1, 1);
					stmt.setInt(2, finalPrice);
					stmt.setInt(3, fsid);
					stmt.setInt(4, seatNo);
					
					int val2=stmt.executeUpdate();
					if(val!=0 && val2!=0) return true;
					else return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
