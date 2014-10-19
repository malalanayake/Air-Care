/**
 * 
 */
package org.air.care.service;

import java.util.List;

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

	public Flight saveFlight(Flight flight);

	public void deleteFlight(Flight flight);

	public void updateFlight(Flight flight);

}
