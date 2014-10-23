/**
 * 
 */
package org.air.care.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.air.care.common.security.CustomUserDetails;
import org.air.care.model.Passenger;
import org.air.care.service.PassengerService;
import org.air.care.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller to handle the passenger requests
 * 
 * @author B.Pirasanth
 *
 */

@Controller
@RequestMapping("/passenger")
public class PassengerController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PassengerService passengerService;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("user");
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPassenger(
			@ModelAttribute("newPassenger") Passenger newPassenger, Model model) {
		return "/client/addPassenger";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveUser(
			@ModelAttribute("newPassenger") @Valid Passenger passengerToBeAdded,
			BindingResult result, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "/client/addPassenger";
		}

		CustomUserDetails loggedInUser = (CustomUserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String name = loggedInUser.getUsername();
		
		org.air.care.model.User user = userService.getUserByUserName(name);
		
		passengerToBeAdded.setUser(user);
		
		passengerService.savePassenger(passengerToBeAdded);
		
		return "/index";
	}

}
