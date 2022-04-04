package com.devacademy.HMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devacademy.HMS.model.Admin;
import com.devacademy.HMS.model.User;
/**
 * The interface Admin Repository 
 * @author RM095789
 *
 */
@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findByEmail(String user);

	List<Admin> findByRole(String user);

}