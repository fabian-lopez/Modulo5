package com.example.postworks6.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

    public static Alertas validaNombre(String nombre){
        Alertas al = new Alertas();
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]+$");
        Matcher matcher = pattern.matcher(nombre);
        al.setError(!matcher.find());
        if(al.isError())
            al.setMensaje("Nombre invalido.");
        return al;
    }

    public static Alertas validaTelefono(String telefono){
        Alertas al = new Alertas();

        String soloDigitos = Formatter.LimpiaStringANumeros(telefono);

        Pattern patternDigitos = Pattern.compile("^[\\d]{10}$");
        Matcher matcher = patternDigitos.matcher(soloDigitos);
        if(!matcher.find()){
            al.setError(true);
            al.setMensaje("El telefono ingresado no es valido. Debe ser un numero de 10 digitos.");
            return al;
        }

        al.setResultadoString(Formatter.formatTelefono(soloDigitos));

        return al;
    }


} // class
