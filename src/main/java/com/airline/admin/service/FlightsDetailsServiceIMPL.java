package com.airline.admin.service;

import com.airline.admin.repo.FlightsDetailsRepoIMPL;

public class FlightsDetailsServiceIMPL implements FlightsDetailsService{
	FlightsDetailsRepoIMPL fdeatilRepo=new FlightsDetailsRepoIMPL();

	@Override
	public boolean isAddFlightsDetails(String fname,int time,int no_seats,int basePrice) {
		boolean b=fdeatilRepo.isAddFlightDetails(fname,time,no_seats,basePrice);
		return b;

}
}
