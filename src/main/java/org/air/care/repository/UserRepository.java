package org.air.care.repository;

import org.air.care.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
	@Query("SELECT u FROM User u where username = :userName")
	public User findByUserName(@Param("userName") String userName);
}
