/**
 * 
 */
package org.air.care.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.air.care.model.Flight;
import org.air.care.model.Path;
import org.air.care.model.PossiblePaths;
import org.air.care.model.Schedule;
import org.air.care.model.grid.GridModel;
import org.air.care.service.AirportGraphService;
import org.air.care.service.AirportService;
import org.air.care.service.FlightService;
import org.air.care.service.PathService;
import org.air.care.service.PossiblePathsService;
import org.air.care.service.ScheduleService;
import org.joda.time.DateTimeComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author B.Pirasanth
 *
 */

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService;

	@Autowired
	PathService pathService;

	@Autowired
	FlightService flightService;

	@Autowired
	AirportGraphService airportGraphService;

	@Autowired
	AirportService airportService;

	@Autowired
	PossiblePathsService possiblePathsService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addSchedule(
			@ModelAttribute("newSchedule") Schedule newSchedule, Model model) {

		List<Path> paths = pathService.getAll();

		Map<Long, String> pathNames = new HashMap<Long, String>();

		for (Path path : paths) {
			pathNames.put(path.getId(), path.getAirportIn().getName() + " -> "
					+ path.getAirportOut().getName());
		}

		List<Flight> flights = flightService.getAllFlight();

		Map<Long, String> flightNums = new HashMap<Long, String>();

		for (Flight flight : flights) {
			flightNums.put(flight.getId(), flight.getFlightNumber() + " - "
					+ flight.getAirline());
		}

		model.addAttribute("flightNums", flightNums);
		model.addAttribute("pathNames", pathNames);

		return "/admin/addSchedule";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView saveSchedule(
			@ModelAttribute("newSchedule") @Valid Schedule scheduleToBeAdded,
			BindingResult result, HttpServletRequest request, Locale locale) {

		ModelAndView modelAndView = new ModelAndView();

		if (result.hasErrors()) {

			List<Path> paths = pathService.getAll();

			Map<Long, String> pathNames = new HashMap<Long, String>();

			for (Path path : paths) {
				pathNames.put(path.getId(), path.getAirportIn().getName()
						+ " -> " + path.getAirportOut().getName());
			}

			List<Flight> flights = flightService.getAllFlight();

			Map<Long, String> flightNums = new HashMap<Long, String>();

			for (Flight flight : flights) {
				flightNums.put(flight.getId(), flight.getFlightNumber() + " - "
						+ flight.getAirline());
			}

			modelAndView.addObject("flightNums", flightNums);
			modelAndView.addObject("pathNames", pathNames);

			modelAndView.setViewName("/admin/addSchedule");
			return modelAndView;
		}

		scheduleToBeAdded.setFlight(flightService
				.getFlightByID(scheduleToBeAdded.getFlight().getId()));

		scheduleToBeAdded.setPath(pathService.getPathById(scheduleToBeAdded
				.getPath().getId()));

		scheduleService.addSchedule(scheduleToBeAdded);

		modelAndView.setViewName("/admin/adminHome");
		return modelAndView;
	}

	@RequestMapping(value = "/getFilteredSchedules", method = RequestMethod.POST)
	public @ResponseBody List<GridModel> getFilteredSchedules(
			@RequestParam("origin") String origin,
			@RequestParam("destination") String destination,
			@RequestParam("departureDate") Date departureDate) {

		List<PossiblePaths> possiblePathsList = possiblePathsService
				.getAllPossiblePaths(origin, destination);
		// List<Schedule> avaliableSchedules = scheduleService.getAll();
		List<GridModel> gridModels = new ArrayList<GridModel>();

		GridModel model;
		for (PossiblePaths possiblePaths : possiblePathsList) {
			model = new GridModel();
			StringBuilder sbPath = new StringBuilder();
			StringBuilder sbLatLng = new StringBuilder();
			for (String possiblePath : possiblePaths.getPath()) {
				sbPath.append(possiblePath.split(",")[0] + " > ");
				sbLatLng.append(possiblePath.split(",")[1] + ","
						+ possiblePath.split(",")[2] + "|");

			}
			if (sbPath.length() > 3)
				model.setPath(sbPath.toString().substring(0,
						sbPath.length() - 3));
			else
				model.setPath(sbPath.toString());
			
			if (sbLatLng.length() > 1)
				model.setLatLngs(sbLatLng.toString().substring(0,
						sbLatLng.length() - 1));
			else
				model.setLatLngs(sbLatLng.toString());
			gridModels.add(model);
		}

		return gridModels;
	}
}
