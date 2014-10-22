package org.air.care.service.impl;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.air.care.common.Constant;
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

	private final String exceptionPathAlreadyExist = "exception.path.save.alreadyExist";

	@Autowired
	PathRepository pathRepository;

	@Override
	public Path save(Airport start, Airport end, Locale locale)
			throws ExceptionResourceAlredyExist {
		Path pathSaved = null;
		Path path = new Path();
		if (pathRepository.findPathByAirports(start, end) == null) {

			path.setAirportIn(start);
			path.setAirportOut(end);

			path = pathRepository.save(path);
			// start.getListOfOutPaths().add(path);
			// end.getListOfInPaths().add(path);

		} else {
			ResourceBundle resourceBundle = ResourceBundle.getBundle(
					Constant.errorMessageBaseName, locale);
			throw new ExceptionResourceAlredyExist(
					resourceBundle.getString(exceptionPathAlreadyExist));
		}
		return pathSaved;
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

	@Override
	public Path getPathById(Long id) {
		return pathRepository.getPathById(id);
	}

}
