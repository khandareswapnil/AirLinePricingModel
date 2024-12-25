package com.airline.user.operation;
import java.util.*;

import com.airline.app.ClientAppication;
import com.airline.user.repo.UserLoginRepo;
public class UserLoginOperation {
	Scanner sc =new Scanner(System.in);
	public int userLogin(String userName,String password)
	{
		
		
		UserLoginRepo userLoginRepo = new UserLoginRepo();
		int uid= userLoginRepo.validateUserRepo(userName,password);
		
		if(uid!=0)
		{
			return uid;
		}
		else
		{
			System.out.println("Wrong username or password . please try again..");
			new ClientAppication().main(null);
		}
		
		return uid;
	}
}
