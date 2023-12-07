package com.example.postworks6.controller;

import com.example.postworks6.bd.PersonaBD;
import com.example.postworks6.helper.Alertas;
import com.example.postworks6.helper.Validations;
import com.example.postworks6.model.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/Persona")
public class PersonaController {

    @PostMapping
    public ResponseEntity<?> creaUsuarioNuevo(@RequestBody Persona persona){

        Alertas a = null;
        Persona p = persona;

        a = Validations.validaNombre(p.getNombre());
        if(a.isError()) {
            return ResponseEntity.badRequest().body(a.getMensaje());
        }

        a = Validations.validaTelefono(p.getTelefono());
        if(a.isError())
            return ResponseEntity.badRequest().body(a.getMensaje());

        p.setTelefono(a.getResultadoString());
        return ResponseEntity.ok(PersonaBD.guardaPersona(p));

    } // creaUsuario

    @GetMapping
    public String getPersonas(){
        String result = "";
        Map<String, Persona> personas = PersonaBD.getPersonas();
        if(personas.isEmpty())
            return result;

        for(Persona persona : personas.values()){
            result += result.equals("") ?  persona.toString() : ",\n" + persona.toString();
        }
        return  result;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonas(@PathVariable("id") String id){
        Map<String, Persona> personas = PersonaBD.getPersonas();
        if(personas.isEmpty())
            return ResponseEntity.badRequest().body("Ninguna persona registrada al momento");

        Persona p = personas.get(id);
        if(p == null)
            return ResponseEntity.badRequest().body("Ninguna persona registrada con el ID: " + id);
        else
            return  ResponseEntity.ok(p);
    }

} // class
