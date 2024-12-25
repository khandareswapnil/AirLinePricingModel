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
		System.out.println("1. ADD FLIGHT SCHEDULE");
		System.out.println("2. UPDATE FLIGHT SCHEDULE");
		System.out.println("3. DELETE FLIGHT SCHEDULE");
		System.out.println("4. VIEW FLIGHT SCHEDULE");
		System.out.println("5. SEARCH FLIGHT SCHEDULE");
		System.out.println("6. FOR EXIT");
	
		System.out.println("Enter the Choice");
		int ch=sc.nextInt();
		
		switch(ch)
		{
		case 1:
			System.out.println("Choose Your Starting City");
			List<CitytEntity> list=cityOpSer.isGetCity();
			list.forEach(list1->System.out.println(list1.getCityName()));
			sc.nextLine();
			 String startCity=sc.nextLine();
			System.out.println("Choose Your Ending City");
			for(CitytEntity city:list)
			{
				 if (!city.getCityName().equalsIgnoreCase(startCity)) {
		                System.out.println(city.getCityName());
			}
			}
			String endCity=sc.nextLine();
			System.out.println("Choose Flight");
			List<FlightsName> list1=fDetailsService.isGetFlightName();
			list1.forEach(list2->System.out.println(list2.getFlightname()));
			String flname=sc.nextLine();
			System.out.println("Enter the Date ");
			String date=sc.nextLine();
			System.out.println("Enter the departure time ");
			List<FlightsTimes> list2=fDetailsService.isGetTime();
			list2.forEach(list3->System.out.println(list3.getTime()));
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
				System.out.println("Flights Schedule Added Sucess");
			}
			else
			{
				System.out.println("Some Problem is There");
			}
			
			break;
			
		case 2:
			System.out.println("Enter the Date");
			sc.nextLine();
			 date=sc.nextLine();
			System.out.println("SR No."+"\t"+"Flight Name"+"\t"+"Start City"+"\t"+"End City"+"\t"+"Date"+"\t\t"+"Time"+"\t"+"No Of Seats"+"\t"+"Base Price(RS)");

			Set<ViewFlightsScheduleByUser> set6= viewFlightsser.viewAllFlightsByDate(date);
			list6.forEach(list7->System.out.println(list7.getId() +"\t"+list7.getFlightName()+"\t"+list7.getStartCity()+"\t\t"+list7.getEndCity()+"\t\t"+list7.getDate()+"\t"+list7.getTime()+"\t"+list7.getNoOfSits()+"\t\t"+list7.getBasePrice()));
			System.out.println("Enter the New Date");
			date=sc.nextLine();
			System.out.println("Enter Time");
			List<FlightsTimes> list3=fDetailsService.isGetTime();
			list3.forEach(list5->System.out.println(list5.getTime()));
			time=sc.nextLine();
			for(ViewFlightsScheduleByUser updateSchedule:list6)
			{
			 fDetails=new FlightsDetails(updateSchedule.getStartCity(),updateSchedule.getEndCity(),date,time,updateSchedule.getFlightName(),updateSchedule.getBasePrice(),updateSchedule.getNoOfSits());
			  b=fDetailsService.isUpdateFlightsDetaisl(fDetails);
				if(b)
				{
					System.out.println("Flights Schedule Update Sucess");
				}
				else
				{
					System.out.println("Please Enter the Information");
				}
			}


			
			break;
		case 3:
			System.out.println("Enter the Date");
			date=sc.nextLine();
			list6= viewFlightsser.viewAllFlightsByDate(date);
			list6.forEach(list7->System.out.println(list7.getId() +"\t"+list7.getFlightName()+"\t"+list7.getStartCity()+"\t\t"+list7.getEndCity()+"\t\t"+list7.getDate()+"\t"+list7.getTime()+"\t"+list7.getNoOfSits()+"\t\t"+list7.getBasePrice()));
			System.out.println("Enter the Time");
			time=sc.nextLine();
			System.out.println("Enter the Start City");
			startCity=sc.nextLine();
			System.out.println("Enter the End City");
			endCity=sc.nextLine();
			
			
			
			break;
		case 4:
			System.out.println("SR No."+"\t"+"Flight Name"+"\t"+"Start City"+"\t"+"End City"+"\t"+"Date"+"\t\t"+"Time"+"\t"+"No Of Seats"+"\t"+"Base Price(RS)");
			List<ViewFlightsScheduleByUser> flightsList= viewFlightsser.isGetAllFlights();
			flightsList.forEach(flightsList3->System.out.println(flightsList3.getId() +"\t"+flightsList3.getFlightName()+"\t"+flightsList3.getStartCity()+"\t\t"+flightsList3.getEndCity()+"\t\t"+flightsList3.getDate()+"\t"+flightsList3.getTime()+"\t"+flightsList3.getNoOfSits()+"\t\t"+flightsList3.getBasePrice()));
			break;
		case 5:
			new SearchFlightSchedule().searchFlightSchedule();
			break;
		case 6:
			new AddFlightDetails().flightALLOperation();
			break;
			
		}
		}while(true);
	}
}
