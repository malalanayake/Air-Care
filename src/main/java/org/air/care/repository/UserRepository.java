package org.air.care.repository;

import org.air.care.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository for User operations
 * 
 * @author malalanayake
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	/**
	 * find user by user name
	 * 
	 * @param userName
	 * @return
	 */
	@Query("Select u from User u where USERNAME=:username")
	public User findOneByUsername(@Param("username") String username);
}
