package com.airline.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddDistanceOfCity {
	private String scity;
	private String ecity;
	private int distance;
}
