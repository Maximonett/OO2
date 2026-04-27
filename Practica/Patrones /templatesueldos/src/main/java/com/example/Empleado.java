package com.example;

public abstract class Empleado {
    protected double horasTrabajadas;
    protected boolean estadoCivil;
    protected int cantidadHijos;

    public Empleado(double horasTrabajadas,boolean estadoCivil, int cantidadHijos) {
        this.horasTrabajadas = horasTrabajadas;
        this.estadoCivil= estadoCivil;
        this.cantidadHijos = cantidadHijos;
    }


    public abstract double calcularSueldo();

    public abstract double Basico(); 
    public abstract double Adicionales();
    public abstract double Descuentos();

}
