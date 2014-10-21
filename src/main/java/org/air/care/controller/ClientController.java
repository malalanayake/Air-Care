package org.air.care.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.User;
import org.air.care.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Main Client Controller
 * 
 * @author malalanayake
 *
 */
@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	UserService userService;

	@Autowired
	@Qualifier("passwordValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.addValidators(validator);
		binder.setDisallowedFields("roles");
	}

	/**
	 * Handle client home request
	 * 
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String clientHome() {
		return "/client/clientHome";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(@ModelAttribute("newUser") User newUser, Model model) {
		model.addAttribute("securityQuestions",
				userService.getSecurityQuestions());
		return "/client/signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView saveUser(
			@ModelAttribute("newUser") @Valid User userToBeAdded,
			BindingResult result, HttpServletRequest request, Locale locale) {
		ModelAndView modelAndView = new ModelAndView();

		if (result.hasErrors()) {

			modelAndView.addObject("securityQuestions",
					userService.getSecurityQuestions());
			modelAndView.setViewName("/client/signup");
			return modelAndView;
		}
		
		try {
			userService.saveUser(userToBeAdded, locale);
		} catch(ExceptionResourceAlredyExist ex) {
			FieldError error = new FieldError("newUser", "username", ex.getMessage());
			result.addError(error);
			modelAndView.addObject("securityQuestions",
					userService.getSecurityQuestions());
			modelAndView.setViewName("/client/signup");
			return modelAndView;
		}

		modelAndView.setViewName("/client/clientHome");
		return modelAndView;
	}

}
