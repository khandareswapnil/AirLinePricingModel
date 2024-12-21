package com.airline.user.service;

import java.util.*;

import com.airline.entity.FlightsDetails;
import com.airline.user.repo.ViewFlightsRepo;
import com.airline.user.repo.ViewFlightsRepoIMPL;

public class ViewFlightsIMPL implements ViewFlights
{
	ViewFlightsRepoIMPL objFlightRepo =new ViewFlightsRepoIMPL();

	@Override
	public List<FlightsDetails> isGetAllFlightsByStartEndCity(String startcity, String endcity) {
		// TODO Auto-generated method stub
		objFlightRepo.viewAllFlightsByStartEndCity (startcity, endcity);
		
		return null;
	}
	
		
}

