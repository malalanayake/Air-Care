package org.air.care.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.Airport;
import org.air.care.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/airport")
public class AirportController {

	@Autowired
	AirportService airportService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addAirport(@ModelAttribute("newAirport") Airport airport) {
		return "/admin/addAirport";
	}

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
}
