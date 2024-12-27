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
			System.out.println("=============================================");
		    System.out.println("        WELCOME TO SKY AIRLINE          ");
		    System.out.println("=============================================");
		    
		    System.out.println("\n------------- MAIN MENU -------------");
	        System.out.println("1. Login");
	        System.out.println("2. Register");
	        System.out.println("-------------------------------------");
	        System.out.print("Enter your choice (1-2): ");
			int ch=sc.nextInt();
			sc.nextLine();
			switch(ch)
			{
			case 1:
				System.out.println("\n--- LOGIN ---");
                System.out.print("Enter Username: ");
                String userName = sc.nextLine();
                System.out.print("Enter Password: ");
                String password = sc.nextLine();
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
