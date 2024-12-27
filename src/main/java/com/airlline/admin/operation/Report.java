package com.airlline.admin.operation;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.airline.admin.service.FlightsDetailsServiceIMPL;
import com.airline.entity.ViewBookingDetails;
import com.airline.entity.ViewFlightsScheduleByUser;
import com.airline.user.service.BookingService;
import com.airline.user.service.ViewFlightsIMPL;

public class Report {
	Scanner sc=new Scanner(System.in);
	ViewFlightsIMPL viewFlightsser=new ViewFlightsIMPL();
	FlightsDetailsServiceIMPL fDetailsService=new FlightsDetailsServiceIMPL();
	BookingService bookService=new BookingService();

	public void report()
	{
		do {
			System.out.println("1. Total Schedule Availble");
			System.out.println("2. Booking User");
			System.out.println("3. Most Frequent User");
			System.out.println("4. For Exit");
			System.out.println("Enter the Choice");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("SR No."+"\t"+"Flight Name"+"\t"+"Start City"+"\t"+"End City"+"\t"+"Date"+"\t\t"+"Time"+"\t"+"No Of Seats"+"\t"+"Base Price(RS)");
				Set<ViewFlightsScheduleByUser> flightsList= viewFlightsser.isGetAllFlights();
				int count=0;
				for(ViewFlightsScheduleByUser viewSchedule:flightsList)
				{
					++count;
					System.out.println(count+"\t\t"+viewSchedule.getFlightName()+"\t\t"+viewSchedule.getStartCity()+"\t\t"+viewSchedule.getEndCity()+"\t\t"+viewSchedule.getDate()+"\t\t"+viewSchedule.getTime()+"\t\t"+viewSchedule.getNoOfSits()+"\t\t"+viewSchedule.getBasePrice());
				}
				System.out.println("Total Flight Schedule Availble "+count);
				break;
			case 2:
				ViewBooking viewBook=new ViewBooking();
				viewBook.viewBookingDetails();
				break;
			case 3:
				String name=bookService.getMaxUser();
				System.out.println("The Most Frequent User " +name);
				break;
			case 4:
				new AdminPanel().adminPanel();
				break;
				default:
					System.out.println("Invalid Input");
			}
			
			
		}while(true);
	}

}
