package com.airline.user.repo;

import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

import com.airline.entity.ViewFlightsScheduleByUser;

public interface ViewFlightsRepo {
	public Set<ViewFlightsScheduleByUser> viewAllFlights();
	public Set<ViewFlightsScheduleByUser> viewAllFlightsByStartEndCity(String scity, String ecity);
	public Set<ViewFlightsScheduleByUser> viewAllFlightsByStartEndCityDate(String scity, String ecity, String date);
	public Set<ViewFlightsScheduleByUser> fetchFsRecordsInReadableFormat(ResultSet rs); // helper method
	public Set<ViewFlightsScheduleByUser> viewAllFlightsByDate(String date);
	public boolean isDeleteScheddule(String date,String time,String startCity,String endCity);
}
