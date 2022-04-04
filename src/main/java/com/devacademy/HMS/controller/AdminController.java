package com.devacademy.HMS.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devacademy.HMS.model.Admin;
import com.devacademy.HMS.model.Appointment;
import com.devacademy.HMS.service.AdminServiceImplementation;
import com.devacademy.HMS.service.AppointmentServiceImplementation;
import com.devacademy.HMS.service.UserService;
/**
 * The type AdminController 
 * @author RM095789
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static Logger logger = LoggerFactory.getLogger(AdminController.class);

	private UserService userService;

	private AdminServiceImplementation adminServiceImplementation;

	private AppointmentServiceImplementation appointmentServiceImplementation;

	@Autowired
	public AdminController(UserService userService, AdminServiceImplementation obj,
			AppointmentServiceImplementation app) {
		this.userService = userService;
		adminServiceImplementation = obj;
		appointmentServiceImplementation = app;
	}
/**
 * Gets the list of all registered users by ROLE_USER and sets last seen 
 * @param model the model interface
 * @return the list of all the registered users and their details
 */
	@RequestMapping("/user-details")
	public String index(Model model) {

		List<Admin> list = adminServiceImplementation.findByRole("ROLE_USER");
		model.addAttribute("user", list);

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

		return "admin/user";
	}
/**
 * Gets the list of all the doctors by ROLE_DOCTOR and sets last seen
 * @param model the model interface
 * @return list of all the doctors and their details
 */
	@RequestMapping("/doctor-details")
	public String doctorDetails(Model model) {

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

		List<Admin> list = adminServiceImplementation.findByRole("ROLE_DOCTOR");

		// add to the spring model
		model.addAttribute("user", list);

		return "admin/doctor";
	}
/**
 * Gets the list of the admin by ROLE_ADMIN and sets last seen
 * @param model the model interface
 * @return the list of admin with their details
 */
	@RequestMapping("/admin-details")
	public String adminDetails(Model model) {

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

		List<Admin> list = adminServiceImplementation.findByRole("ROLE_ADMIN");

		// add to the spring model
		model.addAttribute("user", list);

		return "admin/admin";
	}
/**
 * Gets the form for adding new doctor and gets last seen
 * @param theModel the model interface
 * @return the form for adding new doctor
 */
	@GetMapping("/add-doctor")
	public String showFormForAdd(Model theModel) {
		
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
		
		Admin admin1 = adminServiceImplementation.findByEmail(username);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date now = new Date();

		String log = now.toString();

		admin1.setLastseen(log);

		adminServiceImplementation.save(admin1);
		
		// create model attribute to bind form data
		Admin admin = new Admin();
		
		theModel.addAttribute("doctor", admin);

		return "admin/addDoctor";
	}
/**
 * Adds a new doctor
 * @param admin 
 * gets the admin entity 
 * @param bindingResult
 * sets the view
 * @return if a doctor record already exists with same email then it will reject the email otherwise
 * adds the new doctor and redirect to doctor-details page
 */
	@PostMapping("/save-doctor")
	public String saveEmployee(@ModelAttribute("doctor") @ Valid Admin admin, BindingResult bindingResult) {
		
		Admin adminExists = adminServiceImplementation.findByEmail(admin.getEmail());
		
		System.out.println(adminExists);
        
		//logger.info("Error message at line 198.");
		
		if (adminExists!=null) {
			
			//logger.info("Error message at line 202.");
			bindingResult.reject("email");
			return "admin/addDoctor";
		}
		admin.setRole("ROLE_DOCTOR");

		admin.setPassword("default");

		admin.setEnabled(true);

		admin.setConfirmationToken("ByAdmin-Panel");

		System.out.println(admin);

		adminServiceImplementation.save(admin);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/doctor-details";
		
	}
/**
 * Gets the form for adding new admin and gets last seen		
 * @param theModel the model interface
 * @return the form for adding new admin
 */
	@GetMapping("/add-admin")
	public String showForm(Model theModel) {
			
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
		
		Admin admin1 = adminServiceImplementation.findByEmail(username);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date now = new Date();

		String log = now.toString();

		admin1.setLastseen(log);

		adminServiceImplementation.save(admin1);

		// create model attribute to bind form data
		Admin admin = new Admin();

		theModel.addAttribute("doctor", admin);

		return "admin/addAdmin";
	}
/**
 * Adds new admin
 * @param admin
 * gets the admin entity
 * @param bindingResult
 * sets the view 
 * @return if a admin record already exists with same email then it will reject the email otherwise
 * adds the new admin and redirect to admin-details page
 */
	@PostMapping("/save-admin")
	public String saveEmploye(@ModelAttribute("doctor") @Valid Admin admin, BindingResult bindingResult) {
		
			Admin adminExists = adminServiceImplementation.findByEmail(admin.getEmail());
			System.out.println(adminExists);
			
			if(adminExists !=null) {
				bindingResult.reject("email");
				return "admin/addAdmin";
			}

		admin.setRole("ROLE_ADMIN");

		admin.setPassword("default");

		admin.setEnabled(true);

		admin.setConfirmationToken("ByAdmin-Panel");

		System.out.println(admin);

		adminServiceImplementation.save(admin);

		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/admin-details";
	}
/**
 * Gets the admin profile
 * @param theModel
 * @return the admin details
 */
	@GetMapping("/edit-my-profile")
	public String EditForm(Model theModel) {

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

		// get the employee from the service
		Admin admin = adminServiceImplementation.findByEmail(username);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date now = new Date();

		String log = now.toString();

		admin.setLastseen(log);

		adminServiceImplementation.save(admin);

		System.out.println(admin);

		theModel.addAttribute("profile", admin);

		return "admin/updateMyProfile";
	}
/**
 * Add the details of the new added admin
 * @param admin
 * gets the admin details
 * @return the details of logged in admin
 */
	@PostMapping("/update")
	public String update(@ModelAttribute("profile") Admin admin) {

		System.out.println(admin);

		adminServiceImplementation.save(admin);

		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/user-details";
	}
/**
 * Gets the list of all the booked appointments
 * @param model the model interface
 * @return the list of all appointments
 */
	@RequestMapping("/appointments")
	public String appointments(Model model) {

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

		List<Appointment> list = appointmentServiceImplementation.findAll();

		// add to the spring model
		model.addAttribute("app", list);

		return "admin/appointment";
	}
}
