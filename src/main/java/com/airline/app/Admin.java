package com.airline.app;
import java.util.*;
public class Admin {
	
	public boolean adminInfo()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the User Name");
		String username=sc.nextLine();
		System.out.println("Enter the Password");
		String pass=sc.nextLine();
		
		if((username.equals("Admin"))&&(pass.equals("Admin")))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
}
