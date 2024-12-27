package com.airlline.admin.operation;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.airline.admin.service.FlightsDetailsServiceIMPL;
import com.airline.entity.ViewBookingDetails;
import com.airline.entity.ViewFlightsScheduleByUser;



public class ViewBooking {
	FlightsDetailsServiceIMPL fDetailsService=new FlightsDetailsServiceIMPL();

	public void viewBookingDetails() {
		List<ViewBookingDetails> list=fDetailsService.isViewBooking();
		int count=0;
		if(list!=null)
		{
			System.out.println(String.format("%-20s%-25s%-15s%-20s%-15s%-15s%-15s%-15s%-15s%-15s", 
				    "User Name", "Email", "Contact", "Flight Name", "Start City", "End City", "Date", "Time","Seat No","Price"));

				System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");

				for (ViewBookingDetails viewBook : list) {
				    ++count;
				    System.out.println(String.format("%-20s%-25s%-15s%-20s%-15s%-15s%-15s%-15s%-15s%-15s", 
				        viewBook.getUName(),
				        viewBook.getUEmail(),
				        viewBook.getUContact(),
				        viewBook.getFName(),
				        viewBook.getStartCityName(),
				        viewBook.getEndCityName(),
				        viewBook.getDate(),
				        viewBook.getTime(),
				    viewBook.getSeatNo(),
				    viewBook.getFinalPirce()));
				}

		}
		else
		{
			System.out.println("No Data Present");
		}
		
	}

	}



