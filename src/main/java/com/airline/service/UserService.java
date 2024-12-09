package com.airline.service;
import com.airline.entity.User;
import com.airline.reposiroty.UserRepo;
public class UserService {

	private UserRepo user_repo = new UserRepo();
	
	
	// Register a new user
	public boolean registerUser(User user)
	{
		user_repo.registerUser(user);
		return true;
	}
	
	// method for login user 
	public boolean loginUser (String email, String password)
	{
		return user_repo.validateUser(email, password);
	}
}
