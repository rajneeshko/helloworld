package com.prac.rest.webservices.restfulwebservices.user;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class UserResourceAssembler extends ResourceAssemblerSupport<User, User>{

	public UserResourceAssembler(Class<?> controllerClass, Class<User> resourceType) {
		super(controllerClass, resourceType);
	}

	@Override
	public User toResource(User arg0) {
		User resource = instantiateResource(arg0);
		return resource;
	}

}
