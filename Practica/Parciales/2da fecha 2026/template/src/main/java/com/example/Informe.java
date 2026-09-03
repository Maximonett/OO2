package com.example;

public class Informe {
    private String titulo;
    private StringBuilder contenido;

    public Informe(String titulo) {
        this.titulo = titulo;
        this.contenido = new StringBuilder();
    }

    public void agregarLinea(String linea) {
        contenido.append(linea).append("\n");
    }

    public String getContenido() {
        return contenido.toString();
    }

    public String getTitulo() {
        return titulo;
    }
}
