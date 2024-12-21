package com.airline.user.operation;
import java.util.*;

import com.airline.admin.service.UserOperationsServiceIMPL;
import com.airline.entity.User;
import com.airline.user.repo.UserRegistrationRepo;

public class UserRegistrationOperation {
	Scanner sc =new Scanner(System.in);
	
	public boolean registerUser()
	{

		System.out.println("Provide following details for registration");
		System.out.println("Enter Name: ");
        String name = sc.nextLine();
        
        System.out.println("Enter Email: ");
        String email = sc.nextLine();
        
        System.out.println ("Enter Contact Number: ");
        String contact = sc.nextLine();
        
        System.out.println("Enter Gender(Male/Female/Other): ");
        String gender = sc.nextLine();
        
        System.out.println("Enter Your City): ");
        String city = sc.nextLine();
        
        System.out.println("Enter password");
        String password= sc.nextLine();
        
        User myUser = new User(name,email,contact,gender,city,password); 
        UserOperationsServiceIMPL userOpService=new UserOperationsServiceIMPL();
        
        boolean status = userOpService.isAddUser(myUser);
        
        if(status)
        {
        	System.out.println("Registration Successful ! Login now.");
        	
        	// for login after registration
        	UserLoginOperation userloginOperation = new UserLoginOperation();
        	boolean loginSuccess = userloginOperation.userLogin();      //method call for login
        	return loginSuccess;
        }
        else
        {
        	System.out.println("Registration failed ! Please try again.");
        	registerUser();
        }
	
	return true;
		
	}
}
