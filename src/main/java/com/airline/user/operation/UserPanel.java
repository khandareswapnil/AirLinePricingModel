package com.airline.user.operation;
import java.util.*;

import com.airline.admin.repo.UserOperationRepoIMPL;
import com.airline.admin.service.CityOperationSerIMPL;
import com.airline.app.ClientAppication;
import com.airline.entity.CitytEntity;
import com.airline.entity.User;
import com.airline.entity.ViewFlightsScheduleByUser;
import com.airline.user.service.ViewFlightsIMPL;
public class UserPanel {
	public void userPanel(int uid)
	{
		int id=0;
		String name = null;
		UserOperationRepoIMPL uorp= new UserOperationRepoIMPL();
	    List<User> li = uorp.isGetUser();
	    for(User user: li) {
	    	if(uid==user.getId())
	    	{
	    		id=user.getId();
	    		name=user.getName();
	    	}
	    }
	   

	    if(id==uid)
	    {
	    	System.out.println("***********************WELCOME "+ name.toUpperCase()+" ************************\n");
			ClientAppication capp=new ClientAppication();
			Scanner sc = new Scanner(System.in);
			ViewFlightsIMPL viewFlightsServiceRef =new ViewFlightsIMPL();  // reference for view all flight service class
			CityOperationSerIMPL city =new CityOperationSerIMPL();         // reference for city operation repository class to get lists of all cities
			List<ViewFlightsScheduleByUser> list2=null;                    // created list of viewFlightsScheduleByUser entity class
			do 
			{
				System.out.println("1. View all flights");
				System.out.println("2. View all flights by start and end city");
				System.out.println("3. View all flights by start city, end city and date wise");
				System.out.println("4. For Logout");
				System.out.println("Enter your choice from above menu");
				int menu=sc.nextInt();
				sc.nextLine();
				
				switch(menu) 
				{
				case 1:
					list2=viewFlightsServiceRef.isGetAllFlights();
					System.out.println("-------------------------------------------------------------------------------------------");
					System.out.println("\nNo.\tFlight Name\tStart City\tEnd City\tDate\t\tTime\tNo OF Sits\tBase Price");
					list2.forEach(list3->System.out.println(list3.getId()+"\t"+list3.getFlightName()+"\t"+list3.getStartCity()+"\t\t"+list3.getEndCity()+"\t\t"+list3.getDate()+"\t"+list3.getTime()+"\t"+list3.getNoOfSits()+"\t"+list3.getBasePrice()));
					System.out.println("-------------------------------------------------------------------------------------------");
					System.out.println("");
					
					break;
				case 2:	
					System.out.println("");
					List<CitytEntity> list= city.isGetCity();
					list.forEach(list1->System.out.println(list1.getCityName()));
					System.out.println("\nEnter Your start city from above");
					String scity=sc.nextLine();
					System.out.println("Enter end city from above");
					String ecity=sc.nextLine();
					if(ecity.equals(scity)) 
					{
						System.out.println("Enter different city as start city and end city");
					}
					
					list2 =viewFlightsServiceRef.isGetAllFlightsByStartEndCity (scity, ecity);
					if(!list2.isEmpty()) {
						System.out.println("-------------------------------------------------------------------------------------------");
						System.out.println("\nNo.\tFlight Name\tStart City\tEnd City\tDate\t\tTime\tNo OF Sits\tBase Price");  
						list2.forEach(list3->System.out.println(list3.getId()+"\t"+list3.getFlightName()+"\t"+list3.getStartCity()+"\t\t"+list3.getEndCity()+"\t\t"+list3.getDate()+"\t"+list3.getTime()+"\t"+list3.getNoOfSits()+"\t"+list3.getBasePrice()));
						System.out.println("-------------------------------------------------------------------------------------------");
						System.out.println("");
					}
					else {
						System.out.println("No record found...\n");
					}
					
					break;
				case 3:
					System.out.println("");
					List<CitytEntity> citylist= city.isGetCity();
					citylist.forEach(list1->System.out.println(list1.getCityName()));
					System.out.println("\nEnter Your start city from above");
					String scity1=sc.nextLine();
					System.out.println("Enter end city from above");
					String ecity1=sc.nextLine();
					if(ecity1.equals(scity1)) 
					{
						System.out.println("Enter different city as start city and end city");
						break;
					}
					System.out.println("Enter the date");
					String date=sc.nextLine();
				    list2 =viewFlightsServiceRef.isGetAllFlightsByStartEndCityDate (scity1,ecity1,date );
				    if(!list2.isEmpty()) {
						System.out.println("-------------------------------------------------------------------------------------------");
				    	System.out.println("\nNo.\tFlight Name\tStart City\tEnd City\tDate\t\tTime\tNo OF Sits\tBase Price");
						list2.forEach(list3->System.out.println(list3.getId()+"\t"+list3.getFlightName()+"\t"+list3.getStartCity()+"\t\t"+list3.getEndCity()+"\t\t"+list3.getDate()+"\t"+list3.getTime()+"\t"+list3.getNoOfSits()+"\t"+list3.getBasePrice()));
						System.out.println("-------------------------------------------------------------------------------------------");
						System.out.println("");
				    }
				    else
				    {
				    	System.out.println("No record found.....");
				    }
					
					break;
				case 4:
					System.out.println("---------------------------------------------------------------------------------------------------------\n");
					capp.main(null);
					default:
						break;
						
				}
			}while(true);
	    }
	   
		
		
	}
}
