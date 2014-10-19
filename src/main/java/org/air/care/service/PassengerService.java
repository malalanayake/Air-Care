/**
 * 
 */
package org.air.care.service;

import org.air.care.model.Passenger;

/**
 * Passenger Service interface which is provide the passenger operation to the Controller
 * 
 * @author Amila
 *
 */
public interface PassengerService {

	public Passenger getPassengerByID(Long id);

	public Passenger getPassengerByFirstname(String firstName);

	public Passenger savePassenger(Passenger passenger);

	public void deletePassenger(Passenger passenger);

	public void updatePassenger(Passenger passenger);

}
