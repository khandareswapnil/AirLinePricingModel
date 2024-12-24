package com.airline.app;
import java.util.*;

import com.airlline.admin.operation.Admin;
import com.airlline.admin.operation.AdminPanel;
import com.airline.user.operation.UserPanel;
import com.airline.user.operation.UserLoginOperation;
import com.airline.user.operation.UserRegistrationOperation;
public class ClientAppication {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Admin admin=new Admin();
		AdminPanel adPanel=new AdminPanel();
		UserPanel up = new UserPanel();

		do
		{
			System.out.println("******** WELCOME TO NANA CHI AIRLINE ******** ");
			System.out.println("1. Login");
			System.out.println("2. Register");

			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Enter the User Name");
				sc.nextLine();
				String userName=sc.nextLine();
				System.out.println("Enter the Password");
				String password=sc.nextLine();
				
				if(userName.equals("Admin") && password.equals("Admin"))
				{
					adPanel.adminPanel();
				}
				else
				{
					UserLoginOperation ul = new UserLoginOperation();
					int uid= ul.userLogin(userName,password);
					if(uid!=0)
					{
						up.userPanel(uid);
					}
				}
				
				break;
			case 2:
				     UserRegistrationOperation ur= new UserRegistrationOperation();
				        int uid =ur.registerUser(); 
				        if(uid!=0)
				        	up.userPanel(uid);
				        	
				


				break;
			case 3:
				System.exit(0);
				default :
					System.out.println("InValid Input");
			}
			
		}while(true);
	}

}
