package com.airline.admin.service;

import com.airline.admin.repo.FlightsDetailsRepoIMPL;

public class FlightsDetailsServiceIMPL implements FlightsDetailsService{
	FlightsDetailsRepoIMPL fdeatilRepo=new FlightsDetailsRepoIMPL();

	@Override
	public boolean isAddFlightsDetails(String fname) {
		boolean b=fdeatilRepo.isAddFlightDetails(fname);
		return b;

}
}
