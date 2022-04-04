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
@Table(name = "app")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "department")
	private String department;

	@Column(name = "date")
	private String date;

	@Column(name = "time")
	private String time;

	@Column(name = "description")
	private String description;

	@Column(name = "regtime")
	@Transient
	private String regtime;

	/**
	 * Gets registration time
	 * @return registration time
	 */
	public String getRegtime() {
		return regtime;
	}
/**
 * Sets registration time
 * @param regtime the registration time
 */
	public void setRegtime(String regtime) {
		this.regtime = regtime;
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
	 * Gets name
	 * @return name
	 */
	public String getName() {
		return name;
	}
/**
 * Sets name
 * @param name the name
 */
	public void setName(String name) {
		this.name = name;
	}
/**
 * Gets email
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
	 * Gets date
	 * @return date
	 */

	public String getDate() {
		return date;
	}
	/**
	 * Sets date
	 * @param date the date
	 */

	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * Gets time
	 * @return time
	 */

	public String getTime() {
		return time;
	}
	/**
	 * Sets time
	 * @param time the time
	 */

	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * Gets description
	 * @return description
	 */

	public String getDescription() {
		return description;
	}
/**
 * Sets description
 * @param description the description
 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department
				+ ", date=" + date + ", time=" + time + ", description=" + description + ", regtime=" + regtime + "]";
	}

}