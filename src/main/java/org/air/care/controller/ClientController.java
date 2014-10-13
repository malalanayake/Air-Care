package org.air.care.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Main Client Controller
 * 
 * @author malalanayake
 *
 */
@Controller
@RequestMapping("/client")
public class ClientController {

	/**
	 * Handle client home request
	 * 
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String clientHome() {
		return "/client/home";
	}

}
