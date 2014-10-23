package org.air.care.service.impl;

import java.util.List;

import org.air.care.model.Airport;
import org.air.care.model.Path;
import org.air.care.repository.InMemoryAirportGraphRepository;
import org.air.care.service.AirportGraphService;
import org.air.care.service.AirportService;
import org.air.care.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AirportGraphServiceImpl implements AirportGraphService {

	@Autowired
	AirportService airportService;

	@Autowired
	InMemoryAirportGraphRepository airportGraphRepository;

	@Autowired
	PathService pathService;

	@Override
	public void addNewAirport(Airport airport) {
		airportGraphRepository.addNewAirport(airport);
	}

	@Override
	public void addNewPath(Path path) {
		airportGraphRepository.addNewPath(path);
	}

	@Override
	public void populate() {
		for (Airport airport : airportService.getAllAirports()) {
			this.addNewAirport(airport);
		}

		for (Path path : pathService.getAll()) {
			this.addNewPath(path);
		}
	}

	@Override
	public List<List<Airport>> findAllPossiblePaths(Airport airportIn,
			Airport airportOut) {
		return airportGraphRepository.findAllPossiblePaths(airportIn,
				airportOut);
	}

}
