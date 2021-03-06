package org.air.care.repository;

import java.util.List;

import org.air.care.model.Airport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Provides the Airport repository operations
 * 
 * @author malalanayake
 *
 */
@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {
	@Query("Select a from Airport  a where name=:airportName")
	public Airport findAirportByName(@Param("airportName") String name);
	
	
	@Query("SELECT a FROM Airport a WHERE name LIKE :airportName")
	public List<Airport> filterAirports(@Param("airportName") String filter);

}
