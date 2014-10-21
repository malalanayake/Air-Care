package org.air.care.service;

import java.util.List;

import org.air.care.model.Airport;
import org.air.care.model.Path;

public interface AirportGraphService {

	public void addNewAirport(Airport airport);

	public void addNewPath(Path path);

	public void populate();

	public List<List<Airport>> findAllPossiblePaths(Airport airportIn,
			Airport airportOut);
}
