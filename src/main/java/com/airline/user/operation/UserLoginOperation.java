package com.airline.user.operation;
import java.util.*;
import com.airline.user.repo.UserLoginRepo;
import com.airlline.admin.operation.AdminPanel;
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
			System.out.println("Enter the User Name");
			 userName=sc.nextLine();
			System.out.println("Enter the Password");
			password=sc.nextLine();
			if(userName.equals("Admin") && password.equals("Admin"))
			{
				new AdminPanel().adminPanel();
			}
			
			userLogin(userName,password);
		}
		
		return uid;
	}
}
