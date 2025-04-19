package com.application.ecommerce.model;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "admin_seq", sequenceName = "admin_seq", allocationSize = 1)
	private Long id;
    @Column(columnDefinition = "text")
	private String adminname;
    @Column(columnDefinition = "text")
    @Email(message = "Invalid email type")
	private String email;
    @Column(columnDefinition = "text")
	private String password;
    @Column(columnDefinition = "date")
    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the adminname
	 */
	public String getAdminname() {
		return adminname;
	}
	/**
	 * @param adminname the adminname to set
	 */
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the dob
	 */
	public LocalDate getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	
		
}

