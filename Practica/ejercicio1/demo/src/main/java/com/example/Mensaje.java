package com.example;

public class Mensaje {
    private String contenido;

    public Mensaje(String contenido){
        this.contenido=contenido;
    }

    public String getContenido(){
        return this.contenido;
    }

    public void setContenido(String contenido){
        if ((contenido.length()>=1) && (contenido.length()<=280)) {
            this.contenido=contenido;
        }else {
            System.out.println("Error: El mensaje debe tener entre 1 y 280 caracteres.");
        }
    }

}