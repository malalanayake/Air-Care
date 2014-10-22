package org.air.care.service.impl;

import java.util.Date;
import java.util.List;

import org.air.care.model.Schedule;
import org.air.care.repository.ScheduleRepository;
import org.air.care.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	ScheduleRepository scheduleRepository;
	
	@Override
	public Schedule addSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}

	@Override
	public Schedule getScheduleByDate(Date date) {
		return scheduleRepository.getScheduleByDate(date);
	}

	@Override
	public List<Schedule> getAll() {
		return (List<Schedule>) scheduleRepository.findAll();
	}

}
