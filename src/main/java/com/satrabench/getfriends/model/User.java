package com.satrabench.getfriends.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> origin/master

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	//@Column(unique=true)
	private String email;

	private String name;

<<<<<<< HEAD
	private String password;;
=======
	private String password;

	private boolean isAdmin;

>>>>>>> origin/master
}
