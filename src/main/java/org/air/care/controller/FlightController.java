/**
 * 
 */
package org.air.care.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.air.care.model.Flight;
import org.air.care.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller to handle the Flight requests
 * 
 * @author Amila
 *
 */
@Controller
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	private FlightService flightService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewFlightForm(
			@ModelAttribute("newFlight") Flight newFlight, Model model) {
		model.addAttribute("airlines", flightService.getAllAirLines());
		return "/admin/addFlight";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView processAddNewFlightForm(
			@ModelAttribute("newFlight") @Valid Flight flightToBeAdded,
			BindingResult result, HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();

		if (result.hasErrors()) {

			modelAndView.addObject("airlines", flightService.getAllAirLines());
			modelAndView.setViewName("/admin/addFlight");
			return modelAndView;
		}

		flightService.saveFlight(flightToBeAdded);
		modelAndView.setViewName("/client/home");
		return modelAndView;
	}
}