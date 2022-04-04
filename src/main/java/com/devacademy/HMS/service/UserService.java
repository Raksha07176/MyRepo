package com.devacademy.HMS.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devacademy.HMS.model.User;
import com.devacademy.HMS.repository.UserRepository;

@Service("userService")
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
/**
 * Finds user by email
 * @param email the user email
 * @return the user by email
 */
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	/*public User findByConfirmationToken(String confirmationToken) {
		return userRepository.findByConfirmationToken(confirmationToken);
	}*/
/**
 * Saves the user
 * @param user the user
 */
	public void saveUser(User user) {
		userRepository.save(user);
	}
/**
 * Finds all the users
 * @return the list of all the users
 */
	public List<User> findAll() {

		return userRepository.findAll();
	}

}