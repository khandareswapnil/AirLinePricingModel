package com.airlline.admin.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.airline.admin.service.CityOperationSerIMPL;
import com.airline.entity.CitytEntity;

public class CityOperation {
	Scanner sc=new Scanner(System.in);
	CitytEntity cityEntity=new CitytEntity();
	CityOperationSerIMPL startCityService=new CityOperationSerIMPL();
	
	public void addStartCity(){
		do {
			System.out.println("1. Add City");
			System.out.println("2. View City");
			System.out.println("3. Update City");
			System.out.println("4. Delete City");
			System.out.println("5. Search City");
			System.out.println("6. For Exit");
			System.out.println("Enter the Choice");
			int ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				System.out.println("Enter the City Name");
				sc.nextLine();
				String cityName=sc.nextLine();
				cityEntity.setCityName(cityName);;
				boolean b=startCityService.isAddStartCity(cityEntity);
				if(b)
				{
					System.out.println("City Added Sucess");
				}
				else
				{
					System.out.println("Some Problem is there........");
				}
				break;
			case 2:
				List<CitytEntity> list=new ArrayList<>();
				list=startCityService.isGetCity();
				if(list.isEmpty())
				{
					System.out.println("No City Present");

			
				}else
				{
					System.out.println("City Name");
					list.forEach(list1->System.out.println(list1.getCityName()));
				}
				
				break;
			case 3:
				System.out.println("Enter the Old City Name");
				sc.nextLine();
				 String oldCityName=sc.nextLine();
				 System.out.println("Enter the New City Name");
					sc.nextLine();
					String newCityName=sc.nextLine();
				 
				 
				b=startCityService.isUpdateCity(oldCityName,newCityName);
				if(b)
				{
					System.out.println("City Name Update Sucess");
				}
				else
				{
					System.out.println("Some Problem Is There.............");
				}
				break;
			case 4:
				System.out.println("Enter the Old City Name");
				sc.nextLine();
				 cityName=sc.nextLine();
				 b=startCityService.isDeleted(cityName);
				 if(b)
				 {
					 System.out.println("Deleted Sucess");
				 }
				 else
				 {
					 System.out.println("Some Problem is There");
				 }
				break;
			case 5:
				System.out.println("Enter the City Name");
				sc.nextLine();
				cityName=sc.nextLine();
				
				 list=startCityService.isSearchCity(cityName);
				 list.forEach(list1->System.out.println(list1.getCityName()));
				break;
			case 6:
				System.exit(6);
				break;
				default:
					System.out.println("Invalid Input");
			}
			
			
			
		}while(true);
	}

}
