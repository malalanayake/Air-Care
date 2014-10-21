/**
 * 
 */
package org.air.care.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.Path;
import org.air.care.service.AirportService;
import org.air.care.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller to handle the Path requests
 * 
 * @author Amila
 *
 */
@Controller
@RequestMapping("/path")
public class PathController {

	@Autowired
	PathService pathService;

	@Autowired
	AirportService airportService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewPath(Model model) {
		model.addAttribute("newPath", new Path());
		return "/admin/addPath";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewPath(
			@ModelAttribute("newPath") @Valid Path pathToBeAdded,
			BindingResult result, HttpServletRequest request, Locale locale) {
		if (result.hasErrors()) {
			return "/admin/addPath";
		}		
		try {

			pathService.save(airportService.getByName(pathToBeAdded
					.getAirportIn().getName()), airportService
					.getByName(pathToBeAdded.getAirportOut().getName()), locale);
		} catch (ExceptionResourceAlredyExist e) {
			ObjectError obj = new ObjectError("Error", e.getMessage());
			result.addError(obj);

			return "/admin/addPath";
		}
		return "/client/clientHome";
	}
}