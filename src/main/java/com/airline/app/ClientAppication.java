package com.airline.app;
import java.util.*;
import com.airline.service.UserService;
import com.airline.entity.User;
public class ClientAppication {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Admin admin=new Admin();
		AdminPanel adPanel=new AdminPanel();

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
					System.out.println("Please Enter the Correct UserName And Password");
					admin.adminInfo();
				}
				break;
			case 2:
				UserService us =new UserService();
				UserPanel up = new UserPanel();
				System.out.println("\n1. FOR NEW USER REGISTER FIRST");
				System.out.println("2. CONTINUE LOGIN..");
				System.out.println("Enter the choice");
				int num =sc.nextInt();
				sc.nextLine();
				
				if (num==1)
				{     
				        boolean status =us.registerUser(); 
				        if(status)
				        	up.userpanel();
				        	
				}
				else if(num==2)
				{
					
						boolean status= us.loginUser();
						if(status)
						{
							up.userpanel();
						}
				}
				break;
			case 3:
				System.exit(0);
				default :
					System.out.println("Invalid Input");
			}
			
		}while(true);
	}

}
