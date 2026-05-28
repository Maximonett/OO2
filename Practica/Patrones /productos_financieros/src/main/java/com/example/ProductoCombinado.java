package com.example;

// =======================================
// COMPOSITE
// Contiene otros productos financieros
// =======================================

import java.util.ArrayList;
import java.util.List;

public class ProductoCombinado extends ProductoFinanciero {
    private List<ProductoFinanciero> productos = new ArrayList<>();

    public void agregarProducto(ProductoFinanciero producto){
        productos.add(producto);
    }

    @Override
    public double retornoInversion(double monto){
        double capital= monto;

        for (ProductoFinanciero p: productos){
            capital=p.retornoInversion(capital);
        }
        return capital;
    }

}
