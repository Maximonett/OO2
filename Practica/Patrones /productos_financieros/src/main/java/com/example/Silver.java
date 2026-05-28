package com.example;

public class Silver implements Membresia {
    @Override 
    public double getInteresPlazoFijo(){
        return 0.05;
    }

    @Override 
    public int getMinimoDiasPlazoFijo(){
        return 35;
    }

    @Override 
    public int getParkingBonos(){
        return 72;
    }

    @Override
    public boolean puedeAccederAProducto(int numeroProducto) {
        return numeroProducto == 1 || numeroProducto == 2;
    }
}
