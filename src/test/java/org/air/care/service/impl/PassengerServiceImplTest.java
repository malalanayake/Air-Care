package org.air.care.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.air.care.model.Passenger;
import org.air.care.service.PassengerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test Passenger service operations
 * 
 * @author Amila
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/servlet-context-test.xml",
		"classpath:/root-context-test.xml" })
@Transactional
public class PassengerServiceImplTest {
	
	@Autowired
	PassengerService passengerService;
	
	private static final Log logger = LogFactory.getLog(PassengerServiceImplTest.class);

	@Test
	public void save() {
		
		Passenger passenger = new Passenger();
		passenger.setFirstName("Amila");
		passenger.setLastName("Nagendirapillai");
		passenger.setPassportNumber("N185949");
		passenger.setEmailAddress("namila23@gmail.com");
		
		passenger = passengerService.savePassenger(passenger);
		
		assertNotNull(passenger.getId());
		logger.info("Passenger Information is Saved");
	}

	@Test
	public void getByFirstName() {
		
		Passenger passenger = new Passenger();
		passenger.setFirstName("Amila");
		passenger.setLastName("Nagendirapillai");
		passenger.setPassportNumber("N185949");
		passenger.setEmailAddress("namila23@gmail.com");
		
		passenger = passengerService.savePassenger(passenger);
		
		assertNotNull(passengerService.getPassengerByID(passenger.getId()));
		Passenger passengerfromDB = passengerService.getPassengerByFirstname("Amila");
		
		
		assertNotNull(passengerfromDB);
		assertEquals(passenger.getFirstName(), passengerfromDB.getFirstName());
		assertEquals(passenger.getLastName(), passengerfromDB.getLastName());
		assertEquals(passenger.getPassportNumber(), passengerfromDB.getPassportNumber());
		assertEquals(passenger.getEmailAddress(), passengerfromDB.getEmailAddress());
		logger.info("Passenger is retrieved by First Name");
		
		
		
	}

}
