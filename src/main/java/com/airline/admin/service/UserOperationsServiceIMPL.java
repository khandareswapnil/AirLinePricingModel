package com.airline.admin.service;

import java.util.List;

import com.airline.admin.repo.UserOperationRepoIMPL;
import com.airline.entity.User;

public class UserOperationsServiceIMPL implements UserOperationsService {
	UserOperationRepoIMPL userOpRepo=new UserOperationRepoIMPL();
	@Override
	public boolean isAddUser(User user) {
		return userOpRepo.isAddUser(user);
	}
	@Override
	public List<User> isGetUser() {
		// TODO Auto-generated method stub
		return userOpRepo.isGetUser();
	}
	@Override
	public boolean isUpdateUser(String name,String email) {
		return userOpRepo.isUpdateUser(name,email);
	}
	@Override
	public boolean isDeleted(String email) {
		// TODO Auto-generated method stub
		return userOpRepo.isDeleted(email);
	}

	

}
