package com.example;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private List<Componente> componentes;

    public Equipo(){
        this.componentes=new ArrayList<>();
    
    }

    public void agregar(Componente componente){
        componentes.add(componente);
    }

    public double getConsumo(){
        return componentes.stream()
            .mapToDouble(Componente::getConsumo)
            .sum();
    }

    public double getPrecio(){
        return componentes.stream()
            .mapToDouble(Componente::getPrecio)
            .sum()*1.21;
    }

}
