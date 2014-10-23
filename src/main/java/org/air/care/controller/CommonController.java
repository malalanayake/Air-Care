package org.air.care.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.air.care.common.Constant;
import org.air.care.common.security.CustomUserDetails;
import org.air.care.common.security.SecurityConstant;
import org.air.care.model.User;
import org.air.care.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * Controller which is providing the navigation according to the user role
 * 
 * @author malalanayake
 *
 */
@Controller
@RequestMapping("/")
public class CommonController {
	@Autowired
	UserService userService;

	/**
	 * Handle the home request and place view according to the user type
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String clientHome() {

		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			User user = userService.getUserByUserName(username);

			if (user.getRoles().contains(SecurityConstant.ROLE_ADMIN)) {
				return "/admin/adminHome";
			}

			if (user.getRoles().contains(SecurityConstant.ROLE_CLIENT)) {
				return "/client/clientHome";
			}
		}

		return "/index";

	}

	/**
	 * Return index page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "/index";
	}

	/**
	 * Change the language
	 * 
	 * @param type
	 * @param request
	 * @param response
	 * @param locale
	 */
	@RequestMapping(value = "/language/{type}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public @ResponseBody void changeLanguage(@PathVariable("type") String type,
			HttpServletRequest request, HttpServletResponse response,
			Locale locale) {
		if (type.equals(Constant.LANGUAGE_ENGLISH)) {
			RequestContextUtils.getLocaleResolver(request).setLocale(request,
					response, Locale.ENGLISH);
		}

		if (type.equals(Constant.LANGUAGE_CHINESE)) {
			RequestContextUtils.getLocaleResolver(request).setLocale(request,
					response, Locale.CHINESE);
		}
	}

	/**
	 * Get flight routs
	 * 
	 * @return
	 */
	@RequestMapping(value = "/flights-routes", method = RequestMethod.GET)
	public String getFlightRoutes() {
		return "/flightsRoutes";
	}

	/**
	 * Get Contact
	 * 
	 * @return
	 */
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "/contact";
	}

}
