package com.satrabench.getfriends.service;

import com.satrabench.getfriends.model.User;
import com.satrabench.getfriends.repository.EventRepository;
import com.satrabench.getfriends.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
	private final UserRepository userRepository;
    public ResponseEntity<Object> logInByEmail;

    @Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public ResponseEntity<Object> getAll(){
		return new ResponseEntity<Object>(userRepository.findByEmail(""), HttpStatus.OK);
}

	public ResponseEntity<Object> create(User user){
		return new ResponseEntity<Object>(userRepository.save(user), HttpStatus.OK);
	}

	public ResponseEntity<Object> authentication(String email, String password) {
		return new ResponseEntity<Object>(userRepository.findOneByEmailAndPassword(email, password), HttpStatus.OK);
	}

	public ResponseEntity<Object> externAuthentication(String email) {
		return new ResponseEntity<Object>(userRepository.findOneByEmail(email), HttpStatus.OK);
	}

	public ResponseEntity<Object> SearchOneByName(String name) {
		return new ResponseEntity<Object>(userRepository.findOneByName(name), HttpStatus.OK);
	}

	public ResponseEntity<Object> SearchAllbyIsAdmin() {
		List<User> list =new ArrayList<>();
    	for(User user:userRepository.findAll()){
    		if(user.isAdmin()){
				list.add(user);
			}
		}
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
}
