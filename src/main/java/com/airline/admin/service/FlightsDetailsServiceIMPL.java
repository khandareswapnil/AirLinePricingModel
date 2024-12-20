package com.airline.admin.service;

import java.util.List;

import com.airline.admin.repo.FlightsDetailsRepoImpl;
import com.airline.entity.AddDistanceOfCity;
import com.airline.entity.FlightsDetails;
import com.airline.entity.FlightsName;
import com.airline.entity.FlightsSeatsAndBasePrice;
import com.airline.entity.FlightsTimes;

public class FlightsDetailsServiceIMPL implements FlightsDetailsService
{
	FlightsDetailsRepoImpl fDetailsRepo=new FlightsDetailsRepoImpl();

	@Override
	public boolean isFlightsName(FlightsName fname) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isFlightsName(fname);
	}

	@Override
	public boolean isAddTime(FlightsTimes fTime) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isAddTime(fTime);
	}

	@Override
	public boolean isAddSeatAndBasePrice(FlightsSeatsAndBasePrice fSABP) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isAddSeatAndBasePrice(fSABP);
	}

	@Override
	public boolean isAddDistance(AddDistanceOfCity addDistnace,String startCity,String endCity) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isAddDistance(addDistnace,startCity,endCity);
	}

	@Override
	public List<FlightsName> isGetFlightName() {
		return fDetailsRepo.isGetFlightName();
	}

	@Override
	public List<FlightsTimes> isGetTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightsSeatsAndBasePrice> isGetSeat() {
		// TODO Auto-generated method stub
		return null;
	}

}
	
	
	




