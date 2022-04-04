package com.devacademy.HMS.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class AdminTest {

	@Test
	public void testSetLastSeen() {
		String input = "Mon Mar 14 12:00:12 2022";
		String expected = "Mon Mar 14 12:00:12 2022";

		Admin admin = new Admin();
		admin.setLastseen(input);
		assertEquals(expected, admin.getLastseen());
	}

	@Test
	public void testSetRole() {
		String input = "ROLE_ADMIN";
		String expected = "ROLE_ADMIN";

		Admin admin = new Admin();
		admin.setRole(input);
		assertEquals(expected, admin.getRole());
	}

	@Test
	public void testSetGender() {
		String input = "Female";
		String expected = "Female";

		Admin admin = new Admin();
		admin.setGender(input);
		assertEquals(expected, admin.getGender());
	}

	@Test
	public void testSetConfirmationToken() {
		String input = "123sctyfekfijnft6fa";
		String expected = "123sctyfekfijnft6fa";

		Admin admin = new Admin();
		admin.setConfirmationToken(input);
		assertEquals(expected, admin.getConfirmationToken());
	}

	@Test
	public void testSetId() {
		int input = 1;
		int expected = 1;

		Admin admin = new Admin();
		admin.setId(input);
		assertEquals(expected, admin.getId());
	}

	@Test
	public void testSetPassword() {
		String input = "root";
		String expected = "root";

		Admin admin = new Admin();
		admin.setPassword(input);
		assertEquals(expected, admin.getPassword());
	}

	@Test
	public void testSetDepartment() {
		String input = "Neurology";
		String expected = "Neurology";

		Admin admin = new Admin();
		admin.setDepartment(input);
		assertEquals(expected, admin.getDepartment());
	}

	@Test
	public void testSetFirstName() {
		String input = "Alicia";
		String expected = "Alicia";

		Admin admin = new Admin();
		admin.setFirstName(input);
		assertEquals(expected, admin.getFirstName());
	}

	@Test
	public void testSetLastName() {
		String input = "Parker";
		String expected = "Parker";

		Admin admin = new Admin();
		admin.setLastName(input);
		assertEquals(expected, admin.getLastName());
	}

	@Test
	public void testSetEmail() {
		String input = "test@gmail.com";
		String expected = "test@gmail.com";

		Admin admin = new Admin();
		admin.setEmail(input);
		assertEquals(expected, admin.getEmail());
	}

	@Test
	public void testSetEnabled() {
		boolean input = true;
		boolean expected = true;

		Admin admin = new Admin();
		admin.setEnabled(input);
		assertEquals(expected, admin.getEnabled());
	}
}
