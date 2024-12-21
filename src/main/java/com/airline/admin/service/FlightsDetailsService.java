package com.airline.admin.service;

import java.util.List;

import com.airline.entity.AddDistanceOfCity;
import com.airline.entity.FlightsDetails;
import com.airline.entity.FlightsName;
import com.airline.entity.FlightsSeatsAndBasePrice;
import com.airline.entity.FlightsTimes;

public interface FlightsDetailsService {
	public boolean isFlightsName(FlightsName fname);
	public boolean isAddTime(FlightsTimes fTime);
	public boolean isAddSeatAndBasePrice(FlightsSeatsAndBasePrice fSABP);
	public boolean isAddDistance(AddDistanceOfCity addDistnace,String startCity,String endCity);
	public List<FlightsName> isGetFlightName();
	public List<FlightsTimes> isGetTime();
	public List<FlightsSeatsAndBasePrice> isGetSeat();
	public boolean isAddFlightSchedule(FlightsDetails fDetails);

}
