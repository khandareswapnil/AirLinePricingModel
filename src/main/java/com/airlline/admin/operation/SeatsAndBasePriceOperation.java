package com.airlline.admin.operation;

import java.util.Scanner;

import com.airline.admin.service.FlightsDetailsServiceIMPL;
import com.airline.entity.FlightsSeatsAndBasePrice;

public class SeatsAndBasePriceOperation {
	Scanner sc=new Scanner(System.in);
	FlightsDetailsServiceIMPL fDetailsService=new FlightsDetailsServiceIMPL();
	public void seatAndBasePriceOperation() {
 
		do
		{
			System.out.println("1. ADD BASE PRICE AND NO OF SEATS ");
			System.out.println("2. UPDATE BASE PRICE AND NO OF SEATS");
			System.out.println("3. DELETE BASE PRICE AND NO OF SEATS");
			System.out.println("4. VIEW BASE PRICE AND NO OF SEATS");
			System.out.println("5. SEARCH BASE PRICE AND NO OF SEATS");
			System.out.println("6. FOR EXIT");
		
			System.out.println("Enter the Choice");
			int ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				System.out.println("Enter the Flights Seats");
				sc.nextLine();
				int seats=sc.nextInt();
				System.out.println("Enter the Base Price");
				int basePrice=sc.nextInt();
				FlightsSeatsAndBasePrice fSABP=new FlightsSeatsAndBasePrice(seats,basePrice);
				boolean b=fDetailsService.isAddSeatAndBasePrice(fSABP);
				if(b)
				{
					System.out.println("Flights Seats Added Sucess..................");
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
