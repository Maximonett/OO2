package com.example;

public class Ingrediente {
    private String nombre;
    private double precio;

    public Ingrediente (String nombre, double precio){
        this.nombre=nombre;
        this.precio=precio;
    }

    public String getNombre(){
        return this.nombre;
    }
    public double getPrecio(){ return this.precio;}



}
