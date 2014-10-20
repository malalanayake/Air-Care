/**
 * 
 */
package org.air.care.repository;

import java.util.List;

import org.air.care.model.Airport;
import org.air.care.model.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for Flight operations
 * 
 * @author Amila
 *
 */
@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {

	/**
	 * find flight by airline
	 * 
	 * @param airline
	 * @return
	 */

	@Query("SELECT f FROM Flight f where airline = :airline")
	public List<Flight> getFlightByAirline(@Param("airline") String airline);

}
