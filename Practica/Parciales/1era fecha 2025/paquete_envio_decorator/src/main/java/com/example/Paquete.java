package com.example;

public class Paquete implements Envio {

    private double valorDeclarado;
    private String direccion;
    private String destinatario;
    private String descripcion;

    public Paquete(double valorDeclarado, String direccion, String destinatario, String descripcion) {
        this.valorDeclarado = valorDeclarado;
        this.direccion = direccion;
        this.destinatario = destinatario;
        this.descripcion = descripcion;
    }

    @Override
    public double costoEnvio() {
        return valorDeclarado * 0.05;
    }

    @Override
    public String descripcion() {
        return descripcion;
    }

    @Override
    public double getValorDeclarado() {
        return valorDeclarado;
    }
}
