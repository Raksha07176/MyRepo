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

import com.devacademy.HMS.model.Admin;
import com.devacademy.HMS.repository.AdminRepository;
import com.devacademy.HMS.service.AdminServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceImplementationTest {

	@Autowired
	private AdminServiceImplementation adminService;

	@MockBean
	private AdminRepository adminRepo;

	@Test
	public void testFindAll() {
		Admin admin1 = new Admin();
		admin1.setId(1);
		admin1.setEmail("test@gmail.com");
		admin1.setPassword("root");
		admin1.setFirstName("Alice");
		admin1.setLastName("Parker");
		admin1.setEnabled(true);
		admin1.setGender("Female");
		admin1.setConfirmationToken("123sctyfekfijnft6fa");
		admin1.setRole("Admin");
		admin1.setLastseen("Mon Mar 14 12:00:12 2022");

		Admin admin2 = new Admin();
		admin2.setId(2);
		admin2.setEmail("test123@gmail.com");
		admin2.setPassword("root123");
		admin2.setFirstName("John");
		admin2.setLastName("Adams");
		admin2.setEnabled(true);
		admin2.setGender("Male");
		admin2.setConfirmationToken("awdfgtgfh124ryu8");
		admin2.setRole("Admin");
		admin2.setLastseen("Mon Mar 14 12:37:12 2022");

		List<Admin> admin = adminService.findAll();
		admin.add(admin1);
		admin.add(admin2);

		Mockito.when(adminRepo.findAll()).thenReturn(admin);
		Assert.assertNotNull(admin);
		Assert.assertEquals(2, admin.size());

	}

	@Test
	public void testFindByEmail() {
		Admin admin = new Admin();
		admin.setId(1);
		admin.setEmail("admintest@gmail.com");
		admin.setPassword("root");
		admin.setFirstName("Alice");
		admin.setLastName("Parker");
		admin.setEnabled(true);
		admin.setGender("Female");
		admin.setConfirmationToken("123sctyfekfijnft6fa");
		admin.setRole("Admin");
		admin.setLastseen("Fri Mar 18 15:38:152 2022");

		Mockito.when(adminRepo.findByEmail("admintest@gmail.com")).thenReturn(admin);
		Admin result = adminService.findByEmail("admintest@gmail.com");
		Assert.assertEquals("Alice", result.getFirstName());
	}

	@Test
	public void testFindByRole() {
		Admin admin1 = new Admin();
		admin1.setId(1);
		admin1.setEmail("admin1@gmail.com");
		admin1.setPassword("root");
		admin1.setFirstName("Alice");
		admin1.setLastName("Parker");
		admin1.setEnabled(true);
		admin1.setGender("Female");
		admin1.setConfirmationToken("123sctyfekfijnft6fa");
		admin1.setRole("Admin");
		admin1.setLastseen("Fri Mar 18 15:48:12 2022");

		Admin admin2 = new Admin();
		admin2.setId(2);
		admin2.setEmail("admin2@gmail.com");
		admin2.setPassword("root123");
		admin2.setFirstName("John");
		admin2.setLastName("Adams");
		admin2.setEnabled(true);
		admin2.setGender("Male");
		admin2.setConfirmationToken("awdfgtgfh124ryu8");
		admin2.setRole("Doctor");
		admin2.setLastseen("Fri Mar 18 12:37:12 2022");

		List<Admin> admin = adminService.findByRole("Doctor");
		admin.add(admin1);
		admin.add(admin2);

		Mockito.when(adminRepo.findByRole("Doctor")).thenReturn(admin);
		List<Admin> result = adminService.findByRole("Doctor");
		Assert.assertEquals(admin2, result.get(1));
	}

	@Test
	public void testSave() {
		Admin admin = new Admin();
		admin.setId(1);
		admin.setEmail("admintest@gmail.com");
		admin.setPassword("root");
		admin.setFirstName("Alice");
		admin.setLastName("Parker");
		admin.setEnabled(true);
		admin.setGender("Female");
		admin.setConfirmationToken("123sctyfekfijnft6fa");
		admin.setRole("Admin");
		admin.setLastseen("Fri Mar 18 15:38:152 2022");

		adminService.save(admin);
	}
}
