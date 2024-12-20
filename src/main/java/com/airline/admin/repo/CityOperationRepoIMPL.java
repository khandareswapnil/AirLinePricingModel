package com.airline.admin.repo;

import java.util.ArrayList;
import java.util.List;

import com.airline.entity.CitytEntity;
import com.ariline.config.DBConfig;

public class CityOperationRepoIMPL extends DBConfig implements CityOperation {
	CitytEntity city=new CitytEntity();
	@Override
	public boolean isAddStartCity(CitytEntity city) {
		try {
			stmt=conn.prepareStatement("insert into startcitymaster values('0',?)");
			stmt.setString(1, city.getCityName());
			int val=stmt.executeUpdate();
			return val>0?true:false;
			
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
			
		}
		return false;
	}

	@Override
	public List<CitytEntity> isGetCity() {
		List<CitytEntity> list=new ArrayList();
		try {
			stmt=conn.prepareStatement("select * from citymaster");
			 rs=stmt.executeQuery();
			 if(rs.next())
			 {
				 city.setCityName(rs.getString(2));
				 list.add(city) ;
			 }
			 return list;
			
			
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return null;
	}

}
