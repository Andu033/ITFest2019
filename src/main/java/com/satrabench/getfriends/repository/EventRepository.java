package com.satrabench.getfriends.repository;

import com.satrabench.getfriends.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    Optional<Event> findById(Integer id);
    List<Event> findAllByLocation(String location);
    List<Event> findAllByDateWhenEventStarts(Date date);
    List<Event> findAllByDateWhenEventEnds(Date date);
    Optional<Event> findByName(String name);
    List<Event> findAll();

}
