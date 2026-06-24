package com.example;

public class PlanObligatorio extends PlanMedico {

    public PlanObligatorio() {
        this.montoFijo = 15000;
    }

    @Override
    protected double calcularMontoFijo() {
        return montoFijo; // $15.000
    }

    @Override
    protected double calcularCargoFamiliar(int familiaresACargo, double salario) {
        return familiaresACargo * 3500; // $3.500 por integrante
    }

    @Override
    protected double calcularCoberturaViajera(double salario) {
        return salario * 0.01; // 1% del salario
    }

    @Override
    protected double calcularSeguroInternacion() {
        return 0; // No tiene
    }

    @Override
    protected double aplicarDescuentoCoseguro(double total, int familiaresACargo, double salario, Coseguro coseguro) {
        // Aplica el descuento del coseguro al total
        double descuento = total * (coseguro.getDescuento() / 100.0);
        return total - descuento;
    }
}
