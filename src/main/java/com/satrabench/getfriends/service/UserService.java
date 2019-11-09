package com.satrabench.getfriends.service;

import com.satrabench.getfriends.model.User;
import com.satrabench.getfriends.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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


}
