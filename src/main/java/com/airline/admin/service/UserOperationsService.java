package com.airline.admin.service;

import java.util.List;

import com.airline.entity.User;

public interface UserOperationsService {
	public boolean isAddUser(User user);
	public List<User> isGetUser();
	public boolean isUpdateUser(String name,String email);
	public boolean isDeleted(String email);
	public List<User> isSearchByName(String name);
	public List<User> isSearchByCityName(String cityName);


}
