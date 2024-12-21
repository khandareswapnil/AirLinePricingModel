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
			System.out.println("1. ADMIN LOGIN");
			System.out.println("2. USER LOGIN");
			System.out.println("Enter the Choice");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				boolean b=admin.adminInfo();
				if(b)
				{
					adPanel.adminPanel();
				}
				else
				{
					System.out.println("Enter the Correct UserName and Password");
					admin.adminInfo();
				}
				break;
			case 2:
				System.out.println("\n1. FOR NEW USER REGISTER FIRST");
				System.out.println("2. CONTINUE LOGIN..");
				System.out.println("Enter the choice");
				int num =sc.nextInt();
				sc.nextLine();
				
				if (num==1)
				{       UserRegistrationOperation ur= new UserRegistrationOperation();
				        boolean status =ur.registerUser(); 
				        if(status)
				        	up.userPanel();
				        	
				}
				else if(num==2)
				{
						UserLoginOperation ul = new UserLoginOperation();
						boolean status= ul.userLogin();
						if(status)
						{
							up.userPanel();
						}
				}


				break;
			case 3:
				System.exit(0);
				default :
					System.out.println("InValid Input");
			}
			
		}while(true);
	}

}
