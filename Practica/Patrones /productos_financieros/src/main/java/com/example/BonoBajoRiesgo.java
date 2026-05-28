package com.example;
import java.util.Random;

// =======================================
// LEAF
// =======================================

public class BonoBajoRiesgo extends ProductoFinanciero {
    private int parking;

    public BonoBajoRiesgo(int parking){
        super();
        this.parking=parking;
    }

    @Override
    public double retornoInversion(double monto){

        Random r= new Random();
        double variacion=r.nextDouble(-0.1,0.1);

        return monto*(1+ variacion);
    }
}
