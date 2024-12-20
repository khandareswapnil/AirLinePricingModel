package com.airline.admin.repo;

import java.sql.SQLException;
import java.util.List;

import com.airline.entity.CitytEntity;
import com.airline.entity.User;

public interface UserOperationRepo {
	public boolean isAddUser(User user);
	public List<User> isGetUser();
	public boolean isUpdateUser(String name,String email);
	public boolean isDeleted(String email);
	public List<User> isSearchByName(String name);
	public List<User> isSearchByCityName(String cityName);

}
