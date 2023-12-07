package com.example.postworks7.persistence;

import com.example.postworks7.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonaPersistence {
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
