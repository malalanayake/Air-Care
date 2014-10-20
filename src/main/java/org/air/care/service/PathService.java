package org.air.care.service;

import java.util.List;

import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.Airport;
import org.air.care.model.Path;

/**
 * 
 * @author malalanayake
 *
 */
public interface PathService {

	public Path save(Airport start, Airport end)
			throws ExceptionResourceAlredyExist;

	public Path getPath(Airport start, Airport end);

	public List<Path> getAll();

	public void delete(Path path);

}
