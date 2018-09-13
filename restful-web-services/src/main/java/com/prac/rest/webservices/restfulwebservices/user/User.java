package com.prac.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class User extends ResourceSupport{
	

	private Integer userId;
	
	@Size(min=2)
	private String name;
	
	@Past
	private Date birthDate;

	protected User() {
		
	}
	
	@JsonCreator
	public User(@JsonProperty Integer id,@JsonProperty String name,@JsonProperty Date birthDate) {
		super();
		this.userId = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setId(Integer id) {
		this.userId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
}
