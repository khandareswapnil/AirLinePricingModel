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
	

}
