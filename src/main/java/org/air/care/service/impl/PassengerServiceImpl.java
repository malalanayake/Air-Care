/**
 * 
 */
package org.air.care.service.impl;

import org.air.care.model.Passenger;
import org.air.care.repository.PassengerRepository;
import org.air.care.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Passenger Service implementation
 * 
 * @author Amila
 *
 */
@Service
@Transactional
public class PassengerServiceImpl implements PassengerService{
	
	@Autowired
	PassengerRepository passengerRepository;

	@Override
	public Passenger getPassengerByID(Long id) {
		return passengerRepository.findOne(id);
	}

	@Override
	public Passenger getPassengerByFirstname(String firstName) {
		return passengerRepository.findPassengerByFirstname(firstName);
	}

	@Override
	public Passenger savePassenger(Passenger passenger) {
		return passengerRepository.save(passenger);
	}

	@Override
	public void deletePassenger(Passenger passenger) {
		passengerRepository.delete(passenger);
	}

	@Override
	public void updatePassenger(Passenger passenger) {
		passengerRepository.save(passenger);
	}

}
