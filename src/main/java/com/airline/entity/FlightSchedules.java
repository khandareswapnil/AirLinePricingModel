package com.airline.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightSchedules {
	String startCity;
	String endCity;
	String flight;
	String flightTime;
	int flightBasePriceId;
	String flightScDate;

}
