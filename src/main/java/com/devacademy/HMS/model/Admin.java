
package com.devacademy.HMS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Transient;

/**
 * @author RM095789
 *
 */
@Entity
@Table(name = "user")

public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "username", nullable = false, unique = true)
	@Email(message = "Please provide a valid e-mail")
	@NotEmpty(message = "Please provide an e-mail")
	private String email;

	@Column(name = "password")
	@Transient
	private String password;

	@Column(name = "first_name")
	@NotEmpty(message = "Please provide your first name")
	private String firstName;

	@Column(name = "last_name")
	@NotEmpty(message = "Please provide your last name")
	private String lastName;

	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "confirmation_token")
	private String confirmationToken;

	@Column(name = "gender")
	private String gender;

	@Column(name = "authority")
	private String role;

	@Column(name = "department")
	private String department;

	@Column(name = "lastseen")
	@Transient
	private String lastseen;

	/**
	 * Gets last seen
	 * @return the last seen
	 */
	public String getLastseen() {
		return lastseen;
	}
/**
 * Sets last seen
 * @param lastseen the last seen
 */
	public void setLastseen(String lastseen) {
		this.lastseen = lastseen;
	}
/**
 * Gets role
 * @return role
 */
	public String getRole() {
		return role;
	}
/**
 * Sets role
 * @param role the role
 */
	public void setRole(String role) {
		this.role = role;
	}

	
/**
 * Gets gender
 * @return gender
 */
	
	public String getGender() {
		return gender;
	}

/**
 * Sets gender	
 * @param gender the gender
 */
	
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
/**
 * Gets confirmation  Token	
 * @return confirmation token
 */

	public String getConfirmationToken() {
		return confirmationToken;
	}
/**
 * Sets confirmation token
 * @param confirmationToken  the confirmation token
 */
	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	/**
	 * Gets id
	 * @return id
	 */
	public int getId() {
		return id;
	}
/**
 * Sets id
 * @param id the id
 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
/**
 * Sets password
 * @param password the password
 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets department
	 * @return department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * Sets department
	 * @param department the department
	 */

	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * Gets first name
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Sets the first name
	 * @param firstName the first name
	 */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Gets the last name
	 * @return last name
	 */

	public String getLastName() {
		return lastName;
	}
	/**
	 * Sets the last name
	 * @param lastName the last name
	 */

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
/**
 * Gets Email
 * @return email
 */
	public String getEmail() {
		return email;
	}
	/**
	 * Sets email
	 * @param email the email
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets Enabled
	 * @return enabled
	 */
	public boolean getEnabled() {
		return enabled;
	}
	/**
	 * Sets Enabled
	 * @param value the value
	 */

	public void setEnabled(boolean value) {
		this.enabled = value;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", enabled=" + enabled + ", confirmationToken=" + confirmationToken
				+ ", gender=" + gender + ", role=" + role + ", department=" + department + ", lastseen=" + lastseen
				+ "]";
	}

}