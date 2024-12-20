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
	private int distance;
	private String date;
	private float time;
	private String fname;
	private int basePrice;
	
	
}
