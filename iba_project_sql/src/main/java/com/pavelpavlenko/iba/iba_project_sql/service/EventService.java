package com.pavelpavlenko.iba.iba_project_sql.service;

import java.util.List;

import com.pavelpavlenko.iba.iba_project_sql.model.Event;
import com.pavelpavlenko.iba.iba_project_sql.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService implements IEventService {

    @Autowired
    EventRepository everep;

    @Override
    public List<Event> getEvents() {
        return everep.findAll();
    }

    @Override
    public Event getEvent(int id) {
        return everep.findById(id).get();
    }

    @Override
    public Event addEvent(Event event) {
        return everep.save(event);
    }

    @Override
    public void deleteEvent(int id) {
        everep.deleteById(id);
    }


}
