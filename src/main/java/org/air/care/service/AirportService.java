package org.air.care.service;

import java.util.Locale;

import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.Airport;
import org.springframework.cglib.core.Local;

/**
 * Airport service which is provide the airport operations
 * 
 * @author malalanayake
 *
 */
public interface AirportService {

	public Airport getById(Long id);

	public Airport getByName(String name);

	public Airport save(Airport airport, Locale locale)
			throws ExceptionResourceAlredyExist;

	public void delete(Airport airport);

	public void update(Airport airport);
}
