package com.airline.admin.service;

import java.util.List;
import java.util.Set;

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
	public boolean isAddDistance(AddDistanceOfCity addDistnace) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isAddDistance(addDistnace);
	}

	@Override
	public List<FlightsName> isGetFlightName() {
		return fDetailsRepo.isGetFlightName();
	}

	@Override
	public List<FlightsTimes> isGetTime() {
		// TODO Auto-generated method stub
		return fDetailsRepo.isGetTime();
	}

	@Override
	public List<FlightsSeatsAndBasePrice> isGetSeat() {
		
		return fDetailsRepo.isGetSeat();
	}

	@Override
	public boolean isAddFlightSchedule(FlightsDetails fDetails) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isAddFlightSchedule(fDetails);
	}

	@Override
	public int isUpdateFlightsName() {
		// TODO Auto-generated method stub
		return fDetailsRepo.isUpdateFlightsName();
	}

	@Override
	public List<FlightsName> isSearchName(FlightsName fname) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isSearchName(fname);
	}

	@Override
	public boolean isUpdate(String fname, String newName) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isUpdate(fname, newName);
	}

	@Override
	public boolean isDeleteFlight(FlightsName fname) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isDeleteFlight(fname);
	}

	@Override
	public List<AddDistanceOfCity> isSearchCityDistRecord(String startCity, String endCity) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isSearchCityDistRecord(startCity,endCity);
	}

	@Override
	public List<AddDistanceOfCity> isViewAllDistanceRecords() {
		// TODO Auto-generated method stub
		return fDetailsRepo.isViewAllDistanceRecords();
	}

	@Override
	public boolean isUpdateCityDistRecord(String startCity, String endCity, int dist) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isUpdateCityDistRecord(startCity, endCity, dist);
	}

	@Override
	public boolean isDeleteCityDistRecord(String startCity, String endCity) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isDeleteCityDistRecord(startCity,endCity);
	}

	@Override
	public List<FlightsSeatsAndBasePrice> isSearchSeatAndBasePriceExists(FlightsSeatsAndBasePrice fSABP) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isSearchSeatAndBasePriceExists(fSABP);
	}

	@Override
	public List<FlightsSeatsAndBasePrice> isViewALlSeatAndBasePriceRecords() {
		// TODO Auto-generated method stub
		return fDetailsRepo.isViewALlSeatAndBasePriceRecords();
	}

	@Override
	public boolean isUpdateSeatAndBasePriceRecord(int noOfSits,int bprice) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isUpdateSeatAndBasePriceRecord(noOfSits,bprice);
	}

	@Override
	public boolean isDeleteSeatAndBasePriceRecord(int seats) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isDeleteSeatAndBasePriceRecord(seats);
	}

	@Override
	public boolean isUpdateFlightsDetaisl(FlightsDetails fDetails) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isUpdateFlightsDetaisl(fDetails);
	}

	@Override
	public int isSearchByCityDateNameTime(String startCity, String endCity, String fname, String date, String time) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isSearchByCityDateNameTime(startCity, endCity, fname, date, time);
	}

	@Override
	public int isUpdate(int fsid, int tid) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isUpdate(fsid, tid);
	}

	@Override
	public boolean isDeleteSchedule(int fsid) {
		// TODO Auto-generated method stub
		return fDetailsRepo.isDeleteSchedule(fsid);
	}

	@Override
	public Set<FlightsTimes> isGetFLightTimes() {
		// TODO Auto-generated method stub
		return fDetailsRepo.isGetFLightTimes();
	}


	
	

	

}
	
	
	




