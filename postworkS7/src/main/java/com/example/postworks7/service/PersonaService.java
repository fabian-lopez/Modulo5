package com.example.postworks7.service;

import com.example.postworks7.model.Persona;
import com.example.postworks7.persistence.PersonaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    private final Persona persona;
    private final PersonaPersistence personaPersistence;

    @Autowired
    public PersonaService(Persona persona, PersonaPersistence personaPersistence){

        this.persona = persona;
        this.personaPersistence = personaPersistence;
    }
}
