package com.example;

// =======================================
// LEAF
// =======================================

public class PlazoFijo extends ProductoFinanciero {
    private int dias;
    private double interesDiario;
    
    public PlazoFijo(int dias,double interesDioario){
        super();
        this.dias=dias;
        this.interesDiario=interesDiario;
    }

    @Override
    public double retornoInversion(double monto){
        return monto*(1 + this.interesDiario*this.dias);
    }
}
