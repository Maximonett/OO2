package com.example;

import java.time.LocalDate;

public class PoliticaEstricta implements PoliticaDeCancelacion {

    @Override
    public double calcularReembolso(Reserva reserva, LocalDate fechaCancelacion) {

        return 0.0;

    }

}
