package org.air.care.service.impl;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.air.care.common.Constant;
import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.Airport;
import org.air.care.repository.AirportRepository;
import org.air.care.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Airport service implementation class
 * 
 * @author malalanayake
 *
 */
@Service
@Transactional
public class AirportServiceImpl implements AirportService {

	private final String exceptionAirportAlreadyExist = "exception.aireport.save.alreadyexist";

	@Autowired
	private AirportRepository aiportRepository;

	@Override
	public Airport getById(Long id) {
		return aiportRepository.findOne(id);
	}

	@Override
	public Airport getByName(String name) {
		return aiportRepository.findAirportByName(name);
	}

	@Override
	public Airport save(Airport airport, Locale locale)
			throws ExceptionResourceAlredyExist {
		Airport airportSaved = null;
		if (aiportRepository.findAirportByName(airport.getName()) == null) {
			airportSaved = aiportRepository.save(airport);
		} else {
			ResourceBundle resourceBundle = ResourceBundle.getBundle(
					Constant.errorMessageBaseName, locale);
			throw new ExceptionResourceAlredyExist(
					resourceBundle.getString(exceptionAirportAlreadyExist));
		}

		return airportSaved;
	}

	@Override
	public void delete(Airport airport) {
		aiportRepository.delete(airport);
	}

	@Override
	public void update(Airport airport) {
		aiportRepository.save(airport);
	}

	@Override
	public List<Airport> filterAirports(String name) {
		return aiportRepository.filterAirports(name);
	}

	@Override
	public List<Airport> getAllAirports() {
		return (List<Airport>) aiportRepository.findAll();
	}

}
