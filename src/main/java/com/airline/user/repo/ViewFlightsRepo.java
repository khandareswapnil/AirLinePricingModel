package com.airline.user.repo;

import java.sql.ResultSet;
import java.util.List;

import com.airline.entity.ViewFlightsScheduleByUser;

public interface ViewFlightsRepo {
	public List<ViewFlightsScheduleByUser> viewAllFlights();
	public List<ViewFlightsScheduleByUser> viewAllFlightsByStartEndCity(String scity, String ecity);
	public List<ViewFlightsScheduleByUser> viewAllFlightsByStartEndCityDate(String scity, String ecity, String date);
	public List<ViewFlightsScheduleByUser> fetchFsRecordsInReadableFormat(ResultSet rs); // helper method
	public List<ViewFlightsScheduleByUser> viewAllFlightsByDate(String date);
}
