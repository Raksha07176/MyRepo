package com.devacademy.HMS.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppointmentTest {

	@Test
	public void testSetDepartment() {
		String input = "Neurology";
		String expected = "Neurology";
		Appointment app = new Appointment();
		app.setDepartment(input);
		assertEquals(expected, app.getDepartment());
	}

	@Test
	public void testSetEmail() {
		String input = "test@gmail.com";
		String expected = "test@gmail.com";

		Appointment app = new Appointment();
		app.setEmail(input);
		assertEquals(expected, app.getEmail());
	}

	@Test
	public void testSetId() {
		int input = 1;
		int expected = 1;

		Appointment app = new Appointment();
		app.setId(input);
		assertEquals(expected, app.getId());
	}

	@Test
	public void testSetName() {
		String input = "Alicia Parker";
		String expected = "Alicia Parker";

		Appointment app = new Appointment();
		app.setName(input);
		assertEquals(expected, app.getName());
	}

	@Test
	public void testSetDate() {
		String input = "03/23/2022";
		String expected = "03/23/2022";

		Appointment app = new Appointment();
		app.setDate(input);
		assertEquals(expected, app.getDate());
	}

	@Test
	public void testSetTime() {
		String input = "10:30";
		String expected = "10:30";

		Appointment app = new Appointment();
		app.setTime(input);
		assertEquals(expected, app.getTime());
	}

	@Test
	public void testSetDescription() {
		String input = "Cold";
		String expected = "Cold";

		Appointment app = new Appointment();
		app.setDescription(input);
		assertEquals(expected, app.getDescription());
	}

	@Test
	public void testSetRegTime() {
		String input = "14-03-2022  17:22:00";
		String expected = "14-03-2022  17:22:00";

		Appointment app = new Appointment();
		app.setRegtime(input);
		assertEquals(expected, app.getRegtime());
	}
}
