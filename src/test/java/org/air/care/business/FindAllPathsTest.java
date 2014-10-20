package org.air.care.business;

import java.util.List;

import org.air.care.model.Airport;
import org.air.care.model.Path;
import org.junit.Test;

/**
 * Test the find all paths algoritham
 * 
 * @author malalanayake
 *
 */
public class FindAllPathsTest {

	@Test
	public void findPathTest() {
		DirectedWeightedGraph<Airport> graphFindAllPaths = new DirectedWeightedGraph<Airport>();
		Airport airportA = new Airport();
		airportA.setName("A");
		Airport airportB = new Airport();
		airportB.setName("B");
		Airport airportC = new Airport();
		airportC.setName("C");
		Airport airportD = new Airport();
		airportD.setName("D");
		graphFindAllPaths.addNode(airportA);
		graphFindAllPaths.addNode(airportB);
		graphFindAllPaths.addNode(airportC);
		graphFindAllPaths.addNode(airportD);

		Path pathAB = new Path();
		pathAB.setAirportIn(airportA);
		pathAB.setAirportIn(airportB);
		graphFindAllPaths.addEdge(airportA, airportB, pathAB);

		Path pathAC = new Path();
		pathAC.setAirportIn(airportA);
		pathAC.setAirportIn(airportC);
		graphFindAllPaths.addEdge(airportA, airportC, pathAC);

		Path pathBD = new Path();
		pathBD.setAirportIn(airportB);
		pathBD.setAirportIn(airportD);
		graphFindAllPaths.addEdge(airportB, airportD, pathBD);

		Path pathCD = new Path();
		pathCD.setAirportIn(airportC);
		pathCD.setAirportIn(airportD);
		graphFindAllPaths.addEdge(airportC, airportD, pathCD);

		Path pathCB = new Path();
		pathCB.setAirportIn(airportC);
		pathCB.setAirportIn(airportB);
		graphFindAllPaths.addEdge(airportC, airportB, pathCB);

		Path pathBA = new Path();
		pathBA.setAirportIn(airportB);
		pathBA.setAirportIn(airportA);
		graphFindAllPaths.addEdge(airportB, airportA, pathBA);

		FindAllPaths<Airport> findAllPaths = new FindAllPaths<Airport>(
				graphFindAllPaths);

		for (List<Airport> ss : findAllPaths.getAllPaths(airportA, airportB)) {
			for (Airport s : ss) {
				System.out.print(s.getName() + "->");
			}
			System.out.println();
		}

	}

}
