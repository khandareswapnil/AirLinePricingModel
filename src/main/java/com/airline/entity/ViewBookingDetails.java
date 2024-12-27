package com.airline.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewBookingDetails {
	
	String uName;
	String uEmail;
	String uContact;
	String fName;
	String startCityName;
	String endCityName;
	String date;
	String time;
	int SeatNo;
	int finalPirce;
	
}
