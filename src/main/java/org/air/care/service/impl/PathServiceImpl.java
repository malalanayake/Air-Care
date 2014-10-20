package org.air.care.service.impl;

import java.util.List;

import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.Airport;
import org.air.care.model.Path;
import org.air.care.repository.PathRepository;
import org.air.care.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Path Service implementation
 * 
 * @author malalanayake
 *
 */
@Service
@Transactional
public class PathServiceImpl implements PathService {

	@Autowired
	PathRepository pathRepository;

	@Override
	public Path save(Airport start, Airport end)
			throws ExceptionResourceAlredyExist {
		Path path = new Path();
		if (pathRepository.findPathByAirports(start, end) == null) {

			path.setAirportIn(start);
			path.setAirportOut(end);

			path = pathRepository.save(path);
			start.setOutPath(path);
			end.setInPath(path);
			
		} else {
			throw new ExceptionResourceAlredyExist("Path start from "
					+ start.getName() + " to " + end.getName()
					+ " is alredy exist");
		}

		return path;
	}

	@Override
	public Path getPath(Airport start, Airport end) {
		return pathRepository.findPathByAirports(start, end);
	}

	@Override
	public List<Path> getAll() {
		return (List<Path>) pathRepository.findAll();
	}

	@Override
	public void delete(Path path) {
		pathRepository.delete(path);
	}

}
