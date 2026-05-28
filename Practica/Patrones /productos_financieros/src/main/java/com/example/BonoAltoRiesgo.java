package com.example;

import java.util.Random;

public class BonoAltoRiesgo extends ProductoFinanciero {
    private int parking;

    public BonoAltoRiesgo(int parking){
        super();
        this.parking=parking;
    }

    @Override
    public double retornoInversion(double monto){
        Random r = new Random();

        double variacion=r.nextDouble(-0.7,0.7);

        return monto *(1 + variacion);
    }
}
