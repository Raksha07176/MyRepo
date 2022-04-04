package com.devacademy.HMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devacademy.HMS.model.Appointment;
import com.devacademy.HMS.repository.AppointmentRepository;
import com.devacademy.HMS.model.Admin;
/**
 * 
 * @author RM095789
 *
 */
@Service
public class AppointmentServiceImplementation {

	private AppointmentRepository appointmentRepository;

	@Autowired // Adding bean id @Qualifier
	public AppointmentServiceImplementation(AppointmentRepository obj) {
		appointmentRepository = obj;
	}
/**
 * Saves the appointment
 * @param app the appointment
 */
	public void save(Appointment app) {

		appointmentRepository.save(app);
	}
/**
 * Finds all the appointments
 * @return the list of all the appointments
 */
	public List<Appointment> findAll() {
		return appointmentRepository.findAll();
	}
/**
 * find appointment by department
 * @param department the doctor department
 * @return the appointment by department
 */
	public List<Appointment> findByDepartment(String department) {
		return appointmentRepository.findByDepartment(department);
	}

}
