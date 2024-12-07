package com.airline.app;
import java.util.*;
public class AdminPanel {
	
	public void adminPanel()
	{
		ClientAppication clintApp=new ClientAppication();
		Scanner sc=new Scanner(System.in);
		System.out.println("WELOCME TO ADMIN PANEL");
		System.out.println("****************************************");
		do
		{
			System.out.println("1.View Users");			
			System.out.println("2.View Booking");
			System.out.println("Enter the Choice");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				break;
			case 2:
				break;
			case 3:
				clintApp.main(null);
				break;
				default:
					System.out.println("Invalid Input");
			}
		}while(true);
		
	}
}
