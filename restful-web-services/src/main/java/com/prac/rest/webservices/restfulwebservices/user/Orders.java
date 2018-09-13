package com.prac.rest.webservices.restfulwebservices.user;



import java.util.ArrayList;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ExposesResourceFor(Order.class)
@RequestMapping("/orders")
public class Orders {

	/** The users. */
	private static ArrayList<Order> orders = new ArrayList<>();
	
	static {
		orders.add(new Order(1,"Order 1"));
		orders.add(new Order(2,"Order 2"));
	}
	
	//Retrieve all users.
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<Order> retrieveAllUsers(){
		return orders;
	}
}
