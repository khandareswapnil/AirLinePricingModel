package com.airline.user.service;

import java.util.List;

import com.airline.entity.ViewFlightsScheduleByUser;
import com.airline.user.repo.BookingRepo;

public class BookingService {
	BookingRepo bookrepo= new BookingRepo();
	public List<Integer> showAvailableSeats (int fsid) {
		return bookrepo.showAvailableSeats(fsid);
	}

}
