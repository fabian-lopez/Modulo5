package com.example.postworks8.helper;


public class Alertas {
    private String mensaje;
    private boolean error;
    private String resultadoString;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Alertas() {
        mensaje = "";
        error = false;
        resultadoString = "";
    }

    public String getResultadoString() {
        return resultadoString;
    }

    public void setResultadoString(String resultadoString) {
        this.resultadoString = resultadoString;
    }
}