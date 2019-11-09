package com.satrabench.getfriends.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String name;

    private boolean isOpen;
    @ElementCollection
    private List<String> skillsRequired = new ArrayList<>();

    private String description;

    private String location;

    private Date dateWhenEventStarts;

    private Date dateWhenEventEnds;

    private List<User> listOfUsers = new ArrayList<>();

    private int nrOfPeople;

    public boolean eventIsOpen(Date date){
        if(date.after(dateWhenEventStarts) && date.before(dateWhenEventEnds)){
            return true;
        }
        else
            return false;
    }
}
