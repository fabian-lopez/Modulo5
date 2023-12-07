package com.example.postworks8.helper;
public class Formatter {
    public static String LimpiaStringANumeros(String valor){
        return valor.replaceAll("[^0-9]", "");
    }

    public static String formatTelefono(String telefono){

        return String.format("(%s)-%s-%s",
                telefono.substring(0, 2),
                telefono.substring(2, 6),
                telefono.substring(6));
    }

}
