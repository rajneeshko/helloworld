package com.prac.rest.webservices.restfulwebservices.user;



import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService ;
	
	@Autowired EntityLinks entityLinks;

	
	//Retrieve all users.
	@RequestMapping(value = "/users",method = RequestMethod.GET)
	public List<User> retrieveAllUsers(){
		return userDaoService.findAll();
	}
	
	//Retrieve specific user. 
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	public HttpEntity<User> retrieveUser(@PathVariable int userId) throws NoSuchMethodException, SecurityException {
		User user = userDaoService.findOne(userId);
		Method method = UserResource.class.getMethod("retrieveAllUsers");
		Link allUsers = ControllerLinkBuilder.linkTo(this.getClass(),method,"").withRel("AllUsers");
		user.add(allUsers);
		
		Method method1 = UserResource.class.getMethod("retrieveUser",int.class);
		user.add(ControllerLinkBuilder.linkTo(UserResource.class,method1,user.getUserId()).withSelfRel());
		
		user.add(entityLinks.linkToCollectionResource(Order.class));
		
		return new HttpEntity<User>(user);

	}

	//Retrieve specific user. 
	@DeleteMapping(path="/users/{userId}")
	public void deleteUser(@PathVariable int userId){
		if(userDaoService.deleteUser(userId)==null) {
				throw new UserNotFoundException("id - " + userId);
		}
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getUserId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
