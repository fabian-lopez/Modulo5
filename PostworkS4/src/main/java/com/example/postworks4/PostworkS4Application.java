package com.example.postworks4;


import com.example.postworks4.helpers.Format;
import com.example.postworks4.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.example.postworks4.model.Persona;
//import java.util.Scanner;

@SpringBootApplication
public class PostworkS4Application implements CommandLineRunner {

    private final PersonaService personaService;

    @Autowired
    public PostworkS4Application(PersonaService personaService){
        this.personaService = personaService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PostworkS4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Scanner reader = new Scanner(System.in);
//        Persona p = null;
//
//        System.out.println("Ingresa nombre: ");
//        String nombre = reader.nextLine();
//
//        System.out.println("Ingresa telefono: ");
//        String telefono = reader.nextLine();
//
//        p = new Persona(nombre, telefono);
//        System.out.println(p);
        System.out.println(personaService.info());
    }
}
