package com.example;

public abstract class PlanMedico {
    protected double montoFijo;

    // TEMPLATE METHOD: Define el esqueleto del algoritmo
    public double calcularMonto(int familiaresACargo, double salario, Coseguro coseguro) {
        double total = 0;

        total += calcularMontoFijo();
        total += calcularCargoFamiliar(familiaresACargo, salario);
        total += calcularCoberturaViajera(salario);
        total += calcularSeguroInternacion();

        // Aplicar descuento de coseguro si existe
        if (coseguro != null) {
            total = aplicarDescuentoCoseguro(total, familiaresACargo, salario, coseguro);
        }

        return total;
    }

    // Pasos abstractos que cada plan implementa
    protected abstract double calcularMontoFijo();

    protected abstract double calcularCargoFamiliar(int familiaresACargo, double salario);

    protected abstract double calcularCoberturaViajera(double salario);

    protected abstract double calcularSeguroInternacion();

    protected abstract double aplicarDescuentoCoseguro(double total, int familiaresACargo, double salario,
            Coseguro coseguro);
}
