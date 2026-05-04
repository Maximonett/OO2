package com.example;

public class Pasante {
    int examenesRendidos;

    public Pasante(int examenesRendidos) {
        this.examenesRendidos = examenesRendidos;
    }   

    public double calcularSueldo() {
        return this.Basico() + this.Adicionales() - this.Descuentos();
    }

    public double Basico() {
        return 20000;
    }    


    public double Adicionales() {
        double adicionales = this.examenesRendidos * 2000;
        return adicionales;
    }


    public double Descuentos() {
        double descuentos = 0;
        descuentos += this.Basico() * 0.13;
        descuentos += this.Adicionales() * 0.05;
        return descuentos;
    }

}
