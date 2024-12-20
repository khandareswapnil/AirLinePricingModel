package com.airline.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightsSeatsAndBasePrice {
	private int No_OF_Seats;
	private int basePrice;
}
