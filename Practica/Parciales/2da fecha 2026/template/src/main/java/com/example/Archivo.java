package com.example;

public class Archivo {
    private String contenido;
    private String formato;

    public Archivo(String contenido, String formato) {
        this.contenido = contenido;
        this.formato = formato;
    }

    public String getContenido() {
        return contenido;
    }

    public String getFormato() {
        return formato;
    }

}
