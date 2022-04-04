package com.devacademy.HMS.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserTest {
	
	@Test
	public void testSetLastSeen() {
		String input = "Mon Mar 14 12:00:12 2022";
		String expected = "Mon Mar 14 12:00:12 2022";
		
		User user = new User();
		user.setLastseen(input);
		assertEquals(expected, user.getLastseen());
	}
	
	@Test
	public void testSetRole() {
		String input = "ROLE_User";
		String expected = "ROLE_User";
		
		User user = new User();
		user.setRole(input);
		assertEquals(expected, user.getRole());
	}
	
	@Test
	public void testSetGender() {
		String input = "Female";
		String expected = "Female";
		
		User user = new User();
		user.setGender(input);
		assertEquals(expected, user.getGender());
	}
	
	@Test
	public void testSetConfirmationToken() {
		String input = "123sctyfekfijnft6fa";
		String expected = "123sctyfekfijnft6fa";
		
		User user = new User();
		user.setConfirmationToken(input);
		assertEquals(expected, user.getConfirmationToken());
	}
	
	@Test
	public void testSetId() {
		int input = 1;
		int expected = 1;
		
		User user = new User();
		user.setId(input);
		assertEquals(expected, user.getId());
	}
	
	@Test
	public void testSetPassword() {
		String input = "root";
		String expected = "root";
		
		User user = new User();
		user.setPassword(input);
		assertEquals(expected, user.getPassword());
	}
	
	@Test
	public void testSetDepartment() {
		String input = "Neurology";
		String expected = "Neurology";
		
		User user = new User();
		user.setDepartment(input);
		assertEquals(expected, user.getDepartment());
	}
	
	@Test
	public void testSetFirstName() {
		String input = "Alicia";
		String expected = "Alicia";
		
		User user = new User();
		user.setFirstName(input);
		assertEquals(expected, user.getFirstName());
	}
	
	@Test
	public void testSetLastName() {
		String input = "Parker";
		String expected = "Parker";
		
		User user = new User();
		user.setLastName(input);
		assertEquals(expected, user.getLastName());
	}
	@Test
	public void testSetEmail() {
		String input = "test@gmail.com";
		String expected = "test@gmail.com";
		
		User user = new User();
		user.setEmail(input);
		assertEquals(expected, user.getEmail());
	}
	
	@Test
	public void testSetEnabled() {
		boolean input = true;
		boolean expected = true;
		
		User user = new User();
		user.setEnabled(input);
		assertEquals(expected, user.getEnabled());
	}
	
}
