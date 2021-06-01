package com.webServices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	@Autowired
	UserDaoService service;

	@GetMapping(path="/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User foundUser = service.findOne(id);
		if (foundUser == null) {
			throw new UserNotFoundException("ID = " + id);
		}
		return foundUser;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity createUser(@Valid @RequestBody User user) {
		User newUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentServletMapping()
		.path("/{id}")
		.buildAndExpand(newUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteUserById(id);
		if (user == null) {
			throw new UserNotFoundException("id: " + id);
		}
	}
}
