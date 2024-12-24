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
	public boolean isAddDistance(AddDistanceOfCity addDistnace);
	public List<FlightsName> isGetFlightName();
	public List<FlightsTimes> isGetTime();
	public List<FlightsSeatsAndBasePrice> isGetSeat();
	public boolean isAddFlightSchedule(FlightsDetails fDetails);
	public int isUpdateFlightsName();
	public List<FlightsName> isSearchName(FlightsName fname);
	public boolean isUpdate(String fname,String newName);
	public boolean isDeleteFlight(FlightsName fname);
	public List<AddDistanceOfCity> isSearchCityDistRecord(String startCity,String endCity);
	public List<AddDistanceOfCity> isViewAllDistanceRecords();
	public boolean isUpdateCityDistRecord(String startCity,String endCity,int dist);
	public boolean isDeleteCityDistRecord(String startCity,String endCity);

}
