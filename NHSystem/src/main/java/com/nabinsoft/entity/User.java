package com.nabinsoft.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


//using jpa annotation
@Entity
public class User {
	// using jpa annotation
	// email is pk so annotating with @id
	@Id
	// for email validation
	@Email
	@NotEmpty
	@Column(unique = true)
	private String email;
	@NotEmpty
	private String name;
	@Size(min = 4)
	private String password;
	//one user will  have lot of task to perform
	@OneToMany(mappedBy ="user", cascade=CascadeType.ALL)
	private List<Task> tasks;
	//any given user can be assigned multiple roles and a role can belong to many user 
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USER_ROLES", joinColumns = {
			@JoinColumn(name="USER_EMAIL", referencedColumnName="email")
	}, inverseJoinColumns = {@JoinColumn(name="ROLE_NAME", referencedColumnName="name")})
	private List<Role> roles;

	public User() {
	}

	public User(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Task> getTask() {
		return tasks;
	}

	public void setTask(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
