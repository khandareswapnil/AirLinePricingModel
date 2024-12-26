package com.airline.admin.repo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.airline.entity.AddDistanceOfCity;
import com.airline.entity.FlightsDetails;
import com.airline.entity.FlightsName;
import com.airline.entity.FlightsSeatsAndBasePrice;
import com.airline.entity.FlightsTimes;
import com.airline.entity.ViewBookingDetails;

public interface FlightsDetailsRepo {
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
	public List<AddDistanceOfCity> isSearchCityDistRecord(String startCity, String endCity) ;
	public List<AddDistanceOfCity> isViewAllDistanceRecords();
	public boolean isUpdateCityDistRecord(String startCity, String endCity, int dist);
	public boolean isDeleteCityDistRecord(String startCity, String endCity);
	public List<FlightsSeatsAndBasePrice> isSearchSeatAndBasePriceExists(FlightsSeatsAndBasePrice fSABP) ;
	public List<FlightsSeatsAndBasePrice> isViewALlSeatAndBasePriceRecords();
	public boolean isUpdateSeatAndBasePriceRecord(int noOfSits,int bprice);
	public boolean isDeleteSeatAndBasePriceRecord(int seats);
	public boolean isUpdateFlightsDetaisl(FlightsDetails fDetails);
	public int isSearchByCityDateNameTime(String startCity,String endCity,String fname,String date,String time);
	public int isUpdate(int fsid,int tid);
	public boolean isDeleteSchedule(int fsid);
	public Set<FlightsTimes> isGetFLightTimes();
	public List<ViewBookingDetails> isViewBooking();
	

	

}
