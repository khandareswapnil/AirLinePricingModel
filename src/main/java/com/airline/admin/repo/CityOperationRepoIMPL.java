package com.airline.admin.repo;

import java.util.ArrayList;
import java.util.List;

import com.airline.entity.CitytEntity;
import com.ariline.config.DBConfig;

public class CityOperationRepoIMPL extends DBConfig implements CityOperation {
	@Override
	public boolean isAddStartCity(CitytEntity city) {
		try {
			stmt = conn.prepareStatement("insert into citymaster values('0',?)");
			stmt.setString(1, city.getCityName());
			int val = stmt.executeUpdate();
			return val > 0 ? true : false;

		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return false;
	}

	@Override
	public List<CitytEntity> isGetCity() {
		List<CitytEntity> list = new ArrayList();

		try {
			stmt = conn.prepareStatement("select * from citymaster");
			rs = stmt.executeQuery();

			while (rs.next()) {
				CitytEntity city = new CitytEntity();

				city.setCityName(rs.getString(2));

				list.add(city);

			}
			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isUpdateCity(String oldCityName,String newCityName) {
		try {
			int cid=0;
			System.out.println(newCityName);
			stmt=conn.prepareStatement("select cityid from citymaster where cityname=?");
			stmt.setString(1, oldCityName);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				cid=rs.getInt("cityid");
				stmt=conn.prepareStatement("update citymaster set cityname=? where cityid=?");
				stmt.setString(1, newCityName);
				stmt.setInt(2, cid);
				int val=stmt.executeUpdate();
				return val>0?true:false;			
				}
					
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isDeleted(String name) {
		try {
			stmt=conn.prepareStatement("delete from citymaster where cityname=?");
			stmt.setString(1, name);
			int val=stmt.executeUpdate();
			return val>0?true:false;
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<CitytEntity> isSearchCity(String name) {
		try {
			List<CitytEntity> list=new ArrayList<>();
			stmt=conn.prepareStatement("select * from citymaster where cityname=?");
			stmt.setString(1, name);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				CitytEntity city=new CitytEntity();
				city.setCityName(rs.getString(2));
				list.add(city);
			}
			return list;
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

}
