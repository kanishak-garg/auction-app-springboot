package com.iiht.training.auction.dto;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerDto {

    private Long id;
    
	@NotNull
	@Size(min = 3,max = 100, message = "user name should have at least 3 characters and atmost 100 characters")
	private String username;
    
    @NotNull
	@Size(min = 3,max = 100, message = "password should have at least 3 characters and atmost 100 characters")
	private String password;
    
    @NotNull
    @Email
	@Size(min = 3,max = 100, message = "email should have at least 3 characters and atmost 100 characters")
	private String email;
    
    @NotNull
    // @Size(min = 10,max = 10, message = "Mobile number should be 10 digits")
    @Min(10)
    @Max(10)
	private Long phoneNumber;
    
    @NotNull
	@Size(min = 3,max = 100, message = "user name should have at least 3 characters and atmost 100 characters")
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, email, id, password, phoneNumber, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDto other = (CustomerDto) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(username, other.username);
	}

	
}