package com.airlline.admin.operation;

import java.util.List;
import java.util.Scanner;

import com.airline.admin.service.CityOperationSerIMPL;
import com.airline.admin.service.FlightsDetailsServiceIMPL;
import com.airline.entity.AddDistanceOfCity;
import com.airline.entity.CitytEntity;

public class FlightDistanceOperation {
	Scanner sc=new Scanner(System.in);
	FlightsDetailsServiceIMPL fDetailsService=new FlightsDetailsServiceIMPL();
	CityOperationSerIMPL cityOpSer=new CityOperationSerIMPL();

	public void flightDistanceOperation()
	{
		do
		{
			System.out.println("1. ADD DISTANCE OF TWO CITIES");
			System.out.println("2. UPDATE DISTANCE OF TWO CITIES");
			System.out.println("3. DELETE DISTANCE OF TWO CITIES");
			System.out.println("4. VIEW DISTANCE OF TWO CITIES");
			System.out.println("5. SEARCH DISTANCE OF TWO CITIES");
			System.out.println("6. FOR EXIT");
		
			System.out.println("Enter the Choice");
			int ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
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
				boolean b=fDetailsService.isAddDistance(addDistance,startCity,endCity);
				if(b)
				{
					System.out.println("City Distance added Sucess..................");
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
