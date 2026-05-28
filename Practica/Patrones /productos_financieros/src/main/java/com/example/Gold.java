package com.example;

public class Gold implements Membresia {
    @Override 
    public double getInteresPlazoFijo(){return 0.06;}
    @Override
    public int getMinimoDiasPlazoFijo(){return 30;}
    @Override 
    public int getParkingBonos(){return 24;}

    @Override
    public boolean puedeAccederAProducto(int numeroProducto) {
        return true;  // Gold tiene acceso a todos
    }
}
