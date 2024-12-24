package com.airline.email.verify;

import java.util.ArrayList;
import java.util.List;

import com.airline.entity.OTP;

public class OTPGenerator {
List<OTP> list=null;
	public List<OTP> otpGenerator(String to)
	{
			list=new ArrayList<>();
			OTP otpsend=new OTP();
	        String from = "swapnilkhandare1001@gmail.com";   // Your email (sender)
	        String subject = "Your OTP Code";
	        int otp = generateOTP();                // Generate a random OTP
	        String message = "Your One-Time Password (OTP) is: " + otp;
	        
	        String message1=new SendEmail().sendEmail(to,from,subject,message);
			otpsend.setMeassage(message1);
			otpsend.setOtp(otp);
			list.add(otpsend);
			return list;

	}
	 private static int generateOTP() {
	        return (int) (Math.random() * 9000) + 1000; // Random number between 100000 and 999999
	    }
}
