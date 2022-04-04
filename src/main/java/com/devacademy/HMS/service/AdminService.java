package com.devacademy.HMS.service;

import java.util.List;

import com.devacademy.HMS.model.Admin;
import com.devacademy.HMS.model.User;
/**
 * 
 * @author RM095789
 *
 */
public interface AdminService {
/**
 * Finds the user by role
 * @param user the role to find
 * @return the list of users by role
 */
	public List<Admin> findByRole(String user);
/**
 * Finds user by email
 * @param user the user email or username
 * @return the user by email
 */
	public Admin findByEmail(String user);
/**
 * Finds all the data in a method
 * @return all the present data in a model
 */
	public List<Admin> findAll();
/**
 * Saves the admin
 * @param admin the admin 
 */
	public void save(Admin admin);

}
