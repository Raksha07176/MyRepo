package com.devacademy.HMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devacademy.HMS.model.Admin;
import com.devacademy.HMS.repository.AdminRepository;
/**
 * 
 * @author RM095789
 *
 */

@Service
public class AdminServiceImplementation implements AdminService {

	private AdminRepository adminRepository;

	@Autowired // Adding bean id @Qualifier
	public AdminServiceImplementation(AdminRepository obj) {
		adminRepository = obj;
	}

	@Override
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}

	@Override
	public void save(Admin admin) {

		adminRepository.save(admin);
	}

	@Override
	public Admin findByEmail(String user) {

		return adminRepository.findByEmail(user);

	}

	@Override
	public List<Admin> findByRole(String user) {

		return adminRepository.findByRole(user);
	}

}
