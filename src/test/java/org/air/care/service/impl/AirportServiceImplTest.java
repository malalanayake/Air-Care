package org.air.care.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.Airport;
import org.air.care.model.Path;
import org.air.care.service.AirportService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test Airport service operation
 * 
 * @author malalanayake
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/servlet-context-test.xml",
		"classpath:/root-context-test.xml" })
@Transactional
public class AirportServiceImplTest {

	private static final Log logger = LogFactory
			.getLog(AirportServiceImplTest.class);

	@Autowired
	AirportService airportService;

	@Test
	public void saveAirport() {
		logger.info("====TEST SAVE AIRPORT====");
		Airport airport = new Airport();
		airport.setName("Desmoin Iowa");
		Path path = new Path();
		path.setAirportIn(airport);
		path.setAirportOut(airport);
		List<Path> listOut = new ArrayList<Path>();
		listOut.add(path);
		List<Path> listIn = new ArrayList<Path>();
		listIn.add(path);

		airport.setListOfOutPaths(listOut);
		airport.setListOfInPaths(listIn);

		Airport airportAfter = null;
		try {
			airportAfter = airportService.save(airport);
		} catch (ExceptionResourceAlredyExist e) {
			e.printStackTrace();
		}

		assertNotNull(airportAfter.getId());
		assertEquals(airport.getListOfInPaths().size(), airportAfter
				.getListOfInPaths().size());

		String expName = "";
		try {
			Airport airportExcep = airportService.save(airport);
		} catch (Exception ex) {
			expName = ex.getClass().toString();
		}

		assertEquals(ExceptionResourceAlredyExist.class.toString(), expName);

	}
}
