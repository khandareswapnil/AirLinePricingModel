package com.airline.admin.repo;

import java.sql.SQLException;

public interface FlightsDetailsRepo {
	public boolean isAddFlightDetails(String fname,int time,int no_seats,int basePrice) ;

}
