package com.example;
// =======================================
// STRATEGY / CONFIGURACIÓN
// =======================================
public interface Membresia {
    double getInteresPlazoFijo();
    int getMinimoDiasPlazoFijo();
    int getParkingBonos();

    boolean puedeAccederAProducto(int numeroProducto);
}
