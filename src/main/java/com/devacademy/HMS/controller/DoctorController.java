package com.devacademy.HMS.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devacademy.HMS.model.Admin;
import com.devacademy.HMS.model.Appointment;
import com.devacademy.HMS.service.AdminServiceImplementation;
import com.devacademy.HMS.service.AppointmentServiceImplementation;
import com.devacademy.HMS.service.UserService;
/**
 * 
 * @author RM095789
 *
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController {

	private static Logger logger = LoggerFactory.getLogger(DoctorController.class);
	
	private UserService userService;

	private AdminServiceImplementation adminServiceImplementation;

	private AppointmentServiceImplementation appointmentServiceImplementation;

	@Autowired
	public DoctorController(UserService userService, AdminServiceImplementation obj,
			AppointmentServiceImplementation app) {
		this.userService = userService;
		adminServiceImplementation = obj;
		appointmentServiceImplementation = app;
	}
/**
 * Gets the details of all the appointments after a doctor logs in
 * @param model the model interface
 * @return the list of appointments for a doctor by department tag.
 */
	@RequestMapping("/index")
	public String index(Model model) {

		// get last seen
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			String Pass = ((UserDetails) principal).getPassword();
			logger.info("One + " + username, " " +Pass);

		} else {
			username = principal.toString();
			logger.info("Two + ", username);
		}

		Admin admin = adminServiceImplementation.findByEmail(username);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date now = new Date();

		String log = now.toString();

		admin.setLastseen(log);

		adminServiceImplementation.save(admin);

		List<Appointment> list = appointmentServiceImplementation.findByDepartment(admin.getDepartment());

		model.addAttribute("name", admin.getFirstName());

		model.addAttribute("email", admin.getEmail());

		model.addAttribute("department", admin.getDepartment());

		model.addAttribute("user", admin.getFirstName() + " " + admin.getLastName());

		// add to the spring model
		model.addAttribute("app", list);

		return "doctor/index";
	}

}
