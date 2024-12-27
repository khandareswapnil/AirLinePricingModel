package com.airline.user.operation;
import java.util.*;

import com.airline.admin.service.UserOperationsServiceIMPL;
import com.airline.app.ClientAppication;
import com.airline.email.verify.OTPGenerator;
import com.airline.entity.OTP;
import com.airline.entity.User;
import com.airline.user.repo.UserRegistrationRepo;

public class UserRegistrationOperation {
	Scanner sc =new Scanner(System.in);
	UserOperationsServiceIMPL userOpSer=new UserOperationsServiceIMPL();
	List<User> userList;
	List<OTP> list=null;
	public int registerUser()
	{

		int uid=0;
		int flag=0;
		System.out.println("\n--- REGISTER ---");
		 System.out.println("Please Enter Your Email: ");
		    String email = sc.nextLine();
        userList=userOpSer.isGetUser();
        for(User user:userList)
        {
        	if(user.getEmail().equals(email)) {
            	flag=1;
            	break;
        	}
        }
        if(flag==0)
        {
        	 OTPGenerator otpGen=new OTPGenerator();
             list=otpGen.otpGenerator(email);
             list.forEach(list1->System.out.println(list1.getMeassage()));
             System.out.println("Enter the OTP :");
             int otp=sc.nextInt();
             int verifyOTP=0;
             for(OTP otp1:list)
             {
             	verifyOTP=otp1.getOtp();
             }
             if(verifyOTP==otp)
             {  System.out.println("OTP Verified! Provide the following details for registration:");
             	System.out.println("Provide following details for registration");
         		System.out.println("Enter Name : ");
         		sc.nextLine();
                 String name = sc.nextLine();
                 
                 System.out.println ("Enter Contact Number: ");
                 String contact = sc.nextLine();
                 
                 System.out.println("Enter Gender(Male/Female/Other): ");
                 String gender = sc.nextLine();
                 
                 System.out.println("Enter Your City): ");
                 String city = sc.nextLine();
                 
                 System.out.println("Enter password");
                 String password= sc.nextLine();
                 
                 User myUser = new User(0,name,email,contact,gender,city,password); 
                 UserOperationsServiceIMPL userOpService=new UserOperationsServiceIMPL();
                 
                 boolean status = userOpService.isAddUser(myUser);
                 
                 if(status)
                 {
                 	System.out.println("Registration Successful ! Login now.");
                 	new ClientAppication().main(null);
                 	
                 }
                 else
                 {
                 	System.out.println("Registration failed ! Please try again.");
                 	registerUser();
                 }
                
             }
             else {
            	 System.out.println("Invalid OTP. Registration failed.");
             }
        }
        else
        {
        	System.out.println("Email Are Already Present. Plese Login");
        }
       
        return uid;
		
        
        
		
	
	
		
	}
}
