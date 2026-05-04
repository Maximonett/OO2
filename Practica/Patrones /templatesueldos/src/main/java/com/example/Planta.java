package com.example;

public class Planta extends Empleado {
    int antiguedad;

    public Planta(double horasTrabajadas,boolean estadoCivil, int cantidadHijos, int antiguedad) {
        super(0, estadoCivil, cantidadHijos);
        this.antiguedad = antiguedad;
    }   


    @Override
    public double calcularSueldo() {
        return this.Basico() + this.Adicionales() - this.Descuentos();
    }

    @Override
    public double Basico() {
        return 50000;
    }    

    @Override
    public double Adicionales() {
        double adicionales = 0;
        if (this.estadoCivil) {
            adicionales += 5000;
        }
        
        return adicionales + (this.cantidadHijos * 2000)+(this.antiguedad * 2000);
    }

    @Override
    public double Descuentos() {
        double descuentos = 0;
        descuentos += this.Basico() * 0.13;
        descuentos += this.Adicionales() * 0.05;
        return descuentos;
    }

}
