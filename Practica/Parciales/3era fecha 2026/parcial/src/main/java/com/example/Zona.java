package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class Zona extends ElementoRed {

    private List<ElementoRed> elementos;

    private EstadoRiesgo estado;

    public Zona(String nombre) {

        super(nombre);

        elementos = new ArrayList<>();

        estado = new Normal();
    }

    public void agregar(ElementoRed elemento) {

        elementos.add(elemento);
    }

    public void quitar(ElementoRed elemento) {

        elementos.remove(elemento);
    }

    @Override
    public double valorCO2(){
        double promedio=elementos.stream()
            .mapToDouble(e->e.valorCO2())
            .average()
            .orElse(0.0);
            return promedio;
    }
    /*public double valorCO2() {

        if (cantidadSensores() == 0) {
            return 0;
        }

        double suma = 0;

        for (ElementoRed elemento : elementos) {

            suma += elemento.valorCO2()
                    * elemento.cantidadSensores();
        }

        return suma / cantidadSensores();
    }*/


    @Override
    public int cantidadSensores(){
        int cantidad=elementos.stream()
            .mapToInt(e->e.cantidadSensores())
            .sum();
            return cantidad;
    }
    /*public int cantidadSensores() {

        int cantidad = 0;

        for (ElementoRed elemento : elementos) {

            cantidad += elemento.cantidadSensores();
        }

        return cantidad;
    }*/

    @Override
    public String obtenerEstructura() {

        return "Zona: " + getNombre();
    }

    public void actualizarRiesgo() {

        double co2 = valorCO2();

        estado.actualizar(this, co2);
    }

    public void cambiarEstado(EstadoRiesgo nuevoEstado) {
        this.estado=nuevoEstado;
    }

    public EstadoRiesgo getEstado() {

        return estado;
    }
}