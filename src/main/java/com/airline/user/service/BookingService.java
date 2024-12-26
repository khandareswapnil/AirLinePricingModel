package com.airline.user.service;

import java.util.List;

import com.airline.entity.Seat;
import com.airline.entity.ViewFlightsScheduleByUser;
import com.airline.user.repo.BookingRepo;

public class BookingService {
	BookingRepo bookrepo= new BookingRepo();
	public List<Seat> showAvailableSeats (int fsid) {
		return bookrepo.showAvailableSeats(fsid);
	}
    
	public boolean bookTicket(int uid, int fsid, int seatNo) {
		
		return bookrepo.bookTicket(uid, fsid, seatNo);	
	}
}
