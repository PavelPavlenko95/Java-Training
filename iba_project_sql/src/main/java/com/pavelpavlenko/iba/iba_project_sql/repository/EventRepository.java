package com.pavelpavlenko.iba.iba_project_sql.repository;


import com.pavelpavlenko.iba.iba_project_sql.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {

}