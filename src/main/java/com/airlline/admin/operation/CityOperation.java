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
				List<CitytEntity> list =null;
				System.out.println("Enter the City Name");
				sc.nextLine();
				String cityName=sc.nextLine();
				cityEntity.setCityName(cityName);
				list=startCityService.isSearchCity(cityName);
				if(list.isEmpty())
				{
					boolean b=startCityService.isAddStartCity(cityEntity);
					if(b)
					{
						System.out.println("City Added Sucess");
					}
					else
					{
						System.out.println("Some Problem is there........");
					}
				}
				else
				{
					System.out.println("City Already Present");
				}
				
				break;
			case 2:
				List<CitytEntity> list1=new ArrayList<>();
				list=startCityService.isGetCity();
				if(list.isEmpty())
				{
					System.out.println("No City Present");

			
				}else
				{
					System.out.println("City Name");
					list.forEach(list2->System.out.println(list2.getCityName()));
				}
				
				break;
			case 3:
				System.out.println("Enter the Old City Name");
				sc.nextLine();
				 String oldCityName=sc.nextLine();
				 List<CitytEntity> cityList=startCityService.isSearchCity(oldCityName);
				 if(!cityList.isEmpty())
				 {
					 System.out.println("Enter the New City Name");
						String newCityName=sc.nextLine();
						boolean b=startCityService.isUpdateCity(oldCityName,newCityName);
						if(b)
						{
							System.out.println("City Name Update Sucess");
						}
						else
						{
							System.out.println("Some Problem Is There.............");
						}
				 }
				 else
				 {
					 System.out.println("City Not Found");
				 }

				break;
			case 4:
				 //List<CitytEntity> deleteCityList=null;
				System.out.println("Enter the Old City Name");
				sc.nextLine();
				 cityName=sc.nextLine();
				 List<CitytEntity>  deleteCityList=startCityService.isSearchCity(cityName);
				 if(!deleteCityList.isEmpty())
				 {
						boolean b=startCityService.isDeleted(cityName);
						 if(b)
						 {
							 System.out.println("Deleted Sucess");
						 }
						 else
						 {
							 System.out.println("we are in if of delete block");
						 }
				 }
				 else
				 {
					 System.out.println("City Not Found");
				 }

			
				break;
			case 5:
				System.out.println("Enter the City Name");
				sc.nextLine();
				cityName=sc.nextLine();
				
				 list=startCityService.isSearchCity(cityName);
				 if(!list.isEmpty())
				 {
				 list.forEach(list2->System.out.println(list2.getCityName()));
				 }else
				 {
					 System.out.println("City Not Found");
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
