package com.airlline.admin.operation;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.airline.entity.ViewFlightsScheduleByUser;
import com.airline.user.service.ViewFlightsIMPL;

public class SearchFlightSchedule {
	Scanner sc=new Scanner(System.in);
	ViewFlightsIMPL viewFlight=new ViewFlightsIMPL();
	Set<ViewFlightsScheduleByUser> set=null;
	public void searchFlightSchedule()
	{
		do
		{
			System.out.println("1. BY CITY NAME");
			System.out.println("2. DATE AND TIME");
			System.out.println("3. FOR EXIT");
			System.out.println("ENTER THE CHOICE");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Enter the Start City");
				sc.nextLine();
				String startCity=sc.nextLine();
				System.out.println("Enter the End City");
				String endCity=sc.nextLine();
				set=viewFlight.isGetAllFlightsByStartEndCity(startCity, endCity);
				if(!set.isEmpty())
				{
				System.out.println("SR No."+"\t"+"Flight Name"+"\t"+"Start City"+"\t"+"End City"+"\t"+"Date"+"\t\t"+"Time"+"\t"+"No Of Seats"+"\t"+"Base Price(RS)");
				set.forEach(set1->System.out.println(set1.getId() +"\t"+set1.getFlightName()+"\t"+set1.getStartCity()+"\t\t"+set1.getEndCity()+"\t\t"+set1.getDate()+"\t"+set1.getTime()+"\t"+set1.getNoOfSits()+"\t\t"+set1.getBasePrice()));
				}else
				{
					System.out.println("No Search Found");
				}
				break;
			case 2:
				System.out.println("Enter the Start City");
				sc.nextLine();
				 startCity=sc.nextLine();
				System.out.println("Enter the End City");
				endCity=sc.nextLine();
				System.out.println("Enter the Date");
				String date=sc.nextLine();
				set=viewFlight.isGetAllFlightsByStartEndCityDate(startCity, endCity,date);
				if(!set.isEmpty())
				{
				System.out.println("SR No."+"\t"+"Flight Name"+"\t"+"Start City"+"\t"+"End City"+"\t"+"Date"+"\t\t"+"Time"+"\t"+"No Of Seats"+"\t"+"Base Price(RS)");
				set.forEach(set1->System.out.println(set1.getId() +"\t"+set1.getFlightName()+"\t"+set1.getStartCity()+"\t\t"+set1.getEndCity()+"\t\t"+set1.getDate()+"\t"+set1.getTime()+"\t"+set1.getNoOfSits()+"\t\t"+set1.getBasePrice()));
				}else
				{
					System.out.println("No Search Found");
				}
				break;
			case 3:
				new FlightsScheduleOpeartion().flightsScheduleOperation();
				break;
				default:
					System.out.println("Invalid Input");
			}
		}while(true);
	}

}
