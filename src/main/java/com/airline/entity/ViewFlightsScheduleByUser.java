package com.airline.entity;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewFlightsScheduleByUser {
	int id;
	String flightName;
	String startCity;
	String endCity;
	String date;
	String time;
	int noOfSits;
	int basePrice;
}
