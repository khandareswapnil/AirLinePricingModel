package com.airline.admin.repo;

import java.sql.SQLException;

import com.ariline.config.DBConfig;

public class FlightsDetailsRepoIMPL extends DBConfig implements FlightsDetailsRepo {

	@Override
	public boolean isAddFlightDetails(String fname)  {
		try
		{
			stmt=conn.prepareStatement("insert into flightsinfomaster values ('0',?)");
			stmt.setString(1, fname);
			int val=stmt.executeUpdate();
			return val > 0 ? true : false;
		}
		catch(Exception ex)
		{
			return false;

		}
		
	}

}
