package com.devacademy.HMS.controller;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devacademy.HMS.model.User;
import com.devacademy.HMS.service.UserService;
import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
/**
 * 
 * @author RM095789
 *
 */
@Controller
public class RegisterController {

	private UserService userService;

	@Autowired
	public RegisterController(UserService userService) {
		this.userService = userService;
	}
/**
 * Returns the registration form template
 * @param modelAndView
 * model and view for register
 * @param user
 * Adds the user 
 * @return
 */
	// Return registration form template
	@RequestMapping(value = "/register", method = RequestMethod.GET)

	public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user) {
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register");
		return modelAndView;
	}
/**
 * Adds a user
 * @param modelAndView
 * model and view for register
 * @param user
 * the user details
 * @param bindingResult
 * changes the view in case of error
 * @param request
 * @return if a user email already exists then it shows the error that the user already exists otherwise
 * gets the user registered.
 */
	// Process form input data
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user,
			BindingResult bindingResult, HttpServletRequest request) {

		// Lookup user in database by e-mail
		User userExists = userService.findByEmail(user.getEmail());

		System.out.println(userExists);

		if (userExists != null) {
			modelAndView.addObject("alreadyRegisteredMessage",
					"Oops!  There is already a user registered with the email provided.");
			modelAndView.setViewName("register");
			bindingResult.reject("email");
		}

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("register");
		} else {
			user.setEnabled(true);
			user.setRole("ROLE_USER");

			userService.saveUser(user);

			modelAndView.addObject("confirmationMessage", user.getEmail() + " is successfully registered");
			modelAndView.setViewName("register");
		}

		return modelAndView;
	}
}