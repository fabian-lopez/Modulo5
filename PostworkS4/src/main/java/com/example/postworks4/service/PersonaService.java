package com.example.postworks4.service;

import com.example.postworks4.model.Persona;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;
import java.util.regex.*;
import com.example.postworks4.helpers.Format;

@Service
public class PersonaService {
    private final Persona persona;

    @Autowired
    public PersonaService(Persona persona){
        this.persona = persona;
    }

    @PostConstruct
    private void init(){
        Scanner reader = new Scanner(System.in);

        System.out.println("Ingresa nombre: ");
        String nombre = reader.nextLine();

        if(!validaNombre(nombre)){
            System.out.println(Format.RED + "El nombre ingresado no es valido." + Format.RESET);
            return;
        }

        System.out.println("Ingresa telefono: ");
        String telefono = reader.nextLine();

        if(!validaTelefono(telefono)){
            return;
        }

        persona.setNombre(nombre);
    }

    private boolean validaNombre(String nombre){
        boolean result = false;
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]+$");
        Matcher matcher = pattern.matcher(nombre);
        result = matcher.find();
        return result;
    }
    private boolean validaTelefono(String telefono){
        String soloDigitos = telefono.replaceAll("[^0-9]", "");

        Pattern patternDigitos = Pattern.compile("^[\\d]{10}$");
        Matcher matcher = patternDigitos.matcher(soloDigitos);
        if(!matcher.find()){
            System.out.println(Format.RED + "El telefono ingresado no es valido. Debe ser un numero de 10 digitos." + Format.RESET);
            return false;
        }

        persona.setTelefono(formatTelefono(soloDigitos));

        return true;
    }

    private String formatTelefono(String telefono){

        return String.format("(%s)-%s-%s",
                telefono.substring(0, 2),
                telefono.substring(2, 6),
                telefono.substring(6));
    }

    public String info(){
        return Format.YELLOW + "Persona {"+ Format.RESET + "nombre='" + Format.GREEN + persona.getNombre()
                + Format.RESET + "', telefono='" + Format.GREEN + persona.getTelefono() + Format.RESET
                + "'" + Format.YELLOW + "}" + Format.RESET ;
    }

}
