package com.example;

public class AutoEnAlquiler {
    private double precioPorDia;
    private int cantidadDePlazas;
    private String marca;

    private PoliticaDeCancelacion politica;

    public AutoEnAlquiler(double precioPorDia, int cantidadDePlazas, String marca, PoliticaDeCancelacion politica) {
        this.precioPorDia = precioPorDia;
        this.cantidadDePlazas = cantidadDePlazas;
        this.marca = marca;
        this.politica = politica;
    }

    public PoliticaDeCancelacion getPolitica() {
        return politica;
    }

    public void setPolitica(PoliticaDeCancelacion politica) {
        this.politica = politica;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }

    public int getCantidadDePlazas() {
        return cantidadDePlazas;
    }

    public String getMarca() {
        return marca;
    }

}
