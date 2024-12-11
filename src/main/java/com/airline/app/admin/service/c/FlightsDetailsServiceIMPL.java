package com.airline.app.admin.service.c;

import com.airline.app.admin.repo.copy.FlightsDetailsRepoIMPL;

public class FlightsDetailsServiceIMPL implements FlightsDetails {
	FlightsDetailsRepoIMPL fdeatilRepo=new FlightsDetailsRepoIMPL();
	@Override
	public boolean isAddFlightsDetails(String fname) {
		boolean b=fdeatilRepo.isAddFlightDetails(fname);
		return b;
	}

}
