package com.airlline.admin.operation;

import java.util.List;
import java.util.Scanner;

import com.airline.admin.service.CityOperationSerIMPL;
import com.airline.admin.service.FlightsDetailsServiceIMPL;
import com.airline.entity.AddDistanceOfCity;
import com.airline.entity.CitytEntity;
import com.airline.entity.FlightsDetails;
import com.airline.entity.FlightsName;
import com.airline.entity.FlightsSeatsAndBasePrice;
import com.airline.entity.FlightsTimes;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class AddFlightDetails {
	CityOperationSerIMPL cityOpSer=new CityOperationSerIMPL();
	FlightsDetailsServiceIMPL fDetailsService=new FlightsDetailsServiceIMPL();
	Scanner sc=new Scanner(System.in);
	public void isDistanceOFCities()
	{
		do {
			System.out.println("1. Flights Name");
			System.out.println("2. Flights Times");
			System.out.println("3. Add Distance");
			System.out.println("4. Add Seats And Base Price");
			System.out.println("5. Add Flights Schedule");
			System.out.println("6. FOR Exit");
			System.out.println("Enter the Choice");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Enter the Flights Name");
				sc.nextLine();
				String fname=sc.nextLine();
				FlightsName fgname=new FlightsName(fname);
				boolean b=fDetailsService.isFlightsName(fgname);
				if(b)
				{
					System.out.println("Flights Added Sucess..................");
				}
				else
				{
					System.out.println("Some Problem is There..................");

				}
				break;
			case 2:
				System.out.println("Enter the Flights Timing");
				sc.nextLine();
				String ftime=sc.nextLine();
				FlightsTimes fgtime=new FlightsTimes(ftime);
				b=fDetailsService.isAddTime(fgtime);
				if(b)
				{
					System.out.println("Flights Times Added Sucess..................");
				}
				else
				{
					System.out.println("Some Problem is There..................");

				}
				break;
			case 3:
				
				System.out.println("Enter Your Starting City");
				List<CitytEntity> list=cityOpSer.isGetCity();
				list.forEach(list1->System.out.println(list1.getCityName()));
				sc.nextLine();
				String startCity=sc.nextLine();
				System.out.println("Enter Your Ending City");
				for(CitytEntity city:list)
				{
					 if (!city.getCityName().equalsIgnoreCase(startCity)) {
			                System.out.println(city.getCityName());
				}
				}
				
				String endCity=sc.nextLine();
				System.out.println("Enter the Distance");
				int dis=sc.nextInt();
				AddDistanceOfCity addDistance=new AddDistanceOfCity(dis);
				b=fDetailsService.isAddDistance(addDistance,startCity,endCity);
				if(b)
				{
					System.out.println("City Distance added Sucess..................");
				}
				else
				{
					System.out.println("Some Problem is There..................");

				}
				break;
					
			case 4:
				System.out.println("Enter the Flights Seats");
				sc.nextLine();
				int seats=sc.nextInt();
				System.out.println("Enter the Base Price");
				int basePrice=sc.nextInt();
				FlightsSeatsAndBasePrice fSABP=new FlightsSeatsAndBasePrice(seats,basePrice);
				b=fDetailsService.isAddSeatAndBasePrice(fSABP);
				if(b)
				{
					System.out.println("Flights Seats Added Sucess..................");
				}
				else
				{
					System.out.println("Some Problem is There..................");
				}
				break;
			case 5:
				System.out.println("Choose Your Starting City");
				 list=cityOpSer.isGetCity();
				list.forEach(list1->System.out.println(list1.getCityName()));
				sc.nextLine();
				 startCity=sc.nextLine();
				System.out.println("Choose Your Ending City");
				for(CitytEntity city:list)
				{
					 if (!city.getCityName().equalsIgnoreCase(startCity)) {
			                System.out.println(city.getCityName());
				}
				}
				endCity=sc.nextLine();
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
				 seats=sc.nextInt();
				 basePrice=sc.nextInt();
				FlightsDetails fDetails=new FlightsDetails(startCity,endCity,date,time,flname,basePrice,seats);
				b=fDetailsService.isAddFlightSchedule(fDetails);
				if(b)
				{
					System.out.println("Flights Schedule Added Sucess");
				}
				else
				{
					System.out.println("Please Enter the Enter the Information");
				}
				
					
				break;
			case 6:
				AdminPanel adminPanel=new AdminPanel();
				adminPanel.adminPanel();
				break;
				
				default:
					System.out.println("Invalid Input");
				
			}

		}while(true);
		
		
		
		
	}

}
