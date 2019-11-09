package com.satrabench.getfriends.controller;

import com.satrabench.getfriends.model.User;
import com.satrabench.getfriends.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

	@GetMapping("/users/authentication")
	public ResponseEntity<Object> authentication(@RequestParam(required=false,name="email") String email, @RequestParam(required=false,name="password") String password) {
		return userService.authentication(email, password);
	}

	@GetMapping("/users/externAuthentication")
	public ResponseEntity<Object> externAuthentication(@RequestParam(required=false,name="email") String email) {
		return userService.externAuthentication(email);
	}

	@GetMapping("/users/seachbyname")
	public ResponseEntity<Object> GetOneByName(String name) {
		return userService.SearchOneByName(name);
	}

	@GetMapping("/users/getalladmins")
	public ResponseEntity<Object> GetAllByIsAdmin() {
		return userService.SearchAllbyIsAdmin();
	}

}
