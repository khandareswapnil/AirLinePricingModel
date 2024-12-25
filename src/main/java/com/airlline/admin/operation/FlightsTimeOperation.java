package com.airlline.admin.operation;

import java.util.Scanner;

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
			}
		}while(true);
	}
}
