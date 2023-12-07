package com.example.postworks7.controller;

import com.example.postworks7.service.PersonaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.postworks7.persistence.*;
import com.example.postworks7.helper.Alertas;
import com.example.postworks7.helper.Validations;
import com.example.postworks7.model.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/api/v1/Persona")
public class PersonaController {

    private PersonaService personaService;

    public PersonaController(PersonaService personaService){
        this.personaService = personaService;
    }

    @PostMapping("/Persona")
    public ModelAndView creaUsuarioNuevo(@Valid @ModelAttribute Persona persona, BindingResult bindingResult){
        ModelAndView mav = new ModelAndView("PersonaRegistroOK");
        mav.addObject("persona", persona);

        Alertas a = null;
        Persona p = persona;

        a = Validations.validaNombre(p.getNombre());
        if(a.isError()) {
            bindingResult.rejectValue("nombre", "persona", a.getMensaje());
        }

        a = Validations.validaTelefono(p.getTelefono());
        if(a.isError()) {
            bindingResult.rejectValue("telefono", "persona", a.getMensaje());
            //return ResponseEntity.badRequest().body(a.getMensaje());
        }
        else
            p.setTelefono(a.getResultadoString());

        if (bindingResult.hasErrors()) {
            for(ObjectError error : bindingResult.getAllErrors())
                System.out.println(error.toString());

            mav = new ModelAndView("Persona");
            mav.addObject("persona", persona);

        } else {
            PersonaPersistence.guardaPersona(p);
            System.out.println("NO errores");

            mav = new ModelAndView("PersonaRegistroOK");
            mav.addObject("persona", persona);
            List<Persona> personasLista = new ArrayList<>(PersonaPersistence.getPersonas().values());
            mav.addObject("personasLista", personasLista);
            System.out.println(personasLista);
        }

        return mav;

    } // creaUsuario

    @GetMapping({"/","/Persona"})
    public String formularioRegistro(Model model){
        model.addAttribute("persona", new Persona());
        List<Persona> personasLista = new ArrayList<>(PersonaPersistence.getPersonas().values());
        model.addAttribute("personasLista", personasLista);
        System.out.println( personasLista);
        return "Persona";
    }



    @GetMapping("/PersonaAll")
    public String getPersonas(){
        String result = "";
        Map<String, Persona> personas = PersonaPersistence.getPersonas();
        if(personas.isEmpty())
            return result;

        for(Persona persona : personas.values()){
            result += result.equals("") ?  persona.toString() : ",\n" + persona.toString();
        }
        return  result;
    }

    @GetMapping("/Persona/{id}")
    public ResponseEntity<?> getPersonas(@PathVariable("id") String id){
        Map<String, Persona> personas = PersonaPersistence.getPersonas();
        if(personas.isEmpty())
            return ResponseEntity.badRequest().body("Ninguna persona registrada al momento");

        Persona p = personas.get(id);
        if(p == null)
            return ResponseEntity.badRequest().body("Ninguna persona registrada con el ID: " + id);
        else
            return  ResponseEntity.ok(p);
    }

} // class