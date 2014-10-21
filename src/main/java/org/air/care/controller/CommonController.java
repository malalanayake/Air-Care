package org.air.care.controller;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.air.care.common.security.CustomUserDetails;
import org.air.care.common.security.SecurityConstant;
import org.air.care.model.User;
import org.air.care.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

		return "/client/home";

	}
}
