package com.example.postworks8.model;

import jakarta.persistence.*;

import java.util.UUID;

import jakarta.validation.constraints.*;

@Entity
@Table(name = "PERSONA")
public class Persona {
    @Id
    private String id;
    @NotBlank(message = "Favor de ingresar nombre")
    private String nombre;
    @NotBlank(message = "Favor de ingresar telefono")
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
