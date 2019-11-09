package com.satrabench.getfriends.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	private String password;

	@ElementCollection
	private List<String> skills = new ArrayList<>();

	private boolean isAdmin;
}
