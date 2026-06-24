package com.example;

public class PlanIntegral extends PlanMedico {

    public PlanIntegral() {
        this.montoFijo = 22000;
    }

    @Override
    protected double calcularMontoFijo() {
        return montoFijo; // $22.000
    }

    @Override
    protected double calcularCargoFamiliar(int familiaresACargo, double salario) {
        return (familiaresACargo * 3000) + (salario * 0.01); // $3.000 por integrante + 1% del salario
    }

    @Override
    protected double calcularCoberturaViajera(double salario) {
        return salario * 0.03; // 3% del salario
    }

    @Override
    protected double calcularSeguroInternacion() {
        return montoFijo * 0.05; // 5% del monto fijo
    }

    @Override
    protected double aplicarDescuentoCoseguro(double total, int familiaresACargo, double salario, Coseguro coseguro) {
        // Aplica el descuento del coseguro por cada integrante
        double cargoFamiliar = calcularCargoFamiliar(familiaresACargo, salario);
        double descuento = cargoFamiliar * (coseguro.getDescuento() / 100.0);
        return total - descuento;
    }
}
