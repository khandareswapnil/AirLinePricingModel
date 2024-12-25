package com.airline.user.service;

import java.util.*;

import com.airline.entity.FlightsDetails;
import com.airline.entity.ViewFlightsScheduleByUser;
import com.airline.user.repo.ViewFlightsRepo;
import com.airline.user.repo.ViewFlightsRepoIMPL;

public class ViewFlightsIMPL implements ViewFlights
{
	ViewFlightsRepoIMPL objFlightRepo =new ViewFlightsRepoIMPL();   // created object of repository class
	Set<ViewFlightsScheduleByUser> set;                           // created list to accept list of flights from repo
	

	@Override
	public Set<ViewFlightsScheduleByUser> isGetAllFlightsByStartEndCity(String startcity, String endcity) {
		// TODO Auto-generated method stub		
		return objFlightRepo.viewAllFlightsByStartEndCity (startcity, endcity);
	}

	@Override
	public Set<ViewFlightsScheduleByUser> isGetAllFlights() {
		// TODO Auto-generated method stub
		return objFlightRepo.viewAllFlights();
		
	}

	@Override
	public Set<ViewFlightsScheduleByUser> isGetAllFlightsByStartEndCityDate(String startcity, String endcity, String date) {
		// TODO Auto-generated method stub	
		return objFlightRepo.viewAllFlightsByStartEndCityDate (startcity, endcity,date);
	}

	
		
}

