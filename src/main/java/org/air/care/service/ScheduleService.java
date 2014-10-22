/**
 * 
 */
package org.air.care.service;

import java.util.Date;
import java.util.List;

import org.air.care.model.Schedule;

/**
 * @author B.Pirasanth
 *
 */
public interface ScheduleService {
	public Schedule addSchedule(Schedule schedule);
	
	public Schedule getScheduleByDate(Date date);
	
	public List<Schedule> getAll();
}
