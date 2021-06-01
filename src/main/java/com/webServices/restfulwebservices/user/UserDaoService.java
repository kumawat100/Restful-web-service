package com.webServices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int counter = 1;
	static {
		users.add(new User(counter++, "Adam", new Date()));
		users.add(new User(counter++, "Eve", new Date()));
		users.add(new User(counter++, "Test", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(counter++);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for (User user: users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteUserById(int id) {
		Iterator<User> itr = users.iterator();
		while (itr.hasNext()) {
			User user = itr.next();
			if (user.getId() == id) {
				itr.remove();
				return user;
			}
		}
		return null;
	}
}
