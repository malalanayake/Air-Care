/**
 * 
 */
package org.air.care.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.air.care.model.Path;
import org.air.care.model.Schedule;
import org.air.care.service.PathService;
import org.air.care.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addSchedule(
			@ModelAttribute("newSchedule") Schedule newSchedule, Model model) {

		List<Path> paths = pathService.getAll();
		
		Map<Long, String> pathNames = new HashMap<Long, String>();

		for (Path path : paths) {
			pathNames.put(path.getId(), path.getAirportIn().getName() + " -> "
					+ path.getAirportOut().getName());
		}

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
				pathNames.put(path.getId(), path.getAirportIn().getName() + " -> "
						+ path.getAirportOut().getName());
			}
			modelAndView.addObject("pathNames", pathNames);

			modelAndView.setViewName("/admin/addSchedule");
			return modelAndView;
		}
		
		
		scheduleService.addSchedule(scheduleToBeAdded);

		modelAndView.setViewName("/admin/adminHome");
		return modelAndView;
	}
}
