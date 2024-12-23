package com.airlline.admin.operation;

import java.util.List;
import java.util.Scanner;

import com.airline.admin.service.CityOperationSerIMPL;
import com.airline.admin.service.FlightsDetailsServiceIMPL;
import com.airline.entity.CitytEntity;
import com.airline.entity.FlightsDetails;
import com.airline.entity.FlightsName;
import com.airline.entity.FlightsSeatsAndBasePrice;
import com.airline.entity.FlightsTimes;

public class FlightsScheduleOpeartion {
	Scanner sc=new Scanner(System.in);
	FlightsDetailsServiceIMPL fDetailsService=new FlightsDetailsServiceIMPL();
	CityOperationSerIMPL cityOpSer=new CityOperationSerIMPL();

	
	public void flightsScheduleOperation()
	{
		do {
		System.out.println("1. ADD FLIGHTS TIME");
		System.out.println("2. UPDATE FLIGHTS TIME");
		System.out.println("3. DELETE FLIGHTS TIME");
		System.out.println("4. VIEW FLIGHTS TIME");
		System.out.println("5. SEARCH FLIGHTS TIME");
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
				System.out.println("Please Enter the Enter the Information");
			}
			
			break;
		}
		}while(true);
	}
}
