package com.example;

public abstract class Arma {
    protected String nombre;

    public abstract int calcularDano(Armadura armadura);

    public String getNombre() {
        return nombre;
    }

}
