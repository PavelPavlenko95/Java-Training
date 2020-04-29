package com.pavelpavlenko.iba.iba_project_sql.service;

import com.pavelpavlenko.iba.iba_project_sql.model.Event;

import java.util.List;

public interface IEventService {

    public List<Event> getEvents();

    public Event getEvent(int id);

    public Event addEvent(Event event);

    public void deleteEvent(int id);

}