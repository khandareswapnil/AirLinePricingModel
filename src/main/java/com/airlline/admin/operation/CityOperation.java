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
				System.out.println("City Name");
				list.forEach(list1->System.out.println(cityEntity.getCityName()));
				
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
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
