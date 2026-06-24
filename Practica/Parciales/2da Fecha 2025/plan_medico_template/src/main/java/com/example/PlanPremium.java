package com.example;

public class PlanPremium extends PlanMedico {

    public PlanPremium() {
        this.montoFijo = 33000;
    }

    @Override
    protected double calcularMontoFijo() {
        return montoFijo; // $33.000
    }

    @Override
    protected double calcularCargoFamiliar(int familiaresACargo, double salario) {
        // Hasta 4 integrantes sin cargo, luego $2.800 por cada adicional
        if (familiaresACargo <= 4) {
            return 0;
        }
        return (familiaresACargo - 4) * 2800;
    }

    @Override
    protected double calcularCoberturaViajera(double salario) {
        return salario * 0.01; // 1% del salario
    }

    @Override
    protected double calcularSeguroInternacion() {
        return montoFijo * 0.05; // 5% del monto fijo
    }

    @Override
    protected double aplicarDescuentoCoseguro(double total, int familiaresACargo, double salario, Coseguro coseguro) {
        // Descuenta $10.000 por año de antigüedad en el coseguro
        double descuento = coseguro.getAntiguedad() * 10000;
        return total - descuento;
    }
}
