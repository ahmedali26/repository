package com.asmatech.book.bean;

import com.asmatech.book.validate.IPAdderss;

import jakarta.validation.constraints.Email;

public class AutherBean {
	
	private Long id;
	
	private String name;
	
	@IPAdderss()
	private String ipAddress;
	
	@Email(message = "{validation.email.Pattern.message}")
	private String email;

	private String imagePath;

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

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "AutherBean [id=" + id + ", name=" + name + ", ipAddress=" + ipAddress + ", email=" + email
				+ ", imagePath=" + imagePath + "]";
	}

}
