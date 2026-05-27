package com.example;

import java.util.*;
// PRUDUCTO 
public class Sandwich {
    private List<Ingrediente> ingredientes = new ArrayList<>();

    public void addIngrediente(Ingrediente ingrediente){
        this.ingredientes.add(ingrediente);
    }

    public double getPrecio(){
        return ingredientes.stream()
            .mapToDouble(Ingrediente::getPrecio)
            .sum();
    }

    public void mostrarDetalles(){
        System.out.println("Ingredientes");
        for (Ingrediente i:ingredientes){
            System.out.println(" - " + i.getNombre()+ " ($" + i.getPrecio()+")");
        }
        System.out.println("Precio Total: $ :"+ this.getPrecio()+ "\n");

    }
}
