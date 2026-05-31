package com.example;

import java.time.LocalDate;
import java.time.Period;

public class PoliticaModerada implements PoliticaDeCancelacion {

    @Override
    public double calcularReembolso(Reserva reserva, LocalDate fechasDeCancelacion) {

        Period periodo = Period.between(reserva.getFecha(), fechasDeCancelacion);
        int dias = periodo.getDays();

        double montoTotal = reserva.montoAPagar();

        if (dias >= 7) {
            return montoTotal;
        } else if (dias >= 2) {
            return montoTotal * 0.5;
        } else {
            return 0.0;
        }
    }
}
