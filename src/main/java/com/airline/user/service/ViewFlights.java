package com.airline.user.service;
import java.util.*;
import com.airline.entity.FlightsDetails;

public interface ViewFlights {
	public List<FlightsDetails> isGetAllFlightsByStartEndCity(String startcity, String endcity); 

}
