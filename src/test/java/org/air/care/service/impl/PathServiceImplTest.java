package org.air.care.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.Airport;
import org.air.care.model.Path;
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
 * Test the path service operations
 * 
 * @author malalanayake
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/servlet-context-test.xml",
		"classpath:/root-context-test.xml" })
@Transactional
public class PathServiceImplTest {

	private static final Log logger = LogFactory
			.getLog(PathServiceImplTest.class);

	@Autowired
	PathService pathService;
	@Autowired
	AirportService airportService;

	@Test
	public void savePath() {
		logger.info("====TEST SAVE PATH====");
		Airport airportStart = new Airport();
		airportStart.setName("Desmoin Iowa");
		airportStart.setLocation("Iowa");

		Airport airportEnd = new Airport();
		airportEnd.setName("Ceda rapids");
		airportEnd.setLocation("Iowa");

		Path path = null;
		try {
			airportStart = airportService.save(airportStart);
			airportEnd = airportService.save(airportEnd);
			path = pathService.save(airportStart, airportEnd);
		} catch (ExceptionResourceAlredyExist e) {
			e.printStackTrace();
		}

		airportStart = airportService.getByName(airportStart.getName());
		airportEnd = airportService.getByName(airportEnd.getName());

		assertNotNull(path.getId());
		assertEquals(0, airportStart.getListOfInPaths().size());
		assertEquals(1, airportStart.getListOfOutPaths().size());
		assertEquals(0, airportEnd.getListOfOutPaths().size());
		assertEquals(1, airportEnd.getListOfInPaths().size());

	}

}
