package com.example;

import java.util.HashSet;
import java.util.Set;

public class Pelicula {
    
    private String titulo;
    private int anioEstreno;
    private double puntaje;

    private Set<Pelicula> similares;


    public Pelicula (String titulo,double puntaje, int anioEstreno){
        this.titulo=titulo;
        this.puntaje=puntaje;
        this.anioEstreno=anioEstreno;
        this.similares=new HashSet<>();
    }

    public void agregarSimilar(Pelicula pelicula){
        this.similares.add(pelicula);
        pelicula.similares.add(this);
    }

    public int getAnioEstreno(){return anioEstreno;}
    public double getPuntaje(){return puntaje;}
    public String getTitulo(){return titulo;}
    public Set<Pelicula> getSimilares(){return similares;}
}
