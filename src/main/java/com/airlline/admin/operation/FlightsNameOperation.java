package com.airlline.admin.operation;

import java.util.List;
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
				List<FlightsName> list =fDetailsService.isSearchName(fgname);
				if(list!=null)
				{
					System.out.println("Flights Are Alredy Present.........");
				}
				else
				{
					boolean b=fDetailsService.isFlightsName(fgname);
					if(b)
					{
						System.out.println("Flights Added Sucesss..........");
						break;
					}
					
				}
				
				
				break;
			case 2:
				System.out.println("Enter the Flights Name");
				sc.nextLine();
				fname=sc.nextLine();
				fgname=new FlightsName(fname);
				List<FlightsName> list1=fDetailsService.isSearchName(fgname);
				if(list1==null)
				{
					System.out.println("This Flights Are Not Present.........");

				}
				else
				{
					System.out.println("Enter the New Name");
					String newName=sc.nextLine();
					boolean b=fDetailsService.isUpdate(fname, newName);
					if(b==true)
					{
						System.out.println("Flight Name Update Sucessfully...............");
					}
				}
				
				
				
				break;
			case 3:
				System.out.println("Enter the Flights Name");
				sc.nextLine();
				 fname=sc.nextLine();
				fgname=new FlightsName(fname);
				 list =fDetailsService.isSearchName(fgname);
				if(list!=null)
				{
					boolean b=fDetailsService.isDeleteFlight(fgname);
					if(b==true)
					{
						System.out.println("Flights Deleted Sucess............");
						break;
					}
				}
				else
				{
					System.out.println("Flight Are Not Present..............");
					
				}
				break;
			case 4:
				list=fDetailsService.isGetFlightName();
				System.out.println("***** Flight Names *****");
				list.forEach(list2->System.out.println(list2.getFlightname()));
				System.out.println("************************");
				break;
			case 5:
				System.out.println("Enter the Flights Name");
				sc.nextLine();
				fname=sc.nextLine();
				
				fgname=new FlightsName(fname);
				list=fDetailsService.isSearchName(fgname);
				if(list!=null)
				{
					list.forEach(list5->System.out.println(list5.getFlightname()));
				}
				break;
			case 6:
				break;
				default : 
					System.out.println("Invalid Input");
			}
			
		}while(true);
		
	}

}
