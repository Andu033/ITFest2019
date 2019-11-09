package com.satrabench.getfriends.service;

import com.satrabench.getfriends.model.User;
import com.satrabench.getfriends.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {



	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public ResponseEntity<Object> getAll(){
		return new ResponseEntity<Object>(userRepository.findAllByEmail(""), HttpStatus.OK);
	}

	public ResponseEntity<Object> create(User user){
		return new ResponseEntity<Object>(userRepository.save(user), HttpStatus.OK);
	}


}
