package org.air.care.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Locale;

import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.Airport;
import org.air.care.model.Flight;
import org.air.care.service.FlightService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test Flight service operations
 * 
 * @author Amila
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/servlet-context-test.xml",
		"classpath:/root-context-test.xml" })
@Transactional
public class FlightServiceImplTest {

	@Autowired
	FlightService flightService;

	private static final Log logger = LogFactory
			.getLog(FlightServiceImplTest.class);

	@Test
	public void save() {

		Flight flight = new Flight();
		flight.setAirline("SL001");
		flight.setFlightNumber("FS0013");
		
		Flight flightAfter = null;
		try {
			flightAfter = flightService.saveFlight(flight, Locale.getDefault());
		} catch (ExceptionResourceAlredyExist e) {
			e.printStackTrace();
		}

		assertNotNull(flightAfter.getId());
		logger.info("Flight Information is Saved");
	}

	@Test
	public void getByFlightNumber() {

		Flight flightOne = new Flight();
		flightOne.setAirline("SL001");
		flightOne.setFlightNumber("FN0012");
		
		Flight flightOneAfter = null;
		try {
			flightOneAfter = flightService.saveFlight(flightOne, Locale.getDefault());
		} catch (ExceptionResourceAlredyExist e) {
			e.printStackTrace();
		}

		Flight flightTwo = new Flight();

		flightTwo.setAirline("SL001");
		flightTwo.setFlightNumber("FX0023");
		
		Flight flightTwoAfter = null;
		try {
			flightTwoAfter = flightService.saveFlight(flightTwo, Locale.getDefault());
		} catch (ExceptionResourceAlredyExist e) {
			e.printStackTrace();
		}

		Flight flightThree = new Flight();

		flightThree.setAirline("SL002");
		flightThree.setFlightNumber("FU0034");
		
		Flight flightThreeAfter = null;
		try {
			flightThreeAfter = flightService.saveFlight(flightThree, Locale.getDefault());
		} catch (ExceptionResourceAlredyExist e) {
			e.printStackTrace();
		}

		assertNotNull(flightService.getFlightByID(flightOneAfter.getId()));
		assertNotNull(flightService.getFlightByID(flightTwoAfter.getId()));
		assertNotNull(flightService.getFlightByID(flightThreeAfter.getId()));

		List<Flight> flightfromDB = flightService.getFlightByAirline("SL001");

		assertNotNull(flightfromDB);
		assertEquals(2, flightfromDB.size());

		List<Flight> flightfromDBNew = flightService
				.getFlightByAirline("SL002");

		assertNotNull(flightfromDBNew);
		assertEquals(1, flightfromDBNew.size());

		logger.info("Flight Numbers are Retrieved by AirLine");
	}
}
