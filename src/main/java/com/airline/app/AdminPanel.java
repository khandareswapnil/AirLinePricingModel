package com.airline.app;
import java.util.*;

import com.airline.admin.service.FlightsDetailsServiceIMPL;




public class AdminPanel {
	
	public void adminPanel()
	{
		ClientAppication clintApp=new ClientAppication();
		FlightsDetailsServiceIMPL fdetailsservice=new FlightsDetailsServiceIMPL();
		Scanner sc=new Scanner(System.in);
		System.out.println("WELOCME TO ADMIN PANEL");
		System.out.println("****************************************");
		do
		{
			System.out.println("1.View Users");			
			System.out.println("2.View Booking");
			System.out.println("3. Add Flights Details");
			System.out.println("Enter the Choice");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				
				break;
			case 2:
				break;
			case 3:
				System.out.println("ENTER THE NAME OF FLIGHTS");
				sc.nextLine();
				String fname=sc.nextLine();
				System.out.println("Enter the Time Of Flights");
				int time=sc.nextInt();
				System.out.println("Enter the No Of Seats");
				int no_seats=sc.nextInt();
				System.out.println("Enter the Base Price for Per KM");
				int basePrice=sc.nextInt();
				
				boolean b=fdetailsservice.isAddFlightsDetails(fname,time,no_seats,basePrice);
				if(b)
				{
					System.out.println("Flights Details Added Sucess");
				}
				else
				{
					System.out.println("Some Problem Is There in Add Flights Repository");
				}
				break;
			case 4:
				clintApp.main(null);
				break;
				default:
					System.out.println("Invalid Input");
			}
		}while(true);
		
	}
}
