package com.airlline.admin.operation;

import java.util.List;
import java.util.Scanner;

import com.airline.admin.service.CityOperationSerIMPL;
import com.airline.admin.service.FlightsDetailsServiceIMPL;
import com.airline.entity.AddDistanceOfCity;
import com.airline.entity.CitytEntity;
import com.airline.entity.FlightsDetails;
import com.airline.entity.FlightsName;
import com.airline.entity.FlightsSeatsAndBasePrice;
import com.airline.entity.FlightsTimes;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class AddFlightDetails {
	Scanner sc=new Scanner(System.in);
	public void isDistanceOFCities()
	{
		do {
			System.out.println("1. FLIGHTS NAME ");
			System.out.println("2. FLIGHTS TIME");
			System.out.println("3. CITY DISTANCE");
			System.out.println("4. SEATS AND BASE PRICE");
			System.out.println("5. FLIGHTS SCHEDULE");
			System.out.println("6. FOR EXIT");
			System.out.println("Enter the Choice");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				
				FlightsNameOperation flightsNameOp=new FlightsNameOperation();
				flightsNameOp.flightsNameOperation();
				break;
			case 2:
				FlightsTimeOperation flightTimeOp=new FlightsTimeOperation();
				flightTimeOp.flightsTimeOperation();
				break;
			case 3:
				FlightDistanceOperation flightsDisOpe=new FlightDistanceOperation();
				flightsDisOpe.flightDistanceOperation();
				break;
					
			case 4:
				SeatsAndBasePriceOperation seatandbaseprice=new SeatsAndBasePriceOperation();
				seatandbaseprice.seatAndBasePriceOperation();
				break;
			case 5:
				FlightsScheduleOpeartion flightScheOp=new FlightsScheduleOpeartion();
				flightScheOp.flightsScheduleOperation();
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
