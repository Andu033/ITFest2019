package com.satrabench.getfriends.repository;

import com.satrabench.getfriends.model.User;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	User findByEmail(String email);
	User findOneByEmailAndPassword(String email, String password);
	User findOneByEmail(String email);

	User findById(ID id);
	User findOneByName(String name);
}
