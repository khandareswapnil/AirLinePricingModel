package com.airline.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightsTimes implements Comparable<FlightsTimes>{
	private int id;
	private String time;

	@Override
	public int compareTo(FlightsTimes o) {
		int value=this.time.compareTo(o.time);
		if(value==0)
		{
			return this.time.compareTo(o.time);
		}
		
		return value;
	}

}
