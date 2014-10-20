package org.air.care.repository;

import org.air.care.model.Airport;
import org.air.care.model.Path;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Provide the Path repository operations
 * 
 * @author malalanayake
 *
 */
@Repository
public interface PathRepository extends CrudRepository<Path, Long> {

	@Query("Select a from Path a where airportIn=:start and airportOut=:end")
	public Path findPathByAirports(@Param("start") Airport start,
			@Param("end") Airport end);
}
