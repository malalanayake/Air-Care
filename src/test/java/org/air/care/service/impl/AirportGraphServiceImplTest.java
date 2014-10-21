package org.air.care.service.impl;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Locale;

import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.Airport;
import org.air.care.service.AirportGraphService;
import org.air.care.service.AirportService;
import org.air.care.service.PathService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test the graph implementation
 * 
 * @author malalanayake
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/servlet-context-test.xml",
		"classpath:/root-context-test.xml" })
@Transactional
public class AirportGraphServiceImplTest {

	private static final Log logger = LogFactory
			.getLog(AirportGraphServiceImplTest.class);

	@Autowired
	AirportGraphService airportGraphService;

	@Autowired
	AirportService airportService;

	@Autowired
	PathService pathService;

	@Test
	public void testInMemoryData() throws ExceptionResourceAlredyExist {
		Airport airportA = new Airport();
		airportA.setName("A");
		airportService.save(airportA, Locale.getDefault());

		Airport airportB = new Airport();
		airportB.setName("B");
		airportService.save(airportB, Locale.getDefault());

		Airport airportC = new Airport();
		airportC.setName("C");
		airportService.save(airportC, Locale.getDefault());

		Airport airportD = new Airport();
		airportD.setName("D");
		airportService.save(airportD, Locale.getDefault());

		pathService.save(airportA, airportB, Locale.getDefault());
		pathService.save(airportA, airportC, Locale.getDefault());
		pathService.save(airportB, airportD, Locale.getDefault());
		pathService.save(airportC, airportD, Locale.getDefault());
		pathService.save(airportC, airportB, Locale.getDefault());
		pathService.save(airportB, airportA, Locale.getDefault());

		airportGraphService.populate();
		for (List<Airport> ss : airportGraphService.findAllPossiblePaths(
				airportA, airportB)) {
			for (Airport s : ss) {
				System.out.print(s.getName() + "->");
			}
			System.out.println();
		}

		Airport chicargo = airportService.getByName("Chicago");
		Airport desmoin = airportService.getByName("Desmoin");

		assertNotNull(chicargo);
		assertNotNull(desmoin);
		for (List<Airport> ss : airportGraphService.findAllPossiblePaths(
				chicargo, desmoin)) {
			for (Airport s : ss) {
				System.out.print(s.getName() + "->");
			}
			System.out.println();
		}

		Airport miami = airportService.getByName("Miami International");
		Airport sanFrancisco = airportService.getByName("San Francisco");

		assertNotNull(miami);
		assertNotNull(sanFrancisco);
		for (List<Airport> ss : airportGraphService.findAllPossiblePaths(miami,
				sanFrancisco)) {
			for (Airport s : ss) {
				System.out.print(s.getName() + "->");
			}
			System.out.println();
		}

	}
}
