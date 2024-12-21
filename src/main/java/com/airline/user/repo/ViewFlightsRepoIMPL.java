package com.airline.user.repo;
import java.util.*;

import com.ariline.config.DBConfig;
public class ViewFlightsRepoIMPL extends DBConfig implements ViewFlightsRepo{

	@Override
	public boolean viewAllFlightsByStartEndCity(String scity, String ecity) {
		// TODO Auto-generated method stub
		try {
			int startCityId=0;
			int endCityId=0;
			stmt=conn.prepareStatement("select * from CityMaster where cityName=?");
			stmt.setString(1,scity);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				startCityId=rs.getInt(1);
				if(startCityId!=0)
				{
					stmt=conn.prepareStatement("select *from cityMaster where cityName=?");
					stmt.setString(1, ecity);
					rs=stmt.executeQuery();
					if(rs.next())
					{
						endCityId=rs.getInt(1);
					}
				}
			
			}
			else System.out.println("Provide correct input");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		return false;
	}

}
