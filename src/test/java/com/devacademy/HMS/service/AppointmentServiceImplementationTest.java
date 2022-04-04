package com.devacademy.HMS.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.devacademy.HMS.model.Appointment;
import com.devacademy.HMS.repository.AppointmentRepository;
import com.devacademy.HMS.service.AppointmentServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentServiceImplementationTest {

	@Autowired
	private AppointmentServiceImplementation appointmentService;

	@MockBean
	private AppointmentRepository appointmentRepo;

	@Test
	public void testFindAll() {
		Appointment app1 = new Appointment();
		app1.setId(1);
		app1.setName("Alicia Parker");
		app1.setEmail("test123@gmail.com");
		app1.setDate("03/15/2022");
		app1.setTime("11:30");
		app1.setDescription("Fever");
		app1.setRegtime("14-03-2022  17:20:00");

		Appointment app2 = new Appointment();
		app2.setId(2);
		app2.setName("John Adams");
		app2.setEmail("test@gmail.com");
		app2.setDate("03/23/2022");
		app2.setTime("10:30");
		app2.setDescription("Cold");
		app2.setRegtime("14-03-2022  17:22:00");

		List<Appointment> appointment = appointmentService.findAll();
		appointment.add(app1);
		appointment.add(app2);

		Mockito.when(appointmentRepo.findAll()).thenReturn(appointment);
		Assert.assertNotNull(appointment);
		Assert.assertEquals(2, appointment.size());
	}

	@Test
	public void testSave() {
		Appointment app = new Appointment();
		app.setId(1);
		app.setName("Alicia Parker");
		app.setEmail("test123@gmail.com");
		app.setDepartment("General Medicine");
		app.setDate("03/20/2022");
		app.setTime("12:30");
		app.setDescription("Fever");
		app.setRegtime("18-03-2022  17:20:00");

		appointmentService.save(app);
	}

	@Test
	public void testFindByDepartment() {
		Appointment app1 = new Appointment();
		app1.setId(1);
		app1.setName("Alicia Parker");
		app1.setEmail("test123@gmail.com");
		app1.setDate("03/26/2022");
		app1.setTime("12:30");
		app1.setDepartment("General Medicine");
		app1.setDescription("Fever");
		app1.setRegtime("18-03-2022  17:20:00");

		Appointment app2 = new Appointment();
		app2.setId(2);
		app2.setName("John Adams");
		app2.setEmail("test@gmail.com");
		app2.setDate("03/23/2022");
		app2.setTime("10:30");
		app2.setDepartment("Neurology");
		app2.setDescription("Severe headache");
		app2.setRegtime("18-03-2022  17:22:00");

		List<Appointment> app = appointmentService.findByDepartment("Neurology");
		app.add(app1);
		app.add(app2);

		Mockito.when(appointmentRepo.findByDepartment("Neurology")).thenReturn(app);
		List<Appointment> result = appointmentService.findByDepartment("Neurology");
		Assert.assertEquals(app2, result.get(1));
	}
}
