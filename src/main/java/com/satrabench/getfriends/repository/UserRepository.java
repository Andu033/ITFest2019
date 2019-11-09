package com.satrabench.getfriends.repository;

import com.satrabench.getfriends.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	User findByEmail(String email);
	User findOneByEmailAndPassword(String email, String password);
	User findOneByEmail(String email);

}
