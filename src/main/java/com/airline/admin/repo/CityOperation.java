package com.airline.admin.repo;

import java.util.List;

import com.airline.entity.CitytEntity;

public interface CityOperation {
	public boolean isAddStartCity(CitytEntity City);
	public List<CitytEntity> isGetCity();
	public boolean isUpdateCity(String oldCityName,String newCityName);
	public boolean isDeleted(String name);
	public List<CitytEntity> isSearchCity(String name);

	

}
