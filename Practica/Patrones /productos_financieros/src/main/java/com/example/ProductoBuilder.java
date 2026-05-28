package com.example;

// =======================================
// BUILDER
// Define pasos de construcción
// =======================================

public interface ProductoBuilder {
    ProductoBuilder agregarCompraDolar();

    ProductoBuilder agregarCompraPesos();
    
    ProductoBuilder agregarPlazoFijo(int dias, double interes);

    ProductoBuilder agregarBonoBajoRiesgo(int parking);

    ProductoBuilder agregarBonoAltoRiesgo(int parking);

    ProductoFinanciero build();
}
