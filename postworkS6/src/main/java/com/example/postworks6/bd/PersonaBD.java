package com.example.postworks6.bd;

import com.example.postworks6.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.HashMap;

@Repository
public class PersonaBD {

    public static final Map<String, Persona> personaMap = new HashMap<>();

    public static Persona guardaPersona(Persona persona){
        persona.setId();
        personaMap.put(persona.getId(), persona);
        return persona;
    }

    public static Map<String, Persona> getPersonas(){
        return personaMap;
    }
}
