package org.air.care.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.Airport;
import org.air.care.model.Path;
import org.air.care.service.AirportService;
import org.air.care.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for airport operations
 * 
 * @author malalanayake
 *
 */
@Controller
@RequestMapping("/airport")
public class AirportController {

	@Autowired
	AirportService airportService;

	/**
	 * View the airport registration view
	 * 
	 * @param airport
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addAirport(@ModelAttribute("newAirport") Airport airport,
			Model model) {
		return "/admin/addAirport";
	}

	/**
	 * Register the airport
	 * 
	 * @param airport
	 * @param bindingResult
	 * @param local
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveAirport(
			@Valid @ModelAttribute("newAirport") Airport airport,
			BindingResult bindingResult, Locale local) {
		if (bindingResult.hasErrors()) {
			return "/admin/addAirport";
		}

		try {
			airportService.save(airport, local);
		} catch (ExceptionResourceAlredyExist e) {
			FieldError fieldError = new FieldError("name", "name",
					e.getMessage());
			bindingResult.addError(fieldError);
			return "/admin/addAirport";
		}
		return "/admin/addAirport";
	}

	@RequestMapping(value = "/getFilteredAirports", method = RequestMethod.POST)
	public @ResponseBody List<String> getFilteredAirports(
			@RequestParam("filter") String filter) {
		List<String> names = new ArrayList<String>();
		for (Airport airport : airportService.filterAirports(filter + "%")) {
			names.add(airport.getName());
		}
		return names;
	}
}
