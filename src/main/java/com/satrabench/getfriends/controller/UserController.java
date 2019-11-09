package com.satrabench.getfriends.controller;

import com.satrabench.getfriends.model.User;
import com.satrabench.getfriends.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private final UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@GetMapping("/users")
	public ResponseEntity<Object> getAll(){
		return userService.getAll();
	}
	@PostMapping("/users/create")
	public ResponseEntity<Object> create(@RequestBody User user){
		return userService.create(user);
	}

}
