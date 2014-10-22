/**
 * 
 */
package org.air.care.repository;

import java.util.Date;

import org.air.care.model.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author B.Pirasanth
 *
 */

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
	public Schedule getScheduleByDate(Date date);
}
