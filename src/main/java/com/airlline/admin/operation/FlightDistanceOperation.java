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
	List<AddDistanceOfCity> li;          //list to store Two Cities Distance record 

	public void flightDistanceOperation()
	{
		do
		{
			System.out.println("1. ADD DISTANCE OF TWO CITIES");
			System.out.println("2. UPDATE DISTANCE OF TWO CITIES");
			System.out.println("3. DELETE DISTANCE OF TWO CITIES");
			System.out.println("4. VIEW ALL RECORDS OF DISTANCE OF TWO CITIES");
			System.out.println("5. SEARCH RECORD OF DISTANCE OF TWO CITIES PRESENT?");
			System.out.println("6. FOR HOME PAGE");
			System.out.println("7. FOR EXIT");

		
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
				li=fDetailsService.isSearchCityDistRecord(startCity,endCity);
				if(li==null) {
					System.out.println("Enter the Distance");
					int dis=sc.nextInt();
					AddDistanceOfCity addDistance=new AddDistanceOfCity(startCity,endCity,dis);
					boolean b=fDetailsService.isAddDistance(addDistance);
					if(b)
					{
						System.out.println("City Distance added Sucess..................\n");
					}
					else
					{
						System.out.println("Entered Cities is not in the database ..................\n");

					}
				}
				else {
					System.out.println("These cities Not Present In Database ....\n");			
					}
				
				break;
			case 2:
				System.out.println("Enter Your Starting City");
				list=cityOpSer.isGetCity();
				list.forEach(list1->System.out.println(list1.getCityName()));
				sc.nextLine();
				startCity=sc.nextLine();
				System.out.println("Enter Your Ending City");
				for(CitytEntity city:list)
				{
					 if (!city.getCityName().equalsIgnoreCase(startCity)) {
			                System.out.println(city.getCityName());
				}
				}
				
				endCity=sc.nextLine();
				li=fDetailsService.isSearchCityDistRecord(startCity,endCity);
				if(li!=null) {
					System.out.println("Enter Updated Distance");
					int dist=sc.nextInt();
					if(fDetailsService.isUpdateCityDistRecord(startCity,endCity,dist)) {
						System.out.println("Distance Updated Successfully...\n");
					}
					else {
						System.out.println("There is some problem\n");
					}
				}
				else
					System.out.println("These Cities Distance Record Is Not Present..\n");
				break;
			case 3:
				System.out.println("Enter Your Starting City");
				list=cityOpSer.isGetCity();
				list.forEach(list1->System.out.println(list1.getCityName()));
				sc.nextLine();
				startCity=sc.nextLine();
				System.out.println("Enter Your Ending City");
				for(CitytEntity city:list)
				{
					 if (!city.getCityName().equalsIgnoreCase(startCity)) {
			                System.out.println(city.getCityName());
				}
				}
				
				endCity=sc.nextLine();
				li=fDetailsService.isSearchCityDistRecord(startCity,endCity);
				if(li!=null) {
					
					if(fDetailsService.isDeleteCityDistRecord(startCity,endCity)) {
						System.out.println("Record Deleted Successfully...\n");
					}
					else {
						System.out.println("There is some problem...\n");
					}
				}
				else
					System.out.println("These Cities Distance Record Is Not Present..\n");
				break;
			case 4:
				 li=fDetailsService.isViewAllDistanceRecords();
				if(li!=null) {
					System.out.println("Record Present In Database..\n");
					System.out.println("Start City\tEnd City\tDistance");
					for(AddDistanceOfCity e: li) {	
						System.out.println(e.getScity()+"\t\t"+e.getEcity()+"\t\t"+e.getDistance());
					}
					System.out.println();
				}
				else {
					System.out.println("Record Not Present\n");
				}
				break;
			case 5:
				System.out.println("Enter Your Starting City");
				list=cityOpSer.isGetCity();
				list.forEach(list1->System.out.println(list1.getCityName()));
				sc.nextLine();
				startCity=sc.nextLine();
				System.out.println("Enter Your Ending City");
				for(CitytEntity city:list)
				{
					 if (!city.getCityName().equalsIgnoreCase(startCity)) {
			                System.out.println(city.getCityName());
				}
				}
				
				endCity=sc.nextLine();
				 li=fDetailsService.isSearchCityDistRecord(startCity,endCity);
				if(li!=null) {
					System.out.println("Record Present In Database..\n");
					System.out.println("Start City\tEnd City\tDistance");
					for(AddDistanceOfCity e: li) {	
						System.out.println(e.getScity()+"\t\t"+e.getEcity()+"\t\t"+e.getDistance());
					}
					System.out.println();
				}
				else {
					System.out.println("These Cities Distance Record Not Present in Database.. \n");
				}
				
				break;
			case 6:
				new AdminPanel().adminPanel(); 
				break;
			default: System.exit(0);
					
				
			}
		}while(true);
	}
}
