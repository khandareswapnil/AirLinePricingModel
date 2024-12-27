package com.airline.email.verify;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.airline.admin.service.FlightsDetailsServiceIMPL;
import com.airline.entity.OTP;
import com.airline.entity.ViewBookingDetails;

public class OTPGenerator {
List<OTP> list=null;
FlightsDetailsServiceIMPL fDService=new FlightsDetailsServiceIMPL();

	public List<OTP> otpGenerator(String to)
	{
			list=new ArrayList<>();
			OTP otpsend=new OTP();
	        String from = "swapnilkhandare1001@gmail.com";   // Your email (sender)
	        String subject = "Your OTP Code";
	        int otp = generateOTP();                // Generate a random OTP
	        String message = "Your One-Time Password (OTP) is: " + otp;
	        
	        String message1=new SendEmail().sendEmail(to,from,subject,message);
	        if(message1.equals("true"))
	        {
	        	String message2="OTP Sent Sucessfully";
	        	otpsend.setMeassage(message2);
				otpsend.setOtp(otp);
				list.add(otpsend);
	        }
			
			return list;

	}
	 private static int generateOTP() {
	        return (int) (Math.random() * 9000) + 1000; // Random number between 100000 and 999999
	    }
	 
		
		public String ticketBookInfo(String to, String name,String fname, String scity1, String ecity1, String date,
				LocalTime time, int seatNo, int finalPrice) {
			
			 String from = "swapnilkhandare1001@gmail.com";   // Your email (sender)
		        String subject = "Your Flight Booking Confirmation ";
		        String message = String.format(
		        	    "----------------------------------------\n" +
		        	    "            Flight Ticket               \n" +
		        	    "----------------------------------------\n" +
		        	    "Dear %s, Thank You For Booking!\n\n" +
		        	    "Booking Details:\n" +
		        	    "----------------------------------------\n" +
		        	    "Flight Name      : %s\n" +
		        	    "From             : %s\n" +
		        	    "To               : %s\n" +
		        	    "Date             : %s\n" +
		        	    "Time             : %s\n" +
		        	    "Seat No          : %s\n" +
		        	    "Price            : %s\n" +
		        	    "----------------------------------------\n" +
		        	    "Have a safe journey!\n",
		        	    name, fname, scity1, ecity1, date, time, seatNo, finalPrice
		        	);

		        String message1=new SendEmail().sendEmail(to,from,subject,message);
		        String message2=null;
		        if(message1.equals("true"))
		        {
		        	  message2="Ticket Sent On Your Email";
		        		
		        }
		        return message2;
		       
		        
		}

}
