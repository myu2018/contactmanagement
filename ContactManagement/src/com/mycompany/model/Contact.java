package com.mycompany.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {
	
	private String firstName;
	
	private String lastName;
	
	private String emailAddress;
	
	@JsonProperty("FirstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty("LastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty("EmailAddress")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}	

}
