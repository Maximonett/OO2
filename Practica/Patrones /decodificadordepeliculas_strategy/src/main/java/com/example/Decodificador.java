package com.example;

import java.util.ArrayList;
import java.util.List;

public class Decodificador {
    
    private List<Pelicula> grilla;
    private List<Pelicula> reproducidas;
    private CriterioSugerencia criterio;

    public Decodificador(){
        this.grilla=new ArrayList<>();
        this.reproducidas=new ArrayList<>();
    }

    public List<Pelicula> sugerir(){
        return criterio.sugerir(this);
    }

    public void setCriterio(CriterioSugerencia criterio){
        this.criterio=criterio;
    }


    public void agregarPelicula(Pelicula pelicula){
        grilla.add(pelicula);
    }

    public void reproducir(Pelicula pelicula){
        reproducidas.add(pelicula);
    }
    public List<Pelicula> getGrilla(){
        return grilla;
    }
    public List<Pelicula> getReproducidas(){
        return reproducidas;
    }
}
