package com.airlline.admin.operation;

import java.util.Scanner;
import java.util.Set;

import com.airline.admin.service.FlightsDetailsServiceIMPL;
import com.airline.entity.FlightsTimes;

public class FlightsTimeOperation {
	Scanner sc=new Scanner(System.in);
	FlightsDetailsServiceIMPL fDetailsService=new FlightsDetailsServiceIMPL();

	public String flightsTimeOperation()
	{
		do
		{
			System.out.println("1. ADD FLIGHTS TIME");
			System.out.println("2. VIEW FLIGHTS TIME");
			System.out.println("3. FOR EXIT");
		
			System.out.println("Enter the Choice");
			int ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				System.out.println("Enter the Flights Timing");
				sc.nextLine();
				String ftime=sc.nextLine();
				FlightsTimes fgtime=new FlightsTimes(0,ftime);
				boolean b=fDetailsService.isAddTime(fgtime);
				if(b)
				{
					System.out.println("Flights Times Added Sucess..................");
				}
				else
				{
					System.out.println("Some Problem is There..................");

				}
				break;
			case 2:
				Set<FlightsTimes> timeSet=fDetailsService.isGetFLightTimes();
				timeSet.forEach(timeSet1->System.out.println(timeSet1.getTime()));
				
				break;
			case 3:
				new AddFlightDetails().flightALLOperation();
				break;
				default:
					System.out.println("Invalid Input");
			}
		}while(true);
	}
}
