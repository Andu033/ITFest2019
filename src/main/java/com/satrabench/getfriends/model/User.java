package com.satrabench.getfriends.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

	@ElementCollection
	private List<Integer> eventsParticipating;

	private String password;

	private boolean isAdmin;

	public void addEventToUser(int id){
		eventsParticipating.add(id);
	}
}
