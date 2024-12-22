package com.airline.user.service;
import java.util.*;
import com.airline.entity.FlightsDetails;
import com.airline.entity.ViewFlightsScheduleByUser;

public interface ViewFlights {
	public List<ViewFlightsScheduleByUser> isGetAllFlights();
	public List<ViewFlightsScheduleByUser> isGetAllFlightsByStartEndCity(String startcity, String endcity); 
	public List<ViewFlightsScheduleByUser> isGetAllFlightsByStartEndCityDate(String startcity, String endcity,String date); 
	 


}
