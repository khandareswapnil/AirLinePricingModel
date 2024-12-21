package com.airline.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightsDetails {
	
	private String startCity;
	private String endCity;
	private String date;
	private String time;
	private String fname;
	private int basePrice;
	private int no_seats;
	
}
