package com.satrabench.getfriends.service;

import com.satrabench.getfriends.model.Event;
import com.satrabench.getfriends.model.User;
import com.satrabench.getfriends.repository.EventRepository;
import com.satrabench.getfriends.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EventService {


    private final EventRepository eventRepository;
    private final UserRepository userRepository;


    @Autowired
    public EventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> getAllByOpenTrue() {
        List<Event> list = new ArrayList<>();
        for (Event event : eventRepository.findAll()) {
            if (event.isOpen()) {
                list.add(event);
            }
        }
        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }

    public ResponseEntity<Object> getAllEventsWithSomeSkills(List<String> skills) {
        int contor = 0;
        List<Event> list = new ArrayList<>();
        for (Event e : eventRepository.findAll()) {
            for (String i : skills) {
                for (String j : e.getSkillsRequired()) {
                    if (j.equals(i)) {
                        contor++;
                    }
                }
                if (contor != 0 && contor == e.getSkillsRequired().size()) {
                    list.add(e);
                }
                contor = 0;
            }
        }

        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }

    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<Object>(eventRepository, HttpStatus.OK);
    }

    public ResponseEntity<Object> create(Event event) {
        return new ResponseEntity<Object>(eventRepository.save(event), HttpStatus.OK);
    }

    public ResponseEntity<Object> getAllByLocation(String location) {
        return new ResponseEntity<Object>(eventRepository.findAllByLocation(location), HttpStatus.OK);
    }

    public ResponseEntity<Object> getAllByDateWhenEventStarts(Date dateStart) {
        return new ResponseEntity<Object>(eventRepository.findAllByDateWhenEventStarts(dateStart), HttpStatus.OK);
    }

    public ResponseEntity<Object> getAllByDateWhenEventEnds(Date dateEnds) {
        return new ResponseEntity<Object>(eventRepository.findAllByDateWhenEventEnds(dateEnds), HttpStatus.OK);
    }

    public ResponseEntity<Object> getByName(String name) {
        return new ResponseEntity<Object>(eventRepository.findByName(name), HttpStatus.OK);
    }

    public ResponseEntity<Object> getById(int id) {
        return new ResponseEntity<Object>(eventRepository.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<Object> insertUserInEvent(int id,User user) {
        for (Event e : eventRepository.findAll()) {

            if (e.getId() == id) {
                user.getEventsParticipating().add(id);
                e.getListOfUsers().add(user.getId());
                eventRepository.save(e);
                userRepository.save(user);
                break;
            }
        }
        return new ResponseEntity<Object>(eventRepository.findById(id),HttpStatus.OK);
    }

    //primes idul unui user si returenez  lista de venimebnte
    public ResponseEntity<Object> returnEventsListFofUser(int idUser){
        List<Event> list = new ArrayList<>();
        for(Event e:eventRepository.findAll()){
            if(e.getListOfUsers().contains(idUser)){
                list.add(e);
            }
        }
        return new ResponseEntity<Object>(list,HttpStatus.OK);
    }
}
