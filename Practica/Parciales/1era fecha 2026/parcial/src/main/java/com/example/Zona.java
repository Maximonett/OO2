package com.example;

import java.util.ArrayList;
import java.util.List;

public class Zona extends ElementoRed {

    private List<ElementoRed> elementos;

    public Zona(String nombre) {
        super(nombre);
        elementos = new ArrayList<>();
    }

    public void agregar(ElementoRed elemento) {
        elementos.add(elemento);
    }

    public void quitar(ElementoRed elemento) {
        elementos.remove(elemento);
    }

    @Override
    public double valorCO2() {

        if (elementos.isEmpty()) {
            return 0;
        }

        double suma = 0;

        for (ElementoRed elemento : elementos) {
            suma += elemento.valorCO2();
        }

        return suma / elementos.size();
    }

    @Override
    public int cantidadSensores() {

        int cantidad = 0;

        for (ElementoRed elemento : elementos) {
            cantidad += elemento.cantidadSensores();
        }

        return cantidad;
    }

    @Override
    public String obtenerEstructura() {

        String estructura = "Zona: " + getNombre() + "\n";

        for (ElementoRed elemento : elementos) {
            estructura += "  " + elemento.obtenerEstructura() + "\n";
        }

        return estructura;
    }
}