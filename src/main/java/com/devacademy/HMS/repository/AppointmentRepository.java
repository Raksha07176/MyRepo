package com.devacademy.HMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devacademy.HMS.model.Appointment;
import com.devacademy.HMS.model.User;
/**
 * The interface Appointment Repository
 * @author RM095789
 *
 */
@Repository("appointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	List<Appointment> findByDepartment(String department);
}