package com.example.postworks6.model;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Persona {

    private String id;
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

    public String getId() {
        return id;
    }

    public void setId() {
        UUID uniqueId = UUID.randomUUID();
        this.id = uniqueId.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        if (!id.equals(persona.id)) return false;
        if (!nombre.equals(persona.nombre)) return false;
        return telefono.equals(persona.telefono);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + id.hashCode() ;
        result = 31 * result + nombre.hashCode();
        result = 31 * result + telefono.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + id + '\"' +
                ", \"nombre\": \"" + nombre + '\"' +
                ", \"telefono\": \"" + telefono + '\"' +
                '}';
    }
}
