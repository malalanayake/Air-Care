package org.air.care.repository.impl;

import java.util.List;

import org.air.care.business.DirectedWeightedGraph;
import org.air.care.business.FindAllPaths;
import org.air.care.model.Airport;
import org.air.care.model.Path;
import org.air.care.repository.InMemoryAirportGraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Implementation of Airport Graph repository
 * 
 * @author malalanayake
 *
 */
@Repository
public class InMemoryAirportGraphRepositoryImpl implements
		InMemoryAirportGraphRepository {

	private static DirectedWeightedGraph<Airport> airportGraph = new DirectedWeightedGraph<Airport>();
	private static FindAllPaths<Airport> findAirportPaths = new FindAllPaths<Airport>(
			airportGraph);

	@Override
	public void addNewAirport(Airport airport) {
		airportGraph.addNode(airport);
	}

	@Override
	public void addNewPath(Path path) {
		airportGraph.addEdge(path.getAirportIn(), path.getAirportOut(), path);

	}

	@Override
	public List<List<Airport>> findAllPossiblePaths(Airport airportIn,
			Airport airportOut) {
		return findAirportPaths.getAllPaths(airportIn, airportOut);
	}

}
