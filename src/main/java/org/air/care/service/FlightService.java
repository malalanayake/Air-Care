/**
 * 
 */
package org.air.care.service;

import java.util.List;
import java.util.Locale;

import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.Flight;

/**
 * Flight Service interface which is provide the flight operation to the Controller
 * 
 * @author Amila
 *
 */
public interface FlightService {
	
	public Flight getFlightByID(Long id);
	
	public List<Flight> getFlightByAirline(String airline);

	public Flight saveFlight(Flight flight, Locale locale) throws ExceptionResourceAlredyExist;

	public void deleteFlight(Flight flight);

	public void updateFlight(Flight flight);
	
	public String[] getAllAirLines();

}
