package com.example.postworks4.model;

import com.example.postworks4.helpers.Format;
import org.springframework.stereotype.Component;

@Component
public class Persona {

    private String nombre;
    private String telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Persona(){ }

    public Persona(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }

    @Override
    public String toString(){
        return Format.YELLOW + "Persona {"+ Format.RESET + "nombre='" + Format.GREEN + nombre
                + Format.RESET + "', telefono='" + Format.GREEN + telefono + Format.RESET
                + Format.YELLOW + "'}" + Format.RESET ;
    }
}
