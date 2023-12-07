package com.example.postworks8.controller;

import com.example.postworks8.persistence.PersonaRepository;
//import com.example.postworks8.service.PersonaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.postworks8.helper.Alertas;
import com.example.postworks8.helper.Validations;
import com.example.postworks8.model.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
//@RequestMapping("/api/v1/Persona")
public class PersonaController {

    //private final PersonaService personaService;
    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaController(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    @PostMapping("/Persona")
    public ModelAndView creaUsuarioNuevo(@Valid @ModelAttribute Persona persona, BindingResult bindingResult){
        ModelAndView mav = new ModelAndView("Persona");
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
            mav.addObject("persona", p);

        } else {
            p.setId();
            Persona personaDB = personaRepository.save(p);
            System.out.println("NO errores");
            mav = new ModelAndView("Persona");
            mav.addObject("persona", personaDB);

            List<Persona> personasLista = personaRepository.findAll();
            mav.addObject("personasLista", personasLista);
        }

        return mav;

    } // creaUsuario

    @GetMapping({"/","/Persona"})
    public String formularioRegistro(Model model){
        model.addAttribute("persona", new Persona());

        List<Persona> personasLista = personaRepository.findAll();
        model.addAttribute("personasLista", personasLista);
        System.out.println( personasLista);
        return "Persona";
    }




    @GetMapping("/Persona/{id}")
    public ResponseEntity<?> getPersonas(@PathVariable("id") String id){

        Optional<Persona> personaDB = personaRepository.findById(id);

        if(personaDB == null)
            return ResponseEntity.badRequest().body("Ninguna persona registrada al momento");

        if(personaDB == null)
            return ResponseEntity.badRequest().body("Ninguna persona registrada con el ID: " + id);
        else
            return  ResponseEntity.ok(personaDB);
    }

} // class