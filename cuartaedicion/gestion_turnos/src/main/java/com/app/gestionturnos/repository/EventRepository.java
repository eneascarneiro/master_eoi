package com.app.gestionturnos.repository;


import com.app.gestionturnos.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
    List<Event> findEventByFechahoraBetween(LocalDateTime from, LocalDateTime to);
}
