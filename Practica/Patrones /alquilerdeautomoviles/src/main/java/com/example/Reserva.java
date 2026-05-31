package com.example;

import java.time.LocalDate;

public class Reserva {
    private int cantidadDeDias;
    private LocalDate fecha;
    private AutoEnAlquiler auto;
    private Usuario conductor;

    public Reserva(int cantidadDeDias, LocalDate fecha, AutoEnAlquiler auto, Usuario conductor) {
        this.cantidadDeDias = cantidadDeDias;
        this.fecha = fecha;
        this.auto = auto;
        this.conductor = conductor;
    }

    public Usuario getConductor() {
        return conductor;
    }

    public int getCantidadDeDias() {
        return cantidadDeDias;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public AutoEnAlquiler getAuto() {
        return auto;
    }

    public double montoAPagar() {
        return this.getCantidadDeDias() * this.auto.getPrecioPorDia();
    }

    public double montoAReembolsar(LocalDate fechaTentativaDeCancelacion) {
        return this.auto.getPolitica().calcularReembolso(this, fechaTentativaDeCancelacion);
    }
}
