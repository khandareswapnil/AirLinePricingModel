package com.airline.admin.repo;

import java.sql.SQLException;

import com.ariline.config.DBConfig;

public class FlightsDetailsRepoIMPL extends DBConfig implements FlightsDetailsRepo {

	@Override
	public boolean isAddFlightDetails(String fname,int time,int no_seats,int basePrice)  {
		try
		{
			
			csmt =conn.prepareCall("call FlightsTimeSeats(?,?,?,?)");
			csmt.setString(1, fname);
			csmt.setInt(2, time);
			csmt.setInt(3, no_seats);
			csmt.setInt(4, basePrice);
			
			boolean result=csmt.execute();
			if(!result)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		catch(Exception ex)
		{
			return false;

		}
		
		
	}

}
