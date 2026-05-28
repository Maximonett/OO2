package com.example;


public class DirectorProducto {
    
    public ProductoFinanciero crearProducto1(Membresia membresia){
        if (!membresia.puedeAccederAProducto(1)) {
            throw new IllegalArgumentException("Tu membresía no puede acceder al producto 1");
        }
        return new ProductoFinancieroBuilder() 
            .agregarCompraDolar()
            .agregarPlazoFijo(membresia.getMinimoDiasPlazoFijo(), membresia.getInteresPlazoFijo())
            .agregarCompraPesos()
            .build();
    }

    public ProductoFinanciero crearProducto2(Membresia membresia){
        if (!membresia.puedeAccederAProducto(2)) {
            throw new IllegalArgumentException("Tu membresía no puede acceder al producto 2");
        }
        return new ProductoFinancieroBuilder()
            .agregarBonoBajoRiesgo(membresia.getParkingBonos())
            .agregarPlazoFijo(membresia.getMinimoDiasPlazoFijo(), membresia.getInteresPlazoFijo())
            .agregarCompraPesos()
            .build();
    }

    public ProductoFinanciero crearProducto3(Membresia membresia){
        if (!membresia.puedeAccederAProducto(3)) {
            throw new IllegalArgumentException("Tu membresía no puede acceder al producto 3");
        }
        return new ProductoFinancieroBuilder()
            .agregarBonoAltoRiesgo(membresia.getParkingBonos())
            .agregarBonoBajoRiesgo(membresia.getParkingBonos())
            .agregarPlazoFijo(membresia.getMinimoDiasPlazoFijo(), membresia.getInteresPlazoFijo())
            .build();
    }

    public ProductoFinanciero crearProducto4(Membresia membresia){
        if (!membresia.puedeAccederAProducto(4)) {
            throw new IllegalArgumentException("Tu membresía no puede acceder al producto 4");
        }
        return new ProductoFinancieroBuilder()
            .agregarBonoAltoRiesgo(membresia.getParkingBonos())
            .agregarBonoAltoRiesgo(membresia.getParkingBonos())
            .agregarBonoAltoRiesgo(membresia.getParkingBonos())
            .build();
    }
}