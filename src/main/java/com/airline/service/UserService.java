package com.airline.service;
import java.util.*;
import com.airline.entity.User;
import com.airline.reposiroty.UserRepo;
public class UserService {

	private UserRepo user_repo = new UserRepo();
	
	Scanner sc = new Scanner (System.in);
	
	// Register a new user
	public boolean registerUser()
	{
		
			System.out.println("Provide following details for registration");
			System.out.print("Enter Name: ");
	        String name = sc.nextLine();
	        
	        System.out.print("Enter Email: ");
	        String email = sc.nextLine();
	        
	        System.out.print("Enter Contact Number: ");
	        String contact = sc.nextLine();
	        
	        System.out.print("Enter Gender (Male/Female/Other): ");
	        String gender = sc.nextLine();
	        
	        System.out.print("Enter Password: ");
	        String password = sc.nextLine();
	        
	        User myUser = new User(0,name,email,contact,gender,password); 
	        boolean status =user_repo.registerUser(myUser);
	        if(status)
	        {
	        	System.out.println("Registration Successful ! Login now.");
	        	boolean loginSuccess = loginUser();      //method call for login
	        	return loginSuccess;
	        }
	        else
	        {
	        	System.out.println("Registration failed ! Please try again.");
	        	registerUser();
	        }
		
		return true;
	}
	
	// method for login user 
	public boolean loginUser ()
	{
		System.out.println("Enter your email");
		String email =sc.nextLine();
		System.out.println("Enter Your Password");
		String password = sc.nextLine();
		
		boolean status= user_repo.validateUser(email, password);
		if(status)
		{
			return true;
		}
		else
		{
			System.out.println("Wrong username or password . please try again..");
			loginUser();
		}
		
		return true;
	}
}
