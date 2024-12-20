package com.airline.admin.repo;

import java.sql.SQLException;

import com.airline.entity.AddDistanceOfCity;
import com.airline.entity.FlightsDetails;
import com.airline.entity.FlightsName;
import com.airline.entity.FlightsSeatsAndBasePrice;
import com.airline.entity.FlightsTimes;

public interface FlightsDetailsRepo {
	public boolean isFlightsName(FlightsName fname);
	public boolean isAddTime(FlightsTimes fTime);
	public boolean isAddSeatAndBasePrice(FlightsSeatsAndBasePrice fSABP);
	public boolean isAddDistance(AddDistanceOfCity addDistnace,String startCity,String endCity);

}
