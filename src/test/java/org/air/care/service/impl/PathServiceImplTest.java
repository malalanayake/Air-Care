package org.air.care.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.Airport;
import org.air.care.model.Path;
import org.air.care.repository.AirportRepository;
import org.air.care.repository.PathRepository;
import org.air.care.service.AirportService;
import org.air.care.service.PathService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/servlet-context-test.xml",
		"classpath:/root-context-test.xml" })
@Transactional
public class PathServiceImplTest {

	@Autowired
	PathService pathService;
	@Autowired
	AirportService airportService;

	@Test
	public void savePath() {
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
