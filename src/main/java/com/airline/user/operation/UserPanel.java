package com.airline.user.operation;
import java.util.*;

import com.airline.admin.repo.FlightsDetailsRepoImpl;
import com.airline.admin.repo.UserOperationRepoIMPL;
import com.airline.admin.service.CityOperationSerIMPL;
import com.airline.admin.service.FlightsDetailsServiceIMPL;
import com.airline.app.ClientAppication;
import com.airline.entity.AddDistanceOfCity;
import com.airline.entity.CitytEntity;
import com.airline.entity.Seat;
import com.airline.entity.User;
import com.airline.entity.ViewFlightsScheduleByUser;
import com.airline.user.service.BookingService;
import com.airline.user.service.ViewFlightsIMPL;
public class UserPanel {
	FlightsDetailsServiceIMPL fDetailsService=new FlightsDetailsServiceIMPL();

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
	    	System.out.println("*********************** WELCOME "+ name.toUpperCase()+" ************************\n");
			ClientAppication capp=new ClientAppication();
			Scanner sc = new Scanner(System.in);
			ViewFlightsIMPL viewFlightsServiceRef =new ViewFlightsIMPL();  // reference for view all flight service class
			CityOperationSerIMPL city =new CityOperationSerIMPL();         // reference for city operation repository class to get lists of all cities
			Set<ViewFlightsScheduleByUser> set2=null;                    // created tree set of viewFlightsScheduleByUser entity class
			BookingService bs =new BookingService();                     // Booking Service class object
			FlightsDetailsRepoImpl fdrepo =new FlightsDetailsRepoImpl();   //admin repo reference for getting fsid
			do 
			{
				System.out.println("1. View all flights");
				System.out.println("2. View all flights by start and end city");
				System.out.println("3. View all flights by start city, end city and date wise");
				System.out.println("4. Ticket Booking");
				System.out.println("5. For Logout");
				System.out.println("Enter your choice from above menu");
				int menu=sc.nextInt();
				sc.nextLine();
				
				switch(menu) 
				{
				case 1:
					set2=viewFlightsServiceRef.isGetAllFlights();
					System.out.println("-------------------------------------------------------------------------------------------");
					System.out.println("\nNo.\tFlight Name\tStart City\tEnd City\tDate\t\tTime\tNo OF Sits\tBase Price");
					int count=0;
					for(ViewFlightsScheduleByUser viewSchedule:set2) {
						++count;
						System.out.println(count+"\t"+viewSchedule.getFlightName()+"\t"+viewSchedule.getStartCity()+"\t\t"+viewSchedule.getEndCity()+"\t\t"+viewSchedule.getDate()+"\t"+viewSchedule.getTime()+"\t"+viewSchedule.getNoOfSits());
					}
					//set2.forEach(list3->System.out.println(+list3.getId()+"\t"+list3.getFlightName()+"\t"+list3.getStartCity()+"\t\t"+list3.getEndCity()+"\t\t"+list3.getDate()+"\t"+list3.getTime()+"\t"+list3.getNoOfSits()+"\t"+list3.getBasePrice()));
					System.out.println("-------------------------------------------------------------------------------------------");
					System.out.println("");
					
					break;
				case 2:	
					System.out.println("");
					List<CitytEntity> list= city.isGetCity();
					list.forEach(list1->System.out.println(list1.getCityName()));
					System.out.println("\nEnter Your start city from above");
					String scity=sc.nextLine();
					System.out.println("Enter end city from above");
					String ecity=sc.nextLine();
					if(ecity.equals(scity)) 
					{
						System.out.println("Enter different city as start city and end city");
					}
					
					set2 =viewFlightsServiceRef.isGetAllFlightsByStartEndCity (scity, ecity);
					if(!set2.isEmpty()) {
						System.out.println("-------------------------------------------------------------------------------------------");
						System.out.println("\nNo.\tFlight Name\tStart City\tEnd City\tDate\t\tTime\tNo OF Sits\tBase Price");
					    count=0;
						for(ViewFlightsScheduleByUser viewSchedule:set2) {
							++count;
							System.out.println(count+"\t"+viewSchedule.getFlightName()+"\t"+viewSchedule.getStartCity()+"\t\t"+viewSchedule.getEndCity()+"\t\t"+viewSchedule.getDate()+"\t"+viewSchedule.getTime()+"\t"+viewSchedule.getNoOfSits());
						}
						//set2.forEach(list3->System.out.println(list3.getId()+"\t"+list3.getFlightName()+"\t"+list3.getStartCity()+"\t\t"+list3.getEndCity()+"\t\t"+list3.getDate()+"\t"+list3.getTime()+"\t"+list3.getNoOfSits()+"\t"+list3.getBasePrice()));
						System.out.println("-------------------------------------------------------------------------------------------");
						System.out.println("");
					}
					else {
						System.out.println("No record found...\n");
					}
					
					break;
				case 3:
					System.out.println("");
					List<CitytEntity> citylist= city.isGetCity();
					citylist.forEach(list1->System.out.println(list1.getCityName()));
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
					set2 =viewFlightsServiceRef.isGetAllFlightsByStartEndCityDate (scity1,ecity1,date );
				    if(!set2.isEmpty()) {
						System.out.println("-------------------------------------------------------------------------------------------");
				    	System.out.println("\nNo.\tFlight Name\tStart City\tEnd City\tDate\t\tTime\tNo OF Sits\tBase Price");
				    	count=0;
						for(ViewFlightsScheduleByUser viewSchedule:set2) {
							++count;
							System.out.println(count+"\t"+viewSchedule.getFlightName()+"\t"+viewSchedule.getStartCity()+"\t\t"+viewSchedule.getEndCity()+"\t\t"+viewSchedule.getDate()+"\t"+viewSchedule.getTime()+"\t"+viewSchedule.getNoOfSits());
						}
				    	//set2.forEach(list3->System.out.println(list3.getId()+"\t"+list3.getFlightName()+"\t"+list3.getStartCity()+"\t\t"+list3.getEndCity()+"\t\t"+list3.getDate()+"\t"+list3.getTime()+"\t"+list3.getNoOfSits()+"\t"+list3.getBasePrice()));
						System.out.println("-------------------------------------------------------------------------------------------");
						System.out.println("");
				    }
				    else
				    {
				    	System.out.println("No record found.....");
				    }
					
					break;
				case 4:
					System.out.println("");
					citylist= city.isGetCity();
					citylist.forEach(list1->System.out.println(list1.getCityName()));
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
					set2 =viewFlightsServiceRef.isGetAllFlightsByStartEndCityDate (scity1,ecity1,date );
					int finalPrice=0;
					if (!set2.isEmpty()) {
					    System.out.println("-------------------------------------------------------------------------------------------");
					    System.out.println(String.format("%-4s %-8s %-15s %-12s %-12s %-12s %-10s %-12s %-12s", 
					                                     "No.", "FSINO", "Flight Name", "Start City", "End City", 
					                                     "Date", "Time", "No Of Sits", "Final Price"));
					    System.out.println("-------------------------------------------------------------------------------------------");

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
					        System.out.println(String.format("%-4d %-8s %-15s %-12s %-12s %-12s %-10s %-12d %-12d", 
					                                         count, viewSchedule.getId(), viewSchedule.getFlightName(),
					                                         viewSchedule.getStartCity(), viewSchedule.getEndCity(),
					                                         viewSchedule.getDate(), viewSchedule.getTime(), 
					                                         viewSchedule.getNoOfSits(), finalPrice));
					    }
					    
					    System.out.println("-------------------------------------------------------------------------------------------");
					    System.out.println("");
					

						
						System.out.println("Enter FSINO number from above");
						int ch =sc.nextInt();
                    for(ViewFlightsScheduleByUser el: set2)
                    {
                    	if(el.getId()==ch) {
                    		System.out.println("Flight mached from above...");
                    		 int fsid=fdrepo.isSearchByCityDateNameTime(scity1, ecity1, el.getFlightName(), date, el.getTime().toString());
                    		 System.out.println("Print fsid : "+fsid);
                    		 List<Seat> l=bs.showAvailableSeats(fsid);
                    		 System.out.println("Seat list is empty : "+l.isEmpty());
                    		 for(Seat i:l) {
                    			 if(i.getStatus()==0) {
                    				 System.out.printf("[ "+i.getSno()+" ]\t");
                    				 if(i.getSno()%6==0) System.out.println("");
                    			 }
                    			 else {
                    				 System.out.printf("[ "+i.getSno()+" B]\t");
                    				 if(i.getSno()%6==0) System.out.println("");
                    			 }
                    		 }
                    		 System.out.println("Enter Seat No from Above");
                    		 int seatNo=sc.nextInt();
                    		 System.out.println(finalPrice);
                    		boolean b= bs.bookTicket(uid, fsid, seatNo,finalPrice);          // calling seat booking service method
                    		if(b) {
                    			System.out.println("Your Ticket is Booked");
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
					break;
				case 5:
					System.out.println("---------------------------------------------------------------------------------------------------------\n");
					capp.main(null);
					default:
						break;
						
				}
			}while(true);
	    }
	   
		
		
	}
}