package com.example;

// =======================================
// LEAF
// =======================================

public class CompraPesos extends ProductoFinanciero{
    public CompraPesos(){
        super();
    }

    @Override
    public double retornoInversion(double monto){
        return monto*1.01;
    }
}
