package org.air.care.repository;

import java.util.List;

import org.air.care.model.PossiblePaths;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository operation for the possible paths
 * 
 * @author malalanayake
 *
 */
@Repository
public interface PossiblePathsRepository extends
		CrudRepository<PossiblePaths, Long> {
	@Query("Select a from PossiblePaths a where source=:start and destination=:end")
	public List<PossiblePaths> findPathsByAirports(
			@Param("start") String source, @Param("end") String destination);
}
