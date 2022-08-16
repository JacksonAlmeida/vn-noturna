package com.sunflower.vnnoturna.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.sunflower.vnnoturna.entities.Role;
import com.sunflower.vnnoturna.entities.User;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String email;
	
	private String password;

	private Set<Role> roles = new HashSet<>();

	public UserDTO() {

	}

	public UserDTO(User user) {
		id = user.getId();
		name = user.getName();
		this.email = user.getEmail();
		this.roles = user.getRoles();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

}
