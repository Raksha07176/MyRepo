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

import com.devacademy.HMS.model.User;
import com.devacademy.HMS.repository.UserRepository;
import com.devacademy.HMS.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository userRepo;

	@Test
	public void testFindByEmail() {
		User user = new User();
		user.setId(1);
		user.setEmail("test@gmail.com");
		user.setPassword("root");
		user.setFirstName("Alice");
		user.setLastName("Parker");
		user.setEnabled(true);
		user.setGender("Female");
		user.setConfirmationToken("123sctyfekfijnft6fa");
		user.setRole("User");
		user.setLastseen("Mon Mar 14 10:07:12 2022");

		Mockito.when(userRepo.findByEmail("test@gmail.com")).thenReturn(user);
		User result = service.findByEmail("test@gmail.com");
		Assert.assertEquals("Alice", result.getFirstName());
	}

	@Test
	public void testFindAll() {
		User user1 = new User();
		user1.setId(1);
		user1.setEmail("test@gmail.com");
		user1.setPassword("root");
		user1.setFirstName("Alice");
		user1.setLastName("Parker");
		user1.setEnabled(true);
		user1.setGender("Female");
		user1.setConfirmationToken("123sctyfekfijnft6fa");
		user1.setRole("Admin");
		user1.setLastseen("Mon Mar 14 12:00:12 2022");

		User user2 = new User();
		user2.setId(1);
		user2.setEmail("test123@gmail.com");
		user2.setPassword("root123");
		user2.setFirstName("John");
		user2.setLastName("Adams");
		user2.setEnabled(true);
		user2.setGender("Male");
		user2.setConfirmationToken("awdfgtgfh124ryu8");
		user2.setRole("Admin");
		user2.setLastseen("Mon Mar 14 12:37:12 2022");

		List<User> user = service.findAll();
		user.add(user1);
		user.add(user2);

		Mockito.when(userRepo.findAll()).thenReturn(user);
		Assert.assertNotNull(user);
		Assert.assertEquals(2, user.size());

	}

	@Test
	public void testSaveUser() {
		User user = new User();
		user.setId(1);
		user.setEmail("test@gmail.com");
		user.setPassword("root");
		user.setFirstName("Alice");
		user.setLastName("Parker");
		user.setEnabled(true);
		user.setGender("Female");
		user.setConfirmationToken("123sctyfekfijnft6fa");
		user.setRole("Admin");
		user.setLastseen("Fri Mar 18 15:38:152 2022");

		service.saveUser(user);
	}
}
