package com.devacademy.HMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author RM095789
 *
 */
@Controller
public class LoginController {
/**
 * Gets the login page
 * @return login page
 */
	@RequestMapping("/showMyLoginPage")
	public String showHome() {

		return "login";
	}

}
