package com.airline.admin.service;

import java.util.List;

import com.airline.entity.CitytEntity;

public interface CityOperationInte {
	public boolean isAddStartCity(CitytEntity startCity);
	public List<CitytEntity> isGetCity();
	public boolean isUpdateCity(String oldCityName,String newCityName);
	public boolean isDeleted(String name);
	public List<CitytEntity> isSearchCity(String name);


}
