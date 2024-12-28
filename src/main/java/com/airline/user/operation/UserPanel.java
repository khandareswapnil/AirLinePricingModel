package com.airline.user.operation;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.airline.admin.repo.FlightsDetailsRepoImpl;
import com.airline.admin.repo.UserOperationRepoIMPL;
import com.airline.admin.service.CityOperationSerIMPL;
import com.airline.admin.service.FlightsDetailsServiceIMPL;
import com.airline.admin.service.UserOperationsService;
import com.airline.admin.service.UserOperationsServiceIMPL;
import com.airline.app.ClientAppication;
import com.airline.email.verify.OTPGenerator;
import com.airline.entity.AddDistanceOfCity;
import com.airline.entity.CitytEntity;
import com.airline.entity.Seat;
import com.airline.entity.User;
import com.airline.entity.ViewBookingDetails;
import com.airline.entity.ViewFlightsScheduleByUser;
import com.airline.user.repo.UserHistory;
import com.airline.user.service.BookingService;
import com.airline.user.service.ViewFlightsIMPL;
public class UserPanel {
	FlightsDetailsServiceIMPL fDetailsService=new FlightsDetailsServiceIMPL();
	 UserOperationsService userOpService=new UserOperationsServiceIMPL();


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
	    	 System.out.println("======================================================");
	    	    System.out.println("*********************** WELCOME " + name.toUpperCase() + " ************************");
	    	    System.out.println("======================================================\n");

			ClientAppication capp=new ClientAppication();
			Scanner sc = new Scanner(System.in);
			
			ViewFlightsIMPL viewFlightsServiceRef =new ViewFlightsIMPL();  // reference for view all flight service class
			CityOperationSerIMPL city =new CityOperationSerIMPL();         // reference for city operation repository class to get lists of all cities
			Set<ViewFlightsScheduleByUser> set2=null;                    // created tree set of viewFlightsScheduleByUser entity class
			BookingService bs =new BookingService();                     // Booking Service class object
			FlightsDetailsRepoImpl fdrepo =new FlightsDetailsRepoImpl();   //admin repo reference for getting fsid
			
			do 
			{
				    System.out.println("======================================================");
				    System.out.println("1. View All Flights");
				    System.out.println("2. View Flights by Start and End City");
				    System.out.println("3. View Flights by Start City, End City, and Date");
				    System.out.println("4. Ticket Booking");
				    System.out.println("5. View Booking History");
				    System.out.println("6. Logout");
				    System.out.println("======================================================");
				    System.out.print("Enter your choice: ");
				    int menu = sc.nextInt();
				    sc.nextLine(); 
				
				int count = 0;
				switch(menu) 
				{
				case 1:

				    System.out.println("\n======================================================");
				    System.out.println("                   AVAILABLE FLIGHTS                  ");
				    System.out.println("======================================================");
				    System.out.printf("%-5s %-20s %-15s %-15s %-15s %-10s %-10s\n ", 
				                      "No.", "Flight Name", "Start City", "End City", 
				                      "Date", "Time", "Seats");
				    System.out.println("---------------------------------------------------------------------------------------");

				    set2 = viewFlightsServiceRef.isGetAllFlights(); // Fetch all flights

				    if (set2.isEmpty()) {
				        System.out.println("No flights available at the moment.");
				    } else {
				         count = 0;
				        for (ViewFlightsScheduleByUser viewSchedule : set2) {
				        	if (!viewSchedule.getDate().isBefore(LocalDate.now())) {
				        		++count;
					            System.out.printf("%-5d %-20s %-15s %-15s %-15s %-10s %-10d\n", 
					                              count,
					                              viewSchedule.getFlightName(),
					                              viewSchedule.getStartCity(),
					                              viewSchedule.getEndCity(),
					                              viewSchedule.getDate(),
					                              viewSchedule.getTime(),
					                              viewSchedule.getNoOfSits());
				        	}
				            
				                             
				        }
				    }

				    System.out.println("-----------------------------------------------------------------------------------------");
				    System.out.println();
				    break;


				case 2:	
					System.out.println("\nAvailable Cities:");
					System.out.println("-------------------------------------------------");

					// Display city names
					List<CitytEntity> list = city.isGetCity();
					list.forEach(list1 -> System.out.println(" - " + list1.getCityName()));

					System.out.println("\nEnter your start city from the above list:");
					String scity = sc.nextLine();

					System.out.println("Enter your end city from the above list:");
					String ecity = sc.nextLine();
					System.out.println("");
					if(ecity.equals(scity)) 
					{
						System.out.println("Enter different city as start city and end city");
					}
					
					
					set2 =viewFlightsServiceRef.isGetAllFlightsByStartEndCity (scity, ecity);
					if(!set2.isEmpty()) {
						System.out.println("\n======================================================");
					    System.out.println("                   AVAILABLE FLIGHTS                  ");
					    System.out.println("======================================================");
					    System.out.println("No.\tFlight Name\tStart City\tEnd City\tDate\t\tTime\t\tNo. of Seats");
					    System.out.println("-------------------------------------------------------------------------------------------------------");
					    count=0;
						for(ViewFlightsScheduleByUser viewSchedule:set2) {
							if (!viewSchedule.getDate().isBefore(LocalDate.now())) {

								++count;
								 System.out.println(
								            count + "\t" +
								            viewSchedule.getFlightName() + "\t" +
								            viewSchedule.getStartCity() + "\t\t" +
								            viewSchedule.getEndCity() + "\t\t" +
								            viewSchedule.getDate() + "\t" +
								            viewSchedule.getTime() + "\t\t" +
								            viewSchedule.getNoOfSits() + "\t\t" 
								        );						}
							System.out.println("-------------------------------------------------------------------------------------------------------");
							System.out.println("");
							}
							

					}
					else {
						System.out.println("No record found...\n");
					}
					
					break;
				case 3:
					System.out.println("\nAvailable Cities:");
					System.out.println("-------------------------------------------------");
					List<CitytEntity> citylist= city.isGetCity();
					citylist.forEach(list1->System.out.println(" - " + list1.getCityName()));
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

					System.out.println("");

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		            LocalDate parsedDate = LocalDate.parse(date, formatter);

					if (!parsedDate.isBefore(LocalDate.now()))
					{

					set2 =viewFlightsServiceRef.isGetAllFlightsByStartEndCityDate (scity1,ecity1,date );
				    if(!set2.isEmpty()) {
				    	System.out.println("\n======================================================");
					    System.out.println("                   AVAILABLE FLIGHTS                  ");
					    System.out.println("======================================================");
				    	System.out.println("No.\tFlight Name     \tStart City     \tEnd City       \tDate        \tTime     \tNo. of Seats");
				    	System.out.println("----------------------------------------------------------------------------------------------------------");
				    	count=0;
						for(ViewFlightsScheduleByUser viewSchedule:set2) {
							if (!viewSchedule.getDate().isBefore(LocalDate.now())) {
								++count;
								System.out.printf("%-3d\t%-16s\t%-15s\t%-15s\t%-12s\t%-10s\t%-10d\n",
								        count, 
								        viewSchedule.getFlightName(), 
								        viewSchedule.getStartCity(), 
								        viewSchedule.getEndCity(), 
								        viewSchedule.getDate(), 
								        viewSchedule.getTime(), 
								        viewSchedule.getNoOfSits()
								    );
							}
							System.out.println("----------------------------------------------------------------------------------------------------------");
							System.out.println("");
							}
							
				    }
				    else
				    {
				    	System.out.println("No record found.....");
				    }
					}else
					{
						System.out.println("Please Enter the Correct Date");
					}
					
					break;
				case 4:
					System.out.println("\nAvailable Cities:");
					System.out.println("-------------------------------------------------");
					citylist= city.isGetCity();
					citylist.forEach(list1->System.out.println(" - " + list1.getCityName()));
					System.out.println("\nEnter Your start city from above");
					scity1=sc.nextLine();
					System.out.println("Enter end city from above");
					ecity1=sc.nextLine();
					if(ecity1.equals(scity1)) 
					{
						System.out.println("Enter different city as start city and end city");
						break;
					}
					System.out.println("Enter the date");
					date=sc.nextLine();
			        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		            LocalDate parsedDate1 = LocalDate.parse(date, formatter1);

					if (!parsedDate1.isBefore(LocalDate.now()))
					{
					set2 =viewFlightsServiceRef.isGetAllFlightsByStartEndCityDate (scity1,ecity1,date );
					int finalPrice=0;
					LocalTime time=null;
					String fname=null;
					if (!set2.isEmpty()) {
						System.out.println("\n======================================================");
					    System.out.println("                   AVAILABLE FLIGHTS                  ");
					    System.out.println("======================================================");
					    System.out.println(String.format("%-4s %-15s %-15s %-12s %-12s %-12s %-10s %-12s %-12s", 
					                                     "No.", "Flight Num", "Flight Name", "Start City", "End City", 
					                                     "Date", "Time", "No Of Sits", "Price"));
					    System.out.println("--------------------------------------------------------------------------------------------------------");

					    count = 0;
					    List<AddDistanceOfCity> liDis = fDetailsService.isViewAllDistanceRecords();
					    int dis = 0;

					    for (AddDistanceOfCity cityDistance : liDis) {
					        if ((cityDistance.getScity().equals(scity1)) && (cityDistance.getEcity().equals(ecity1))) {
					            dis = cityDistance.getDistance();
					        }
					    }

					    for (ViewFlightsScheduleByUser viewSchedule : set2) {
					        ++count;
					        finalPrice = viewSchedule.getBasePrice() * dis;
					        time=viewSchedule.getTime();
					        fname=viewSchedule.getFlightName();
					        System.out.println(String.format("%-4d %-15s %-15s %-12s %-12s %-12s %-10s %-12d %-12d", 
					                                         count, viewSchedule.getId(), viewSchedule.getFlightName(),
					                                         viewSchedule.getStartCity(), viewSchedule.getEndCity(),
					                                         viewSchedule.getDate(), viewSchedule.getTime(), 
					                                         viewSchedule.getNoOfSits(), finalPrice));
					    }
					    
					    System.out.println("--------------------------------------------------------------------------------------------------------");
					    System.out.println("");
		
						System.out.println("Enter Flight number from above");
						int ch =sc.nextInt();
               		 System.out.println("\n------------------------------------------------------------------------------------------");
               		 System.out.println();

                    for(ViewFlightsScheduleByUser el: set2)
                    {
                    	if(el.getId()==ch) {
                    		 int fsid=fdrepo.isSearchByCityDateNameTime(scity1, ecity1, el.getFlightName(), date, el.getTime().toString());
                    		 List<Seat> l=bs.showAvailableSeats(fsid);
                    		 for(Seat i:l) {
                    			 if (i.getStatus() == 0) {
                    			        // Available seat
                    			        System.out.printf("[ %-4d ]\t", i.getSno());
                    			    } else {
                    			        // Booked seat
                    			        System.out.printf("[ %-4d B]\t", i.getSno());
                    			    }
                    			    if (i.getSno() % 6 == 0) {
                    			        System.out.println();  // Move to the next line after every 6 seats
                    			    }
                    		 }
                    		 System.out.println("\n------------------------------------------------------------------------------------------");
                    		 System.out.println("Enter Seat No from Above:");
                    		 int seatNo=sc.nextInt();
                    		 System.out.println();
                    		 List<User> userList=userOpService.isGetUser();
                    		 String userName=null;
                    		 String userEmail=null;
                    		 for(User user:userList)
                    		 {
                    			if(uid==user.getId()) 
                    			{
                    				userName=user.getName();
                    				userEmail=user.getEmail();
                    			}
                    		 }
                    		// System.out.println(finalPrice);
                    		boolean b= bs.bookTicket(uid, fsid, seatNo,finalPrice);          // calling seat booking service method
                    		if(b) {
                    			OTPGenerator emailSend=new OTPGenerator();
                    			System.out.println("Your Ticket is Booked!\n");
                    			String message=emailSend.ticketBookInfo(userEmail,name,fname,scity1,ecity1,date,time,seatNo,finalPrice);
                    			System.out.println(message);
                    			System.out.println();
                    		}
                    		else {
                    			System.out.println("This seat is already booked..");
                    		}
                    	}
                    	
                    }
				    }
				    else
				    {
				    	System.out.println("No record found.....");
				    }
					}
					else
					{
						System.out.println("Enter the Correct Date");
					}
					break;
				case 5:
					List<ViewBookingDetails> l=null;
					UserHistory u=new UserHistory();
					l=u.isGetUserHistory(uid);
					if(l.isEmpty()) {
						System.out.println("No record found");
					}
					else {
						System.out.println("\n======================================================");
					    System.out.println("                   YOUR HISTORY                  ");
					    System.out.println("======================================================");
						System.out.println(String.format("%-20s%-15s%-15s%-15s%-15s%-15s%-15s", 
							     "Flight Name", "Start City", "End City", "Date", "Time","Seat No","Price"));

							System.out.println("------------------------------------------------------------------------------------------------------");
							count=0;
							for (ViewBookingDetails viewBook : l) {
							    ++count;
							    System.out.println(String.format("%-20s%-15s%-15s%-15s%-15s%-15s%-15s", 
							        viewBook.getFName(),
							        viewBook.getStartCityName(),
							        viewBook.getEndCityName(),
							        viewBook.getDate(),
							        viewBook.getTime(),
							        viewBook.getSeatNo(),
							        viewBook.getFinalPirce()));
							}
					}
					break;
				case 6:
					System.out.println("---------------------------------------------------------------------------------------------------------\n");
					capp.main(null);
					default:
						break;
						
				}
			}while(true);
	    }
	   
		
		
	}
}