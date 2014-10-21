package org.air.care.repository;

import java.util.List;

import org.air.care.model.Airport;
import org.air.care.model.Path;

/**
 * This interface is provide the access to the graph operation
 * 
 * @author malalanayake
 *
 */
public interface InMemoryAirportGraphRepository {

	public void addNewAirport(Airport airport);

	public void addNewPath(Path path);

	public List<List<Airport>> findAllPossiblePaths(Airport airportIn,
			Airport airportOut);

}
