package com.airline.admin.service;

import java.util.List;

import com.airline.admin.repo.CityOperationRepoIMPL;
import com.airline.entity.CitytEntity;

public class CityOperationSerIMPL implements CityOperationInte {
	CityOperationRepoIMPL Cityoprepo=new CityOperationRepoIMPL();
	@Override
	public boolean isAddStartCity(CitytEntity startCity) {
		return Cityoprepo.isAddStartCity(startCity);
	}
	@Override
	public List<CitytEntity> isGetCity() {
		
		return Cityoprepo.isGetCity();
	}
	@Override
	public boolean isUpdateCity(String oldCityName,String newCityName) {
		// TODO Auto-generated method stub
		return Cityoprepo.isUpdateCity(oldCityName,newCityName);
	}
	@Override
	public boolean isDeleted(String name) {
		// TODO Auto-generated method stub
		return Cityoprepo.isDeleted(name);
	}
	@Override
	public List<CitytEntity> isSearchCity(String name) {
		// TODO Auto-generated method stub
		return Cityoprepo.isSearchCity(name);
	}
	

}
