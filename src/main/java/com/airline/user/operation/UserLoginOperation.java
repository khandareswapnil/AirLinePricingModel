package com.airline.user.operation;
import java.util.*;

import com.airline.user.repo.UserLoginRepo;
public class UserLoginOperation {
	Scanner sc =new Scanner(System.in);
	public boolean userLogin()
	{
		System.out.println("Enter your email");
		String email =sc.nextLine();
		System.out.println("Enter Your Password");
		String password = sc.nextLine();
		UserLoginRepo userLoginRepo = new UserLoginRepo();
		boolean status= userLoginRepo.validateUserRepo(email,password);
		
		if(status)
		{
			return true;
		}
		else
		{
			System.out.println("Wrong username or password . please try again..");
			userLogin();
		}
		
		return true;
	}
}
