package com.devacademy.HMS.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devacademy.HMS.model.Admin;
import com.devacademy.HMS.model.Appointment;
import com.devacademy.HMS.service.AdminServiceImplementation;
import com.devacademy.HMS.service.AppointmentServiceImplementation;
/**
 * 
 * @author RM095789
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	private AppointmentServiceImplementation appointmentServiceImplementation;

	private AdminServiceImplementation adminServiceImplementation;

	@Autowired
	public UserController(AppointmentServiceImplementation obj1, AdminServiceImplementation obj) {
		appointmentServiceImplementation = obj1;
		adminServiceImplementation = obj;

	}
/**
 * Gets the index page as user logs in
 * @param model the model interface
 * @return the index page
 */
	@GetMapping("/index")
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

		Appointment obj = new Appointment();

		obj.setName(admin.getFirstName() + " " + admin.getLastName());

		obj.setEmail(admin.getEmail());

		System.out.println(obj);

		model.addAttribute("app", obj);

		return "user/index";
	}
/**
 * Adds new appointment and set registration time and date
 * @param obj
 * the appointment entity
 * @return adds the appointment and incase of duplicate submissions redirect to index page
 */
	@PostMapping("/save-app")
	public String saveEmploye(@ModelAttribute("app") Appointment obj) {
		Date date = Calendar.getInstance().getTime();
		java.sql.Date dateDB = new java.sql.Date(date.getTime());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String strDate = dateFormat.format(dateDB);

		obj.setRegtime(strDate);
		appointmentServiceImplementation.save(obj);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/user/index";
	}
/**
 * Gets the information about the hospital
 * @param model the model interface
 * @return the about page
 */
	@GetMapping("/about")
	public String about(Model model) {

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

		Appointment obj = new Appointment();

		obj.setName(admin.getFirstName() + " " + admin.getLastName());

		obj.setEmail(admin.getEmail());

		System.out.println(obj);

		model.addAttribute("app", obj);

		return "user/about";
	}
/**
 * Gets the blog page
 * @param model the model interface
 * @return the blog page in user login
 */
	@GetMapping("/blog-single")
	public String bs(Model model) {

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

		Appointment obj = new Appointment();

		obj.setName(admin.getFirstName() + " " + admin.getLastName());

		obj.setEmail(admin.getEmail());

		System.out.println(obj);

		model.addAttribute("app", obj);

		return "user/blog-single";
	}
/**
 * Gets the blog page
 * @param model the model interface
 * @return  the blog page in user login
 */
	@GetMapping("/blog")
	public String blog(Model model) {

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

		Appointment obj = new Appointment();

		obj.setName(admin.getFirstName() + " " + admin.getLastName());

		obj.setEmail(admin.getEmail());

		System.out.println(obj);

		model.addAttribute("app", obj);

		return "user/blog";
	}
/**
 * Gets the contact details
 * @param model the model interface
 * @return the contact details page
 */
	@GetMapping("/contact")
	public String contact(Model model) {

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

		Appointment obj = new Appointment();

		obj.setName(admin.getFirstName() + " " + admin.getLastName());

		obj.setEmail(admin.getEmail());

		System.out.println(obj);

		model.addAttribute("app", obj);

		return "user/contact";
	}
/**
 * Gets the information about the department
 * @param model the model interface
 * @return the department page
 */
	@GetMapping("/department-single")
	public String d(Model model) {

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

		Appointment obj = new Appointment();

		obj.setName(admin.getFirstName() + " " + admin.getLastName());

		obj.setEmail(admin.getEmail());

		System.out.println(obj);

		model.addAttribute("app", obj);

		return "user/department-single";
	}
/**
 * Gets the information about all the mentioned departments
 * @param model the model interface
 * @return the departments information page
 */
	@GetMapping("/departments")
	public String dep(Model model) {

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

		Appointment obj = new Appointment();

		obj.setName(admin.getFirstName() + " " + admin.getLastName());

		obj.setEmail(admin.getEmail());

		System.out.println(obj);

		model.addAttribute("app", obj);

		return "user/departments";
	}
/**
 * Gets the information about the doctors 
 * @param model the model interface
 * @return the doctor information page
 */
	@GetMapping("/doctor")
	public String doctor(Model model) {

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

		Appointment obj = new Appointment();

		obj.setName(admin.getFirstName() + " " + admin.getLastName());

		obj.setEmail(admin.getEmail());

		System.out.println(obj);

		model.addAttribute("app", obj);

		return "user/doctor";
	}
}
