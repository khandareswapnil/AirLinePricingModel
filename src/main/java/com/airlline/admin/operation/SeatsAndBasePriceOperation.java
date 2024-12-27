package com.airlline.admin.operation;

import java.util.List;
import java.util.Scanner;

import com.airline.admin.service.FlightsDetailsServiceIMPL;
import com.airline.entity.FlightsSeatsAndBasePrice;

public class SeatsAndBasePriceOperation {
	Scanner sc=new Scanner(System.in);
	FlightsDetailsServiceIMPL fDetailsService=new FlightsDetailsServiceIMPL();
	List<FlightsSeatsAndBasePrice> list;
	public void seatAndBasePriceOperation() {
 
		do
		{
			System.out.println("1. ADD Base Price And No Of Seats ");
			System.out.println("2. Update Base Price Of No Of Seats");
			System.out.println("3. Delete Base Price And No Of Seats Record");
			System.out.println("4. View Base Price And No Of Seats");
			System.out.println("5. Search Base Price And No Of Seats");
			System.out.println("6. For BACK");
			System.out.println("7. For HOME PAGE Menu");
		
			System.out.println("Enter the Choice");
			int ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				System.out.println("Enter the Flights Seats");
				sc.nextLine();
				int seats=sc.nextInt();
				System.out.println("Enter the Base Price(RS)");
				int basePrice=sc.nextInt();
				FlightsSeatsAndBasePrice fSABP=new FlightsSeatsAndBasePrice(seats,basePrice);
				list=fDetailsService.isSearchSeatAndBasePriceExists(fSABP);
				if(list.isEmpty()) {
					boolean b=fDetailsService.isAddSeatAndBasePrice(fSABP);
					if(b)
					{
						System.out.println("Flights Seats Added Sucessfully..................\n");
					}
					else
					{
						System.out.println("Some Problem is There..................\n");
					}
				}
				else {
					System.out.println("Record already present...\n");
				}
				
				break;
			case 2:
				System.out.println("Enter the Flights Total Seats");
				sc.nextLine();
				seats=sc.nextInt();
			    fSABP=new FlightsSeatsAndBasePrice(seats,0);   // passing 0 bqz there is no need of this parameter
			    list=fDetailsService.isSearchSeatAndBasePriceExists(fSABP);
				if(!list.isEmpty()) {
					System.out.println("Enter updated base price");
					int bprice=sc.nextInt();
					boolean b=fDetailsService.isUpdateSeatAndBasePriceRecord(seats,bprice);
					if(b)
					{
						System.out.println("Flights Base Price Updated Sucessfully..................\n");
					}
					else
					{
						System.out.println("Some Problem is There..................\n");
					}
					
				}
				else {
					System.out.println("Record not found. Cant't Update.......\n");
				}
				break;
			case 3:
				System.out.println("Enter the Flights Total No Of Seats For Delete Record");
				sc.nextLine();
				seats=sc.nextInt();
			    fSABP=new FlightsSeatsAndBasePrice(seats,0);   // passing 0 bqz there is no need of this parameter
			    list=fDetailsService.isSearchSeatAndBasePriceExists(fSABP);
				if(!list.isEmpty()) {
					boolean b=fDetailsService.isDeleteSeatAndBasePriceRecord(seats);
					if(b)
					{
						System.out.println("Flights No OF Seats - Basse Price Record Deleted Sucess..................\n");
					}
					else
					{
						System.out.println("Some Problem is There..................\n");
					}
				}
				else {
					System.out.println("Record not found. Cant't Delete.........\n");
				}
				break;

			case 4:
				list=fDetailsService.isViewALlSeatAndBasePriceRecords();
				if(!list.isEmpty()) {
					System.out.println("-------------------------------------------------------------------------------------------");
					System.out.println("No Of Sits\tBase Price(RS)");
					for(FlightsSeatsAndBasePrice el: list)
					{
						System.out.println(el.getNo_OF_Seats()+"\t\t"+el.getBasePrice());
					}
					System.out.println("-------------------------------------------------------------------------------------------");
					System.out.println("");
				}
				else {
					System.out.println("No record found..\n");
				}
                break;
				
			case 5:
				System.out.println("Enter the Flights Seats");
				sc.nextLine();
			    seats=sc.nextInt();
				System.out.println("Enter the Base Price");
				basePrice=sc.nextInt();
				fSABP=new FlightsSeatsAndBasePrice(seats,basePrice);
				list=fDetailsService.isSearchSeatAndBasePriceExists(fSABP);
				if(!list.isEmpty()) {
					System.out.println("Record found....\n");
					System.out.println("-------------------------------------------------------------------------------------------");
					System.out.println("No Of Sits\tBase Price");
					for(FlightsSeatsAndBasePrice el: list)
					{
						System.out.println(el.getNo_OF_Seats()+"\t\t"+el.getBasePrice());
					}
					System.out.println("-------------------------------------------------------------------------------------------");
					System.out.println();
				}
				else {
					System.out.println("Record Not present ...........\n");
				}
				
				break;
			case 6:
				new AddFlightDetails().flightALLOperation();
				break;
			case 7:
				new AdminPanel().adminPanel();
				break;
			}
		}while(true);
	}

}
