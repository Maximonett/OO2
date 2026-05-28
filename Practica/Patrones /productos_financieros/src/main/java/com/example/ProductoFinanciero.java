package com.example;

import java.time.LocalDate;

// =======================================
// PATRÓN COMPOSITE
// =======================================

// ---------------------------------------
// COMPONENT
// Representa la interfaz común
// ---------------------------------------


public abstract class ProductoFinanciero  {
    private LocalDate fechaOperacion;


    public abstract double retornoInversion(double monto);


}
