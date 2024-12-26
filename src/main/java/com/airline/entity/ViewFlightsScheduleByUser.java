package com.airline.entity;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewFlightsScheduleByUser implements Comparable<ViewFlightsScheduleByUser>{
	int id;
	String flightName;
	String startCity;
	String endCity;
	LocalDate date;
	LocalTime time;
	int noOfSits;
	int basePrice;
	
	@Override
	public int compareTo(ViewFlightsScheduleByUser second) {
		// TODO Auto-generated method stub
        int value = this.date.compareTo(second.date);
        
        // If dates are equal, compare by time
        if (value == 0) {


            int val2= this.time.compareTo(second.time);
            if(val2==0){
            	return 1;
            }
            return val2;
        }

        return value;
	}
}
