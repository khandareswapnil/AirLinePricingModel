package com.airline.user.service;
import java.util.*;
import com.airline.entity.FlightsDetails;
import com.airline.entity.ViewFlightsScheduleByUser;

public interface ViewFlights {
	public Set<ViewFlightsScheduleByUser> isGetAllFlights();
	public Set<ViewFlightsScheduleByUser> isGetAllFlightsByStartEndCity(String startcity, String endcity); 
	public Set<ViewFlightsScheduleByUser> isGetAllFlightsByStartEndCityDate(String startcity, String endcity,String date); 
	 
}
