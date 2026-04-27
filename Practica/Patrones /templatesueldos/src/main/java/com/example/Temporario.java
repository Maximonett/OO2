package com.example;

public class Temporario extends Empleado {
    
    public Temporario(double horasTrabajadas,boolean estadoCivil, int cantidadHijos) {
        super(horasTrabajadas, estadoCivil, cantidadHijos);
    }   

    public void setHorasTrabajadas(double horas) {
        this.horasTrabajadas = horas;
    }

    @Override
    public double calcularSueldo() {
        return this.Basico() + this.Adicionales() - this.Descuentos();
    }

    @Override
    public double Basico() {
        return 20000 + (this.horasTrabajadas * 300);
    }    

    @Override
    public double Adicionales() {
        double adicionales = 0;
        if (this.estadoCivil) {
            adicionales += 5000;
        }
        return adicionales + (this.cantidadHijos * 2000);
    }

    @Override
    public double Descuentos() {
        double descuentos = 0;
        descuentos += this.Basico() * 0.13;
        descuentos += this.Adicionales() * 0.05;
        return descuentos;
    }

}
