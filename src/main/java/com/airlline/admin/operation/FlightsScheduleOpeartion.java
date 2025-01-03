package com.airlline.admin.operation;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.airline.admin.service.CityOperationSerIMPL;
import com.airline.admin.service.FlightsDetailsServiceIMPL;
import com.airline.entity.CitytEntity;
import com.airline.entity.FlightsDetails;
import com.airline.entity.FlightsName;
import com.airline.entity.FlightsSeatsAndBasePrice;
import com.airline.entity.FlightsTimes;
import com.airline.entity.ViewFlightsScheduleByUser;
import com.airline.user.service.ViewFlightsIMPL;

public class FlightsScheduleOpeartion {
	Scanner sc=new Scanner(System.in);
	FlightsDetailsServiceIMPL fDetailsService=new FlightsDetailsServiceIMPL();
	CityOperationSerIMPL cityOpSer=new CityOperationSerIMPL();
	ViewFlightsIMPL viewFlightsser=new ViewFlightsIMPL();
	
	public void flightsScheduleOperation()
	{
		do {
			 System.out.println("\n============== FLIGHT SCHEDULE MENU ==============");
		       System.out.println("1. Add Flight Schedule");
		        System.out.println("2. Update Flight Schedule");
		        System.out.println("3. Delete Flight Schedule");
		        System.out.println("4. View Flight Schedule");
		        System.out.println("5. Search Flight Schedule");
		        System.out.println("6. Exit");
		        System.out.println("==================================================");
		        System.out.print("Enter your choice: ");
	
		int ch=sc.nextInt();
        System.out.println("+-------------------------------------------+");

		sc.nextLine();
		
		switch(ch)
		{
		case 1:
			System.out.println("\n--- Add Flight Schedule ---");
			System.out.println("Choose Your Starting City :");
			List<CitytEntity> list=cityOpSer.isGetCity();
			list.forEach(list1->System.out.println("- "+list1.getCityName()));
			String startCity=sc.nextLine();
			System.out.println("Choose Your Ending City");
			for(CitytEntity city:list)
			{
				 if (!city.getCityName().equalsIgnoreCase(startCity)) {
		                System.out.println("- "+city.getCityName());
			}
			}
			String endCity=sc.nextLine();
			System.out.println("Choose Flight :");
			List<FlightsName> list1=fDetailsService.isGetFlightName();
			list1.forEach(list2->System.out.println(list2.getFlightname()));
			String flname=sc.nextLine();
			System.out.println("Enter the Date (YYYY-MM-DD): ");
			String date=sc.nextLine();
			System.out.println("Choose the departure time ");
			Set<FlightsTimes> setTime=fDetailsService.isGetFLightTimes();
			setTime.forEach(set1->System.out.println(set1.getTime()));
			String time=sc.nextLine();
			System.out.println("Choose the No. of Seats and Base Price");
			List<FlightsSeatsAndBasePrice> list4=fDetailsService.isGetSeat();
			list4.forEach(list5->System.out.println(list5.getNo_OF_Seats()+"\t"+list5.getBasePrice()));
			 int seats=sc.nextInt();
			int  basePrice=sc.nextInt();
			FlightsDetails fDetails=new FlightsDetails(startCity,endCity,date,time,flname,basePrice,seats);
			boolean b=fDetailsService.isAddFlightSchedule(fDetails);
			if(b)
			{
				System.out.println("Flights Schedule Added Sucessfully !");
				
			}
			else
			{
				System.out.println("Some Problem is There");
			}
			
			break;
			
		case 2:
			System.out.println("\n--- Update Flight Schedule ---");
			System.out.println("Enter the Date");
			sc.nextLine();
			date=sc.nextLine();
			System.out.println("SR No."+"\t"+"Flight Name"+"\t"+"Start City"+"\t"+"End City"+"\t"+"Date"+"\t\t"+"Time"+"\t"+"No Of Seats"+"\t"+"Base Price(RS)");

			Set<ViewFlightsScheduleByUser> set6= viewFlightsser.viewAllFlightsByDate(date);
			set6.forEach(list7->System.out.println(list7.getId() +"\t"+list7.getFlightName()+"\t"+list7.getStartCity()+"\t\t"+list7.getEndCity()+"\t\t"+list7.getDate()+"\t"+list7.getTime()+"\t"+list7.getNoOfSits()+"\t\t"+list7.getBasePrice()));

			System.out.println("Enter The Start City");
			startCity=sc.nextLine();
			System.out.println("Enter the End City");
			endCity=sc.nextLine();
			System.out.println("Enter the Flights Name");
			String name=sc.nextLine();
			System.out.println("Enter the Time");
			setTime=fDetailsService.isGetFLightTimes();
			setTime.forEach(set1->System.out.println(set1.getTime()));
				time=sc.nextLine();

			int fsid=fDetailsService.isSearchByCityDateNameTime(startCity, endCity, name, date, time);
			if(fsid!=0)
			{
				System.out.println("Inside flight Records found....***///");
				System.out.println("Enter the New Date for Schedule");
				String newDate=sc.nextLine();
				System.out.println("Enter the New Time");
				String newTime=sc.nextLine();
				setTime=fDetailsService.isGetFLightTimes();
				int timeid=0;
				for(FlightsTimes ftime: setTime)
				{
					if((ftime.getTime()).equals(newTime))
					{
						timeid=ftime.getId();
						break;
					}
					
				}
				
				int val=fDetailsService.isUpdate(fsid, timeid);
				if(val!=0)
				{
					System.out.println("Update SucessFully");
				}
				else
				{
					System.out.println("Some Problem is There");
				}
			}else
			{
				System.out.println("No Schedule Are Present");
			}
			
			
			break;
		case 3:
			System.out.println("\n--- Delete Flight Schedule ---");
			System.out.println("Enter the Date");
			sc.nextLine();
			date=sc.nextLine();
			System.out.println("SR No."+"\t"+"Flight Name"+"\t"+"Start City"+"\t"+"End City"+"\t"+"Date"+"\t\t"+"Time"+"\t"+"No Of Seats"+"\t"+"Base Price(RS)");
			set6= viewFlightsser.viewAllFlightsByDate(date);
			set6.forEach(list7->System.out.println(list7.getId() +"\t"+list7.getFlightName()+"\t"+list7.getStartCity()+"\t\t"+list7.getEndCity()+"\t\t"+list7.getDate()+"\t"+list7.getTime()+"\t"+list7.getNoOfSits()+"\t\t"+list7.getBasePrice()));
			System.out.println("Enter The Start City");
			startCity=sc.nextLine();
			System.out.println("Enter the End City");
			endCity=sc.nextLine();
			System.out.println("Enter the Flights Name");
			name=sc.nextLine();
			System.out.println("Enter the Time");
			setTime=fDetailsService.isGetFLightTimes();
			setTime.forEach(set->System.out.println(set.getTime()));
				time=sc.nextLine();

			fsid=fDetailsService.isSearchByCityDateNameTime(startCity, endCity, name, date, time);
			if(fsid!=0)
			{
				b=fDetailsService.isDeleteSchedule(fsid);
				if(b)
				{
					System.out.println("Flights Schedule Delete SucessFully");
				}
				else
				{
					System.out.println("Some Problem is There");
				}
			}else
			{
				System.out.println("No Schedule Are Present");
			}
						
			break;
		case 4:
			System.out.println("\n--- View Flight Schedule ---");
			System.out.println("================================================================================================================");
		    System.out.printf("%-5s %-20s %-15s %-15s %-12s %-10s %-15s %-15s\n", 
		                      "SR No.", "Flight Name", "Start City", "End City", "Date", "Time", "No. of Seats", "Base Price (₹)");
		    System.out.println("================================================================================================================");
			Set<ViewFlightsScheduleByUser> flightsList= viewFlightsser.isGetAllFlights();
			int count=0;
			for(ViewFlightsScheduleByUser viewSchedule:flightsList)
			{
				++count;
				System.out.printf("%-5d %-20s %-15s %-15s %-12s %-10s %-15d %-15d\n",
                        count, 
                        viewSchedule.getFlightName(), 
                        viewSchedule.getStartCity(), 
                        viewSchedule.getEndCity(), 
                        viewSchedule.getDate(), 
                        viewSchedule.getTime(), 
                        viewSchedule.getNoOfSits(), 
                        viewSchedule.getBasePrice());
			}
			break;
		case 5:
			System.out.println("\n--- Search Flight Schedule ---");
			new SearchFlightSchedule().searchFlightSchedule();
			break;
		case 6:
			new AddFlightDetails().flightALLOperation();
			break;
			
		}
		}while(true);
	}
}
