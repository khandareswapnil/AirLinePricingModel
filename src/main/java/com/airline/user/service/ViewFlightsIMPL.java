package com.airline.user.service;

import java.util.*;

import com.airline.entity.FlightsDetails;
import com.airline.entity.ViewFlightsScheduleByUser;
import com.airline.user.repo.ViewFlightsRepo;
import com.airline.user.repo.ViewFlightsRepoIMPL;

public class ViewFlightsIMPL implements ViewFlights
{
	ViewFlightsRepoIMPL objFlightRepo =new ViewFlightsRepoIMPL();   // created object of repository class
	List<ViewFlightsScheduleByUser> list;                           // created list to accept list of flights from repo
	

	@Override
	public List<ViewFlightsScheduleByUser> isGetAllFlightsByStartEndCity(String startcity, String endcity) {
		// TODO Auto-generated method stub	
		list=objFlightRepo.viewAllFlightsByStartEndCity (startcity, endcity);	
		return list;
	}

	@Override
	public List<ViewFlightsScheduleByUser> isGetAllFlights() {
		// TODO Auto-generated method stub
		return objFlightRepo.viewAllFlights();
		
	}

	@Override
	public List<ViewFlightsScheduleByUser> isGetAllFlightsByStartEndCityDate(String startcity, String endcity, String date) {
		// TODO Auto-generated method stub
		list=objFlightRepo.viewAllFlightsByStartEndCityDate (startcity, endcity,date);	
		return list;
	}

	@Override
	public List<ViewFlightsScheduleByUser> viewAllFlightsByDate(String date) {
		// TODO Auto-generated method stub
		return objFlightRepo.viewAllFlightsByDate(date);
	}

	@Override
	public boolean isDeleteScheddule(String date, String time, String startCity, String endCity) {
		// TODO Auto-generated method stub
		return false;
	}
	
		
}

