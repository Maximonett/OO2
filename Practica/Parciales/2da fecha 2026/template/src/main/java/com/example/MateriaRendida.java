package com.example;

import java.time.LocalDate;

public class MateriaRendida {
    private String nombreMateria;
    private LocalDate fecha;
    private double nota;

    public MateriaRendida(String nombreMateria, LocalDate fecha, double nota) {
        this.nombreMateria = nombreMateria;
        this.fecha = fecha;
        this.nota = nota;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getNota() {
        return nota;
    }
}
