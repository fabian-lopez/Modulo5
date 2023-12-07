package com.example.postworks6.service;

import com.example.postworks6.bd.PersonaBD;
import com.example.postworks6.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    private final Persona persona;
    private final PersonaBD personaBD;

    @Autowired
    public PersonaService(Persona persona, PersonaBD personaBD){

        this.persona = persona;
        this.personaBD = personaBD;
    }

} // class
