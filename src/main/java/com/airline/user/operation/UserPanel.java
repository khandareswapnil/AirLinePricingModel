package com.airline.user.operation;
import java.util.*;

import com.airline.admin.service.CityOperationSerIMPL;
import com.airline.entity.CitytEntity;
import com.airline.user.service.ViewFlightsIMPL;
public class UserPanel {
	public void userPanel()
	{
		Scanner sc = new Scanner(System.in);
		int choice=1;
		do 
		{
			System.out.println("1. View all flights by start and end city");
			
			System.out.println("Enter your choice from above menu");
			int menu=sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1:
				ViewFlightsIMPL viewFlightsServiceRef =new ViewFlightsIMPL();  // reference for view all flight service class
				CityOperationSerIMPL city =new CityOperationSerIMPL();         // reference for city operation repository class to get lists of all cities
				List<CitytEntity> list= city.isGetCity();
				list.forEach(list1->System.out.println(list1.getCityName()));
				System.out.println("Enter Your start city from above");
				String scity=sc.nextLine();
				System.out.println("Enter end city from above");
				String ecity=sc.nextLine();
				if(ecity.equals(scity)) 
				{
					System.out.println("Enter different city as start city and end city");
				}
				
				viewFlightsServiceRef.isGetAllFlightsByStartEndCity (scity, ecity);
				
				
				
				
			}
		}while(choice!=0);
		
	}
}
