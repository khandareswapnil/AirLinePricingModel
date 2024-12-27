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
	public void flightALLOperation()
	{
		do {
	        System.out.println("==================================================");
			System.out.println("1. Flights Name Operations");
			System.out.println("2. Flights Times Operations");
			System.out.println("3. Distance Of Two Cities Operations");
			System.out.println("4. Flight Seats And Base Price Operations");
			System.out.println("5. Flights Schedule Operations");
			System.out.println("6. Exit");
	        System.out.println("==================================================");


			System.out.println("Enter the Choice");
			int ch=sc.nextInt();
	        System.out.println("+-------------------------------------------+");
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
