package com.example;

public class Sensor extends ElementoRed {

    private double valorCO2;

    public Sensor(String nombre, double valorCO2) {

        super(nombre);

        this.valorCO2 = valorCO2;
    }

    @Override
    public double valorCO2() {

        return valorCO2;
    }

    @Override
    public int cantidadSensores() {

        return 1;
    }

    @Override
    public String obtenerEstructura() {

        return "Sensor: " + getNombre();
    }

    public void setValorCO2(double valorCO2) {

        this.valorCO2 = valorCO2;
    }
}