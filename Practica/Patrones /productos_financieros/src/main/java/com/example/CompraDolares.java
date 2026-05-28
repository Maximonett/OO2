package com.example;

// =======================================
// LEAF
// =======================================

public class CompraDolares extends ProductoFinanciero {
    public CompraDolares(){
        super();
    }
    
    @Override
    public double retornoInversion(double monto){
        return monto*1.02;
    }




}
