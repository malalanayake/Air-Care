package org.air.care.service;

import java.util.List;
import java.util.Locale;

import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.Airport;
import org.air.care.model.Path;

/**
 * Path Service interface which is provide the path operation to the Controller
 * 
 * @author malalanayake
 *
 */
public interface PathService {

	public Path getPathById(Long id);
	
	public Path save(Airport start, Airport end, Locale locale)
			throws ExceptionResourceAlredyExist;

	public Path getPath(Airport start, Airport end);

	public List<Path> getAll();

	public void delete(Path path);

}
