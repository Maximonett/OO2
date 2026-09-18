package com.example;

public abstract class ElementoRed {

    private String nombre;
    private MecanismoMitigacion mecanismo;

    public ElementoRed(String nombre) {
        this.nombre = nombre;

        // Mecanismo por defecto
        this.mecanismo = new ReduccionTemporalTransito();
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double valorCO2();

    public abstract int cantidadSensores();

    public abstract String obtenerEstructura();

    public void definirMecanismo(MecanismoMitigacion mecanismo) {
        this.mecanismo = mecanismo;
    }

    public void activarMitigacion() {
        mecanismo.activar();
    }
}