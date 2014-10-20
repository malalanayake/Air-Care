/**
 * 
 */
package org.air.care.service.impl;

import java.util.List;

import org.air.care.common.Constant;
import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.Flight;
import org.air.care.repository.FlightRepository;
import org.air.care.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Flight Service implementation
 * 
 * @author Amila
 *
 */
@Service
@Transactional
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	FlightRepository flightRepository;

	@Override
	public Flight getFlightByID(Long id) {
		return flightRepository.findOne(id);
	}

	@Override
	public Flight saveFlight(Flight flight){		
		return flightRepository.save(flight);
	}

	@Override
	public void deleteFlight(Flight flight) {
		flightRepository.delete(flight);
	}

	@Override
	public void updateFlight(Flight flight) {
		flightRepository.save(flight);
	}

	@Override
	public List<Flight> getFlightByAirline(String airline) {
		return flightRepository.getFlightByAirline(airline);
	}

	@Override
	public String[] getAllAirLines() {
		return Constant.AIRLINES;
	}

}
