package com.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Coseguro {
    private String nombre;
    private int descuento; // porcentaje
    private LocalDate fechaIngreso;
    private double montoCoberturaViajes;

    public Coseguro(String nombre, int descuento, LocalDate fechaIngreso, double montoCoberturaViajes) {
        this.nombre = nombre;
        this.descuento = descuento;
        this.fechaIngreso = fechaIngreso;
        this.montoCoberturaViajes = montoCoberturaViajes;
    }

    public double getDescuento() {
        return descuento;
    }

    public int getAntiguedad() {
        return (int) ChronoUnit.YEARS.between(fechaIngreso, LocalDate.now());
    }

    public double getMontoCoberturaViajes() {
        return montoCoberturaViajes;
    }
}
