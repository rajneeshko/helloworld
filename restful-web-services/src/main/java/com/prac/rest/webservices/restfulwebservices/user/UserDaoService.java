package com.prac.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDaoService.
 */
@Component
public class UserDaoService {

	/** The users. */
	private static ArrayList<User> users = new ArrayList<>();
	
	/** The user count. */
	private static int userCount = 3;
	
	static {
		users.add(new User(1,"Adam 1", new Date()));
		users.add(new User(2,"Adam 2", new Date()));
		users.add(new User(3,"Adam 3", new Date()));
		users.add(new User(4,"Adam 4", new Date()));
	}
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<User> findAll(){
		return users;
	}
	
	/**
	 * Save.
	 *
	 * @param user the user
	 * @return the user
	 */
	public User save(User user) {
		if(user.getUserId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	/**
	 * Find one.
	 *
	 * @param userId the user id
	 * @return the user
	 */
	public User findOne(int userId) {
		User userToReturn = null ;
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = iterator.next();
			if(user.getUserId()==userId) {
				userToReturn = user;
			}
		}
		
		if(userToReturn==null) {
			throw new UserNotFoundException("id - " + userId);
		}
		return userToReturn;
	}

	public User deleteUser(int userId) {
		User userToBeDeleted = null;
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = iterator.next();
			if(user.getUserId()==userId) {
				userToBeDeleted = user;
				users.remove(user);
			}
		}
		return userToBeDeleted;
	}


}
