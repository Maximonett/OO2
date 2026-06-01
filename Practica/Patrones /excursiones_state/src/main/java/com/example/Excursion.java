package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Excursion {
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String puntoEncuentro;
    private double costo;
    private int cupoMinimo;
    private int cupoMaximo;
    private List<Usuario> inscriptos;
    private List<Usuario> listaEspera;
    private EstadoExcursion estado;

    public Excursion(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String puntoEncuentro,
            double costo, int cupoMinimo, int cupoMaximo) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.puntoEncuentro = puntoEncuentro;
        this.costo = costo;
        this.cupoMinimo = cupoMinimo;
        this.cupoMaximo = cupoMaximo;
        this.inscriptos = new ArrayList<>();
        this.listaEspera = new ArrayList<>();
        this.estado = new EstadoProvisorio();
    }

    // Metodos delegados al estado
    public void inscribir(Usuario usuario) {
        estado.inscribir(this, usuario);
    }

    public String obtenerInformacion() {
        return estado.obtenerInformacion(this);
    }

    // Metodos auxiliares que el estado necesita para moficar el contexto
    protected void cambiarEstado(EstadoExcursion nuevoEstado) {
        this.estado = nuevoEstado;
    }

    protected void agregarInscripto(Usuario usuario) {
        this.inscriptos.add(usuario);
    }

    protected void agregarAListaEspera(Usuario usuario) {
        this.listaEspera.add(usuario);
    }

    public int getCantidadInscriptos() {
        return this.inscriptos.size();
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public String getPuntoEncuentro() {
        return puntoEncuentro;
    }

    public double getCosto() {
        return costo;
    }

    public int getCupoMinimo() {
        return cupoMinimo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public List<Usuario> getInscriptos() {
        return new ArrayList<>(inscriptos);// Se retorna una copia para mantener el encapsulamiento
    }

    public List<Usuario> getListaEspera() {
        return new ArrayList<>(listaEspera);
    }

}
