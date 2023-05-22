package com.app.gestionturnos.service;

import com.app.gestionturnos.model.Event;
import com.app.gestionturnos.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService extends AbstractBusinessServiceSoloEnt<Event,Long, EventRepository> {


    protected EventService(EventRepository eventRepository) {
        super(eventRepository);
    }
}
