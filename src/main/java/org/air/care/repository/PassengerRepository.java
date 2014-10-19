/**
 * 
 */
package org.air.care.repository;

import org.air.care.model.Passenger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for Passenger operations
 * 
 * @author Amila
 *
 */
@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Long>{
	
	/**
	 * find passenger by first name
	 * 
	 * @param firstName
	 * @return
	 */
	
	@Query("Select p from Passenger p where firstName=:firstName")
	public Passenger findPassengerByFirstname(@Param("firstName") String firstName);
	
}
