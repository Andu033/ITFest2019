package com.satrabench.getfriends.controller;
import com.satrabench.getfriends.model.Event;
import com.satrabench.getfriends.model.User;
import com.satrabench.getfriends.service.EventService;
import com.satrabench.getfriends.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OneToOne;
import java.util.List;

@RestController
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/event")
    public ResponseEntity<Object> getAll(){
        return eventService.getAll();
    }

    @PostMapping("/event/create")
    public ResponseEntity<Object> create(@RequestBody Event event){
        return eventService.create(event);
    }


    //aici doar apelez
    @GetMapping("/event/user/getbyskills")
    public ResponseEntity<Object> getAllEventsBySomeSkills(@RequestParam(required=false,name="string") List<String> string){
        return eventService.getAllEventsWithSomeSkills(string);
    }

    @GetMapping("/event/user/getbyopen")
    public ResponseEntity<Object> findAllByOpenTrue(){
        return eventService.getAllByOpenTrue();
    }

    @PostMapping("/users/getid")
    public ResponseEntity<Object> getById(@RequestParam(required=false,name="id") int id){
        return eventService.getById(id);
    }

    @PostMapping("/users/putuserinevent")
    public ResponseEntity<Object> insertUserInEvent(@RequestParam(required=false,name="id") int id,@RequestParam(required=false,name="user") User user){
        return eventService.insertUserInEvent(id,user);
    }

    @PostMapping("/users/returnuserevents")
    public ResponseEntity<Object> returnListParticipatedEventsOfUser(@RequestParam(required=false,name="id") int id){
        return eventService.returnEventsListFofUser(id);
    }


    //un id de user
    //fac endpoint primeste ca pathvariable :id user si numele skilului si il adauga la user si salv in database
    //id ul unui user si
    //return evenimente disponibile,cu skillurile unui user,stergi un eveniment
}
