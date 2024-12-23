package com.airlline.admin.operation;

import java.util.Scanner;

import com.airline.admin.service.FlightsDetailsServiceIMPL;
import com.airline.entity.FlightsName;

public class FlightsNameOperation {
	Scanner sc=new Scanner(System.in);
	FlightsDetailsServiceIMPL fDetailsService=new FlightsDetailsServiceIMPL();

	public String flightsNameOperation()
	{
		do {
			System.out.println("1. ADD FLIGHTS NAME");
			System.out.println("2. UPDATE FLIGHTS NAME");
			System.out.println("3. DELETE FLIGHTS NAME");
			System.out.println("4. VIEW FLIGHTS NAME");
			System.out.println("5. SEARCH FLIGHTS NAME");
			System.out.println("6. FOR EXIT");
		
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
			}
			
		}while(true);
		
	}

}
